
package lissa.dao;

import java.util.ArrayList;
import lissa.be.Rol;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RolDao {
    
    private Session session;
    private Session sesion;
    private Transaction tx;

    Rol obj = null;

    public int registrar(Rol obj) {
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
    
    public ArrayList<Rol> listar() throws HibernateException {
        ArrayList<Rol> list = null;

        try {
            iniciarOperacion();
            String hql = "from Rol";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Rol>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } 
        return list;
    }
    
    public ArrayList<Rol> listarxUsuario(long idUser) throws HibernateException {
        ArrayList<Rol> list = null;
        try {
            iniciarOperacion();
            String hql = "select r from UsuarioRol ur inner join ur.rol r where ur.usuario.idUsuario = "+idUser;
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Rol>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } 
        return list;
    }
    
    public Rol buscarId(int id) {
        Rol bean = new Rol();
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Rol as r where r.idrol = :id_Rol";
        Query query = session.createQuery(hql);
        query.setParameter("id_Rol", id);
        bean = (Rol) query.uniqueResult();
        return bean;
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
