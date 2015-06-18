package br.udesc.ceavi.costestimator.dao.core;

import br.udesc.ceavi.costestimator.dao.apontamento.ApontamentoDAO;
import br.udesc.ceavi.costestimator.dao.ator.AtorDAO;
import br.udesc.ceavi.costestimator.dao.casodeuso.CasoDeUsoDAO;
import br.udesc.ceavi.costestimator.dao.custo.CustoDAO;
import br.udesc.ceavi.costestimator.dao.fatoresambiente.FatoresAmbienteDAO;
import br.udesc.ceavi.costestimator.dao.fatorestecnicos.FatoresTecnicosDAO;
import br.udesc.ceavi.costestimator.dao.funcionario.FuncionarioDAO;
import br.udesc.ceavi.costestimator.dao.jpa.JPADAOFactory;
import br.udesc.ceavi.costestimator.dao.projeto.ProjetoDAO;
import br.udesc.ceavi.costestimator.dao.usuario.UsuarioDAO;

/**
 *
 * @author diego
 */
public abstract class DAOFactory {
    
    public final static int FABRICA = 1;
    
    public static DAOFactory getDAOFactory(){
        switch(FABRICA){
            case 1:{
                return new JPADAOFactory();
            }
            default:{
                return null;
            }
        }
    }
    
    public abstract ApontamentoDAO getApontamentoDAO();
    public abstract AtorDAO getAtorDAO();
    public abstract CasoDeUsoDAO getCasoDeUsoDAO();
    public abstract CustoDAO getCustoDAO();
    public abstract FatoresAmbienteDAO getFatoresAmbienteDAO();
    public abstract FatoresTecnicosDAO getFatoresTecnicosDAO();
    public abstract FuncionarioDAO getFuncionarioDAO();
    public abstract ProjetoDAO getProjetoDAO();
    public abstract UsuarioDAO getUsuarioDAO();
}
