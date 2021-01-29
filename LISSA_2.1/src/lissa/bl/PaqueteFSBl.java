
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.PaqueteFondoSolidaridad;
import lissa.dao.PaqueteFSDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class PaqueteFSBl extends AbstractBL<PaqueteFondoSolidaridad>{
    private PaqueteFSDao dao;
    
    @Override
    public AbstractDA getDAO() {
        dao = new PaqueteFSDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (PaqueteFSDao) dao;
    }

    @Override
    public PaqueteFondoSolidaridad registrar(PaqueteFondoSolidaridad bean) {
        return save(bean);
    }

    @Override
    public int actualizar(PaqueteFondoSolidaridad bean) {
        return update(bean);
    }

    @Override
    public int eliminar(PaqueteFondoSolidaridad bean) {
        return delete(bean);
    }

    @Override
    public List<PaqueteFondoSolidaridad> listar() {
        return list();
    }

    @Override
    public ArrayList<PaqueteFondoSolidaridad> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<PaqueteFondoSolidaridad> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PaqueteFondoSolidaridad buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PaqueteFondoSolidaridad buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
