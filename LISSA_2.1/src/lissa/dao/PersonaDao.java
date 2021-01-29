package lissa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import lissa.be.HistoriaClinica;
import lissa.be.Medico;
import lissa.be.MedicoEspecialidad;
import lissa.be.Persona;
import lissa.be.SeguroVida;
import lissa.be.SeguroVidaUsaPersona;
import lissa.bl.SeguroPersonaBl;
import lissa.table.ModeloMedicoEspecialidad;
import lissa.table.ModeloSeguroVida;
import lissa.table.ModelosSeguroVida;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonaDao {

    private Persona oPersona;
    private List<Persona> listPersonas;
    private ArrayList<Persona> list;
    private Session sesion;
    private Transaction tx;
    Persona obj;
    private static final int SUCCESS = 1, ERROR = 0;

    public Persona registrarPersona(Persona obj) {
        try {
            iniciarOperacion();
            sesion.save(obj);
            tx.commit();
            return obj;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        } finally {
            sesion.close();
        }

    }

    public ArrayList<Persona> buscar(String ref) {
        ArrayList<Persona> list = null;
        try {
            iniciarOperacion();
            String hql = "from Persona a left join fetch a.estadoCivil b left join fetch a.tipoDocidentidad c "
                    + "where (a.apellidoPaterno || ' ' || a.apellidoMaterno || ' ' || a.nombre) like '" + ref + "%'";
            Query q = sesion.createQuery(hql);
            list = (ArrayList<Persona>) q.list();

            if (list.isEmpty()) {
                String hql2 = "from Persona a left join fetch a.estadoCivil b left join fetch a.tipoDocidentidad c "
                        + "where a.numeroDocumento = '" + ref + "'";
                Query q2 = sesion.createQuery(hql2);
                list = (ArrayList<Persona>) q2.list();
            }
            tx.commit();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            list = new ArrayList<>();
        } finally {
            cerrarSesion();
        }
        return list;
    }

    public Persona buscarPersonaXDni(String numeroDocumento) {
        oPersona = new Persona();
        try {
            iniciarOperacion();
            String hql = "from Persona a left join fetch a.estadoCivil b left join fetch a.tipoDocidentidad c "
                    + "left  join fetch a.tipoPersona d "
                    + "where a.numeroDocumento='" + numeroDocumento + "'";
            Query query = sesion.createQuery(hql);
            oPersona = (Persona) query.uniqueResult();
        } catch (HibernateException e) {
            oPersona = new Persona();
            manejaExcepcion(e);
        }finally{
            cerrarSesion();
        }
        return oPersona;
    }

    public int actualizar(Persona obj) throws HibernateException {
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

    public Persona buscar(long id) throws HibernateException {
        try {
            iniciarOperacion();
            obj = (Persona) sesion.get(Persona.class, id);
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return obj;
    }

    public ArrayList<Persona> listar() {
        try {
            iniciarOperacion();
            String hql = "from Persona per";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Persona>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
//        finally{
//            sesion.close();
//        }
        return list;
    }

    public ArrayList<Persona> buscarxNombres(String nombres) {
        try {
            iniciarOperacion();
            String hql = "from Persona p where (p.apellidoPaterno || ' ' || "
                    + "p.apellidoMaterno || ' ' || p.nombre) like '%" + nombres + "%'";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Persona>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        return list;
    }

    public List<Persona> listarPersonaXDoc(String ref) throws HibernateException {
        try {
            iniciarOperacion();
            String hql = "from Persona a left join fetch a.estadoCivil b left join fetch a.tipoDocidentidad c "
                    + "left  join fetch a.tipoPersona d "
                    + "where a.numeroDocumento like '%" + ref + "%' or a.ruc like '%" + ref + "%' "
                    + "order by a.numeroDocumento asc";
            Query query = sesion.createQuery(hql);
            listPersonas = query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            listPersonas = new LinkedList<>();
        } finally {
            sesion.close();
        }
        return listPersonas;
    }

    public List<Persona> listarPersonaXNombres(String ref) throws HibernateException {
        try {
            iniciarOperacion();
            String hql = "from Persona a left join fetch a.estadoCivil b left join fetch a.tipoDocidentidad c "
                    + "left  join fetch a.tipoPersona d "
                    + "where (a.apellidoPaterno || ' ' || a.apellidoMaterno || ' ' || a.nombre) like '%" + ref + "%' "
                    + "order by a.apellidoPaterno asc";
            Query query = sesion.createQuery(hql);
            listPersonas = query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            listPersonas = new LinkedList<>();
        } finally {
            sesion.close();
        }
        return listPersonas;
    }

    public Persona buscarPersonaXRuc(String ref) {
        oPersona = new Persona();
        try {
            iniciarOperacion();
            String hql = "from Persona as p left join fetch p.estadoCivil b left join fetch p.tipoDocidentidad c "
                    + "left join fetch p.tipoPersona d "
                    + "where p.ruc='" + ref + "'";
            Query query = sesion.createQuery(hql);
            oPersona = (Persona) query.uniqueResult();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } finally {
            sesion.close();
        }
        return oPersona;
    }

    public int registrarPersonaMedico(Persona oPersona, Medico oMedico, ModeloMedicoEspecialidad oModeloEspecialidad) {
        int res;
        try {
            iniciarOperacion();
            //Medico
            oMedico.setPersona(oPersona);
            sesion.save(oMedico);
            //Medico x especialidad
            for (int i = 0; i < oModeloEspecialidad.size(); i++) {
                MedicoEspecialidad me = oModeloEspecialidad.get(i);
                me.setMedico(oMedico);
                sesion.save(me);
            }
            tx.commit();
            res = SUCCESS;
        } catch (HibernateException e) {
            res = ERROR;
            manejaExcepcion(e);
        } finally {
            sesion.close();
        }
        return res;

    }

    public int actualizarPersonaMedico(Persona oPersona, Medico oMedico) {
        int res;
        try {
            iniciarOperacion();
            //Medico
            oMedico.setPersona(oPersona);
            sesion.update(oMedico);
            tx.commit();
            res = SUCCESS;
        } catch (HibernateException e) {
            res = ERROR;
            manejaExcepcion(e);
            //e.printStackTrace();
        } finally {
            sesion.close();
        }
        return res;
    }

    public int actualizar(Persona oPersona, HistoriaClinica oHistoriaClinica, ModelosSeguroVida msv) {
        int res;
        try {
            iniciarOperacion();
            sesion.update(oPersona);
            if (oHistoriaClinica != null) {
                oHistoriaClinica.setPersona(oPersona);
                sesion.save(oHistoriaClinica);
            }
            //Registrar Seguros
            SeguroVidaUsaPersona oSeguroPersona = new SeguroVidaUsaPersona();
            SeguroVida seguro = new SeguroVida();
            for (int i = 0; i < msv.size(); i++) {
                seguro = (SeguroVida) msv.get(i);
                if (!existeSeguroPersona(oPersona.getIdpersona(), msv.get(i).getIdSeguroVida())) {
                    oSeguroPersona.setSeguroVida(seguro);
                    oSeguroPersona.setPersona(oPersona);
                    oSeguroPersona.setEstado(true);
                    oSeguroPersona.setFechaReg(new Date());
                    sesion.save(oSeguroPersona);
                }
            }
            tx.commit();
            res = SUCCESS;
        } catch (HibernateException e) {
            res = ERROR;
            manejaExcepcion(e);
            //e.printStackTrace();
        } finally {
            cerrarSesion();
        }
        return res;
    }

    public boolean existeSeguroPersona(long idPersona, int idSeguro) {
        SeguroPersonaBl blSeguroPersona = new SeguroPersonaBl();
        SeguroVidaUsaPersona temp = new SeguroVidaUsaPersona();
        boolean existe = false;
        temp = blSeguroPersona.buscarSeguroPersona(idPersona, idSeguro);
        if (temp == null) {
            existe = false;
        } else {
            existe = true;
        }
        return existe;
    }

    public int registrar(Persona oPersona, HistoriaClinica oHistoriaClinica, ModelosSeguroVida msv) {
        int res;
        try {
            iniciarOperacion();
            sesion.save(oPersona);
            if (oHistoriaClinica != null) {
                oHistoriaClinica.setPersona(oPersona);
                sesion.save(oHistoriaClinica);
            }
            //Registrar Seguros
            SeguroVidaUsaPersona oSeguroPersona = new SeguroVidaUsaPersona();
            SeguroVida seguro = new SeguroVida();
            for (int i = 0; i < msv.size(); i++) {
                seguro = (SeguroVida) msv.get(i);
                if (!existeSeguroPersona(oPersona.getIdpersona(), msv.get(i).getIdSeguroVida())) {
                    oSeguroPersona.setSeguroVida(seguro);
                    oSeguroPersona.setPersona(oPersona);
                    oSeguroPersona.setEstado(true);
                    oSeguroPersona.setFechaReg(new Date());
                    sesion.save(oSeguroPersona);
                }
            }
            tx.commit();
            res = SUCCESS;
        } catch (HibernateException e) {
            res = ERROR;
            manejaExcepcion(e);
        } finally {
            cerrarSesion();
        }
        return res;
    }

}
