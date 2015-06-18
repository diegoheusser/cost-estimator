package br.udesc.ceavi.costestimator.modelo;

import br.udesc.ceavi.costestimator.dao.apontamento.ApontamentoDAO;
import br.udesc.ceavi.costestimator.dao.core.DAOFactory;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diego
 */
@Entity
public class Apontamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apontamento_id")
    private int id;
    
    @Column(name = "data_apontamento")
    @Temporal(TemporalType.DATE)
    private Date dataApotamento;
    
    @Column
    private double horas;
    
    @Column
    private double porcentagem;
    
    @ManyToOne
    @JoinColumn(name = "caso_uso_id")
    private CasoDeUso casoDeUso;
    
    public void salvar(){
        ApontamentoDAO dao = DAOFactory.getDAOFactory().getApontamentoDAO();
        dao.salvar(this);
    }
    
    public static void remover(int id){
        ApontamentoDAO dao = DAOFactory.getDAOFactory().getApontamentoDAO();
        dao.remover(id);
    }
    
    public static List<Apontamento> listar(){
        ApontamentoDAO dao = DAOFactory.getDAOFactory().getApontamentoDAO();
        return dao.listar();
    }
    
    public static Apontamento buscar(int id){
        ApontamentoDAO dao = DAOFactory.getDAOFactory().getApontamentoDAO();
        return dao.buscar(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataApotamento() {
        return dataApotamento;
    }

    public void setDataApotamento(Date dataApotamento) {
        this.dataApotamento = dataApotamento;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public CasoDeUso getCasoDeUso() {
        return casoDeUso;
    }

    public void setCasoDeUso(CasoDeUso casoDeUso) {
        this.casoDeUso = casoDeUso;
    }


}
