package br.udesc.ceavi.costestimator.dao.usuario;

import br.udesc.ceavi.costestimator.dao.core.JPADefaultDAO;
import br.udesc.ceavi.costestimator.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author diego
 */
public class JPAUsuarioDAO extends JPADefaultDAO<Usuario> implements UsuarioDAO {

    @Override
    public Class getEntity() {
        return Usuario.class;
    }

    @Override
    public Usuario buscar(String login, String senha) {
        EntityManager em = jpaUtil.getEM();
        Usuario u = null;
        try{
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha");
            q.setParameter("login", login);
            q.setParameter("senha", senha);
            u = (Usuario) q.getSingleResult();
        }finally{
            em.close();
        }
        return u;
    }
    
}
