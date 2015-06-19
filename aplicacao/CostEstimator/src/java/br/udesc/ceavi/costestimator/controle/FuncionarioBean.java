package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.Funcionario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author diego
 */
@ManagedBean(name = "beanFuncionario")
@SessionScoped
public class FuncionarioBean {

    private final String telaCadastro = "/sistema/funcionario/cadastro";
    private final String telaConsulta = "/sistema/funcionario/consulta";

    private Funcionario funcionario;
    private List<Funcionario> funcionarios;

    public FuncionarioBean() {
        this.funcionario = new Funcionario();
        this.funcionarios = Funcionario.listar();
    }

    public String novo() {
        this.funcionario = new Funcionario();
        return telaCadastro;
    }

    public String salvar() {
        try {
            funcionario.salvar();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Funcionário salvo com sucesso", ""));

            this.funcionario = new Funcionario();
            this.funcionarios = Funcionario.listar();
            return telaConsulta;

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro ao salvar funcionário", ""));
            return telaCadastro;
        }

    }

    public String cancelar() {
        this.funcionario = new Funcionario();
        return "/sistema/funcionario/consuta";
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
