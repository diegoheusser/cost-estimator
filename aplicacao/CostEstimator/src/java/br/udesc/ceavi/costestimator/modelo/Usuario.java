package br.udesc.ceavi.costestimator.modelo;

import br.udesc.ceavi.costestimator.dao.core.DAOFactory;
import br.udesc.ceavi.costestimator.dao.usuario.UsuarioDAO;
import br.udesc.ceavi.costestimator.util.SHA2;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author diego
 */
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private int id;

    @Column
    private String nome;

    @Column
    private String login;

    @Column
    private String senha;

    @Column
    private boolean administrador;

    @OneToMany(mappedBy = "usuario")
    private List<Projeto> projetos;

    public void salvar() {
        UsuarioDAO dao = DAOFactory.getDAOFactory().getUsuarioDAO();
        dao.salvar(this);
    }

    public static void remover(int id) {
        UsuarioDAO dao = DAOFactory.getDAOFactory().getUsuarioDAO();
        dao.remover(id);
    }

    public static List<Usuario> listar() {
        UsuarioDAO dao = DAOFactory.getDAOFactory().getUsuarioDAO();
        return dao.listar();
    }

    public static Usuario buscar(int id) {
        UsuarioDAO dao = DAOFactory.getDAOFactory().getUsuarioDAO();
        return dao.buscar(id);
    }
    
    public static Usuario buscar(String login, String senha){
        UsuarioDAO dao = DAOFactory.getDAOFactory().getUsuarioDAO();
        return dao.buscar(login, senha);
    }

    public Usuario() {
        this.projetos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void setSenha(String senha) throws NoSuchAlgorithmException, 
            UnsupportedEncodingException {
        this.senha = SHA2.sha2(senha);
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

}
