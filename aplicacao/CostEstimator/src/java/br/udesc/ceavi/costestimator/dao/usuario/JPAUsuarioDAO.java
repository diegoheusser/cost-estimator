package br.udesc.ceavi.costestimator.dao.usuario;

import br.udesc.ceavi.costestimator.dao.core.JPADefaultDAO;
import br.udesc.ceavi.costestimator.modelo.Usuario;

/**
 *
 * @author diego
 */
public class JPAUsuarioDAO extends JPADefaultDAO<Usuario> implements UsuarioDAO {

    @Override
    public Class getEntity() {
        return Usuario.class;
    }
    
}
