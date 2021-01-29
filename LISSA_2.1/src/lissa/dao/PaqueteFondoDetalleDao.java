
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.PaqueteFondoDetalle;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PaqueteFondoDetalleDao extends AbstractDA<PaqueteFondoDetalle>{
    private Session sesion;
    private Transaction tx;
    private ArrayList<PaqueteFondoDetalle> list;
    public static final int SUCCESS = 1;
    public static final int ERROR = 0;
    private PaqueteFondoDetalle obj;
    
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
        return list(PaqueteFondoDetalle.class);
    }

    @Override
    public ArrayList<PaqueteFondoDetalle> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PaqueteFondoDetalle> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PaqueteFondoDetalle buscar(long id) {
        return search(PaqueteFondoDetalle.class, id);
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
        try {
            iniciarOperacion();
            String hql = "from PaqueteFondoDetalle p where p.paqueteFondoSolidaridad.idpaquetefs=:id";
            Query q = sesion.createQuery(hql);
            q.setParameter("id", id);
            list = (ArrayList<PaqueteFondoDetalle>) q.list();
            tx.commit();
            sesion.close();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            list = null;
        }
        return list;
    }
    
    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public PaqueteFondoDetalle buscarxId(int id) {
        try {
            iniciarOperacion();
            String hql = "select a from PaqueteFondoDetalle a where a.idpaquetefondo=:id";
            Query q = sesion.createQuery(hql);
            q.setParameter("id", id);
            obj =  (PaqueteFondoDetalle) q.uniqueResult();
            tx.commit();
            sesion.close();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            obj = null;
        }
        return obj;
    }
    
}
