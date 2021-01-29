
package lissa.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lissa.be.Medico;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MedicoDao {
    private Session sesion;
    private Transaction tx;
    private List<Medico> list;
    private Medico obj;
    
    public int registrar(Medico obj) {
        int id = 0;
        try {
            iniciarOperacion();
            id = (int) sesion.save(obj);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return id;
    }
    
    public void actualizar(Medico obj) {
        try {
            iniciarOperacion();
            sesion.update(obj);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        }
    }
    //Optimo para obtener objetos basado en una clave foranea
    public Medico buscarId(int id) {
        Medico bean = new Medico();
        iniciarOperacion();
        String hql = "from Medico as m where m.idPersona = :id_Medico";
        Query query = sesion.createQuery(hql);
        query.setParameter("id_Medico", id);
        bean = (Medico) query.uniqueResult();
        return bean;
    }
    
    public List<Medico> buscar(String ref) {
        try {
            iniciarOperacion();
            StringBuilder hql = new StringBuilder();
            hql.append("Select m from Medico m left join fetch m.persona p left join fetch m.tipoMedico c ");
            hql.append("where (p.apellidoPaterno || ' ' || p.apellidoMaterno || ' ' || p.nombre) like :ref ");
            hql.append("order by p.apellidoPaterno asc ");
            
            Query query = sesion.createQuery(hql.toString());
            query.setParameter("ref", "%"+ ref+"%");
            list = query.list();
        } catch (HibernateException e) {
            list = new LinkedList<>();
            manejaExcepcion(e);
        } finally{
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
        Mensajes.ErrorFatal(he);
    }

    public Medico buscarMedicoXDni(String dni) {
        try {
            iniciarOperacion();
            String hql = "Select m from Medico m left join fetch m.persona p where p.numeroDocumento='" + dni + "' "
                    + "and m.estado = true";
            Query query = sesion.createQuery(hql);
            obj = (Medico) query.uniqueResult();
        } catch (HibernateException he) {
            obj = new Medico();
            manejaExcepcion(he);
        } finally{
            sesion.close();
        }
        return obj;
    }
    
//    public ArrayList<Medico> buscarxNombres(String ref) {
//        try {
//            iniciarOperacion();
//            String hql = "Select m from Medico m inner join m.persona p "
//                    + "where (p.apellidoPaterno || ' ' || p.apellidoMaterno || ' ' || p.nombre) like '%" + ref + "%' "
//                    + "and m.estado = true";
//            Query query = sesion.createQuery(hql);
//            list = (ArrayList<Medico>) query.list();
//        } catch (HibernateException e) {
//            manejaExcepcion(e);
//        }
//        return list;
//    }
//
    public ArrayList<Medico> listar() {
        ArrayList<Medico> list = new ArrayList<>();
        try {
            iniciarOperacion();
            String hql = "from Medico m left join fetch m.persona b where m.estado = true";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Medico>) query.list();
        } catch (HibernateException he) {
            list = new ArrayList<>();
            manejaExcepcion(he);
        }finally{
            sesion.close();
        }
        
        return list;
    }

    
}
