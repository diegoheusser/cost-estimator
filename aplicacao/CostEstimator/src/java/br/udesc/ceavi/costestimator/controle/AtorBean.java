package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.Ator;
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
public class AtorBean extends Nivel {

    private Ator ator;
    private Nivel nivel;

    public String salvar() {
        HttpSession session
                = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        ProjetoBean beanProjeto = (ProjetoBean) session.getAttribute("beanProjeto");
        ator.setProjeto(beanProjeto.getProjeto());
        beanProjeto.getProjeto().getAtores().add(ator);
        
        return "/sistema/projeto/cadastro";
    }
    
    public String cancelar(){
        ator = new Ator();
        return "/sistema/projeto/cadastro";
    }
    
    public String novo(){
        ator = new Ator();
        return "/sistema/projeto/ator/cadastro";
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

}
