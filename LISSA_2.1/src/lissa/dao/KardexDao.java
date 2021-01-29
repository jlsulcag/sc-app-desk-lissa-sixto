
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Kardex;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class KardexDao extends AbstractDA<Kardex>{

    private Session sesion;
    private Transaction tx;
    
    @Override
    public Kardex registrar(Kardex bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Kardex bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Kardex bean) {
        return delete(bean);
    }

    @Override
    public List<Kardex> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Kardex> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<Kardex> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Kardex buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Kardex buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long generarNumeracion(int grupo) {
        iniciarOperacion();
        long num = 0;
        String hql = "select max(k.numComprobante) from Kardex k where k.grupoNumeracion = " + grupo;
        Query query = sesion.createQuery(hql);
        if(query.uniqueResult() == null){
            num = 0;
        }else{
            num = (long) query.uniqueResult();
        }        
        tx.commit();
        return num;
    }
    
    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }
    
    private void manejaExcepcion(HibernateException he) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Kardex> listarxProducto(long idproducto, long idalmacen) {
        String hql = "from Kardex a where a.idProducto = "+idproducto+" and a.idAlmacenAfectado = "+idalmacen+" order by a.fechaMov desc, a.nroOrden desc";
        return listar(hql);
    }

    public long nroOrdenregistro(Long idProducto) {
        iniciarOperacion();
        long num = 0;
        String hql = "select max(k.nroOrden) from Kardex k where k.idProducto = " + idProducto;
        Query query = sesion.createQuery(hql);
        if(query.uniqueResult() == null){
            num = 0;
        }else{
            num = (long) query.uniqueResult();
        }        
        tx.commit();
        return num;
    }
    
}
