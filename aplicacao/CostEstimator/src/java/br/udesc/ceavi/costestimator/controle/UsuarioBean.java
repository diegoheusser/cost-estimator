package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.Usuario;
import br.udesc.ceavi.costestimator.util.SHA2;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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

    private final String telaCadastro = "/sistema/usuario/cadastro";
    private final String telaConsulta = "/sistema/usuario/consulta";
    private final String telaAlterar = "/sistema/usuario/alterar";
    private final String telaRedefinirSenha = "/sistema/usuario/redefinir";
    private Usuario usuario;
    private List<Usuario> usuarios;
    private String senhaAntiga;
    private String senhaNova;

    @PostConstruct
    public void init() {
        this.atualizaUsuarios();
    }

    public void excluir(Usuario u) {
        try {
            Usuario.remover(u.getId());
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_INFO, "Removido", ""
                    )
            );
            atualizaUsuarios();
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "Erro: ", ex.getMessage()
                    )
            );
        }
    }

    public void atualizaUsuarios() {
        this.usuarios = Usuario.listar();
    }

    public String alterar(Usuario usu) {
        this.usuario = usu;
        return telaAlterar;
    }

    public String redefinir() {
        return telaRedefinirSenha;
    }

    public String salvarRedefinir() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (SHA2.sha2(senhaAntiga).equals(usuario.getSenha())) {
            this.usuario.setSenha(senhaNova);
        }
        this.senhaAntiga = "";
        this.senhaNova = "";
        return telaAlterar;
    }

    public String cancelarRedefinir() {
        this.senhaAntiga = "";
        this.senhaNova = "";
        return telaAlterar;
    }

    public String salvar() {
        try {
            this.usuario.salvar();
            atualizaUsuarios();
        } catch (Exception ex) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR, "Erro", ex.getMessage()));
            return telaCadastro;
        }
        return telaConsulta;
    }

    public String cancelar() {
        this.usuario = new Usuario();
        return telaConsulta;
    }

    public String novo() {
        this.usuario = new Usuario();
        return telaCadastro;
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

    public String getSenhaAntiga() {
        return senhaAntiga;
    }

    public void setSenhaAntiga(String senhaAntiga) {
        this.senhaAntiga = senhaAntiga;
    }

    public String getSenhaNova() {
        return senhaNova;
    }

    public void setSenhaNova(String senhaNova) {
        this.senhaNova = senhaNova;
    }

}
