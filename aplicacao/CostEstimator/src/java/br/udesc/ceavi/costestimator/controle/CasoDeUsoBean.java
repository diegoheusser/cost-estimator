package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.CasoDeUso;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
    private Nivel nivel;

    public String alterar(CasoDeUso uc) {
        this.casoDeUso = uc;
        return telaCadastroCasoDeUso;
    }

    public String salvar() {
        try {
            casoDeUso.salvar();
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

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

}
