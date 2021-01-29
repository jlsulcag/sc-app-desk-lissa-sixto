package lissa.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lissa.be.UsuarioPermiso;
import lissa.common.Constante;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioPermisodao extends AbstractDA<UsuarioPermiso> {

    private Session sesion;
    private Transaction tx;
    private List<UsuarioPermiso> list;

    @Override
    public UsuarioPermiso registrar(UsuarioPermiso bean) {
        return save(bean);
    }

    @Override
    public int actualizar(UsuarioPermiso bean) {
        return update(bean);
    }

    @Override
    public int eliminar(UsuarioPermiso bean) {
        return delete(bean);
    }

    @Override
    public List<UsuarioPermiso> listar() {
        return list(UsuarioPermiso.class);
    }

    @Override
    public ArrayList<UsuarioPermiso> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<UsuarioPermiso> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioPermiso buscar(long id) {
        return search(UsuarioPermiso.class, id);
    }

    @Override
    public UsuarioPermiso buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId(UsuarioPermiso.class);
    }
    /*
    public UsuarioPermiso buscarPermiso(long idUsuario, int idpermiso) {
        String hql = "from UsuarioPermiso a where a.usuario.idUsuario = " + idUsuario + " and a.permiso.idpermiso = " + idpermiso;
        return search(hql);
    }
    */
    public List<UsuarioPermiso> listarPermisosxUsuario(long idUsuario) {
        try {
            iniciarOperacion();
            StringBuilder hql = new StringBuilder();
            hql.append("from UsuarioPermiso a left join fetch a.permiso b left join fetch a.usuario c ");
            hql.append("where c.idUsuario =:id and a.estado =:estado ");
            hql.append("order by 1 asc ");

            Query query = sesion.createQuery(hql.toString());
            query.setParameter("id", idUsuario);
            query.setParameter("estado", Constante.ESTADO_ACT);
            list = query.list();
            
        } catch (HibernateException e) {
            manejaExcepcion(e);
            list = new LinkedList<>();
        }finally{
            cerrarSesion();
        }        
        return list;

    }
    
    public UsuarioPermiso buscarUsuarioPermiso(int codigo, long idUsuario) {
        UsuarioPermiso obj = new UsuarioPermiso();
        try {
            iniciarOperacion();
            StringBuilder hql = new StringBuilder();
            hql.append("from UsuarioPermiso a left join fetch a.usuario b left join fetch a.permiso c ");
            hql.append("where b.idUsuario =:idusuario and c.codigo =:codigo and a.estado =:estado ");
            Query query = sesion.createQuery(hql.toString());
            query.setParameter("idusuario", idUsuario);
            query.setParameter("codigo", codigo);            
            query.setParameter("estado", Constante.ESTADO_ACT);
            query.setMaxResults(1);
            obj = (UsuarioPermiso) query.uniqueResult();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            obj = new UsuarioPermiso();
        } finally{
            cerrarSesion();
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

    private void manejaExcepcion(HibernateException he) {
        tx.rollback();
        Mensajes.ErrorFatal(he);
    }

    public void cerrarSesion() {
        sesion.close();
    }

    public int quitarPermiso(int idusuariopermiso) {
        int res = 0;
        try {
            iniciarOperacion();
            StringBuilder hql = new StringBuilder();
            hql.append("update UsuarioPermiso a set estado =:estado where idusuariopermiso =:id");
            Query query = sesion.createQuery(hql.toString());
            query.setParameter("estado", Constante.ESTADO_ANU);
            query.setParameter("id", idusuariopermiso);
            query.executeUpdate();
            tx.commit();
            res = Constante.SUCCESS;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            tx.rollback();
            res = Constante.ERROR;
        } finally{
            cerrarSesion();
        }
        return res;
    }

    

}
