package br.udesc.ceavi.costestimator.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author diego
 */
public class JPAUtil {

    private static JPAUtil instancia;
    private final EntityManagerFactory emf;
    
    private JPAUtil(){
        this.emf = Persistence.createEntityManagerFactory("CostEstimatorPU");
    }
    
    public static JPAUtil getInstancia(){
        if(instancia == null) {
            instancia = new JPAUtil();
        }
        return instancia;
    }
    
    public EntityManager getEM(){
        return emf.createEntityManager();
    }
}
