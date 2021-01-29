package lissa.gui.farmacia;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import lissa.be.Almacen;
import lissa.be.AlmacenProducto;
import lissa.be.DetalleVenta;
import lissa.be.Kardex;
import lissa.be.Persona;
import lissa.be.Producto;
import lissa.be.Venta;
import lissa.bl.AlmacenProductoBl;
import lissa.bl.DetalleVentaBl;
import lissa.bl.KardexBl;
import lissa.bl.PersonaBl;
import lissa.bl.VentaBl;
import lissa.controller.AlmacenCtrl;
import lissa.ds.DSConeccion;
import lissa.gui.JF_Principal;
import lissa.gui.JIF_BuscarPersonaNatural;
import lissa.reportes.ReportGeneric;
import lissa.table.ModeloComprobanteVenta;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Variables;

public class JIF_BuscarComprobanteVenta extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloComprobanteVenta oModeloComprobanteVenta;
    private Persona oPersona;
    private PersonaBl oPersonaBl;
    private Venta oVenta;
    private Venta oVentaTemp;
    private VentaBl oVentaBl;
    private List<Venta> listVenta;
    private List<Persona> listPersona;
    //Variables para el reporte
    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;

    private String tipoComprobante = "";
    private DetalleVenta oDetalleVenta;
    private DetalleVentaBl oDetalleVentaBl;
    private List<DetalleVenta> listDetalleVenta;
    private Kardex oKardex;
    private KardexBl oKardexBl;
    private JComboBox cbxAlmacen;
    private AlmacenCtrl oAlmacenCtrl;
    private AlmacenProducto oAlmacenProducto;
    private AlmacenProductoBl oAlmacenProductoBl;

    public JIF_BuscarComprobanteVenta(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloComprobanteVenta = new ModeloComprobanteVenta();
        tblResultados.setModel(oModeloComprobanteVenta);
        cbxAlmacen = new JComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txfNumComprobante = new javax.swing.JTextField();
        btnBusqAvanzada = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        btnImprimir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        rbtnActivo = new javax.swing.JRadioButton();
        rbtnAnulado = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        txfMotivoAnulacion = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Buscar Comprobante");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setText("N° Comprobante :");

        txfNumComprobante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNumComprobanteKeyReleased(evt);
            }
        });

        btnBusqAvanzada.setText("Búsqueda Avanzada por cliente");
        btnBusqAvanzada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusqAvanzadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBusqAvanzada)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBusqAvanzada)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txfNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3))
        );

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblResultadosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultados);

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Administración", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        buttonGroup1.add(rbtnActivo);
        rbtnActivo.setText("Activo");

        buttonGroup1.add(rbtnAnulado);
        rbtnAnulado.setText("Anulado");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnActivo)
                    .addComponent(rbtnAnulado))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnActivo)
                .addGap(0, 0, 0)
                .addComponent(rbtnAnulado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Motivo de anulación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txfMotivoAnulacion, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txfMotivoAnulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton2.setText("Anular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImprimir))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimir)
                    .addComponent(jButton2))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        if (oVenta.getEstado().equals("ANU")) {
            Mensajes.docAnulado();
        } else {
            imprimir();
        }

    }//GEN-LAST:event_btnImprimirActionPerformed

    private void tblResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseReleased
        obtenerDatos();
    }//GEN-LAST:event_tblResultadosMouseReleased

    private void txfNumComprobanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNumComprobanteKeyReleased
        Utilitarios.validaCaracterNumerico(evt, txfNumComprobante);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txfNumComprobante.getText().trim().equals("")) {
                buscarPersonaxNumComprobante(txfNumComprobante.getText().trim().toUpperCase());
                personalizarTabla();
            } else {
                Mensajes.msjValidarIngreso();
            }
        }
    }//GEN-LAST:event_txfNumComprobanteKeyReleased

    private void btnBusqAvanzadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusqAvanzadaActionPerformed
        root.jifBuscarPersonaNatural.setInvocador(JIF_BuscarPersonaNatural.JIF_BUSCAR_COMPROBANTE_VENTA);
        root.insertarInternalFrames(root.jifBuscarPersonaNatural);

    }//GEN-LAST:event_btnBusqAvanzadaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (oVenta.getEstado().equals("ACT")) {
            if (isDatosValidos()) {
                if (anular() == Variables.SUCCESS) {
                    inicializar();
                    Mensajes.msjRegCorrecta();
                } else {
                    Mensajes.msjRegError();
                }
            } else {
                Mensajes.msjValidarIngreso();
            }
        } else {
            Mensajes.docAnulado();
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusqAvanzada;
    private javax.swing.JButton btnImprimir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnActivo;
    private javax.swing.JRadioButton rbtnAnulado;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txfMotivoAnulacion;
    private javax.swing.JTextField txfNumComprobante;
    // End of variables declaration//GEN-END:variables

    private void buscarPersonaxDni(String dni) {
        oPersona = new Persona();
        oPersonaBl = new PersonaBl();
        oPersona = oPersonaBl.buscarPersonaXDni(dni);
        oModeloComprobanteVenta.clear();
        if (oPersona != null) {
            buscarComprobantexIdCliente(oPersona.getIdpersona());
        }
    }

    private void buscarComprobantexIdCliente(long idPersona) {
        oVenta = new Venta();
        oVentaBl = new VentaBl();
        listVenta = oVentaBl.listarxIdCliente(idPersona);
        oModeloComprobanteVenta.clear();
        if (!listVenta.isEmpty()) {
            for (Venta obj : listVenta) {
                oModeloComprobanteVenta.add(obj);
            }
        }
    }

    private void listarVentasAll() {
        oVenta = new Venta();
        oVentaBl = new VentaBl();
        listVenta = oVentaBl.listarAll();
        if (!listVenta.isEmpty()) {
            for (Venta obj : listVenta) {
                oModeloComprobanteVenta.add(obj);
            }
        }
    }

    private void obtenerDatos() {
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            oVenta = oModeloComprobanteVenta.get(tblResultados.getSelectedRow());
            if (oVenta.getFarComprobante().getComprobante().equals("FACTURA")) {
                tipoComprobante = "FacturaFar";
            } else if (oVenta.getFarComprobante().getComprobante().equals("BOLETA")) {
                tipoComprobante = "OtrosComprobantesFar";
            } else if (oVenta.getFarComprobante().getComprobante().equals("BOLETA SEGUROS")) {
                tipoComprobante = "Far_BoletaSeguros";
            } else if (oVenta.getFarComprobante().getComprobante().equals("BOLETA ELECTRONICA")) {
                tipoComprobante = Variables.FAR_BOLETA_ELECTRONICA;
            } else if (oVenta.getFarComprobante().getComprobante().equals("FACTURA ELECTRONICA")) {
                tipoComprobante = Variables.FAR_FACTURA_ELECTRONICA;
            }
        } else {
            Mensajes.tblSelected();
        }
    }

    private void imprimir() {
        try {
            ds = new lissa.ds.DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport(tipoComprobante, new String[]{"ID_COMPROBANTE"}, new Object[]{oVenta.getIdventa()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Comprobante");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
        } catch (Exception ex) {
            Mensajes.ErrorReporte(ex);
            //Logger.getLogger(JIF_BuscarComprobanteVenta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void personalizarTabla() {
        System.out.println("");
    }

    private void buscarPersonaxNumComprobante(String num) {
        oVentaBl = new VentaBl();
        listVenta = oVentaBl.listarXNumComprobante(num);
        oModeloComprobanteVenta.clear();
        if (!listVenta.isEmpty()) {
            for (Venta obj : listVenta) {
                oModeloComprobanteVenta.add(obj);
            }
        } else {
            Mensajes.msjResultVacio();
        }
    }

    public void cargarDatosPersona(Persona beanTabla) {
        oPersona = beanTabla;
        buscarComprobantexIdCliente(oPersona.getIdpersona());
    }

    private boolean isDatosValidos() {
        return (tblResultados.getRowSelectionAllowed()
                && tblResultados.getSelectedRow() != -1
                && rbtnAnulado.isSelected()
                && !txfMotivoAnulacion.getText().trim().toUpperCase().equals(""));
    }

    private int anular() {
        oVentaBl = new VentaBl();
        oVentaTemp = new Venta();

        oVentaTemp.setIdventa(oVenta.getIdventa());
        oVentaTemp.setEstadoSunat("ANULADO");
        oVentaTemp.setPersonaPaciente(oVenta.getPersonaPaciente());
        oVentaTemp.setClientepersonanatural(oVenta.getClientepersonanatural() != null ? oVenta.getClientepersonanatural() : null);
        oVentaTemp.setUsuarioReg(oVenta.getUsuarioReg());
        oVentaTemp.setFechaVenta(oVenta.getFechaVenta());
        oVentaTemp.setHoraVenta(oVenta.getHoraVenta());
        oVentaTemp.setFarComprobante(oVenta.getFarComprobante());
        oVentaTemp.setSerie(oVenta.getSerie().trim());
        oVentaTemp.setNumComprobante(oVenta.getNumComprobante());
        oVentaTemp.setCorreoClienteTemp(oVenta.getCorreoClienteTemp().trim());
        oVentaTemp.setGrupoNumeracion(oVenta.getGrupoNumeracion());
        oVentaTemp.setSubTotal(oVenta.getSubTotal());
        oVentaTemp.setMontoIgv(oVenta.getMontoIgv());
        oVentaTemp.setTotal(oVenta.getTotal());
        oVentaTemp.setEstado("ANU");
        oVentaTemp.setMotivoAnulacion(txfMotivoAnulacion.getText().trim().toUpperCase());
        oVentaTemp.setCaja(oVenta.getCaja());
        oVentaTemp.setNumOperacion(oVenta.getNumOperacion());
        oVentaTemp.setDescripcionSeguros(oVenta.getDescripcionSeguros().trim());
        oVentaTemp.setOrganizacion(oVenta.getOrganizacion());
        oVentaTemp.setUsuarioAnu(root.getUser());
        oVentaTemp.setTipoDocCliente(oVenta.getTipoDocCliente());
        oVentaTemp.setTotalValorVentaOpGravadas(oVenta.getTotalValorVentaOpGravadas());
        oVentaTemp.setTotalValorVentaOpeInafectas(oVenta.getTotalValorVentaOpeInafectas());
        oVentaTemp.setTotalValorVentaOpeExoneradas(oVenta.getTotalValorVentaOpeExoneradas());
        oVentaTemp.setTotalSumatoriaIgv(oVenta.getMontoIgv());
        oVentaTemp.setTotalSumatoriaIsc(oVenta.getTotalSumatoriaIsc());
        oVentaTemp.setTotalSumatoriaOtrosTributos(oVenta.getTotalSumatoriaOtrosTributos());
        oVentaTemp.setTotalSumatoriaOtrosCargos(oVenta.getTotalSumatoriaOtrosCargos());
        oVentaTemp.setTotalSumatoriaDescuentos(oVenta.getTotalSumatoriaDescuentos());
        oVentaTemp.setTotalImporteVenta(oVenta.getTotalImporteVenta());
        oVentaTemp.setTipoMoneda(oVenta.getTipoMoneda().trim());
        oVentaTemp.setTotalOpeGratuitas(oVenta.getTotalOpeGratuitas());

        //Buscar detalles de la venta seleccionada para el retorno de las cantidades a farmacia
        oDetalleVentaBl = new DetalleVentaBl();
        listDetalleVenta = oDetalleVentaBl.listarDetallesxidVenta(oVenta.getIdventa());

        return oVentaBl.actualizar(oVentaTemp, listDetalleVenta);
    }

    private Kardex registrarKardex() {
        oKardex = new Kardex();
        oKardexBl = new KardexBl();

        oKardex.setAlmacenByIdDestino((Almacen) cbxAlmacen.getSelectedItem()); //destino  es farmacia
        oKardex.setIdAlmacenAfectado(((Almacen) cbxAlmacen.getSelectedItem()).getIdalmacen()); // afectado es farmacia
        oKardex.setTipoOperacion("ENTRADA");
        oKardex.setOperacion("DEVOLUCION");
        oKardex.setFechaMov(new Date());
        oKardex.setHoraMov(Utilitarios.horaActual());
        oKardex.setComprobante("");
        oKardex.setNumSerie("");
        oKardex.setNumComprobante(0);
        oKardex.setOrigen("");
        oKardex.setDestino("");
        oKardex.setObservacion("");

        return oKardexBl.registrar(oKardex);
    }

    public void inicializar() {
        txfNumComprobante.setText("");
        buttonGroup1.clearSelection();
        txfMotivoAnulacion.setText("");
        oModeloComprobanteVenta.clear();
        cargarCbxAlmacen();
    }

    private void cargarCbxAlmacen() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.rellenaAlmacen(cbxAlmacen);
        oAlmacenCtrl.defaultSelectAlmacen("farmacia", cbxAlmacen);
    }
    /*
     private void registrarDetalleKardex(Kardex oKardex, List<DetalleVenta> listDetalleVenta) {
     for (int i = 0; i < listDetalleVenta.size(); i++) {
     oDetalleKardex = new DetalleKardex();
     oDetalleKardexBl = new DetalleKardexBl();
     oDetalleVenta = listDetalleVenta.get(i);

     oDetalleKardex.setKardex(oKardex);
     oDetalleKardex.setProducto(oDetalleVenta.getProducto());
     oDetalleKardex.setCantidad(oDetalleVenta.getCantidadVenta());
     //Buscar Stock anterior
     long stockAnt = stockAnterior(oDetalleVenta.getProducto().getIdproducto(), ((Almacen) cbxAlmacen.getSelectedItem()).getIdalmacen());

     oDetalleKardex.setStockAntOrig(Integer.parseInt(stockAnt + ""));
     oDetalleKardex.setStockActOrig(Integer.parseInt((stockAnt + oDetalleKardex.getCantidad()) + ""));
     oDetalleKardex.setStockAnt(Integer.parseInt(stockAnt + ""));
     oDetalleKardex.setStockActual(Integer.parseInt((stockAnt + oDetalleKardex.getCantidad()) + ""));
     int num = oDetalleKardexBl.maxNumMov();
     oDetalleKardex.setNumeroMovimiento(num + 1);
     //

     oDetalleKardexBl.registrar(oDetalleKardex);
     }
     }
     */

    private long stockAnterior(int idproducto, int idalmacen) {
        oAlmacenProductoBl = new AlmacenProductoBl();
        return oAlmacenProductoBl.buscar(idproducto, idalmacen);
    }

    private int actualizarAlmacenStock(List<DetalleVenta> listDetalleVenta) {
        int res = -1;
        for (int i = 0; i < listDetalleVenta.size(); i++) {
            oDetalleVenta = listDetalleVenta.get(i);
            actualizarAlamcenProducto();
            actualizarKardex();

            res = 0;
        }
        return res;
    }

    private void actualizarAlamcenProducto() {
        int res = -1;
        oAlmacenProducto = new AlmacenProducto();
        oAlmacenProductoBl = new AlmacenProductoBl();
        //oAlmacenProducto = buscarAlmacenProductoXlote(oDetalleVenta.getLote(), (Almacen) cbxAlmacen.getSelectedItem(), oDetalleVenta.getProducto());
        oAlmacenProducto = oAlmacenProductoBl.buscarxIdalmacenproducto(oDetalleVenta.getIdAlmacenproducto());
        if (oAlmacenProducto != null) {
            oAlmacenProducto.setStockActual(oAlmacenProducto.getStockActual().add(oDetalleVenta.getCantidadVenta()));
            res = oAlmacenProductoBl.actualizar(oAlmacenProducto);
        }
    }

    private void actualizarKardex() {
        oKardex = new Kardex();
        oKardexBl = new KardexBl();

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
        oAlmacenProductoBl = new AlmacenProductoBl();
        oAlmacenProducto = oAlmacenProductoBl.buscarxAlmacen(oKardex.getIdAlmacenproducto(), oKardex.getIdAlmacenAfectado());
        if (oAlmacenProducto != null) {
            oKardex.setStockActual(oAlmacenProducto.getStockActual());
        }

        oKardexBl.registrar(oKardex);
    }

    private AlmacenProducto buscarAlmacenProductoXlote(String lote, Almacen oAlmacen, Producto oProducto) {
        oAlmacenProductoBl = new AlmacenProductoBl();
        return oAlmacenProductoBl.buscarProductoxAlmacenyLote(lote, oAlmacen, oProducto);
    }

}
