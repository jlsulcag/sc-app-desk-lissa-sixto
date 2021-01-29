
package lissa.dao;

import java.util.ArrayList;
import lissa.be.TipoMedico;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TipoMedicoDao {
    private Session sesion;
    private Transaction tx;
    private TipoMedico obj;
    
    public ArrayList<TipoMedico> listar() throws HibernateException {
        ArrayList<TipoMedico> list = null;

        try {
            iniciarOperacion();
            String hql = "from TipoMedico";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<TipoMedico>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        return list;
    }
    
    public TipoMedico buscar(Integer id) throws HibernateException{
        try {
            iniciarOperacion();
            obj = (TipoMedico) sesion.get(TipoMedico.class, id);
        } catch (HibernateException he) {
            manejaExcepcion(he);
        }finally{
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
}
