
package lissa.dao;

import lissa.be.Atencion;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDao {
    private Session sesion;
    private Transaction tx;
    private Atencion oUsuario;

    public int registrar(Atencion obj) {
        int id = 0;
        try {
            iniciarOperacion();
            //retorna  el id registrado del objeto
            id = (int)sesion.save(obj);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return id;
    }
    
    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
}
