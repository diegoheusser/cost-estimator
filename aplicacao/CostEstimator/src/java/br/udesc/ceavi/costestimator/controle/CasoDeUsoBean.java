package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.Ator;
import br.udesc.ceavi.costestimator.modelo.CasoDeUso;
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
    
    private CasoDeUso casoDeUso;
    private Nivel nivel;

    public String salvar() {
        HttpSession session
                = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        ProjetoBean beanProjeto = (ProjetoBean) session.getAttribute("beanProjeto");
        casoDeUso.setProjeto(beanProjeto.getProjeto());
        beanProjeto.getProjeto().getCasoDeUsos().add(casoDeUso);
        
        return "/sistema/projeto/cadastro";
    }
    
    public String cancelar(){
        casoDeUso = new CasoDeUso();
        return "/sistema/projeto/cadastro";
    }
    
    public String novo(){
        casoDeUso = new CasoDeUso();
        return "/sistema/projeto/casodeuso/cadastro";
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
