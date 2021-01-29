package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Egreso;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EgresoDao extends AbstractDA<Egreso> {

    private Session sesion;
    private Transaction tx;

    @Override
    public Egreso registrar(Egreso bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Egreso bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Egreso bean) {
        return delete(bean);
    }

    @Override
    public List<Egreso> listar() {
        return list(Egreso.class);
    }

    @Override
    public ArrayList<Egreso> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<Egreso> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Egreso buscar(long id) {
        return search(Egreso.class, id);
    }

    @Override
    public Egreso buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId(Egreso.class);
    }

    public long numeroSig() {
        iniciarOperacion();
        long num = 0;
        String hql = "select max(c.numero) from Egreso c";
        Query query = sesion.createQuery(hql);
        if (query.uniqueResult() == null) {
            num = num + 1;
        } else {
            num = (long) query.uniqueResult() + 1;
        }
        tx.commit();
        return num;
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
