
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.DetalleVenta;
import lissa.be.Venta;
import lissa.dao.DetalleVentaDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class DetalleVentaBl extends AbstractBL<DetalleVenta>{
    private DetalleVentaDao dao;
    @Override
    public AbstractDA getDAO() {
        dao = new DetalleVentaDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (DetalleVentaDao) dao;
    }

    @Override
    public DetalleVenta registrar(DetalleVenta bean) {
        return save(bean);
    }

    @Override
    public int actualizar(DetalleVenta bean) {
        return update(bean);
    }

    @Override
    public int eliminar(DetalleVenta bean) {
        return delete(bean);
    }

    @Override
    public List<DetalleVenta> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleVenta> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleVenta> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleVenta buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleVenta buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<DetalleVenta> listarXVenta(Venta oVenta) {
        dao = new DetalleVentaDao();
        return dao.listarXVenta(oVenta);
    }
    
    public List<DetalleVenta> listarDetallesxidVenta(long idVenta){
        dao = new DetalleVentaDao();
        return dao.listarDetallesxidVenta(idVenta);
    }
    
}
