
package lissa.util;

import java.util.List;

public interface IDaoGeneric<T> {
    
    public T registrar(T obj) throws Exception;
    public int actualizar(T obj)throws Exception;
    public int eliminar(T obj)throws Exception;
    public List<T> listar()throws Exception;
    public List<T> listar(long id)throws Exception;
    public T buscar(long id)throws Exception;
    public T buscar(String ref)throws Exception;
    
}
