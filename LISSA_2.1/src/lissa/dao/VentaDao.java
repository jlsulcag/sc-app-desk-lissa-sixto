package lissa.dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.ws.rs.ProcessingException;
import lissa.be.AlmacenProducto;
import lissa.be.Caja;
import lissa.be.Cuentaxcobrar;
import lissa.be.DetalleVenta;
import lissa.be.HistorialAtencionFps;
import lissa.be.Kardex;
import lissa.be.Usuario;
import lissa.be.Venta;
import lissa.bl.AlmacenProductoBl;
import lissa.bl.KardexBl;
import lissa.table.ModeloVentaProducto;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Variables;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.openfact.client.OpenfactClientFactory;
import org.openfact.client.OrganizationClient;
import org.openfact.client.oauth.TokenManager;
import org.openfact.client.services.DocumentsService;
import org.openfact.client.services.representations.idm.DocumentRequestRepresentation;
import org.openfact.client.services.representations.idm.DocumentResponseRepresentation;
import org.openfact.client.services.representations.idm.LineRepresentation;

public class VentaDao extends AbstractDA<Venta> {

    private Session sesion;
    private Transaction tx;
    private List<Venta> list;
    private Venta obj;

    private int SUCCESS = 1;
    private int ERROR = 0;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Venta> listar(String hql) {
        hql = "from Venta A where A.order by A.fechaVenta desc";
        return list(hql);
    }

    @Override
    public List<Venta> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta buscar(long id) {
        return search(Venta.class, id);
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
        iniciarOperacion();
        long num = 0;
        String hql = "select max(v.numComprobante) from Venta v where v.grupoNumeracion = " + id;
        Query query = sesion.createQuery(hql);
        if (query.uniqueResult() == null) {
            num = 0;
        } else {
            num = (Long) query.uniqueResult();
        }
        tx.commit();
        return num;
    }

    public int obtenerNumOperacion() {
        iniciarOperacion();
        int num = 0;
        String hql = "select max(v.numOperacion) from Venta as v";
        Query query = sesion.createQuery(hql);
        if (query.uniqueResult() == null) {
            num = 0;
        } else {
            num = (Integer) query.uniqueResult();
        }
        tx.commit();
        return num;
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

    public BigDecimal calcularTotalBoleta(Caja oCaja) {
        BigDecimal total;
        try {
            iniciarOperacion();
            StringBuilder hql = new StringBuilder();
            hql.append("select sum(vt.total) from Venta vt inner join vt.farComprobante fc ");
            hql.append("inner join vt.caja c where c.idcaja = :idCaja ");
            hql.append("and (fc.comprobante = 'BOLETA' OR fc.comprobante = 'BOLETA ELECTRONICA' OR fc.comprobante = 'TICKET BOLETA') ");
            hql.append("and vt.estado='ACT'");
            Query query = sesion.createQuery(hql.toString());
            query.setParameter("idCaja", oCaja.getIdcaja());
            total = (BigDecimal) query.uniqueResult();
            if (total == null || total == new BigDecimal("0.00")) {
                total = new BigDecimal("0.00");
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
            total = BigDecimal.ZERO;
        } finally {
            sesion.close();
        }
        return total;
    }

    public BigDecimal calcularTotalFactura(Caja oCaja) {
        BigDecimal total = BigDecimal.ZERO;
        try {
            iniciarOperacion();
            String hql = "select sum(vt.total) from Venta vt inner join vt.farComprobante fc inner join vt.caja c where c.idcaja = " + oCaja.getIdcaja() + " and (fc.comprobante = 'FACTURA' OR fc.comprobante = 'FACTURA ELECTRONICA') and vt.estado='ACT'";
            Query query = sesion.createQuery(hql);
            total = (BigDecimal) query.uniqueResult();
            if (total == null || total == new BigDecimal("0.00")) {
                total = new BigDecimal("0.00");
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
            total = BigDecimal.ZERO;
        } finally {
            sesion.close();
        }
        return total;
    }

    

    public List<Venta> listarxIdCliente(long idPersona) {
        try {
            iniciarOperacion();
            String hql = "from Venta v left join fetch v.farComprobante b  left join fetch v.clientepersonanatural c where c.idpersona = " + idPersona;
            list = sesion.createQuery(hql).list();
            tx.commit();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            list = new LinkedList<>();
        } finally {
            cerrarSesion();
        }
        return list;
    }

    public List<Venta> listarAll() {
        try {
            iniciarOperacion();
            String hql = "from Venta";
            list = sesion.createQuery(hql).list();
            tx.commit();
            //sesion.close();
            return list;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        }
    }

    public List<Venta> listarXNumComprobante(String num) {
        try {
            iniciarOperacion();
            String hql = "from Venta v left join fetch v.farComprobante b  left join fetch v.clientepersonanatural c where v.numComprobante = " + num + " order by v.numComprobante desc";
            list = sesion.createQuery(hql).list();
            tx.commit();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            list = new LinkedList<>();
        } finally {
            cerrarSesion();
        }
        return list;
    }

    public Venta buscarXidVenta(long idVenta) {
        try {
            iniciarOperacion();
            String hql = "from Venta v where v.idventa = " + idVenta + " order by v.numComprobante desc";
            obj = (Venta) sesion.createQuery(hql).uniqueResult();
            tx.commit();
            sesion.close();
            return obj;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        }
    }

    public int registrar(Venta oVenta, ModeloVentaProducto omvp, Cuentaxcobrar oCuentaxcobrar, HistorialAtencionFps histfps, List<Kardex> listKardex) {
        int res;
        try {
            iniciarOperacion();
            sesion.save(oVenta);
            for (int i = 0; i < omvp.size(); i++) {
                DetalleVenta obj = new DetalleVenta();
                obj = omvp.get(i);
                obj.setVenta(oVenta);
                sesion.save(obj);
            }
            //Registrar cuentas por cobrar
            if (oCuentaxcobrar != null) {
                oCuentaxcobrar.setVenta(oVenta);
                sesion.save(oCuentaxcobrar);
            }

            //Registrar el historial de fps si es que es diferente de null
            if (histfps != null) {
                histfps.setIdVenta(oVenta.getIdventa());
                histfps.setFechaAtencion(oVenta.getFechaVenta());
                sesion.save(histfps);
            }
            //Actualizar Stock
            for (int i = 0; i < omvp.getRowCount(); i++) {
                AlmacenProducto oAlmacenProducto = new AlmacenProducto();
                AlmacenProductoBl oAlmacenProductoBl = new AlmacenProductoBl();
                DetalleVenta oDetalleVenta = omvp.get(i);
                AlmacenProducto oAlmacenProductoTemp = new AlmacenProducto();
                oAlmacenProductoTemp = oAlmacenProductoBl.buscarxIdalmacenproducto(oDetalleVenta.getIdAlmacenproducto());
                if (oAlmacenProductoTemp != null) {
                    oAlmacenProductoTemp.setStockActual(oAlmacenProductoTemp.getStockActual().subtract(oDetalleVenta.getCantidadVenta()));
                    //oAlmacenProductoBl.actualizar(oAlmacenProductoTemp);
                    sesion.update(oAlmacenProductoTemp);
                }
            }
            //Generar Kardex
            for (Kardex objKardex : listKardex) {
                sesion.save(objKardex);
            }
            
            //registrar comprobante electronico  
            /*
            if (oVenta.getTotal().compareTo(BigDecimal.ZERO) == 1) {
                if (oVenta.getFarComprobante().getComprobante().trim().equals("BOLETA ELECTRONICA") || oVenta.getFarComprobante().getComprobante().trim().equals("FACTURA ELECTRONICA")) {
                    emitirComprobanteElectronico(oVenta, omvp);
                }
            }
            */
            
            tx.commit();
            res = SUCCESS;

        } catch (HibernateException e) {
            res = ERROR;
            manejaExcepcion(e);
            //e.printStackTrace();
        } catch (ProcessingException pe) {
            res = ERROR;
            JOptionPane.showMessageDialog(null, "Error en generar comprobante electrónico ...Causa Probable:" + pe, "Error Fatal", JOptionPane.ERROR_MESSAGE);
            //pe.printStackTrace();
        }finally {
            sesion.close();
        }
        return res;
    }

    private void emitirComprobanteElectronico(Venta oVenta, ModeloVentaProducto omvp) {
        TokenManager tokenManager = OpenfactClientFactory.getTokenManager("openfact-web-console", Variables.tokenServerUrl, Variables.refreshToken);
        DocumentsService service = OpenfactClientFactory.getDocumentsService(Variables.openfactUrl, tokenManager);
        OrganizationClient client = new OrganizationClient(Variables.RUC, service);
        DocumentResponseRepresentation invoice = client.createInvoiceAndParseAsEntity(getInvoice(oVenta, omvp), true);
        System.out.println("Invoice .... : "+invoice.getDocumentId());
        System.out.println("Invoice .... : "+invoice.getStatus());
    }

    public DocumentRequestRepresentation getInvoice(Venta oVenta, ModeloVentaProducto omvp) {
        DocumentRequestRepresentation invoice = new DocumentRequestRepresentation();

        invoice.setFechaDeEmision(oVenta.getFechaVenta());
        invoice.setTipo(oVenta.getFarComprobante().getCodigoSunat());
        invoice.setSerie(oVenta.getSerie());
        invoice.setNumero(Utilitarios.numberFormat(oVenta.getNumComprobante(), "########"));
        //validar  si es para  factura u otro  tipo de comprobante
        if (oVenta.getFarComprobante().getCodigoSunat().equals("01")) {
            if (!oVenta.getClientepersonanatural().getRazonSocial().trim().equals("")) {
                invoice.setEntidadDenominacion(oVenta.getClientepersonanatural().getRazonSocial().trim());
            } else {
                invoice.setEntidadDenominacion((oVenta.getClientepersonanatural().getNombre().trim() + " " + oVenta.getClientepersonanatural().getApellidoPaterno().trim() + " " + oVenta.getClientepersonanatural().getApellidoMaterno().trim()).trim());
            }
        } else {
            invoice.setEntidadDenominacion((oVenta.getClientepersonanatural().getNombre().trim() + " " + oVenta.getClientepersonanatural().getApellidoPaterno().trim() + " " + oVenta.getClientepersonanatural().getApellidoMaterno().trim()).trim());
        }
        //invoice.setEntidadEmail(oVenta.getCorreo_cliente_temp().trim()); // Email del cliente
        if (oVenta.getFarComprobante().getCodigoSunat().equals("01")) { //01 = factura
            if (oVenta.getTipoDocCliente().getCodigoSunat().trim().equals("6")) { // 6 = ruc
                invoice.setEntidadNumeroDeDocumento(oVenta.getClientepersonanatural().getRuc().trim());
            }
        } else {
            if (oVenta.getTipoDocCliente().getCodigoSunat().trim().equals("6")) { // 6 = ruc
                invoice.setEntidadNumeroDeDocumento(oVenta.getClientepersonanatural().getRuc().trim());
            } else {
                invoice.setEntidadNumeroDeDocumento(oVenta.getClientepersonanatural().getNumeroDocumento().trim()); // Numero de documento del cliente (RUC/DNI)
            }

        }

        invoice.setEntidadTipoDeDocumento(oVenta.getTipoDocCliente().getCodigoSunat()); // Tipo de Documento del cliente (RUC/DNI)
        invoice.setEnviarAutomaticamenteASunat(true);
        invoice.setEnviarAutomaticamenteAlCliente(true);
        invoice.setIgv(new BigDecimal(18)); // IGV Aplicado a la operacion expresada en porcentaje 18%
        invoice.setMoneda(oVenta.getTipoMoneda()); // Moneda nacional
        invoice.setObservaciones("");

        invoice.setOperacionGratuita(false); // Si la operacion es gratuita
        invoice.setTotalGratuita(BigDecimal.ZERO);

        invoice.setTotalGravada(oVenta.getSubTotal().setScale(2, RoundingMode.HALF_UP));
        invoice.setTotalExonerada(BigDecimal.ZERO);
        invoice.setTotalInafecta(BigDecimal.ZERO);

        invoice.setTotal(oVenta.getTotal().setScale(2, RoundingMode.HALF_UP));
        invoice.setTotalIgv(oVenta.getMontoIgv().setScale(2, RoundingMode.HALF_UP));
        invoice.setTotalOtrosCargos(BigDecimal.ZERO); // Otros cargos aplicados
        invoice.setDescuentoGlobal(BigDecimal.ZERO); // Descuentos aplicados

        // Detalle de la factura
        List<LineRepresentation> lines = new ArrayList<>();
        for (int i = 0; i < omvp.size(); i++) {
            DetalleVenta obj = new DetalleVenta();
            obj = omvp.get(i);
            LineRepresentation line = new LineRepresentation();
            line.setCantidad(obj.getCantidadVenta());
            line.setDescripcion(obj.getProducto().getNombre().trim());
            line.setTipoDeIgv("10"); // Codigo de operacion (Gravado - Operacion Onerosa)
            line.setValorUnitario(obj.getValorUnitarioItem().setScale(2, RoundingMode.HALF_UP)); // Precio unitario sin igv
            line.setIgv(obj.getMontoIgvItem().setScale(2, RoundingMode.HALF_UP)); // Igv aplicado al item
            line.setPrecioUnitario(obj.getPrecioUnitarioItem().setScale(2, RoundingMode.HALF_UP)); // Precio unitario con igv
            line.setSubtotal(obj.getSubTotal().setScale(2, RoundingMode.HALF_UP)); // Subtotal sin igv
            line.setTotal(obj.getMontoTotal().setScale(2, RoundingMode.HALF_UP)); // Subtotal con igv
            lines.add(line);
        }

        // Return result
        invoice.setDetalle(lines);
        /*
         System.out.println("Tipo--"+ invoice.getTipo()+"--");
         System.out.println("Doc Cliente--"+ invoice.getEntidadTipoDeDocumento()+"--");
         System.out.println("--"+ invoice.getEntidadNumeroDeDocumento()+"--");
         System.out.println("--"+ invoice.getEntidadDenominacion()+"--");
         */
        return invoice;
    }

    public int actualizar(Venta oVentaTemp, List<DetalleVenta> listDetalleVenta) {
        int res;
        try {
            iniciarOperacion();
            sesion.update(oVentaTemp);
            //actualizar el stock a retornar a farmacia y kardex
            for (int i = 0; i < listDetalleVenta.size(); i++) {
                DetalleVenta dv = new DetalleVenta();
                dv = listDetalleVenta.get(i);
                //actualizar almacen producto
                actualizarAlamcenProducto(dv);
                //Registrar kardex
                registrarKardex(dv);
            }
            tx.commit();
            res = SUCCESS;
        } catch (HibernateException e) {
            res = ERROR;
            manejaExcepcion(e);
        } finally {
            cerrarSesion();
        }
        return res;
    }

    private void actualizarAlamcenProducto(DetalleVenta dv) {
        AlmacenProducto oAlmacenProducto = new AlmacenProducto();
        AlmacenProductoBl oAlmacenProductoBl = new AlmacenProductoBl();
        oAlmacenProducto = oAlmacenProductoBl.buscarxIdalmacenproducto(dv.getIdAlmacenproducto());
        if (oAlmacenProducto != null) {
            oAlmacenProducto.setStockActual(oAlmacenProducto.getStockActual().add(dv.getCantidadVenta()));
            sesion.update(oAlmacenProducto);
        }
    }

    private void registrarKardex(DetalleVenta oDetalleVenta) {
        Kardex oKardex = new Kardex();
        KardexBl oKardexBl = new KardexBl();

        oKardex.setAlmacenByIdOrigen(null);
        oKardex.setIdAlmacenAfectado(2);
        oKardex.setAlmacenByIdDestino(null);

        oKardex.setIdFarcomprobante(oDetalleVenta.getVenta().getFarComprobante().getIdfarcomprobante());
        oKardex.setTipoOperacion("ENTRADA");
        oKardex.setOperacion("DEVOLUCION");
        oKardex.setFechaMov(new Date());
        oKardex.setHoraMov(Utilitarios.horaActual());
        oKardex.setComprobante(oDetalleVenta.getVenta().getFarComprobante().getComprobante());
        oKardex.setNumSerie("");
        oKardex.setNumComprobante(oDetalleVenta.getVenta().getNumComprobante() != null ? oDetalleVenta.getVenta().getNumComprobante() : Long.parseLong("0"));
        oKardex.setOrigen("");
        oKardex.setDestino("");
        oKardex.setObservacion("");
        oKardex.setGrupoNumeracion(1);
        oKardex.setIdProducto(Long.parseLong(oDetalleVenta.getProducto().getIdproducto() + ""));
        oKardex.setCantidad(oDetalleVenta.getCantidadVenta());
        oKardex.setIdAlmacenproducto(oDetalleVenta.getIdAlmacenproducto());
        oKardex.setValorUnit(oDetalleVenta.getPrecioVenta());
        oKardex.setEstado(1);
        //Obntener el ultimo numero de orden de registro de kardex
        long nro = oKardexBl.nroOrdenregistro(oKardex.getIdProducto());
        oKardex.setNroOrden(nro + 1);
        //obtener el stock actual y restarlo la cantidad de salida
        AlmacenProductoBl oAlmacenProductoBl = new AlmacenProductoBl();
        AlmacenProducto oAlmacenProducto = new AlmacenProducto();
        oAlmacenProducto = oAlmacenProductoBl.buscarxAlmacen(oKardex.getIdAlmacenproducto(), oKardex.getIdAlmacenAfectado());
        if (oAlmacenProducto != null) {
            oKardex.setStockActual(oAlmacenProducto.getStockActual());
        }
        sesion.save(oKardex);
    }

    public List<Venta> listarXusuarioYFecha(Usuario usuario, java.sql.Date fechaVenta) {
        list = new LinkedList<Venta>();
        try {            
            iniciarOperacion();
            String hql = "from Venta a left join fetch a.usuarioReg b "
                    + "left join fetch a.clientepersonanatural c left join fetch a.farComprobante d "
                    + "where a.fechaVenta = '"+fechaVenta+"' and a.usuarioReg.idUsuario ="+usuario.getIdUsuario();
            list = sesion.createQuery(hql).list();
            tx.commit();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            list = new LinkedList<Venta>();
        }finally{
            cerrarSesion();
        }
        return list;
    }

    public int enviarComprobanteElectronicoASunat(Venta oVenta, List<DetalleVenta> listDetalleVenta) {
        int res = -1;
        try {
            iniciarOperacion();
            oVenta.setEstadoSunat("ENVIADO");
            sesion.update(oVenta);            
            //Enviar comprobante electronico
            enviarComprobanteElectronico(oVenta, listDetalleVenta);
            tx.commit();
            res = SUCCESS;
        } catch (HibernateException e) {
            res = ERROR;
            manejaExcepcion(e);
        }finally{
            cerrarSesion();
        }
        return res;
    }
    
    private void enviarComprobanteElectronico(Venta oVenta, List<DetalleVenta> listDetalleVenta) {
        TokenManager tokenManager = OpenfactClientFactory.getTokenManager("openfact-web-console", Variables.tokenServerUrl, Variables.refreshToken);
        DocumentsService service = OpenfactClientFactory.getDocumentsService(Variables.openfactUrl, tokenManager);
        OrganizationClient client = new OrganizationClient(Variables.RUC, service);
        DocumentResponseRepresentation invoice = client.createInvoiceAndParseAsEntity(getInvoice(oVenta, listDetalleVenta), true);
    
    }
    
    public DocumentRequestRepresentation getInvoice(Venta oVenta, List<DetalleVenta> listDetalleVenta) {
        DocumentRequestRepresentation invoice = new DocumentRequestRepresentation();

        invoice.setFechaDeEmision(oVenta.getFechaVenta());
        invoice.setTipo(oVenta.getFarComprobante().getCodigoSunat());
        invoice.setSerie(oVenta.getSerie());
        invoice.setNumero(Utilitarios.numberFormat(oVenta.getNumComprobante(), "########"));
        //validar  si es para  factura u otro  tipo de comprobante
        if (oVenta.getFarComprobante().getCodigoSunat().equals("01")) {
            if (!oVenta.getClientepersonanatural().getRazonSocial().trim().equals("")) {
                invoice.setEntidadDenominacion(oVenta.getClientepersonanatural().getRazonSocial().trim());
            } else {
                invoice.setEntidadDenominacion((oVenta.getClientepersonanatural().getNombre().trim() + " " + oVenta.getClientepersonanatural().getApellidoPaterno().trim() + " " + oVenta.getClientepersonanatural().getApellidoMaterno().trim()).trim());
            }
        } else {
            invoice.setEntidadDenominacion((oVenta.getClientepersonanatural().getNombre().trim() + " " + oVenta.getClientepersonanatural().getApellidoPaterno().trim() + " " + oVenta.getClientepersonanatural().getApellidoMaterno().trim()).trim());
        }
        //invoice.setEntidadEmail(oVenta.getCorreo_cliente_temp().trim()); // Email del cliente
        if (oVenta.getFarComprobante().getCodigoSunat().equals("01")) { //01 = factura
            if (oVenta.getTipoDocCliente().getCodigoSunat().trim().equals("6")) { // 6 = ruc
                invoice.setEntidadNumeroDeDocumento(oVenta.getClientepersonanatural().getRuc().trim());
            }
        } else {
            if (oVenta.getTipoDocCliente().getCodigoSunat().trim().equals("6")) { // 6 = ruc
                invoice.setEntidadNumeroDeDocumento(oVenta.getClientepersonanatural().getRuc().trim());
            } else {
                invoice.setEntidadNumeroDeDocumento(oVenta.getClientepersonanatural().getNumeroDocumento().trim()); // Numero de documento del cliente (RUC/DNI)
            }

        }

        invoice.setEntidadTipoDeDocumento(oVenta.getTipoDocCliente().getCodigoSunat()); // Tipo de Documento del cliente (RUC/DNI)
        invoice.setEnviarAutomaticamenteASunat(true);
        invoice.setEnviarAutomaticamenteAlCliente(true);
        invoice.setIgv(new BigDecimal(18)); // IGV Aplicado a la operacion expresada en porcentaje 18%
        invoice.setMoneda(oVenta.getTipoMoneda()); // Moneda nacional
        invoice.setObservaciones("");

        invoice.setOperacionGratuita(false); // Si la operacion es gratuita
        invoice.setTotalGratuita(BigDecimal.ZERO);

        invoice.setTotalGravada(oVenta.getSubTotal().setScale(2, RoundingMode.HALF_UP));
        invoice.setTotalExonerada(BigDecimal.ZERO);
        invoice.setTotalInafecta(BigDecimal.ZERO);

        invoice.setTotal(oVenta.getTotal().setScale(2, RoundingMode.HALF_UP));
        invoice.setTotalIgv(oVenta.getMontoIgv().setScale(2, RoundingMode.HALF_UP));
        invoice.setTotalOtrosCargos(BigDecimal.ZERO); // Otros cargos aplicados
        invoice.setDescuentoGlobal(BigDecimal.ZERO); // Descuentos aplicados

        // Detalle de la factura
        List<LineRepresentation> lines = new ArrayList<>();
        for (DetalleVenta obj:listDetalleVenta) {
            LineRepresentation line = new LineRepresentation();
            line.setCantidad(obj.getCantidadVenta());
            line.setDescripcion(obj.getProducto().getNombre().trim());
            line.setTipoDeIgv("10"); // Codigo de operacion (Gravado - Operacion Onerosa)
            line.setValorUnitario(obj.getValorUnitarioItem().setScale(2, RoundingMode.HALF_UP)); // Precio unitario sin igv
            line.setIgv(obj.getMontoIgvItem().setScale(2, RoundingMode.HALF_UP)); // Igv aplicado al item
            line.setPrecioUnitario(obj.getPrecioUnitarioItem().setScale(2, RoundingMode.HALF_UP)); // Precio unitario con igv
            line.setSubtotal(obj.getSubTotal().setScale(2, RoundingMode.HALF_UP)); // Subtotal sin igv
            line.setTotal(obj.getMontoTotal().setScale(2, RoundingMode.HALF_UP)); // Subtotal con igv
            lines.add(line);
        }

        // Return result
        invoice.setDetalle(lines);
        /*
         System.out.println("Tipo--"+ invoice.getTipo()+"--");
         System.out.println("Doc Cliente--"+ invoice.getEntidadTipoDeDocumento()+"--");
         System.out.println("--"+ invoice.getEntidadNumeroDeDocumento()+"--");
         System.out.println("--"+ invoice.getEntidadDenominacion()+"--");
         */
        return invoice;
    }

    
}
