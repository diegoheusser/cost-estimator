package br.udesc.ceavi.costestimator.dao.jpa;

import br.udesc.ceavi.costestimator.dao.ator.AtorDAO;
import br.udesc.ceavi.costestimator.dao.ator.JPAAtorDAO;
import br.udesc.ceavi.costestimator.dao.casodeuso.CasoDeUsoDAO;
import br.udesc.ceavi.costestimator.dao.casodeuso.JPACasoDeUsoDAO;
import br.udesc.ceavi.costestimator.dao.core.DAOFactory;
import br.udesc.ceavi.costestimator.dao.custo.CustoDAO;
import br.udesc.ceavi.costestimator.dao.custo.JPACustoDAO;
import br.udesc.ceavi.costestimator.dao.fatoresambiente.FatoresAmbienteDAO;
import br.udesc.ceavi.costestimator.dao.fatoresambiente.JPAFatoresAmbienteDAO;
import br.udesc.ceavi.costestimator.dao.fatorestecnicos.FatoresTecnicosDAO;
import br.udesc.ceavi.costestimator.dao.fatorestecnicos.JPAFatoresTecnicosDAO;
import br.udesc.ceavi.costestimator.dao.funcionario.FuncionarioDAO;
import br.udesc.ceavi.costestimator.dao.funcionario.JPAFuncionarioDAO;
import br.udesc.ceavi.costestimator.dao.projeto.JPAProjetoDAO;
import br.udesc.ceavi.costestimator.dao.projeto.ProjetoDAO;
import br.udesc.ceavi.costestimator.dao.usuario.JPAUsuarioDAO;
import br.udesc.ceavi.costestimator.dao.usuario.UsuarioDAO;

/**
 *
 * @author diego
 */
public class JPADAOFactory extends DAOFactory {

    @Override
    public AtorDAO getAtorDAO() {
        return new JPAAtorDAO();
    }

    @Override
    public CasoDeUsoDAO getCasoDeUsoDAO() {
        return new JPACasoDeUsoDAO();
    }

    @Override
    public CustoDAO getCustoDAO() {
        return new JPACustoDAO();
    }

    @Override
    public FatoresAmbienteDAO getFatoresAmbienteDAO() {
        return new JPAFatoresAmbienteDAO();
    }

    @Override
    public FatoresTecnicosDAO getFatoresTecnicosDAO() {
        return new JPAFatoresTecnicosDAO();
    }

    @Override
    public FuncionarioDAO getFuncionarioDAO() {
        return new JPAFuncionarioDAO();
    }

    @Override
    public ProjetoDAO getProjetoDAO() {
        return new JPAProjetoDAO();
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new JPAUsuarioDAO();
    }
    
}
