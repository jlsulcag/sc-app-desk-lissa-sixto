package lissa.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.ComprobanteDetalle;
import lissa.be.ProcedimientoTarifario;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JSULCAG
 */
public class ProcedimientoTarifarioDao extends AbstractDA<ProcedimientoTarifario> {

    private List<ProcedimientoTarifario> list;
    private Session sesion;
    private Transaction tx;
    List<ProcedimientoTarifario> l;

    @Override
    public ProcedimientoTarifario registrar(ProcedimientoTarifario bean) {
        return save(bean);
    }

    @Override
    public int actualizar(ProcedimientoTarifario bean) {
        return update(bean);
    }

    @Override
    public int eliminar(ProcedimientoTarifario bean) {
        return delete(bean);
    }

    @Override
    public List<ProcedimientoTarifario> listar() {
        return list(ProcedimientoTarifario.class);
    }

    @Override
    public ArrayList<ProcedimientoTarifario> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<ProcedimientoTarifario> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcedimientoTarifario buscar(long id) {
        return search(ProcedimientoTarifario.class, id);
    }

    @Override
    public ProcedimientoTarifario buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId(ProcedimientoTarifario.class);
    }

    public List<ProcedimientoTarifario> listarRef(String ref) {
        //Todos Act y Anu
        try {
            String hql = "from ProcedimientoTarifario a left join fetch a.procedimiento b left join fetch a.tarifario c left join fetch b.servicio d "
                    + "where (d.denominacion || ' ' || b.denominacion) like '%" + ref + "%' "
                    + "order by c.nombre asc, d.denominacion asc";
            iniciarOperacion();
            Query q = sesion.createQuery(hql);
            ArrayList<ProcedimientoTarifario> l = (ArrayList) q.list();
            tx.commit();
            return l;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        }finally{
            sesion.close();
        }
    }
    
    public List<ProcedimientoTarifario> listarRefAct(String ref) {
        //Solo ACT
        try {
            iniciarOperacion();
            String hql = "from ProcedimientoTarifario a left join fetch a.procedimiento b left join fetch a.tarifario c left join fetch b.servicio d "
                    + "where (d.denominacion || ' ' || b.denominacion) like '%" + ref + "%' and a.estado = 1 "
                    + "order by c.nombre asc, d.denominacion asc ";            
            Query q = sesion.createQuery(hql);
            l = q.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            l = new LinkedList<>();
        }finally{
            sesion.close();
        }
        return l;
    }

    private void iniciarOperacion() throws HibernateException {
        if (sesion != null) {
            sesion.close();
        } else {
            sesion = HibernateUtil.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
        }
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        JOptionPane.showMessageDialog(null, "" + he, "Error", JOptionPane.ERROR_MESSAGE);
        //throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public List<ProcedimientoTarifario> listarFull() {
        StringBuilder hql = new StringBuilder();
        try {            
            hql.append("from ProcedimientoTarifario a left join fetch a.procedimiento b left join fetch a.tarifario c left join fetch b.servicio d ");
            hql.append("order by c.nombre asc, d.denominacion asc, b.codigo asc ");
            iniciarOperacion();
            Query q = sesion.createQuery(hql.toString());
            list = q.list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            list = new LinkedList<>();
        } finally{
            sesion.close();
        }
        return list;
    }

}
