
package lissa.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lissa.be.Compra;
import lissa.be.DetalleCompra;
import lissa.be.DetalleVenta;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JSULCAG
 */
public class DetalleCompraDao extends AbstractDA<DetalleCompra>{
    private Session s;
    private Transaction t;
    private List<DetalleCompra> l;
    private DetalleCompra obj;

    private void iniciarOperacion() {
        s = HibernateUtil.getSessionFactory().openSession();
        t = s.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) {
        t.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
    
    @Override
    public DetalleCompra registrar(DetalleCompra bean) {
        return save(bean);
    }

    @Override
    public int actualizar(DetalleCompra bean) {
        return update(bean);
    }

    @Override
    public int eliminar(DetalleCompra bean) {
        return delete(bean);
    }

    @Override
    public List<DetalleCompra> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleCompra> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleCompra> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleCompra buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleCompra buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<DetalleCompra> listarXCompra(Compra oCompra) {
        try {
            iniciarOperacion();
            String hql = "select dc from DetalleCompra dc left join fetch dc.compra c left join fetch dc.producto d where c.idcompra= "+oCompra.getIdcompra() +" "
                    + "order by 1 asc";
            Query query = s.createQuery(hql);
            l = query.list();
            s.close();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            l = new LinkedList<>();
        }
        return l;
    }

    public DetalleCompra buscarXId(DetalleCompra o) {
        StringBuilder hql = new StringBuilder();
        try {
            iniciarOperacion();
            hql.append("select dc from DetalleCompra dc left join fetch dc.compra c ")
                    .append("left join fetch dc.producto d left join fetch d.presentacion e ")
                    .append("left join fetch c.farComprobante f ")
                    .append("left join fetch c.personaProveedor pp ")
                    .append("where dc.iddetallecompra =:iddetallecompra");            
            Query query = s.createQuery(hql.toString());
            query.setParameter("iddetallecompra", o.getIddetallecompra());
            obj = (DetalleCompra) query.uniqueResult();            
        } catch (HibernateException e) {
            Mensajes.ErrorFatal(e);
            obj = null;
        } finally{
            s.close();
        }
        return obj;
    }
    
}
