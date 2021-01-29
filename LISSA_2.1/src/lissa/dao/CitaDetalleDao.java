package lissa.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lissa.be.CitaDetalle;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JSULCAG
 */
public class CitaDetalleDao extends AbstractDA<CitaDetalle> {

    private Session sesion;
    private Transaction tx;
    private List<CitaDetalle> listCitaDetalles;

    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaException(HibernateException he) throws HibernateException {
        if (tx != null) {
            tx.rollback();
        }
        Mensajes.ErrorFatal(he);
    }

    @Override
    public CitaDetalle registrar(CitaDetalle bean) {
        return save(bean);
    }

    @Override
    public int actualizar(CitaDetalle bean) {
        return update(bean);
    }

    @Override
    public int eliminar(CitaDetalle bean) {
        return delete(bean);
    }

    @Override
    public List<CitaDetalle> listar() {
        return list(CitaDetalle.class);
    }

    @Override
    public ArrayList<CitaDetalle> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CitaDetalle> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CitaDetalle buscar(long id) {
        return search(CitaDetalle.class, id);
    }

    @Override
    public CitaDetalle buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId(CitaDetalle.class);
    }

    public List<CitaDetalle> listarxIdCita(long idcita) {
        listCitaDetalles = new LinkedList<>();
        try {
            iniciarOperacion();
            String hql = "from CitaDetalle a left join fetch a.cita b left join fetch a.medico c left join fetch c.persona p "
                    + "left join fetch a.procedimientoTarifario d "
                    + "left join fetch d.procedimiento e left join fetch e.servicio f "
                    + "left join fetch d.tarifario g left join fetch b.beneficio h left join fetch h.seguroVida j "
                    + "where b.idcita = " + idcita + " order by 1";
            Query query = sesion.createQuery(hql);
            listCitaDetalles = query.list();
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx = null;
            }
            manejaException(he);
        } finally {
            sesion.close();
        }
        return listCitaDetalles;
    }

}
