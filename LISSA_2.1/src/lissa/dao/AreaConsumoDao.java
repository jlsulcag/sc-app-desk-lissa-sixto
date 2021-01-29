
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.AreaConsumo;
import lissa.util.AbstractDA;

public class AreaConsumoDao extends AbstractDA<AreaConsumo>{

    @Override
    public AreaConsumo registrar(AreaConsumo bean) {
        return save(bean);
    }

    @Override
    public int actualizar(AreaConsumo bean) {
        return update(bean);
    }

    @Override
    public int eliminar(AreaConsumo bean) {
        return delete(bean);
    }

    @Override
    public List<AreaConsumo> listar() {
        return list(AreaConsumo.class);
    }

    @Override
    public ArrayList<AreaConsumo> listar(String hql) {
        hql = "from AreaConsumo";
        return list(hql);
    }

    @Override
    public List<AreaConsumo> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AreaConsumo buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AreaConsumo buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
