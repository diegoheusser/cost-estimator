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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "fatores_tecnicos")
public class FatoresTecnicos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fatores_tecnicos_id")
    private int id;

    @Column(name = "peso_t1")
    private double pesoT1;

    @Column(name = "influencia_t1")
    private double influenciaT1;

    @Column(name = "peso_t2")
    private double pesoT2;

    @Column(name = "influencia_t2")
    private double influenciaT2;

    @Column(name = "peso_t3")
    private double pesoT3;

    @Column(name = "influencia_t3")
    private double influenciaT3;

    @Column(name = "peso_t4")
    private double pesoT4;

    @Column(name = "influencia_t4")
    private double influenciaT4;

    @Column(name = "peso_t5")
    private double pesoT5;

    @Column(name = "influencia_t5")
    private double influenciaT5;

    @Column(name = "peso_t6")
    private double pesoT6;

    @Column(name = "influencia_t6")
    private double influenciaT6;

    @Column(name = "peso_t7")
    private double pesoT7;

    @Column(name = "influencia_t7")
    private double influenciaT7;

    @Column(name = "peso_t8")
    private double pesoT8;

    @Column(name = "influencia_t8")
    private double influenciaT8;

    @Column(name = "peso_t9")
    private double pesoT9;

    @Column(name = "influencia_t9")
    private double influenciaT9;

    @Column(name = "peso_t10")
    private double pesoT10;

    @Column(name = "influencia_t10")
    private double influenciaT10;

    @Column(name = "peso_t11")
    private double pesoT11;

    @Column(name = "influencia_t11")
    private double influenciaT11;

    @Column(name = "peso_t12")
    private double pesoT12;

    @Column(name = "influencia_t12")
    private double influenciaT12;

    @Column(name = "peso_t13")
    private double pesoT13;

    @Column(name = "influencia_t13")
    private double influenciaT13;

    public FatoresTecnicos(){
        this.pesoT1 = 2;
        this.pesoT2 = 1;
        this.pesoT3 = 1;
        this.pesoT4 = 1;
        this.pesoT5 = 1;
        this.pesoT6 = 0.5;
        this.pesoT7 = 0.5;
        this.pesoT8 = 2;
        this.pesoT9 = 1;
        this.pesoT10 = 1;
        this.pesoT11 = 1;
        this.pesoT12 = 1;
        this.pesoT13 = 1;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPesoT1() {
        return pesoT1;
    }

    public void setPesoT1(double pesoT1) {
        this.pesoT1 = pesoT1;
    }

    public double getInfluenciaT1() {
        return influenciaT1;
    }

    public void setInfluenciaT1(double influenciaT1) {
        this.influenciaT1 = influenciaT1;
    }

    public double getPesoT2() {
        return pesoT2;
    }

    public void setPesoT2(double pesoT2) {
        this.pesoT2 = pesoT2;
    }

    public double getInfluenciaT2() {
        return influenciaT2;
    }

    public void setInfluenciaT2(double influenciaT2) {
        this.influenciaT2 = influenciaT2;
    }

    public double getPesoT3() {
        return pesoT3;
    }

    public void setPesoT3(double pesoT3) {
        this.pesoT3 = pesoT3;
    }

    public double getInfluenciaT3() {
        return influenciaT3;
    }

    public void setInfluenciaT3(double influenciaT3) {
        this.influenciaT3 = influenciaT3;
    }

    public double getPesoT4() {
        return pesoT4;
    }

    public void setPesoT4(double pesoT4) {
        this.pesoT4 = pesoT4;
    }

    public double getInfluenciaT4() {
        return influenciaT4;
    }

    public void setInfluenciaT4(double influenciaT4) {
        this.influenciaT4 = influenciaT4;
    }

    public double getPesoT5() {
        return pesoT5;
    }

    public void setPesoT5(double pesoT5) {
        this.pesoT5 = pesoT5;
    }

    public double getInfluenciaT5() {
        return influenciaT5;
    }

    public void setInfluenciaT5(double influenciaT5) {
        this.influenciaT5 = influenciaT5;
    }

    public double getPesoT6() {
        return pesoT6;
    }

    public void setPesoT6(double pesoT6) {
        this.pesoT6 = pesoT6;
    }

    public double getInfluenciaT6() {
        return influenciaT6;
    }

    public void setInfluenciaT6(double influenciaT6) {
        this.influenciaT6 = influenciaT6;
    }

    public double getPesoT7() {
        return pesoT7;
    }

    public void setPesoT7(double pesoT7) {
        this.pesoT7 = pesoT7;
    }

    public double getInfluenciaT7() {
        return influenciaT7;
    }

    public void setInfluenciaT7(double influenciaT7) {
        this.influenciaT7 = influenciaT7;
    }

    public double getPesoT8() {
        return pesoT8;
    }

    public void setPesoT8(double pesoT8) {
        this.pesoT8 = pesoT8;
    }

    public double getInfluenciaT8() {
        return influenciaT8;
    }

    public void setInfluenciaT8(double influenciaT8) {
        this.influenciaT8 = influenciaT8;
    }

    public double getPesoT9() {
        return pesoT9;
    }

    public void setPesoT9(double pesoT9) {
        this.pesoT9 = pesoT9;
    }

    public double getInfluenciaT9() {
        return influenciaT9;
    }

    public void setInfluenciaT9(double influenciaT9) {
        this.influenciaT9 = influenciaT9;
    }

    public double getPesoT10() {
        return pesoT10;
    }

    public void setPesoT10(double pesoT10) {
        this.pesoT10 = pesoT10;
    }

    public double getInfluenciaT10() {
        return influenciaT10;
    }

    public void setInfluenciaT10(double influenciaT10) {
        this.influenciaT10 = influenciaT10;
    }

    public double getPesoT11() {
        return pesoT11;
    }

    public void setPesoT11(double pesoT11) {
        this.pesoT11 = pesoT11;
    }

    public double getInfluenciaT11() {
        return influenciaT11;
    }

    public void setInfluenciaT11(double influenciaT11) {
        this.influenciaT11 = influenciaT11;
    }

    public double getPesoT12() {
        return pesoT12;
    }

    public void setPesoT12(double pesoT12) {
        this.pesoT12 = pesoT12;
    }

    public double getInfluenciaT12() {
        return influenciaT12;
    }

    public void setInfluenciaT12(double influenciaT12) {
        this.influenciaT12 = influenciaT12;
    }

    public double getPesoT13() {
        return pesoT13;
    }

    public void setPesoT13(double pesoT13) {
        this.pesoT13 = pesoT13;
    }

    public double getInfluenciaT13() {
        return influenciaT13;
    }

    public void setInfluenciaT13(double influenciaT13) {
        this.influenciaT13 = influenciaT13;
    }

}
