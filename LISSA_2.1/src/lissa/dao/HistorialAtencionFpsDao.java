
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.FondoSolidaridad;
import lissa.be.HistorialAtencionFps;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HistorialAtencionFpsDao extends AbstractDA<HistorialAtencionFps>{
    private Session sesion;
    private Transaction tx;
    private ArrayList<HistorialAtencionFps> list;
    private HistorialAtencionFps obj;
    
    @Override
    public HistorialAtencionFps registrar(HistorialAtencionFps bean) {
        return save(bean);
    }

    @Override
    public int actualizar(HistorialAtencionFps bean) {
        return update(bean);
    }

    @Override
    public int eliminar(HistorialAtencionFps bean) {
        return delete(bean);
    }

    @Override
    public List<HistorialAtencionFps> listar() {
        return list(HistorialAtencionFps.class);
    }

    @Override
    public ArrayList<HistorialAtencionFps> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HistorialAtencionFps> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HistorialAtencionFps buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HistorialAtencionFps buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public HistorialAtencionFps buscarUltimoRegistro(FondoSolidaridad o) {
        try {
            iniciarOperacion();
            String hql = "select h from HistorialAtencionFps h where h.fondoSolidaridad.idFondosolidaridad=:idfps and (h.numRegistro=(select max(h2.numRegistro) from HistorialAtencionFps h2 where h2.fondoSolidaridad.idFondosolidaridad=:idfps))";
            Query q = sesion.createQuery(hql).setMaxResults(1);
            q.setParameter("idfps", o.getIdFondosolidaridad()); 
            obj =  (HistorialAtencionFps) q.uniqueResult();
            //tx.commit();            
        } catch (HibernateException e) {
            manejaExcepcion(e);
            obj = new HistorialAtencionFps();
        }finally{
            sesion.close();
        }
        return obj;
    }
    
    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        Mensajes.ErrorFatal(he);
    }
    
}
