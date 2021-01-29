
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Caja;
import lissa.be.Producto;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductoDao extends AbstractDA<Producto>{
    private Session sesion;
    private Transaction tx;
    private Caja obj = null;
    private ArrayList<Producto> list;
    
    @Override
    public Producto registrar(Producto bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Producto bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Producto bean) {
        return delete(bean);
    }

    @Override
    public List<Producto> listar() {
        return listar();
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
        hql = "from Producto";
        return list(hql);
    }
    
    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public ArrayList<Producto> listarRef(String ref) {
        try {
            iniciarOperacion();
            String hql = "from Producto p where p.nombre like '%"+ref+"%'";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Producto>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
//        finally{
//            sesion.close();
//        }
        return list;
    }
    
}
