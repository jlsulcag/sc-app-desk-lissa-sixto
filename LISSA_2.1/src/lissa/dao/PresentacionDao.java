package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Presentacion;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PresentacionDao extends AbstractDA<Presentacion> {

    private Session sesion;
    private Transaction tx;
    private ArrayList<Presentacion> list;
    public static final int SUCCESS = 1;
    public static final int ERROR = 0;

    @Override
    public Presentacion registrar(Presentacion bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Presentacion bean)  {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return update(bean);
    }

    @Override
    public int eliminar(Presentacion bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    public ArrayList<Presentacion> listar(String hql) {
        hql = "from Presentacion f order by f.denominacion asc";
        return list(hql);
    }

    @Override
    public List<Presentacion> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Presentacion buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Presentacion buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    @Override
    public List<Presentacion> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    ///---
    public ArrayList<Presentacion> buscarF(String ref) {
        ArrayList<Presentacion> list = null;
        try {
            iniciarOperacion();
            list = (ArrayList<Presentacion>) sesion.createQuery("from Presentacion p where (p.denominacion) like '%" + ref + "%'").list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        tx.commit();
        return list;
    } 
}
