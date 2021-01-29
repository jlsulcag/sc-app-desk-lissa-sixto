package lissa.gui;

import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.Beneficio;
import lissa.be.Caja;
import lissa.be.Comprobante;
import lissa.be.Atencion;
import lissa.be.CitaDetalle;
import lissa.be.FondoSolidaridad;
import lissa.be.ComprobanteDetalle;
import lissa.be.Medico;
import lissa.be.MedicoDerivaAtiende;
import lissa.be.Persona;
import lissa.be.PersonaJuridica;
import lissa.be.Procedimiento;
import lissa.be.ProcedimientoTarifario;
import lissa.be.SeguroVida;
import lissa.be.SeguroVidaUsaPersona;
import lissa.be.Usuario;
import lissa.be.UsuarioPermiso;
import lissa.bl.BoletaBl;
import lissa.bl.BeneficioBl;
import lissa.bl.CitaDetalleBl;
import lissa.bl.ComprobanteBl;
import lissa.bl.FondoPrevisionBl;
import lissa.bl.ItemsComprobanteBl;
import lissa.bl.SeguroBl;
import lissa.bl.SeguroPersonaBl;
import lissa.bl.MedicoDerivaAtiendeBl;
import lissa.bl.PacienteBl;
import lissa.bl.UsuarioPermisoBl;
import lissa.controller.BeneficioCtrl;
import lissa.controller.SeguroCtrl;
import lissa.table.ModeloProcedimientoMedico;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Variables;

public class JIF_EmitirComprobante extends javax.swing.JInternalFrame {

    BoletaBl oBLBoleta = new BoletaBl();
    private JF_Principal root;
    private Usuario oUsuario;
    private Caja Ocaja;
    private ComprobanteDetalle oComprobanteDetalle;
    private ItemsComprobanteBl oBlItemComprobante;
    private SeguroBl blSeguro;
    private SeguroPersonaBl oBlSeguroPersona;
    private Comprobante oComprobante;
    private ComprobanteBl oBlComprobante;
    private Persona oPersona;
    private PersonaJuridica oPersonaJuridica;
    private Atencion oAtencionTemp = null;
    private PacienteBl oBlPaciente = null;
    private Medico oMedicoD;
    private Medico oMedicoA;
    private ModeloProcedimientoMedico oModeloProcedimiento;
    private SeguroVida oSeguroVida;
    private BigDecimal montoTotal = new BigDecimal("0.00");
    private BigDecimal montoAdicional = new BigDecimal("0.00");
    private BigDecimal montoPagar = new BigDecimal("0.00");
    private BigDecimal montoCubiertoSeguro;
    private BigDecimal montoReal = new BigDecimal("0.00");
    private int cubierto;
    private FondoSolidaridad beanfs = null;
    private FondoSolidaridad oFondoSolidaridad = null;
    private FondoPrevisionBl oBlFondoPrevision = null;
    private BeneficioBl oBeneficioBl = null;
    private List<Beneficio> beneficioList;
    public static final int CIEN = 100;
    public static final BigDecimal CIENTODIESIOCHO = new BigDecimal(1.18);
    private ArrayList<MedicoDerivaAtiende> listMedDA;
    private MedicoDerivaAtiende oMedicoDerivaAtiende;
    private MedicoDerivaAtiendeBl oMedicoDerivaAtiendeBl;
    private ProcedimientoTarifario oProcedimientoTarifario;
    private List<ComprobanteDetalle> listComprobanteDetalle = new LinkedList<>();
    private Atencion oAtencion;
    private UsuarioPermiso oUsuarioPermiso;
    private UsuarioPermisoBl oUsuarioPermisoBl;
    private final static int ES_CONVENIO = 1;
    private CitaDetalleBl oCitaDetalleBl;
    private List<CitaDetalle> listCitaDetalle;
    private SeguroCtrl oSeguroCtrl;
    private BeneficioCtrl oBeneficioCtrl;

    public JIF_EmitirComprobante(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloProcedimiento = new ModeloProcedimientoMedico();
        tblResultados.setModel(oModeloProcedimiento);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txfNombrePersona = new javax.swing.JTextField();
        btnBuscarPaciente = new javax.swing.JButton();
        txfFechaIngreso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txfFondoPrev = new javax.swing.JTextField();
        btnBuscarFondoPrev = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResultados = new org.jdesktop.swingx.JXTable();
        jLabel17 = new javax.swing.JLabel();
        txfMontoTotal = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        txfMontoProcedTarifario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txfProcedimiento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txfMedicoDerivador = new javax.swing.JTextField();
        txfMedicoTratante = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jsCubiertoSeguro = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        txfMontoPagado = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbxSeguro = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        cbxBeneficio = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        txfMontoAdicional = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txfObservacionServicio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txfNumCarta = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Atención");
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
                formInternalFrameOpened(evt);
            }
        });

        jPanel8.setPreferredSize(new java.awt.Dimension(790, 560));

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paciente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11))); // NOI18N

        jLabel26.setText("Paciente : ");

        txfNombrePersona.setEnabled(false);

        btnBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });

        txfFechaIngreso.setEditable(false);
        txfFechaIngreso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel2.setText("Fecha Ingreso :");

        jLabel9.setText("Fondo Previsión : ");

        txfFondoPrev.setEnabled(false);

        btnBuscarFondoPrev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Reports-icon.png"))); // NOI18N
        btnBuscarFondoPrev.setToolTipText("Ver detalles");
        btnBuscarFondoPrev.setEnabled(false);
        btnBuscarFondoPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFondoPrevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfNombrePersona, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfFondoPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarFondoPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscarFondoPrev)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txfFondoPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(txfNombrePersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txfFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(btnBuscarPaciente))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle del Comprobante", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tblResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResultadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblResultados);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("TOTAL S/.");

        txfMontoTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txfMontoTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfMontoTotal.setText("0.00");
        txfMontoTotal.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txfMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txfMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Servicio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txfMontoProcedTarifario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfMontoProcedTarifario.setEnabled(false);
        txfMontoProcedTarifario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfMontoProcedTarifarioKeyReleased(evt);
            }
        });

        jLabel4.setText("S/.");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Procedimiento : ");

        txfProcedimiento.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txfProcedimiento.setEnabled(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Derivado por : ");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Atendido por : ");

        txfMedicoDerivador.setEnabled(false);
        txfMedicoDerivador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfMedicoDerivadorActionPerformed(evt);
            }
        });

        txfMedicoTratante.setEnabled(false);
        txfMedicoTratante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfMedicoTratanteActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jsCubiertoSeguro.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jsCubiertoSeguro.setEnabled(false);
        jsCubiertoSeguro.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsCubiertoSeguroStateChanged(evt);
            }
        });

        jLabel6.setText("S/.");

        txfMontoPagado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfMontoPagado.setEnabled(false);

        jLabel10.setText("Cubierto Seguro (%) : ");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Convenio :");

        cbxSeguro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione>" }));
        cbxSeguro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxSeguroItemStateChanged(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Beneficio : ");

        cbxBeneficio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Selecccione>" }));
        cbxBeneficio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxBeneficioItemStateChanged(evt);
            }
        });

        jLabel33.setText("Aumt/Desc :");

        txfMontoAdicional.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfMontoAdicional.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfMontoAdicionalKeyReleased(evt);
            }
        });

        jLabel38.setText("Observación :");

        jLabel5.setText("N° Carta : ");

        txfNumCarta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txfProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfMontoProcedTarifario, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbxSeguro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addGap(350, 350, 350)
                                .addComponent(jLabel5))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txfMontoAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jsCubiertoSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfMontoPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfNumCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txfObservacionServicio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txfMedicoDerivador, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txfMedicoTratante, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cbxSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(cbxBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txfNumCarta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txfProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txfMontoProcedTarifario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jsCubiertoSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfMontoPagado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel33)
                            .addComponent(txfMontoAdicional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txfMedicoDerivador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txfMedicoTratante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txfObservacionServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/remove.png"))); // NOI18N
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Cash-register-icon_1.png"))); // NOI18N
        jButton2.setText("Pago en Caja");
        jButton2.setToolTipText("");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(btnQuitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        resetComponent();
        oComprobante = null;
        oPersona = null;
        oPersonaJuridica = null;
        montoTotal = new BigDecimal("0.00");
        //this.cbxSeguro.setSelectedIndex(0);
        this.txfFondoPrev.setText("");
        personalizaVistaTabla();
        btnBuscarFondoPrev.setEnabled(false);
    }//GEN-LAST:event_formInternalFrameClosing

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        personalizaVistaTabla();
    }//GEN-LAST:event_formInternalFrameOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Enviar  la data  ingresada a la pantalla de caja , para  su  pago respectivo
        if (tieneCarta() && txfNumCarta.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el numero de carta", "Atención", JOptionPane.ERROR_MESSAGE);
        } else {
            EnviarDatosaCaja(listComprobanteDetalle);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if (tblResultados.getSelectedRow() != -1) {
            listComprobanteDetalle.remove(oModeloProcedimiento.get(tblResultados.getSelectedRow()));
            oModeloProcedimiento.remove(tblResultados.getSelectedRow());
            calcularMontoTotal(listComprobanteDetalle);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un elemento de la lista", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
        personalizaVistaTabla();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregarDetalle();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txfMontoAdicionalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfMontoAdicionalKeyReleased
        calcularMontoAPagar();
    }//GEN-LAST:event_txfMontoAdicionalKeyReleased

    private void cbxSeguroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxSeguroItemStateChanged
        oSeguroVida = new SeguroVida();
        if (cbxSeguro.getSelectedIndex() > 0) {
            oSeguroVida = (SeguroVida) cbxSeguro.getSelectedItem();
            //cargarBeneficios();
            llenarBeneficioxSeguro(oSeguroVida.getIdSeguroVida());
        }
    }//GEN-LAST:event_cbxSeguroItemStateChanged

    private void btnBuscarFondoPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFondoPrevActionPerformed
        buscarFondoPrevision();
    }//GEN-LAST:event_btnBuscarFondoPrevActionPerformed

    private void jsCubiertoSeguroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsCubiertoSeguroStateChanged
        calcularMontoaPagoServicio();
    }//GEN-LAST:event_jsCubiertoSeguroStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        buscarMedico(JIF_BuscarMedico.MEDICO_ATIENDE);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        buscarMedico(JIF_BuscarMedico.MEDICO_DERIVADOR);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txfMedicoTratanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfMedicoTratanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfMedicoTratanteActionPerformed

    private void txfMedicoDerivadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfMedicoDerivadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfMedicoDerivadorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (isDatosValidosBoleta()) {
            buscarProcedimiento();
        } else {
            Mensajes.msjValidarIngreso();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txfMontoProcedTarifarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfMontoProcedTarifarioKeyReleased
        if (!txfMontoProcedTarifario.getText().trim().equals("")) {
            calcularMontoAPagar();
        } else {
            resetMontosCalculados();
            calcularMontoAPagar();
        }
    }//GEN-LAST:event_txfMontoProcedTarifarioKeyReleased

    private void tblResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseClicked

    }//GEN-LAST:event_tblResultadosMouseClicked

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        buscarPersona();
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void cbxBeneficioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxBeneficioItemStateChanged
        habilitaDeshabilitaSeguro();
    }//GEN-LAST:event_cbxBeneficioItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarFondoPrev;
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox cbxBeneficio;
    private javax.swing.JComboBox cbxSeguro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jsCubiertoSeguro;
    private org.jdesktop.swingx.JXTable tblResultados;
    private javax.swing.JTextField txfFechaIngreso;
    private javax.swing.JTextField txfFondoPrev;
    private javax.swing.JTextField txfMedicoDerivador;
    private javax.swing.JTextField txfMedicoTratante;
    private javax.swing.JTextField txfMontoAdicional;
    private javax.swing.JTextField txfMontoPagado;
    private javax.swing.JTextField txfMontoProcedTarifario;
    private javax.swing.JTextField txfMontoTotal;
    private javax.swing.JTextField txfNombrePersona;
    private javax.swing.JTextField txfNumCarta;
    private javax.swing.JTextField txfObservacionServicio;
    private javax.swing.JTextField txfProcedimiento;
    // End of variables declaration//GEN-END:variables

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblResultados, 80);
        Utilitarios.formateaColumna(3, tblResultados, 70);
        Utilitarios.alinearDatosColumnaTablaDerecha(3, tblResultados);
    }

    private long generarNumeracionComprobante() {
        oBLBoleta = new BoletaBl();
        return oBLBoleta.obtenerUltNumero(oComprobante.getGrupoNumeracion()) + 1;
    }

    private void registrar() {
        if (isDatosValidosRegistrarBoleta()) {
            oComprobante = registrarBoleta();
            if (oComprobante != null) {
                registrarDetalleBoleta();
                JOptionPane.showMessageDialog(null, "Registro de comprobante exitoso", "Atención", JOptionPane.INFORMATION_MESSAGE);
                resetComponent();//Limpiar los datos actuales del comprobante
                this.doDefaultCloseAction();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar procedimientos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar comprobante", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private Comprobante registrarBoleta() {
        oBlComprobante = new ComprobanteBl();
        //deberia relacionar  con id  persona
        if (oAtencionTemp != null) {
            oComprobante.setAtencion(oAtencionTemp);
            oComprobante.setBeneficio(cbxBeneficio.getSelectedIndex() > 0 ? (Beneficio) cbxBeneficio.getSelectedItem() : null);
            oComprobante.setEstado("REG");
            oComprobante.setFechaReg(new Date());
            oComprobante.setSubTotal(new BigDecimal("0.00"));
            oComprobante.setMontoIgv(new BigDecimal("0.00"));
            oComprobante.setMontoTotal(montoTotal);
            oComprobante.setIdUsuario(getoUsuario().getIdUsuario());
            oComprobante.setCaja(getOcaja());
            oComprobante.setNumeroOperacion(obtenerNumeroOperacion());
            return oBlComprobante.registrar(oComprobante);
        } else {
            JOptionPane.showMessageDialog(null, "Registre su ingreso en Admisión", "Atención", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    private void registrarDetalleBoleta() {
        if (oModeloProcedimiento.size() > 0) {
            for (int i = 0; i < oModeloProcedimiento.size(); i++) {
                oComprobanteDetalle = new ComprobanteDetalle();
                oBlItemComprobante = new ItemsComprobanteBl();
                oComprobanteDetalle = (ComprobanteDetalle) oModeloProcedimiento.get(i);
                oComprobanteDetalle.setComprobante(oComprobante);
                oComprobanteDetalle = oBlItemComprobante.registrar(oComprobanteDetalle);
            }
        } else {
            JOptionPane.showMessageDialog(null, "La boleta no contiene procedimientos para su registro", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void agregarItemsComprobante() {
        oComprobanteDetalle = new ComprobanteDetalle();
        if (oProcedimientoTarifario != null) {
            //setear valores de cada uno de los items para guardar en la tabla comprobanteDetalle
            oComprobanteDetalle.setProcedimientoTarifario(oProcedimientoTarifario);
            oComprobanteDetalle.setMontoProcedimiento(oProcedimientoTarifario.getCosto());
            oComprobanteDetalle.setConcepto(oProcedimientoTarifario.getProcedimiento().getDenominacion());
            oComprobanteDetalle.setFechaReg(new Date());
            oComprobanteDetalle.setMedicoByIdMedicoDeriva(oMedicoD);
            oComprobanteDetalle.setMedicoByIdMedicoAtiende(oMedicoA);
            oComprobanteDetalle.setImporteAdicional(montoAdicional);
            oComprobanteDetalle.setMontoPagado(montoPagar);
            oComprobanteDetalle.setObservacion(!txfObservacionServicio.getText().trim().equals("") ? txfObservacionServicio.getText().trim().toUpperCase() : "");
            oComprobanteDetalle.setPorcCubierto(cubierto);
            oComprobanteDetalle.setMontoCubierto(montoCubiertoSeguro != null ? montoCubiertoSeguro : new BigDecimal("0.00"));
            oComprobanteDetalle.setFechaAtencion(new Date());
            oComprobanteDetalle.setEstado("REG");
            oComprobanteDetalle.setUnidadMedida("NIU");
            oComprobanteDetalle.setCantidad(new BigDecimal("1.00"));
            oComprobanteDetalle.setPrecioUnitarioItem(montoPagar);
            oComprobanteDetalle.setValorUnitarioItem(montoPagar.divide(Variables.CIEN_IGV, 2, RoundingMode.HALF_UP));
            oComprobanteDetalle.setMontoIgvItem(oComprobanteDetalle.getValorUnitarioItem().multiply(Variables.IGV));
            oComprobanteDetalle.setSubTotal(oComprobanteDetalle.getValorUnitarioItem().multiply(oComprobanteDetalle.getCantidad()));
            oComprobanteDetalle.setMontoTotal(oComprobanteDetalle.getPrecioUnitarioItem().multiply(oComprobanteDetalle.getCantidad()));

            //falta id tipo IGV
            //oComprobanteDetalle.setNumeroCarta(!txfNumCarta.getText().trim().equals("") ? txfNumCarta.getText().trim() : "");
            //fin de seteo de valores
            // if (!existeProcedimientoxCarta(oComprobanteDetalle)) {
            oModeloProcedimiento.add(oComprobanteDetalle);
            //Se agrega a una lista los valores para los datos del medico que deriva o atiende
            //agregarMedicoDerivaAtiende(oComprobanteDetalle);
            listComprobanteDetalle.add(oComprobanteDetalle);
            //Calcula el monto total acumulado              
            calcularMontoTotal(listComprobanteDetalle);
            // }

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el procedimiento", "Atención", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private void agregarMedicoDerivaAtiende(ComprobanteDetalle oItemComprobante) {
        if (oMedicoD != null) {
            oMedicoDerivaAtiende = new MedicoDerivaAtiende();
            oMedicoDerivaAtiende.setComprobanteDetalle(oItemComprobante);
            oMedicoDerivaAtiende.setMedico(oMedicoD);
            //BigDecimal monto = txfMontoDerivado.getText().trim().equals("")?BigDecimal.ZERO:new BigDecimal(txfMontoDerivado.getText().trim());
            //oMedicoDerivaAtiende.setMonto(monto);            
            oMedicoDerivaAtiende.setEstadoPago("DEBE");
            oMedicoDerivaAtiende.setMotivo("DERIVA");
            oMedicoDerivaAtiende.setIdCajaafecto(getOcaja().getIdcaja());
            listMedDA.add(oMedicoDerivaAtiende);
        }
        if (oMedicoA != null) {
            oMedicoDerivaAtiende = new MedicoDerivaAtiende();
            oMedicoDerivaAtiende.setComprobanteDetalle(oItemComprobante);
            oMedicoDerivaAtiende.setMedico(oMedicoA);
            //BigDecimal monto = txfMontoAtencion.getText().trim().equals("")?BigDecimal.ZERO:new BigDecimal(txfMontoAtencion.getText().trim());
            //oMedicoDerivaAtiende.setMonto(monto);
            if (oMedicoA != null && oMedicoA.getTipoMedico().getNombre().trim().equals("PLANTA")) {
                oMedicoDerivaAtiende.setEstadoPago("NO SE PAGA");
            } else {
                oMedicoDerivaAtiende.setEstadoPago("DEBE");
            }
            oMedicoDerivaAtiende.setMotivo("ATIENDE");
            oMedicoDerivaAtiende.setIdCajaafecto(getOcaja().getIdcaja());
            listMedDA.add(oMedicoDerivaAtiende);
        }
    }

    private void buscarPersona() {
        buscarSocio(JIF_BuscarPersonaNatural.JIF_EMITIR_COMPROBANTE);
    }

    void cargarDatosPersona(Persona beanTabla) {
        this.oPersona = beanTabla;
        //busca datos del paciente por  ultimo ingreso
        oBlPaciente = new PacienteBl();
        if (oPersona != null) {
            oAtencion = oBlPaciente.buscarPacienteXid(oPersona.getIdpersona());
            if (oAtencion != null && oAtencion.getEstado().equals("REG")) {                
                txfNombrePersona.setText((oPersona.getNombre().trim() + " " + oPersona.getApellidoPaterno().trim() + " " + oPersona.getApellidoMaterno().trim()).length()>=40?(oPersona.getNombre().trim() + " " + oPersona.getApellidoPaterno().trim() + " " + oPersona.getApellidoMaterno().trim()).toUpperCase().trim().substring(0,40)+"...":(oPersona.getNombre().trim() + " " + oPersona.getApellidoPaterno().trim() + " " + oPersona.getApellidoMaterno().trim()).toUpperCase().trim());
                txfFechaIngreso.setText(Utilitarios.formatFecha(oAtencion.getFechaIngreso()));
                cargarDatosCita();//carga  datos de la cita  si la persona cuenta  con una
                personalizaVistaTabla();
                //Llenar los seguros con los que  cuenta el paciente
                //llenarComboSegurosPaciente();
                //Obtener el ultimo fondo de prevision segun el dni recuperado
                if (oPersona != null) {
                    obtenerFondoPrevUlt(oPersona.getNumeroDocumento());
                }
                //fin de busqueda
                btnBuscarFondoPrev.setEnabled(true);
                txfFechaIngreso.setBackground(Color.GREEN);
            } else {
                txfFechaIngreso.setText("");
                txfFechaIngreso.setBackground(Color.RED);
                JOptionPane.showMessageDialog(null, "Registre un nuevo ingreso", "Atención", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe datos del pacienteE", "Atención", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void llenarComboSegurosPaciente() {
        blSeguro = new SeguroBl();
        oBlSeguroPersona = new SeguroPersonaBl();
        ArrayList<SeguroVidaUsaPersona> list;
        list = oBlSeguroPersona.listar(oPersona.getIdpersona());
        cbxSeguro.removeAllItems();
        cbxBeneficio.removeAllItems();
        cbxSeguro.addItem("<SELECCIONE>");
        cbxBeneficio.addItem("<SELECCIONE>");
        for (SeguroVidaUsaPersona list1 : list) {
            SeguroVida seguro = new SeguroVida();
            //seguro = blSeguro.buscar(list1.getIdSeguroVida());
            seguro = blSeguro.buscar(list1.getSeguroVida().getIdSeguroVida());
            seguro.setOp(SeguroVida.DATO);
            cbxSeguro.addItem(seguro);
        }
    }

    private boolean isDatosValidosBoleta() {
        return (!this.txfNombrePersona.getText().trim().equals(""));
    }

    private void buscarSocio(int JIF_EMITIR_COMPROBANTE) {
        root.jifBuscarPersonaNatural.setInvocador(JIF_EMITIR_COMPROBANTE);
        try {
            root.insertarInternalFrames(root.jifBuscarPersonaNatural);
            root.jifBuscarPersonaNatural.inicializar();
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    private void resetComponent() {
        this.cbxSeguro.setSelectedIndex(0);
        this.cbxBeneficio.setSelectedIndex(0);
        this.txfNombrePersona.setText("");
        this.txfProcedimiento.setText("");
        this.txfMontoProcedTarifario.setText("");
        this.oModeloProcedimiento.clear();
        this.txfMontoTotal.setText("0.00");
        this.txfMontoPagado.setText("");
        this.txfMontoAdicional.setText("");
        this.jsCubiertoSeguro.setValue(0);
        txfFechaIngreso.setText("");
    }

    public void cargarDatosUsuario(Usuario user) {
        this.setoUsuario(user);
    }

    public Usuario getoUsuario() {
        return oUsuario;
    }

    public void setoUsuario(Usuario oUsuario) {
        this.oUsuario = oUsuario;
    }

    private Integer obtenerNumeroOperacion() {
        oBLBoleta = new BoletaBl();
        return oBLBoleta.obtenerNumeroOperacion() + 1;
    }

    private void buscarMedico(int MEDICO_DERIVADOR) {
        root.jifBuscarMedico.setInvocador(MEDICO_DERIVADOR);
        try {
            root.insertarInternalFrames(root.jifBuscarMedico);
            root.jifBuscarMedico.inicializar();
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    void cargarDatosMedicoD(Medico beanTabla) {
        this.oMedicoD = beanTabla;
        txfMedicoDerivador.setText(oMedicoD.getPersona().getApellidoPaterno().trim() + " " + oMedicoD.getPersona().getApellidoMaterno().trim() + " " + oMedicoD.getPersona().getNombre());
    }

    void cargarDatosMedicoA(Medico beanTabla) {
        this.oMedicoA = beanTabla;
        txfMedicoTratante.setText(oMedicoA.getPersona().getApellidoPaterno().trim() + " " + oMedicoA.getPersona().getApellidoMaterno().trim() + " " + oMedicoA.getPersona().getNombre());
    }

    private void buscarFondoPrevision() {
        root.insertarInternalFrames(root.jifFondoPrevision);
        root.jifFondoPrevision.enviarDatosPersona(oPersona);
    }

    private void calcularMontoaPagoServicio() {
        if (oProcedimientoTarifario != null) {
            calcularMontoAPagar();
        }

    }

    void cargarDatos(FondoSolidaridad beanTablaFS) {
        oFondoSolidaridad = beanTablaFS;
        txfFondoPrev.setText(Utilitarios.formatFecha(oFondoSolidaridad.getFechaReg()));
        if (isVigente(oFondoSolidaridad.getFechaReg())) {
            txfFondoPrev.setBackground(Color.GREEN);
        } else {
            txfFondoPrev.setBackground(Color.RED);
        }

    }

    private void cargarBeneficios() {
        oBeneficioBl = new BeneficioBl();
        cbxBeneficio.removeAllItems();
        beneficioList = oBeneficioBl.buscarXIdSeguro(((SeguroVida) cbxSeguro.getSelectedItem()).getIdSeguroVida());
        if (!beneficioList.isEmpty()) {
            cbxBeneficio.removeAllItems();
            cbxBeneficio.addItem("<SELECCIONE>");
            for (Beneficio beneficio1 : beneficioList) {
                beneficio1.setOp(SeguroVida.DATO);
                cbxBeneficio.addItem(beneficio1);
            }
        }
    }

    private void obtenerFondoPrevUlt(String numeroDocumento) {
        oFondoSolidaridad = new FondoSolidaridad();
        oBlFondoPrevision = new FondoPrevisionBl();
        oFondoSolidaridad = oBlFondoPrevision.obtenerUltimo(numeroDocumento);
        txfFondoPrev.setFont(new Font("Tahoma", Font.BOLD, 12));
        txfFondoPrev.setDisabledTextColor(Color.BLACK);
        if (oFondoSolidaridad != null) {
            txfFondoPrev.setText(Utilitarios.formatFecha(oFondoSolidaridad.getFechaReg()));
            if (isVigente(oFondoSolidaridad.getFechaReg())) {
                txfFondoPrev.setBackground(Color.GREEN);
            } else {
                txfFondoPrev.setBackground(Color.RED);
            }
        } else {
            txfFondoPrev.setText("NO TIENE FPS");
            btnBuscarFondoPrev.setEnabled(false);
            txfFondoPrev.setDisabledTextColor(Color.red);
        }
    }

    private void calcularMontoAPagar() {
        resetMontosCalculados();
        montoReal = oProcedimientoTarifario.getCosto();
        //cubierto = ((Integer) jsCubiertoSeguro.getValue());
        if (cbxBeneficio.getSelectedIndex() > 0) {
            if (((Beneficio) cbxBeneficio.getSelectedItem()).getPorcCubierto() == 100) {
                cubierto = ((Beneficio) cbxBeneficio.getSelectedItem()).getPorcCubierto();
            } else {
                cubierto = ((Integer) jsCubiertoSeguro.getValue());
            }
            jsCubiertoSeguro.setValue(cubierto);
        } else {
            cubierto = ((Integer) jsCubiertoSeguro.getValue());
        }
        if (!txfMontoAdicional.getText().trim().equals("") && !txfMontoAdicional.getText().trim().equals("-")) {
            montoAdicional = new BigDecimal(txfMontoAdicional.getText().trim());
        } else {
            montoAdicional = new BigDecimal("0.00");
        }
        montoCubiertoSeguro = (montoReal.multiply(new BigDecimal(cubierto)).setScale(2, RoundingMode.HALF_UP)).divide(new BigDecimal(CIEN));
        montoPagar = ((montoReal.add(montoAdicional)).subtract(montoCubiertoSeguro)).setScale(2, RoundingMode.HALF_UP);
        //imprimir en pantalla el importe  total
        if (esConvenio()) {
            if (oUsuarioPermiso != null) {
                txfMontoPagado.setText(montoPagar.toString());
            } else {
                txfMontoPagado.setText("00.00");
            }
        } else {
            txfMontoPagado.setText(montoPagar.toString());
        }

    }

    void EnviarDatosCaja(Caja oCaja) {
        this.setOcaja(oCaja);
    }

    public Caja getOcaja() {
        return Ocaja;
    }

    public void setOcaja(Caja Ocaja) {
        this.Ocaja = Ocaja;
    }

    void enviarDatosPaciente(Persona beanTablaPersona) {
        cargarDatosPersona(beanTablaPersona);
    }

    private void resetMontosCalculados() {
        montoReal = BigDecimal.ZERO;
        //cubierto = 0;
        montoAdicional = BigDecimal.ZERO;
        montoCubiertoSeguro = BigDecimal.ZERO;
        montoPagar = BigDecimal.ZERO;
    }

    private void resetComponentDatosServicio() {
        oProcedimientoTarifario = null;
        oMedicoA = null;
        oMedicoD = null;
        txfProcedimiento.setText("");
        txfMontoProcedTarifario.setText("");
        txfMedicoDerivador.setText("");
        txfMedicoTratante.setText("");
        txfMontoPagado.setText("");
        txfMontoAdicional.setText("");
        jsCubiertoSeguro.setValue(0);
        txfObservacionServicio.setText("");
        oComprobanteDetalle = null;

    }

    void inicializar() {
        listMedDA = new ArrayList<>();
        montoTotal = new BigDecimal("0.00");
        oModeloProcedimiento.clear();
        oModeloProcedimiento.enviaUser(getoUsuario());
        listComprobanteDetalle.clear();
        txfNumCarta.setText("");
        cargarSeguroyBeneficio();
        cargarDatosCita();
        oModeloProcedimiento.clear();
        personalizaVistaTabla();

    }

    private void buscarProcedimiento() {
        root.jifBuscarProcedimiento.setInvocador(JIF_BuscarProcedimiento.JIF_ATENCION);
        root.insertarInternalFrames(root.jifBuscarProcedimiento);
        root.jifBuscarProcedimiento.enviarUser(getoUsuario());
        root.jifBuscarProcedimiento.inicializar();

        //root.jifBuscarProcedimiento.enviaBeneficio((Beneficio)cbxBeneficio.getSelectedItem());
    }

    void enviaDatosProcedimiento(ProcedimientoTarifario obj) {
        oUsuarioPermisoBl = new UsuarioPermisoBl();
        oProcedimientoTarifario = obj;
        //validar que se observe  el precio de los comvenios
        oUsuarioPermiso = oUsuarioPermisoBl.buscarUsuarioPermiso(1, oUsuario.getIdUsuario());
        txfProcedimiento.setText(oProcedimientoTarifario.getProcedimiento().getDenominacion().trim());
        if (esConvenio()) {
            if (oUsuarioPermiso != null) {
                txfMontoProcedTarifario.setText(oProcedimientoTarifario.getCosto().toString());
            } else {
                //no mostrar costos
                txfMontoProcedTarifario.setText("**.**");
            }
        } else {
            txfMontoProcedTarifario.setText(oProcedimientoTarifario.getCosto().toString());
            jsCubiertoSeguro.setValue(0);
        }
        //
        calcularMontoAPagar();
    }

    private boolean esConvenio() {
        return (oProcedimientoTarifario.getTarifario().getEsconvenio() == ES_CONVENIO);
    }

    private void resetTotales() {
        montoTotal = BigDecimal.ZERO;
    }

    private boolean isDatosValidosRegistrarBoleta() {
        return (!this.txfNombrePersona.getText().trim().equals("")
                && this.oModeloProcedimiento.size() > 0);
    }

    private void calcularMontoTotal(List<ComprobanteDetalle> listComprobanteDetalle) {
        montoTotal = new BigDecimal("0.00");
        if (!listComprobanteDetalle.isEmpty()) {
            for (ComprobanteDetalle obj : listComprobanteDetalle) {
                montoTotal = montoTotal.add(obj.getMontoPagado());
                txfMontoTotal.setText(montoTotal.toEngineeringString());
            }
        } else {
            txfMontoTotal.setText(montoTotal.toEngineeringString());
        }

    }

    private void EnviarDatosaCaja(List<ComprobanteDetalle> listComprobanteDetalle) {

        if (Ocaja != null && oUsuario != null && !listComprobanteDetalle.isEmpty()) {

            //Asignar atencion segun lo elegido
            if (cbxSeguro.getSelectedIndex() > 0 && cbxBeneficio.getSelectedIndex() > 0) {
                if (((Beneficio) cbxBeneficio.getSelectedItem()).getNombreBeneficio().equals(Variables.FONDO_PREVISION)) {
                    if (oFondoSolidaridad != null) {
                        if (isVigente(oFondoSolidaridad.getFechaReg())) {
                            root.insertarInternalFrames(root.jifCobroCaja);
                            root.jifCobroCaja.inicializar(oUsuario, Ocaja, oPersona, listComprobanteDetalle, montoTotal, this, oAtencion,
                                    (Beneficio) cbxBeneficio.getSelectedItem(), oFondoSolidaridad);
                        } else {
                            JOptionPane.showMessageDialog(null, "Su FPS no se encuentra  vigente", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "No existe FPS", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (cbxSeguro.getSelectedIndex() > 0 && cbxBeneficio.getSelectedIndex() > 0 && !((Beneficio) cbxBeneficio.getSelectedItem()).getNombreBeneficio().equals(Variables.FONDO_PREVISION)) {
                    root.insertarInternalFrames(root.jifCobroCaja);
                    root.jifCobroCaja.inicializar(oUsuario, Ocaja, oPersona, listComprobanteDetalle, montoTotal, this, oAtencion,
                            (Beneficio) cbxBeneficio.getSelectedItem(), txfNumCarta.getText().toUpperCase().trim());
                }
            } else if (cbxSeguro.getSelectedIndex() == 0 && cbxBeneficio.getSelectedIndex() == 0) {
                root.insertarInternalFrames(root.jifCobroCaja);
                root.jifCobroCaja.inicializar(oUsuario, Ocaja, oPersona, listComprobanteDetalle, montoTotal, this, oAtencion);
            }

            //montoTotal = new BigDecimal("0.00");
        }

    }

    void EnviarDatosAtencion(Atencion oAtencion) {
        this.oAtencion = oAtencion;
    }

    private void habilitaDeshabilitaSeguro() {
        if (cbxBeneficio.getSelectedIndex() > 0) {
            jsCubiertoSeguro.setEnabled(true);
            jsCubiertoSeguro.setValue(((Beneficio) cbxBeneficio.getSelectedItem()).getPorcCubierto());
        } else {
            jsCubiertoSeguro.setEnabled(false);
            jsCubiertoSeguro.setValue(0);
        }
    }

    private boolean isDatosValidosDetalles() {
        return (oProcedimientoTarifario != null
                && oMedicoA != null);
    }

    private boolean existeProcedimientoxCarta(ComprobanteDetalle oComprobanteDetalle) {
        boolean existe = false;
        if (listComprobanteDetalle.size() > 0) {
            for (ComprobanteDetalle obj : listComprobanteDetalle) {
                /*
                 if (oComprobanteDetalle.getNumeroCarta().equals(obj.getNumeroCarta()) && oComprobanteDetalle.getProcedimientoTarifario().getIdprocedimientotarifario() == obj.getProcedimientoTarifario().getIdprocedimientotarifario()) {
                 existe = true;
                 break;
                 }
                 */
            }
            //Buscar en la  base de datos

        } else {

        }
        //Buscar En la tabla  temporal

        return existe;
    }

    private boolean isVigente(Date fechaFPS) {
        Calendar fechaVenc = Calendar.getInstance();
        fechaVenc.setTime(fechaFPS);
        //sumandole un año a la fecha de registro del fondo de prevision
        fechaVenc.add(Calendar.YEAR, 1);
        //obtener fecha actual
        Calendar c = new GregorianCalendar();
        //comparar para determinar vigencia
        if (c.before(fechaVenc)) {
            return true;
        } else {
            return false;
        }
    }

    private void agregarDetalle() {
        if (isDatosValidosDetalles()) {
            if (tieneCarta() && txfNumCarta.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese el numero de carta", "Atención", JOptionPane.ERROR_MESSAGE);
            } else {
                if (txfMontoAdicional.getText().trim().equals("")) {
                    agregarItemsComprobante();
                    personalizaVistaTabla();
                    resetComponentDatosServicio();
                } else if (!txfObservacionServicio.getText().trim().equals("")) {
                    agregarItemsComprobante();
                    personalizaVistaTabla();
                    resetComponentDatosServicio();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese la observación del Aumento/Descuento", "Atención", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos", "Atención", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean tieneCarta() {
        boolean tienecarta;
        if (cbxSeguro.getSelectedIndex() > 0 && ((SeguroVida) cbxSeguro.getSelectedItem()).getTieneCarta() == Variables.UNO) {
            tienecarta = true;
        } else {
            tienecarta = false;
        }
        return tienecarta;
    }

    private void cargarDatosCita() {
        //limpiar  para cada llamado
        if(listCitaDetalle != null){
            listCitaDetalle.clear();
        }  
        if(listComprobanteDetalle != null){
            listComprobanteDetalle.clear();
        }
        
        //si tiene una cita en estado REG,  cargar sus datos
        if (oAtencion != null) {
            if (oAtencion.getCita() != null) {
                oCitaDetalleBl = new CitaDetalleBl();
                
                listCitaDetalle = oCitaDetalleBl.listarxIdCita(oAtencion.getCita().getIdcita());
                for (CitaDetalle obj : listCitaDetalle) {
                    ComprobanteDetalle temp = new ComprobanteDetalle();
                    if (obj.getCita().getBeneficio() != null) {
                        oSeguroCtrl = new SeguroCtrl(root);
                        oBeneficioCtrl = new BeneficioCtrl(root);
                        oSeguroCtrl.defaultSelectCbx(obj.getCita().getBeneficio().getSeguroVida().getDescripcion().trim(), cbxSeguro);
                        oBeneficioCtrl.defaultSelectCbx(obj.getCita().getBeneficio().getNombreBeneficio().trim(), cbxBeneficio);
                        txfNumCarta.setText(obj.getCita().getNumeroCarta());
                    }
                    temp.setProcedimientoTarifario(obj.getProcedimientoTarifario());
                    temp.setMontoProcedimiento(obj.getCosto());
                    temp.setConcepto(obj.getProcedimientoTarifario().getProcedimiento().getDenominacion());
                    temp.setFechaReg(new Date());
                    temp.setMedicoByIdMedicoDeriva(null);
                    temp.setMedicoByIdMedicoAtiende(obj.getMedico() != null ? obj.getMedico() : null);
                    temp.setImporteAdicional(new BigDecimal("0.00"));
                    temp.setObservacion("");
                    temp.setPorcCubierto(obj.getCita().getBeneficio() != null ? obj.getCita().getBeneficio().getPorcCubierto() : 0);
                    BigDecimal montoCubiertoSeguro = new BigDecimal("0.00");
                    montoCubiertoSeguro = (obj.getCosto().multiply(new BigDecimal(temp.getPorcCubierto())).setScale(2, RoundingMode.HALF_UP)).divide(new BigDecimal(CIEN));
                    BigDecimal montoPagar = new BigDecimal("0.00");
                    montoPagar = (obj.getCosto().subtract(montoCubiertoSeguro)).setScale(2, RoundingMode.HALF_UP);
                    temp.setMontoPagado(obj.getCosto().multiply(new BigDecimal(temp.getPorcCubierto())));
                    temp.setMontoCubierto(montoCubiertoSeguro);
                    temp.setMontoPagado(montoPagar);
                    temp.setFechaAtencion(new Date());
                    temp.setEstado("REG");
                    temp.setUnidadMedida("NIU");
                    temp.setCantidad(new BigDecimal("1.00"));
                    temp.setPrecioUnitarioItem(montoPagar);
                    temp.setValorUnitarioItem(montoPagar.divide(Variables.CIEN_IGV, 2, RoundingMode.HALF_UP));
                    temp.setMontoIgvItem(temp.getValorUnitarioItem().multiply(Variables.IGV));
                    temp.setSubTotal(temp.getValorUnitarioItem().multiply(temp.getCantidad()));
                    temp.setMontoTotal(temp.getPrecioUnitarioItem().multiply(temp.getCantidad()));

                    oModeloProcedimiento.add(temp);
                    listComprobanteDetalle.add(temp);
                    calcularMontoTotal(listComprobanteDetalle);

                }
            }

        }
    }

    private void cargarSeguroyBeneficio() {
        oSeguroCtrl = new SeguroCtrl(root);
        oSeguroCtrl.rellenaCbx(cbxSeguro);
    }

    private void llenarBeneficioxSeguro(int idseguro) {
        oBeneficioCtrl = new BeneficioCtrl(root);
        oBeneficioCtrl.rellenaCbx(cbxBeneficio, idseguro);
    }

}
