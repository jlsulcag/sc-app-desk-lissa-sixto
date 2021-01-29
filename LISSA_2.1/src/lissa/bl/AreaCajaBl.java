
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.AreaCaja;
import lissa.dao.AreaCajaDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;




public class AreaCajaBl extends AbstractBL<AreaCaja>{
    private AreaCajaDao dao;
    
    public AreaCajaBl(){
        
    }
    
    @Override
    public AbstractDA getDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDA(AbstractDA dao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AreaCaja registrar(AreaCaja bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(AreaCaja bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(AreaCaja bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AreaCaja> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AreaCaja> listar(String hql) {
      dao = new AreaCajaDao();
      return dao.listar(hql);
    }

    @Override
    public List<AreaCaja> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AreaCaja buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AreaCaja buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
