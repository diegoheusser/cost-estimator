package br.udesc.ceavi.costestimator.modelo;

/**
 *
 * @author diego
 */
public enum Complexidade {

    SIMPLES(1), MEDIO(2), COMPLEXO(3);
    
    private final int valor;
    
    Complexidade(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

}
