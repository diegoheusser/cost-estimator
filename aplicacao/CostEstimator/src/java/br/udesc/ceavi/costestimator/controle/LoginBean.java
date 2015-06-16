package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author diego
 */
@ManagedBean(name = "beanLogin")
@SessionScoped
public class LoginBean {
    
    private Usuario usuario;
    private String login;
    private String senha;
    
    public String logar(){
        return "login";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
