package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.Funcionario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diego
 */
@ManagedBean(name = "beanFuncionario")
@SessionScoped
public class FuncionarioBean {

    private final String telaCadastro = "/sistema/funcionario/cadastro";
    private final String telaConsulta = "/sistema/funcionario/consulta";
    private final String telaFuncionarios = "/sistema/funcionario/funcionarios";
    private final String telaCadastroProjeto = "/sistema/projeto/cadastro";

    private Funcionario funcionario;
    private List<Funcionario> funcionarios;
    private List<Funcionario> funcionariosSelecionados;

    public FuncionarioBean() {
        this.funcionario = new Funcionario();
        funcionariosSelecionados = new ArrayList<>();
        atualizaFuncionarios();
    }

    private void atualizaFuncionarios() {
        this.funcionarios = Funcionario.listar();
    }
    

    public String adicionar(){
        HttpSession session
                = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        ProjetoBean beanProjeto = (ProjetoBean) session.getAttribute("beanProjeto");
        beanProjeto.adicionar(funcionariosSelecionados);
        return telaCadastroProjeto;
    }

    public void excluir(Funcionario f) {
        try {
            Funcionario.remover(f.getId());
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_INFO, "Removido", ""
                    )
            );
            atualizaFuncionarios();
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "Erro: ", ex.getMessage()
                    )
            );
        }
    }

    public String addFuncionario() {
        return telaFuncionarios;
    }

    public String alterar(Funcionario fu) {
        this.funcionario = fu;
        return telaCadastro;
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
        return telaConsulta;
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

    public List<Funcionario> getFuncionariosSelecionados() {
        return funcionariosSelecionados;
    }

    public void setFuncionariosSelecionados(List<Funcionario> funcionariosSelecionados) {
        this.funcionariosSelecionados = funcionariosSelecionados;
    }

}
