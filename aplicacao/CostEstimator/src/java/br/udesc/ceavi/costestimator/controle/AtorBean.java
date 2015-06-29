package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.Ator;
import br.udesc.ceavi.costestimator.modelo.Projeto;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diego
 */
@ManagedBean(name = "beanAtor")
@SessionScoped
public class AtorBean {

    private final String telaCadastroAtor = "/sistema/projeto/ator/cadastro";
    private final String telaCadastroProjeto = "/sistema/projeto/cadastro";
    private Ator ator;

    public String alterar(Ator at) {
        this.ator = at;
        return telaCadastroAtor;
    }

    public String salvar() {
        try {
            HttpSession session
                    = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
            ProjetoBean beanProjeto = (ProjetoBean) session.getAttribute("beanProjeto");
            ator.setProjeto(beanProjeto.getProjeto());
            beanProjeto.getProjeto().getAtores().add(ator);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Erro",
                                    ex.getMessage()
                            ));
            return telaCadastroAtor;
        }
        return telaCadastroProjeto;
    }

    public String cancelar() {
        ator = new Ator();
        return telaCadastroProjeto;
    }

    public String novo() {
        ator = new Ator();
        return telaCadastroAtor;
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }



}
