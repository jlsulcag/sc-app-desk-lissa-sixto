
package lissa.util;

import java.util.ArrayList;
import java.util.List;

public interface DAO<Tipo>{   
    public Tipo registrar(Tipo bean);
    public int actualizar(Tipo bean);
    public int eliminar(Tipo bean);  
    public List<Tipo> listar();
    //public List<Tipo> listar(Class c);
    public ArrayList<Tipo> listar(String hql);
    public List<Tipo> listar(long id);
    public Tipo buscar(long id);  
    public Tipo buscar(String ref);
    public long id();      
}
