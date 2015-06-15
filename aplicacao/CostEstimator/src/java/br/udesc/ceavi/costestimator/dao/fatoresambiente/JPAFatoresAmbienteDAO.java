package br.udesc.ceavi.costestimator.dao.fatoresambiente;

import br.udesc.ceavi.costestimator.dao.core.JPADefaultDAO;
import br.udesc.ceavi.costestimator.modelo.FatoresAmbiente;

/**
 *
 * @author diego
 */
public class JPAFatoresAmbienteDAO extends JPADefaultDAO<FatoresAmbiente> implements FatoresAmbienteDAO {

    @Override
    public Class getEntity() {
        return FatoresAmbiente.class;
    }
    
}
