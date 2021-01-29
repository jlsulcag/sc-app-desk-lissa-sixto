package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.DetalleVenta;
import lissa.be.Venta;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DetalleVentaDao extends AbstractDA<DetalleVenta> {

    private static final int SUCCESS = 0, ERROR = -1;
    private Session s;
    private Transaction t;
    private List<DetalleVenta> l;

    private void iniciarOperacion() {
        s = HibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) {
        t.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    @Override
    public DetalleVenta registrar(DetalleVenta bean) {
        return save(bean);
    }

    @Override
    public int actualizar(DetalleVenta bean) {
        return update(bean);
    }

    @Override
    public int eliminar(DetalleVenta bean) {
        return delete(bean);
    }

    @Override
    public List<DetalleVenta> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleVenta> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<DetalleVenta> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleVenta buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleVenta buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<DetalleVenta> listarXVenta(Venta oVenta) {
        try {
            iniciarOperacion();
            String hql = "select dv from DetalleVenta dv inner join dv.venta v where v.idventa = "+oVenta.getIdventa();
            Query query = s.createQuery(hql);
            l = query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        return l;
    }

    public List<DetalleVenta> listarDetallesxidVenta(long idVenta) {
        String hql = "select a from DetalleVenta a left join fetch a.venta b left join fetch a.producto c left join fetch b.farComprobante d "
                + "where b.idventa = "+idVenta;
        return listar(hql);
    }

}
