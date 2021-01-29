
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.TipoPersona;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TipoPersonaDao{
    
    private Session sesion;
    private Transaction tx;
    private TipoPersona obj;
    private ArrayList<TipoPersona> listTipoPersonas;
    
    public TipoPersona buscarxId(long id){
        try {
            iniciarOperacion();
            String hql = "from TipoPersona a where a.estado =:sts and a.idtipopersona = :id";
            Query query = sesion.createQuery(hql);
            query.setParameter("sts", 1);
            query.setParameter("id", id);
            obj = (TipoPersona) query.uniqueResult();
            tx.commit();
            return obj;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        }finally{
            sesion.close();
        }
    }
    
    public ArrayList<TipoPersona> listar() {
        try {
            iniciarOperacion();
            String hql = "from TipoPersona a where a.estado =:sts";
            Query query = sesion.createQuery(hql);
            query.setParameter("sts", 1);
            listTipoPersonas = (ArrayList<TipoPersona>) query.list();
            tx.commit();            
        } catch (HibernateException e) {
            manejaExcepcion(e);
            listTipoPersonas = null;
        }finally{
            sesion.close();
        }
        return listTipoPersonas;
    }
    
    private  void iniciarOperacion() throws HibernateException{
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }
    
    private void manejaExcepcion(HibernateException he) throws HibernateException{
        tx.rollback();
        Mensajes.ErrorFatal(he);
    }

    
}
