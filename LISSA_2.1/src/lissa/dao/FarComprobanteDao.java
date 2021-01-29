
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.FarComprobante;
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
public class FarComprobanteDao extends AbstractDA<FarComprobante>{

    private Session s;
    private Transaction t;
    private ArrayList<FarComprobante> list;
    
    private void iniciarOperacion() {
        s = HibernateUtil.getSessionFactory().openSession();
        t = s  .beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) {
        t.rollback();
        Mensajes.ErrorFatal(he);
        //throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    @Override
    public FarComprobante registrar(FarComprobante bean) {
        return save(bean);
    }

    @Override
    public int actualizar(FarComprobante bean) {
        return update(bean);
    }

    @Override
    public int eliminar(FarComprobante bean) {
        return delete(bean);
    }

    @Override
    public List<FarComprobante> listar() {
        return list("from");
    }

    @Override
    public ArrayList<FarComprobante> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FarComprobante> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FarComprobante buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FarComprobante buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<FarComprobante> listarxTipo(String ref) {
        try {
            iniciarOperacion();
            String query = "from FarComprobante A where A.tipoComprobante = '"+ref+"' and A.estado is true";
            Query q =s.createQuery(query);
            list = (ArrayList<FarComprobante>) q.list();
            t.commit();
            return list;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        }finally{
            s.close();
        }
    }
    
}
