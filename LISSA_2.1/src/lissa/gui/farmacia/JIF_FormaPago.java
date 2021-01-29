package lissa.gui.farmacia;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lissa.be.Beneficio;
import lissa.be.Cuentaxcobrar;
import lissa.be.FarFormaPago;
import lissa.be.FondoSolidaridad;
import lissa.be.HistorialAtencionFps;
import lissa.be.PaqueteFondoDetalle;
import lissa.be.PaqueteFondoSolidaridad;
import lissa.be.Persona;
import lissa.be.PersonaJuridica;
import lissa.be.SeguroVida;
import lissa.be.ServiciosFondoSolidaridad;
import lissa.be.Venta;
import lissa.bl.FondoPrevisionBl;
import lissa.bl.HistorialAtencionBl;
import lissa.bl.PaqueteFondoDetalleBl;
import lissa.bl.PersonaJuridicaBl;
import lissa.bl.ServicioFSBl;
import lissa.controller.BeneficioCtrl;
import lissa.controller.FarFormaPagoCtrl;
import lissa.controller.PaqueteFSCtrl;
import lissa.controller.PaqueteFondoDetalleCtrl;
import lissa.controller.SeguroCtrl;
import lissa.gui.JF_Principal;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_FormaPago extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private PersonaJuridica oPersonaJuridica;
    private PersonaJuridicaBl oPersonaJuridicaBl;
    private FarFormaPagoCtrl oFarFormaPagoCtrl;
    private SeguroCtrl oSeguroCtrl;
    private BeneficioCtrl oBeneficioCtrl;
    private Persona oPersona;
    private Venta oVenta;
    private BigDecimal total = BigDecimal.ZERO;
    private BigDecimal descuento = BigDecimal.ZERO;
    private BigDecimal totaldesc = BigDecimal.ZERO;
    private BigDecimal copago = BigDecimal.ZERO;
    private BigDecimal cuentasxcobrar = BigDecimal.ZERO;
    private BigDecimal montoFps = BigDecimal.ZERO;
    private double porDesc = 0;
    private double porCopago = 0;
    private BigDecimal totalAPagar = BigDecimal.ZERO;
    private BigDecimal totalDescuento = BigDecimal.ZERO;//descuento + cuentas x cobrar
    private FondoSolidaridad oFondoSolidaridad;
    private FondoPrevisionBl oFondoSolidaridadBl;
    private Cuentaxcobrar oCuentaxcobrar;
    private BigDecimal montoPagado = BigDecimal.ZERO;
    private ServiciosFondoSolidaridad oServiciosFondoSolidaridad;
    private ServicioFSBl oServicioFSBl;
    private List<ServiciosFondoSolidaridad> listServiciosFs;
    private PaqueteFSCtrl oPaqueteFSCtrl;
    private PaqueteFondoDetalleCtrl oPaqueteFondoDetalleCtrl;
    private HistorialAtencionFps oHistorialAtencionFps;
    private HistorialAtencionBl oHistorialAtencionBl;
    private PaqueteFondoDetalle oPaqueteFondoDetalle;
    private PaqueteFondoDetalleBl oPaqueteFondoDetalleBl;

    public JIF_FormaPago(JF_Principal root) {
        initComponents();
        this.root = root;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbxModalidadPago = new javax.swing.JComboBox();
        cbxSeguro = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txfDescuento = new javax.swing.JTextField();
        txfCopago = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbxBeneficio = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblDescuento = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblDiferencia = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblCopago = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        lblCuentaxCobrar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txfFechaPago = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txfSaldoFPS = new javax.swing.JTextField();
        cbxPaquete = new javax.swing.JComboBox();
        cbxServicioFps = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnVerDetalles = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txfMontoFps = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        lblMontoFps = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblMontoaPagar = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

        setClosable(true);
        setTitle("Formas de pago");

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Forma de pago"));

        jLabel6.setText("Modalidad de pago :");

        cbxModalidadPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxModalidadPagoActionPerformed(evt);
            }
        });

        cbxSeguro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxSeguroItemStateChanged(evt);
            }
        });
        cbxSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSeguroActionPerformed(evt);
            }
        });

        jLabel11.setText("Descuento :");

        jLabel12.setText("Copago :");

        txfDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfDescuentoKeyReleased(evt);
            }
        });

        txfCopago.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfCopago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCopagoKeyReleased(evt);
            }
        });

        jLabel13.setText("Cuenta por cobrar :");

        jLabel14.setText("Seguro :");

        jLabel15.setText("Beneficio :");

        cbxBeneficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxBeneficioActionPerformed(evt);
            }
        });

        jLabel17.setText("%");

        jLabel18.setText("%");

        jLabel1.setText("Total ");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("S/.");

        lblDescuento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDescuento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDescuento.setText("0.00");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("S/.");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0.00");

        lblDiferencia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDiferencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDiferencia.setText("0.00");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("S/.");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("S/.");

        lblCopago.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCopago.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCopago.setText("0.00");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("S/.");

        lblCuentaxCobrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCuentaxCobrar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCuentaxCobrar.setText("0.00");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Fondo de previsión social"));

        jLabel9.setText("Fecha pago :");

        txfFechaPago.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfFechaPago.setEnabled(false);

        jLabel10.setText("Saldo S/.");

        txfSaldoFPS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfSaldoFPS.setEnabled(false);

        cbxPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPaqueteActionPerformed(evt);
            }
        });

        cbxServicioFps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxServicioFpsActionPerformed(evt);
            }
        });

        jLabel2.setText("Paquete :");

        jLabel3.setText("Servicio :");

        btnVerDetalles.setText("Ver");
        btnVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetallesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txfFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfSaldoFPS, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerDetalles)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbxPaquete, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxServicioFps, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txfFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txfSaldoFPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerDetalles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxServicioFps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(12, 12, 12))
        );

        jLabel26.setText("Monto cubierto FPS :");

        txfMontoFps.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfMontoFps.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfMontoFpsKeyReleased(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("S/.");

        lblMontoFps.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMontoFps.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMontoFps.setText("0.00");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 204));
        jLabel16.setText("Monto a pagar :");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 204));
        jLabel25.setText("S/.");

        lblMontoaPagar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMontoaPagar.setForeground(new java.awt.Color(0, 102, 204));
        lblMontoaPagar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMontoaPagar.setText("0.00");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxBeneficio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cbxModalidadPago, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbxSeguro, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txfDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel17))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel13)))
                            .addGap(9, 9, 9)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblDiferencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jSeparator1)))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addGap(18, 18, 18)
                            .addComponent(txfCopago, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblCopago, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblCuentaxCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(125, 125, 125)
                            .addComponent(jLabel25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblMontoaPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(txfMontoFps, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMontoFps, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxModalidadPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel21)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel11)
                    .addComponent(txfDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20)
                    .addComponent(lblDescuento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(cbxBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(lblDiferencia))))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txfCopago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel23)
                            .addComponent(lblCopago))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txfMontoFps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(lblMontoFps))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel24)
                            .addComponent(lblCuentaxCobrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel25)
                            .addComponent(lblMontoaPagar)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxSeguroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxSeguroItemStateChanged

    }//GEN-LAST:event_cbxSeguroItemStateChanged

    private void txfDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfDescuentoKeyReleased
        calcularDescuento();
    }//GEN-LAST:event_txfDescuentoKeyReleased

    private void txfCopagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCopagoKeyReleased
        calcularCopago();
    }//GEN-LAST:event_txfCopagoKeyReleased

    private void txfMontoFpsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfMontoFpsKeyReleased
        calcularMontoFps();
    }//GEN-LAST:event_txfMontoFpsKeyReleased

    private void cbxModalidadPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxModalidadPagoActionPerformed
        if (cbxModalidadPago.getSelectedIndex() > 0) {
            resetcomponents();
            configurarComponentes();
        }
    }//GEN-LAST:event_cbxModalidadPagoActionPerformed

    private void cbxBeneficioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxBeneficioActionPerformed
        if (cbxBeneficio.getSelectedIndex() > 0) {
            resetcomponents();
            configuraComponentes2();
            //cargaFPS si es que tiene y si es fondo de prevision
            if (cbxBeneficio.getSelectedItem().toString().equals("FONDO PREVISION")) {
                cargarFondoPs(oPersona);
            }

        }
    }//GEN-LAST:event_cbxBeneficioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cbxSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSeguroActionPerformed
        if (cbxSeguro.getSelectedIndex() > 0) {
            rellenaCbxBeneficio(((SeguroVida) cbxSeguro.getSelectedItem()).getIdSeguroVida());
        } else {
            cbxBeneficio.removeAllItems();
        }

    }//GEN-LAST:event_cbxSeguroActionPerformed

    private void cbxPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPaqueteActionPerformed
        if (cbxPaquete.getSelectedIndex() > 0) {
            //determina si esta activo o no
            determinarEstadoFps();
        }
    }//GEN-LAST:event_cbxPaqueteActionPerformed

    private void cbxServicioFpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxServicioFpsActionPerformed
        if (cbxServicioFps.getSelectedIndex() > 0) {
            try {
                buscarDatosUltimoRegistroFondo();
            } catch (Exception ex) {
                Logger.getLogger(JIF_FormaPago.class.getName()).log(Level.SEVERE, "Error", ex);
            }
        }
    }//GEN-LAST:event_cbxServicioFpsActionPerformed

    private void btnVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetallesActionPerformed
        verHistorial();
    }//GEN-LAST:event_btnVerDetallesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVerDetalles;
    private javax.swing.JComboBox cbxBeneficio;
    private javax.swing.JComboBox cbxModalidadPago;
    private javax.swing.JComboBox cbxPaquete;
    private javax.swing.JComboBox cbxSeguro;
    private javax.swing.JComboBox cbxServicioFps;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblCopago;
    private javax.swing.JLabel lblCuentaxCobrar;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblDiferencia;
    private javax.swing.JLabel lblMontoFps;
    private javax.swing.JLabel lblMontoaPagar;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextField txfCopago;
    private javax.swing.JTextField txfDescuento;
    private javax.swing.JTextField txfFechaPago;
    private javax.swing.JTextField txfMontoFps;
    private javax.swing.JTextField txfSaldoFPS;
    // End of variables declaration//GEN-END:variables
    public void inicializar() {
        cargarCbxFormaPago();
        cargarCbxSeguro();
        cargarCbxPaquete();
        resetcomponentsFull();
    }
    /*
     private void buscarPersonaJuridicaPorRuc() {
     oPersonaJuridica = new PersonaJuridica();
     oPersonaJuridicaBl = new PersonaJuridicaBl();

     oPersonaJuridica = oPersonaJuridicaBl.buscarxRuc(txfRuc.getText().trim());
     if (oPersonaJuridica != null && oPersonaJuridica.getIdPersonaJuridica() != 0) {
     txfRazonSocial.setText(oPersonaJuridica.getRazonSocial().trim());
     }
     }
     */

    private void cargarCbxFormaPago() {
        oFarFormaPagoCtrl = new FarFormaPagoCtrl(root);
        oFarFormaPagoCtrl.rellenaCbx(cbxModalidadPago);
        //oFarFormaPagoCtrl.defaultSelectValor("contado", cbxModalidadPago);
    }

    private void cargarCbxSeguro() {
        oSeguroCtrl = new SeguroCtrl(root);
        oSeguroCtrl.rellenaCbx(cbxSeguro);
    }

    private void rellenaCbxBeneficio(int idSeguroVida) {
        oBeneficioCtrl = new BeneficioCtrl(root);
        oBeneficioCtrl.rellenaCbx(cbxBeneficio, idSeguroVida);
    }

    void enviaDatos(String tot) {
        total = new BigDecimal(tot).setScale(2, RoundingMode.HALF_UP);
        lblTotal.setText(total.toString());
        totalDescuento = BigDecimal.ZERO;
    }

    private void calcularDescuento() {
        //Porcentaje de dscuento
        porDesc = !txfDescuento.getText().trim().equals("") ? Double.valueOf(txfDescuento.getText().trim()) / 100 : 0;
        //descuento = total*(%descuento)
        descuento = total.multiply(new BigDecimal(porDesc)).setScale(2, RoundingMode.HALF_UP);
        lblDescuento.setText(descuento.toString());
        totaldesc = total.subtract(descuento);//diferencia entre total y el monto del descuento
        lblDiferencia.setText(totaldesc.toString());
        //total a pagar
        totalAPagar = totaldesc;
        lblMontoaPagar.setText(totalAPagar.toString());
    }

    private void calcularCopago() {
        //Porcentaje de copago
        porCopago = !txfCopago.getText().trim().equals("") ? Double.valueOf(txfCopago.getText().trim()) / 100 : 0;
        //copago = diferencia*(%copago)
        copago = totaldesc.multiply(new BigDecimal(porCopago)).setScale(2, RoundingMode.HALF_UP);
        lblCopago.setText(copago.toString());
        cuentasxcobrar = totaldesc.subtract(copago).setScale(2, RoundingMode.HALF_UP);
        lblCuentaxCobrar.setText(cuentasxcobrar.toString());
        //total a pagar
        totalAPagar = copago;
        lblMontoaPagar.setText(totalAPagar.toString());
    }

    void enviaDatosPersona(Persona per) {
        if (per != null) {
            oPersona = per;
            //cargarFondoPs(oPersona);
        }

    }

    private void configurarComponentes() {
        switch (cbxModalidadPago.getSelectedItem().toString().trim()) {
            case "CONTADO":
                txfDescuento.setEnabled(false);
                txfCopago.setEnabled(false);
                txfMontoFps.setEnabled(false);
                cbxSeguro.setEnabled(false);
                cbxBeneficio.setEnabled(false);
                cbxPaquete.setEnabled(false);
                cbxServicioFps.setEnabled(false);
                cbxSeguro.setSelectedIndex(0);
                cbxBeneficio.removeAllItems();
                cbxPaquete.setSelectedIndex(0);
                cbxServicioFps.removeAllItems();
                calcularTotalaPagar();
                break;
            case "CREDITO":
                txfDescuento.setEnabled(false);
                txfCopago.setEnabled(false);
                txfMontoFps.setEnabled(false);
                cbxSeguro.setEnabled(false);
                cbxBeneficio.setEnabled(false);
                cbxPaquete.setEnabled(false);
                cbxServicioFps.setEnabled(false);
                cbxSeguro.setSelectedIndex(0);
                cbxBeneficio.removeAllItems();
                cbxPaquete.setSelectedIndex(0);
                cbxServicioFps.removeAllItems();
                calcularCredito();
                break;
            case "SEGURO":
                txfDescuento.setEnabled(true);
                txfCopago.setEnabled(true);
                txfMontoFps.setEnabled(true);
                cbxSeguro.setEnabled(true);
                cbxBeneficio.setEnabled(true);
                cbxSeguro.setSelectedIndex(0);
                cbxBeneficio.removeAllItems();
                cbxPaquete.setSelectedIndex(0);
                cbxServicioFps.removeAllItems();
                break;
        }
    }

    private void cargarFondoPs(Persona oPersona) {
        oFondoSolidaridadBl = new FondoPrevisionBl();
        if (oPersona != null) {
            oFondoSolidaridad = oFondoSolidaridadBl.obtenerUltimo(oPersona.getNumeroDocumento().trim());
            if (oFondoSolidaridad != null) {
                txfFechaPago.setText(Utilitarios.formatFecha(oFondoSolidaridad.getFechaReg()));
                //verifica si la fecha  de pago es despues  de la fecha especificada- actual
                if (oFondoSolidaridad.getFechaReg().after(new Date())) {
                    txfFechaPago.setBackground(Color.red);
                } else {
                    txfFechaPago.setBackground(Color.GREEN);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No tiene fondos registrados", "Error", JOptionPane.ERROR_MESSAGE);
                cbxBeneficio.setSelectedIndex(0);
                //this.doDefaultCloseAction();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cargue los datos de una Persona", "Error", JOptionPane.ERROR_MESSAGE);
            cbxBeneficio.setSelectedIndex(0);
            //this.doDefaultCloseAction();
        }

    }

    private void cargarFondops() {
        if (cbxBeneficio.getSelectedItem().toString().equals("FONDO PREVISION")) {
            cargarFondoPs(oPersona);//
        }
    }

    private Cuentaxcobrar agregarCuentasxcobrar() {
        oCuentaxcobrar = new Cuentaxcobrar();

        oCuentaxcobrar.setEstado("DEBE");
        oCuentaxcobrar.setFechaPago(new Date());
        oCuentaxcobrar.setMontoPagado(BigDecimal.ZERO);
        oCuentaxcobrar.setBeneficio(cbxBeneficio.getSelectedIndex() > 0 ? (Beneficio) cbxBeneficio.getSelectedItem() : null);
        oCuentaxcobrar.setFondoSolidaridad(oFondoSolidaridad != null ? oFondoSolidaridad : null);
        oCuentaxcobrar.setUsuario(this.root.getUser());
        oCuentaxcobrar.setTotal(total);
        oCuentaxcobrar.setPorcDesc(porDesc);
        oCuentaxcobrar.setMontoDesc(descuento);
        oCuentaxcobrar.setPorcCopago(porCopago);
        oCuentaxcobrar.setMontoCopago(copago);
        oCuentaxcobrar.setCuentaXCobrar(cuentasxcobrar);
        oCuentaxcobrar.setMontoPagofps(montoFps);
        oCuentaxcobrar.setMontoPagado(totalAPagar);
        return oCuentaxcobrar;

    }

    private void calcularMontoFps() {
        montoFps = (!txfMontoFps.getText().trim().equals("") ? (new BigDecimal(txfMontoFps.getText().trim()).setScale(2, RoundingMode.HALF_UP)) : BigDecimal.ZERO);
        lblMontoFps.setText(montoFps.toString());
        cuentasxcobrar = montoFps;
        lblCuentaxCobrar.setText(cuentasxcobrar.toString());
        //total a pagar por el cliente
        totalAPagar = total.subtract(montoFps).setScale(2, RoundingMode.HALF_UP);
        lblMontoaPagar.setText(totalAPagar.toString());

    }

    private void resetcomponentsFull() {
        cbxBeneficio.removeAllItems();
        cbxModalidadPago.setSelectedIndex(0);
        cbxSeguro.setSelectedIndex(0);
        txfFechaPago.setText("");
        txfFechaPago.setBackground(Color.WHITE);
        txfSaldoFPS.setText("");
        lblTotal.setText(total.toString());
        txfDescuento.setText("");
        lblDescuento.setText("0.00");
        lblDiferencia.setText("0.00");
        txfCopago.setText("");
        lblCopago.setText("0.00");
        txfMontoFps.setText("");
        lblMontoFps.setText("0.00");
        lblCuentaxCobrar.setText("0.00");
        lblMontoaPagar.setText("0.00");
        cbxServicioFps.removeAllItems();
        oPersona = null;
    }

    private void calcularTotalaPagar() {
        totalAPagar = total;
        lblMontoaPagar.setText(totalAPagar.toString());
    }

    private void calcularCredito() {
        cuentasxcobrar = total;
        lblCuentaxCobrar.setText(cuentasxcobrar.toString());
        //total a pagar
        totalAPagar = BigDecimal.ZERO;
        lblMontoaPagar.setText(totalAPagar.setScale(2, RoundingMode.HALF_UP).toString());
    }

    private void configuraComponentes2() {
        switch (cbxBeneficio.getSelectedItem().toString().trim()) {
            case "COPAGO FIJO":
                txfDescuento.setEnabled(true);
                txfCopago.setEnabled(true);
                txfMontoFps.setEnabled(false);
                cbxPaquete.setEnabled(false);
                cbxServicioFps.setEnabled(false);
                break;
            case "FONDO PREVISION":
                txfDescuento.setEnabled(false);
                txfCopago.setEnabled(false);
                txfMontoFps.setEnabled(true);
                cbxPaquete.setEnabled(true);
                cbxServicioFps.setEnabled(true);
                break;
            case "DESCUENTO POR PLANILLA":
                txfDescuento.setEnabled(false);
                txfCopago.setEnabled(false);
                txfMontoFps.setEnabled(false);
                cbxPaquete.setEnabled(false);
                cbxServicioFps.setEnabled(false);
                calcularMontosdescuento();
                break;
        }
    }

    private void calcularMontosdescuento() {
        cuentasxcobrar = total;
        lblCuentaxCobrar.setText(cuentasxcobrar.toString());
        totalAPagar = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        lblMontoaPagar.setText(totalAPagar.toString());

    }

    private void resetcomponents() {
        lblTotal.setText(total.toString());
        txfDescuento.setText("");
        lblDescuento.setText("0.00");
        lblDiferencia.setText("0.00");
        txfCopago.setText("");
        lblCopago.setText("0.00");
        txfMontoFps.setText("");
        lblMontoFps.setText("0.00");
        lblCuentaxCobrar.setText("0.00");
        lblMontoaPagar.setText("0.00");
        txfMontoFps.setText("");
    }

    private void cargarCbxPaquete() {
        oPaqueteFSCtrl = new PaqueteFSCtrl(root);
        oPaqueteFSCtrl.rellenaCbx(cbxPaquete);
    }

    private void determinarEstadoFps() {
        if (cbxPaquete.getSelectedIndex() > 0) {
            if (oFondoSolidaridad != null) {
                oServicioFSBl = new ServicioFSBl();
                oServiciosFondoSolidaridad = oServicioFSBl.buscarBeneficio(oFondoSolidaridad, (PaqueteFondoSolidaridad) cbxPaquete.getSelectedItem());
                if (oServiciosFondoSolidaridad != null) {
                    //Cargar los servicios asociados  al paquete seleccionado
                    carCbxServicioFps((PaqueteFondoSolidaridad) cbxPaquete.getSelectedItem());
                } else {
                    JOptionPane.showMessageDialog(null, "Su FPS no se encuentra activo para ningun paquete", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No tiene fondos registrados", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private void carCbxServicioFps(PaqueteFondoSolidaridad obj) {
        oPaqueteFondoDetalleCtrl = new PaqueteFondoDetalleCtrl(root);
        oPaqueteFondoDetalleCtrl.rellenaCbx(cbxServicioFps, obj.getIdpaquetefs());
    }

    private HistorialAtencionFps agregarHistorial() {
        oHistorialAtencionFps = new HistorialAtencionFps();
        oHistorialAtencionBl = new HistorialAtencionBl();

        oHistorialAtencionFps.setFondoSolidaridad(oFondoSolidaridad);
        oHistorialAtencionFps.setIdPaqueteFps(((PaqueteFondoSolidaridad) cbxPaquete.getSelectedItem()).getIdpaquetefs());
        oHistorialAtencionFps.setIdServicioFps(((PaqueteFondoDetalle) cbxServicioFps.getSelectedItem()).getIdpaquetefondo());
        //seterar venta en la pantalla anterior
        oHistorialAtencionFps.setMontoDisponible(new BigDecimal(txfSaldoFPS.getText().trim()).setScale(2, RoundingMode.HALF_UP));

        oHistorialAtencionFps.setMontoUtilizado(montoFps);
        oHistorialAtencionFps.setSaldo(oHistorialAtencionFps.getMontoDisponible().subtract(montoFps));
        oHistorialAtencionFps.setNumRegistro((oHistorialAtencionBl.buscarUltimoRegistro(oFondoSolidaridad)) != null ? (oHistorialAtencionBl.buscarUltimoRegistro(oFondoSolidaridad)).getNumRegistro() + 1 : 1);

        return oHistorialAtencionFps;
    }

    private void buscarDatosUltimoRegistroFondo() throws Exception {
        /*buscar historial de atencion  con el fondo seleccionado y si se encuentra ACT
         la busqueda se debe hacer por fondo  y paquete 
         */
        oHistorialAtencionBl = new HistorialAtencionBl();
        oHistorialAtencionFps = oHistorialAtencionBl.buscarUltimoRegistro(oFondoSolidaridad);
        if (oHistorialAtencionFps != null) {
            //setear monto disponible y cantidad de atenciones disponibles por servicio
            txfSaldoFPS.setText(oHistorialAtencionFps.getSaldo().toString());

        } else {
            //seterar valores por defecto, es decir poner parametros iniciales segun servicio seleccionado 
            cargarDatosDetallePaquete();
        }
    }

    private void cargarDatosDetallePaquete() {
        oPaqueteFondoDetalleBl = new PaqueteFondoDetalleBl();

        oPaqueteFondoDetalle = oPaqueteFondoDetalleBl.buscarxId(((PaqueteFondoDetalle) cbxServicioFps.getSelectedItem()).getIdpaquetefondo());
        if (oPaqueteFondoDetalle != null && oPaqueteFondoDetalle.getBeneficio().trim().equals("FARMACIA")) {
            txfSaldoFPS.setText(oPaqueteFondoDetalle.getImporteCubierto().toString());
        } else {
            Mensajes.msjErrorgenerico(PaqueteFondoDetalle.class);
        }
    }

    private boolean isDatosValidosFps() {
        return (oFondoSolidaridad != null
                && cbxBeneficio.getSelectedItem().toString().equals("FONDO PREVISION") //&& cbxServicioFps.getSelectedItem().toString().equals("FARMACIA")
                );
    }

    private void verHistorial() {
        if (isDatosValidosFps()) {
            root.insertarInternalFrames(root.jifHistorialFps);
            root.jifHistorialFps.cargarHistorialFPS(oFondoSolidaridad);
        }
    }

    private void guardar() {
        
        totalDescuento = descuento.add(cuentasxcobrar).setScale(2, RoundingMode.HALF_UP);
        if (cbxModalidadPago.getSelectedItem().toString().equals("CONTADO")) {
            root.jifRegVentas.enviaCuentasxcobrar(totalAPagar, totalDescuento);
            this.doDefaultCloseAction();
        } else if (cbxModalidadPago.getSelectedItem().toString().equals("SEGURO") && cbxSeguro.getSelectedItem().toString().equals("CAC SANTA MARIA MAGDALENA")) {
            //Si se tiene una cuenta  por cobrar mayor a cero, solo en ese caso se genera un registro
            oCuentaxcobrar = agregarCuentasxcobrar();
            if (cbxBeneficio.getSelectedItem().toString().equals("FONDO PREVISION")) {
                if (isDatosValidosFps()) {
                    oHistorialAtencionFps = agregarHistorial();
                    root.jifRegVentas.enviaCuentasxcobrar(oCuentaxcobrar, totalAPagar, oHistorialAtencionFps, totalDescuento);
                    this.doDefaultCloseAction();
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede guardar. Error en FPS", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if(cbxBeneficio.getSelectedItem().toString().equals("DESCUENTO POR PLANILLA")){
                /*En el descuento por planilla se debe registrar el ingreso como si se estaria pagando en efectivo
                  -Adicionalmente se debe registrar una cuenta por cobrar por el mismo  monto y anombre del cliente
                */
                totalAPagar = cuentasxcobrar;
                root.jifRegVentas.enviaCuentasxcobrar(oCuentaxcobrar, totalAPagar, totalDescuento);
                this.doDefaultCloseAction();
            }

        } else {
            oCuentaxcobrar = agregarCuentasxcobrar();
            root.jifRegVentas.enviaCuentasxcobrar(oCuentaxcobrar, totalAPagar, totalDescuento);
            this.doDefaultCloseAction();
        }
    }
}
