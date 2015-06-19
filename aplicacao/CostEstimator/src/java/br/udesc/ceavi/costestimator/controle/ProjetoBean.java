package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.Projeto;
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

    private Projeto projeto;
    private List<Projeto> projetos;

    public ProjetoBean() {
        HttpSession session
                = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        LoginBean beanLogin = (LoginBean) session.getAttribute("beanLogin");
        this.projeto = new Projeto();
        this.projetos = Projeto.listar(beanLogin.getUsuario().getId());
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
        return "/sistema/projeto/consuta";
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
