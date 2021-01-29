package lissa.gui;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import lissa.be.Atencionhc;
import lissa.be.HistoriaClinica;
import lissa.be.Persona;
import lissa.bl.AtencionBl;
import lissa.bl.PersonaBl;
import lissa.bl.HistoriaClinicaBl;
import lissa.table.ModeloAtencionhc;
import lissa.table.ModeloHistoriaClinica;
import lissa.util.Utilitarios;

public class JIF_BuscarHistoriaClinica extends javax.swing.JInternalFrame {

    private JF_Principal root = null;
    private HistoriaClinica oHistoriaClinica = null;
    private HistoriaClinicaBl oBlHistoriaClinica = null;
    private ModeloHistoriaClinica oModeloHistoriaClinica = null;
    private ArrayList<HistoriaClinica> listHistoria;
    private HistoriaClinica beanTabla = null;
    private ModeloAtencionhc oModeloAtencion = null;
    private Persona oPersona = null;
    private PersonaBl oPersonaBl = null;
    private Atencionhc oAtencionhc = null;
    private AtencionBl oAtencionBl = null;
    private ArrayList<Atencionhc> listAtenciones = null;

    private int invocador;

    public static final int JIF_REGISTRAR_DIAGNOSTICO = 1;
    public static final int JIF_HISTORIA_CLINICA = 2;
    public static final int REGISTRAR = 1;
    public static final int EDITAR = 2;
    private int banBoton = 0;

    public JIF_BuscarHistoriaClinica(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloHistoriaClinica = new ModeloHistoriaClinica();
        tblResultados.setModel(oModeloHistoriaClinica);
        oModeloAtencion = new ModeloAtencionhc();
        tblAtenciones.setModel(oModeloAtencion);
        personalizaTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bntCargar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txfRef = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cbxBuscarPor = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAtenciones = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txfApePaterno = new javax.swing.JTextField();
        txfApeMaterno = new javax.swing.JTextField();
        txfNombres = new javax.swing.JTextField();
        txfNumDni = new javax.swing.JTextField();
        txfHistoriaClinica = new javax.swing.JTextField();
        txfDireccion = new javax.swing.JTextField();
        txfTelefono = new javax.swing.JTextField();
        txfOcupacion = new javax.swing.JTextField();
        txfGradoInstruccion = new javax.swing.JTextField();
        txfLugarNacimiento = new javax.swing.JTextField();
        txfLugarProcedencia = new javax.swing.JTextField();
        jdcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        cbxSexo = new javax.swing.JComboBox();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Buscar Historia Clinica");
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

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        bntCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/arrow.png"))); // NOI18N
        bntCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCargarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCAR HISTORIA CLINICA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setText("Valor :");

        txfRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfRefActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

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
        tblResultados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblResultadosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultados);

        jLabel4.setText("Buscar por :");

        cbxBuscarPor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Apellidos y Nombres", "N° DNI", "N° HC" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfRef, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cbxBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txfRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTROS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tblAtenciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblAtenciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblAtencionesMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblAtenciones);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL PACIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Apellido Paterno :");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Apellido Materno :");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nombres :");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Fecha de Nacimiento :");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Historia Clínica :");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("DNI :");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Dirección :");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Telefono :");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Sexo :");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Ocupación :");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Grado de Instrucción :");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Lugar de Nacimiento :");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Lugar de Procedencia :");

        txfApePaterno.setEnabled(false);

        txfApeMaterno.setEnabled(false);

        txfNombres.setEnabled(false);
        txfNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombresActionPerformed(evt);
            }
        });

        txfNumDni.setEnabled(false);

        txfHistoriaClinica.setEnabled(false);

        txfDireccion.setEnabled(false);

        txfTelefono.setEnabled(false);

        txfOcupacion.setEnabled(false);

        txfGradoInstruccion.setEnabled(false);

        txfLugarNacimiento.setEnabled(false);

        txfLugarProcedencia.setEnabled(false);

        jdcFechaNacimiento.setEnabled(false);

        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<SELECCIONE>", "MASCULINO", "FEMENINO" }));
        cbxSexo.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfApePaterno)
                    .addComponent(txfApeMaterno)
                    .addComponent(txfNombres)
                    .addComponent(txfNumDni)
                    .addComponent(txfHistoriaClinica)
                    .addComponent(txfDireccion)
                    .addComponent(txfTelefono)
                    .addComponent(txfOcupacion)
                    .addComponent(txfGradoInstruccion)
                    .addComponent(txfLugarNacimiento)
                    .addComponent(txfLugarProcedencia)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cbxSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfApePaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfApeMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txfNumDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txfHistoriaClinica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txfOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txfGradoInstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txfLugarNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txfLugarProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/edit.png"))); // NOI18N
        btnEditar.setPreferredSize(new java.awt.Dimension(65, 40));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Save.png"))); // NOI18N
        btnGuardar.setPreferredSize(new java.awt.Dimension(65, 40));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/cancel.png"))); // NOI18N
        btnCancelar.setPreferredSize(new java.awt.Dimension(65, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(286, 286, 286)
                                .addComponent(bntCargar))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bntCargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseReleased
        if (tblResultados.getRowSelectionAllowed()) {
            obtenerDatos();
        }
    }//GEN-LAST:event_tblResultadosMouseReleased

    private void bntCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCargarActionPerformed
        //Cargar datos basicos
        if (tblResultados.getSelectedRow() != -1 && tblAtenciones.getSelectedRow() == -1) {
            cargarDatosPersona();
            this.doDefaultCloseAction();
            //resetComponent();
            beanTabla = null;
        } else if (tblResultados.getSelectedRow() != -1 && tblAtenciones.getSelectedRow() != -1) {
            cargarDatosPersona();
            cargarHistorial();
            this.doDefaultCloseAction();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una persona", "Atencion", JOptionPane.INFORMATION_MESSAGE);
        }
        //cagar historial de historia clinica por fecha seleccionada

//        if (beanTabla == null || beanTabla.getIdhistoriaclinica() == 0) {
//            JOptionPane.showMessageDialog(null, "Seleccione una persona", "Atencion2", JOptionPane.INFORMATION_MESSAGE);
//        } else {
//            cargarDatosPersona();
//            this.doDefaultCloseAction();
//            //resetComponent();
//            beanTabla = null;
//        }
    }//GEN-LAST:event_bntCargarActionPerformed

    private void txfRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfRefActionPerformed
        btnBuscar.doClick();
    }//GEN-LAST:event_txfRefActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarHistoriaClinica();
        personalizaTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        personalizaTabla();
        resetComponent();
        estadoComponentes(false);
    }//GEN-LAST:event_formInternalFrameClosing

    private void tblResultadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblResultadosKeyReleased
        int code = evt.getKeyCode();
        char caracter = evt.getKeyChar();
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            //obtenerDatos();
            if (code == KeyEvent.VK_ENTER) {//cargar datos  al JIF que lo llama                
                if (beanTabla != null) {
                    cargarDatosPersona();
                    this.doDefaultCloseAction();
                    oModeloHistoriaClinica.clear();
                    beanTabla = null;
                }
            }
        }
    }//GEN-LAST:event_tblResultadosKeyReleased

    private void txfNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombresActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblResultados.getSelectedRow() != -1) {
            configuraActualizar();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una persona", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        configuraGuardar();
        resetComponent();
        estadoComponentes(false);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        resetComponent();
        estadoComponentes(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblAtencionesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAtencionesMouseReleased
        if (tblAtenciones.getRowSelectionAllowed() && tblAtenciones.getSelectedRow() != -1) {
            oAtencionhc = oModeloAtencion.get(tblAtenciones.getSelectedRow());
        }
    }//GEN-LAST:event_tblAtencionesMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntCargar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbxBuscarPor;
    private javax.swing.JComboBox cbxSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcFechaNacimiento;
    private javax.swing.JTable tblAtenciones;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txfApeMaterno;
    private javax.swing.JTextField txfApePaterno;
    private javax.swing.JTextField txfDireccion;
    private javax.swing.JTextField txfGradoInstruccion;
    private javax.swing.JTextField txfHistoriaClinica;
    private javax.swing.JTextField txfLugarNacimiento;
    private javax.swing.JTextField txfLugarProcedencia;
    private javax.swing.JTextField txfNombres;
    private javax.swing.JTextField txfNumDni;
    private javax.swing.JTextField txfOcupacion;
    private javax.swing.JTextField txfRef;
    private javax.swing.JTextField txfTelefono;
    // End of variables declaration//GEN-END:variables

    private void buscarHistoriaClinica() {
        oBlHistoriaClinica = new HistoriaClinicaBl();
        String ref = "";
        if (!txfRef.getText().equals("")) {
            ref = txfRef.getText().trim().toUpperCase();
            listHistoria = oBlHistoriaClinica.buscar(ref);
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un parámetro de búsqueda", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
        if (listHistoria.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen resultados", "Atención", JOptionPane.INFORMATION_MESSAGE);
        } else {
            oModeloHistoriaClinica.addAll(listHistoria);
        }

        txfRef.setText("");
        //personalizarTabla();
    }

    private void obtenerDatos() {
        beanTabla = (HistoriaClinica) oModeloHistoriaClinica.get(tblResultados.getSelectedRow());
        /*
         cargamos los datos del paciente seleccionado a los campos que corresponde, 
         para  su actualizacion de ser necesario
         */
        txfApePaterno.setText(beanTabla.getPersona().getApellidoPaterno());
        txfApeMaterno.setText(beanTabla.getPersona().getApellidoMaterno());
        txfNombres.setText(beanTabla.getPersona().getNombre());
        jdcFechaNacimiento.setDate(beanTabla.getPersona().getFechaNacimiento());
        txfNumDni.setText(beanTabla.getPersona().getNumeroDocumento());
        if (beanTabla.getPersona().getSexo() == null || beanTabla.getPersona().getSexo().equals("")) {
            this.cbxSexo.setSelectedIndex(0);
        } else {
            this.cbxSexo.setSelectedItem(beanTabla.getPersona().getSexo());
        }
        txfHistoriaClinica.setText(beanTabla.getNumerohc().toString());
        txfDireccion.setText(beanTabla.getPersona().getDireccion());
        txfTelefono.setText(beanTabla.getPersona().getTelefono());
        txfOcupacion.setText(beanTabla.getPersona().getOcupacion());
        txfGradoInstruccion.setText(beanTabla.getPersona().getGradoInstruccion());
        txfLugarNacimiento.setText(beanTabla.getPersona().getLugarNacimiento());
        txfLugarProcedencia.setText(beanTabla.getPersona().getLugarProcedencia());
        //Se lista todas los registros de historia clinica del paciente por fecha y hora
        listarAtenciones();
    }

    private void cargarDatosPersona() {
        switch (getInvocador()) {
            case JIF_HISTORIA_CLINICA:
                root.jifHistoriaClinica.cargarDatosHistoriaClinica(beanTabla);
                break;
        }
    }

    public int getInvocador() {
        return invocador;
    }

    public void setInvocador(int invocador) {
        this.invocador = invocador;
    }

    private void personalizaTabla() {
        Utilitarios.formateaColumna(0, tblResultados, 80);
        Utilitarios.formateaColumna(2, tblResultados, 80);
        Utilitarios.formateaColumna(3, tblResultados, 80);
    }

    private void listarAtenciones() {
        oAtencionBl = new AtencionBl();
        oModeloAtencion.clear();
        listAtenciones = oAtencionBl.listar(beanTabla);
        if (!listAtenciones.isEmpty()) {
            oModeloAtencion.addAll(listAtenciones);
        }
//        if (!beanTabla.getAtencions().isEmpty()) {
//            for (Atencion2 atencion : beanTabla.getAtencions()) {
//                oModeloAtencion.add(atencion);
//            }
//        }
    }

    private void configuraActualizar() {
        banBoton = EDITAR;
        estadoComponentes(true);
    }

    private void estadoComponentes(boolean b) {
        txfApePaterno.setEnabled(b);
        txfApeMaterno.setEnabled(b);
        txfNombres.setEnabled(b);
        jdcFechaNacimiento.setEnabled(b);
        txfNumDni.setEnabled(b);
        cbxSexo.setEnabled(b);
        txfDireccion.setEnabled(b);
        txfTelefono.setEnabled(b);
        txfOcupacion.setEnabled(b);
        txfGradoInstruccion.setEnabled(b);
        txfLugarNacimiento.setEnabled(b);
        txfLugarProcedencia.setEnabled(b);
    }

    private void configuraGuardar() {
        if (banBoton == EDITAR) {
            if (isDatosValidos()) {
                if (actualizar() != 0) {
                    JOptionPane.showMessageDialog(null, "Actualización Exitosa", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    //oModeloHistoriaClinica.add(beanTabla);
                } else {
                    JOptionPane.showMessageDialog(null, "Error durante la actualización", "Atención", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos", "Atención", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private boolean isDatosValidos() {
        return true;
    }

    private int actualizar() {
        //Se crea los objetos  aser  utilizados en el metodo
        oPersona = new Persona();
        oPersonaBl = new PersonaBl();

        oPersona.setIdpersona(beanTabla.getPersona().getIdpersona());
        oPersona.setApellidoPaterno(txfApePaterno.getText().toUpperCase().trim());
        oPersona.setApellidoMaterno(txfApeMaterno.getText().toUpperCase().trim());
        oPersona.setNombre(txfNombres.getText().toUpperCase().trim());
        oPersona.setFechaNacimiento(jdcFechaNacimiento.getDate());
        oPersona.setNumeroDocumento(txfNumDni.getText().trim());
        oPersona.setSexo(cbxSexo.getSelectedItem().toString());
        oPersona.setDireccion(txfDireccion.getText().toUpperCase().trim());
        oPersona.setTelefono(txfTelefono.getText().toUpperCase().trim());
        oPersona.setOcupacion(txfOcupacion.getText().toUpperCase().trim());
        oPersona.setGradoInstruccion(txfGradoInstruccion.getText().toUpperCase().trim());
        oPersona.setLugarNacimiento(txfLugarNacimiento.getText().toUpperCase().trim());
        oPersona.setLugarProcedencia(txfLugarProcedencia.getText().toUpperCase().trim());

        return oPersonaBl.actualizar(oPersona);
    }

    private void resetComponent() {
        txfApePaterno.setText("");
        txfApeMaterno.setText("");
        txfNombres.setText("");
        jdcFechaNacimiento.setDate(null);
        txfNumDni.setText("");
        cbxSexo.setSelectedIndex(0);
        txfHistoriaClinica.setText("");
        txfDireccion.setText("");
        txfTelefono.setText("");
        txfOcupacion.setText("");
        txfGradoInstruccion.setText("");
        txfLugarNacimiento.setText("");
        txfLugarProcedencia.setText("");
        txfRef.setText("");
        oModeloAtencion.clear();
        oModeloHistoriaClinica.clear();
        cbxBuscarPor.setSelectedIndex(0);
    }

//    private Atencion2 obtenerAtencion() {
//        oAtencionBl = new AtencionBl();
//        return oAtencionBl.buscarUltimaAtencion(beanTabla.getIdhistoriaclinica());
//    }
    private void cargarHistorial() {
        root.jifHistoriaClinica.cargarDatosHistorial(oAtencionhc);
    }
}
