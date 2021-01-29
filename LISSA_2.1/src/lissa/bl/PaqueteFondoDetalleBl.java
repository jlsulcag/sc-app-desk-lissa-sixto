
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.PaqueteFondoDetalle;
import lissa.dao.PaqueteFondoDetalleDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class PaqueteFondoDetalleBl extends AbstractBL<PaqueteFondoDetalle>{
    private PaqueteFondoDetalleDao dao;
    @Override
    public AbstractDA getDAO() {
        dao = new PaqueteFondoDetalleDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (PaqueteFondoDetalleDao) dao;
    }

    @Override
    public PaqueteFondoDetalle registrar(PaqueteFondoDetalle bean) {
        return save(bean);
    }

    @Override
    public int actualizar(PaqueteFondoDetalle bean) {
        return update(bean);
    }

    @Override
    public int eliminar(PaqueteFondoDetalle bean) {
        return delete(bean);
    }

    @Override
    public List<PaqueteFondoDetalle> listar() {
        return list();
    }

    @Override
    public ArrayList<PaqueteFondoDetalle> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PaqueteFondoDetalle> listar(long id) {
        return list(id);
    }

    @Override
    public PaqueteFondoDetalle buscar(long id) {
        return search(id);
    }

    @Override
    public PaqueteFondoDetalle buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<PaqueteFondoDetalle> listarxIdPaquete(int id){
        dao = new PaqueteFondoDetalleDao();
        return dao.listarxIdPaquete(id);
    }

    public PaqueteFondoDetalle buscarxId(int id) {
        dao = new PaqueteFondoDetalleDao();
        return dao.buscarxId(id);
    }
    
}
