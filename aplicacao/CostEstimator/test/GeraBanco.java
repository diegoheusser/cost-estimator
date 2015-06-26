

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
        u.setLogin("admin");
        u.setNome("Administrador");
        u.setSenha("admin");
        u.salvar();
    }
}
