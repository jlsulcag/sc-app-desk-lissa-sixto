package lissa.bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lissa.be.ComprobanteDetalle;
import lissa.be.Atencion;
import lissa.dao.ItemsComprobanteDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

/**
 *
 * @author Jorge Luis Sulca González
 */
public class ItemsComprobanteBl extends AbstractBL<ComprobanteDetalle>{
    private ItemsComprobanteDao dao;

    @Override
    public AbstractDA getDAO() {
        dao = new ItemsComprobanteDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (ItemsComprobanteDao) dao;
    }

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
        return list();
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
        return search(id);
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
        dao = new ItemsComprobanteDao();
        return dao.buscarXPaciente(numeroDocumento);
    }

    public ArrayList<ComprobanteDetalle> listarServicios(Atencion oPaciente) {
        dao = new ItemsComprobanteDao();
        return dao.listarServicios(oPaciente);
    }


    public ArrayList<ComprobanteDetalle> listarxRango(Date inicio, Date fin, long idMedico) {
        dao = new ItemsComprobanteDao();
        return dao.listarxRango(inicio, fin, idMedico);
    }
    public ArrayList<ComprobanteDetalle> listarxRango(Date inicio, Date fin) {
        dao = new ItemsComprobanteDao();
        return dao.listarxRango(inicio, fin);
    }

    public ArrayList<ComprobanteDetalle> listarSabanon(Date inicio, Date fin) {
        dao = new ItemsComprobanteDao();
        return dao.listarSabanon(inicio, fin);
    }

    public ArrayList<ComprobanteDetalle> buscarxNumeroHC(String hc) {
        dao = new ItemsComprobanteDao();
        return dao.buscarxNumeroHC(hc);
    }

    public ArrayList<ComprobanteDetalle> buscarxRangoYNumeroHC(Date inicio, Date fin, String hc) {
        dao = new ItemsComprobanteDao();
        return dao.buscarxRangoYNumeroHC(inicio, fin, hc);
    }

    public List<ComprobanteDetalle> listarAtencionesxFPS(long idFondosolidaridad) {
        dao = new ItemsComprobanteDao();
        return dao.listarAtencionesxFPS(idFondosolidaridad);
    }

    public List<ComprobanteDetalle> listarXidComprobante(long idcomprobante) {
        dao = new ItemsComprobanteDao();
        return dao.listarXidComprobante(idcomprobante);
    }
   
}
