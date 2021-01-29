package lissa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lissa.be.MedicoDerivaAtiende;
import lissa.util.AbstractDA;
import lissa.util.Utilitarios;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MedicoDerivaAtiendeDao extends AbstractDA<MedicoDerivaAtiende> {

    private Session sesion;
    private Transaction tx;
    private ArrayList<MedicoDerivaAtiende> list;
    //private MedicoDerivaAtiende obj = null;
    public static final int SUCCESS = 1, ERROR = 2;

    @Override
    public MedicoDerivaAtiende registrar(MedicoDerivaAtiende bean) {
        return save(bean);
    }

    @Override
    public int actualizar(MedicoDerivaAtiende bean) {
        return update(bean);

    }
    
    @Override
    public int eliminar(MedicoDerivaAtiende bean) {
        return delete(bean);
    }

    @Override
    public List<MedicoDerivaAtiende> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<MedicoDerivaAtiende> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MedicoDerivaAtiende> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MedicoDerivaAtiende buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MedicoDerivaAtiende buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    public ArrayList<MedicoDerivaAtiende> buscarXMedico(String ref) {
        try {
            iniciarOperacion();
            String hql = "select mda from MedicoDerivaAtiende mda inner join mda.itemsComprobante ic inner join ic.comprobante c inner join ic.medicoByIdMedicoAtiende ma inner join ma.persona pe\n"
                    + "inner join ic.servicio ser inner join c.paciente pa inner join pa.persona pe2 where c.fechaBoleta BETWEEN '2016-01-01' and '2017-03-17' and\n"
                    + "pe.nombre like '%" + ref + "%'";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<MedicoDerivaAtiende>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        //tx.commit();
        return list;
    }

    private void manejaExcepcion(HibernateException e) {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", e);
    }

    public ArrayList<MedicoDerivaAtiende> listar(Date date, Date date0, String tipoMedico) {
        try {
            iniciarOperacion();
            String hql = "select mda from MedicoDerivaAtiende mda left join mda.itemsComprobante ic inner join ic.comprobante c inner join mda.medico m inner join m.persona pe\n"
                    + " inner join c.paciente pa inner join pa.persona pe2 where c.fechaBoleta BETWEEN '" + Utilitarios.castDate_UTIL_SQL(date) + "' and '" + Utilitarios.castDate_UTIL_SQL(date0) + "' and\n"
                    + " mda.tipoMedico='" + tipoMedico + "'";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<MedicoDerivaAtiende>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        return list;
    }

    public List<MedicoDerivaAtiende> listarxRango(Date inicio, Date fin) {
        try {
            iniciarOperacion();
            String hql = "from MedicoDerivaAtiende a1 left join fetch a1.comprobanteDetalle a left join fetch a.comprobante b left join fetch b.atencion c "
                    + "left join fetch c.persona d left join fetch a.procedimientoTarifario g left join fetch g.procedimiento h "
                    + "left join fetch a1.medico i left join fetch i.persona j "
                    + "where b.fechaComprobante between '" + Utilitarios.castDate_UTIL_SQL(inicio) + "' and '" + Utilitarios.castDate_UTIL_SQL(fin) + "' "
                    + "order by b.numeroOperacion asc";
            Query q = sesion.createQuery(hql);
            List<MedicoDerivaAtiende> l = (ArrayList) q.list();
            tx.commit();
            sesion.close();
            return l;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        }
    }

    public List<MedicoDerivaAtiende> listarxRango(Date inicio, Date fin, int idMedico) {
        try {
            iniciarOperacion();
            String hql = "from MedicoDerivaAtiende a1 left join fetch a1.comprobanteDetalle a left join fetch a.comprobante b left join fetch b.atencion c "
                    + "left join fetch c.persona d left join fetch a.procedimientoTarifario g left join fetch g.procedimiento h "
                    + "left join fetch a1.medico i left join fetch i.persona j "
                    + "left join fetch a1.usuariopago k "
                    + "left join fetch c.historiaClinica "
                    + "where b.fechaComprobante between '" + Utilitarios.castDate_UTIL_SQL(inicio) + "' and '" + Utilitarios.castDate_UTIL_SQL(fin) + "' "
                    + "and i.idMedico = "+idMedico+" "
                    + "order by b.numeroOperacion desc";
            Query q = sesion.createQuery(hql);
            List<MedicoDerivaAtiende> l = (ArrayList) q.list();
            tx.commit();
            sesion.close();
            return l;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        }
    }
}
