package br.udesc.ceavi.costestimator.dao.fatorestecnicos;

import br.udesc.ceavi.costestimator.dao.core.JPADefaultDAO;
import br.udesc.ceavi.costestimator.modelo.FatoresTecnicos;

/**
 *
 * @author diego
 */
public class JPAFatoresTecnicosDAO extends JPADefaultDAO<FatoresTecnicos> implements FatoresTecnicosDAO {

    @Override
    public Class getEntity() {
        return FatoresTecnicos.class;
    }
    
}
