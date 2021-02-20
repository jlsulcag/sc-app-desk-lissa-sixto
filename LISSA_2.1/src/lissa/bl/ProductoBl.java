
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Producto;
import lissa.dao.ProductoDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class ProductoBl extends AbstractBL<Producto>{
    private ProductoDao dao;
    @Override
    public AbstractDA getDAO() {
        dao = new ProductoDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (ProductoDao) dao;        
    }

    @Override
    public Producto registrar(Producto bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Producto bean) {
        return (int) update(bean);
    }

    @Override
    public int eliminar(Producto bean) {
        return (int) delete(bean);
    }

    @Override
    public List<Producto> listar() {
        return list();
    }

    @Override
    public List<Producto> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Producto> listar(String hql) {
        dao = new ProductoDao();
        return dao.listar(hql);
    }
    
    public ArrayList<Producto> listRef(String ref, int op){
        dao = new ProductoDao();
        return dao.listarRef(ref, op);
    }
    
}
