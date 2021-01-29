package lissa.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.Caja;
import lissa.be.Usuario;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDao {

    private Session sesion;
    private Transaction tx;
    private Usuario oUsuario;
    private Usuario obj = null;
    public static final int SUCCESS = 1, ERROR = 2;
    private int res = 0;
    private List<Usuario> listUsuarios;

    public UsuarioDao() {
    }

    public Usuario registrar(Usuario obj) {
        try {
            iniciarOperacion();
            sesion.save(obj);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        }
//        finally {
//            sesion.close();
//        }
        return obj;
    }

    public ArrayList<Usuario> listar(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ArrayList<Usuario> list = null;
        list = (ArrayList<Usuario>) session.createQuery("from FondoSolidaridad fs where fs.idSocio=" + id).list();
        session.getTransaction().commit();
        return list;
    }

    public Usuario buscarUsuario(String usuario, String clave) {
        //oUsuario = new Usuario();
        try {
            
            iniciarOperacion();
            String hql = "from Usuario as u where u.nombre='" + usuario + "' and u.contrasenia='" + clave + "'";
            Query query = sesion.createQuery(hql);
            query.setMaxResults(1);
            oUsuario = (Usuario) query.uniqueResult();
            tx.commit();
            
        } catch (HibernateException e) {
            manejaExcepcion(e);
            oUsuario = new Usuario();
        }finally{
            sesion.close();
        }
        return oUsuario;
    }

    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        Mensajes.ErrorFatal(he);
    }

    public int actualizar(Usuario obj) {
        try {
            iniciarOperacion();
            sesion.update(obj);
            tx.commit();
            res = SUCCESS;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            res = ERROR;
        } finally {
            sesion.close();
        }
        return res;
    }

    public List<Usuario> buscarxApellidosyNombres(String ref) {
        listUsuarios = new LinkedList<>();
        try {
            iniciarOperacion();
            String hql = "from Usuario u left join fetch  u.persona b where (b.apellidoPaterno || ' ' || "
                    + "b.apellidoMaterno || ' ' || b.nombre) like '%" + ref + "%'";
            Query q = sesion.createQuery(hql);
            listUsuarios = q.list();
            tx.commit();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }finally{
            sesion.close();
        }
        return listUsuarios;
    }
    
    public List<Usuario> buscarxNombreUsuario(String ref) {
        listUsuarios = new LinkedList<>();
        try {
            iniciarOperacion();
            String hql = "from Usuario u left join fetch  u.persona b where u.nombre like '%" + ref + "%'";
            Query q = sesion.createQuery(hql);
            listUsuarios = q.list();
            tx.commit();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }finally{
            sesion.close();
        }
        return listUsuarios;
    }

    public Usuario buscarXIdCaja(Caja oCaja) {
        try {
            iniciarOperacion();
            String hql = "Select user from Caja caj inner join caj.usuario user where caj.idcaja =" + oCaja.getIdcaja();
            Query query = sesion.createQuery(hql);
            obj = (Usuario) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        }
        return obj;
    }

    public Usuario buscarXid(long idUser) {
        try {
            iniciarOperacion();
            String hql = "from Usuario usu where usu.idUsuario = " + idUser;
            Query query = sesion.createQuery(hql);
            obj = (Usuario) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        }
        return obj;
    }

}
