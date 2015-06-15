package br.udesc.ceavi.costestimator.modelo;

import br.udesc.ceavi.costestimator.dao.core.DAOFactory;
import br.udesc.ceavi.costestimator.dao.funcionario.FuncionarioDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author diego
 */
@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionario_id")
    private int id;
    
    @Column
    private String nome;
    
    @Column(name = "valor_hora")
    private double valorHora;
    
    @ManyToMany(mappedBy = "funcionarios")
    private List<Projeto> projetos;
    
    public void salvar(){
        FuncionarioDAO dao = DAOFactory.getDAOFactory().getFuncionarioDAO();
        dao.salvar(this);
    }
    
    public static void remover(int id){
        FuncionarioDAO dao = DAOFactory.getDAOFactory().getFuncionarioDAO();
        dao.remover(id);
    }
    
    public static List<Funcionario> listar(){
        FuncionarioDAO dao = DAOFactory.getDAOFactory().getFuncionarioDAO();
        return dao.listar();
    }
    
    public static Funcionario buscar(int id){
        FuncionarioDAO dao = DAOFactory.getDAOFactory().getFuncionarioDAO();
        return dao.buscar(id);
    }
    
    public Funcionario(){
        this.projetos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
    
    
}
