package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.Projeto;
import br.udesc.ceavi.costestimator.modelo.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diego
 */
@ManagedBean(name = "beanProjeto")
@SessionScoped
public class ProjetoBean {

    private final String telaCadastro = "/sistema/projeto/cadastro";
    private final String telaConsulta = "/sistema/projeto/consulta";
    private final String telaApontamentos = "/sistema/projeto/apontamentos";
    private final String telaUCP = "/sistema/projeto/ucp";

    private Projeto projeto;
    private List<Projeto> projetos;

    public ProjetoBean() {
        this.projeto = new Projeto();
        atualizaProjetos();
    }
    
    public String apontar(Projeto pr){
        return telaApontamentos;
    }
    
    public String calcular(Projeto pr) {
        return telaUCP;
    }

    private void atualizaProjetos() {
        HttpSession session
                = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        LoginBean beanLogin = (LoginBean) session.getAttribute("beanLogin");
        this.projetos = Projeto.listar(beanLogin.getUsuario().getId());
    }

    public void excluir(Projeto p) {
        try {
            Projeto.remover(p.getId());
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_INFO, "Removido", ""
                    )
            );
            atualizaProjetos();
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "Erro: ", ex.getMessage()
                    )
            );
        }
    }

    public String alterar(Projeto pr) {
        this.projeto = pr;
        return telaCadastro;
    }

    public String novo() {
        this.projeto = new Projeto();
        return telaCadastro;
    }

    public String salvar() {
        try {
            HttpSession session
                    = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
            LoginBean beanLogin = (LoginBean) session.getAttribute("beanLogin");
            projeto.setUsuario(beanLogin.getUsuario());
            projeto.salvar();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Projeto salvo com sucesso", ""));

            this.projeto = new Projeto();
            this.projetos = Projeto.listar();
            return telaConsulta;

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro ao salvar projeto", ""));
            return telaCadastro;
        }

    }

    public String cancelar() {
        this.projeto = new Projeto();
        return telaConsulta;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

}
