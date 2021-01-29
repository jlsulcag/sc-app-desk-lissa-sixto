/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.SeguroVida;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jorge Luis Sulca González
 */
public class SeguroDao {

    private SeguroVida oSeguroVida;
    private List<SeguroVida> listSeguroVida;
    private Session session = HibernateUtil.getSessionFactory().openSession();

    private Session sesion;
    private Transaction tx;
    public static final int SUCCESS = 1;
    public static final int ERROR = 0;

    SeguroVida obj = null;

    public SeguroVida registrarSeguro(SeguroVida obj) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        return obj;

    }

    public List<SeguroVida> listar() throws HibernateException {
        List<SeguroVida> list = null;
        try {
            iniciarOperacion();
            String hql = "from SeguroVida a where a.estado = true";
            Query query = sesion.createQuery(hql);
            list = query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } finally {
            sesion.close();
        }
        return list;
    }

    public void eliminar(SeguroVida obj) throws HibernateException {
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

    public SeguroVida buscar(int id) throws HibernateException {
        try {
            iniciarOperacion();
            obj = (SeguroVida) sesion.get(SeguroVida.class, id);
        } catch (HibernateException he) {
            
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return obj;
    }

    private void iniciarOperacion() throws HibernateException {
        if (sesion != null) {
            sesion.close();
        } else {
            sesion = HibernateUtil.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
        }
    }

    public ArrayList<SeguroVida> buscarF(String ref) {
        ArrayList<SeguroVida> list = null;
        try {
            iniciarOperacion();
            list = (ArrayList<SeguroVida>) sesion.createQuery("from SeguroVida p where (p.descripcion) like '%" + ref + "%'").list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        tx.commit();
        return list;
    }

    public int actualizar(SeguroVida obj)throws HibernateException {
       int result = 0;
        try {
            iniciarOperacion();
            sesion.update(obj);
            tx.commit();
            result = SUCCESS;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            result = ERROR;
        } finally {
            sesion.close();
        }
        return result;
    }
    
    public void cerrarSesion() {
        sesion.close();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        Mensajes.ErrorFatal(he);
    }

}
