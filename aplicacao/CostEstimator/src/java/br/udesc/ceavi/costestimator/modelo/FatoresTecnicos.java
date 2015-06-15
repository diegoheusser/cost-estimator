package br.udesc.ceavi.costestimator.modelo;

import br.udesc.ceavi.costestimator.dao.core.DAOFactory;
import br.udesc.ceavi.costestimator.dao.fatorestecnicos.FatoresTecnicosDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "fatores_tecnicos")
public class FatoresTecnicos implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "fatores_tecnicos_id")
    private int id;
    
    @Column
    private double T1;
    
    @Column
    private double T2;
    
    @Column
    private double T3;
    
    @Column
    private double T4;
    
    @Column
    private double T5;
    
    @Column
    private double T6;
    
    @Column
    private double T7;
    
    @Column
    private double T8;
    
    @Column
    private double T9;
    
    @Column
    private double T10;
    
    @Column
    private double T11;
    
    @Column
    private double T12;
    
    @Column
    private double T13;
    
    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    public void salvar(){
        FatoresTecnicosDAO dao = DAOFactory.getDAOFactory().getFatoresTecnicosDAO();
        dao.salvar(this);
    }
    
    public static void remover(int id){
        FatoresTecnicosDAO dao = DAOFactory.getDAOFactory().getFatoresTecnicosDAO();
        dao.remover(id);
    }
    
    public static List<FatoresTecnicos> listar(){
        FatoresTecnicosDAO dao = DAOFactory.getDAOFactory().getFatoresTecnicosDAO();
        return dao.listar();
    }
    
    public static FatoresTecnicos buscar(int id){
        FatoresTecnicosDAO dao = DAOFactory.getDAOFactory().getFatoresTecnicosDAO();
        return dao.buscar(id);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getT1() {
        return T1;
    }

    public void setT1(double T1) {
        this.T1 = T1;
    }

    public double getT2() {
        return T2;
    }

    public void setT2(double T2) {
        this.T2 = T2;
    }

    public double getT3() {
        return T3;
    }

    public void setT3(double T3) {
        this.T3 = T3;
    }

    public double getT4() {
        return T4;
    }

    public void setT4(double T4) {
        this.T4 = T4;
    }

    public double getT5() {
        return T5;
    }

    public void setT5(double T5) {
        this.T5 = T5;
    }

    public double getT6() {
        return T6;
    }

    public void setT6(double T6) {
        this.T6 = T6;
    }

    public double getT7() {
        return T7;
    }

    public void setT7(double T7) {
        this.T7 = T7;
    }

    public double getT8() {
        return T8;
    }

    public void setT8(double T8) {
        this.T8 = T8;
    }

    public double getT9() {
        return T9;
    }

    public void setT9(double T9) {
        this.T9 = T9;
    }

    public double getT10() {
        return T10;
    }

    public void setT10(double T10) {
        this.T10 = T10;
    }

    public double getT11() {
        return T11;
    }

    public void setT11(double T11) {
        this.T11 = T11;
    }

    public double getT12() {
        return T12;
    }

    public void setT12(double T12) {
        this.T12 = T12;
    }

    public double getT13() {
        return T13;
    }

    public void setT13(double T13) {
        this.T13 = T13;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    
    
}
