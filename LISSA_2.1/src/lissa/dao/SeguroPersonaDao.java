/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.SeguroVidaUsaPersona;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Jorge Luis Sulca González
 */
public class SeguroPersonaDao {

    private Session sesion;
    private Transaction tx;

    SeguroVidaUsaPersona obj = null;

    public int registrar(SeguroVidaUsaPersona obj) {
        int id = 0;
        try {
            iniciarOperacion();
            //retorna  el id registrado del objeto
            id = (int) sesion.save(obj);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return id;
    }

    public void actualizar(SeguroVidaUsaPersona obj) throws HibernateException {
        try {
            iniciarOperacion();
            sesion.update(obj);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
            System.out.println("Finalizo la actualizacion");
        }
    }

    public void eliminar(SeguroVidaUsaPersona obj) throws HibernateException {
        try {
            iniciarOperacion();
            sesion.delete(obj);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
    }

    public SeguroVidaUsaPersona buscar(long id) throws HibernateException {

        try {
            iniciarOperacion();
            obj = (SeguroVidaUsaPersona) sesion.get(SeguroVidaUsaPersona.class, id);
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return obj;
    }

    public List<SeguroVidaUsaPersona> listar() throws HibernateException {
        List<SeguroVidaUsaPersona> list = null;

        try {
            iniciarOperacion();
            String hql = "from Persona";
            Query query = sesion.createQuery(hql);
            list = query.list();
        } catch (HibernateException e) {
        } finally {
            sesion.close();
        }
        return list;
    }

    

    public ArrayList<SeguroVidaUsaPersona> listar(long id) {
        ArrayList<SeguroVidaUsaPersona> list = null;
        try {
            iniciarOperacion();
            String hql = "from SeguroVidaUsaPersona sv left join fetch sv.persona p where p.idpersona=" + id;
            list = (ArrayList<SeguroVidaUsaPersona>) sesion.createQuery(hql).list();               
        } catch (HibernateException e) {
            list = new ArrayList<SeguroVidaUsaPersona>();
            manejaExcepcion(e);
        }finally{
            sesion.close();
        }
        return list;
    }

    public ArrayList<SeguroVidaUsaPersona> buscar(String ref) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ArrayList<SeguroVidaUsaPersona> list = null;

        list = (ArrayList<SeguroVidaUsaPersona>) session.createQuery("from Participante p where p.nombres  like '%" + ref + "%'").list();
        if (list.isEmpty()) {
            list = (ArrayList<SeguroVidaUsaPersona>) session.createQuery("from Persona p where p.dni like '%" + ref + "%'").list();
        }
        session.getTransaction().commit();
        return list;
    }

    public void eliminar(int idSeguroVida) throws HibernateException {
        SessionFactory fact = new Configuration().configure().buildSessionFactory();
        sesion = fact.openSession();
        String hql = "delete from SeguroVidaUsaPersona svup where svup.idSeguroVida=" + idSeguroVida;
        Query query = sesion.createQuery(hql);
        query.executeUpdate();
        tx.commit();
    }

    public SeguroVidaUsaPersona buscarSeguroPersona(long idPersona, int idSeguro) {
        iniciarOperacion();
        String hql = "from SeguroVidaUsaPersona svp where svp.persona.idpersona = :id_Persona and svp.seguroVida.idSeguroVida = :id_Seguro";
        Query query = sesion.createQuery(hql);
        query.setParameter("id_Persona", idPersona);
        query.setParameter("id_Seguro", idSeguro);
        return (SeguroVidaUsaPersona) query.uniqueResult();        
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
