
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Tarifario;
import lissa.util.AbstractDA;

public class TarifarioDao extends AbstractDA<Tarifario>{

    @Override
    public Tarifario registrar(Tarifario bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Tarifario bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Tarifario bean) {
        return delete(bean);
    }

    @Override
    public List<Tarifario> listar() {
        return list(Tarifario.class);
    }

    @Override
    public ArrayList<Tarifario> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<Tarifario> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tarifario buscar(long id) {
        return search(Tarifario.class, id);
    }

    @Override
    public Tarifario buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId(Tarifario.class);
    }

    public ArrayList listarFull() {
        String hql = "from Tarifario";
        return listar(hql);
    }
    
}
