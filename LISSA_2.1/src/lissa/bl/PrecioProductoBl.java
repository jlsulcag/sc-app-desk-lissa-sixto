
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.PrecioProducto;
import lissa.dao.PrecioProductoDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class PrecioProductoBl extends AbstractBL<PrecioProducto>{

    private PrecioProductoDao dao;
    
    @Override
    public AbstractDA getDAO() {
        dao = new PrecioProductoDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (PrecioProductoDao) dao;
    }

    @Override
    public PrecioProducto registrar(PrecioProducto bean) {
        return save(bean);
    }

    @Override
    public int actualizar(PrecioProducto bean) {
        return update(bean);
    }

    @Override
    public int eliminar(PrecioProducto bean) {
        return delete(bean);
    }

    @Override
    public List<PrecioProducto> listar() {
        return list();
    }

    @Override
    public ArrayList<PrecioProducto> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<PrecioProducto> listar(long id) {
        return list(id);
    }

    @Override
    public PrecioProducto buscar(long id) {
        return search(id);
    }

    @Override
    public PrecioProducto buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }

    public PrecioProducto buscarxIdAlmacenProducto(Long idalmacenproducto) {
        dao = new PrecioProductoDao();
        return dao.buscarxIdAlmacenProducto(idalmacenproducto);
    }
    
}
