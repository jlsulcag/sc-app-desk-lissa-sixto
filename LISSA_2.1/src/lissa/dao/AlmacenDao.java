
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Almacen;
import lissa.util.AbstractDA;

public class AlmacenDao extends AbstractDA<Almacen>{

    @Override
    public Almacen registrar(Almacen bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Almacen bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Almacen bean) {
        return delete(bean);
    }

    @Override
    public List<Almacen> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Almacen> listar(String hql) {
        hql = "from Almacen A order by A.nombre asc"                      ;
        return list(hql);
    }

    @Override
    public List<Almacen> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Almacen buscar(long id) {
        return search(Almacen.class, id);
    }

    @Override
    public Almacen buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
