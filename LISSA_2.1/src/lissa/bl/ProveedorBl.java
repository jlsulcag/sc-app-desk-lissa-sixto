package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Proveedor;
import lissa.dao.ProveedorDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

/**
 *
 * @author SISTEMAS
 */
public class ProveedorBl extends AbstractBL<Proveedor> {

    private ProveedorDao dao;

    @Override
    public AbstractDA getDAO() {
        dao = new ProveedorDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (ProveedorDao) dao;
    }

    @Override
    public Proveedor registrar(Proveedor bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Proveedor bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Proveedor bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proveedor> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Proveedor buscar(long id) {
        return search(id);
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Proveedor> listar() {
        dao = new ProveedorDao();
        return dao.listar();
    }

    @Override
    public Proveedor buscar(String ruc) {
        dao = new ProveedorDao();
        return dao.buscar(ruc);
    }

    @Override
    public ArrayList<Proveedor> listar(String rs) {
        dao = new ProveedorDao();
        return dao.listar(rs);
    }


}
