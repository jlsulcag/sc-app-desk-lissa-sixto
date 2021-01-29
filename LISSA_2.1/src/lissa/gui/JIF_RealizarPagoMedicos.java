package lissa.gui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lissa.be.Caja;
import lissa.be.Egreso;
import lissa.be.EgresoDetalle;
import lissa.be.Medico;
import lissa.be.MedicoDerivaAtiende;
import lissa.be.Usuario;
import lissa.bl.CajaBl;
import lissa.bl.EgresoBl;
import lissa.bl.EgresoDetalleBl;
import lissa.bl.MedicoDerivaAtiendeBl;
import lissa.controller.MedicoCtrl;
import lissa.ds.DSConeccion;
import lissa.render.TCellEditor;
import lissa.reportes.ReportGeneric;
import lissa.table.ModeloPagoMedicos;
import lissa.util.Mensajes;
import org.rx.cr.util.Utilitarios;

public class JIF_RealizarPagoMedicos extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private Usuario oUsuario;
    private ModeloPagoMedicos oModeloPagoMedicos;
    private List<MedicoDerivaAtiende> listPagoMedicos;
    private List<MedicoDerivaAtiende> listPagoMedicosTemp;
    private MedicoDerivaAtiendeBl oMedicoDerivaAtiendeBl;
    private MedicoDerivaAtiende oMedicoDerivaAtiende;
    private MedicoDerivaAtiende oMedicoDerivaAtiendeTemp;
    private Caja oCaja;
    private CajaBl oCajaBl;
    private BigDecimal montoPagar;
    private MedicoCtrl oMedicoCtrl;
    private Egreso oEgreso;
    private EgresoBl oEgresoBl;
    private EgresoDetalle oEgresoDetalle;
    private EgresoDetalleBl oEgresoDetalleBl;
    private Medico oMedico;
    public static final int SUCESS = 1, ERROR = -1;
    //Variables para el reporte
    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;

    public JIF_RealizarPagoMedicos(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloPagoMedicos = new ModeloPagoMedicos();
        tblAtenciones.setModel(oModeloPagoMedicos);
        listPagoMedicos = new LinkedList<>();
        listPagoMedicosTemp = new LinkedList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jdcFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jdcFechaFin = new com.toedter.calendar.JDateChooser();
        btnProcesar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txfMedico = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAtenciones = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txfMontoPagar = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Pago a Médicos");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));

        jLabel1.setText("Inicio :");

        jLabel2.setText("Fecha Fin :");

        btnProcesar.setText("Procesar");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Medico :");

        txfMedico.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProcesar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcesar)
                    .addComponent(jButton1)
                    .addComponent(jLabel4)
                    .addComponent(txfMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Atenciones"));

        tblAtenciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAtenciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAtencionesMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblAtencionesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblAtenciones);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );

        jButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton3.setText("Procesar Pago");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Monto a Pagar :");

        txfMontoPagar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txfMontoPagar.setForeground(new java.awt.Color(0, 153, 255));
        txfMontoPagar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfMontoPagar.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfMontoPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfMontoPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        resetTotal();
        listarComprobanteDetalle();
        tblAtenciones.getColumnModel().getColumn(10).setCellEditor(new TCellEditor(new JCheckBox()));
        personalizaVistaTabla();
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void tblAtencionesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAtencionesMouseReleased
        //obtenerDatos();
    }//GEN-LAST:event_tblAtencionesMouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        procesarPago();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblAtencionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAtencionesMouseClicked
        try {
            oMedicoDerivaAtiende = new MedicoDerivaAtiende();
            if (tblAtenciones.getColumnModel().getColumn(10).getCellEditor().getCellEditorValue().equals(true)) {
                oMedicoDerivaAtiende = oModeloPagoMedicos.get(Utilitarios.seleccionarFila(evt));
                if (oMedicoDerivaAtiende != null && oMedicoDerivaAtiende.getEstadoPago().equals("DEBE")) {
                    listPagoMedicosTemp.add(oMedicoDerivaAtiende);
                } else {
                    JOptionPane.showMessageDialog(null, "La atención se encuentra PAGADA", "Atención", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                oMedicoDerivaAtiende = oModeloPagoMedicos.get(Utilitarios.seleccionarFila(evt));
                if (oMedicoDerivaAtiende != null) {
                    listPagoMedicosTemp.remove(oMedicoDerivaAtiende);
                }
            }
            calcularTotalPagar(listPagoMedicosTemp);
        } catch (Exception e) {
            System.out.println("Error de seleccion :" + e);
        }
    }//GEN-LAST:event_tblAtencionesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscarMedico(JIF_BuscarMedico.REALIZAR_PAGO_MEDICOS);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcesar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFechaFin;
    private com.toedter.calendar.JDateChooser jdcFechaInicio;
    private javax.swing.JTable tblAtenciones;
    private javax.swing.JTextField txfMedico;
    private javax.swing.JTextField txfMontoPagar;
    // End of variables declaration//GEN-END:variables

    void resetComponents() {
        lissa.util.Utilitarios.fechaActual(jdcFechaInicio);
        lissa.util.Utilitarios.fechaActual(jdcFechaFin);
        personalizaVistaTabla();
        if (oMedicoDerivaAtiende != null) {
            oMedicoDerivaAtiende = null;
        }
        oModeloPagoMedicos.clear();
        //tblAtenciones.getColumnModel().getColumn(9).setCellEditor(new TCellEditor(new JCheckBox()));
    }

    void enviarDatos(Usuario user) {
        oUsuario = user;
        //resetComponents();
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaAnchoColumnaTabla(0, tblAtenciones, 60);
        Utilitarios.formateaAnchoColumnaTabla(1, tblAtenciones, 120);
        Utilitarios.formateaAnchoColumnaTabla(2, tblAtenciones, 80);
        Utilitarios.formateaAnchoColumnaTabla(4, tblAtenciones, 80);
        Utilitarios.formateaAnchoColumnaTabla(6, tblAtenciones, 110);
        Utilitarios.formateaAnchoColumnaTabla(7, tblAtenciones, 70);
        Utilitarios.formateaAnchoColumnaTabla(8, tblAtenciones, 100);
        Utilitarios.formateaAnchoColumnaTabla(9, tblAtenciones, 70);
        Utilitarios.formateaAnchoColumnaTabla(10, tblAtenciones, 20);

        Utilitarios.alinearDatosColumnaTablaDerecha(9, tblAtenciones);
    }

    private void listarComprobanteDetalle() {
        listPagoMedicos = new LinkedList();
        oMedicoDerivaAtiendeBl = new MedicoDerivaAtiendeBl();
        oModeloPagoMedicos.clear();
        if (isDatosValidosBusqueda()) {
            listPagoMedicos = oMedicoDerivaAtiendeBl.listarxRangoFechasYMedico(jdcFechaInicio.getDate(), jdcFechaFin.getDate(), oMedico.getIdMedico());
            for (MedicoDerivaAtiende obj : listPagoMedicos) {
                oModeloPagoMedicos.add(obj);
            }
        } else {
            Mensajes.msjValidarIngreso();
        }
    }

    private boolean isDatosValidosBusqueda() {
        return (jdcFechaInicio.getDate() != null
                && jdcFechaFin.getDate() != null
                && !txfMedico.getText().trim().equals(""));
    }

    void enviarCaja(Caja obj) {
        this.oCaja = obj;
    }

    private void calcularTotalPagar(List<MedicoDerivaAtiende> listPagoMedicos) {
        montoPagar = new BigDecimal("0.00");
        for (MedicoDerivaAtiende obj : listPagoMedicos) {
            montoPagar = montoPagar.add(obj.getMonto()).setScale(2, RoundingMode.HALF_UP);
        }
        txfMontoPagar.setText(montoPagar.toString());
    }

    private void resetTotal() {
        montoPagar = new BigDecimal("0.00");
        txfMontoPagar.setText(montoPagar.toString());
        listPagoMedicosTemp = new LinkedList<>();
    }

    private void procesarPago() {
        if (montoPagar.compareTo(new BigDecimal("0.00")) == 1 && !listPagoMedicosTemp.isEmpty()) {
            for (MedicoDerivaAtiende obj : listPagoMedicosTemp) {
                oMedicoDerivaAtiendeTemp = obj;
                oMedicoDerivaAtiendeTemp.setEstadoPago("PAGADO");
                oMedicoDerivaAtiendeTemp.setUsuariopago(oUsuario);
                oMedicoDerivaAtiendeBl.actualizar(obj);

            }
            //Registrar el egreso  con sus respectivos detalles
            registrarEgreso(listPagoMedicosTemp);
            btnProcesar.doClick();
        } else {
            JOptionPane.showMessageDialog(null, "No se puede realizar Pago", "Atención", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarEgreso(List<MedicoDerivaAtiende> listPagoMedicosTemp) {
        oCajaBl = new CajaBl();
        BigDecimal montoTotal = new BigDecimal("0.00");
        oEgreso = new Egreso();
        oEgreso.setNumero(obtenerNumero());
        oEgreso.setFecha(new Date());
        oEgreso.setMotivo("PAGO A MEDICO");
        oEgreso.setMotivoOtros("");
        oEgreso.setTipoComprobante("");
        oEgreso.setNroComprobante("");
        for (MedicoDerivaAtiende obj : listPagoMedicosTemp) {
            montoTotal = montoTotal.add(obj.getMonto());

        }
        oEgreso.setMonto(montoTotal);
        oEgreso.setObservacion("");
        oEgreso.setIdUsuario(oUsuario.getIdUsuario());
        oCaja = oCajaBl.buscarPorIdusuario(oUsuario);
        if (oCaja != null) {
            oEgreso.setIdCajaafecto(Long.parseLong(oCaja.getIdcaja() + ""));
        }
        oEgreso.setEstado(1);
        oEgreso = oEgresoBl.registrar(oEgreso);
        if (oEgreso != null) {
            if (registrarEgresoDetalle(oEgreso, listPagoMedicosTemp) == 1) {
                Mensajes.msjRegCorrecta();
                //Imprimir comprobante de egreso pago a medicos
                imprimirConstancia(oEgreso);
            } else {
                Mensajes.msjRegError();
            }
        } else {
            Mensajes.msjRegError();
        }
    }

    private long obtenerNumero() {
        oEgresoBl = new EgresoBl();
        return oEgresoBl.numeroSig();
    }

    private int registrarEgresoDetalle(Egreso oEgreso, List<MedicoDerivaAtiende> listPagoMedicosTemp) {
        oEgresoDetalleBl = new EgresoDetalleBl();
        for (MedicoDerivaAtiende obj : listPagoMedicosTemp) {
            oEgresoDetalle = new EgresoDetalle();
            oEgresoDetalle.setEgreso(oEgreso);
            oEgresoDetalle.setDescripcion("PAGO A MEDICO");
            oEgresoDetalle.setCantidad(0);
            oEgresoDetalle.setMonto(obj.getMonto());
            oEgresoDetalle.setMedicoDerivaAtiende(obj);
            oEgresoDetalleBl.registrar(oEgresoDetalle);
        }
        return SUCESS;
    }

    private void imprimirConstancia(Egreso oEgreso) {
        try {
            ds = new DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport("PagoMedicos", new String[]{"ID_EGRESO"}, new Object[]{oEgreso.getIdegreso()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Reporte");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.setResizable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
        } catch (Exception ex) {
            Logger.getLogger(JIF_RealizarPagoMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void buscarMedico(int REALIZAR_PAGO_MEDICOS) {
        root.jifBuscarMedico.setInvocador(REALIZAR_PAGO_MEDICOS);
        try {
            root.insertarInternalFrames(root.jifBuscarMedico);
            root.jifBuscarMedico.inicializar();
        } catch (Exception e) {
            Mensajes.ErrorGenerico(e);
        }
    }

    void cargarDatosMedico(Medico beanTabla) {
        oMedico = new Medico();
        oMedico = beanTabla;
        txfMedico.setText(oMedico.getPersona().getNombre().trim()+" "+oMedico.getPersona().getApellidoPaterno().trim()+" "+oMedico.getPersona().getApellidoMaterno().trim());
    }
}
