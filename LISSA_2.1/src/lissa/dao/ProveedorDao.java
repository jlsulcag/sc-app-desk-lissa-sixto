
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Proveedor;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author SISTEMAS
 */
public class ProveedorDao  extends AbstractDA<Proveedor>{
     private Session sesion;
    private Transaction tx;
    private ArrayList<Proveedor> list = null;
    private Proveedor oProveedor;
    
    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public ArrayList<Proveedor> listar() {
        try {
            iniciarOperacion();
            String hql = "from Proveedor";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Proveedor>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } 
//        finally {
//            sesion.close();
//        }
        return list;
    }

    public Proveedor buscar(String ruc) {
        oProveedor = new Proveedor();
        try {
            iniciarOperacion();
            String hql = "select pro from Proveedor pro inner join pro.personaJuridica pj where pj.numeroRuc='" + ruc + "'";
            Query query = sesion.createQuery(hql);
            oProveedor = (Proveedor) query.uniqueResult();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }       
        return oProveedor;
    }

    public ArrayList<Proveedor> listar(String rs) {
        try {
            iniciarOperacion();
            String hql = "select pro from Proveedor pro inner join pro.personaJuridica pj where pj.razonSocial like '%"+rs+"%'";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Proveedor>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } 
//        finally {
//            sesion.close();
//        }
        return list;
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
        return search(Proveedor.class, id);
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
