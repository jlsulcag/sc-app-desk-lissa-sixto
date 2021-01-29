package lissa.dao;

import java.util.ArrayList;
import lissa.be.Atencionhc;
import lissa.be.HistoriaClinica;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AtencionDao {
    private Session sesion;
    private Transaction tx;
    Atencionhc obj = null;
    private ArrayList<Atencionhc> listAtenciones;

    public Atencionhc registrar(Atencionhc obj) throws HibernateException {
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

    public void actualizar(Atencionhc obj) throws HibernateException {
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
    
    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public Atencionhc buscar(Integer id) {
        try {
            iniciarOperacion();
            //String hql = "from Paciente pac inner join fetch pac.persona p where p.idPersona=" + id;
            //Query query = sesion.createQuery(hql);
            //obj = (Atencion2) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return obj;
    }

//    public Atencion2 buscarUltimaAtencion(int idhistoriaclinica) {
//        obj = new Atencion2();
//        try {
//            iniciarOperacion();
//            String hql = "select aten from Atencion2 aten inner join aten.historiaClinica hc where hc.idhistoriaclinica = "+ idhistoriaclinica + "and aten.fechaAtencion = (select max(aten2.fechaAtencion) from Atencion2 aten2)";
//            Query query = sesion.createQuery(hql);
//            obj = (Atencion2) query.uniqueResult();
//        } catch (HibernateException e) {
//            manejaExcepcion(e);
//        }
//        return obj;
//    }

    public ArrayList<Atencionhc> listar(HistoriaClinica hc) {
        try {
            iniciarOperacion();
            String hql = "select aten from Atencion aten inner join aten.historiaClinica hc where hc.idhistoriaclinica = "+ hc.getIdhistoriaclinica() + " order by aten.fechaAtencion desc, aten.idAtencion desc";
            Query query = sesion.createQuery(hql);
            listAtenciones = (ArrayList<Atencionhc>) query.list();
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        }
        finally{
            sesion.close();
        }
        return listAtenciones;
    }
}

