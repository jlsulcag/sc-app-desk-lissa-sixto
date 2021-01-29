package lissa.dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import lissa.be.HistoriaClinica;
import lissa.be.Persona;
import lissa.be.TipoHistoriaClinica;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HistoriaClinicaDao {

    private Session sesion;
    private Transaction tx;
    private ArrayList<HistoriaClinica> list;
    private HistoriaClinica bean;

    public HistoriaClinicaDao() {
    }

    public HistoriaClinica registrar(HistoriaClinica obj) {
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

    public void actualizar(HistoriaClinica obj) {
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

    public int generarHC() {
        iniciarOperacion();
        int num = 0;
        String hql = "select max(hc.numerohc) from HistoriaClinica hc";
        //from UnidadAcademica ua inner join fetch ua.facultad f where f.idfacultad=
        Query query = sesion.createQuery(hql);
        if (query.uniqueResult() == null) {
            num = 0;
        } else {
            num = (Integer) query.uniqueResult();
        }
        tx.commit();
        return num;
    }

    public int generarHCxTipo(TipoHistoriaClinica obj) {
        iniciarOperacion();
        int num = 0;
        String hql = "select max(hc.numerohc) from HistoriaClinica hc where hc.tipoHistoriaClinica.idtipohc = " + obj.getIdtipohc();
        //from UnidadAcademica ua inner join fetch ua.facultad f where f.idfacultad=
        Query query = sesion.createQuery(hql);
        if (query.uniqueResult() == null) {
            num = 0;
        } else {
            num = (Integer) query.uniqueResult();
        }
        tx.commit();
        return num;
    }

    private void iniciarOperacion() throws HibernateException {
        if (sesion != null) {
            sesion.close();
        } else {
            sesion = HibernateUtil.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
        }
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        Mensajes.ErrorFatal(he);
    }

    public HistoriaClinica buscarXdniPersona(String numeroDocumento) {
        bean = new HistoriaClinica();
        try {
            iniciarOperacion();
            String hql = "select hc from HistoriaClinica hc where hc.persona.numeroDocumento = :num_doc";
            Query query = sesion.createQuery(hql);
            query.setParameter("num_doc", numeroDocumento);
            bean = (HistoriaClinica) query.uniqueResult();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        return bean;
    }

    public ArrayList<HistoriaClinica> buscar(String ref) {
        ArrayList<HistoriaClinica> list = null;
        try {
            iniciarOperacion();
            list = (ArrayList<HistoriaClinica>) sesion.createQuery("select hc from HistoriaClinica hc inner join hc.persona p inner join hc.tipoHistoriaClinica thc where (p.apellidoPaterno || ' ' || "
                    + "p.apellidoMaterno || ' ' || p.nombre) like '%" + ref + "%' and thc.idtipohc = " + 1).list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        tx.commit();
        return list;
    }

    public HistoriaClinica buscar(int idpersona) {
        try {
            iniciarOperacion();
            String hql = "from HistoriaClinica hc inner join fetch hc.persona p where p.idPersona=" + idpersona;
            Query query = sesion.createQuery(hql);
            bean = (HistoriaClinica) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        }
        return bean;
    }

    public HistoriaClinica buscar(Persona per, TipoHistoriaClinica thc) {
        try {
            iniciarOperacion();
            String hql = "select hc from HistoriaClinica hc left join fetch hc.persona p left join fetch hc.tipoHistoriaClinica thc where p.idpersona=" + per.getIdpersona() + " and thc.idtipohc = " + thc.getIdtipohc();
            Query query = sesion.createQuery(hql);
            bean = (HistoriaClinica) query.uniqueResult();
        } catch (HibernateException he) {
            bean = new HistoriaClinica();
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return bean;
    }

    public HistoriaClinica buscar(Persona per) {
        try {
            iniciarOperacion();
            String hql = "select hc from HistoriaClinica hc inner join fetch hc.persona p inner join fetch hc.tipoHistoriaClinica thc where p.idpersona=" + per.getIdpersona() + " and thc.idtipohc = 2";
            Query query = sesion.createQuery(hql);
            bean = (HistoriaClinica) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            JOptionPane.showMessageDialog(null, he, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return bean;
    }

    public ArrayList<HistoriaClinica> listar(int idPersona) {
        try {
            iniciarOperacion();
            String hql = "select hc from HistoriaClinica hc inner join fetch hc.persona p where p.idpersona=" + idPersona;
            Query query = sesion.createQuery(hql);
            list = (ArrayList<HistoriaClinica>) query.list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        }
        return list;
    }
}
