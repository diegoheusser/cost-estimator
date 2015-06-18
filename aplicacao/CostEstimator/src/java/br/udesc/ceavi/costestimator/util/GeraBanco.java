package br.udesc.ceavi.costestimator.util;

import br.udesc.ceavi.costestimator.modelo.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author diego
 */
public class GeraBanco {
    public static void main(String[] args) throws NoSuchAlgorithmException, 
            UnsupportedEncodingException {
        Usuario u = new Usuario();
        u.setAdministrador(true);
        u.setLogin("root");
        u.setNome("Administrador");
        u.setSenha("root");
        u.salvar();
    }
}
