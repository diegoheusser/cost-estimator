package br.udesc.ceavi.costestimator.modelo;

import br.udesc.ceavi.costestimator.dao.core.DAOFactory;
import br.udesc.ceavi.costestimator.dao.projeto.ProjetoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author diego
 */
@Entity
public class Projeto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projeto_id")
    private int id;

    @Column
    private String descricao;

    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Column(name = "data_termino")
    @Temporal(TemporalType.DATE)
    private Date dataTermino;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "projeto_funcionario",
            joinColumns = {
                @JoinColumn(name = "projeto_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "funcionario_id")})
    private List<Funcionario> funcionarios;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<Ator> atores;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<CasoDeUso> casoDeUsos;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "fatores_ambientais_id")
    private FatoresAmbiente fatoresAmbientais;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fatores_tecnicos_id")
    private FatoresTecnicos fatoresTecnicos;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<Custo> custos;
    
    @Column(name = "custo_estimado")
    private double custoEstimado;
    
    @Column(name = "custo_real")
    private double custoReal;


    public void salvar() {
        ProjetoDAO dao = DAOFactory.getDAOFactory().getProjetoDAO();
        dao.salvar(this);
    }

    public static void remover(int id) {
        ProjetoDAO dao = DAOFactory.getDAOFactory().getProjetoDAO();
        dao.remover(id);
    }

    public static List<Projeto> listar() {
        ProjetoDAO dao = DAOFactory.getDAOFactory().getProjetoDAO();
        return dao.listar();
    }

    public static List<Projeto> listar(int id) {
        ProjetoDAO dao = DAOFactory.getDAOFactory().getProjetoDAO();
        return dao.listar(id);
    }

    public static Projeto buscar(int id) {
        ProjetoDAO dao = DAOFactory.getDAOFactory().getProjetoDAO();
        return dao.buscar(id);
    }

    public Projeto() {
        this.funcionarios = new ArrayList<>();
        this.atores = new ArrayList<>();
        this.casoDeUsos = new ArrayList<>();
        this.custos = new ArrayList<>();
        fatoresAmbientais = new FatoresAmbiente();
        fatoresTecnicos = new FatoresTecnicos();
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public List<CasoDeUso> getCasoDeUsos() {
        return casoDeUsos;
    }

    public void setCasoDeUsos(List<CasoDeUso> casoDeUsos) {
        this.casoDeUsos = casoDeUsos;
    }

    public FatoresAmbiente getFatoresAmbientais() {
        return fatoresAmbientais;
    }

    public void setFatoresAmbientais(FatoresAmbiente fatoresAmbientais) {
        this.fatoresAmbientais = fatoresAmbientais;
    }

    public FatoresTecnicos getFatoresTecnicos() {
        return fatoresTecnicos;
    }

    public void setFatoresTecnicos(FatoresTecnicos fatoresTecnicos) {
        this.fatoresTecnicos = fatoresTecnicos;
    }

    public List<Custo> getCustos() {
        return custos;
    }

    public void setCustos(List<Custo> custos) {
        this.custos = custos;
    }

    public double getCustoEstimado() {
        return custoEstimado;
    }

    public void setCustoEstimado(double custoEstimado) {
        this.custoEstimado = custoEstimado;
    }

    public double getCustoReal() {
        return custoReal;
    }

    public void setCustoReal(double custoReal) {
        this.custoReal = custoReal;
    }

}
