package lissa.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import lissa.be.TipoDocidentidad;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TipoDocIdentidadDao {

    private Session sesion;
    private Transaction tx;
    private TipoDocidentidad obj = null;
    private ArrayList<TipoDocidentidad> list;

    public ArrayList<TipoDocidentidad> listar() throws HibernateException {
        list = new ArrayList<>();
        try {
            iniciarOperacion();
            String hql = "from TipoDocidentidad";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<TipoDocidentidad>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            list = new ArrayList<>();
        } finally {
            cerrarSesion();
        }
        return list;
    }

    private void iniciarOperacion() throws HibernateException {
        if (sesion != null) {
            sesion.close();
        } else {
            sesion = HibernateUtil.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
        }
    }
    
    public void cerrarSesion() {
        sesion.close();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        Mensajes.ErrorFatal(he);
    }
}
