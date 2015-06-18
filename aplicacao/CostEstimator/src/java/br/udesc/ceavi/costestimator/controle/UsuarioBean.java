package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.Usuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author diego
 */
@ManagedBean(name = "beanUsuario")
@SessionScoped
public class UsuarioBean {
    
    private Usuario usuario;
    private List<Usuario> usuarios;
    
    @PostConstruct
    public void init(){
        this.usuarios = Usuario.listar();
    }
    
    public String salvar(){
        try{
            this.usuario.salvar();
        } catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(
                    null, 
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Erro",
                            ex.getMessage()
                    )
            );
            return "/sistema/cadastro";
        }
        return "/sistema/consulta";
    }
    
    public String cancelar(){
        this.usuario = new Usuario();
        return "/sistema/consuta";
    }
    
    public String novo(){
        this.usuario = new Usuario();
        return "/sistema/cadastro";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
