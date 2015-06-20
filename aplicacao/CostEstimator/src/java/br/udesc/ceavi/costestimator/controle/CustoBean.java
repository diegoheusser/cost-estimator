package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.Ator;
import br.udesc.ceavi.costestimator.modelo.Custo;
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

    private Custo custo;

    public String salvar() {
        HttpSession session
                = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        ProjetoBean beanProjeto = (ProjetoBean) session.getAttribute("beanProjeto");
        custo.setProjeto(beanProjeto.getProjeto());
        beanProjeto.getProjeto().getCustos().add(custo);

        return "/sistema/projeto/cadastro";
    }

    public String cancelar() {
        custo = new Custo();
        return "/sistema/projeto/cadastro";
    }

    public String novo() {
        custo = new Custo();
        return "/sistema/projeto/custo/cadastro";
    }

    public Custo getCusto() {
        return custo;
    }

    public void setCusto(Custo custo) {
        this.custo = custo;
    }

}
