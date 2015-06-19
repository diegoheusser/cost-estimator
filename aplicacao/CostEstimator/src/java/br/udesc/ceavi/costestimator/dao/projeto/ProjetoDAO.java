package br.udesc.ceavi.costestimator.dao.projeto;

import br.udesc.ceavi.costestimator.dao.core.DefaultDAO;
import br.udesc.ceavi.costestimator.modelo.Projeto;
import java.util.List;

/**
 *
 * @author diego
 */
public interface ProjetoDAO extends DefaultDAO<Projeto> {
    
    public List<Projeto> listar(int id);
    
}
