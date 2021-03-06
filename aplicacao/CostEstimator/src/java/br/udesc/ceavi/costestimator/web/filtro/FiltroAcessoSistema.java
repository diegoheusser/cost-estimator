/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.costestimator.web.filtro;

import br.udesc.ceavi.costestimator.controle.LoginBean;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diego
 */
public class FiltroAcessoSistema implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession sessao = ((HttpServletRequest) request).getSession();
        LoginBean beanLogin = (LoginBean) sessao.getAttribute("beanLogin");

        if (beanLogin != null && beanLogin.getUsuario() != null) {
            chain.doFilter(request, response);
        } else {
            RequestDispatcher encaminhador = request.getRequestDispatcher("/login.jsf");
            encaminhador.forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }

}
