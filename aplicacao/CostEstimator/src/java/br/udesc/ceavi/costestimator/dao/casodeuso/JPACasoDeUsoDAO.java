package br.udesc.ceavi.costestimator.dao.casodeuso;

import br.udesc.ceavi.costestimator.dao.core.JPADefaultDAO;
import br.udesc.ceavi.costestimator.modelo.CasoDeUso;

/**
 *
 * @author diego
 */
public class JPACasoDeUsoDAO extends JPADefaultDAO<CasoDeUso> implements CasoDeUsoDAO {

    @Override
    public Class getEntity() {
        return CasoDeUso.class;
    }
    
}
