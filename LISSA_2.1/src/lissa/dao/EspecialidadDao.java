
package lissa.dao;

import java.util.ArrayList;
import lissa.be.Especialidad;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EspecialidadDao {
    private Session sesion;
    private Transaction tx;
    private Especialidad obj;
    
    public ArrayList<Especialidad> listar() throws HibernateException {
        ArrayList<Especialidad> list = null;

        try {
            iniciarOperacion();
            String hql = "from Especialidad";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Especialidad>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } finally {
            sesion.close();
        }
        return list;
    }
    
    public Especialidad buscar(Integer id) throws HibernateException {
        try {
            iniciarOperacion();
            obj = (Especialidad) sesion.get(Especialidad.class, id);
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return obj;
    }
    
    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public Especialidad registrar(Especialidad obj) throws HibernateException{
        try {
            iniciarOperacion();
            sesion.save(obj);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return obj;
    }
}
