package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.Usuario;
import br.udesc.ceavi.costestimator.util.SHA2;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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

    public String logar() throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        usuario = Usuario.buscar(login, SHA2.sha2(senha));
        if (usuario == null) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_WARN,
                            "Acesso negado",
                            "login ou senha inválidos"
                    )
            );
            return "login";
        }
        login = "";
        senha = "";
        return "/sistema/index";
    }

    public String logoff() {
        this.usuario = null;
        HttpSession session
                = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();
        return "/login";
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
