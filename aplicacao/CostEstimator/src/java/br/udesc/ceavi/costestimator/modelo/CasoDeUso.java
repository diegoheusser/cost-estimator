package br.udesc.ceavi.costestimator.modelo;

import br.udesc.ceavi.costestimator.dao.casodeuso.CasoDeUsoDAO;
import br.udesc.ceavi.costestimator.dao.core.DAOFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "caso_uso")
public class CasoDeUso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caso_uso_id")
    private int id;

    @Column
    private String descricao;

    @Column
    private int complexidade;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;
    
    @OneToMany( mappedBy = "casoDeUso",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<Apontamento> apontamentos;

    public static void remover(int id) {
        CasoDeUsoDAO dao = DAOFactory.getDAOFactory().getCasoDeUsoDAO();
        dao.remover(id);
    }

 
    public CasoDeUso(){
        this.apontamentos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getComplexidade() {
        return complexidade;
    }

    public void setComplexidade(int complexidade) {
        this.complexidade = complexidade;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Apontamento> getApontamentos() {
        return apontamentos;
    }

    public void setApontamentos(List<Apontamento> apontamentos) {
        this.apontamentos = apontamentos;
    }
    
    public String getComp(){
        switch(complexidade){
            case 5: {
                return "Simples";
            }
            case 10: {
                return "Médio";
            }
            case 15: {
                return "Complexo";
            }
            default: {
                return "";
            }
        }
    }
    
    public int porcentagem(){
        int p = 0;
        for(Apontamento a : apontamentos){
            p += a.getPorcentagem();
        }
        return p;
    }
    
    public double horasGastas(){
        double h = 0;
        for(Apontamento a :apontamentos){
            h += a.getHoras();
        }
        return h;
    }

}
