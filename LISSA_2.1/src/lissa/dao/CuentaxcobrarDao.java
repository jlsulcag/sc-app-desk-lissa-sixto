
package lissa.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lissa.be.Cuentaxcobrar;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CuentaxcobrarDao extends AbstractDA<Cuentaxcobrar>{

    private Session sesion;
    private Transaction tx;
    private List<Cuentaxcobrar> list;
    
    @Override
    public Cuentaxcobrar registrar(Cuentaxcobrar bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Cuentaxcobrar bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Cuentaxcobrar bean) {
        return delete(bean);
    }

    @Override
    public List<Cuentaxcobrar> listar() {
        return list(Cuentaxcobrar.class);
    }

    @Override
    public ArrayList<Cuentaxcobrar> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cuentaxcobrar> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cuentaxcobrar buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cuentaxcobrar buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Cuentaxcobrar> listarxCobrar(int idBeneficio) {
        try {
            iniciarOperacion();
            String hql = "from Cuentaxcobrar a left join fetch a.venta b left join fetch a.beneficio c "
                    + "left join fetch a.fondoSolidaridad d left join fetch a.usuario e "
                    + "left join fetch b.clientepersonanatural f "
                    + "left join fetch c.seguroVida g "
                    + "where a.estado = 'DEBE' and c.idbeneficio = "+idBeneficio + " "
                    + "ORDER BY b.fechaVenta desc, b.numOperacion desc";
            list = sesion.createQuery(hql).list();
            tx.commit();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            list = new LinkedList<>();
        }finally{
            cerrarSesion();
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
    
    private void manejaExcepcion(HibernateException he) {
        tx.rollback();
        Mensajes.ErrorFatal(he);
    }

    public void cerrarSesion() {
        sesion.close();
    }
    
}
