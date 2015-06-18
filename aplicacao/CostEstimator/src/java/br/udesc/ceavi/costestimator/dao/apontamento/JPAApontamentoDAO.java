package br.udesc.ceavi.costestimator.dao.apontamento;

import br.udesc.ceavi.costestimator.dao.core.JPADefaultDAO;
import br.udesc.ceavi.costestimator.modelo.Apontamento;

/**
 *
 * @author diego
 */
public class JPAApontamentoDAO extends JPADefaultDAO<Apontamento> implements ApontamentoDAO {

    @Override
    public Class getEntity() {
        return Apontamento.class;
    }
    
}
