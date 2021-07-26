package lissa.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.Especialidad;
import lissa.be.Medico;
import lissa.be.MedicoEspecialidad;
import lissa.be.Persona;
import lissa.be.TipoMedico;
import lissa.bl.PersonaBl;
import lissa.bl.EspecialidadBl;
import lissa.bl.MedicoBl;
import lissa.bl.MedicoEspecialidadBl;
import lissa.bl.TipoMedicoBl;
import lissa.bl.TipoPersonaBl;
import lissa.table.ModeloMedicoEspecialidad;
import lissa.table.ModeloMedico;
import lissa.table.ModeloPersonas;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Constants;

public class JIF_AdministrarMedico extends javax.swing.JInternalFrame {

    private JF_Principal root = null;
    private int banBoton = 0;
    private Persona oPersona = null;
    private Medico oMedico = null;
    private PersonaBl oBLPersona = null;
    private MedicoBl oBlMedico = null;
    private TipoMedicoBl oBlTipoMedico = null;
    private List<TipoMedico> listTipoMedico = null;
    private Especialidad oEspecialidad = null;
    private MedicoEspecialidad medicoEspecialidad = null;
    private EspecialidadBl oBlEspecialidad = null;
    private List<Especialidad> listEspecialidad = null;
    private ModeloMedicoEspecialidad oModeloMedicoEspecialidad = null;
    private MedicoEspecialidad oMedicoEspecialidad = null;
    private MedicoEspecialidadBl oBlMedicoEspecialidad = null;
    private ModeloMedico oModeloMedico = null;
    private Persona beanTabla = null;
    private Medico beanTablaM = null;
    private TipoMedico beanTablaTipoMedico = null;
    private TipoMedico oTipoMedico = null;
    private List<Medico> listMedico;
    private List<MedicoEspecialidad> listMedicoEspecialidad;

    public JIF_AdministrarMedico(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloMedico = new ModeloMedico();
        tblResultados.setModel(oModeloMedico);
        oModeloMedicoEspecialidad = new ModeloMedicoEspecialidad();
        tblEspecialidad.setModel(oModeloMedicoEspecialidad);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txfBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfApeMaterno = new javax.swing.JTextField();
        txfNombres = new javax.swing.JTextField();
        txfApePaterno = new javax.swing.JTextField();
        txfDni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnBuscarPersona = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbxTipoMedico = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        rbtnActivo = new javax.swing.JRadioButton();
        rbtnDesactivado = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txfCodColegiatura = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cbxEspecialidad = new javax.swing.JComboBox();
        btnAgregarEspecialidad = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEspecialidad = new javax.swing.JTable();
        btnEliminarEspecialidad = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Administrar personal médico");
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Médico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txfBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBusquedaActionPerformed(evt);
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
        jScrollPane1.setViewportView(tblResultados);

        jLabel5.setText("Apellidos y Nombres :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel7.setText("DNI :");

        jLabel2.setText("Nombres :");

        jLabel3.setText("Apellido Paterno :");

        txfApeMaterno.setEnabled(false);
        txfApeMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfApeMaternoActionPerformed(evt);
            }
        });

        txfNombres.setEnabled(false);

        txfApePaterno.setEnabled(false);

        txfDni.setEnabled(false);
        txfDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfDniKeyReleased(evt);
            }
        });

        jLabel4.setText("Apellido Materno :");

        btnBuscarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        btnBuscarPersona.setEnabled(false);
        btnBuscarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPersonaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txfApePaterno)
                            .addComponent(txfNombres)
                            .addComponent(txfApeMaterno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(213, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarPersona)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfApePaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfApeMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(0, 36, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Adicionales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel6.setText("Tipo médico :");

        cbxTipoMedico.setEnabled(false);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        buttonGroup1.add(rbtnActivo);
        rbtnActivo.setSelected(true);
        rbtnActivo.setText("Activo");
        rbtnActivo.setEnabled(false);

        buttonGroup1.add(rbtnDesactivado);
        rbtnDesactivado.setText("Desactivado");
        rbtnDesactivado.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnActivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(rbtnDesactivado)
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnActivo)
                    .addComponent(rbtnDesactivado))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setText("Cod. Colegiatura : ");

        txfCodColegiatura.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbxTipoMedico, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txfCodColegiatura, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxTipoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txfCodColegiatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Save.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setPreferredSize(new java.awt.Dimension(65, 40));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/edit.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.setPreferredSize(new java.awt.Dimension(65, 40));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/new.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.setPreferredSize(new java.awt.Dimension(65, 40));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/cancel.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(65, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel10.setText("Especialidad :");

        cbxEspecialidad.setEnabled(false);

        btnAgregarEspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Button-Download-icon.png"))); // NOI18N
        btnAgregarEspecialidad.setToolTipText("Agregar");
        btnAgregarEspecialidad.setEnabled(false);
        btnAgregarEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEspecialidadActionPerformed(evt);
            }
        });

        tblEspecialidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblEspecialidad);

        btnEliminarEspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Button-Upload-icon.png"))); // NOI18N
        btnEliminarEspecialidad.setToolTipText("Quitar");
        btnEliminarEspecialidad.setEnabled(false);
        btnEliminarEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEspecialidadActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        btnAdd.setToolTipText("Agregar Especialidad");
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(cbxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Especialidad", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfApeMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfApeMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfApeMaternoActionPerformed

    private void txfDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfDniKeyReleased
        Utilitarios.validaCaracterNumerico(evt, txfDni);
        Utilitarios.validaNumeroCaracteres(txfDni, 8);
        txfDni.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_txfDniKeyReleased

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        configuraGuardar();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblResultados.getSelectedRow() != -1) {
            configuraActualizar();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una persona", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        configuraNuevo();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        configuraCancelar();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEspecialidadActionPerformed
        llenarTablaEspecialidades();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnAgregarEspecialidadActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        resetComponent();
        resetPaintComponent();
        buscarMedico();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseReleased
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            resetComponent();
            oModeloMedicoEspecialidad.clear();
            obtenerDatosTabla();
            estadoTextFields(false);
            activarBotones(true, true, false, true);
            personalizaVistaTabla();
        }
    }//GEN-LAST:event_tblResultadosMouseReleased

    private void txfBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBusquedaActionPerformed
        btnBuscar.doClick();
    }//GEN-LAST:event_txfBusquedaActionPerformed

    private void btnEliminarEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEspecialidadActionPerformed
        eliminarEspecialidadMedicoBd();
        buscarMedico();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnEliminarEspecialidadActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        resetComponent();
        oModeloMedico.clear();
        oModeloMedicoEspecialidad.clear();
        personalizaVistaTabla();
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        root.insertarInternalFrames(root.jifAddEspecialidad);
        root.jifAddEspecialidad.enviaDatos(this);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBuscarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPersonaActionPerformed
        openBuscarPersona();
    }//GEN-LAST:event_btnBuscarPersonaActionPerformed


    // Constants declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAgregarEspecialidad;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarPersona;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminarEspecialidad;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbxEspecialidad;
    private javax.swing.JComboBox cbxTipoMedico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbtnActivo;
    private javax.swing.JRadioButton rbtnDesactivado;
    private javax.swing.JTable tblEspecialidad;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txfApeMaterno;
    private javax.swing.JTextField txfApePaterno;
    private javax.swing.JTextField txfBusqueda;
    private javax.swing.JTextField txfCodColegiatura;
    private javax.swing.JTextField txfDni;
    private javax.swing.JTextField txfNombres;
    // End of variables declaration//GEN-END:variables

    private void configuraNuevo() {
        banBoton = 1;
        tblResultados.setEnabled(true);
        btnBuscarPersona.setEnabled(true);
        oModeloMedico.clear();
        oModeloMedicoEspecialidad.clear();
        resetComponent();
        estadoTextFields(true);
        estadoBotones(false, false, true, true);
    }

    private void configuraCancelar() {
        banBoton = 0;
        resetComponent();
        resetPaintComponent();
        estadoTextFields(false);
        estadoBotones(true, false, false, true);
        oModeloMedico.clear();
        oModeloMedicoEspecialidad.clear();
        if (oPersona != null) {
            oPersona = null;
        }
        if (oMedico != null) {
            oMedico = null;
        }
        if(beanTablaM != null){
            beanTablaM = null;
        }

    }

    private void configuraActualizar() {
        banBoton = 2;
        btnBuscarPersona.setEnabled(false);
        estadoTextFields(true);
        estadoBotones(true, false, true, true);
    }

    private void configuraGuardar() {
        if (banBoton == 1) {
            if (isDatosValidos()) {
                resetPaintComponent();
                if (registrar() == Constants.SUCCESS) {
                    Mensajes.msjRegCorrecta();
                    oModeloMedicoEspecialidad.clear();
                    oModeloMedico.clear();
                    oModeloMedico.add(buscarMedicoXDni(oPersona.getNumeroDocumento().trim()));
                    resetComponent();
                    estadoTextFields(false);
                    estadoBotones(true, false, false, true);
                    btnBuscarPersona.setEnabled(false);
                } else {
                    Mensajes.msjRegError();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos", "Atención", JOptionPane.INFORMATION_MESSAGE);
                paintComponent();
            }

        } else if (banBoton == 2) {
            if (isDatosValidosActualizar()) {
                if (actualizarPersona() == Constants.SUCCESS) {
                    Mensajes.msjActCorrecta();
                    resetPaintComponent();
                    oModeloMedico.clear();
                    oModeloMedicoEspecialidad.clear();
                    Medico temp = new Medico();
                    temp = buscarMedicoXDni(beanTablaM.getPersona().getNumeroDocumento().trim());
                    if (temp != null) {
                        oModeloMedico.add(temp);
                    }
                    resetComponent();
                    estadoTextFields(false);
                    estadoBotones(true, false, false, true);
                } else {
                    Mensajes.msjActErronea();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos", "Atención", JOptionPane.INFORMATION_MESSAGE);
                paintComponent();
            }

        }
    }

    private void resetComponent() {  
        //txfBusqueda.setText("");
        txfNombres.setText("");
        txfApePaterno.setText("");
        txfApeMaterno.setText("");
        txfDni.setText("");
        this.txfCodColegiatura.setText("");
        this.cbxTipoMedico.setSelectedIndex(0);
        this.cbxEspecialidad.setSelectedIndex(0);
        this.rbtnActivo.setSelected(true);
        this.rbtnDesactivado.setSelected(false);
    }

    private void estadoTextFields(boolean b) {        
        this.cbxTipoMedico.setEnabled(b);
        this.cbxEspecialidad.setEnabled(b);
        this.rbtnActivo.setEnabled(b);
        this.rbtnDesactivado.setEnabled(b);
        this.btnAgregarEspecialidad.setEnabled(b);
        this.btnAdd.setEnabled(b);
        this.txfCodColegiatura.setEnabled(b);
        this.btnEliminarEspecialidad.setEnabled(b);
        btnBuscarPersona.setEnabled(b);
    }

    private void estadoBotones(boolean nuevo, boolean editar, boolean guardar, boolean cancelar) {
        btnNuevo.setEnabled(nuevo);
        btnEditar.setEnabled(editar);
        btnGuardar.setEnabled(guardar);
        btnCancelar.setEnabled(cancelar);
    }

    public void paintComponent() {
        Utilitarios.paintCbxVacio(cbxTipoMedico);
    }

    private void resetPaintComponent() {
        Utilitarios.resetPaintCbx(cbxTipoMedico);
    }

    private boolean isDatosValidos() {
        return (oPersona != null
                && oPersona.getIdpersona() > 0
                && this.cbxTipoMedico.getSelectedIndex() > 0
                && this.oModeloMedicoEspecialidad.size() > 0);
    }

    private boolean isDatosValidosActualizar() {
        return (!this.txfApeMaterno.getText().trim().equals("")
                && !this.txfNombres.getText().trim().equals("")
                && !this.txfApePaterno.getText().trim().equals("")
                && !this.txfDni.getText().trim().equals("")
                && this.cbxTipoMedico.getSelectedIndex() > 0);
    }

    private int registrar() {
        oBLPersona = new PersonaBl();
        //Datos del Medico
        oMedico = new Medico();
        oMedico.setTipoMedico(((TipoMedico) cbxTipoMedico.getSelectedItem()));
        oMedico.setCodigoColegiatura(txfCodColegiatura.getText().trim().toUpperCase());
        oMedico.setFechaReg(new Date());
        oMedico.setEstado(rbtnActivo.isSelected());

        return oBLPersona.registrarPersonaMedico(oPersona, oMedico, oModeloMedicoEspecialidad);
    }

    private void llenarCbxTipoMedico() {
        oBlTipoMedico = new TipoMedicoBl();
        listTipoMedico = oBlTipoMedico.listar();
        cbxTipoMedico.removeAllItems();
        cbxTipoMedico.addItem("<Seleccione>");
        for (TipoMedico tipoMedico : listTipoMedico) {
            tipoMedico.setOp(TipoMedico.DATO);
            cbxTipoMedico.addItem(tipoMedico);
        }
    }

    public void llenarCbxEspecialidad() {
        oBlEspecialidad = new EspecialidadBl();
        listEspecialidad = oBlEspecialidad.listar();
        cbxEspecialidad.removeAllItems();
        cbxEspecialidad.addItem("<Seleccione>");
        for (Especialidad especialidad : listEspecialidad) {
            especialidad.setOp(TipoMedico.DATO);
            cbxEspecialidad.addItem(especialidad);
        }
    }

    private void llenarTablaEspecialidades() {
        if (cbxEspecialidad.getSelectedIndex() != 0) {
            if (1==1) {//validar duplicidad de espcialidades para un mismo medico
                MedicoEspecialidad me = new MedicoEspecialidad();
                me.setEspecialidad((Especialidad) cbxEspecialidad.getSelectedItem());
                oModeloMedicoEspecialidad.add(me);
            } else {
                JOptionPane.showMessageDialog(null, "La especialidad seleccionada ya fue asignado", "Atención", JOptionPane.INFORMATION_MESSAGE);
            }
            cbxEspecialidad.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una especialidad", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblEspecialidad, 60);
        Utilitarios.formateaColumna(0, tblResultados, 60);
        Utilitarios.formateaColumna(2, tblResultados, 40);
    }

   

    private void buscarMedico() {
        oMedico = new Medico();
        oBlMedico = new MedicoBl();
        String ref = txfBusqueda.getText().trim().toUpperCase();
        listMedico = oBlMedico.buscar(ref);
        oModeloMedico.clear();
        for (Medico obj : listMedico) {
            oModeloMedico.add(obj);
        }
        personalizaVistaTabla();
        estadoTextFields(false);
    }

    private Medico buscarMedicoXDni(String dni) {
        oBlMedico = new MedicoBl();
        return oBlMedico.buscarMedicoXDni(dni);
    }

    private void activarBotones(boolean nuevo, boolean modificar, boolean guardar, boolean cancelar) {
        btnNuevo.setEnabled(nuevo);
        btnEditar.setEnabled(modificar);
        btnGuardar.setEnabled(guardar);
        btnCancelar.setEnabled(cancelar);
    }

    private void obtenerDatosTabla() {
        beanTablaM = (Medico) oModeloMedico.get(tblResultados.getSelectedRow());

        this.txfNombres.setText(beanTablaM.getPersona().getApellidoPaterno().trim());
        this.txfApePaterno.setText(beanTablaM.getPersona().getApellidoMaterno().trim());
        this.txfApeMaterno.setText(beanTablaM.getPersona().getNombre().trim());
        this.txfDni.setText(beanTablaM.getPersona().getNumeroDocumento().trim());
        //recuperar datos especificos del medico
        txfCodColegiatura.setText(beanTablaM.getCodigoColegiatura());
        rbtnActivo.setSelected(beanTablaM.getEstado());
        rbtnDesactivado.setSelected(!beanTablaM.getEstado());

        Utilitarios.recuperaDatosTipoMedico(beanTablaM.getTipoMedico().getIdTipoMedico(), this.cbxTipoMedico);
        
        //Listar especialidades del medico
        oBlMedicoEspecialidad = new MedicoEspecialidadBl();
        listMedicoEspecialidad = oBlMedicoEspecialidad.listarXMedico(beanTablaM.getIdMedico());
        oModeloMedicoEspecialidad.clear();
        for (MedicoEspecialidad obj : listMedicoEspecialidad) {
            oModeloMedicoEspecialidad.add(obj);
        }

    }

    private int actualizarPersona() {
        oBLPersona = new PersonaBl();       

        //Medico
        oMedico = new Medico();
        oMedico.setIdMedico(beanTablaM.getIdMedico());
        oMedico.setPersona(beanTablaM.getPersona());
        oMedico.setTipoMedico(new TipoMedico(((TipoMedico) cbxTipoMedico.getSelectedItem()).getIdTipoMedico()));
        oMedico.setCodigoColegiatura(txfCodColegiatura.getText().trim().toUpperCase());
        oMedico.setEstado(rbtnActivo.isSelected());
        oMedico.setFechaReg(beanTablaM.getFechaReg());

        return oBLPersona.actualizarPersonaMedico(beanTablaM.getPersona(), oMedico);
    }

    public void eliminarEspecialidadMedicoBd() {
        int regEliminados = 0;
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            oMedico = oModeloMedico.get(tblResultados.getSelectedRow());
            if (tblEspecialidad.getRowSelectionAllowed() && tblEspecialidad.getSelectedRow() != -1) {
                medicoEspecialidad = oModeloMedicoEspecialidad.get(tblEspecialidad.getSelectedRow());
                oBlMedicoEspecialidad = new MedicoEspecialidadBl();
                regEliminados = oBlMedicoEspecialidad.eliminar(oEspecialidad, oMedico);
                if (regEliminados > 0) {
                    JOptionPane.showMessageDialog(null, regEliminados + " Registros eliminados", "Atención", JOptionPane.INFORMATION_MESSAGE);
                }
                //Actualizar lista de especialidades del medico                
                oModeloMedicoEspecialidad.remove(tblEspecialidad.getSelectedRow());
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una Especialidad", "Atención", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Médico", "Atención", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void actualizarEspecialidades() {
        oMedicoEspecialidad = new MedicoEspecialidad();
        oBlMedicoEspecialidad = new MedicoEspecialidadBl();
        ArrayList<String> list = new ArrayList<String>();
        int id = 0;
        if (oModeloMedicoEspecialidad.size() > 0) {
            for (int i = 0; i < oModeloMedicoEspecialidad.getRowCount(); i++) {
                for (int j = 0; j < oModeloMedicoEspecialidad.getColumnCount(); j++) {
                    list.add(oModeloMedicoEspecialidad.getValueAt(i, j).toString());
                    oMedicoEspecialidad.getEspecialidad().setIdEspecialidad(Integer.parseInt(oModeloMedicoEspecialidad.getValueAt(i, j).toString()));
                    oMedicoEspecialidad.setMedico(oMedico);
                    //validar que  evite duplicados  a nivel de base de datos
                    id = oBlMedicoEspecialidad.registrar(oMedicoEspecialidad);
                    j = oModeloMedicoEspecialidad.getColumnCount();
                }
            }
        }
        //return id;

    }

    void inicializar() {
        llenarCbxTipoMedico();
        llenarCbxEspecialidad();
        configuraCancelar();
        personalizaVistaTabla();
    }

    private void openBuscarPersona() {
        root.jifAdministrarPersonanatural.setInvocador(JIF_AdministrarPersonaNatural.JIF_REGISTRAR_MEDICO);
        root.insertarInternalFrames(root.jifAdministrarPersonanatural);
        root.jifAdministrarPersonanatural.inicializar();
    }

    void cargarDatosPerona(Persona beanTabla) {
        oPersona = beanTabla;
        txfNombres.setText(oPersona.getNombre().trim());
        txfApePaterno.setText(oPersona.getApellidoPaterno().trim());
        txfApeMaterno.setText(oPersona.getApellidoMaterno().trim());
        txfDni.setText(oPersona.getNumeroDocumento().trim());
    }
}
