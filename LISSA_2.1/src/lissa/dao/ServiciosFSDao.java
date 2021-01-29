package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.FondoSolidaridad;
import lissa.be.PaqueteFondoSolidaridad;
import lissa.be.ServiciosFondoSolidaridad;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ServiciosFSDao extends AbstractDA<ServiciosFondoSolidaridad> {

    private Session sesion;
    private Transaction tx;
    private ArrayList<ServiciosFondoSolidaridad> list;
    private ServiciosFondoSolidaridad obj;

    @Override
    public ServiciosFondoSolidaridad registrar(ServiciosFondoSolidaridad bean) {
        return save(bean);
    }

    @Override
    public int actualizar(ServiciosFondoSolidaridad bean) {
        return update(bean);
    }

    @Override
    public int eliminar(ServiciosFondoSolidaridad bean) {
        return delete(bean);
    }

    @Override
    public List<ServiciosFondoSolidaridad> listar() {
        return list(ServiciosFondoSolidaridad.class);
    }

    @Override
    public ArrayList<ServiciosFondoSolidaridad> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ServiciosFondoSolidaridad> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ServiciosFondoSolidaridad buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ServiciosFondoSolidaridad buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ServiciosFondoSolidaridad buscarBeneficio(FondoSolidaridad oFondoSolidaridad, PaqueteFondoSolidaridad paqueteFondoSolidaridad) {

        try {
            iniciarOperacion();
            String hql = "select a from ServiciosFondoSolidaridad a where a.fondoSolidaridad.idFondosolidaridad = " + oFondoSolidaridad.getIdFondosolidaridad() + " and a.paqueteFondoSolidaridad.idpaquetefs = " + paqueteFondoSolidaridad.getIdpaquetefs();
            Query query = sesion.createQuery(hql);
            obj = (ServiciosFondoSolidaridad) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            obj = null;
        }
        return obj;
    }

    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR : Capa de acceso  a datos", he);
    }

}
