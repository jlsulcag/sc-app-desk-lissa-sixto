package lissa.dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.ws.rs.ProcessingException;
import lissa.be.Atencion;
import lissa.be.Caja;
import lissa.be.Comprobante;
import lissa.be.ComprobanteDetalle;
import lissa.be.Persona;
import lissa.be.TipoComprobante;
import lissa.be.TipoDocidentidad;
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

public class ComprobanteDao extends AbstractDA<Comprobante> {

    private Session sesion;
    private Transaction tx;
    Comprobante obj = null;
    private ArrayList<Comprobante> list;
    private List<Comprobante> listComprobantes;
    private int SUCCESS = 1;
    private int ERROR = 0;

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

    private void iniciarOperacion() throws HibernateException {
        if (sesion != null) {
            sesion.close();
        } else {
            sesion = HibernateUtil.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
        }
    }

    public void cerrarSesion() {
        sesion.close();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        Mensajes.ErrorFatal(he);
        //throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

    public List<Comprobante> buscarXnumComprobante(long ref) {
        try {
            iniciarOperacion();
            String hql = "from Comprobante a left join fetch a.atencion b left join fetch b.persona c "
                    + "left join fetch a.tipoComprobante d "
                    + "left join fetch a.beneficio e left join fetch e.seguroVida f "
                    + "where a.numero=" + ref + " "
                    + "order by a.numero desc";
            Query query = sesion.createQuery(hql);
            listComprobantes = query.list();
            tx.commit();
            return listComprobantes;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        } finally {
            sesion.close();
        }
    }

    public ArrayList<Comprobante> buscarXtipoDoc(String ref) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList<Comprobante> list = null;
        list = (ArrayList<Comprobante>) session.createQuery("from Comprobante b where b.numeroBoleta =" + ref).list();
        session.getTransaction().commit();
        return list;
    }

    public ArrayList<Comprobante> buscarXfecha(Date ref) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList<Comprobante> list = null;
        list = (ArrayList<Comprobante>) session.createQuery("from Comprobante b where b.numeroBoleta =" + ref).list();
        session.getTransaction().commit();
        return list;
    }

    public Comprobante buscarXPaciente(String numeroDocumento) {
        try {
            iniciarOperacion();
            String hql = "select ic from ItemsComprobante ic inner join ic.comprobante c inner join c.paciente pac inner join pac.persona per where per.numeroDocumento=" + numeroDocumento;
            Query query = sesion.createQuery(hql);
            obj = (Comprobante) query.uniqueResult();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        }
        return obj;
    }

    public ArrayList<Comprobante> buscarXNombre(String nombre) {
        //ArrayList<Comprobante> list;
        try {
            iniciarOperacion();
            String hql = "select com from Comprobante com inner join com.paciente pac inner join pac.persona per "
                    + "where (per.apellidoPaterno || ' ' || per.apellidoMaterno || ' ' || per.nombre) like '%" + nombre + "%' "
                    + "order by com.fechaBoleta desc";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Comprobante>) query.list();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        }
        return list;
    }

    public BigDecimal calcuatTotalRecibo(Caja oCaja) {
        BigDecimal total = null;
        try {
            iniciarOperacion();
            String hql = "select sum(com.montoTotal) from Comprobante com inner join com.caja caj inner join com.tipoComprobante tc where caj.idcaja=" + oCaja.getIdcaja() + " and tc.denominacion = 'ORDEN DE SERVICIO' and com.estado = 'ACT'";
            Query query = sesion.createQuery(hql);
            total = (BigDecimal) query.uniqueResult();
            if (total == null || total == new BigDecimal("0.00")) {
                total = new BigDecimal("0.00");
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
        }
        return total;
    }

    public BigDecimal calcularTotalBoleta(Caja oCaja) {
        BigDecimal total = null;
        try {
            iniciarOperacion();
            String hql = "select sum(com.montoTotal) from Comprobante com inner join com.caja caj inner join com.tipoComprobante tc where caj.idcaja=" + oCaja.getIdcaja() + " and (tc.denominacion = 'BOLETA' or tc.denominacion = 'BOLETA ELECTRONICA') and com.estado = 'ACT'";
            Query query = sesion.createQuery(hql);
            total = (BigDecimal) query.uniqueResult();
            if (total == null || total == new BigDecimal("0.00")) {
                total = new BigDecimal("0.00");
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
        }
        return total;
    }

    public BigDecimal calcularTotalFactura(Caja oCaja) {
        BigDecimal total = null;
        try {
            iniciarOperacion();
            String hql = "select sum(com.montoTotal) from Comprobante com inner join com.caja caj inner join com.tipoComprobante tc where caj.idcaja=" + oCaja.getIdcaja() + " and (tc.denominacion = 'FACTURA' or tc.denominacion = 'FACTURA ELECTRONICA') and com.estado = 'ACT'";
            Query query = sesion.createQuery(hql);
            total = (BigDecimal) query.uniqueResult();
            if (total == null || total == new BigDecimal("0.00")) {
                total = new BigDecimal("0.00");
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
        }
        return total;
    }

    public ArrayList<Comprobante> listarAtencionFondo(Caja oCaja) {
        try {
            iniciarOperacion();
            list = (ArrayList<Comprobante>) sesion.createQuery("Select com from Comprobante com inner join com.caja caj inner join caj.usuario usu inner join usu.persona per inner join com.beneficio ben where caj.idcaja = " + oCaja.getIdcaja() + " and ben.nombreBeneficio = 'FONDO PREVISION'").list();
            tx.commit();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        return list;
    }

    public Comprobante buscarXnumDoc(Integer numeroBoleta, TipoComprobante tipoComprobante) {
        try {
            iniciarOperacion();
            String hql = "from Comprobante c where c.numeroBoleta=" + numeroBoleta + " and c.tipoComprobante = " + tipoComprobante.getIdtipocomprobante();
            Query query = sesion.createQuery(hql);
            obj = (Comprobante) query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        return obj;
    }

    public ArrayList<Comprobante> listar(Persona per) {
        try {
            iniciarOperacion();
            String hql = "from Comprobante a left join fetch a.atencion b left join fetch b.persona c "
                    + "left join fetch a.tipoComprobante d "
                    + "where c.idpersona = " + per.getIdpersona() + " order by a.numero desc";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<Comprobante>) query.list();
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return list;
    }

    public int registrar(Comprobante oComprobante, List<ComprobanteDetalle> listComprobanteDetalle, Atencion oAtencion) {
        int res;
        try {
            iniciarOperacion();
            sesion.save(oComprobante);
            for (ComprobanteDetalle obj : listComprobanteDetalle) {
                obj.setComprobante(oComprobante);
                sesion.save(obj);
            }
            oAtencion.setEstado("ATENDIDO");
            sesion.update(oAtencion);
            if (oAtencion.getCita() != null) {
                oAtencion.getCita().setEstado("ATENDIDO");
                sesion.update(oAtencion.getCita());
            }
            //registrar comprobante electronico
            
            if (oComprobante.getTipoComprobante().getDenominacion().trim().equals("BOLETA ELECTRONICA") || oComprobante.getTipoComprobante().getDenominacion().trim().equals("FACTURA ELECTRONICA")) {
                emitirComprobanteElectronico(oComprobante, listComprobanteDetalle);
            }
            
            tx.commit();
            res = SUCCESS;
        } catch (HibernateException he) {
            res = ERROR;
            manejaExcepcion(he);
        } catch (ProcessingException pe) {
            res = ERROR;
            JOptionPane.showMessageDialog(null, "Error en generar comprobante electrónico ...Causa Probable:" + pe, "Error Fatal", JOptionPane.ERROR_MESSAGE);
            //pe.printStackTrace();
        } finally {
            sesion.close();
        }
        return res;
    }

    public List<Comprobante> buscarXRangoFecha(java.sql.Date inicio, java.sql.Date fin, String numeroCarta) throws HibernateException {
        listComprobantes = new LinkedList<>();
        try {
            iniciarOperacion();
            StringBuilder hql = new StringBuilder();
            hql.append("from Comprobante a left  join fetch a.atencion b left join fetch b.persona c ");
            hql.append("left join fetch a.beneficio d left join fetch a.tipoComprobante e ");
            hql.append("left join fetch d.seguroVida f ");
            hql.append("where a.fechaComprobante between :inicio and :fin ");
            if(!numeroCarta.trim().equals("0")){
                hql.append("and a.numeroCarta = :numerocarta ");
            }            
            hql.append("order by a.fechaComprobante DESC");
            Query q = sesion.createQuery(hql.toString());
            q.setParameter("inicio", inicio);
            q.setParameter("fin", fin);
            if(!numeroCarta.trim().equals("0")){
                q.setParameter("numerocarta", numeroCarta);
            }
            listComprobantes = q.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            listComprobantes = new LinkedList<>();
        } finally {
            sesion.close();
        }
        return listComprobantes;
    }

    private void emitirComprobanteElectronico(Comprobante oComprobante, List<ComprobanteDetalle> listComprobanteDetalle) {
        TokenManager tokenManager = OpenfactClientFactory.getTokenManager("openfact-web-console", Variables.tokenServerUrl, Variables.refreshToken);
        DocumentsService service = OpenfactClientFactory.getDocumentsService(Variables.openfactUrl, tokenManager);
        OrganizationClient client = new OrganizationClient(Variables.RUC, service);

        DocumentResponseRepresentation invoice = client.createInvoiceAndParseAsEntity(getInvoice(oComprobante, listComprobanteDetalle), true);
        System.out.println("Invoice admision ... : "+invoice.getStatus());
        System.out.println("Invoice admision ... : "+invoice.getDocumentId());
    }

    // Crear factura boleta
    public DocumentRequestRepresentation getInvoice(Comprobante oComprobante, List<ComprobanteDetalle> listComprobanteDetalle) {
        DocumentRequestRepresentation invoice = new DocumentRequestRepresentation();

        invoice.setFechaDeEmision(oComprobante.getFechaComprobante());
        invoice.setTipo(oComprobante.getTipoComprobante().getCodigoSunat());
        invoice.setSerie(oComprobante.getSerie());
        invoice.setNumero(Utilitarios.numberFormat(oComprobante.getNumero(), "########"));
        //validar  si es para  factura u otro  tipo de comprobante
        if (oComprobante.getTipoComprobante().getCodigoSunat().equals("01")) {
            if (!oComprobante.getClientepersonanatural().getRazonSocial().trim().equals("")) {
                invoice.setEntidadDenominacion(oComprobante.getClientepersonanatural().getRazonSocial().trim());
            } else {
                invoice.setEntidadDenominacion((oComprobante.getClientepersonanatural().getNombre().trim() + " " + oComprobante.getClientepersonanatural().getApellidoPaterno().trim() + " " + oComprobante.getClientepersonanatural().getApellidoMaterno().trim()).trim());
            }
        } else {
            invoice.setEntidadDenominacion((oComprobante.getClientepersonanatural().getNombre().trim() + " " + oComprobante.getClientepersonanatural().getApellidoPaterno().trim() + " " + oComprobante.getClientepersonanatural().getApellidoMaterno().trim()).trim());
        }
        invoice.setEntidadEmail(oComprobante.getCorreo_cliente_temp().trim()); // Email del cliente
        if (oComprobante.getTipoComprobante().getCodigoSunat().equals("01")) { //01 = factura
            if (oComprobante.getTipoDocCliente().getCodigoSunat().trim().equals("6")) { // 6 = ruc
                invoice.setEntidadNumeroDeDocumento(oComprobante.getClientepersonanatural().getRuc().trim());
            }
        } else {
            if (oComprobante.getTipoDocCliente().getCodigoSunat().trim().equals("6")) { // 6 = ruc
                invoice.setEntidadNumeroDeDocumento(oComprobante.getClientepersonanatural().getRuc().trim());
            } else {
                invoice.setEntidadNumeroDeDocumento(oComprobante.getClientepersonanatural().getNumeroDocumento().trim()); // Numero de documento del cliente (RUC/DNI)
            }

        }

        invoice.setEntidadTipoDeDocumento(oComprobante.getTipoDocCliente().getCodigoSunat()); // Tipo de Documento del cliente (RUC/DNI)
        invoice.setEnviarAutomaticamenteASunat(true);
        invoice.setEnviarAutomaticamenteAlCliente(true);
        invoice.setIgv(new BigDecimal(18)); // IGV Aplicado a la operacion expresada en porcentaje 18%
        invoice.setMoneda(oComprobante.getTipoMoneda()); // Moneda nacional
        invoice.setObservaciones("");

        invoice.setOperacionGratuita(false); // Si la operacion es gratuita
        invoice.setTotalGratuita(BigDecimal.ZERO);

        invoice.setTotalGravada(oComprobante.getSubTotal().setScale(2, RoundingMode.HALF_UP));
        invoice.setTotalExonerada(BigDecimal.ZERO);
        invoice.setTotalInafecta(BigDecimal.ZERO);

        invoice.setTotal(oComprobante.getMontoTotal().setScale(2, RoundingMode.HALF_UP));
        invoice.setTotalIgv(oComprobante.getMontoIgv().setScale(2, RoundingMode.HALF_UP));
        invoice.setTotalOtrosCargos(BigDecimal.ZERO); // Otros cargos aplicados
        invoice.setDescuentoGlobal(BigDecimal.ZERO); // Descuentos aplicados

        // Detalle de la factura
        List<LineRepresentation> lines = new ArrayList<>();
        for (ComprobanteDetalle obj : listComprobanteDetalle) {
            LineRepresentation line = new LineRepresentation();
            line.setCantidad(obj.getCantidad());
            line.setDescripcion(obj.getConcepto());
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
