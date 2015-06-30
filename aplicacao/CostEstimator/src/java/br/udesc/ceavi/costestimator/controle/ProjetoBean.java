package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.Ator;
import br.udesc.ceavi.costestimator.modelo.CasoDeUso;
import br.udesc.ceavi.costestimator.modelo.Custo;
import br.udesc.ceavi.costestimator.modelo.FatoresAmbiente;
import br.udesc.ceavi.costestimator.modelo.FatoresTecnicos;
import br.udesc.ceavi.costestimator.modelo.Funcionario;
import br.udesc.ceavi.costestimator.modelo.Projeto;
import br.udesc.ceavi.costestimator.treinamento.IRedeNeural;
import br.udesc.ceavi.costestimator.treinamento.RedeNeuralOpenCv;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.joda.time.DateTime;
import org.opencv.core.Core;

/**
 *
 * @author diego
 */
@ManagedBean(name = "beanProjeto")
@SessionScoped
public class ProjetoBean {

    private final String telaCadastro = "/sistema/projeto/cadastro";
    private final String telaConsulta = "/sistema/projeto/consulta";
    private final String telaApontamentos = "/sistema/projeto/apontamentos";
    private final String telaUCP = "/sistema/projeto/ucp";

    private Projeto projeto;
    private List<Projeto> projetos;

    public ProjetoBean() {
        this.projeto = new Projeto();
        System.loadLibrary("opencv_java241");
        atualizaProjetos();
    }

    public String apontar(Projeto pr) {
        return telaApontamentos;
    }

    public void relatorioUCP() {
        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("PROJETO_ID", this.projeto.getId());
        try {
            relatorio("ucp", parametros);
        } catch (JRException ex) {
            Logger.getLogger(ProjetoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProjetoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(ProjetoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void relatorio(String nomeRelatorio, HashMap<String, Object> parametros) throws JRException, IOException, SQLException, NamingException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ext = context.getExternalContext();

        InputStream fis = ext.getResourceAsStream("/relatorios/" + nomeRelatorio + ".jrxml");

        JasperReport jasper = JasperCompileManager.compileReport(fis);

        Context cxt = new InitialContext();
        DataSource dataSource = (DataSource) cxt.lookup("java:/comp/env/jdbc/controle_estoque");

        JasperPrint printer = JasperFillManager.fillReport(jasper, parametros, dataSource.getConnection());

        HttpServletResponse resp = (HttpServletResponse) ext.getResponse();
        resp.setContentType("application/pdf");
        resp.addHeader("Content-Disposition", "inline;filename=" + nomeRelatorio + ".pdf");

        JasperExportManager.exportReportToPdfStream(printer, resp.getOutputStream());
        context.responseComplete();
    }

    public String calcular(Projeto pr) {
        double uaw = 0;
        double qtdAtoresSimples = 0;
        double qtdAtoresMedios = 0;
        double qtdAtoresComplexos = 0;
        for (Ator a : pr.getAtores()) {
            uaw += a.getComplexidade();
            switch (a.getComplexidade()) {
                case 1: {
                    qtdAtoresSimples++;
                    break;
                }
                case 2: {
                    qtdAtoresMedios++;
                    break;
                }
                case 3: {
                    qtdAtoresComplexos++;
                    break;
                }
            }
        }
        double uucw = 0;
        double qtdCasosDeUsoSimples = 0;
        double qtdCasosDeUsoMedios = 0;
        double qtdCasosDeUsoComplexos = 0;
        for (CasoDeUso cdu : pr.getCasoDeUsos()) {
            uucw += cdu.getComplexidade();
            switch (cdu.getComplexidade()) {
                case 5: {
                    qtdCasosDeUsoSimples++;
                    break;
                }
                case 10: {
                    qtdCasosDeUsoMedios++;
                    break;
                }
                case 15: {
                    qtdCasosDeUsoComplexos++;
                    break;
                }
            }
        }
        double uucp = 0;
        uucp = uaw + uucw;
        FatoresTecnicos ft = pr.getFatoresTecnicos();
        double t1 = ft.getPesoT1() * ft.getInfluenciaT1();
        double t2 = ft.getPesoT2() * ft.getInfluenciaT2();
        double t3 = ft.getPesoT3() * ft.getInfluenciaT3();
        double t4 = ft.getPesoT4() * ft.getInfluenciaT4();
        double t5 = ft.getPesoT5() * ft.getInfluenciaT5();
        double t6 = ft.getPesoT6() * ft.getInfluenciaT6();
        double t7 = ft.getPesoT7() * ft.getInfluenciaT7();
        double t8 = ft.getPesoT8() * ft.getInfluenciaT8();
        double t9 = ft.getPesoT9() * ft.getInfluenciaT9();
        double t10 = ft.getPesoT10() * ft.getInfluenciaT10();
        double t11 = ft.getPesoT11() * ft.getInfluenciaT11();
        double t12 = ft.getPesoT12() * ft.getInfluenciaT12();
        double t13 = ft.getPesoT13() * ft.getInfluenciaT13();
        double tfactor = t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10 + t11 + t12 + t13;
        double tcf = 0.6 + (0.01 * tfactor);
        FatoresAmbiente fa = pr.getFatoresAmbientais();
        double e1 = fa.getPesoE1() * fa.getInfluenciaE1();
        double e2 = fa.getPesoE2() * fa.getInfluenciaE2();
        double e3 = fa.getPesoE3() * fa.getInfluenciaE3();
        double e4 = fa.getPesoE4() * fa.getInfluenciaE4();
        double e5 = fa.getPesoE5() * fa.getInfluenciaE5();
        double e6 = fa.getPesoE6() * fa.getInfluenciaE6();
        double e7 = fa.getPesoE7() * fa.getInfluenciaE7();
        double e8 = fa.getPesoE8() * fa.getInfluenciaE8();
        double efactor = e1 + e2 + e3 + e4 + e5 + e6 + e7 + e8;
        double ecf = 1.4 + (-0.03 * efactor);
        double ucp = uucp * tcf * ecf;
        double horasProgramacao = pr.getHorasPessoasUCP() * ucp;
        int qtdFuncionarios = pr.getFuncionarios().size();
        double horasPorFuncionario = horasProgramacao / qtdFuncionarios;
        double valorFuncioarios = 0;
        for (Funcionario f : pr.getFuncionarios()) {
            valorFuncioarios += (f.getValorHora() * horasPorFuncionario);
        }
        double custos = 0;
        for (Custo c : pr.getCustos()) {
            custos += c.getValor();
        }
        double custoEstimado = valorFuncioarios + custos;
        int dias = (int) (horasPorFuncionario / 8);
        DateTime dt = new DateTime(pr.getDataInicio());
        Date dataEstimada = dt.plusDays(dias).toDate();
        double[] entrada = new double[27];
        entrada[0] = qtdAtoresSimples;
        entrada[1] = qtdAtoresMedios;
        entrada[2] = qtdAtoresComplexos;
        entrada[3] = qtdCasosDeUsoSimples;
        entrada[4] = qtdCasosDeUsoMedios;
        entrada[5] = qtdCasosDeUsoComplexos;
        entrada[6] = t1;
        entrada[7] = t2;
        entrada[8] = t3;
        entrada[9] = t4;
        entrada[10] = t5;
        entrada[11] = t6;
        entrada[12] = t7;
        entrada[13] = t8;
        entrada[14] = t9;
        entrada[15] = t10;
        entrada[16] = t11;
        entrada[17] = t12;
        entrada[18] = t13;
        entrada[19] = e1;
        entrada[20] = e2;
        entrada[21] = e3;
        entrada[22] = e4;
        entrada[23] = e5;
        entrada[24] = e6;
        entrada[25] = e7;
        entrada[26] = e8;
        IRedeNeural redeNeural = RedeNeuralOpenCv.getInstancia();
        redeNeural.treinamento();
        double[] saida = redeNeural.predicao(entrada);
        int maior = 0;
        for (int i = 0; i < saida.length; i++) {
            if (saida[i] > saida[maior]) {
                maior = i;
            }
        }
        pr.setComplexidade(maior + 1);
        pr.setDataTerminoEstimada(dataEstimada);
        pr.setCustoEstimado(custoEstimado);
        this.projeto = pr;
        return telaUCP;
    }

    public void adicionar(List<Funcionario> funcionarios) {
        for (Funcionario f : funcionarios) {
            if (!projeto.getFuncionarios().contains(f)) {
                projeto.getFuncionarios().add(f);
            }
        }
    }

    private void atualizaProjetos() {
        HttpSession session
                = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        LoginBean beanLogin = (LoginBean) session.getAttribute("beanLogin");
        this.projetos = Projeto.listar(beanLogin.getUsuario().getId());
    }

    public void excluir(Projeto p) {
        try {
            Projeto.remover(p.getId());
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_INFO, "Removido", ""
                    )
            );
            atualizaProjetos();
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "Erro: ", ex.getMessage()
                    )
            );
        }
    }

    public void removerAtor(Ator a) {
        try {
            projeto.getAtores().remove(a);
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_INFO, "Removido", ""
                    )
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "Erro: ", ex.getMessage()
                    )
            );
        }
    }

    public void removerCasoDeUso(CasoDeUso c) {
        try {
            projeto.getCasoDeUsos().remove(c);
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_INFO, "Removido", ""
                    )
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "Erro: ", ex.getMessage()
                    )
            );
        }
    }

    public void removerCusto(Custo c) {
        try {
            projeto.getCustos().remove(c);
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_INFO, "Removido", ""
                    )
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "Erro: ", ex.getMessage()
                    )
            );
        }
    }

    public void remover(Funcionario f) {
        try {
            projeto.getFuncionarios().remove(f);
            f.getProjetos().remove(projeto);
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_INFO, "Removido", ""
                    )
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_ERROR, "Erro: ", ex.getMessage()
                    )
            );
        }
    }

    public String alterar(Projeto pr) {
        this.projeto = pr;
        return telaCadastro;
    }

    public String novo() {
        this.projeto = new Projeto();
        return telaCadastro;
    }

    public String salvar() {
        try {
            HttpSession session
                    = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(false);
            LoginBean beanLogin = (LoginBean) session.getAttribute("beanLogin");
            projeto.setUsuario(beanLogin.getUsuario());
            projeto.salvar();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Projeto salvo com sucesso", ""));

            this.projeto = new Projeto();
            this.projetos = Projeto.listar();
            return telaConsulta;

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro ao salvar projeto", ""));
            return telaCadastro;
        }

    }

    public String cancelar() {
        this.projeto = new Projeto();
        return telaConsulta;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

}
