package lissa.bl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lissa.be.Atencion;
import lissa.be.Caja;
import lissa.be.Comprobante;
import lissa.be.ComprobanteDetalle;
import lissa.be.Persona;
import lissa.be.TipoComprobante;
import lissa.dao.ComprobanteDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

/**
 *
 * @author Jorge Luis Sulca González
 */
public class ComprobanteBl extends AbstractBL<Comprobante> {

    private ComprobanteDao dao;
    private ArrayList<Comprobante> list;

    @Override
    public AbstractDA getDAO() {
        dao = new ComprobanteDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (ComprobanteDao) dao;
    }

    @Override
    public Comprobante registrar(Comprobante bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Comprobante bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Comprobante bean) {
        return delete(bean);
    }

    @Override
    public List<Comprobante> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Comprobante> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comprobante> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comprobante buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comprobante buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public List<Comprobante> buscarXnumComprobante(long ref) {
        dao = new ComprobanteDao();
        return dao.buscarXnumComprobante(ref);
    }

    public ArrayList<Comprobante> buscarXtipoDoc(String ref) {
        dao = new ComprobanteDao();
        list = dao.buscarXtipoDoc(ref);
        return list;
    }

    public ArrayList<Comprobante> buscarXfecha(Date ref) {
        dao = new ComprobanteDao();
        list = dao.buscarXfecha(ref);
        return list;
    }


    public Comprobante buscarXPaciente(String numeroDocumento) {
        dao = new ComprobanteDao();
        return dao.buscarXPaciente(numeroDocumento);
    }

    public ArrayList<Comprobante> buscarXNombre(String nombres) {
        dao = new ComprobanteDao();
        return dao.buscarXNombre(nombres);
    }

    public BigDecimal calcuatTotalRecibo(Caja oCaja) {
        dao = new ComprobanteDao();
        return dao.calcuatTotalRecibo(oCaja);
    }

    public BigDecimal calcularTotalBoleta(Caja oCaja) {
        dao = new ComprobanteDao();
        return dao.calcularTotalBoleta(oCaja);
    }

    public BigDecimal calcularTotalFactura(Caja oCaja) {
        dao = new ComprobanteDao();
        return dao.calcularTotalFactura(oCaja);
    }

    public ArrayList<Comprobante> listarAtencionFondo(Caja oCaja) {
        dao = new ComprobanteDao();
        return dao.listarAtencionFondo(oCaja);
    }

    public void cerrarSesion() {
        dao = new ComprobanteDao();
        dao.cerrarSesion();
    }

    public Comprobante buscarXnumDoc(Integer numeroBoleta, TipoComprobante tipoComprobante) {
        dao = new ComprobanteDao();
        return dao.buscarXnumDoc(numeroBoleta, tipoComprobante);
    }

    public ArrayList<Comprobante> listar(Persona per) {
        dao = new ComprobanteDao();
        return dao.listar(per);
    }

    public int registrar(Comprobante oComprobante, List<ComprobanteDetalle> listComprobanteDetalle, Atencion oAtencion) {
        dao = new ComprobanteDao();
        return dao.registrar(oComprobante, listComprobanteDetalle, oAtencion);
    }

    public List<Comprobante> buscarXRangoFecha(java.sql.Date inicio, java.sql.Date fin, String numeroCarta) {
        dao = new ComprobanteDao();
        return dao.buscarXRangoFecha(inicio, fin, numeroCarta);
    }
}
