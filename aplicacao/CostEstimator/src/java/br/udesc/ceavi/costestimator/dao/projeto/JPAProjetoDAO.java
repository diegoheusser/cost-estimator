package br.udesc.ceavi.costestimator.dao.projeto;

import br.udesc.ceavi.costestimator.dao.core.JPADefaultDAO;
import br.udesc.ceavi.costestimator.modelo.Projeto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author diego
 */
public class JPAProjetoDAO extends JPADefaultDAO<Projeto> implements ProjetoDAO {

    @Override
    public Class getEntity() {
        return Projeto.class;
    }

    @Override
    public List<Projeto> listar(int id) {
        EntityManager em = jpaUtil.getEM();
        List<Projeto> lista = new ArrayList<>();
        try{
            Query q = em.createQuery("SELECT p FROM Projeto p WHERE p.usuario.id = :id");
            q.setParameter("id", id);
            lista = q.getResultList();
        }finally{
            em.close();
        }
        return lista;
    }
    
}
