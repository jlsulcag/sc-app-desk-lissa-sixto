package lissa.dao;

import java.util.ArrayList;
import lissa.be.PersonaJuridica;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonaJuridicaDao {

    private Session sesion;
    private Transaction tx;
    private PersonaJuridica obj;
    public static final int SUCCESS = 1, ERROR = 2;
    private ArrayList<PersonaJuridica> list;

    public PersonaJuridica registrar(PersonaJuridica bean) throws HibernateException {
        try {
            iniciarOperacion();
            sesion.save(bean);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        }
//        finally {
//            sesion.close();
//        }
        return bean;
    }

    public int actualizar(PersonaJuridica obj) throws HibernateException {
        try {
            iniciarOperacion();
            sesion.merge(obj);
            tx.commit();
            return SUCCESS;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            return ERROR;
        } finally {
            sesion.close();
        }
    }

    public ArrayList<PersonaJuridica> buscarPersonaJuridica(String ref) {
        ArrayList<PersonaJuridica> list = null;
        try {
            iniciarOperacion();
            list = (ArrayList<PersonaJuridica>) sesion.createQuery("from PersonaJuridica p where p.razonSocial like '%" + ref + "%'").list();            
            tx.commit();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        return list;
    }
    
    public PersonaJuridica buscarxRuc(String ruc) {
        obj = new PersonaJuridica();
        try {
            iniciarOperacion();
            String hql = "from PersonaJuridica as pj where pj.numeroRuc='" + ruc + "'";
            Query query = sesion.createQuery(hql);
            obj = (PersonaJuridica) query.uniqueResult();
        } catch (HibernateException e) {
            manejaExcepcion(e);
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
