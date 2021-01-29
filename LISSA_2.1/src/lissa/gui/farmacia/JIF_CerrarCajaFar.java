package lissa.gui.farmacia;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lissa.be.Caja;
import lissa.be.Persona;
import lissa.be.Rol;
import lissa.be.Usuario;
import lissa.bl.CajaBl;
import lissa.bl.ComprobanteBl;
import lissa.bl.VentaBl;
import lissa.ds.DSConeccion;
import lissa.gui.JF_Principal;
import lissa.gui.JIF_AtencionFondoPrev;
import lissa.reportes.ReportGeneric;
import lissa.table.ModeloCaja;
import lissa.util.Utilitarios;

public class JIF_CerrarCajaFar extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloCaja modeloCaja;
    private ArrayList<Caja> listCajas;
    private CajaBl cajaBl;
    private Caja oCaja;

    private ComprobanteBl oComprobanteBl = null;
    private VentaBl oVentaBl = null;
    Calendar calendar = Calendar.getInstance();
    //Variable de Objeto Calendar
    BigDecimal totalFactura = new BigDecimal("0.00");
    BigDecimal totalBoleta = new BigDecimal("0.00");
    BigDecimal totalRecibo = new BigDecimal("0.00");
    BigDecimal totalFinal = new BigDecimal("0.00");
    BigDecimal totalDescuadre = new BigDecimal("0.00");
    BigDecimal totalContabilizado = new BigDecimal("0.00");

    //Variables para el reporte
    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;

    public JIF_AtencionFondoPrev jifAtencionFondoPrev;

    private Usuario userTemp;
    private Persona perTemp;
    private Rol rolTemp;
    private String ParamTemp;

    public JIF_CerrarCajaFar(JF_Principal root) {
        initComponents();
        this.root = root;
        modeloCaja = new ModeloCaja();
        tblCajas.setModel(modeloCaja);
        jifAtencionFondoPrev = new JIF_AtencionFondoPrev(this.root);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jToolBar2 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jdcFechaCierre = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCajas = new javax.swing.JTable();
        txfSaldoInicial = new javax.swing.JTextField();
        txfSaldoFinal = new javax.swing.JTextField();
        txfSaldoContabilizado = new javax.swing.JTextField();
        txfObservaciones = new javax.swing.JTextField();
        btnCerrarCaja = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txfDescuadre = new javax.swing.JTextField();
        lblMensaje = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jToolBar3 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();

        jToolBar1.setRollover(true);

        jToolBar2.setRollover(true);

        setClosable(true);
        setTitle("Cierre de Caja");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Saldo Inicial :");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Total Final :");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Total Contabilizado :");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Fecha Cierre :");

        jdcFechaCierre.setEnabled(false);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Observaciones :");

        tblCajas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCajas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblCajasMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblCajas);

        txfSaldoInicial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txfSaldoInicial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfSaldoInicial.setEnabled(false);

        txfSaldoFinal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txfSaldoFinal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfSaldoFinal.setEnabled(false);

        txfSaldoContabilizado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txfSaldoContabilizado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfSaldoContabilizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfSaldoContabilizadoActionPerformed(evt);
            }
        });
        txfSaldoContabilizado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfSaldoContabilizadoKeyReleased(evt);
            }
        });

        btnCerrarCaja.setText("Cerrar Caja");
        btnCerrarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCajaActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Descuadre :");

        txfDescuadre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txfDescuadre.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfDescuadre.setEnabled(false);
        txfDescuadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfDescuadreActionPerformed(evt);
            }
        });

        lblMensaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButton1.setText("Arqueo de Caja");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txfDescuadre, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(txfSaldoContabilizado)
                                            .addComponent(txfSaldoFinal)
                                            .addComponent(txfSaldoInicial))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jdcFechaCierre, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfObservaciones)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCerrarCaja))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jdcFechaCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfSaldoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txfSaldoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txfSaldoContabilizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txfDescuadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txfObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrarCaja)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jToolBar3.setRollover(true);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Refresh.png"))); // NOI18N
        jButton3.setToolTipText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(341, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        listarCajas();
        personalizaTabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tblCajas.getSelectedRow() != -1 && oCaja != null) {
            generarReporte();
        } else {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txfDescuadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfDescuadreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfDescuadreActionPerformed

    private void btnCerrarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCajaActionPerformed
        if (tblCajas.getSelectedRow() != -1) {
            cerrarCaja();
            resetComponents();
            listarCajas();
            personalizaTabla();
        } else {

        }
    }//GEN-LAST:event_btnCerrarCajaActionPerformed

    private void txfSaldoContabilizadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfSaldoContabilizadoKeyReleased
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            calcularDescuadre();
        }
    }//GEN-LAST:event_txfSaldoContabilizadoKeyReleased

    private void txfSaldoContabilizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfSaldoContabilizadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfSaldoContabilizadoActionPerformed

    private void tblCajasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCajasMouseReleased
        if (tblCajas.getRowSelectionAllowed()) {
            obtenerDatosCaja();
        }
    }//GEN-LAST:event_tblCajasMouseReleased

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        resetComponents();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarCaja;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private com.toedter.calendar.JDateChooser jdcFechaCierre;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTable tblCajas;
    private javax.swing.JTextField txfDescuadre;
    private javax.swing.JTextField txfObservaciones;
    private javax.swing.JTextField txfSaldoContabilizado;
    private javax.swing.JTextField txfSaldoFinal;
    private javax.swing.JTextField txfSaldoInicial;
    // End of variables declaration//GEN-END:variables

    private void listarCajas() {
        cajaBl = new CajaBl();
        modeloCaja.clear();
        String caja;
        if (rolTemp.getDenominacion().trim().equals("FARMACIA")) {
            caja = "CAJA 02 - FARMACIA";
            listCajas = cajaBl.listarxUsuario(userTemp, caja);
        } else {
            caja = "CAJA 01 - CLINICA";
            listCajas = cajaBl.listarxUsuario(userTemp, caja);
        }
        if (!listCajas.isEmpty()) {
            modeloCaja.addAll(listCajas);
        }
    }

    private void obtenerDatosCaja() {
        oCaja = new Caja();
        oCaja = modeloCaja.get(tblCajas.getSelectedRow());
        //OBTENER FECHA Y HORA DE CIERRE
        txfSaldoInicial.setText(oCaja.getSaldoInicial().toString());
//        calcularTotalRecibo(oCaja);
        calcularTotalBoleta(oCaja);
        calcularTotalFactura(oCaja);
        calcularTotalFinal();
        if (oCaja.getEstado().trim().equals("CERRADO")) {
            txfSaldoContabilizado.setText(oCaja.getSaldoContabilizado().toString());
            txfDescuadre.setText(oCaja.getDescuadre().toString());
        } else if (oCaja.getEstado().trim().equals("ABIERTO")) {
            txfSaldoContabilizado.setText("");
            txfDescuadre.setText("");
            lblMensaje.setText("");
        } else {
            resetComponents();
        }
    }

    private void resetComponents() {
        modeloCaja.clear();
        jdcFechaCierre.setDate(new Date());
        txfSaldoInicial.setText("");
        txfSaldoFinal.setText("");
        txfSaldoContabilizado.setText("");
        txfDescuadre.setText("");
        txfObservaciones.setText("");
    }

    private void calcularTotalBoleta(Caja oCaja) {
        oVentaBl = new VentaBl();
        totalBoleta = oVentaBl.calcularTotalBoleta(oCaja);
    }

    private void calcularTotalFactura(Caja oCaja) {
        oVentaBl = new VentaBl();
        totalFactura = oVentaBl.calcularTotalFactura(oCaja);
    }

    private void calcularTotalFinal() {
        totalFinal = totalBoleta.add(totalFactura);
        txfSaldoFinal.setText(totalFinal.toString());
    }

    private void calcularDescuadre() {
        if (!txfSaldoContabilizado.getText().trim().equals("")) {
            totalContabilizado = new BigDecimal(txfSaldoContabilizado.getText().trim());
            totalDescuadre = totalFinal.subtract(totalContabilizado);
            txfDescuadre.setText(totalDescuadre.toString());
        }
        mostrarMensajeDescuadre();
    }

    private void mostrarMensajeDescuadre() {
        if (totalDescuadre.signum() == -1) {
            lblMensaje.setText("SOBRANTE");
            lblMensaje.setForeground(Color.BLUE);
        } else if (totalDescuadre.signum() == 0) {
            lblMensaje.setText("");
            //lblMensaje.setForeground(Color.BLUE);
        } else if (totalDescuadre.signum() == 1) {
            lblMensaje.setText("FALTANTE");
            lblMensaje.setForeground(Color.RED);
        }
    }

    private void cerrarCaja() {
        cajaBl = new CajaBl();
        obtenerDatosCaja();
        if (oCaja.getEstado().trim().equals("ABIERTO")) {
            oCaja.setFechaCierre(jdcFechaCierre.getDate());
            oCaja.setHoraCierre(Utilitarios.horaActual());
            oCaja.setEstado("CERRADO");
            oCaja.setSaldoFinal(totalFinal);
            oCaja.setSaldoContabilizado(totalContabilizado);
            oCaja.setDescuadre(totalDescuadre);
            if (cajaBl.actualizar(oCaja) != 0) {
                JOptionPane.showMessageDialog(null, "La Caja se cerró correctamente", "Atención", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error durante el cierre de caja", "Atención", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "La caja seleccionada ya está cerrada", "Atención", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inicializar() {
        listarCajas();
        personalizaTabla();
    }

    public void cargarDatosUser(Usuario user, Persona oPersona, Rol oRol) {
        userTemp = user;
        perTemp = oPersona;
        rolTemp = oRol;
    }

    private void generarReporte() {
        try {
            ds = new DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport("FarReportePorTurno", new String[]{"ID_CAJA"}, new Object[]{oCaja.getIdcaja()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Reporte por turno");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.setMaximizable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
        } catch (Exception ex) {
            Logger.getLogger(JIF_CerrarCajaFar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void personalizaTabla() {
        Utilitarios.formateaColumna(0, tblCajas, 80);
        Utilitarios.formateaColumna(1, tblCajas, 150);
        Utilitarios.formateaColumna(2, tblCajas, 120);
        Utilitarios.formateaColumna(4, tblCajas, 100);
    }

}
