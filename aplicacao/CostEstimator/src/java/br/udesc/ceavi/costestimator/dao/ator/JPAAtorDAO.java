package br.udesc.ceavi.costestimator.dao.ator;

import br.udesc.ceavi.costestimator.dao.core.JPADefaultDAO;
import br.udesc.ceavi.costestimator.modelo.Ator;

/**
 *
 * @author diego
 */
public class JPAAtorDAO extends JPADefaultDAO<Ator> implements AtorDAO {

    @Override
    public Class getEntity() {
        return Ator.class;
    }
    
}
