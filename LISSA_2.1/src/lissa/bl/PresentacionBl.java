
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Presentacion;
import lissa.dao.PresentacionDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class PresentacionBl extends AbstractBL<Presentacion>{
   // private PresentacionDao dao;
    private PresentacionDao dao;
    
    //.....
    //private PresentacionDao daoFamilia;
    private ArrayList<Presentacion> list;
    //.....

    @Override
    public AbstractDA getDAO() {
        dao = new PresentacionDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (PresentacionDao) dao;
    }

    @Override
    public Presentacion registrar(Presentacion bean) {
        return save(bean);
    }
//
    @Override
    public int actualizar(Presentacion obj) {
        return update(obj);
    }
//
    @Override
    public int eliminar(Presentacion bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Presentacion> listar(String hql) {
        dao = new PresentacionDao();
        return dao.listar(hql);
    }

    @Override
    public List<Presentacion> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Presentacion buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Presentacion buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    ///
     public ArrayList<Presentacion> buscarF(String ref) {
        dao = new PresentacionDao();
        list = dao.buscarF(ref);
        return list;
    }
    ///

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Presentacion> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
