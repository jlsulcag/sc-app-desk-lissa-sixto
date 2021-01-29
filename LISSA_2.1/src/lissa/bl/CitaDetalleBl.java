
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.CitaDetalle;
import lissa.dao.CitaDetalleDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

/**
 *
 * @author JSULCAG
 */
public class CitaDetalleBl extends AbstractBL<CitaDetalle>{

    private CitaDetalleDao dao;
    
    @Override
    public AbstractDA getDAO() {
        dao = new CitaDetalleDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (CitaDetalleDao) dao;
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
        return list();
    }

    @Override
    public ArrayList<CitaDetalle> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CitaDetalle> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CitaDetalle buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CitaDetalle buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<CitaDetalle> listarxIdCita() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<CitaDetalle> listarxIdCita(long idcita) {
        dao = new CitaDetalleDao();
        return dao.listarxIdCita(idcita);
    }
    
}
