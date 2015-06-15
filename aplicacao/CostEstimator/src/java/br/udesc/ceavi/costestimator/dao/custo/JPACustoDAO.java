package br.udesc.ceavi.costestimator.dao.custo;

import br.udesc.ceavi.costestimator.dao.core.JPADefaultDAO;
import br.udesc.ceavi.costestimator.modelo.Custo;

/**
 *
 * @author diego
 */
public class JPACustoDAO extends JPADefaultDAO<Custo> implements CustoDAO {

    @Override
    public Class getEntity() {
        return Custo.class;
    }
    
}
