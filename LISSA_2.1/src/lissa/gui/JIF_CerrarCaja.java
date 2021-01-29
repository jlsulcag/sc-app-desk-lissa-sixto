package lissa.gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import lissa.be.Caja;
import lissa.be.Comprobante;
import lissa.be.Persona;
import lissa.be.Rol;
import lissa.be.Usuario;
import lissa.bl.ComprobanteBl;
import lissa.bl.CajaBl;
import lissa.ds.DSConeccion;
import lissa.reportes.ReportGeneric;
import lissa.table.ModeloCaja;
import lissa.util.Utilitarios;

public class JIF_CerrarCaja extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloCaja modeloCaja;
    private ArrayList<Caja> listCajas;
    private CajaBl cajaBl;
    private Caja oCaja;
    private ComprobanteBl oComprobanteBl = null;
    Calendar calendar = Calendar.getInstance();//Variable de Objeto Calendar
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

    //
    public JIF_AtencionFondoPrev jifAtencionFondoPrev;
    
    private Usuario userTemp;
    private Persona perTemp;
    private Rol rolTemp;

    public JIF_CerrarCaja(JF_Principal root) {
        initComponents();
        this.root = root;
        modeloCaja = new ModeloCaja();
        tblCajas.setModel(modeloCaja);        
        jifAtencionFondoPrev = new JIF_AtencionFondoPrev(this.root);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jdcFechaCierre = new com.toedter.calendar.JDateChooser();
        jsHoraCierre = new javax.swing.JSpinner();
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
        jLabel11 = new javax.swing.JLabel();
        txfTotalBoleta = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txfTotalFactura = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txfTotalRecibo = new javax.swing.JTextField();
        lblMensaje = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("APERTURA DE CAJA");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Total Boletas :");

        txfTotalBoleta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txfTotalBoleta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfTotalBoleta.setEnabled(false);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Total Facturas :");

        txfTotalFactura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txfTotalFactura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfTotalFactura.setEnabled(false);
        txfTotalFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTotalFacturaActionPerformed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Total Otros :");

        txfTotalRecibo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txfTotalRecibo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfTotalRecibo.setEnabled(false);
        txfTotalRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTotalReciboActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrarCaja)
                .addContainerGap())
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
                                .addComponent(jdcFechaCierre, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jsHoraCierre, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfObservaciones)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txfDescuadre, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(txfSaldoContabilizado)
                                    .addComponent(txfSaldoFinal)
                                    .addComponent(txfTotalRecibo)
                                    .addComponent(txfTotalFactura)
                                    .addComponent(txfSaldoInicial)
                                    .addComponent(txfTotalBoleta))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jsHoraCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jdcFechaCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txfSaldoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txfTotalBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txfTotalFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfTotalRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txfSaldoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txfSaldoContabilizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txfDescuadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txfObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrarCaja)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jToolBar1.setRollover(true);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Refresh.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfSaldoContabilizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfSaldoContabilizadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfSaldoContabilizadoActionPerformed

    private void txfDescuadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfDescuadreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfDescuadreActionPerformed

    private void tblCajasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCajasMouseReleased
        if (tblCajas.getRowSelectionAllowed()) {
            obtenerDatosCaja();
        }
    }//GEN-LAST:event_tblCajasMouseReleased

    private void btnCerrarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCajaActionPerformed
        if (tblCajas.getSelectedRow() != -1) {
            cerrarCaja();
            personalizaTabla();
            resetComponents();
            listarCajas();
        } else {

        }
    }//GEN-LAST:event_btnCerrarCajaActionPerformed

    private void txfTotalFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTotalFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTotalFacturaActionPerformed

    private void txfTotalReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTotalReciboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTotalReciboActionPerformed

    private void txfSaldoContabilizadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfSaldoContabilizadoKeyReleased
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            calcularDescuadre();
        }
    }//GEN-LAST:event_txfSaldoContabilizadoKeyReleased

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        resetComponents();
        listarCajas();
        inicioHora();
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tblCajas.getSelectedRow() != -1 && oCaja != null) {
            generarReporte();
        } else {
            JOptionPane.showConfirmDialog(null, "Error en arqueo. Consulte con su administrador de sistema", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        listarCajas();
        personalizaTabla();
        inicioHora();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarCaja;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private com.toedter.calendar.JDateChooser jdcFechaCierre;
    private javax.swing.JSpinner jsHoraCierre;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTable tblCajas;
    private javax.swing.JTextField txfDescuadre;
    private javax.swing.JTextField txfObservaciones;
    private javax.swing.JTextField txfSaldoContabilizado;
    private javax.swing.JTextField txfSaldoFinal;
    private javax.swing.JTextField txfSaldoInicial;
    private javax.swing.JTextField txfTotalBoleta;
    private javax.swing.JTextField txfTotalFactura;
    private javax.swing.JTextField txfTotalRecibo;
    // End of variables declaration//GEN-END:variables

    public void listarCajas() {
        cajaBl = new CajaBl();
        modeloCaja.clear();
        String caja;
        if (rolTemp.getDenominacion().trim().equals("FARMACIA")) {
            caja = "CAJA 02 - FARMACIA";
            listCajas = cajaBl.listarxUsuario(userTemp, caja);
        } else{
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
        calcularTotalRecibo(oCaja);
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

    private void cerrarCaja() {
        cajaBl = new CajaBl();
        obtenerDatosCaja();
        if (oCaja.getEstado().trim().equals("ABIERTO")) {
            oCaja.setFechaCierre(jdcFechaCierre.getDate());
            SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
            oCaja.setHoraCierre(hour.format(jsHoraCierre.getValue()));
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

    private void inicioHora() {
        Calendar calendar = Calendar.getInstance();//Variable de Objeto Calendar  
        //fecha de sistema
        jdcFechaCierre.setCalendar(calendar);
        Date inicio = calendar.getTime();
        //Indicamos año hasta -100 del actual
        calendar.add(Calendar.YEAR, -100);
        //Guardamos la configuración en un DATE
        Date fechaAnterior = calendar.getTime();
        //Indicamos año hasta +200 del actual
        calendar.add(Calendar.YEAR, 200);
        //Guardamos la configuración en un DATE
        Date fechaPosterior = calendar.getTime();
        //Usamos el contructor de abajo para crear un modelo para el Spinner
        //SpinnerDateModel(Date value, Comparable start, Comparable end, int calendarField)
        //Utilizamos los datos que creamos más arriba
        //Para fecha utilizamos Calendar.YEAR y para hora Calendar.HOUR, el resto puede ser igual
        SpinnerModel fechaModel = new SpinnerDateModel(inicio, fechaAnterior, fechaPosterior, Calendar.YEAR);
        SpinnerModel horaModel = new SpinnerDateModel(inicio, fechaAnterior, fechaPosterior, Calendar.HOUR);
        //Indicamos el model para cada Spinner además del formato de fecha y hora según corresponda.
//        fecha.setModel(fechaModel);
//        fecha.setEditor(new JSpinner.DateEditor(fecha, "dd/MM/yyyy"));
        jsHoraCierre.setModel(horaModel);
        jsHoraCierre.setEditor(new JSpinner.DateEditor(jsHoraCierre, "HH:mm:ss"));
    }

    private void resetComponents() {
        modeloCaja.clear();
        jdcFechaCierre.setDate(new Date());
        jsHoraCierre.setValue(new Date());
        txfSaldoInicial.setText("");
        txfTotalBoleta.setText("");
        txfTotalFactura.setText("");
        txfTotalRecibo.setText("");
        txfSaldoFinal.setText("");
        txfSaldoContabilizado.setText("");
        txfDescuadre.setText("");
        txfObservaciones.setText("");
    }

    private void calcularTotalRecibo(Caja oCaja) {
        oComprobanteBl = new ComprobanteBl();
        totalRecibo = oComprobanteBl.calcuatTotalRecibo(oCaja);
        txfTotalRecibo.setText(totalRecibo.toString());
    }

    private void calcularTotalBoleta(Caja oCaja) {
        oComprobanteBl = new ComprobanteBl();
        totalBoleta = oComprobanteBl.calcularTotalBoleta(oCaja);
        txfTotalBoleta.setText(totalBoleta.toString());
    }

    private void calcularTotalFactura(Caja oCaja) {
        oComprobanteBl = new ComprobanteBl();
        totalFactura = oComprobanteBl.calcularTotalFactura(oCaja);
        txfTotalFactura.setText(totalFactura.toString());
    }

    private void calcularTotalFinal() {
        totalFinal = totalBoleta.add(totalFactura).add(totalRecibo);
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

    private void generarReporte() {
        try {
            ds = new DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport("ReportePorTurno", new String[]{"ID_CAJA"}, new Object[]{oCaja.getIdcaja()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Reporte por turno");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
        } catch (Exception ex) {
            Logger.getLogger(JIF_CerrarCaja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inicializar() {
        listarCajas();
        personalizaTabla();
        inicioHora();
    }

    public void cargarDatosUser(Usuario user, Persona oPersona, Rol oRol) {
        userTemp = user;
        perTemp = oPersona;
        rolTemp = oRol;
    }
    
    private void personalizaTabla() {
        Utilitarios.formateaColumna(0, tblCajas, 80);
        Utilitarios.formateaColumna(1, tblCajas, 150);
        Utilitarios.formateaColumna(2, tblCajas, 120);
        Utilitarios.formateaColumna(4, tblCajas, 100);
    }
}
