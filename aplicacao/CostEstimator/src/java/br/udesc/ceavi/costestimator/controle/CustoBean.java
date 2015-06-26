package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.Custo;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diego
 */
@ManagedBean(name = "beanCusto")
@SessionScoped
public class CustoBean {

    private final String telaCadastroCusto = "/sistema/projeto/custo/cadastro";
    private final String telaCadastroProjeto = "/sistema/projeto/cadastro";
    private Custo custo;

    public String alterar(Custo ct) {
        this.custo = ct;
        return telaCadastroCusto;
    }
    
        public void excluir(Custo c) {
        try {
            if (c.getProjeto().getId() != 0) {
                Custo.remover(c.getId());
            } else {
                HttpSession session
                        = (HttpSession) FacesContext.getCurrentInstance()
                        .getExternalContext().getSession(false);
                ProjetoBean beanProjeto = (ProjetoBean) session.getAttribute("beanProjeto");
                beanProjeto.getProjeto().getCustos().remove(c);
            }
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_INFO, "Removido", ""
                    )
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "Erro: ", ex.getMessage()
                    )
            );
        }
    }

    public String salvar() {
        try {
            HttpSession session
                    = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
            ProjetoBean beanProjeto = (ProjetoBean) session.getAttribute("beanProjeto");
            custo.setProjeto(beanProjeto.getProjeto());
            beanProjeto.getProjeto().getCustos().add(custo);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Erro",
                                    ex.getMessage()
                            ));
            return telaCadastroCusto;
        }
        return telaCadastroProjeto;
    }

    public String cancelar() {
        custo = new Custo();
        return telaCadastroProjeto;
    }

    public String novo() {
        custo = new Custo();
        return telaCadastroCusto;
    }

    public Custo getCusto() {
        return custo;
    }

    public void setCusto(Custo custo) {
        this.custo = custo;
    }

}
