package lissa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.ComprobanteDetalle;
import lissa.be.Atencion;
import lissa.util.AbstractDA;
import lissa.util.Utilitarios;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jorge Luis Sulca González
 */
public class ItemsComprobanteDao extends AbstractDA<ComprobanteDetalle> {

    private Session sesion;
    private Transaction tx;
    private ArrayList<ComprobanteDetalle> list;

    @Override
    public ComprobanteDetalle registrar(ComprobanteDetalle bean) {
        return save(bean);
    }

    @Override
    public int actualizar(ComprobanteDetalle bean) {
        return update(bean);
    }

    @Override
    public int eliminar(ComprobanteDetalle bean) {
        return delete(bean);
    }

    @Override
    public List<ComprobanteDetalle> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ComprobanteDetalle> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<ComprobanteDetalle> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ComprobanteDetalle buscar(long id) {
        return search(ComprobanteDetalle.class, id);
    }

    @Override
    public ComprobanteDetalle buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<ComprobanteDetalle> buscarXPaciente(String numeroDocumento) {
        try {
            iniciarOperacion();
            list = (ArrayList<ComprobanteDetalle>) sesion.createQuery("select ic from ItemsComprobante ic inner join ic.comprobante c inner join c.paciente pac inner join pac.persona per where per.numeroDocumento='" + numeroDocumento + "'").list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        tx.commit();
        return list;
    }

    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        JOptionPane.showMessageDialog(null, "" + he, "Error", JOptionPane.ERROR_MESSAGE);
        //throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public ArrayList<ComprobanteDetalle> listarServicios(Atencion oAtencion) {
        try {
            iniciarOperacion();
            String hql = "from ComprobanteDetalle a left join fetch a.comprobante b left join fetch b.atencion c "
                    + "left join fetch c.persona d left join fetch a.medicoByIdMedicoAtiende e left join fetch "
                    + "e.persona f left join fetch a.procedimientoTarifario g left join fetch g.procedimiento h "
                    + "left join fetch a.medicoatiendereal i left join fetch i.persona j left join fetch a.medicoByIdMedicoDeriva k "
                    + "left join fetch k.persona l left join fetch c.historiaClinica m "
                    + "where c.idatencion=" + oAtencion.getIdatencion() + " "
                    + "order by b.numeroOperacion desc";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<ComprobanteDetalle>) query.list();
            tx.commit();
            sesion.close();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        return list;
    }

    public ArrayList<ComprobanteDetalle> listarxRango(Date inicio, Date fin, long idMedico) {
        try {
            String hql = "from ComprobanteDetalle a left join fetch a.comprobante b left join fetch b.atencion c "
                    + "left join fetch c.persona d left join fetch a.medicoByIdMedicoAtiende e left join fetch "
                    + "e.persona f left join fetch a.procedimientoTarifario g left join fetch g.procedimiento h "
                    + "left join fetch a.medicoatiendereal i left join fetch i.persona j left join fetch a.medicoByIdMedicoDeriva k "
                    + "left join fetch k.persona l left join fetch c.historiaClinica m "
                    + "where b.fechaComprobante between '" + Utilitarios.castDate_UTIL_SQL(inicio) + "' and '" + Utilitarios.castDate_UTIL_SQL(fin) + "' "
                    + "and i.idMedico = "+idMedico +" "
                    + "order by b.numeroOperacion desc";
            iniciarOperacion();
            Query q = sesion.createQuery(hql);
            ArrayList<ComprobanteDetalle> l = (ArrayList) q.list();
            tx.commit();
            sesion.close();
            return l;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        }
    }
    
    public ArrayList<ComprobanteDetalle> listarxRango(Date inicio, Date fin) {
        try {
            String hql = "from ComprobanteDetalle a left join fetch a.comprobante b left join fetch b.atencion c "
                    + "left join fetch c.persona d left join fetch a.medicoByIdMedicoAtiende e left join fetch "
                    + "e.persona f left join fetch a.procedimientoTarifario g left join fetch g.procedimiento h "
                    + "left join fetch a.medicoatiendereal i left join fetch i.persona j left join fetch a.medicoByIdMedicoDeriva k "
                    + "left join fetch k.persona l left join fetch c.historiaClinica m "
                    + "where b.fechaComprobante between '" + Utilitarios.castDate_UTIL_SQL(inicio) + "' and '" + Utilitarios.castDate_UTIL_SQL(fin) + "' "
                    + "order by b.numeroOperacion desc";
            iniciarOperacion();
            Query q = sesion.createQuery(hql);
            ArrayList<ComprobanteDetalle> l = (ArrayList) q.list();
            tx.commit();
            sesion.close();
            return l;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        }
    }

    public ArrayList<ComprobanteDetalle> listarSabanon(Date inicio, Date fin) {
        ArrayList<ComprobanteDetalle> l;
        try {
            String hql = "from ComprobanteDetalle a "
                    + "left join fetch a.comprobante b "
                    + "left join fetch b.atencion c "
                    + "left join fetch c.persona d "
                    + "left join fetch a.medicoByIdMedicoAtiende e "
                    + "left join fetch e.persona f "
                    + "left join fetch a.medicoatiendereal g "
                    + "left join fetch g.persona h "
                    + "left join fetch b.beneficio i "
                    + "left join fetch i.seguroVida j "
                    + "left join fetch a.procedimientoTarifario k "
                    + "left join fetch k.procedimiento l "
                    + "left join fetch l.servicio m "
                    + "left join fetch b.tipoComprobante n "
                    + "left join fetch a.medicoByIdMedicoDeriva o "
                    + "left join fetch o.persona p "
                    + "left join fetch c.historiaClinica q "
                    + "where b.fechaComprobante between '" + Utilitarios.castDate_UTIL_SQL(inicio) + "' and '" + Utilitarios.castDate_UTIL_SQL(fin) + "' "
                    //+ "and b.estado = 'ACT' "
                    + "order by b.numeroOperacion desc";
            iniciarOperacion();
            Query q = sesion.createQuery(hql);
            l = (ArrayList) q.list();
            tx.commit();
            return l;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return new ArrayList<>();
        } finally {
            sesion.close();
        }
    }

    public ArrayList<ComprobanteDetalle> buscarxNumeroHC(String hc) {
        try {
            String hql = "from ComprobanteDetalle a left join fetch a.comprobante b left join fetch b.atencion c "
                    + "left join fetch c.persona d left join fetch a.medicoByIdMedicoAtiende e left join fetch "
                    + "e.persona f left join fetch a.procedimientoTarifario g left join fetch g.procedimiento h "
                    + "left join fetch a.medicoatiendereal i left join fetch i.persona j left join fetch a.medicoByIdMedicoDeriva k "
                    + "left join fetch k.persona l left join fetch c.historiaClinica m "
                    + "where m.numerohc = " + Integer.parseInt(hc) + " "
                    + "order by b.numeroOperacion desc";
            iniciarOperacion();
            Query q = sesion.createQuery(hql);
            ArrayList<ComprobanteDetalle> l = (ArrayList) q.list();
            tx.commit();
            sesion.close();
            return l;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        }

    }

    public ArrayList<ComprobanteDetalle> buscarxRangoYNumeroHC(Date inicio, Date fin, String hc) {
        try {
            String hql = "from ComprobanteDetalle a left join fetch a.comprobante b left join fetch b.atencion c "
                    + "left join fetch c.persona d left join fetch a.medicoByIdMedicoAtiende e left join fetch "
                    + "e.persona f left join fetch a.procedimientoTarifario g left join fetch g.procedimiento h "
                    + "left join fetch a.medicoatiendereal i left join fetch i.persona j left join fetch a.medicoByIdMedicoDeriva k "
                    + "left join fetch k.persona l left join fetch c.historiaClinica m "
                    + "where m.numerohc = " + Integer.parseInt(hc) + " and "
                    + "b.fechaComprobante between '" + Utilitarios.castDate_UTIL_SQL(inicio) + "' and '" + Utilitarios.castDate_UTIL_SQL(fin) + "' "
                    + "order by b.numeroOperacion desc";
            iniciarOperacion();
            Query q = sesion.createQuery(hql);
            ArrayList<ComprobanteDetalle> l = (ArrayList) q.list();
            tx.commit();
            sesion.close();
            return l;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        }
    }

    public List<ComprobanteDetalle> listarAtencionesxFPS(long idFondosolidaridad) {
         try {
            String hql = "from ComprobanteDetalle a left join fetch a.comprobante b left join fetch b.atencion c "
                    + "left join fetch b.beneficio i left join fetch i.seguroVida j "
                    + "left join fetch a.procedimientoTarifario k left join fetch k.procedimiento l "
                    + "left join fetch l.servicio m left join fetch b.tipoComprobante n "
                    + "where  b.fondoSolidaridad.idFondosolidaridad = "+idFondosolidaridad + " "
                    + "order by b.fechaComprobante desc";
            iniciarOperacion();
            Query q = sesion.createQuery(hql);
            ArrayList<ComprobanteDetalle> l = (ArrayList) q.list();
            tx.commit();
            return l;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        } finally {
            sesion.close();
        }
    }

    public List<ComprobanteDetalle> listarXidComprobante(long idcomprobante) throws HibernateException{
        try {
            String hql = "from ComprobanteDetalle a left join fetch a.comprobante b "
                    + "left join fetch a.medicoByIdMedicoAtiende e left join fetch e.persona f "
                    + "left join fetch a.procedimientoTarifario g left join fetch g.procedimiento h "
                    + "left join fetch a.medicoatiendereal i left join fetch i.persona j left join fetch a.medicoByIdMedicoDeriva k "
                    + "left join fetch k.persona l "
                    + "left join fetch h.servicio m "
                    + "where b.idcomprobante = :idcomprobante "
                    + "order by a.idcomprobantedetalle asc";
            iniciarOperacion();
            Query q = sesion.createQuery(hql);
            q.setParameter("idcomprobante", idcomprobante);
            ArrayList<ComprobanteDetalle> l = (ArrayList) q.list();
            tx.commit();
            return l;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        } finally {
            sesion.close();
        }
    }

}
