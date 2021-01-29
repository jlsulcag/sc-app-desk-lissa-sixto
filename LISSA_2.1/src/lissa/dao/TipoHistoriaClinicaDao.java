package lissa.dao;

import java.util.ArrayList;
import lissa.be.TipoHistoriaClinica;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TipoHistoriaClinicaDao {

    private Session sesion;
    private Transaction tx;
    private TipoHistoriaClinica obj = null;
    private ArrayList<TipoHistoriaClinica> list;

    public ArrayList<TipoHistoriaClinica> listar() throws HibernateException {
        try {
            iniciarOperacion();
            String hql = "from TipoHistoriaClinica";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<TipoHistoriaClinica>) query.list();
        } catch (HibernateException e) {
            list = new ArrayList<>();
            manejaExcepcion(e);
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
