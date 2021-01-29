
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.TipoOperacion;
import lissa.dao.TipoOperacionDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class TipoOperacionBl extends AbstractBL<TipoOperacion>{
    private TipoOperacionDao dao;
    
    @Override
    public AbstractDA getDAO() {
        dao = new TipoOperacionDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (TipoOperacionDao) dao;
    }

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
        return list();
    }

    @Override
    public ArrayList<TipoOperacion> listar(String hql) {
        dao = new TipoOperacionDao();
        return dao.listar(hql);
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
