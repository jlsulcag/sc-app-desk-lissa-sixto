
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Compra;
import lissa.be.DetalleCompra;
import lissa.dao.DetalleCompraDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

/**
 *
 * @author JSULCAG
 */
public class DetalleCompraBl extends AbstractBL<DetalleCompra>{
    private DetalleCompraDao dao;
    @Override
    public AbstractDA getDAO() {
        dao = new DetalleCompraDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (DetalleCompraDao) dao;
    }

    @Override
    public DetalleCompra registrar(DetalleCompra bean) {
        return save(bean);
    }

    @Override
    public int actualizar(DetalleCompra bean) {
        return update(bean);
    }

    @Override
    public int eliminar(DetalleCompra bean) {
        return delete(bean);
    }

    @Override
    public List<DetalleCompra> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleCompra> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleCompra> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleCompra buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleCompra buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<DetalleCompra> listarXCompra(Compra oCompra) {
        dao = new DetalleCompraDao();
        return dao.listarXCompra(oCompra);
    }
    
    public DetalleCompra buscarXId(DetalleCompra obj) {
        dao = new DetalleCompraDao();
        return dao.buscarXId(obj);
    }
    
}
