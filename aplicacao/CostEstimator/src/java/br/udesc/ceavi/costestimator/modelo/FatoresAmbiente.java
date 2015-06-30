package br.udesc.ceavi.costestimator.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "fatores_ambiente")
public class FatoresAmbiente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fatores_ambiente_id")
    private int id;

    @Column(name = "peso_e1")
    private double pesoE1;

    @Column(name = "influencia_e1")
    private double influenciaE1;

    @Column(name = "peso_e2")
    private double pesoE2;

    @Column(name = "influencia_e2")
    private double influenciaE2;

    @Column(name = "peso_e3")
    private double pesoE3;

    @Column(name = "influencia_e3")
    private double influenciaE3;

    @Column(name = "peso_e4")
    private double pesoE4;

    @Column(name = "influencia_e4")
    private double influenciaE4;

    @Column(name = "peso_e5")
    private double pesoE5;

    @Column(name = "influencia_e5")
    private double influenciaE5;

    @Column(name = "peso_e6")
    private double pesoE6;

    @Column(name = "influencia_e6")
    private double influenciaE6;

    @Column(name = "peso_e7")
    private double pesoE7;

    @Column(name = "influencia_e7")
    private double influenciaE7;

    @Column(name = "peso_e8")
    private double pesoE8;

    @Column(name = "influencia_e8")
    private double influenciaE8;

    public FatoresAmbiente(){
        this.pesoE1 = 1.5;
        this.pesoE2 = -1;
        this.pesoE3 = 0.5;
        this.pesoE4 = 0.5;
        this.pesoE5 = 1;
        this.pesoE6 = 1;
        this.pesoE7 = -1;
        this.pesoE8 = 2;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPesoE1() {
        return pesoE1;
    }

    public void setPesoE1(double pesoE1) {
        this.pesoE1 = pesoE1;
    }

    public double getInfluenciaE1() {
        return influenciaE1;
    }

    public void setInfluenciaE1(double influenciaE1) {
        this.influenciaE1 = influenciaE1;
    }

    public double getPesoE2() {
        return pesoE2;
    }

    public void setPesoE2(double pesoE2) {
        this.pesoE2 = pesoE2;
    }

    public double getInfluenciaE2() {
        return influenciaE2;
    }

    public void setInfluenciaE2(double influenciaE2) {
        this.influenciaE2 = influenciaE2;
    }

    public double getPesoE3() {
        return pesoE3;
    }

    public void setPesoE3(double pesoE3) {
        this.pesoE3 = pesoE3;
    }

    public double getInfluenciaE3() {
        return influenciaE3;
    }

    public void setInfluenciaE3(double influenciaE3) {
        this.influenciaE3 = influenciaE3;
    }

    public double getPesoE4() {
        return pesoE4;
    }

    public void setPesoE4(double pesoE4) {
        this.pesoE4 = pesoE4;
    }

    public double getInfluenciaE4() {
        return influenciaE4;
    }

    public void setInfluenciaE4(double influenciaE4) {
        this.influenciaE4 = influenciaE4;
    }

    public double getPesoE5() {
        return pesoE5;
    }

    public void setPesoE5(double pesoE5) {
        this.pesoE5 = pesoE5;
    }

    public double getInfluenciaE5() {
        return influenciaE5;
    }

    public void setInfluenciaE5(double influenciaE5) {
        this.influenciaE5 = influenciaE5;
    }

    public double getPesoE6() {
        return pesoE6;
    }

    public void setPesoE6(double pesoE6) {
        this.pesoE6 = pesoE6;
    }

    public double getInfluenciaE6() {
        return influenciaE6;
    }

    public void setInfluenciaE6(double influenciaE6) {
        this.influenciaE6 = influenciaE6;
    }

    public double getPesoE7() {
        return pesoE7;
    }

    public void setPesoE7(double pesoE7) {
        this.pesoE7 = pesoE7;
    }

    public double getInfluenciaE7() {
        return influenciaE7;
    }

    public void setInfluenciaE7(double influenciaE7) {
        this.influenciaE7 = influenciaE7;
    }

    public double getPesoE8() {
        return pesoE8;
    }

    public void setPesoE8(double pesoE8) {
        this.pesoE8 = pesoE8;
    }

    public double getInfluenciaE8() {
        return influenciaE8;
    }

    public void setInfluenciaE8(double influenciaE8) {
        this.influenciaE8 = influenciaE8;
    }
    
}
