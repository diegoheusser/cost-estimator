package br.udesc.ceavi.costestimator.modelo;

import br.udesc.ceavi.costestimator.dao.ator.AtorDAO;
import br.udesc.ceavi.costestimator.dao.core.DAOFactory;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author diego, marcos gg
 */
@Entity
public class Ator implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ator_id")
    private int id;

    @Column
    private String descricao;

    @Column
    private int complexidade;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

 public static void remover(int id) {
        AtorDAO dao = DAOFactory.getDAOFactory().getAtorDAO();
        dao.remover(id);
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

    public String getComp() {
        switch (complexidade) {
            case 1: {
                return "Simples";
            }
            case 2: {
                return "Médio";
            }
            case 3: {
                return "Complexo";
            }
            default: {
                return "";
            }
        }
    }
}
