package lissa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.Cita;
import lissa.be.CitaDetalle;
import lissa.be.Medico;
import lissa.be.Persona;
import lissa.table.ModeloCitaDetalle;
import lissa.util.Utilitarios;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CitaDao {

    private Session sesion;
    private Transaction tx;
    private Cita obj;
    private CitaDetalle oCitaDetalle;
    public static final int SUCCESS = 1, ERROR = 2;
    ArrayList<Cita> list = null;
    private List<CitaDetalle> listCitaDetalles;

    public Cita registrar(Cita obj) throws HibernateException {
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

    public int actualizar(Cita obj) throws HibernateException {
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

    public ArrayList<Cita> listar() {
        try {
            iniciarOperacion();
            String hql = "from Cita c order by c.fecha desc";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Cita>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
//        finally{
//            sesion.close();
//        }
        return list;
    }

    public ArrayList<Cita> listarPorMedico(Medico medico) {
        try {
            iniciarOperacion();
            String hql = "select cit from Cita cit inner join cit.medico med where med.idMedico = " + medico.getIdMedico() + "order by cit.fecha desc";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Cita>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
//        finally{
//            sesion.close();
//        }
        return list;
    }

    public ArrayList<Cita> listarPorPacienteFecha(String pac, Date fecha) {
        try {
            iniciarOperacion();
            String hql = "select cit from Cita cit inner join cit.persona p where (p.apellidoPaterno || ' ' || "
                    + "p.apellidoMaterno || ' ' || p.nombre) like '%" + pac + "%' and cit.fecha = '" + Utilitarios.castDate_UTIL_SQL(fecha) + "' order by cit.fecha desc";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Cita>) query.list();
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

    public int registrar(Cita oCita, ModeloCitaDetalle oModeloCitaDetalle) {
        int res = 0;
        try {
            iniciarOperacion();
            sesion.save(oCita);
            for (int i = 0; i < oModeloCitaDetalle.size(); i++) {
                oCitaDetalle = oModeloCitaDetalle.get(i);
                oCitaDetalle.setCita(oCita);
                sesion.save(oCitaDetalle);
            }
            tx.commit();
            res = SUCCESS;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            res = ERROR;
        } finally {
            sesion.close();
        }
        return res;
    }

    public List<CitaDetalle> listarxServicioFecha(long idservicio, Date date) {
        listCitaDetalles = new LinkedList<>();
        try {
            iniciarOperacion();
            String hql = "from CitaDetalle a left join fetch a.cita b left join fetch a.procedimientoTarifario c "
                    + "left join fetch c.procedimiento d left join fetch d.servicio e left join fetch b.persona f left join fetch b.beneficio g "
                    + "where b.fechaCita = '" + Utilitarios.castDate_UTIL_SQL(date) + "' and e.idservicio = " + idservicio;
            Query query = sesion.createQuery(hql);
            listCitaDetalles = query.list();
            tx.commit();
        } catch (HibernateException e) {
            listCitaDetalles = null;
            manejaExcepcion(e);
        } finally {
            sesion.close();
        }
        return listCitaDetalles;
    }

    public List<CitaDetalle> listarxMedicoFecha(int idMedico, Date date) {
        listCitaDetalles = new LinkedList<>();
        try {
            iniciarOperacion();
            String hql = "from CitaDetalle a left join fetch a.cita b left join fetch a.procedimientoTarifario c "
                    + "left join fetch c.procedimiento d left join fetch d.servicio e left join fetch b.persona f left join fetch b.beneficio g "
                    + "left join fetch a.medico h "
                    + "where b.fechaCita = '" + Utilitarios.castDate_UTIL_SQL(date) + "' and h.idMedico = " + idMedico;
            Query query = sesion.createQuery(hql);
            listCitaDetalles = query.list();
            tx.commit();
        } catch (HibernateException e) {
            listCitaDetalles = null;
            manejaExcepcion(e);
        } finally {
            sesion.close();
        }
        return listCitaDetalles;
    }

    public Cita buscarXPersona(Persona beanTablaPersona) {
        try {
            iniciarOperacion();
            String hql = "from Cita a where a.persona.numeroDocumento=:dni and a.estado = 'REG' and "
                    + "a.numero = (select max(b.numero) from Cita b where b.persona.numeroDocumento=:dni)";
            Query query = sesion.createQuery(hql);
            query.setParameter("dni", beanTablaPersona.getNumeroDocumento());
            obj = (Cita) query.uniqueResult();
        } catch (HibernateException he) {
            obj = new Cita();
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return obj;
    }

    public int maxNumero() {
        int actual;
        try {
            iniciarOperacion();
            String hql = "select max(a.numero) from Cita a";
            Query query = sesion.createQuery(hql);
            if (query.uniqueResult() == null) {
                actual = 1;
            } else {
                actual = (int) query.uniqueResult() + 1;
            }
            tx.commit();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            actual = 0;
        }
        return actual;
    }

    public List<CitaDetalle> listarCitas(Date fecha, int idmedico, long idservicio) {
        listCitaDetalles = new LinkedList<>();
        try {
            iniciarOperacion();
            StringBuilder hql = new StringBuilder();
            hql.append("from CitaDetalle a left join fetch a.cita b left join fetch a.procedimientoTarifario c ");
            hql.append("left join fetch c.procedimiento d left join fetch d.servicio e left join fetch b.persona f left join fetch b.beneficio g ");
            hql.append("left join fetch a.medico h ");
            hql.append("where b.fechaCita = :fecha ");
            if (idmedico != 0) {
                hql.append("and h.idMedico = :idmedico ");
            }
            if (idservicio != 0) {
                hql.append("and e.idservicio = :idservicio ");
            }
            hql.append("order by 1 asc ");
            Query query = sesion.createQuery(hql.toString());
            query.setParameter("fecha", Utilitarios.castDate_UTIL_SQL(fecha));
            if (idmedico != 0) {
                query.setParameter("idmedico", idmedico);
            }
            if (idservicio != 0) {
                query.setParameter("idservicio", idservicio);
            }   
            listCitaDetalles = query.list();
            //tx.commit();
        } catch (HibernateException e) {
            listCitaDetalles = new LinkedList<>();
            manejaExcepcion(e);
            //e.printStackTrace();
        } finally {
            sesion.close();
        }
        return listCitaDetalles;
    }

}
