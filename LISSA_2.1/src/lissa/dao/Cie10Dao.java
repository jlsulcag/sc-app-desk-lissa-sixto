
package lissa.dao;

import java.util.ArrayList;
import lissa.be.Cie10;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Cie10Dao {
    private Session sesion;
    private Transaction tx;
    Cie10 obj = null;

    public Cie10 registrar(Cie10 oCie10) throws HibernateException {
        try {
            iniciarOperacion();
            sesion.save(oCie10);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return oCie10;
    }

    public void actualizar(Cie10 obj) throws HibernateException {
        try {
            iniciarOperacion();
            sesion.update(obj);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
    }
    
    public ArrayList<Cie10> buscar(String ref) {
        ArrayList<Cie10> list = null;
        try {
            iniciarOperacion();
            list = (ArrayList<Cie10>) sesion.createQuery("from Cie10 c where c.codigo like '%" + ref + "%'").list();

            if (list.isEmpty()) {
                list = (ArrayList<Cie10>) sesion.createQuery("from Cie10 c where c.descripcion like '%" + ref + "%'").list();
            }
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        tx.commit();
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

    public Cie10 buscar(Integer id) {
        try {
            iniciarOperacion();
            //String hql = "from Paciente pac inner join fetch pac.persona p where p.idPersona=" + id;
            //Query query = sesion.createQuery(hql);
            //obj = (Atencion) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return obj;
    }

    public Cie10 buscarXid(int idCie10) {
        try {
            iniciarOperacion();
            String hql = "from Cie10 cie where cie.idCie10=" + idCie10;
            Query query = sesion.createQuery(hql);
            obj = (Cie10) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return obj;
    }
}
