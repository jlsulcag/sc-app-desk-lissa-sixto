package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.Atencion;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PacienteDao {

    private Session sesion;
    private Transaction tx;
    Atencion obj = null;

    public long registrar(Atencion obj) throws HibernateException {
        long id = 0;
        Session sesion = null;
        Transaction transaction = null;
        try {
            //iniciarOperacion();
            sesion = HibernateUtil.getSessionFactory().openSession();
            transaction = sesion.beginTransaction();
            id = (long) sesion.save(obj);
            sesion.flush();
            sesion.clear();
            transaction.commit();
            //tx.commit();
        } catch (HibernateException he) {
            //manejaExcepcion(he);
            //he.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR FATAL ... " + he, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            sesion.close();
        }
        return id;
    }

    public void actualizar(Atencion obj) throws HibernateException {
        try {
            iniciarOperacion();
            sesion.update(obj);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
    }

    public ArrayList<Atencion> buscarPersonaJuridica(String ref) {
        ArrayList<Atencion> list = null;
        try {
            iniciarOperacion();
            list = (ArrayList<Atencion>) sesion.createQuery("from PersonaJuridica p where p.razonSocial like '%" + ref + "%'").list();
            if (list.isEmpty()) {
                list = (ArrayList<Atencion>) sesion.createQuery("from PersonaJuridica p where p.numeroRuc like '%" + ref + "%'").list();
            }
            tx.commit();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        return list;
    }

    private void iniciarOperacion() throws HibernateException {
        if (sesion != null) {
            sesion.close();
        } else {
            sesion = HibernateUtil.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
        }
    }

    public void cerrarSesion() {
        sesion.close();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        Mensajes.ErrorFatal(he);
    }

    //Busqueda optima para encontrar la ultima atencion de un paciente baso en el id de la persona
    public Atencion buscar(long id) {
        try {
            iniciarOperacion();
            String hql = "from Atencion a left join fetch a.persona p left join fetch a.cita g "
                    + "where p.idpersona=" + id
                    + " and a.fechaIngreso=(select max(b.fechaIngreso) from Atencion b inner "
                    + "join b.persona per2 where per2.idpersona=" + id
                    + ") and a.numeroAtencion=(select max(c.numeroAtencion) from "
                    + "Atencion c inner join c.persona per3 where per3.idpersona=" + id + ")";
            Query query = sesion.createQuery(hql);
            obj = (Atencion) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return obj;
    }

    public List<Atencion> buscarXIdPersona(Integer id) {
        List<Atencion> list = null;
        try {
            iniciarOperacion();
            String hql = "from Atencion a inner join fetch a.persona p where p.idpersona=" + id + " order by a.fechaIngreso desc";
            Query query = sesion.createQuery(hql);
            query.setMaxResults(1);
            list = query.list();
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        }
        return list;
    }

    public Integer ultimoNumAtencion() {
        iniciarOperacion();
        Integer num = 0;
        String hql = "select max(a.numeroAtencion) from Atencion a";
        Query query = sesion.createQuery(hql);
        if (query.uniqueResult() == null) {
            num = 0;
        } else {
            num = (Integer) query.uniqueResult();
        }
        tx.commit();
        return num;
    }

    public ArrayList<Atencion> listarIngresosPaciente(long idPersona) {
        ArrayList<Atencion> list = null;
        try {
            iniciarOperacion();
            String hql = "from Atencion a left join fetch a.persona p where p.idpersona=" + idPersona + " "
                    + "order by a.fechaIngreso desc";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Atencion>) query.list();
        } catch (HibernateException he) {
            list = new ArrayList<>();
            manejaExcepcion(he);
        } finally {
            cerrarSesion();
        }
        return list;
    }
}
