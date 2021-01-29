
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Beneficio;
import lissa.be.Atencion;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BeneficioDao extends AbstractDA<Beneficio>{
    private Session sesion;
    private Transaction tx;
    private Beneficio obj = null;
    List<Beneficio> list = null;
    
    public List<Beneficio> buscarXIdSeguro(Integer id) {
        
        try {
            iniciarOperacion();
            String hql = "from Beneficio ben left join fetch ben.seguroVida sv where sv.idSeguroVida=" + id;
            Query query = sesion.createQuery(hql);
            list = query.list();
            tx.commit();
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

    @Override
    public Beneficio registrar(Beneficio bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Beneficio bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Beneficio bean) {
        return delete(bean);
    }

    @Override
    public List<Beneficio> listar() {
        return list(Beneficio.class);
    }

    @Override
    public ArrayList<Beneficio> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<Beneficio> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Beneficio buscar(long id) {
        return search(Beneficio.class, id);
    }

    @Override
    public Beneficio buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
