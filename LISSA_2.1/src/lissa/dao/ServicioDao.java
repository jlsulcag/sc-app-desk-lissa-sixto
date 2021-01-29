package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Servicio;
import lissa.be.TipoMedico;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ServicioDao extends AbstractDA<Servicio>{
    private Session sesion;
    private Transaction tx;
    private TipoMedico obj;
    
    public ArrayList<Servicio> buscarRef(String ref) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        ArrayList<Servicio> list = null;

        list = (ArrayList<Servicio>) session.createQuery("from Servicio s where s.denominacion like '%" + ref + "%' or s.subCategoria like '%"+ref+"%' or s.categoria like '%"+ref+"%'").list();
        session.getTransaction().commit();
        return list;
    }

    public ArrayList<Servicio> listarFull() {
        ArrayList<Servicio> list = null;

        try {
            iniciarOperacion();
            String hql = "from Servicio";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Servicio>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
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

    @Override
    public Servicio registrar(Servicio bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Servicio bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Servicio bean) {
        return delete(bean);
    }

    @Override
    public List<Servicio> listar() {
        return list(Servicio.class);
    }

    @Override
    public ArrayList<Servicio> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<Servicio> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Servicio buscar(long id) {
        return search(Servicio.class, id);
    }

    @Override
    public Servicio buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId(Servicio.class);
    }

    public ArrayList listarxIdPadre(long idpadre) {
        String hql = "from Servicio a where a.tarifario.idtarifario = "+idpadre;
        return listar(hql);
    }

    public ArrayList listarTodo() {
        String hql = "from Servicio";
        return listar(hql);
    }
}
