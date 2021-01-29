package lissa.gui;

import java.awt.Color;
import java.beans.PropertyVetoException;
import java.sql.Time;
import java.text.ParseException;
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
import lissa.be.Atencionhc;
import lissa.be.Cie10;
import lissa.be.Comprobante;
import lissa.be.FuncionVital;
import lissa.be.HistoriaClinica;
import lissa.be.ComprobanteDetalle;
import lissa.be.Persona;
import lissa.be.Rol;
import lissa.be.Usuario;
import lissa.bl.AtencionBl;
import lissa.bl.ComprobanteBl;
import lissa.bl.HistoriaClinicaBl;
import lissa.bl.ItemsComprobanteBl;
import lissa.bl.UsuarioBl;
import lissa.bl.FuncionVitalBl;
import lissa.ds.DSConeccion;
import lissa.reportes.ReportGeneric;
import lissa.util.Utilitarios;
import net.sf.jasperreports.engine.JRException;

public class JPanel_HistoriaClinica extends javax.swing.JPanel {

    private JF_Principal root;
    private HistoriaClinica oHistoriaClinica = null;
    private HistoriaClinicaBl oBlHistoriaClinica = null;
    private Cie10 oCie10;
    private Atencionhc oAtencionhc = null;
    private AtencionBl oAtencionBl = null;
    private Comprobante oComprobante = null;
    private ComprobanteBl oComprobanteBl = null;
    private ComprobanteDetalle oItemsComprobante = null;
    private ItemsComprobanteBl oBlItemComprobante = null;
    private ArrayList<ComprobanteDetalle> listItemcomp = null;
    private ComprobanteDetalle beanTablaItemComp = null;
    private FuncionVital oFuncionVital = null;
    private FuncionVitalBl oFuncionVitalBl = null;
    private Usuario usuario = null;
    private UsuarioBl oUsuarioBl = null;
    private Usuario userTemp;
    private Persona perTemp;
    private Rol rolTemp;
    private double imc;
    private String reporte;

    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;

    public JPanel_HistoriaClinica(JF_Principal root) {
        initComponents();
        this.root = root;
        inicioHora();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfNombres = new javax.swing.JTextField();
        txfEdad = new javax.swing.JTextField();
        cbxSexo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txfDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txfOcupacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jdcFechanacimiento = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txfTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txfGradoInstruccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txfLugarNacimiento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txfLugarProcedencia = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel36 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jdcFechaAtencion = new com.toedter.calendar.JDateChooser();
        jsHoraAtencion = new javax.swing.JSpinner();
        jButton12 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        txfHistoriaClinica = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel20 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txaAntFam = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        txaAntPer = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        rbtnNo = new javax.swing.JRadioButton();
        rbtnSi = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        txfAlergia = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txfPresionArt2 = new javax.swing.JTextField();
        txfPresionArt1 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txfTemperatura = new javax.swing.JTextField();
        txfr = new javax.swing.JTextField();
        txfp = new javax.swing.JTextField();
        txfPeso = new javax.swing.JTextField();
        txfImc = new javax.swing.JTextField();
        txfTalla = new javax.swing.JTextField();
        btnCancelarTab1 = new javax.swing.JButton();
        btnGuardarTab1 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        txfEnfermeria = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txfMotivoConsulta = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaAnamnesis = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaExamenClinicoDirigido = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txfDiagnostico = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txfDescCie10 = new javax.swing.JTextField();
        txfCodCie10 = new javax.swing.JTextField();
        btnBuscarCie10 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDiagnostico = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        txfExamenesAuxiliares = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExamenAuxiliar = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        txfTratamiento = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTratamiento = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txaObservaciones = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jdchFechaProxCita = new com.toedter.calendar.JDateChooser();
        jPanel13 = new javax.swing.JPanel();
        txfMedico = new javax.swing.JTextField();
        btnCancelarTab3 = new javax.swing.JButton();
        btnGuardarTab3 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnBuscarPaciente = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS GENERALES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Apellidos y Nombres :");

        jLabel2.setText("Edad :");

        jLabel3.setText("Sexo :");

        txfNombres.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfNombres.setEnabled(false);

        txfEdad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfEdad.setEnabled(false);
        txfEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfEdadActionPerformed(evt);
            }
        });

        cbxSexo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<SELECCIONE>", "MASCULINO", "FEMENINO" }));
        cbxSexo.setEnabled(false);

        jLabel4.setText("Dirección :");

        txfDireccion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfDireccion.setEnabled(false);

        jLabel5.setText("Ocupación :");

        txfOcupacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfOcupacion.setEnabled(false);

        jLabel6.setText("Fecha de Nacimiento :");

        jdcFechanacimiento.setEnabled(false);
        jdcFechanacimiento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel7.setText("Teléfono :");

        txfTelefono.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfTelefono.setEnabled(false);

        jLabel8.setText("Grado de Instrucción :");

        txfGradoInstruccion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfGradoInstruccion.setEnabled(false);

        jLabel9.setText("Lugar de Nacimiento :");

        txfLugarNacimiento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfLugarNacimiento.setEnabled(false);

        jLabel10.setText("Lugar de Procedencia :");

        txfLugarProcedencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfLugarProcedencia.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfDireccion)
                            .addComponent(txfNombres))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfOcupacion))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(1, 1, 1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(3, 3, 3)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jdcFechanacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txfLugarNacimiento))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfGradoInstruccion)
                            .addComponent(txfLugarProcedencia))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txfOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcFechanacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txfGradoInstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txfLugarNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txfLugarProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("CLÍNICA SANTA MARÍA MAGDALENA");
        jLabel35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 102, 102));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("HISTORIA CLÍNICA");

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FECHA Y HORA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jdcFechaAtencion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jsHoraAtencion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Refresh.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jdcFechaAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsHoraAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(480, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcFechaAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jsHoraAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HC N°", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txfHistoriaClinica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfHistoriaClinica.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfHistoriaClinica.setEnabled(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txfHistoriaClinica, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(txfHistoriaClinica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ANTECEDENTES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel11.setText("Antecedentes patológicos familiares :");

        jLabel12.setText("Antecedentes patológicos personales :");

        txaAntFam.setColumns(20);
        txaAntFam.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        txaAntFam.setRows(5);
        jScrollPane8.setViewportView(txaAntFam);

        txaAntPer.setColumns(20);
        txaAntPer.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        txaAntPer.setRows(5);
        jScrollPane9.setViewportView(txaAntPer);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addContainerGap())
                    .addComponent(jScrollPane8)
                    .addComponent(jScrollPane9)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel11)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ALERGIAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel16.setText("Alergia a algún medicamento :");

        buttonGroup1.add(rbtnNo);
        rbtnNo.setText("No");

        buttonGroup1.add(rbtnSi);
        rbtnSi.setText("Sí");

        jLabel17.setText("¿Cuál(es)? :");

        txfAlergia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnSi)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfAlergia))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(rbtnNo)
                    .addComponent(rbtnSi)
                    .addComponent(jLabel17)
                    .addComponent(txfAlergia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FUNCIONES VITALES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel18.setText("CFV : PA");

        jLabel19.setText("/");

        jLabel20.setText("T°");

        jLabel21.setText("C°");

        jLabel22.setText("R°");

        jLabel23.setText("x1");

        jLabel24.setText("P°");

        jLabel25.setText("X1");

        jLabel26.setText("Peso:");

        jLabel27.setText("Kg");

        jLabel28.setText("Talla:");

        jLabel29.setText("m");

        jLabel30.setText("IMC:");

        jLabel31.setText("kg/m2");

        txfPresionArt2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfPresionArt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfPresionArt2ActionPerformed(evt);
            }
        });

        txfPresionArt1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfPresionArt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfPresionArt1ActionPerformed(evt);
            }
        });

        jLabel37.setText("mmHg");

        txfTemperatura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfTemperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTemperaturaActionPerformed(evt);
            }
        });

        txfr.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfrActionPerformed(evt);
            }
        });

        txfp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfpActionPerformed(evt);
            }
        });

        txfPeso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfPesoActionPerformed(evt);
            }
        });

        txfImc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfImc.setEnabled(false);
        txfImc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfImcActionPerformed(evt);
            }
        });

        txfTalla.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfTalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTallaActionPerformed(evt);
            }
        });
        txfTalla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfTallaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txfPresionArt1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfPresionArt2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addGap(42, 42, 42)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addGap(51, 51, 51)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfr, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addGap(48, 48, 48)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addGap(53, 53, 53)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addGap(36, 36, 36)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addGap(38, 38, 38)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfImc, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(txfImc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(txfTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(txfp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(txfr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(txfTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(txfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(txfPresionArt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txfPresionArt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel37)))
                .addGap(3, 3, 3))
        );

        btnCancelarTab1.setText("Cancelar");

        btnGuardarTab1.setText("Guardar");
        btnGuardarTab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTab1ActionPerformed(evt);
            }
        });

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RESPONSABLE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txfEnfermeria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfEnfermeria.setEnabled(false);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txfEnfermeria, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txfEnfermeria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarTab1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelarTab1)
                .addGap(6, 6, 6))
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarTab1)
                    .addComponent(btnGuardarTab1))
                .addContainerGap())
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(344, 344, 344)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("ENFERMERIA", jPanel20);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MOTIVO DE CONSULTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txfMotivoConsulta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txfMotivoConsulta)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(txfMotivoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ANAMNESIS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txaAnamnesis.setColumns(20);
        txaAnamnesis.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        txaAnamnesis.setRows(5);
        jScrollPane3.setViewportView(txaAnamnesis);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EX. CLÍNICO DIRIGIDO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txaExamenClinicoDirigido.setColumns(20);
        txaExamenClinicoDirigido.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        txaExamenClinicoDirigido.setRows(5);
        jScrollPane4.setViewportView(txaExamenClinicoDirigido);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DIAGNÓSTICO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel32.setText("Diagnóstico : ");

        jLabel33.setText("CIE - 10 : ");

        txfDescCie10.setEnabled(false);

        txfCodCie10.setEnabled(false);

        btnBuscarCie10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        btnBuscarCie10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCie10ActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/remove.png"))); // NOI18N

        tblDiagnostico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tblDiagnostico);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txfDescCie10, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txfCodCie10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarCie10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txfDiagnostico)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txfDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfCodCie10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(txfDescCie10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarCie10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton7.setText("Siguiente");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton7))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7)
                .addContainerGap())
        );

        jTabbedPane1.addTab("MEDICO", jPanel21);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EXAMENES AUXILIARES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tblExamenAuxiliar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblExamenAuxiliar);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/remove.png"))); // NOI18N

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(txfExamenesAuxiliares)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txfExamenesAuxiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TRATAMIENTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tblTratamiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblTratamiento);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/remove.png"))); // NOI18N

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(txfTratamiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton8)
                        .addComponent(txfTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OBSERVACIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txaObservaciones.setColumns(20);
        txaObservaciones.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        txaObservaciones.setRows(5);
        jScrollPane7.setViewportView(txaObservaciones);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel12.setBackground(new java.awt.Color(202, 237, 228));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PROXIMA CITA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jdchFechaProxCita, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jdchFechaProxCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RESPONSABLE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txfMedico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfMedico.setEnabled(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txfMedico)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(txfMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        btnCancelarTab3.setText("Cancelar");
        btnCancelarTab3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTab3ActionPerformed(evt);
            }
        });

        btnGuardarTab3.setText("Guardar");
        btnGuardarTab3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTab3ActionPerformed(evt);
            }
        });

        jButton10.setText("Anterior");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarTab3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarTab3))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarTab3)
                    .addComponent(btnGuardarTab3)
                    .addComponent(jButton10)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jTabbedPane1.addTab("MEDICO", jPanel23);

        btnBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarPaciente))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnBuscarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txfEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEdadActionPerformed

    private void btnBuscarCie10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCie10ActionPerformed
        buscarCie10(JIF_AdminCie10.JIF_HCAMBULATORIA);
    }//GEN-LAST:event_btnBuscarCie10ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (IsDatosValidosDiagnostico()) {
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el diagnóstico", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
        this.txfDiagnostico.setText("");
        this.txfCodCie10.setText("");
        this.txfDescCie10.setText("");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txfPresionArt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPresionArt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPresionArt2ActionPerformed

    private void txfPresionArt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPresionArt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPresionArt1ActionPerformed

    private void txfTemperaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTemperaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTemperaturaActionPerformed

    private void txfrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfrActionPerformed

    private void txfpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfpActionPerformed

    private void txfPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPesoActionPerformed

    private void txfImcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfImcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfImcActionPerformed

    private void txfTallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTallaActionPerformed

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        buscarHistoriaClinica(JIF_BuscarHistoriaClinica.JIF_HISTORIA_CLINICA);
        //root.insertarInternalFrames(root.jifBuscarHC);
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void btnGuardarTab3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTab3ActionPerformed
        if (isDatosValidos()) {
            registrar();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese todos los campos", "Atención", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarTab3ActionPerformed

    private void btnCancelarTab3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTab3ActionPerformed
        resetComponentFull();
        estadoComponentFull(true);
    }//GEN-LAST:event_btnCancelarTab3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (!txfExamenesAuxiliares.getText().trim().equals("")) {
            resetComponentExamen();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un examen", "Atención", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnGuardarTab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTab1ActionPerformed
        guardarTab1();
    }//GEN-LAST:event_btnGuardarTab1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        inicioHora();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (!txfTratamiento.getText().trim().equals("")) {
            personalizaTablaTratamiento();
            resetComponentTratamiento();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese tratamiento", "Atención", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (oAtencionhc != null) {
            if (oAtencionhc.getTipoAtencion().equals("PRIMERA ATENCIÓN")) {
                reporte = "HistoriaClinicaAmbulatoria";
            } else {
                reporte = "HistoriaClinicaAmbulatoriaRev";
            }
            imprimir(oAtencionhc);
            resetComponentFull();
            estadoComponentFull(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txfTallaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTallaKeyReleased
        double peso = Double.parseDouble(txfPeso.getText().trim());
        double talla = Double.parseDouble(txfTalla.getText().trim());
        double talla2 = Math.pow(talla, 2);
        imc = peso / talla2;
        txfImc.setText("" + Utilitarios.Redondear(imc, 2));
    }//GEN-LAST:event_txfTallaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarCie10;
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnCancelarTab1;
    private javax.swing.JButton btnCancelarTab3;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarTab1;
    private javax.swing.JButton btnGuardarTab3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbxSexo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdcFechaAtencion;
    private com.toedter.calendar.JDateChooser jdcFechanacimiento;
    private com.toedter.calendar.JDateChooser jdchFechaProxCita;
    private javax.swing.JSpinner jsHoraAtencion;
    private javax.swing.JRadioButton rbtnNo;
    private javax.swing.JRadioButton rbtnSi;
    private javax.swing.JTable tblDiagnostico;
    private javax.swing.JTable tblExamenAuxiliar;
    private javax.swing.JTable tblTratamiento;
    private javax.swing.JTextArea txaAnamnesis;
    private javax.swing.JTextArea txaAntFam;
    private javax.swing.JTextArea txaAntPer;
    private javax.swing.JTextArea txaExamenClinicoDirigido;
    private javax.swing.JTextArea txaObservaciones;
    private javax.swing.JTextField txfAlergia;
    private javax.swing.JTextField txfCodCie10;
    private javax.swing.JTextField txfDescCie10;
    private javax.swing.JTextField txfDiagnostico;
    private javax.swing.JTextField txfDireccion;
    private javax.swing.JTextField txfEdad;
    private javax.swing.JTextField txfEnfermeria;
    private javax.swing.JTextField txfExamenesAuxiliares;
    private javax.swing.JTextField txfGradoInstruccion;
    private javax.swing.JTextField txfHistoriaClinica;
    private javax.swing.JTextField txfImc;
    private javax.swing.JTextField txfLugarNacimiento;
    private javax.swing.JTextField txfLugarProcedencia;
    private javax.swing.JTextField txfMedico;
    private javax.swing.JTextField txfMotivoConsulta;
    private javax.swing.JTextField txfNombres;
    private javax.swing.JTextField txfOcupacion;
    private javax.swing.JTextField txfPeso;
    private javax.swing.JTextField txfPresionArt1;
    private javax.swing.JTextField txfPresionArt2;
    private javax.swing.JTextField txfTalla;
    private javax.swing.JTextField txfTelefono;
    private javax.swing.JTextField txfTemperatura;
    private javax.swing.JTextField txfTratamiento;
    private javax.swing.JTextField txfp;
    private javax.swing.JTextField txfr;
    // End of variables declaration//GEN-END:variables

    void cargarDatosHistoriaClinica(HistoriaClinica beanTabla) {
        resetComponentFull();
        estadoComponentFull(true);
        cargarDatosGenerales(beanTabla);
    }

    void cargarDatosGenerales(HistoriaClinica beanTabla) {
        oHistoriaClinica = beanTabla;
        txfNombres.setText(oHistoriaClinica.getPersona().getApellidoPaterno() + " "
                + oHistoriaClinica.getPersona().getApellidoMaterno() + " " + oHistoriaClinica.getPersona().getNombre());
        txfHistoriaClinica.setText(oHistoriaClinica.getNumerohc().toString());
        if (oHistoriaClinica.getPersona().getSexo() == null || oHistoriaClinica.getPersona().getSexo().equals("")) {
            this.cbxSexo.setSelectedIndex(0);
        } else {
            this.cbxSexo.setSelectedItem(oHistoriaClinica.getPersona().getSexo());
        }
        txfDireccion.setText(oHistoriaClinica.getPersona().getDireccion());
        txfOcupacion.setText(oHistoriaClinica.getPersona().getOcupacion());
        jdcFechanacimiento.setDate(oHistoriaClinica.getPersona().getFechaNacimiento());
        txfTelefono.setText(oHistoriaClinica.getPersona().getTelefono());
        txfGradoInstruccion.setText(oHistoriaClinica.getPersona().getGradoInstruccion());
        txfLugarNacimiento.setText(oHistoriaClinica.getPersona().getLugarNacimiento());
        txfLugarProcedencia.setText(oHistoriaClinica.getPersona().getLugarProcedencia());
        if (oHistoriaClinica.getPersona().getFechaNacimiento() != null) {
            txfEdad.setText("" + Utilitarios.obtenerEdad(oHistoriaClinica.getPersona().getFechaNacimiento()));
        } else {
            txfEdad.setText("");
        }
        //cargar los datos del usuario logueado
        txfEnfermeria.setText(perTemp.getNombre().trim() + " " + perTemp.getApellidoPaterno().trim() + " " + perTemp.getApellidoMaterno().trim());
        //personalizar formato de las tablas
    }

    void cargarCie10(Cie10 beanTabla) {
        oCie10 = beanTabla;

        this.txfCodCie10.setText(oCie10.getCodigo().trim());
        this.txfDescCie10.setText(oCie10.getDescripcion().trim());
    }


    private boolean IsDatosValidosDiagnostico() {
        return (!txfDiagnostico.getText().toUpperCase().trim().equals("")
                && !txfDescCie10.getText().toUpperCase().trim().equals("")
                && !txfCodCie10.getText().toUpperCase().trim().equals(""));
    }

    private void inicioHora() {
        Calendar calendar = Calendar.getInstance();//Variable de Objeto Calendar        
        //fecha de sistema
        jdcFechaAtencion.setCalendar(calendar);
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
        jsHoraAtencion.setModel(horaModel);
        jsHoraAtencion.setEditor(new JSpinner.DateEditor(jsHoraAtencion, "HH:mm:ss"));
    }

    private boolean isDatosValidos() {
        return (!this.txfNombres.getText().trim().equals("")
                && !this.txfHistoriaClinica.getText().trim().equals("")
                && this.jdcFechaAtencion.getDate() != null
                && this.jsHoraAtencion.getValue() != null);
    }

    private void registrar() {
        if (oAtencionhc != null) {
            oAtencionBl = new AtencionBl();
            oAtencionhc.setIdUsuarioMed(userTemp.getIdUsuario());
            oAtencionBl.actualizar(oAtencionhc);
        }
        JOptionPane.showMessageDialog(null, "Registro correcto", "Atención", JOptionPane.INFORMATION_MESSAGE);
    }

    private Atencionhc registrarAtencion() {
        oAtencionhc = new Atencionhc();
        oAtencionBl = new AtencionBl();

        //obtenmos la hora en string
        oAtencionhc.setFechaAtencion(jdcFechaAtencion.getDate());
//        Date ahora = new Date(jsHora.getValue().toString());
//        SimpleDateFormat formatHora = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
        oAtencionhc.setHoraAtencion(hour.format(jsHoraAtencion.getValue()));
        //oAtencion.setHoraAtencion(jsHora.getValue().toString());
        oAtencionhc.setHistoriaClinica(oHistoriaClinica);
        oAtencionhc.setIdUsuarioEnf(userTemp.getIdUsuario());
        if (oHistoriaClinica.getAtencionhcs().isEmpty()) {
            oAtencionhc.setTipoAtencion("PRIMERA ATENCIÓN");
        } else {
            oAtencionhc.setTipoAtencion("REEVALUACION");
        }
        if (!txfEdad.getText().trim().equals("")) {
            oAtencionhc.setEdad(Integer.parseInt(txfEdad.getText().trim()));
        }

        return oAtencionBl.registrar(oAtencionhc);

    }


    private void buscarHistoriaClinica(int JIF_HISTORIA_CLINICA) {
        root.jifBuscarHC.setInvocador(JIF_HISTORIA_CLINICA);
        root.insertarInternalFrames(root.jifBuscarHC);
    }


    private void registrarFuncionVital() {
        oFuncionVital = new FuncionVital();
        oFuncionVitalBl = new FuncionVitalBl();
        oFuncionVital.setAtencionhc(oAtencionhc);
        oFuncionVital.setPresionArterial(Integer.parseInt(txfPresionArt1.getText().trim()));
        oFuncionVital.setPresionArterial2(Integer.parseInt(txfPresionArt2.getText().trim()));
        oFuncionVital.setTemperatura(Double.valueOf(txfTemperatura.getText().trim()));
        oFuncionVital.setR(Double.valueOf(txfr.getText().trim()));
        oFuncionVital.setP(Double.valueOf(txfp.getText().trim()));
        oFuncionVital.setPeso(Double.valueOf(txfPeso.getText().trim()));
        oFuncionVital.setTalla(Double.valueOf(txfTalla.getText().trim()));
        oFuncionVital.setImc(Double.valueOf(txfImc.getText().trim()));
        oFuncionVitalBl.registrar(oFuncionVital);
    }


    void cargardatosCie10(Cie10 cie10) {
        oCie10 = cie10;
        txfDescCie10.setText(oCie10.getDescripcion().toUpperCase());
        txfCodCie10.setText(oCie10.getCodigo().toUpperCase());
    }



    private void resetComponentExamen() {
        txfExamenesAuxiliares.setText("");
    }

    private void guardarTab1() {
        if (isdatosValidostab1()) {
            registrarAtencion();
            registrarFuncionVital();
            JOptionPane.showMessageDialog(null, "Registro exitoso", "Atención", JOptionPane.INFORMATION_MESSAGE);
            resetComponentTab1();
            resetComponentGenerales();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos", "Atención", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isdatosValidostab1() {
        return (jdcFechaAtencion.getDate() != null
                && jsHoraAtencion.getValue() != null
                && !txfHistoriaClinica.getText().equals("")
                && oHistoriaClinica != null
                && !txfPresionArt1.getText().equals("")
                && !txfPresionArt2.getText().equals("")
                && !txfTemperatura.getText().equals("")
                && !txfr.getText().equals("")
                && !txfp.getText().equals("")
                && !txfPeso.getText().equals("")
                && !txfTalla.getText().equals("")
                && !txfImc.getText().equals(""));
    }

    private void resetComponentTab1() {
        this.txaAntFam.setText("");
        this.txaAntPer.setText("");
        this.rbtnNo.setSelected(false);
        this.rbtnSi.setSelected(false);
        this.txfAlergia.setText("");
        this.txfPresionArt1.setText("");
        this.txfPresionArt2.setText("");
        this.txfTemperatura.setText("");
        this.txfr.setText("");
        this.txfp.setText("");
        this.txfPeso.setText("");
        this.txfTalla.setText("");
        this.txfImc.setText("");
    }

    private void resetComponentGenerales() {
        inicioHora();
        this.txfHistoriaClinica.setText("");
        this.txfNombres.setText("");
        this.txfEdad.setText("");
        this.cbxSexo.setSelectedIndex(0);
        this.txfDireccion.setText("");
        this.txfOcupacion.setText("");
        this.jdcFechanacimiento.setDate(null);
        this.txfTelefono.setText("");
        this.txfGradoInstruccion.setText("");
        this.txfLugarNacimiento.setText("");
        this.txfLugarProcedencia.setText("");
    }

    private void resetComponentTab2() {
        this.txfMotivoConsulta.setText("");
        this.txaAnamnesis.setText("");
        this.txaExamenClinicoDirigido.setText("");
        this.txfDiagnostico.setText("");
        this.txfCodCie10.setText("");
        this.txfDescCie10.setText("");
    }

    private void resetComponentTab3() {
        txfExamenesAuxiliares.setText("");
        txaObservaciones.setText("");
        jdchFechaProxCita.setDate(null);
        txfMedico.setText("");
    }

    void cargarDatosHistorial(Atencionhc atencion) {
        cargarAtencion(atencion);
        //bloquear intergaz
        if (atencion != null) {
            estadoComponentAtencion(false);
        } else {
            estadoComponentAtencion(true);
        }
    }

    void cargarAtencion(Atencionhc atencion) {
        this.oAtencionhc = atencion;
        jdcFechaAtencion.setDate(oAtencionhc.getFechaAtencion());
        //visualizar la hora en la historia clinica
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("HH:mm:ss");
        String hora = oAtencionhc.getHoraAtencion();
        Date horaAct = null;
        try {
            horaAct = formatoDelTexto.parse(hora);
            jsHoraAtencion.setValue(horaAct);
        } catch (ParseException ex) {
            Logger.getLogger(JPanel_HistoriaClinica.class.getName()).log(Level.SEVERE, null, ex);
        }
        //fin
        //cargar los datos del personal de enfermeria (triaje) que   hizo el registro
        cargarDatosPersonal(oAtencionhc.getIdUsuarioEnf());
        //cargar detalle de historia clinica segun fecha de atencion seleccionada
        cargarDetalleHistoriaClinica(oAtencionhc);
        //cargar datos del personal de enfermeria quien hizo el registro

    }

    private void cargarDatosPersonal(long idUser) {
        oUsuarioBl = new UsuarioBl();
        usuario = oUsuarioBl.buscarXid(idUser);
        if (usuario != null) {
            txfEnfermeria.setText(usuario.getPersona().getNombre().trim() + " " + usuario.getPersona().getApellidoPaterno().trim() + " " + usuario.getPersona().getApellidoMaterno().trim());
        }
    }

    private void cargarDetalleHistoriaClinica(Atencionhc oAtencion) {
        //cargar datos del personal si  ya lo registro
        if (oAtencion.getIdUsuarioMed() != 0 && oAtencion.getIdUsuarioMed() != 0) {
            //cargar datos
            oUsuarioBl = new UsuarioBl();
            usuario = oUsuarioBl.buscarXid(oAtencion.getIdUsuarioMed());
            if (usuario != null) {
                txfMedico.setText(usuario.getPersona().getNombre().trim() + " " + usuario.getPersona().getApellidoPaterno().trim() + " " + usuario.getPersona().getApellidoMaterno().trim());
            }
        } else {
            //no cargar datos
            System.out.println("no carga los datos ..");
        }
        cargarFuncionVital(oAtencion);
    }


    private void cargarFuncionVital(Atencionhc oAtencion) {
        oFuncionVital = new FuncionVital();
        oFuncionVitalBl = new FuncionVitalBl();
        oFuncionVital = oFuncionVitalBl.buscar(oAtencion);
        if (oFuncionVital != null) {
            txfPresionArt1.setText(oFuncionVital.getPresionArterial().toString());
            txfPresionArt2.setText(oFuncionVital.getPresionArterial2().toString());
            txfTemperatura.setText(oFuncionVital.getTemperatura().toString());
            txfr.setText(oFuncionVital.getR().toString());
            txfp.setText(oFuncionVital.getP().toString());
            txfPeso.setText(oFuncionVital.getPeso().toString());
            txfTalla.setText(oFuncionVital.getTalla().toString());
            txfImc.setText(oFuncionVital.getImc().toString());
            estadoComponentFuncionVital(false);
        } else {
            estadoComponentFuncionVital(true);
        }
    }

    private void personalizaTablaTratamiento() {
        Utilitarios.formateaColumna(0, tblTratamiento, 80);
    }

    private void resetComponentTratamiento() {
        txfTratamiento.setText("");
    }

    private void resetComponentFull() {
        resetComponentGenerales();
        resetComponentTab1();
        resetComponentTab2();
        resetComponentTab3();
    }

    void resetComponentTodo() {
        resetComponentFull();
    }

    void cargarDatosUser(Usuario user, Persona oPersona, Rol oRol) {
        userTemp = user;
        perTemp = oPersona;
        rolTemp = oRol;

    }

    private void estadoComponentAtencion(boolean b) {
        jdcFechaAtencion.setEnabled(b);
        jsHoraAtencion.setEnabled(b);
        btnGuardarTab1.setEnabled(b);
    }

    private void estadoComponentAntecedentes(boolean b) {
        txaAntPer.setEnabled(b);
        txaAntFam.setEnabled(b);
    }

    private void estadoComponentAlergia(boolean b) {
        txfAlergia.setEnabled(b);
    }

    private void estadoComponentFuncionVital(boolean b) {
        txfPresionArt1.setEnabled(b);
        txfPresionArt2.setEnabled(b);
        txfTemperatura.setEnabled(b);
        txfr.setEnabled(b);
        txfp.setEnabled(b);
        txfPeso.setEnabled(b);
        txfTalla.setEnabled(b);
        txfImc.setEnabled(b);
    }

    private void estadoComponentAnamnesis(boolean b) {
        txaAnamnesis.setEnabled(b);
        txfMotivoConsulta.setEnabled(b);
        txaExamenClinicoDirigido.setEnabled(b);

    }

    private void estadoComponentDatoAdicional(boolean b) {
        txaObservaciones.setEnabled(b);
        jdchFechaProxCita.setEnabled(b);

    }

    private void estadoComponentExamenAuxiliar(boolean b) {
        txfExamenesAuxiliares.setEnabled(b);
    }

    private void estadoComponentTratamiento(boolean b) {
        txfTratamiento.setEnabled(b);
    }

    private void estadoComponentDiagnostico(boolean b) {
        txfDiagnostico.setEnabled(b);
    }

    private void estadoComponentFull(boolean b) {
        estadoComponentAtencion(b);
        estadoComponentAntecedentes(b);
        estadoComponentAlergia(b);
        estadoComponentFuncionVital(b);
        estadoComponentAnamnesis(b);
        estadoComponentDatoAdicional(b);
        estadoComponentExamenAuxiliar(b);
        estadoComponentTratamiento(b);
        estadoComponentDiagnostico(b);
    }

    private void imprimir(Atencionhc atencion) {

        try {
            //Si es el primer ingreso imprimir la primera pagina completa
            ds = new DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport(reporte, new String[]{"NUN_HC", "FECHA"}, new Object[]{Integer.parseInt(txfHistoriaClinica.getText().trim()), atencion.getFechaAtencion()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Historia Clinica Digital");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
            //si es re evaluacion imprimir solo detalle de la atencion
        } catch (PropertyVetoException ex) {
            Logger.getLogger(JPanel_HistoriaClinica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JPanel_HistoriaClinica.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void buscarCie10(int JIF_HCAMBULATORIA) {
        root.jifAdminCie10.setInvocador(JIF_HCAMBULATORIA);
        root.insertarInternalFrames(root.jifAdminCie10);
    }

}
