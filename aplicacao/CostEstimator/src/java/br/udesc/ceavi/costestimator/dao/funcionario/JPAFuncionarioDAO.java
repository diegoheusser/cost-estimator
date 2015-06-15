package br.udesc.ceavi.costestimator.dao.funcionario;

import br.udesc.ceavi.costestimator.dao.core.JPADefaultDAO;
import br.udesc.ceavi.costestimator.modelo.Funcionario;

/**
 *
 * @author diego
 */
public class JPAFuncionarioDAO extends JPADefaultDAO<Funcionario> implements FuncionarioDAO {

    @Override
    public Class getEntity() {
        return Funcionario.class;
    }
    
}
