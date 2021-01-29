
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Permiso;
import lissa.util.AbstractDA;

public class PermisoDao extends AbstractDA<Permiso>{

    @Override
    public Permiso registrar(Permiso bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Permiso bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Permiso bean) {
        return delete(bean);
    }

    @Override
    public List<Permiso> listar() {
        return list(Permiso.class);
    }

    @Override
    public ArrayList<Permiso> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<Permiso> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Permiso buscar(long id) {
        return search(Permiso.class, id);
    }

    @Override
    public Permiso buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId(Permiso.class);
    }
    
}
