
package lissa.dao;

import lissa.be.Atencionhc;
import lissa.be.FuncionVital;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FuncionVitalDao {
    private Session sesion;
    private Transaction tx;
    private FuncionVital obj = null;
    public static final int SUCCESS = 1, ERROR = 2;

    public FuncionVital registrar(FuncionVital obj) throws HibernateException {
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

    public int actualizar(FuncionVital obj) throws HibernateException {
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

    public FuncionVital buscar(Atencionhc oAtencion) {
        obj = new FuncionVital();
        try {
            iniciarOperacion();
            String hql = "select fv from FuncionVital as fv inner join fv.atencion aten where aten.idAtencion =" + oAtencion.getIdatencionhc();
            Query query = sesion.createQuery(hql);
            obj = (FuncionVital) query.uniqueResult();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }       
        return obj;
    }
}
