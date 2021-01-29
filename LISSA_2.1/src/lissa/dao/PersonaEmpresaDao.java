package lissa.dao;

import java.util.ArrayList;
import lissa.be.PersonaEmpresa;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonaEmpresaDao {

    private Session sesion;
    private Transaction tx;
    private PersonaEmpresa obj = null;
    public static final int SUCCESS = 1, ERROR = 2;
    private ArrayList<PersonaEmpresa> list;

    public PersonaEmpresa registrar(PersonaEmpresa obj) throws HibernateException {
        try {
            iniciarOperacion();
            sesion.save(obj);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return obj;
    }

    public int actualizar(PersonaEmpresa obj) throws HibernateException {
        int res = 0;
        try {
            iniciarOperacion();
            sesion.update(obj);
            tx.commit();
            res = SUCCESS;
        } catch (HibernateException he) {
            manejaExcepcion(he);
            res = ERROR;
        } finally {
            sesion.close();
        }
        return res;
    }

    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public PersonaEmpresa buscarXidPersJur(int id) {
        try {
            iniciarOperacion();
            String hql = "from PersonaEmpresa pe where pe.personaJuridica.idPersonaJuridica = :id_PersonaJ";
            Query query = sesion.createQuery(hql);
            query.setParameter("id_PersonaJ", id);
            obj = (PersonaEmpresa) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            cerrarSesion();
        }
        return obj;
    }

    public void cerrarSesion() {
        sesion.close();
    }
}
