package lissa.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lissa.be.Rol;
import lissa.be.UsuarioRol;
import lissa.common.Constante;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioRolDao {

    private Session sesion;
    private Transaction tx;
    UsuarioRol obj = null;
    List<UsuarioRol> list;

    public int registrar(UsuarioRol obj) {
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

    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public ArrayList<UsuarioRol> listar_modulos_usuario(int idUsuario) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ArrayList<UsuarioRol> list = null;
        list = (ArrayList<UsuarioRol>) session.createQuery("from UsuarioRol ur where ur.idUsuario=" + idUsuario).list();
        session.getTransaction().commit();
        return list;
    }

    public UsuarioRol buscar(long idUsuario, int idrol) {
        try {
            iniciarOperacion();
            String hql = "select ur from UsuarioRol ur inner join ur.usuario u inner join ur.rol r where u.idUsuario = " + idUsuario + " and r.idrol = " + idrol;
            Query query = sesion.createQuery(hql);
            obj = (UsuarioRol) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return obj;
    }

    public void eliminar(UsuarioRol oUsuarioRol) {
        try {
            iniciarOperacion();
            sesion.delete(oUsuarioRol);
            tx.commit();
            sesion.close();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
    }

    public boolean existeRolAsignado(long idUsuario, int idrol) {
        UsuarioRol obj = new UsuarioRol();
        try {
            iniciarOperacion();
            StringBuilder hql = new StringBuilder();
            hql.append("from UsuarioRol a ");
            hql.append("where a.usuario.idUsuario =:idusuario and a.rol.idrol =:idrol and a.estado =:act");
            Query query = sesion.createQuery(hql.toString());
            query.setParameter("idusuario", idUsuario);
            query.setParameter("idrol", idrol);
            query.setParameter("act", Constante.ESTADO_ACT);
            query.setMaxResults(1);
            obj = (UsuarioRol) query.uniqueResult();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            obj = new UsuarioRol();
        }
        if (obj != null && obj.getIdUsuarioRol() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<UsuarioRol> listarModulosXUsuario(long idUsuario) {
        try {
            iniciarOperacion();
            StringBuilder hql = new StringBuilder();
            hql.append("from UsuarioRol a left join fetch a.usuario b left join fetch a.rol c ");
            hql.append("where b.idUsuario =:idusuario and a.estado =:estado ");
            Query query = sesion.createQuery(hql.toString());
            query.setParameter("idusuario", idUsuario);
            query.setParameter("estado", Constante.ESTADO_ACT);
            list = query.list();
        } catch (HibernateException e) {            
            list = new LinkedList<>();
            manejaExcepcion(e);
        }
        return list;
    }

    public int quitarRol(int idUsuarioRol) {
        int res = 0;
        try {
            iniciarOperacion();
            StringBuilder hql = new StringBuilder();
            hql.append("update UsuarioRol a set estado =:estado where idUsuarioRol =:id");
            Query query = sesion.createQuery(hql.toString());
            query.setParameter("estado", Constante.ESTADO_ANU);
            query.setParameter("id", idUsuarioRol);
            query.executeUpdate();
            tx.commit();
            res = Constante.SUCCESS;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            tx.rollback();
            res = Constante.ERROR;
        }
        return res;
    }
}
