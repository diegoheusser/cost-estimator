package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.Ator;
import br.udesc.ceavi.costestimator.modelo.CasoDeUso;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diego
 */
@ManagedBean(name = "beanCasoDeUso")
@SessionScoped
public class CasoDeUsoBean {

    private final String telaCadastroCasoDeUso = "/sistema/projeto/casodeuso/cadastro";
    private final String telaCadastroProjeto = "/sistema/projeto/cadastro";
    private CasoDeUso casoDeUso;

    public String alterar(CasoDeUso uc) {
        this.casoDeUso = uc;
        return telaCadastroCasoDeUso;
    }

        public void excluir(CasoDeUso c) {
        try {
            if (c.getProjeto().getId() != 0) {
                CasoDeUso.remover(c.getId());
            } else {
                HttpSession session
                        = (HttpSession) FacesContext.getCurrentInstance()
                        .getExternalContext().getSession(false);
                ProjetoBean beanProjeto = (ProjetoBean) session.getAttribute("beanProjeto");
                beanProjeto.getProjeto().getCasoDeUsos().remove(c);
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
            casoDeUso.setProjeto(beanProjeto.getProjeto());
            beanProjeto.getProjeto().getCasoDeUsos().add(casoDeUso);
        } catch (Exception ex) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Erro",
                                    ex.getMessage()
                            ));
            return telaCadastroCasoDeUso;
        }
        return telaCadastroProjeto;
    }

    public String cancelar() {
        casoDeUso = new CasoDeUso();
        return telaCadastroProjeto;
    }

    public String novo() {
        casoDeUso = new CasoDeUso();
        return telaCadastroCasoDeUso;
    }

    public CasoDeUso getCasoDeUso() {
        return casoDeUso;
    }

    public void setCasoDeUso(CasoDeUso casoDeUso) {
        this.casoDeUso = casoDeUso;
    }


}
