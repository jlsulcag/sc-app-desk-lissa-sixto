package lissa.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lissa.be.Especialidad;
import lissa.be.Medico;
import lissa.be.MedicoEspecialidad;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MedicoEspecialidadDao {

    private Session sesion;
    private Transaction tx;
    private List<MedicoEspecialidad> list;

    public int registrar(MedicoEspecialidad obj) {
        int id = 0;
        try {
            iniciarOperacion();
            id = (int) sesion.save(obj);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return id;
    }

    public ArrayList<MedicoEspecialidad> listar(int id) {
        ArrayList<MedicoEspecialidad> list = null;
        try {
            iniciarOperacion();            
            //list = (ArrayList<MedicoEspecialidad>) sesion.createQuery("from MedicoEspecialidad me where me.idMedico=" + id).list();
            list = (ArrayList<MedicoEspecialidad>) sesion.createQuery("from MedicoEspecialidad  me inner join  me.especialidad e where me.medico.idmedico=" + id).list();
            sesion.getTransaction().commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        }
        return list;
    }

    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public int eliminar(Especialidad oEspecialidad, Medico oMedico) {
        int rowsAfect = 0;
        try {
            iniciarOperacion();
            String hqlDelete = "delete MedicoEspecialidad me where me.especialidad =:oEspecialidad and me.medico =:oMedico";
            Query query = sesion.createQuery(hqlDelete);
            query.setParameter("oEspecialidad", oEspecialidad);
            query.setParameter("oMedico", oMedico);
            rowsAfect = query.executeUpdate();
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return rowsAfect;
    }

    public List<MedicoEspecialidad> listarXMedico(int idMedico) {
        try {
            iniciarOperacion();
            StringBuilder hql = new StringBuilder();
            hql.append("from MedicoEspecialidad a left join fetch a.especialidad b ");
            hql.append("where a.medico.idMedico =:idmedico ");
            hql.append("order by  a.especialidad.denominacion asc ");
            Query query = sesion.createQuery(hql.toString());
            query.setParameter("idmedico", idMedico);
            list = query.list();
        } catch (HibernateException e) {
            list = new LinkedList<>();
            manejaExcepcion(e);
        }
        return list;
    }

}
