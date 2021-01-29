
package lissa.bl;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lissa.be.Caja;
import lissa.be.Cuentaxcobrar;
import lissa.be.DetalleVenta;
import lissa.be.HistorialAtencionFps;
import lissa.be.Kardex;
import lissa.be.Usuario;
import lissa.be.Venta;
import lissa.dao.VentaDao;
import lissa.table.ModeloVentaProducto;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class VentaBl extends AbstractBL<Venta>{
    private VentaDao dao;
    
    @Override
    public AbstractDA getDAO() {
        dao = new VentaDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (VentaDao) dao;
    }

    @Override
    public Venta registrar(Venta bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Venta bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Venta bean) {
        return delete(bean);
    }

    @Override
    public List<Venta> listar() {
        return list();
    }

    @Override
    public ArrayList<Venta> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<Venta> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta buscar(long id) {
        return search(id);
    }

    @Override
    public Venta buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public long obtenerUltNumero(int id) {
        dao = new VentaDao();
        return dao.obtenerUltNumero(id);
    }
    public int obtenerNumOperacion() {
        dao = new VentaDao();
        return dao.obtenerNumOperacion();
    }

//    public int obtenerNumeroOperacion() {
//        dao = new VentaDao();
//        return dao.obtenerNumeroOperacion();
//    }
    public BigDecimal calcularTotalBoleta(Caja oCaja) {
        dao = new VentaDao();
        return dao.calcularTotalBoleta(oCaja);
    }
    public BigDecimal calcularTotalFactura(Caja oCaja) {
        dao = new VentaDao();
        return dao.calcularTotalFactura(oCaja);
    }

    public List<Venta> listarxIdCliente(long idPersona) {
        dao = new VentaDao();
        return dao.listarxIdCliente(idPersona);
    }
    public List<Venta> listarAll() {
        dao = new VentaDao();
        return dao.listarAll();
    }

    public List<Venta> listarXNumComprobante(String num) {
        dao = new VentaDao();
        return dao.listarXNumComprobante(num);
    }

    public Venta buscarXidVenta(long idVenta) {
        dao = new VentaDao();
        return dao.buscarXidVenta(idVenta);
    }

    public int registrar(Venta oVenta, ModeloVentaProducto omvp, Cuentaxcobrar cc, HistorialAtencionFps histfpf, List<Kardex> listKardex) {
        dao = new VentaDao();
        return dao.registrar(oVenta, omvp, cc, histfpf, listKardex);
    }

    public int actualizar(Venta oVentaTemp, List<DetalleVenta> listDetalleVenta) {
        dao = new VentaDao();
        return dao.actualizar(oVentaTemp, listDetalleVenta);
    }

    public List<Venta> listarXusuarioYFecha(Usuario usuario, Date fechaVenta) {
        dao = new VentaDao();
        return dao.listarXusuarioYFecha(usuario, fechaVenta);
    }

    public int enviarComprobanteElectronicoASunat(Venta oVenta, List<DetalleVenta> listDetalleVenta) {
        dao = new VentaDao();
        return dao.enviarComprobanteElectronicoASunat(oVenta, listDetalleVenta);
    }
    
    
}
