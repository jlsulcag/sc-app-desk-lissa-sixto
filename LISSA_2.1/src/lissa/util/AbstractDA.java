package lissa.util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class AbstractDA<T> implements DAO<T> {

    private static final int SUCCESS = 0, ERROR = -1;    
    private Session s;
    private Transaction t;
    
    private void iniciarOperacion() {
        s = HibernateUtil.getSessionFactory().openSession();//Abre una nueva sesion
        //s = HibernateUtil.getSessionFactory().getCurrentSession();
        t = s  .beginTransaction();
        
    }

    private void manejaExcepcion(HibernateException he) {
        t.rollback();
        //throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
        JOptionPane.showMessageDialog(null, ""+he, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Deprecated
    public T save(T bean) {
        try {
            iniciarOperacion();
            s.save(bean);
            t.commit();
            s.close();
            return bean;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        }
    }

    @Deprecated
    public int update(T bean) {
        try {
            iniciarOperacion();
            s.update(bean);
            t.commit();
            s.close();
            return SUCCESS;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return   ERROR;
        }
    }

    @Deprecated
    public int delete(T bean) {
        try {
            iniciarOperacion();
            s.delete(bean);
            t.commit();
            s.close();
            return SUCCESS;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return ERROR;
        }
    }

    @Deprecated
    public List<T> list(Class c) {
        try {
            iniciarOperacion();
            List<T> l = s.createQuery("from " + c.getSimpleName()).list();
            t.commit();
            s.close();
            return l;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        }
    }  


    @Deprecated
    public ArrayList<T> list(String query) {
        try {
            iniciarOperacion();
            Query q = s.createQuery(query);
            ArrayList<T> l = (ArrayList) q.list();
            t.commit();
            //s.close();
            return l;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        }
    }
        

//    @Deprecated
//    public List<T> list(Class cd, Class cm, long id) {
//        try {
//            Query q = s.createQuery("from " + cd.getSimpleName() + " where id_" + cm.getSimpleName().toLowerCase() + "=:id");
//            q.setParameter("id", id);
//            List<T> l = (List) q.list();
//            t.commit();
//            s.close();
//            return l;
//        } catch (HibernateException e) {
//            t.rollback();
//            e.printStackTrace();
//            return null;
//        }
//    }

    @Deprecated
    public T search(Class c, long id) {
        try {
            iniciarOperacion();
            Query q = s.createQuery("from " + c.getSimpleName() + " where id" + c.getSimpleName().toLowerCase() + "=:id");
            q.setParameter("id", id);
            List<T> l = (List) q.list();
            t.commit();
            //s.close();
            for (T t1 : l) {
                return t1;
            }
            return null;
        } catch (HibernateException e) {
            t.rollback();
            manejaExcepcion(e);
            return null;
        }
    }

    @Deprecated
    public T search(String query) {
        try {
            iniciarOperacion();
            Query q = s.createQuery(query);
            T obj = (T) q.uniqueResult();
            t.commit();
            s.close();
            return obj;
        } catch (HibernateException e) {
            t.rollback();            
            manejaExcepcion(e);            
            return null;
        }
    }

    @Deprecated
    public long maxId(Class c) {
        try {
            List<T> l = (List) s.createQuery("max(id" + c.getSimpleName().toLowerCase() + ") from " + c.getSimpleName()).list();
            t.commit();
            s.close();
            return l.size() > 0 ? l.size() + 1 : 1;
        } catch (HibernateException e) {
            t.rollback();
            e.printStackTrace();
            return 0;
        }
    }
}
