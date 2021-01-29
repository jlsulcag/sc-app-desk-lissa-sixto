
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.TipoOperacion;
import lissa.util.AbstractDA;

public class TipoOperacionDao extends AbstractDA<TipoOperacion>{

    @Override
    public TipoOperacion registrar(TipoOperacion bean) {
        return save(bean);
    }

    @Override
    public int actualizar(TipoOperacion bean) {
        return update(bean);
    }

    @Override
    public int eliminar(TipoOperacion bean) {
        return delete(bean);
    }

    @Override
    public List<TipoOperacion> listar() {
        return list(TipoOperacion.class);
    }

    @Override
    public ArrayList<TipoOperacion> listar(String hql) {
        hql = "from TipoOperacion a order by a.operacion";
        return list(hql);
    }

    @Override
    public List<TipoOperacion> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoOperacion buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoOperacion buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
