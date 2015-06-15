package br.udesc.ceavi.costestimator.dao.core;

import br.udesc.ceavi.costestimator.dao.jpa.JPAUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author diego
 * @param <T>
 */
public abstract class JPADefaultDAO<T extends Object> implements DefaultDAO<T> {

    protected JPAUtil jpaUtil;

    public abstract Class getEntity();

    public JPADefaultDAO() {
        jpaUtil = JPAUtil.getInstancia();
    }

    @Override
    public void salvar(T t) {
        EntityManager em = jpaUtil.getEM();
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void remover(int id) {
        EntityManager em = jpaUtil.getEM();
        try {
            T t = (T) em.find(getEntity(), id);
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
    }

    @Override
    public List<T> listar() {
        EntityManager em = jpaUtil.getEM();
        List<T> lista = new ArrayList<>();
        try{
            Query consulta = em.createQuery("SELECT t FROM "+getEntity().getName()+" t");
            lista = consulta.getResultList();
        }finally{
            em.close();
        }
        return lista;
    }

    @Override
    public T buscar(int id) {
        EntityManager em = jpaUtil.getEM();
        T t = null;
        try{
            t = (T) em.find(getEntity(), id);
        }finally{
            em.close();
        }
        return t;
    }

}
