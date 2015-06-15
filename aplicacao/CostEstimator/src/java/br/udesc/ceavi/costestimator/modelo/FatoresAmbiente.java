package br.udesc.ceavi.costestimator.modelo;

import java.io.Serializable;
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
@Table(name = "fatores_ambiente")
public class FatoresAmbiente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fatores_ambiente_id")
    private int id;
    
    @Column
    private double E1;
    
    @Column
    private double E2;
    
    @Column
    private double E3;
    
    @Column
    private double E4;
    
    @Column
    private double E5;
    
    @Column
    private double E6;
    
    @Column
    private double E7;
    
    @Column
    private double E8;
    
    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getE1() {
        return E1;
    }

    public void setE1(double E1) {
        this.E1 = E1;
    }

    public double getE2() {
        return E2;
    }

    public void setE2(double E2) {
        this.E2 = E2;
    }

    public double getE3() {
        return E3;
    }

    public void setE3(double E3) {
        this.E3 = E3;
    }

    public double getE4() {
        return E4;
    }

    public void setE4(double E4) {
        this.E4 = E4;
    }

    public double getE5() {
        return E5;
    }

    public void setE5(double E5) {
        this.E5 = E5;
    }

    public double getE6() {
        return E6;
    }

    public void setE6(double E6) {
        this.E6 = E6;
    }

    public double getE7() {
        return E7;
    }

    public void setE7(double E7) {
        this.E7 = E7;
    }

    public double getE8() {
        return E8;
    }

    public void setE8(double E8) {
        this.E8 = E8;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    
    
}
