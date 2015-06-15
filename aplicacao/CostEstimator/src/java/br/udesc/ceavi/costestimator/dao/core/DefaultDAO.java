package br.udesc.ceavi.costestimator.dao.core;

import java.util.List;

/**
 *
 * @author diego
 * @param <T>
 */
public interface DefaultDAO<T> {

    public void salvar(T t);
    public void remover(int id);
    public List<T> listar();
    public T buscar(int id);
    
}
