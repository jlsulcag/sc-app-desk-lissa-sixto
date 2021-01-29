package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.FormaFarmaceutica;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormaFarmaceuticaDao extends AbstractDA<FormaFarmaceutica>{

    private Session sesion;
    private Transaction tx;
    private FormaFarmaceutica oFormaFarmaceutica;
    private ArrayList<FormaFarmaceutica> list;

    @Override
    public FormaFarmaceutica registrar(FormaFarmaceutica bean) {
        return save(bean);
    }

    @Override
    public int actualizar(FormaFarmaceutica bean) {
        return update(bean);
    }

    @Override
    public int eliminar(FormaFarmaceutica bean) {
        return delete(bean);
    }

    @Override
    public List<FormaFarmaceutica> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<FormaFarmaceutica> listar(String hql) {
        hql = "from FormaFarmaceutica c order by c.denominacion asc";
        return list(hql);
    }

    @Override
    public List<FormaFarmaceutica> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FormaFarmaceutica buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FormaFarmaceutica buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    ///---
    public ArrayList<FormaFarmaceutica> buscarF(String ref) {
        ArrayList<FormaFarmaceutica> list = null;
        try {
            iniciarOperacion();
            list = (ArrayList<FormaFarmaceutica>) sesion.createQuery("from FormaFarmaceutica p where (p.denominacion) like '%" + ref + "%'").list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        tx.commit();
        return list;
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
