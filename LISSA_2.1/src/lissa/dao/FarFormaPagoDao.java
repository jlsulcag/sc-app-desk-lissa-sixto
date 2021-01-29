
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.FarFormaPago;
import lissa.util.AbstractDA;

public class FarFormaPagoDao extends AbstractDA<FarFormaPago>{

    @Override
    public FarFormaPago registrar(FarFormaPago bean) {
        return save(bean);
    }

    @Override
    public int actualizar(FarFormaPago bean) {
        return update(bean);
    }

    @Override
    public int eliminar(FarFormaPago bean) {
        return delete(bean);
    }

    @Override
    public List<FarFormaPago> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<FarFormaPago> listar(String hql) {
        hql = "from FarFormaPago fp order by fp.formaPago asc";
        return list(hql);
    }

    @Override
    public List<FarFormaPago> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FarFormaPago buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FarFormaPago buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
