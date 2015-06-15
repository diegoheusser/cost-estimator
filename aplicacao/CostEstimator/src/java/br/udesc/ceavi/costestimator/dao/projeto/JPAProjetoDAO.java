package br.udesc.ceavi.costestimator.dao.projeto;

import br.udesc.ceavi.costestimator.dao.core.JPADefaultDAO;
import br.udesc.ceavi.costestimator.modelo.Projeto;

/**
 *
 * @author diego
 */
public class JPAProjetoDAO extends JPADefaultDAO<Projeto> implements ProjetoDAO {

    @Override
    public Class getEntity() {
        return Projeto.class;
    }
    
}
