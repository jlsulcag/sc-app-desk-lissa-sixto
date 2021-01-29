package lissa.dao;

import java.util.ArrayList;
import lissa.be.EstadoCivil;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EstadoCivilDao {

    private Session sesion;
    private Transaction tx;
    private EstadoCivil obj = null;
    private ArrayList<EstadoCivil> list;

    public ArrayList<EstadoCivil> listar() throws HibernateException {
        try {
            iniciarOperacion();
            String hql = "from EstadoCivil";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<EstadoCivil>) query.list();
        } catch (HibernateException e) {
            list = new ArrayList<>();
            manejaExcepcion(e);
        } finally {
            sesion.close();
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
