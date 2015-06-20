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
    
    @Override
    public String toString(){
        switch(valor){
            case 1:{
                return "Simples";
            }
            case 2:{
                return "Médio";
            }
            case 3:{
                return "Complexo";
            }
            default:{
                return "";
            }
        }
    }

}
