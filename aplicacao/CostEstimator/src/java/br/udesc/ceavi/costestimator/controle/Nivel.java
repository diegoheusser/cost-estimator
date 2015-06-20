package br.udesc.ceavi.costestimator.controle;

import br.udesc.ceavi.costestimator.modelo.Complexidade;

/**
 *
 * @author diego
 */
public class Nivel {
    
    private final Complexidade simples = Complexidade.SIMPLES;
    private final Complexidade medio = Complexidade.MEDIO;
    private final Complexidade complexo = Complexidade.COMPLEXO;

    public Complexidade getSimples() {
        return simples;
    }

    public Complexidade getMedio() {
        return medio;
    }

    public Complexidade getComplexo() {
        return complexo;
    }

}
