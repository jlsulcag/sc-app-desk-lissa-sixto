package lissa.dao;

import java.util.ArrayList;
import lissa.be.Caja;
import lissa.be.Rol;
import lissa.be.Usuario;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CajaDao {

    private Session sesion;
    private Transaction tx;
    private Caja obj = null;
    private ArrayList<Caja> list;
    public static final int SUCCESS = 1;
    public static final int ERROR = 0;

    public int registrar(Caja obj) throws HibernateException {
        int id = 0;
        try {
            iniciarOperacion();
            id = (int) sesion.save(obj);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return id;
    }

    public int actualizar(Caja obj) throws HibernateException {
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

    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public ArrayList<Caja> listar() {
        try {
            iniciarOperacion();
            String hql = "from Caja A left join fetch A.usuario B left join fetch A.areaCaja C order by A.fechaApertura desc, A.estado asc";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Caja>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } finally {
            sesion.close();
        }
        return list;
    }

//    public ArrayList<Caja> listarxUsuario(Usuario user) {
//        try {
//            iniciarOperacion();
//            String hql = "select A from Caja A inner join A.usuario B inner join A.areaCaja C where B.idUsuario=" + user.getIdUsuario() + " and C.modulo = 'CAJA 02 - FARMACIA' order by A.fechaApertura desc, A.idcaja desc";
//            Query query = sesion.createQuery(hql);
//            list = (ArrayList<Caja>) query.list();
//        } catch (HibernateException e) {
//            manejaExcepcion(e);
//        }
//        finally{
//            sesion.close();
//        }
//        return list;
//    }
    public Caja buscarPorIdusuario(Usuario user) {
        try {
            iniciarOperacion();
            String hql = "select caj from Caja caj inner join caj.usuario user where user.idUsuario=" + user.getIdUsuario() + " and caj.estado = 'ABIERTO'";
            Query query = sesion.createQuery(hql);
            obj = (Caja) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        }
//        finally {
//            sesion.close();
//        }
        return obj;
    }

    public long numCajasAbi() {
        long numCajasAbi = 0;
        try {
            iniciarOperacion();
            String hql = "select count(caj.estado) from Caja caj where caj.estado = 'ABIERTO'";
            Query query = sesion.createQuery(hql);
            numCajasAbi = (long) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return numCajasAbi;
    }

    public ArrayList<Caja> listarxUsuario(Usuario user, String caja) {
        try {
            iniciarOperacion();
            String hql = "select A from Caja A left join fetch A.usuario B left join fetch A.areaCaja C where B.idUsuario=" + user.getIdUsuario() + " and C.modulo = '" + caja + "' order by A.fechaApertura desc, A.idcaja desc";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Caja>) query.list();
            tx.commit();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } finally {
            sesion.close();            
        }
        return list;
    }
}
