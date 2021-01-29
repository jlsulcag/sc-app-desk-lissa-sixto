package lissa.dao;

import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BoletaDao {
    
    private Session sesion;
    private Transaction tx;

    public long obtenerUltNumero(int id) {
        iniciarOperacion();
        long num = 0;
        String hql = "select max(c.numero) from Comprobante c where c.grupoNumeracion="+id;
        Query query = sesion.createQuery(hql);
        if(query.uniqueResult() == null){
            num = 0;
        }else{
            num = (long) query.uniqueResult();
        }        
        tx.commit();
        return num;
    }
    
    public int obtenerNumeroOperacion() {
        iniciarOperacion();
        int num = 0;
        String hql = "select max(c.numeroOperacion) from Comprobante as c";
        Query query = sesion.createQuery(hql);       
        if(query.uniqueResult() == null){
            num = 0;
        }else{
            num = (Integer) query.uniqueResult();
        }   
        tx.commit();
        return num;
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
