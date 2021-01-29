package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.SeguroVidaUsaPersona;
import lissa.be.TipoComprobante;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jorge Luis Sulca González
 */
public class TipoComprobanteDao extends AbstractDA<TipoComprobante> {

    private Session sesion;
    private Transaction tx;
    private ArrayList<TipoComprobante> list = null;

    @Override
    public TipoComprobante registrar(TipoComprobante bean) {
        return save(bean);
    }

    @Override
    public int actualizar(TipoComprobante bean) {
        return update(bean);
    }

    @Override
    public int eliminar(TipoComprobante bean) {
        return delete(bean);
    }

    @Override
    public List<TipoComprobante> listar() {
        return list(TipoComprobante.class);
    }

    @Override
    public ArrayList<TipoComprobante> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<TipoComprobante> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoComprobante buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoComprobante buscar(String ref) {
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

    public ArrayList listarAct() {
        String hql = "from TipoComprobante a where a.estado = "+1;
        return listar(hql);
    }

}
