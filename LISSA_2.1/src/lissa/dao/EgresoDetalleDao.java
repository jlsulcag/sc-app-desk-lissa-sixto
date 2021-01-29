package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.EgresoDetalle;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JSULCAG
 */
public class EgresoDetalleDao extends AbstractDA<EgresoDetalle> {

    private Session sesion;
    private Transaction tx;

    @Override
    public EgresoDetalle registrar(EgresoDetalle bean) {
        return save(bean);
    }

    @Override
    public int actualizar(EgresoDetalle bean) {
        return update(bean);
    }

    @Override
    public int eliminar(EgresoDetalle bean) {
        return delete(bean);
    }

    @Override
    public List<EgresoDetalle> listar() {
        return list(EgresoDetalle.class);
    }

    @Override
    public ArrayList<EgresoDetalle> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<EgresoDetalle> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EgresoDetalle buscar(long id) {
        return search(EgresoDetalle.class, id);
    }

    @Override
    public EgresoDetalle buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId(EgresoDetalle.class);
    }

    public List<EgresoDetalle> listarxMedico(int idMedico) {
        List<EgresoDetalle> list = null;
        try {
            iniciarOperacion();
            String hql = "from EgresoDetalle a left join fetch a.egreso b left join fetch a.medicoDerivaAtiende c "
                    + "left join fetch c.medico d where d.idMedico = ?";
            Query query = sesion.createQuery(hql);
            query.setParameter(0, idMedico);
            list = query.list();
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return list;
    }

    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        JOptionPane.showMessageDialog(null, "ERROR FATAL ... " + he, "Error", JOptionPane.ERROR_MESSAGE);
    }

}
