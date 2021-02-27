package lissa.gui;
// <editor-fold defaultstate="collapsed" desc="Import">

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import lissa.be.Caja;
import lissa.be.ComprobanteDetalle;
import lissa.be.Persona;
import lissa.be.ProcedimientoTarifario;
import lissa.be.Rol;
import lissa.be.Usuario;
import lissa.bl.CajaBl;
import lissa.bl.ProcedimientoTarifarioBl;
import lissa.conf.FileConf;
import lissa.ds.DSConeccion;
import lissa.gui.farmacia.JIF_AdminAlmacenProducto;
import lissa.gui.farmacia.JIF_AdminFormaFarmaceutica;
import lissa.gui.farmacia.JIF_AdminLaboratorio;
import lissa.gui.farmacia.JIF_AdminPrecioVenta;
import lissa.gui.farmacia.JIF_AdminPresentacion;
import lissa.gui.farmacia.JIF_AdminProducto;
import lissa.gui.farmacia.JIF_AjusteInventario;
import lissa.gui.farmacia.JIF_RegistroMovimiento;
import lissa.gui.farmacia.JIF_BuscarComprobanteCompras;
import lissa.gui.farmacia.JIF_BuscarComprobanteVenta;
import lissa.gui.farmacia.JIF_BusqProductos;
import lissa.gui.farmacia.JIF_BusqProveedor;
import lissa.gui.farmacia.JIF_CantidadVenta;
import lissa.gui.farmacia.JIF_CerrarCajaFar;
import lissa.gui.farmacia.JIF_Compras;
import lissa.gui.farmacia.JIF_ConsultaFPS;
import lissa.gui.farmacia.JIF_CuentasXCobrarFarmacia;
import lissa.gui.farmacia.JIF_EditarItemsCompra;
import lissa.gui.farmacia.JIF_FormaPago;
import lissa.gui.farmacia.JIF_HistorialAtencionFPS;
import lissa.gui.farmacia.JIF_KardexAlmacen;
import lissa.gui.farmacia.JIF_InventarioInicial;
import lissa.gui.farmacia.JIF_NotaSalidaFar;
import lissa.gui.farmacia.JIF_NuevoProducto;
import lissa.gui.farmacia.JIF_ProductosVencidos;
import lissa.gui.farmacia.JIF_ProductosXVencer;
import lissa.gui.farmacia.JIF_RegAreaConsumo;
import lissa.gui.farmacia.JIF_RegFormaFarmaceutica;
import lissa.gui.farmacia.JIF_RegPresentacion;
import lissa.gui.farmacia.JIF_RegLaboratorio;
import lissa.gui.farmacia.JIF_RegVentas;
import lissa.gui.farmacia.JIF_StockActual;
import lissa.gui.rep.JIF_ComprasResumen;
import lissa.gui.rep.JIF_NotaSalidaXservico;
import lissa.gui.rep.JIF_RecaudacionTipoPaciente;
import lissa.gui.rep.JIF_RepConsumo;
import lissa.gui.rep.JIF_RepCuentasXCobrarFarmacia;
import lissa.gui.rep.JIF_RepFPS;
import lissa.gui.rep.JIF_RepUtilidad;
import lissa.gui.rep.JIF_RepVentas;
import lissa.gui.rep.JIF_RepXMedico;
import lissa.gui.rep.JIF_RepXServicio;
import lissa.gui.rep.JIF_RepXServicioYProcedimiento;
import lissa.gui.rep.JIF_Sabanon;
import lissa.gui.rep.JIF_SalidasXFecha;
import lissa.util.Reportes;
import lissa.util.Utilitarios;
import lissa.util.Background;
import lissa.util.Mensajes;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
// </editor-fold>

public class JF_Principal extends javax.swing.JFrame {

    private Caja oCaja = null;
    private CajaBl ocajaBl = null;
    private Usuario user;
    private Persona oPersona;
    private Rol oRol;
    private DSConeccion ds = null;
    private boolean isFirst = true;
    private FileConf config;
    public JD_Configuracion jdConf;
    int DimenVentana = JF_Principal.MAXIMIZED_BOTH;
    public JD_IniciarSesion jdIniciarSesion = null;
    public JIF_EmitirComprobante jifEmitirComprobante = null;
    public JIF_BuscarPersonaNatural jifBuscarPersonaNatural = null;
    public JIF_AdministrarPersonaJuridica jifAdministrarPersonaJuridica = null;
    public JIF_BuscarPersonaJuridica jifBuscarPersonaJuridica = null;
    public JIF_AdministrarPersonaNatural jifAdministrarPersonanatural = null;
    public JIF_FondoPrevision jifFondoPrevision = null;
    public JIF_RegistrarUsuario jifRegistrarUsuario = null;
    public JIF_AdministrarComprobante jifAdministrarComprobante = null;
    public JIF_BuscarComprobante jifBuscarComprobante;
    public JIF_Reporte_RecaudacionDiariaTipoDocFecha jifReporteCajaDiario = null;
    public JIF_ReporteCajaMensual jifReporteCajaMensual = null;
    public JD_Contactenos jdContactenos = null;
    public JIF_CambiarContraseña jifCambiarContraseña = null;
    public JIF_AdministrarMedico jifAdministrarMedico = null;
    public JIF_BuscarMedico jifBuscarMedico = null;
    public JIF_BuscarFondoPrevisionTemp jifBuscarFondoPrevTemp = null;
    public JIF_BuscarHistoriaClinica jifBuscarHC = null;
    public JIF_AdminCie10 jifAdminCie10 = null;
    public JIF_Reporte_RecaudacionDiariaXMedico jifReporteRecaudacionPorMedico = null;
    public JIF_Reporte_RecaudacionResumen jifReporteRecaudacionResumen = null;
    public JIF_Reporte_RecaudacionPorServicio jifReporteRecaudacionXServicio = null;
    public JIF_HistoriaClinica jifHistoriaClinica = null;
    public JPanel_HistoriaClinica jPanel_HistoriaClinica = null;
    public JIF_AbrirCaja jifAbrirCaja = null;
    public JIF_CerrarCaja jifCerrarCaja = null;
    public JIF_BuscarCajeros jifBuscarCajeros = null;
    public JIF_AtencionFondoPrev jifAtencionFondoPrev = null;
    public JIF_RepTurno jifRepTurno = null;
    public JIF_Admision jifAdmision = null;
    public JIF_CitaMedica jifCitaMedica = null;
    public JIF_MantenerCita jifMantenerCita = null;
    public JPanel_Admision jpAdmision;
    public JIF_AddEspecialidad jifAddEspecialidad;
    public JIF_AdministrarSeguro jifAdministrarSeguro;
    public JIF_CobroCaja jifCobroCaja;
    public JIF_AdministrarAtencion jifAdministrarAtencion;
    public JIF_Sabanon jifSabanon;
    public JIF_ServicioAdd jifServicioAdd;
    //JIF para el modulo de farmacia
    public JIF_RegFormaFarmaceutica jifFormaFarmaceutica;
    public JIF_RegPresentacion jifRegPresentacion;
    public JIF_AdminProducto jifAdminProducto;
    public JIF_NuevoProducto jifNuevoProducto;
    public JIF_RegLaboratorio jifRegLaboratorio;
    public JIF_Compras jifCompras;
    public JIF_BusqProductos jifBusqProductos;
    public JIF_RegistroMovimiento jifAlmacen;
    public JIF_AdminPresentacion jifAdminPresentacion;
    public JIF_AdminFormaFarmaceutica jifAdminFormaFarmaceutica;
    public JIF_AdminLaboratorio jifAdminLaboratorio;
    public JIF_KardexAlmacen jifKardexAlmacen;
    public JIF_StockActual jifStockActual;
    public JIF_CerrarCajaFar jifCerrarCajaFar;

    public JIF_RegVentas jifRegVentas;
    public JIF_ComprasResumen jifComprasResumen;
    public JIF_RepVentas jifRepVentas;
    public JIF_ProductosXVencer jifProductosXVencer;
    public JIF_RecaudacionTipoPaciente jifRecaudaciobTipoPaciente;
    public JIF_BusqProveedor jifBusqProveedor;
    public JIF_InventarioInicial jifMigrar;
    public JIF_CantidadVenta jifCantidadVenta;
    public JIF_ProductosVencidos jifProductosVencidos;
    public JIF_ConsultaFPS jifConsultaFPS;
    public JIF_BuscarComprobanteVenta jifBuscarComprobanteVenta;
    public JIF_FormaPago jifFormaPago;
    public JIF_BuscarComprobanteCompras jifBuscarComprobantesCompras;
    public JIF_NotaSalidaFar jifNotaSalidafar;
    public JIF_RegAreaConsumo jifRegAreaConsumo;
    public JIF_HistorialAtencionFPS jifHistorialFps;
    public JIF_RepFPS jifRepFPS;
    public JIF_RepConsumo jifrepCoebrtura;
    public JIF_AdminPrecioVenta jifAdminPrecioVenta;
    public JIF_NotaSalidaXservico jifNotaSalidaXfecha;
    public JIF_AjusteInventario jifAjusteInventario;
    public JIF_AdminAlmacenProducto jifAdminAlmacenProducto;
    public JIF_BuscarProcedimiento jifBuscarProcedimiento;
    public JIF_AdministrarTarifario jifAdministrarTarifario;
    public JIF_AdministrarProcedimiento jifAdministrarProcedimiento;
    public JIF_Egresos jifEgresos;
    public JIF_RegistrarPagoMedicos jifRegistrarPagoMedicos;
    public JIF_RealizarPagoMedicos jifRealizarPagoMedicos;
    public JIF_RepXServicio jifRepXServicio;
    public JIF_RepXServicioYProcedimiento jifRepXServYproc;
    public JIF_RepXMedico jifRepxMedico;
    public JIF_SalidasXFecha jifSalidasXFecha;
    public JIF_TriajePersonas jifTriajePersonas;
    public JD_VisorHc jdVisorHc;
    public JIF_ReimprimirEgreso jifReimprimirEgreso;
    public JIF_AdministrarCitas jifAdministrarCitas;
    public JIF_RegistrarCita jifRegistrarCita;
    public JIF_GenerarPreFactura jifGenerarPreFactura;
    public JIF_MisComprobantes jifMisComprobantes;
    public JIF_CuentasXCobrarFarmacia jifCuentasxCobrarFarmacia;
    public JIF_RepCuentasXCobrarFarmacia jifRepCuentasxCobrarfarmacia;
    public JIF_EditarItemsCompra jifEditarItemsCompra;
    public JIF_RepUtilidad jifReporteUtilidad;

//    private JD_BackUpDB_Creator_Sirec bcpc = null;
//    private JD_BackUpDB_Restore_Sirec bcpr = null;
    public JF_Principal() throws Exception {
        /*
        look 1
        try {
            UIManager.setLookAndFeel(new SyntheticaBlueLightLookAndFeel());
       } catch (ParseException | UnsupportedLookAndFeelException e) {
        }
         */
        
        //look 2        
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.updateComponentTreeUI(JF_Principal.this);
        //Fin look 2
        initComponents();

        setExtendedState(DimenVentana);
        personalizaFondoEscritorio(JDPContenedor);

        //Seccion para la configuracion
        jdConf = new JD_Configuracion(this);
        //jdConf.setIconImage(icon.getImage());
        setConfig(jdConf.getConfig());
        if (!jdConf.isValidDBStructure()) {
//            bcpr = new JD_BackUpDB_Restore_Sirec(this);
//            bcpr.setIconImage(icon.getImage());
//            bcpr.validaRestauracionBackUp();
        }
        //fin configuracion

        jifAdminFormaFarmaceutica = new JIF_AdminFormaFarmaceutica(this);
        jifAdminLaboratorio = new JIF_AdminLaboratorio(this);
        jifAdminPresentacion = new JIF_AdminPresentacion(this);
        jifAdminProducto = new JIF_AdminProducto(this);
        jifAlmacen = new JIF_RegistroMovimiento(this);
        jifBusqProductos = new JIF_BusqProductos(this);
        jifBusqProveedor = new JIF_BusqProveedor(this);
        jifCantidadVenta = new JIF_CantidadVenta(this);
        jifCerrarCajaFar = new JIF_CerrarCajaFar(this);
        jifCompras = new JIF_Compras(this);
        jifConsultaFPS = new JIF_ConsultaFPS(this);
        jifKardexAlmacen = new JIF_KardexAlmacen(this);
        jifMigrar = new JIF_InventarioInicial(this);
        jifNuevoProducto = new JIF_NuevoProducto(this);
        jifProductosXVencer = new JIF_ProductosXVencer(this);
        jifProductosVencidos = new JIF_ProductosVencidos(this);
        jifFormaFarmaceutica = new JIF_RegFormaFarmaceutica(this);
        jifRegLaboratorio = new JIF_RegLaboratorio(this);
        jifRegPresentacion = new JIF_RegPresentacion(this);
        jifRegVentas = new JIF_RegVentas(this);
        jifStockActual = new JIF_StockActual(this);
        jifComprasResumen = new JIF_ComprasResumen(this);
        jifRepVentas = new JIF_RepVentas(this);
        jifBuscarComprobanteVenta = new JIF_BuscarComprobanteVenta(this);
        jifBuscarComprobantesCompras = new JIF_BuscarComprobanteCompras(this);
        jifNotaSalidafar = new JIF_NotaSalidaFar(this);
        jifRepFPS = new JIF_RepFPS(this);

        //carga de iniciar sesion
        jdIniciarSesion = new JD_IniciarSesion(this);
        if (isFirst) {
            jdIniciarSesion.setVisible(true);
            isFirst = false;
        }
        //fin de inicio de sesion

        jifEmitirComprobante = new JIF_EmitirComprobante(this);
        jifBuscarPersonaNatural = new JIF_BuscarPersonaNatural(this);
        jifAdministrarPersonaJuridica = new JIF_AdministrarPersonaJuridica(this);
        jifAdministrarPersonanatural = new JIF_AdministrarPersonaNatural(this);
        jifFondoPrevision = new JIF_FondoPrevision(this);
        jifRegistrarUsuario = new JIF_RegistrarUsuario(this);
        jifAdministrarComprobante = new JIF_AdministrarComprobante(this);
        jifReporteCajaDiario = new JIF_Reporte_RecaudacionDiariaTipoDocFecha(this);
        jifReporteCajaMensual = new JIF_ReporteCajaMensual(this);
        jifCambiarContraseña = new JIF_CambiarContraseña(this);
        jifAdministrarMedico = new JIF_AdministrarMedico(this);
        jifBuscarMedico = new JIF_BuscarMedico(this);
        jifBuscarFondoPrevTemp = new JIF_BuscarFondoPrevisionTemp(this);
        jifBuscarHC = new JIF_BuscarHistoriaClinica(this);
        jifAdminCie10 = new JIF_AdminCie10(this);
        jifReporteRecaudacionPorMedico = new JIF_Reporte_RecaudacionDiariaXMedico(this);
        jifReporteRecaudacionResumen = new JIF_Reporte_RecaudacionResumen(this);
        jifReporteRecaudacionXServicio = new JIF_Reporte_RecaudacionPorServicio(this);
        jdContactenos = new JD_Contactenos(this);
        jifHistoriaClinica = new JIF_HistoriaClinica(this);
        jPanel_HistoriaClinica = new JPanel_HistoriaClinica(this);
        jifAbrirCaja = new JIF_AbrirCaja(this);
        jifCerrarCaja = new JIF_CerrarCaja(this);
        jifBuscarCajeros = new JIF_BuscarCajeros(this);
        jifAtencionFondoPrev = new JIF_AtencionFondoPrev(this);
        jifRepTurno = new JIF_RepTurno(this);
        jifAdmision = new JIF_Admision(this);
        jifAdministrarSeguro = new JIF_AdministrarSeguro(this);
        //jifCitaMedica = new JIF_CitaMedica(this);
        jifMantenerCita = new JIF_MantenerCita(this);
        jifBuscarPersonaJuridica = new JIF_BuscarPersonaJuridica(this);
        jpAdmision = new JPanel_Admision(this);
        jifAddEspecialidad = new JIF_AddEspecialidad(this);
        jifRecaudaciobTipoPaciente = new JIF_RecaudacionTipoPaciente(this);
        jifFormaPago = new JIF_FormaPago(this);
        jifRegAreaConsumo = new JIF_RegAreaConsumo(this);
        jifHistorialFps = new JIF_HistorialAtencionFPS(this);
        jifrepCoebrtura = new JIF_RepConsumo(this);
        jifAdminPrecioVenta = new JIF_AdminPrecioVenta(this);
        jifNotaSalidaXfecha = new JIF_NotaSalidaXservico(this);
        jifAjusteInventario = new JIF_AjusteInventario(this);
        jifAdminAlmacenProducto = new JIF_AdminAlmacenProducto(this);
        jifBuscarProcedimiento = new JIF_BuscarProcedimiento(this);
        jifCobroCaja = new JIF_CobroCaja(this);
        jifAdministrarAtencion = new JIF_AdministrarAtencion(this);
        jifSabanon = new JIF_Sabanon(this);
        jifServicioAdd = new JIF_ServicioAdd(this);
        jifAdministrarTarifario = new JIF_AdministrarTarifario(this);
        jifAdministrarProcedimiento = new JIF_AdministrarProcedimiento(this);
        jifEgresos = new JIF_Egresos(this);
        jifRegistrarPagoMedicos = new JIF_RegistrarPagoMedicos(this);
        jifRealizarPagoMedicos = new JIF_RealizarPagoMedicos(this);
        jifRepXServicio = new JIF_RepXServicio(this);
        jifRepXServYproc = new JIF_RepXServicioYProcedimiento(this);
        jifRepxMedico = new JIF_RepXMedico(this);
        jifSalidasXFecha = new JIF_SalidasXFecha(this);
        jifBuscarComprobante = new JIF_BuscarComprobante(this);
        jifTriajePersonas = new JIF_TriajePersonas(this);
        jdVisorHc = new JD_VisorHc(this);
        jifReimprimirEgreso = new JIF_ReimprimirEgreso(this);
        jifAdministrarCitas = new JIF_AdministrarCitas(this);
        jifRegistrarCita = new JIF_RegistrarCita(this);
        jifGenerarPreFactura = new JIF_GenerarPreFactura(this);
        jifMisComprobantes = new JIF_MisComprobantes(this);
        jifCuentasxCobrarFarmacia = new JIF_CuentasXCobrarFarmacia(this);
        jifRepCuentasxCobrarfarmacia = new JIF_RepCuentasXCobrarFarmacia(this);
        jifEditarItemsCompra = new JIF_EditarItemsCompra(this);
        jifReporteUtilidad = new JIF_RepUtilidad(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDPContenedor = new javax.swing.JDesktopPane();
        jTextField1 = new javax.swing.JTextField();
        jmbPrincipal = new javax.swing.JMenuBar();
        jmInicio = new javax.swing.JMenu();
        jmiIniciarSesion = new javax.swing.JMenuItem();
        jmiCerrarSesion = new javax.swing.JMenuItem();
        jmiSalir = new javax.swing.JMenuItem();
        jmCita = new javax.swing.JMenu();
        jmiAdministrarCitas = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jmAdmision = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jmAtencion = new javax.swing.JMenu();
        jmiEmitirComprobante = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jmCaja = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmiReimpresionEgresos = new javax.swing.JMenuItem();
        jmiMisComprobantesFarmacia = new javax.swing.JMenuItem();
        jmiMisComprobantesAdmision = new javax.swing.JMenuItem();
        jmCtasxCobrar = new javax.swing.JMenu();
        jmiCtasxCobrarFarmacia = new javax.swing.JMenuItem();
        jmiCtasxCobrarAdmision = new javax.swing.JMenuItem();
        jmHistoriaClinica = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jmContabilidad = new javax.swing.JMenu();
        jmReportes = new javax.swing.JMenu();
        jmi001 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jm008 = new javax.swing.JMenu();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jmi009 = new javax.swing.JMenuItem();
        jmi010 = new javax.swing.JMenuItem();
        jmi012 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jmi011 = new javax.swing.JMenuItem();
        jmi013 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jmi006 = new javax.swing.JMenuItem();
        jmi039 = new javax.swing.JMenuItem();
        jmi040 = new javax.swing.JMenuItem();
        jmi041 = new javax.swing.JMenuItem();
        jmi038 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiCuentasxCobrarFarmacia = new javax.swing.JMenuItem();
        jmiExportarTarifario = new javax.swing.JMenuItem();
        jmiReporteUtilidad = new javax.swing.JMenuItem();
        jmPersonal = new javax.swing.JMenu();
        jmiUsuarios = new javax.swing.JMenuItem();
        jmiStafProfesional = new javax.swing.JMenuItem();
        jmMiCuenta = new javax.swing.JMenu();
        JMCambiarContrasenia = new javax.swing.JMenuItem();
        jmAyuda = new javax.swing.JMenu();
        Ayuda = new javax.swing.JMenuItem();
        JMAcercaDe = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jmAlmacen = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem34 = new javax.swing.JMenuItem();
        jmVentas = new javax.swing.JMenu();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jmCompras = new javax.swing.JMenu();
        jMenuItem26 = new javax.swing.JMenuItem();
        jmMantenimiento = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();
        jmTriaje = new javax.swing.JMenu();
        jMenuItem37 = new javax.swing.JMenuItem();
        jmiHc = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LISSA");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JDPContenedor.setBackground(java.awt.SystemColor.controlHighlight);

        jTextField1.setText("jTextField1");

        jmbPrincipal.setBackground(new java.awt.Color(20, 92, 168));

        jmInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Turn-Off.png"))); // NOI18N
        jmInicio.setText("INICIO");
        jmInicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmInicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmInicio.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jmiIniciarSesion.setText("Iniciar Sesión");
        jmiIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiIniciarSesionActionPerformed(evt);
            }
        });
        jmInicio.add(jmiIniciarSesion);

        jmiCerrarSesion.setText("Cerrar Sesión");
        jmiCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCerrarSesionActionPerformed(evt);
            }
        });
        jmInicio.add(jmiCerrarSesion);

        jmiSalir.setText("Salir");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalirActionPerformed(evt);
            }
        });
        jmInicio.add(jmiSalir);

        jmbPrincipal.add(jmInicio);

        jmCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/citas.png"))); // NOI18N
        jmCita.setText("CITA");
        jmCita.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmCita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmCita.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jmiAdministrarCitas.setText("Administrar Citas");
        jmiAdministrarCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAdministrarCitasActionPerformed(evt);
            }
        });
        jmCita.add(jmiAdministrarCitas);

        jMenuItem7.setText("Generar Pre Factura");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jmCita.add(jMenuItem7);

        jmbPrincipal.add(jmCita);

        jmAdmision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/User-Files48.png"))); // NOI18N
        jmAdmision.setText("ADMISION");
        jmAdmision.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmAdmision.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmAdmision.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmAdmision.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jmAdmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAdmisionActionPerformed(evt);
            }
        });

        jMenuItem15.setText("Personas");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jmAdmision.add(jMenuItem15);

        jmbPrincipal.add(jmAdmision);

        jmAtencion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/doctor-icon.png"))); // NOI18N
        jmAtencion.setText("ATENCION");
        jmAtencion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmAtencion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmAtencion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmAtencion.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jmiEmitirComprobante.setText("Atención Pacientes");
        jmiEmitirComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEmitirComprobanteActionPerformed(evt);
            }
        });
        jmAtencion.add(jmiEmitirComprobante);

        jMenuItem16.setText("Catalogo de Servicios y Procedimientos");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jmAtencion.add(jMenuItem16);

        jmbPrincipal.add(jmAtencion);

        jmCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Cash-register-icon.png"))); // NOI18N
        jmCaja.setText("CAJA");
        jmCaja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmCaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmCaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmCaja.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jmCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCajaActionPerformed(evt);
            }
        });

        jMenuItem12.setText("Aperturar Caja");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jmCaja.add(jMenuItem12);

        jMenuItem13.setText("Cerrar Caja");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jmCaja.add(jMenuItem13);

        jMenu1.setText("Administrar Comprobante");

        jMenuItem6.setText("Farmacia Ventas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem5.setText("Farmacia Compras");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem9.setText("Admisión");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jmCaja.add(jMenu1);

        jMenuItem40.setText("Registrar Egresos");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        jmCaja.add(jMenuItem40);

        jMenuItem41.setText("Ingresar Pago a Médicos");
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
        jmCaja.add(jMenuItem41);

        jMenuItem1.setText("Realizar Pago a Médico");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmCaja.add(jMenuItem1);

        jmiReimpresionEgresos.setText("Reimprimir Egresos");
        jmiReimpresionEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiReimpresionEgresosActionPerformed(evt);
            }
        });
        jmCaja.add(jmiReimpresionEgresos);

        jmiMisComprobantesFarmacia.setText("Mis Comprobantes Farmacia");
        jmiMisComprobantesFarmacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMisComprobantesFarmaciaActionPerformed(evt);
            }
        });
        jmCaja.add(jmiMisComprobantesFarmacia);

        jmiMisComprobantesAdmision.setText("Mis Comprobantes Admisión");
        jmCaja.add(jmiMisComprobantesAdmision);

        jmCtasxCobrar.setText("Cuentas x Cobrar");

        jmiCtasxCobrarFarmacia.setText("Farmacia");
        jmiCtasxCobrarFarmacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCtasxCobrarFarmaciaActionPerformed(evt);
            }
        });
        jmCtasxCobrar.add(jmiCtasxCobrarFarmacia);

        jmiCtasxCobrarAdmision.setText("Admisión");
        jmCtasxCobrar.add(jmiCtasxCobrarAdmision);

        jmCaja.add(jmCtasxCobrar);

        jmbPrincipal.add(jmCaja);

        jmHistoriaClinica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/history.png"))); // NOI18N
        jmHistoriaClinica.setText("HISTORIA CLINICA");
        jmHistoriaClinica.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmHistoriaClinica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmHistoriaClinica.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmHistoriaClinica.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jmHistoriaClinica.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jmHistoriaClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmHistoriaClinicaActionPerformed(evt);
            }
        });

        jMenuItem11.setText("Historia Clínica");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jmHistoriaClinica.add(jMenuItem11);

        jMenuItem14.setText("Historia Clínica Ocupacional");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jmHistoriaClinica.add(jMenuItem14);

        jmbPrincipal.add(jmHistoriaClinica);

        jmContabilidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/sales-report-icon (1).png"))); // NOI18N
        jmContabilidad.setText("CONTABILIDAD");
        jmContabilidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmContabilidad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmContabilidad.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jmbPrincipal.add(jmContabilidad);

        jmReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/custom-reports-icon.png"))); // NOI18N
        jmReportes.setText("REPORTES");
        jmReportes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmReportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmReportes.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jmReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmReportesActionPerformed(evt);
            }
        });

        jmi001.setText("Reporte caja por turno");
        jmi001.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi001ActionPerformed(evt);
            }
        });
        jmReportes.add(jmi001);
        jmReportes.add(jSeparator1);

        jm008.setText("Compras");

        jMenuItem29.setText("Resumen");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jm008.add(jMenuItem29);

        jMenuItem31.setText("Detalle");
        jm008.add(jMenuItem31);

        jmReportes.add(jm008);

        jmi009.setText("Reporte de Compras");
        jmi009.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi009ActionPerformed(evt);
            }
        });
        jmReportes.add(jmi009);

        jmi010.setText("Reporte de Ventas");
        jmi010.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi010ActionPerformed(evt);
            }
        });
        jmReportes.add(jmi010);

        jmi012.setText("Reporte Salidas X Seguro");
        jmi012.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi012ActionPerformed(evt);
            }
        });
        jmReportes.add(jmi012);

        jMenuItem10.setText("Reporte planilla de atención FPS");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jmReportes.add(jMenuItem10);

        jMenuItem35.setText("Producto por Vencer");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jmReportes.add(jMenuItem35);

        jmi011.setText("Reporte inventario total");
        jmi011.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi011ActionPerformed(evt);
            }
        });
        jmReportes.add(jmi011);

        jmi013.setText("Reporte inventario fisico valorizado");
        jmi013.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi013ActionPerformed(evt);
            }
        });
        jmReportes.add(jmi013);

        jMenuItem25.setText("Reporte Consumo");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jmReportes.add(jMenuItem25);

        jMenuItem30.setText("Reporte nota salida por servicio");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jmReportes.add(jMenuItem30);

        jmi006.setText("Recaudación por Servicio y Procedimiento");
        jmi006.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi006ActionPerformed(evt);
            }
        });
        jmReportes.add(jmi006);

        jmi039.setText("Atenciones por Servicio");
        jmi039.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi039ActionPerformed(evt);
            }
        });
        jmReportes.add(jmi039);

        jmi040.setText("Atenciones por Servicio y Procedimiento");
        jmi040.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi040ActionPerformed(evt);
            }
        });
        jmReportes.add(jmi040);

        jmi041.setText("Atenciones por Médico");
        jmi041.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi041ActionPerformed(evt);
            }
        });
        jmReportes.add(jmi041);

        jmi038.setText("Planilla de Atención");
        jmi038.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi038ActionPerformed(evt);
            }
        });
        jmReportes.add(jmi038);

        jMenu2.setText("Planilla de Atención - Farmacia");
        jmReportes.add(jMenu2);

        jmiCuentasxCobrarFarmacia.setText("Cuentas por Cobrar - Farmacia");
        jmiCuentasxCobrarFarmacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCuentasxCobrarFarmaciaActionPerformed(evt);
            }
        });
        jmReportes.add(jmiCuentasxCobrarFarmacia);

        jmiExportarTarifario.setText("Exportar Tarifario(Excel)");
        jmiExportarTarifario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExportarTarifarioActionPerformed(evt);
            }
        });
        jmReportes.add(jmiExportarTarifario);

        jmiReporteUtilidad.setText("Reporte de Utilidad");
        jmiReporteUtilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiReporteUtilidadActionPerformed(evt);
            }
        });
        jmReportes.add(jmiReporteUtilidad);

        jmbPrincipal.add(jmReportes);

        jmPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/user-settings.png"))); // NOI18N
        jmPersonal.setText("PERSONAL");
        jmPersonal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmPersonal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmPersonal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmPersonal.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jmPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmPersonalActionPerformed(evt);
            }
        });

        jmiUsuarios.setText("Usuarios del Sistema");
        jmiUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUsuariosActionPerformed(evt);
            }
        });
        jmPersonal.add(jmiUsuarios);

        jmiStafProfesional.setText("Staff Profesional");
        jmiStafProfesional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiStafProfesionalActionPerformed(evt);
            }
        });
        jmPersonal.add(jmiStafProfesional);

        jmbPrincipal.add(jmPersonal);

        jmMiCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/System-Security.png"))); // NOI18N
        jmMiCuenta.setText("MI CUENTA");
        jmMiCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmMiCuenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmMiCuenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmMiCuenta.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        JMCambiarContrasenia.setText("Cambiar Contaseña");
        JMCambiarContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMCambiarContraseniaActionPerformed(evt);
            }
        });
        jmMiCuenta.add(JMCambiarContrasenia);

        jmbPrincipal.add(jmMiCuenta);

        jmAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/help.png"))); // NOI18N
        jmAyuda.setText("AYUDA");
        jmAyuda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmAyuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmAyuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmAyuda.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        Ayuda.setText("Manual de Usuario");
        Ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AyudaActionPerformed(evt);
            }
        });
        jmAyuda.add(Ayuda);

        JMAcercaDe.setText("Contactenos");
        JMAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMAcercaDeActionPerformed(evt);
            }
        });
        jmAyuda.add(JMAcercaDe);

        jMenuItem4.setText("Acerca de Lissa");
        jmAyuda.add(jMenuItem4);

        jmbPrincipal.add(jmAyuda);

        jmAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/kardex.png"))); // NOI18N
        jmAlmacen.setText("ALMACEN");
        jmAlmacen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmAlmacen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmAlmacen.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jmAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAlmacenActionPerformed(evt);
            }
        });

        jMenuItem20.setText("Registrar Movimiento");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jmAlmacen.add(jMenuItem20);

        jMenuItem28.setText("Kardex - Almacen");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jmAlmacen.add(jMenuItem28);

        jMenuItem22.setText("Stock Actual x Producto");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jmAlmacen.add(jMenuItem22);

        jMenuItem33.setText("Ajuste de Inventario");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jmAlmacen.add(jMenuItem33);

        jMenuItem27.setText("Administrar Precios");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jmAlmacen.add(jMenuItem27);

        jMenuItem34.setText("Administrar Fecha y Lote");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jmAlmacen.add(jMenuItem34);

        jmbPrincipal.add(jmAlmacen);

        jmVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/shopping-cart-up-icon.png"))); // NOI18N
        jmVentas.setText("VENTAS");
        jmVentas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmVentas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmVentas.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jMenuItem24.setText("Registrar Venta");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jmVentas.add(jMenuItem24);

        jMenuItem8.setText("Nota de Salida");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jmVentas.add(jMenuItem8);

        jmbPrincipal.add(jmVentas);

        jmCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/shopping-cart-down-icon.png"))); // NOI18N
        jmCompras.setText("COMPRAS");
        jmCompras.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmCompras.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jMenuItem26.setText("Registrar Compra");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jmCompras.add(jMenuItem26);

        jmbPrincipal.add(jmCompras);

        jmMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/application-settings.png"))); // NOI18N
        jmMantenimiento.setText("MANTENIMIENTO");
        jmMantenimiento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmMantenimiento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmMantenimiento.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jmMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmMantenimientoActionPerformed(evt);
            }
        });

        jMenuItem18.setText("Laboratorio");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jMenuItem18);

        jMenuItem19.setText("Forma Farmaceutica");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jMenuItem19);

        jMenuItem32.setText("Producto");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jMenuItem32);

        jMenuItem23.setText("Proveedor");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jMenuItem23);

        jMenuItem21.setText("Presentación");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jMenuItem21);

        jMenuItem36.setText("Convenios");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jMenuItem36);

        jMenuItem2.setText("Inventario Inicial");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jMenuItem2);

        jMenuItem3.setText("Consulta Fondo Solidaridad");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jMenuItem3);

        jMenuItem38.setText("Servicios y Procedimientos");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jMenuItem38);

        jMenuItem39.setText("Administrar Tarifario");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        jmMantenimiento.add(jMenuItem39);

        jmbPrincipal.add(jmMantenimiento);

        jmTriaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/nurse-girl-icon.png"))); // NOI18N
        jmTriaje.setText("TRIAJE");
        jmTriaje.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jmTriaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmTriaje.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jmTriaje.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jmTriaje.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jMenuItem37.setText("Administrar Atenciones");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        jmTriaje.add(jMenuItem37);

        jmiHc.setText("Historia Clinica");
        jmiHc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiHcActionPerformed(evt);
            }
        });
        jmTriaje.add(jmiHc);

        jmbPrincipal.add(jmTriaje);

        setJMenuBar(jmbPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDPContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 1077, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JDPContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void jmiUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUsuariosActionPerformed
        insertarInternalFrames(jifRegistrarUsuario);
        jifRegistrarUsuario.inicializar();
    }//GEN-LAST:event_jmiUsuariosActionPerformed

    private void jmAdmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAdmisionActionPerformed
    }//GEN-LAST:event_jmAdmisionActionPerformed

    private void JMAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMAcercaDeActionPerformed
        jdContactenos.setVisible(true);
    }//GEN-LAST:event_JMAcercaDeActionPerformed

    private void AyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AyudaActionPerformed
        visorManual();
    }//GEN-LAST:event_AyudaActionPerformed

    private void jmiEmitirComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEmitirComprobanteActionPerformed
        buscarCaja();
        if (oCaja != null) {
            insertarInternalFrames(jifEmitirComprobante);
            jifEmitirComprobante.cargarDatosUsuario(user);
            jifEmitirComprobante.inicializar();
            jifEmitirComprobante.EnviarDatosCaja(oCaja);
        } else {
            JOptionPane.showMessageDialog(null, "Aperture caja antes realizar cualquier operación", "Atención", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jmiEmitirComprobanteActionPerformed

    private void jmPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmPersonalActionPerformed


    }//GEN-LAST:event_jmPersonalActionPerformed

    private void jmiCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCerrarSesionActionPerformed
        cerrarSesion();
    }//GEN-LAST:event_jmiCerrarSesionActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        //jPanel8.setBounds(jDesktopPane1.getWidth()-(jPanel8.getWidth()+10),jPanel3.getHeight()+10,jPanel8.getWidth(),jPanel8.getHeight());       
        //jPanel3.setBounds(jDesktopPane1.getWidth()-(jPanel3.getWidth()+10),5,jPanel3.getWidth(),jPanel3.getHeight());
    }//GEN-LAST:event_formComponentResized

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        //Utilitarios.maximizar(this);
        //Utilitarios.centreaVentana(this);
    }//GEN-LAST:event_formComponentShown

    private void jmCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCajaActionPerformed

    }//GEN-LAST:event_jmCajaActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        insertarInternalFrames(jifBuscarComprobante);
        jifBuscarComprobante.inicializar();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jmiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalirActionPerformed
        salir();
    }//GEN-LAST:event_jmiSalirActionPerformed

    private void jmiIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiIniciarSesionActionPerformed
        jdIniciarSesion.setVisible(true);
    }//GEN-LAST:event_jmiIniciarSesionActionPerformed

    private void JMCambiarContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMCambiarContraseniaActionPerformed
        insertarInternalFrames(jifCambiarContraseña);
        jifCambiarContraseña.cargarDatosUser(user, oPersona);
    }//GEN-LAST:event_JMCambiarContraseniaActionPerformed

    private void jmiStafProfesionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiStafProfesionalActionPerformed
        insertarInternalFrames(jifAdministrarMedico);
        jifAdministrarMedico.inicializar();
    }//GEN-LAST:event_jmiStafProfesionalActionPerformed

    private void jmHistoriaClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmHistoriaClinicaActionPerformed

    }//GEN-LAST:event_jmHistoriaClinicaActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        insertarInternalFrames(jifHistoriaClinica);
        jifHistoriaClinica.cargarDatosUser(user, oPersona, oRol);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        //BUSCAR  SI EXISTE ALGUNA CAJA ABIERTA
        /*Si existe alguna caja abierta para el usuario a asignar, entonces no debe permitir la apertura
         *Si el usuario aun no tiene  ninguna caja aperturada, proceder  con su aperetura*/
        insertarInternalFrames(jifAbrirCaja);
        jifAbrirCaja.inicializar();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        insertarInternalFrames(jifCerrarCajaFar);
        jifCerrarCajaFar.cargarDatosUser(user, oPersona, oRol);
        jifCerrarCajaFar.inicializar();
        


    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //salir();
    }//GEN-LAST:event_formWindowClosing

    private void jmReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmReportesActionPerformed

    }//GEN-LAST:event_jmReportesActionPerformed

    private void jmi001ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi001ActionPerformed
        insertarInternalFrames(jifRepTurno);
        jifRepTurno.inicializar();
    }//GEN-LAST:event_jmi001ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed


    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        insertarInternalFrames(jifAdmision);
        jifAdmision.iniciar();
        jifAdmision.enviarDatos(user, oRol);
        jifAdmision.enviarDatosCaja(buscarCaja());
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        insertarInternalFrames(jifCompras);
        jifCompras.cargarDatosUser(user, oPersona, oRol);
        jifCompras.inicializar();
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
        insertarInternalFrames(jifAdminProducto);
        this.jifAdminProducto.inicializarJif();
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        insertarInternalFrames(jifAdminLaboratorio);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        insertarInternalFrames(jifAdminFormaFarmaceutica);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
//        insertarInternalFrames(jifVentas);
//        jifVentas.cargarDatosUser(user, oPersona, oRol);
//        jifVentas.inicializar();

        buscarCaja();
        if (oCaja != null && oCaja.getAreaCaja().getModulo().equals("CAJA 02 - FARMACIA")) {
            insertarInternalFrames(jifRegVentas);
            jifRegVentas.cargarDatosUser(user, oPersona, oRol);
            jifRegVentas.inicializar();
            jifRegVentas.EnviarDatosCaja(oCaja);

        } else {
            JOptionPane.showMessageDialog(null, "Aperture caja antes realizar cualquier operación", "Atención", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jmAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAlmacenActionPerformed

    }//GEN-LAST:event_jmAlmacenActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        insertarInternalFrames(jifAlmacen);
        jifAlmacen.cargarDatosUser(user, oPersona, oRol);
        jifAlmacen.inicializar();
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        insertarInternalFrames(jifAdminPresentacion);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        insertarInternalFrames(jifKardexAlmacen);
        jifKardexAlmacen.inicializar();
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        insertarInternalFrames(jifStockActual);
        jifStockActual.inicializar();
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jmi009ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi009ActionPerformed
        insertarInternalFrames(jifComprasResumen);
        jifComprasResumen.inicializar();
    }//GEN-LAST:event_jmi009ActionPerformed

    private void jmi010ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi010ActionPerformed
        insertarInternalFrames(jifRepVentas);
        jifRepVentas.inicializar();
    }//GEN-LAST:event_jmi010ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        insertarInternalFrames(jifProductosXVencer);
        jifProductosXVencer.inicializar();
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        insertarInternalFrames(jifAdministrarSeguro);
        jifAdministrarSeguro.inicializar();
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        insertarInternalFrames(jifAdministrarPersonaJuridica);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        insertarInternalFrames(jifRealizarPagoMedicos);
        jifRealizarPagoMedicos.resetComponents();
        jifRealizarPagoMedicos.enviarDatos(user);
        jifRealizarPagoMedicos.enviarCaja(buscarCaja());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        insertarInternalFrames(jifMigrar);
        jifMigrar.inicializar();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jmi011ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi011ActionPerformed
        generarReporte();
    }//GEN-LAST:event_jmi011ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        insertarInternalFrames(jifConsultaFPS);
        jifConsultaFPS.inicializar();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        insertarInternalFrames(jifBuscarComprobanteVenta);
        jifBuscarComprobanteVenta.inicializar();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jmi012ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi012ActionPerformed
        jifSalidasXFecha = new JIF_SalidasXFecha(this);
        insertarInternalFrames(jifSalidasXFecha);
        jifSalidasXFecha.inicializar();

    }//GEN-LAST:event_jmi012ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        insertarInternalFrames(jifBuscarComprobantesCompras);
        jifBuscarComprobantesCompras.inicializar();

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        insertarInternalFrames(jifNotaSalidafar);
        jifNotaSalidafar.cargarDatosUser(user, oPersona, oRol);
        jifNotaSalidafar.inicializar();

    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        insertarInternalFrames(jifRepFPS);
        jifRepFPS.inicializar();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jmi013ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi013ActionPerformed
        generarReportePrecioCompra();

    }//GEN-LAST:event_jmi013ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        insertarInternalFrames(jifrepCoebrtura);

    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jmMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmMantenimientoActionPerformed
        insertarInternalFrames(jifAdministrarTarifario);
    }//GEN-LAST:event_jmMantenimientoActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        insertarInternalFrames(jifAdminPrecioVenta);
        jifAdminPrecioVenta.enviaUser(user);
        jifAdminPrecioVenta.iniciar();
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        insertarInternalFrames(jifNotaSalidaXfecha);
        jifNotaSalidaXfecha.inicializar();
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        insertarInternalFrames(jifAjusteInventario);
        jifAjusteInventario.iniciar();
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        insertarInternalFrames(jifAdminAlmacenProducto);
        jifAdminAlmacenProducto.iniciar();
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed
        abrirJifAdministrarAtencion();
    }//GEN-LAST:event_jMenuItem37ActionPerformed

    private void jmi038ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi038ActionPerformed
        insertarInternalFrames(jifSabanon);
    }//GEN-LAST:event_jmi038ActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        insertarInternalFrames(jifAdministrarProcedimiento);
        jifAdministrarProcedimiento.iniciar();
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        insertarInternalFrames(jifAdministrarTarifario);
        jifAdministrarTarifario.enviarDatosUsuario(user);
        jifAdministrarTarifario.iniciar();

    }//GEN-LAST:event_jMenuItem39ActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        insertarInternalFrames(jifEgresos);
        jifEgresos.enviaUser(user);
        jifEgresos.inicializar();
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41ActionPerformed
        insertarInternalFrames(jifRegistrarPagoMedicos);
        jifRegistrarPagoMedicos.resetComponents();
        jifRegistrarPagoMedicos.enviarDatos(user);
    }//GEN-LAST:event_jMenuItem41ActionPerformed

    private void jmi039ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi039ActionPerformed
        insertarInternalFrames(jifRepXServicio);
        jifRepXServicio.iniciar();
    }//GEN-LAST:event_jmi039ActionPerformed

    private void jmi040ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi040ActionPerformed
        insertarInternalFrames(jifRepXServYproc);
        jifRepXServYproc.iniciar();
    }//GEN-LAST:event_jmi040ActionPerformed

    private void jmi041ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi041ActionPerformed
        insertarInternalFrames(jifRepxMedico);
        jifRepxMedico.iniciar();
    }//GEN-LAST:event_jmi041ActionPerformed

    private void jmi006ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi006ActionPerformed
        insertarInternalFrames(jifReporteRecaudacionXServicio);
    }//GEN-LAST:event_jmi006ActionPerformed

    private void jmiHcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiHcActionPerformed
        insertarInternalFrames(jifTriajePersonas);
        jifTriajePersonas.iniciar();
    }//GEN-LAST:event_jmiHcActionPerformed

    private void jmiReimpresionEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiReimpresionEgresosActionPerformed
        insertarInternalFrames(jifReimprimirEgreso);
        jifReimprimirEgreso.iniciar();
    }//GEN-LAST:event_jmiReimpresionEgresosActionPerformed

    private void jmiAdministrarCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAdministrarCitasActionPerformed
        insertarInternalFrames(jifAdministrarCitas);
        jifAdministrarCitas.setoUsuario(user);
        jifAdministrarCitas.iniciar();

    }//GEN-LAST:event_jmiAdministrarCitasActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        insertarInternalFrames(jifGenerarPreFactura);
        jifGenerarPreFactura.iniciar();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        buscarProcedimiento();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jmiMisComprobantesFarmaciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMisComprobantesFarmaciaActionPerformed
        insertarInternalFrame();
    }//GEN-LAST:event_jmiMisComprobantesFarmaciaActionPerformed

    private void jmiCtasxCobrarFarmaciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCtasxCobrarFarmaciaActionPerformed
        insertarInternalFrameCuentasxCobrar();
    }//GEN-LAST:event_jmiCtasxCobrarFarmaciaActionPerformed

    private void jmiCuentasxCobrarFarmaciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCuentasxCobrarFarmaciaActionPerformed
        insertarInternalFrames(jifRepCuentasxCobrarfarmacia);
        jifRepCuentasxCobrarfarmacia.inicializar();
    }//GEN-LAST:event_jmiCuentasxCobrarFarmaciaActionPerformed

    private void jmiExportarTarifarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExportarTarifarioActionPerformed
        GenerarExcelTarifario();
    }//GEN-LAST:event_jmiExportarTarifarioActionPerformed

    private void jmiReporteUtilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiReporteUtilidadActionPerformed
        insertarInternalFrames(jifReporteUtilidad);
        jifReporteUtilidad.inicializar();
    }//GEN-LAST:event_jmiReporteUtilidadActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new JF_Principal().setVisible(true);

                } catch (Exception ex) {
                    Logger.getLogger(JF_Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Ayuda;
    private javax.swing.JDesktopPane JDPContenedor;
    private javax.swing.JMenuItem JMAcercaDe;
    private javax.swing.JMenuItem JMCambiarContrasenia;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenu jm008;
    private javax.swing.JMenu jmAdmision;
    private javax.swing.JMenu jmAlmacen;
    private javax.swing.JMenu jmAtencion;
    private javax.swing.JMenu jmAyuda;
    private javax.swing.JMenu jmCaja;
    private javax.swing.JMenu jmCita;
    private javax.swing.JMenu jmCompras;
    private javax.swing.JMenu jmContabilidad;
    private javax.swing.JMenu jmCtasxCobrar;
    private javax.swing.JMenu jmHistoriaClinica;
    private javax.swing.JMenu jmInicio;
    private javax.swing.JMenu jmMantenimiento;
    private javax.swing.JMenu jmMiCuenta;
    private javax.swing.JMenu jmPersonal;
    private javax.swing.JMenu jmReportes;
    private javax.swing.JMenu jmTriaje;
    private javax.swing.JMenu jmVentas;
    private javax.swing.JMenuBar jmbPrincipal;
    private javax.swing.JMenuItem jmi001;
    private javax.swing.JMenuItem jmi006;
    private javax.swing.JMenuItem jmi009;
    private javax.swing.JMenuItem jmi010;
    private javax.swing.JMenuItem jmi011;
    private javax.swing.JMenuItem jmi012;
    private javax.swing.JMenuItem jmi013;
    private javax.swing.JMenuItem jmi038;
    private javax.swing.JMenuItem jmi039;
    private javax.swing.JMenuItem jmi040;
    private javax.swing.JMenuItem jmi041;
    private javax.swing.JMenuItem jmiAdministrarCitas;
    private javax.swing.JMenuItem jmiCerrarSesion;
    private javax.swing.JMenuItem jmiCtasxCobrarAdmision;
    private javax.swing.JMenuItem jmiCtasxCobrarFarmacia;
    private javax.swing.JMenuItem jmiCuentasxCobrarFarmacia;
    private javax.swing.JMenuItem jmiEmitirComprobante;
    private javax.swing.JMenuItem jmiExportarTarifario;
    private javax.swing.JMenuItem jmiHc;
    private javax.swing.JMenuItem jmiIniciarSesion;
    private javax.swing.JMenuItem jmiMisComprobantesAdmision;
    private javax.swing.JMenuItem jmiMisComprobantesFarmacia;
    private javax.swing.JMenuItem jmiReimpresionEgresos;
    private javax.swing.JMenuItem jmiReporteUtilidad;
    private javax.swing.JMenuItem jmiSalir;
    private javax.swing.JMenuItem jmiStafProfesional;
    private javax.swing.JMenuItem jmiUsuarios;
    // End of variables declaration//GEN-END:variables

    private void ponerFondo(JDesktopPane JDPContenedor) {
        BufferedImage imagen = null;
        URL path = getClass().getClassLoader().getResource("lissa/imagenes/backgroundFinal1.jpg");

        try {
            imagen = ImageIO.read(path);
            JDPContenedor.setBorder(new Background(imagen));
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarInternalFrames(JInternalFrame jif) {
        try {
            Utilitarios.insertaInternalFrame(jif, JDPContenedor);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(JF_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void personalizaFondoEscritorio(JDesktopPane dp) {
        BufferedImage imagen = null;
        URL path = getClass().getResource("/lissa/resources/FondoDesktop.png");
        try {
            imagen = ImageIO.read(path);
            dp.setBorder(new DesktopPaneBackground(imagen));
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void visorManual() {
        JOptionPane.showMessageDialog(null, "El Manual  de usuario no esta disponible", "Atención", JOptionPane.INFORMATION_MESSAGE);
    }

    private void salir() {
        int op = JOptionPane.showConfirmDialog(this, "Esta seguro que desea salir del sistema.", "Atención", JOptionPane.YES_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            cerrarSesion();
            System.exit(0);
        }
    }

    public void loguinStart() {
        jdIniciarSesion.validaConfFile();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Persona getoPersona() {
        return oPersona;
    }

    public void setoPersona(Persona oPersona) {
        this.oPersona = oPersona;
    }

    public FileConf getConfig() {
        return config;
    }

    public void setConfig(FileConf config) {
        this.config = config;
    }

    private long numCajasAbi() {
        ocajaBl = new CajaBl();
        return ocajaBl.numCajasAbi();
    }

    public Rol getoRol() {
        return oRol;
    }

    public void setoRol(Rol oRol) {
        this.oRol = oRol;
    }

    private void generarReportePrecioCompra() {
        Reportes rep = new Reportes(this);
        rep.reportePrecioCompraUnd();
    }

    private void generarReporte() {
        Reportes rep = new Reportes(this);
        rep.reporteStockTotal();
    }

    private void reportesXResponsabilidad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void abrirJifAdministrarAtencion() {
        insertarInternalFrames(jifAdministrarAtencion);
        jifAdministrarAtencion.enviarDatos(getUser());
    }

    void configuraInterfazJefeVacio() {
        jmbPrincipal.removeAll();
        desHabilitarLoguin();
        jmbPrincipal.add(jmInicio);
        jmbPrincipal.updateUI();
        JOptionPane.showMessageDialog(null, "No existe modulo configurado.. Vuelva a ingresar al sistema", "Atención", JOptionPane.INFORMATION_MESSAGE);
    }

    private void buscarProcedimiento() {
        jifBuscarProcedimiento.setInvocador(JIF_BuscarProcedimiento.JIF_PRINCIPAL);
        insertarInternalFrames(jifBuscarProcedimiento);
        jifBuscarProcedimiento.enviarUser(getUser());
        jifBuscarProcedimiento.inicializar();
    }

    private void insertarInternalFrame() {
        insertarInternalFrames(jifMisComprobantes);
        jifMisComprobantes.inicializar();
    }

    private void insertarInternalFrameCuentasxCobrar() {
        insertarInternalFrames(jifCuentasxCobrarFarmacia);
        jifCuentasxCobrarFarmacia.inicializar();
    }

    private void GenerarExcelTarifario() {
        ProcedimientoTarifarioBl oProcedimientoTarifarioBl = new ProcedimientoTarifarioBl();
        List<ProcedimientoTarifario> listProcedimientoTarifario;
        listProcedimientoTarifario = oProcedimientoTarifarioBl.listarFull();
        if(!listProcedimientoTarifario.isEmpty()){
            generarExcel(listProcedimientoTarifario);
        }else{
            Mensajes.msjResultVacio();
        }
    }

    private void generarExcel(List<ProcedimientoTarifario> listProcedimientoTarifario) {
        int fil = 0;
        try {
            //ProcedimientoTarifario obj;
            //Crear titulos de las columnas
            String titulos[] = {"TARIFARIO", "SERVICIO", "CODIGO", "PROCEDIMIENTO", "COSTO"};
            //Definir  ruta del archivo
            String ruta = System.getProperty("user.home") + "/Tarifario.xls";
            //Definir File que  contenga el archivo
            File archivo = new File(ruta);
            //Validar  la exietencia del archivo
            if (archivo.exists()) {
                archivo.delete();
            }
            archivo.createNewFile();
            //Creamos el libro excel
            Workbook libro = new HSSFWorkbook();
            //inicializar  flujo de datos
            FileOutputStream file = new FileOutputStream(archivo);
            //Creamos la hoja dentro del libro
            Sheet hoja = (Sheet) libro.createSheet("Tarifario");
            //Escribir los datos en la hoja
            //Creamos una fila en la hoja en la posicion 0
            Row fila = hoja.createRow(0);

            // Creamos el estilo de celda del color VERDE
            HSSFCellStyle styleGroup1 = (HSSFCellStyle) libro.createCellStyle();
            styleGroup1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            styleGroup1.setFillForegroundColor(HSSFColor.GREEN.index);
            //fin de estilo de cabecera
            //Creamos el encabezado
            for (int i = 0; i < titulos.length; i++) {
                Cell celda = fila.createCell(i);
                celda.setCellValue(titulos[i]);
                celda.setCellStyle(styleGroup1);
            }
            
            //Hacer  el ciclo de acuerdo a la cantidad de datos
            for (ProcedimientoTarifario obj : listProcedimientoTarifario) {
                //obj = new ComprobanteDetalle();
                //obj = listComprobanteDetalle.get(i);
                
                //la clase row nos permite crear las filas
                Row fila1 = hoja.createRow(fil + 1);
                //cantidad de celdas de datos
                fil++;
                for (int j = 0; j < titulos.length; j++) {
                    int iterador = 0;
                    Cell celda1 = fila1.createCell(j);
                    switch (j) {
                        case 0:
                            if (obj.getTarifario() != null) {
                                celda1.setCellValue(obj.getTarifario().getNombre());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;
                        case 1:
                            if (obj.getProcedimiento().getServicio() != null) {
                                celda1.setCellValue(obj.getProcedimiento().getServicio().getDenominacion());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;
                        case 2:
                            if (obj.getProcedimiento() != null || !obj.getProcedimiento().getCodigo().equals("")) {
                                celda1.setCellValue(obj.getProcedimiento().getCodigo());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;
                        case 3:
                            if (obj.getProcedimiento() != null) {
                                celda1.setCellValue(obj.getProcedimiento().getDenominacion());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;

                        case 4:
                            if (obj != null) {
                                celda1.setCellValue(obj.getCosto().toString());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;                       
                    }

                }

            }
            /*Escribimos en el libro*/
            libro.write(file);
            //

            /**
             * Primero obtenemos la primera hoja del excel, despues la primera
             * columna que viene siendo la cabecera y despues la cantidad de
             * celdas que tiene esa columna para darle autosize a cada celda en
             * el for.
             */
            for (int i = 0; i < libro.getSheetAt(0).getRow(0)
                    .getLastCellNum(); i++) {
                libro.getSheetAt(0).autoSizeColumn((short) i);
            }
            /*Cerramos el flujo*/
            file.close();
            Mensajes.msjArchivoGeneradoConExito(System.getProperty("user.home"));
        } catch (IOException ex) {
            Logger.getLogger(JIF_Sabanon.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }

    public class DesktopPaneBackground implements Border {

        private final BufferedImage image;

        public DesktopPaneBackground(BufferedImage image) {
            this.image = image;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(0, 0, 0, 0);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawImage(image, 0, 0, c.getWidth(), c.getHeight(), null);
        }
    }

    public void configuraInterfazTriaje() {
        jmbPrincipal.removeAll();
        habilitarLoguin();
        jmbPrincipal.add(jmInicio);
        jmbPrincipal.add(jmMiCuenta);
        jmbPrincipal.add(jmTriaje);
        jmbPrincipal.add(Box.createHorizontalGlue());
        jmbPrincipal.add(jmAyuda);
        jmbPrincipal.updateUI();
    }

    public void configuraInterfazAdmision() {
        jmbPrincipal.removeAll();
        habilitarLoguin();
        jmbPrincipal.add(jmInicio);
        jmbPrincipal.add(jmCita);
        jmbPrincipal.add(jmAdmision);
        //Definir las opciones del menu atencion
        jmbPrincipal.add(jmAtencion);
        jmAtencion.removeAll();
        jmAtencion.add(jmiEmitirComprobante);
        jmAtencion.add(jMenuItem16);
        //
        jmbPrincipal.add(jmCaja);
        jmCaja.removeAll();
        jmCaja.add(jMenuItem12);
        jmCaja.add(jMenuItem13);
        jmCaja.add(jMenuItem1);
        jmCaja.add(jMenuItem40);
        jmCaja.add(jMenuItem41);
        //MENU REPORTES
        jmbPrincipal.add(jmReportes);
        jmReportes.removeAll();
        jmReportes.add(jmi038);
        //MENU PERSONAL
        jmbPrincipal.add(jmPersonal);
        jmPersonal.removeAll();
        jmPersonal.add(jmiStafProfesional);

        //MENU MI CUENTA
        jmbPrincipal.add(jmMiCuenta);
        //SEPARADOR
        jmbPrincipal.add(Box.createHorizontalGlue());
        jmbPrincipal.add(jmAyuda);
        jmbPrincipal.updateUI();
    }

    //JEFE CAJA
    public void configuraInterfazJefeCaja() {
        jmbPrincipal.removeAll();
        habilitarLoguin();
        jmbPrincipal.add(jmInicio);
        //MENU CAJA
        jmbPrincipal.add(jmCaja);
        jmCaja.removeAll();
        jmCaja.add(jMenuItem12);
        jmCaja.add(jMenuItem13);
        jmCaja.add(jMenu1);
        jMenu1.removeAll();
        jMenu1.add(jMenuItem6);
        jMenu1.add(jMenuItem5);
        jmCaja.add(jMenuItem41);
        //MENU MI CUENTA
        jmbPrincipal.add(jmMiCuenta);
        //MENU REPORTES
        jmbPrincipal.add(jmReportes);
        jmReportes.removeAll();
        jmReportes.add(jmi001);
        jmReportes.add(jmi009);
        jmReportes.add(jmi010);
        jmReportes.add(jmi011);
        jmReportes.add(jmiReporteUtilidad);
        //MENU PERSONAL
        jmbPrincipal.add(jmPersonal);
        jmPersonal.removeAll();
        jmPersonal.add(jmiUsuarios);
        //ALMACEN FARMACIA      
        jmbPrincipal.add(jmAlmacen);
        jmAlmacen.removeAll();
        jmAlmacen.add(jMenuItem33);
        jmAlmacen.add(jMenuItem28);
        //MENU MI CUENTA
        jmbPrincipal.add(jmMiCuenta);
        //SEPARADOR
        jmbPrincipal.add(Box.createHorizontalGlue());
        jmbPrincipal.add(jmAyuda);

        jmbPrincipal.updateUI();
    }

    public void configuraInterfazGerencia() {
        jmbPrincipal.removeAll();
        habilitarLoguin();
        jmbPrincipal.add(jmInicio);
        jmbPrincipal.add(jmReportes);
        jmbPrincipal.add(jmMiCuenta);
        jmbPrincipal.add(Box.createHorizontalGlue());
        jmbPrincipal.add(jmAyuda);

        jmbPrincipal.updateUI();
    }

    //INTERFAR FARMACIA
    public void configuraInterfazFarmacia() {
        jmbPrincipal.removeAll();
        habilitarLoguin();
        jmbPrincipal.add(jmInicio);
        jmbPrincipal.add(jmMantenimiento);
        jmMantenimiento.removeAll();
        jmMantenimiento.add(jMenuItem18);
        jmMantenimiento.add(jMenuItem19);
        jmMantenimiento.add(jMenuItem32);
        jmMantenimiento.add(jMenuItem21);
        jmMantenimiento.add(jMenuItem2);
        jmbPrincipal.add(jmCaja);
        jmCaja.removeAll();
        jmCaja.add(jMenuItem12);
        jmCaja.add(jMenuItem13);
        jmbPrincipal.add(jmVentas);
        jmbPrincipal.add(jmCompras);
        //Almacen        
        jmbPrincipal.add(jmAlmacen);
        jmAlmacen.removeAll();
        jmAlmacen.add(jMenuItem20);
        jmAlmacen.add(jMenuItem28);
        jmAlmacen.add(jMenuItem22);
        jmAlmacen.add(jMenuItem27);
        jmAlmacen.add(jMenuItem34);
        //Reportes
        jmbPrincipal.add(jmReportes);
        jmReportes.removeAll();
        jmReportes.add(jmi009);
        jmReportes.add(jmi010);
        jmReportes.add(jmi013);
        jmReportes.add(jMenuItem35);
        //
        jmbPrincipal.add(jmMiCuenta);
        jmbPrincipal.add(Box.createHorizontalGlue());
        jmbPrincipal.add(jmAyuda);

        jmbPrincipal.updateUI();
    }

    public void configuraInterfazSistemas() {
        jmbPrincipal.removeAll();
        habilitarLoguin();
        jmbPrincipal.add(jmInicio);
        jmbPrincipal.add(jmPersonal);
        jmbPrincipal.add(jmMiCuenta);
        jmbPrincipal.add(Box.createHorizontalGlue());
        jmbPrincipal.add(jmAyuda);

        jmbPrincipal.updateUI();
    }

    private void cerrarSesion() {
        this.setUser(null);
        jmbPrincipal.removeAll();
        jmInicio.removeAll();
        jmInicio.add(jmiIniciarSesion);
        //jmInicio.add(jmiCerrarSesion);
        jmInicio.add(jmiSalir);
        jmbPrincipal.add(jmInicio);
        jmbPrincipal.add(Box.createHorizontalGlue());
        jmbPrincipal.updateUI();
        JDPContenedor.removeAll();

    }

    public void desHabilitarLoguin() {
        jmInicio.removeAll();
        jmInicio.add(jmiIniciarSesion);
        jmInicio.add(jmiSalir);
    }

    public void habilitarLoguin() {
        jmInicio.removeAll();
        jmInicio.add(jmiCerrarSesion);
        jmInicio.add(jmiSalir);
    }

    public Caja buscarCaja() {
        oCaja = new Caja();
        ocajaBl = new CajaBl();
        oCaja = ocajaBl.buscarPorIdusuario(user);
        return oCaja;
    }

}
