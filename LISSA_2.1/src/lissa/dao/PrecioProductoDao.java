
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.PrecioProducto;
import lissa.util.AbstractDA;

public class PrecioProductoDao extends AbstractDA<PrecioProducto>{

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
        return list(PrecioProducto.class);
    }

    @Override
    public ArrayList<PrecioProducto> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<PrecioProducto> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PrecioProducto buscar(long id) {
        return search(PrecioProducto.class, id);
    }

    @Override
    public PrecioProducto buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId(PrecioProducto.class);
    }

    public PrecioProducto buscarxIdAlmacenProducto(Long idalmacenproducto) {
        String hql = "from PrecioProducto a left join fetch a.almacenProducto b where b.idalmacenproducto="+idalmacenproducto+" and a.estado = 1";
        return buscar(hql);
    }
    
}
