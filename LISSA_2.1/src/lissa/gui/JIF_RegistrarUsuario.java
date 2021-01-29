package lissa.gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lissa.be.Permiso;
import lissa.be.Persona;
import lissa.be.Rol;
import lissa.be.Usuario;
import lissa.be.UsuarioPermiso;
import lissa.be.UsuarioRol;
import lissa.bl.PermisoBl;
import lissa.bl.PersonaBl;
import lissa.bl.RolBl;
import lissa.bl.UsuarioBl;
import lissa.bl.UsuarioPermisoBl;
import lissa.bl.UsuarioRolBl;
import lissa.common.Constante;
import lissa.table.ModeloPermiso;
import lissa.table.ModeloPermisoxUsuario;
import lissa.table.ModeloPersonal;
import lissa.table.ModeloRol;
import lissa.table.ModeloUsuarioRol;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import org.apache.commons.codec.digest.DigestUtils;
import org.rx.cr.ds.DSConeccion;
import static org.rx.cr.util.Utilitarios.*;

public class JIF_RegistrarUsuario extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloRol modeloRolDisponible = null;
    private ModeloUsuarioRol modeloUsuarioRol = null;

    private DSConeccion ds = null;

    private Persona oPersona = null;
    private PersonaBl oBLPersona = null;
    private Usuario oUsuario = null;
    private Usuario oUsuarioAct = null;
    private UsuarioBl oUsuarioBl = null;
    private UsuarioBl oUsuarioBlAct = null;
    private UsuarioRol oUsuarioRol = null;
    private UsuarioRolBl oUsuarioRolBl = null;
    private Rol oRol = null;
    private RolBl oBlRol = null;
    private ModeloPersonal oModeloPersonal = null;
    private Usuario beanTabla = null;
    private int banBoton = 0;
    private static final int RESETPASSWORD_SUCCESS = 1;
    private static final int RESETPASSWORD_FAIL = 2;
    private List<Usuario> listUsuarios;
    private ModeloPermiso modeloPermisoDis;
    private ModeloPermisoxUsuario modeloPermisoAsig;

    private PermisoBl permisoBl;
    private List<Permiso> listPermisos;

    private Permiso permisoSelect;
    private UsuarioPermisoBl usuarioPermisoBl;
    private UsuarioPermiso usuarioPermiso;
    private UsuarioPermiso usuarioPermisoSelect;
    private List<UsuarioPermiso> listPermisosxUsuario;
    private List<UsuarioPermiso> listUsuarioPermisoAsig;
    private Rol rolSelect;
    private UsuarioRol usuarioPermisoAsig;

    public JIF_RegistrarUsuario(JF_Principal root) throws Exception {
        initComponents();
        adaptarMovimiento(this);
        this.root = root;
        modeloRolDisponible = new ModeloRol();
        modeloUsuarioRol = new ModeloUsuarioRol();
        tblModuloDisponible.setModel(modeloRolDisponible);
        tblModuloAsignado.setModel(modeloUsuarioRol);
        oModeloPersonal = new ModeloPersonal();
        tblUsuarios.setModel(oModeloPersonal);
        modeloPermisoDis = new ModeloPermiso();
        modeloPermisoAsig = new ModeloPermisoxUsuario();
        tblPermisoDis.setModel(modeloPermisoDis);
        tblPermisoAsig.setModel(modeloPermisoAsig);
    }

    //<editor-fold defaultstate="collapsed" desc="Codigo Auto Generado">
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfNombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txfApellidoPaterno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txfApellidoMaterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txfDni = new javax.swing.JTextField();
        btnBuscarPersona = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txf_nombre_usuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txf_clave_usuario = new javax.swing.JPasswordField();
        rbtnActivo = new javax.swing.JRadioButton();
        rbtnDesactivado = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txfBusqueda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txfUsuario = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblModuloDisponible = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblModuloAsignado = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        btnQuitarRol = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPermisoDis = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPermisoAsig = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        btnQuitarPermiso = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Administración de usuarios");
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
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nombres :");

        txfNombres.setEnabled(false);
        txfNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNombresKeyReleased(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Apellido Paterno :");

        txfApellidoPaterno.setEnabled(false);
        txfApellidoPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfApellidoPaternoKeyReleased(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Apellido Materno :");

        txfApellidoMaterno.setEnabled(false);
        txfApellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfApellidoMaternoKeyReleased(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("DNI :");

        txfDni.setEnabled(false);
        txfDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfDniKeyReleased(evt);
            }
        });

        btnBuscarPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        btnBuscarPersona.setToolTipText("Buscar Persona");
        btnBuscarPersona.setEnabled(false);
        btnBuscarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPersonaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txfApellidoPaterno)
                    .addComponent(txfApellidoMaterno)
                    .addComponent(txfNombres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPersona))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txfApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(txfApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nombre Usuario :");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Clave Usuario :");

        txf_clave_usuario.setEnabled(false);

        buttonGroup1.add(rbtnActivo);
        rbtnActivo.setSelected(true);
        rbtnActivo.setText("Activo");
        rbtnActivo.setEnabled(false);

        buttonGroup1.add(rbtnDesactivado);
        rbtnDesactivado.setText("Desactivado");
        rbtnDesactivado.setEnabled(false);

        jLabel10.setText("Estado : ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rbtnActivo)
                        .addGap(48, 48, 48)
                        .addComponent(rbtnDesactivado))
                    .addComponent(txf_nombre_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                    .addComponent(txf_clave_usuario))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txf_nombre_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txf_clave_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnActivo)
                    .addComponent(rbtnDesactivado)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/cancel.png"))); // NOI18N
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Save.png"))); // NOI18N
        btnGuardar.setEnabled(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txfBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBusquedaActionPerformed(evt);
            }
        });
        txfBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfBusquedaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBusquedaKeyReleased(evt);
            }
        });

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblUsuarios);

        jLabel5.setText("Apellidos y Nombres :");

        jLabel8.setText("Usuario :");

        txfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfUsuarioKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfBusqueda)
                    .addComponent(txfUsuario))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/edit.png"))); // NOI18N
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/new.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Lock-Unlock-icon.png"))); // NOI18N
        jButton6.setToolTipText("Resetear Contraseña");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(893, 229));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modulos disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel6.setMaximumSize(new java.awt.Dimension(383, 191));

        tblModuloDisponible.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblModuloDisponible.setMaximumSize(new java.awt.Dimension(150, 64));
        tblModuloDisponible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblModuloDisponibleMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblModuloDisponible);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modulos asignados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel7.setMaximumSize(new java.awt.Dimension(408, 191));

        tblModuloAsignado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblModuloAsignado.setMaximumSize(new java.awt.Dimension(150, 64));
        tblModuloAsignado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblModuloAsignadoMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblModuloAsignado);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );

        jButton2.setText(">");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnQuitarRol.setText("<");
        btnQuitarRol.setEnabled(false);
        btnQuitarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarRolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jButton2)
                        .addGap(2, 2, 2)
                        .addComponent(btnQuitarRol)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Roles", jPanel5);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Permisos disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel10.setMaximumSize(new java.awt.Dimension(383, 191));

        tblPermisoDis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPermisoDis.setMaximumSize(new java.awt.Dimension(150, 64));
        tblPermisoDis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblPermisoDisMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tblPermisoDis);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Permisos asignados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel11.setMaximumSize(new java.awt.Dimension(408, 191));

        tblPermisoAsig.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPermisoAsig.setMaximumSize(new java.awt.Dimension(150, 64));
        tblPermisoAsig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblPermisoAsigMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tblPermisoAsig);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );

        jButton4.setText(">");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnQuitarPermiso.setText("<");
        btnQuitarPermiso.setEnabled(false);
        btnQuitarPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarPermisoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitarPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jButton4)
                        .addGap(2, 2, 2)
                        .addComponent(btnQuitarPermiso)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1118, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Permisos", jPanel8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton6)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(5, 5, 5))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        registrarModulo();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblModuloDisponibleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblModuloDisponibleMouseReleased
        selectRol();
    }//GEN-LAST:event_tblModuloDisponibleMouseReleased

    private void tblModuloAsignadoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblModuloAsignadoMouseReleased
        btnQuitarRol.setEnabled(true);
    }//GEN-LAST:event_tblModuloAsignadoMouseReleased

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

    }//GEN-LAST:event_formComponentShown

    private void btnQuitarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarRolActionPerformed
        quitarRol();
    }//GEN-LAST:event_btnQuitarRolActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (banBoton == 1) {
            if (isValidoDatos()) {
                try {
                    registrarUsuario();
                    resetComponent();
                } catch (Exception ex) {
                    Logger.getLogger(JIF_RegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese todos los datos", "Atención", JOptionPane.INFORMATION_MESSAGE);
                paintComponent();
            }
        } else if (banBoton == 2) {
            if (isValidoDatos()) {
                try {
                    actualizarCuentaUsuario();
                    oModeloPersonal.clear();
                    resetComponent();
                } catch (Exception ex) {
                    Logger.getLogger(JIF_RegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese todos los datos", "Atención", JOptionPane.INFORMATION_MESSAGE);
                paintComponent();
            }
        }
        personalizarTablas();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        resetComponent();
        activarBotones(true, false, false, true);
        oPersona = null;
        oUsuario = null;
        oUsuarioRol = null;
        estadoTextFields(false);
        personalizarTablas();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        personalizarTablas();
    }//GEN-LAST:event_formInternalFrameOpened

    private void txfDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfDniKeyReleased
        Utilitarios.validaCaracterNumerico(evt, txfDni);
        Utilitarios.validaNumeroCaracteres(txfDni, 8);
        txfDni.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_txfDniKeyReleased

    private void tblUsuariosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseReleased
        if (tblUsuarios.getRowSelectionAllowed()) {
            try {
                obtenerDatosTabla();
                estadoTextFields(false);
                activarBotones(true, true, false, true);
            } catch (SQLException ex) {
                Logger.getLogger(JIF_RegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        personalizarTablas();
    }//GEN-LAST:event_tblUsuariosMouseReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        configuraNuevo();
        defaultPassword();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblUsuarios.getSelectedRow() != -1) {
            configuraActualizar();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un personal", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txfNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombresKeyReleased

    }//GEN-LAST:event_txfNombresKeyReleased

    private void txfApellidoPaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfApellidoPaternoKeyReleased

    }//GEN-LAST:event_txfApellidoPaternoKeyReleased

    private void txfApellidoMaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfApellidoMaternoKeyReleased

    }//GEN-LAST:event_txfApellidoMaternoKeyReleased

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        resetComponent();
        activarBotones(true, false, false, true);
        personalizarTablas();
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnBuscarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPersonaActionPerformed
        buscarPersona();
    }//GEN-LAST:event_btnBuscarPersonaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (tblUsuarios.getRowSelectionAllowed() && beanTabla != null) {
            if (resetPassword() == 1) {
                Mensajes.msjResetPassword();
            } else {
                Mensajes.msjActErronea();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cargue los datos de un Usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txfBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBusquedaActionPerformed

    }//GEN-LAST:event_txfBusquedaActionPerformed

    private void txfBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBusquedaKeyPressed

    }//GEN-LAST:event_txfBusquedaKeyPressed

    private void txfBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBusquedaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarxApellidosyNombres();
        }
    }//GEN-LAST:event_txfBusquedaKeyReleased

    private void txfUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUsuarioKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarxNombreUsuario();
        }
    }//GEN-LAST:event_txfUsuarioKeyReleased

    private void tblPermisoDisMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPermisoDisMouseReleased
        selectPermiso();
    }//GEN-LAST:event_tblPermisoDisMouseReleased

    private void tblPermisoAsigMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPermisoAsigMouseReleased
        selectUserPermisoAsig();
    }//GEN-LAST:event_tblPermisoAsigMouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        registrarPermisoSelect();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnQuitarPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarPermisoActionPerformed
        quitarPermiso();
    }//GEN-LAST:event_btnQuitarPermisoActionPerformed
    //<editor-fold defaultstate="collapsed" desc="Variables Autogeneradas">    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPersona;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuitarPermiso;
    private javax.swing.JButton btnQuitarRol;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbtnActivo;
    private javax.swing.JRadioButton rbtnDesactivado;
    private javax.swing.JTable tblModuloAsignado;
    private javax.swing.JTable tblModuloDisponible;
    private javax.swing.JTable tblPermisoAsig;
    private javax.swing.JTable tblPermisoDis;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txfApellidoMaterno;
    private javax.swing.JTextField txfApellidoPaterno;
    private javax.swing.JTextField txfBusqueda;
    private javax.swing.JTextField txfDni;
    private javax.swing.JTextField txfNombres;
    private javax.swing.JTextField txfUsuario;
    private javax.swing.JPasswordField txf_clave_usuario;
    private javax.swing.JTextField txf_nombre_usuario;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    //</editor-fold>

    private void personalizarTablas() {
        Utilitarios.formateaColumna(0, tblModuloDisponible, 50);
        Utilitarios.formateaColumna(0, tblModuloAsignado, 50);
        Utilitarios.formateaColumna(2, tblModuloAsignado, 80);

        Utilitarios.formateaColumna(0, tblUsuarios, 50);
        Utilitarios.formateaColumna(0, tblUsuarios, 100);

        Utilitarios.formateaColumna(0, tblPermisoDis, 50);
        Utilitarios.formateaColumna(1, tblPermisoDis, 50);

        Utilitarios.formateaColumna(0, tblPermisoAsig, 50);
        Utilitarios.formateaColumna(1, tblPermisoAsig, 50);

    }

    private void cargar_lista_modulos() throws Exception {
        oBlRol = new RolBl();
        modeloRolDisponible.addAll(oBlRol.listar());
    }

    private void cargarPermisos() throws Exception {
        permisoBl = new PermisoBl();
        listPermisos = permisoBl.listar();
        for (Permiso per : listPermisos) {
            modeloPermisoDis.add(per);
        }
    }

    private void registrarUsuario() throws Exception {
        if (oPersona != null) {
            //Validar si la persona ya cuenta con una cuenta de usuario en el sistema
            registrarCuentaUsuario(oPersona);
        }
    }

    private void registrarCuentaUsuario(Persona per) throws Exception {
        oUsuario = new Usuario();
        oUsuarioBl = new UsuarioBl();

        oUsuario.setNombre(txf_nombre_usuario.getText().toUpperCase().trim());
        oUsuario.setContrasenia(DigestUtils.md5Hex("LISSA"));
        oUsuario.setPersona(per);
        oUsuario.setEstado(rbtnActivo.isSelected());

        oUsuario = oUsuarioBl.registrar(oUsuario);
        cargarDatosUsuario(oUsuario);

    }

    private void actualizarCuentaUsuario() throws Exception {
        oUsuarioAct = new Usuario();
        oUsuarioBlAct = new UsuarioBl();

        oUsuarioAct.setIdUsuario(beanTabla.getIdUsuario());
        oUsuarioAct.setPersona(beanTabla.getPersona());
        oUsuarioAct.setNombre(beanTabla.getNombre());
        oUsuarioAct.setContrasenia(beanTabla.getContrasenia());
        oUsuarioAct.setFechaReg(beanTabla.getFechaReg());
        if (rbtnActivo.isSelected()) {
            oUsuarioAct.setEstado(Boolean.TRUE);
        } else {
            oUsuarioAct.setEstado(Boolean.FALSE);
        }
        oUsuarioBl.actualizar(oUsuarioAct);
    }

    private boolean isValidoDatos() {
        return (!this.txfNombres.getText().trim().equals("")
                && !this.txfApellidoPaterno.getText().trim().equals("")
                && !this.txfApellidoMaterno.getText().trim().equals("")
                && !this.txfDni.getText().trim().equals("")
                && !this.txf_nombre_usuario.getText().trim().equals("")
                && !this.txf_clave_usuario.getText().trim().equals(""));
    }

    public void paintComponent() {
        Utilitarios.paintTxfVacio(txfNombres);
        Utilitarios.paintTxfVacio(txfApellidoPaterno);
        Utilitarios.paintTxfVacio(txfApellidoMaterno);
        Utilitarios.paintTxfVacio(txfDni);
        Utilitarios.paintTxfVacio(txf_nombre_usuario);
        Utilitarios.paintTxfVacio(txf_clave_usuario);
    }

    public void resetPaintComponent() {
        Utilitarios.resetPaintTxf(txfNombres);
        Utilitarios.resetPaintTxf(txfApellidoPaterno);
        Utilitarios.resetPaintTxf(txfApellidoMaterno);
        Utilitarios.resetPaintTxf(txfDni);
        Utilitarios.resetPaintTxf(txf_nombre_usuario);
        Utilitarios.resetPaintTxf(txf_clave_usuario);
    }

    private void resetComponent() {
        this.txfNombres.setText("");
        this.txfApellidoPaterno.setText("");
        this.txfApellidoMaterno.setText("");
        this.txfDni.setText("");
        this.txf_nombre_usuario.setText("");
        this.txf_clave_usuario.setText("");
        this.modeloUsuarioRol.clear();
        buttonGroup1.clearSelection();
        personalizarTablas();
    }

    private void buscarxApellidosyNombres() {
        oUsuarioBl = new UsuarioBl();
        listUsuarios = new LinkedList<>();
        oModeloPersonal.clear();
        String ref = txfBusqueda.getText().trim().toUpperCase();
        listUsuarios = oUsuarioBl.buscarxApellidosyNombres(ref);
        for (Usuario obj : listUsuarios) {
            oModeloPersonal.add(obj);
        }
        personalizarTablas();
        txfBusqueda.setText("");
        estadoTextFields(false);
    }

    private void buscarxNombreUsuario() {
        oUsuarioBl = new UsuarioBl();
        listUsuarios = new LinkedList<>();
        oModeloPersonal.clear();
        String ref = txfUsuario.getText().trim().toUpperCase();
        listUsuarios = oUsuarioBl.buscarxNombreUsuario(ref);
        for (Usuario obj : listUsuarios) {
            oModeloPersonal.add(obj);
        }
        personalizarTablas();
        txfUsuario.setText("");
        estadoTextFields(false);
    }

    private void estadoTextFields(Boolean e) {
        this.txfNombres.setEnabled(e);
        this.txfApellidoPaterno.setEnabled(e);
        this.txfApellidoMaterno.setEnabled(e);
        this.txfDni.setEnabled(e);
    }

    private void activarBotones(boolean nuevo, boolean modificar, boolean guardar, boolean cancelar) {
        btnNuevo.setEnabled(nuevo);
        btnEditar.setEnabled(modificar);
        btnGuardar.setEnabled(guardar);
        btnCancelar.setEnabled(cancelar);
    }

    private void obtenerDatosTabla() throws SQLException {
        resetComponent();
        beanTabla = (Usuario) oModeloPersonal.get(tblUsuarios.getSelectedRow());
        this.txfNombres.setText(beanTabla.getPersona().getNombre());
        this.txfApellidoPaterno.setText(beanTabla.getPersona().getApellidoPaterno());
        this.txfApellidoMaterno.setText(beanTabla.getPersona().getApellidoMaterno());
        this.txfDni.setText(beanTabla.getPersona().getNumeroDocumento());
        this.txf_nombre_usuario.setText(beanTabla.getNombre());
        this.txf_clave_usuario.setText(beanTabla.getContrasenia().trim().substring(1, 10));
        if (beanTabla.getEstado()) {
            this.rbtnActivo.setSelected(true);
            this.rbtnDesactivado.setSelected(false);
        } else {
            this.rbtnActivo.setSelected(false);
            this.rbtnDesactivado.setSelected(true);
        }
        //listar modulos
        listarModulosAsignados();
        //listarPermisosDel Usuario
        listPermisosUserSelect(beanTabla);

    }

    private void configuraNuevo() {
        banBoton = 1;
        btnBuscarPersona.setEnabled(true);
        tblUsuarios.setEnabled(true);
        oModeloPersonal.clear();
        this.modeloUsuarioRol.clear();
        this.modeloPermisoAsig.clear();
        resetComponent();
        activarBotones(false, false, true, true);
        tblModuloAsignado.setEnabled(true);
        tblModuloDisponible.setEnabled(true);
        rbtnActivo.setEnabled(true);
        rbtnDesactivado.setEnabled(true);
        personalizarTablas();
    }

    private void configuraActualizar() {
        banBoton = 2;
        rbtnActivo.setEnabled(true);
        rbtnDesactivado.setEnabled(true);
        activarBotones(true, false, true, true);
    }

    /*
     private void generarNombreUser() {
     if (txfNombres.getText().length() > 0) {
     User = (User.concat(txfNombres.getText().trim().toUpperCase())).substring(0, 1);
     txf_nombre_usuario.setText(User);
     } else {
     User = "";
     txf_nombre_usuario.setText("");
     }
     //algoritmo para unir  apellidos compuestos por mas de dos letras
     String apePaterno = txfApellidoPaterno.getText().toUpperCase().trim();
     String[] splitArr = apePaterno.split(" ");
     for (int i = 0; i < splitArr.length; i++) {
     User2 = User2.concat(splitArr[i]);
     }
     //fin de algoritmo
     if (txfApellidoMaterno.getText().length() > 0) {
     User3 = (txfApellidoMaterno.getText().trim().toUpperCase()).substring(0, 1);
     txf_nombre_usuario.setText(User.concat(User2).concat(User3));
     } else {
     User3 = "";
     txf_nombre_usuario.setText(User.concat(User2));
     }
     }
     */
    private void buscarPersona() {
        root.jifAdministrarPersonanatural.setInvocador(JIF_AdministrarPersonaNatural.JIF_USUARIO);
        root.insertarInternalFrames(root.jifAdministrarPersonanatural);
        root.jifAdministrarPersonanatural.inicializar();
    }

    void cargarDatosPersona(Persona beanTabla) {
        oPersona = beanTabla;
        txfNombres.setText(oPersona.getNombre());
        txfApellidoPaterno.setText(oPersona.getApellidoPaterno());
        txfApellidoMaterno.setText(oPersona.getApellidoMaterno());
        txfDni.setText(oPersona.getNumeroDocumento());
    }

    private int resetPassword() {
        oUsuarioAct = new Usuario();
        oUsuarioBlAct = new UsuarioBl();
        oUsuarioAct.setIdUsuario(beanTabla.getIdUsuario());
        oUsuarioAct.setPersona(beanTabla.getPersona());
        oUsuarioAct.setNombre(beanTabla.getNombre());
        oUsuarioAct.setContrasenia(DigestUtils.md5Hex("LISSA"));
        oUsuarioAct.setFechaReg(beanTabla.getFechaReg());
        if (rbtnActivo.isSelected()) {
            oUsuarioAct.setEstado(Boolean.TRUE);
        } else {
            oUsuarioAct.setEstado(Boolean.FALSE);
        }
        return oUsuarioBl.actualizar(oUsuarioAct);
    }

    public void inicializar() {
        try {
            cargar_lista_modulos();
            cargarPermisos();
            personalizarTablas();
        } catch (Exception ex) {
            Logger.getLogger(JIF_RegistrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void defaultPassword() {
        txf_clave_usuario.setText("LISSA");
    }

    private void cargarDatosUsuario(Usuario oUsuario) {
        oModeloPersonal.add(oUsuario);
    }

    private void registrarModulo() {
        if (isUserSelected()) {
            if (isModuloSelected()) {
                if (!existeRolAsignado(beanTabla.getIdUsuario(), rolSelect.getIdrol())) {
                    oUsuarioRol = new UsuarioRol();
                    oUsuarioRolBl = new UsuarioRolBl();
                    oUsuarioRol.setUsuario(beanTabla);
                    oUsuarioRol.setRol(modeloRolDisponible.get(tblModuloDisponible.getSelectedRow()));
                    oUsuarioRol.setFechaReg(new Date());
                    oUsuarioRol.setDescripcion("");
                    oUsuarioRol.setEstado(Constante.ESTADO_ACT);

                    oUsuarioRolBl.registrar(oUsuarioRol);
                    //Listar  todos los modulos asignados al usuario
                    listarModulosAsignados();
                    personalizarTablas();
                } else {
                    Mensajes.mensajeSistemaInformacion(null, Constante.EL_USUARIO_YA_CUENTA_CON_EL_ROL);
                }
            } else {

            }
        } else {
            Mensajes.tblSelected();
        }

    }

    private void listarModulos() {
        modeloUsuarioRol.clear();
        beanTabla = oModeloPersonal.get(tblUsuarios.getSelectedRow());
        for (UsuarioRol obj : beanTabla.getUsuarioRols()) {
            //obtener roles de los usuarios por idRol
            oRol = new Rol();
            oBlRol = new RolBl();
            oRol = oBlRol.buscarId(obj.getRol().getIdrol());
            //modeloUsuarioRol.add(oRol);
        }
    }

    //Lista los modulos asignados por id usuario
    private void listarModulosAsignados() {
        oUsuarioRolBl = new UsuarioRolBl();
        modeloUsuarioRol.clear();
        List<UsuarioRol> listUsuarioRoles = new LinkedList<>();
        long idUsuario = beanTabla.getIdUsuario();
        listUsuarioRoles = oUsuarioRolBl.listarModulosXUsuario(idUsuario);
        for (UsuarioRol obj : listUsuarioRoles) {
            modeloUsuarioRol.add(obj);
        }
    }

    private void selectPermiso() {
        if (tblPermisoDis.getRowSelectionAllowed() && tblPermisoDis.getSelectedRow() != -1) {
            permisoSelect = modeloPermisoDis.get(tblPermisoDis.getSelectedRow());
            jButton4.setEnabled(true);
        }
    }

    private void registrarPermisoSelect() {
        if (isUserSelected()) {
            if (isPermisoSelected()) {
                if (!existePermiso(permisoSelect.getIdpermiso(), beanTabla.getIdUsuario())) {
                    usuarioPermisoBl = new UsuarioPermisoBl();
                    usuarioPermiso = new UsuarioPermiso();
                    usuarioPermiso.setUsuario(beanTabla);
                    usuarioPermiso.setPermiso(permisoSelect);
                    usuarioPermiso.setFechaAct(new Date());
                    usuarioPermiso.setEstado(Constante.ESTADO_ACT);
                    usuarioPermiso.setUserReg(root.getUser());

                    usuarioPermiso = usuarioPermisoBl.registrar(usuarioPermiso);

                    if (usuarioPermiso.getIdusuariopermiso() != 0) {
                        Mensajes.msjRegCorrecta();
                        //Listar todos los permisos con los que cuenta el usuario
                        listPermisosUserSelect(beanTabla);
                        //Fin Listar
                        personalizarTablas();
                    } else {
                        Mensajes.msjRegError();
                    }
                } else {
                    Mensajes.mensajeSistemaInformacion(null, Constante.EL_USUARIO_YA_CUENTA_CON_EL_PERMISO);
                }
            } else {
                Mensajes.mensajeSistemaInformacion(null, Constante.SELECCIONE_PERMISO);
            }
        } else {
            Mensajes.mensajeSistemaInformacion(null, Constante.SELECCIONE_USUARIO);
        }

    }

    private void listPermisosUserSelect(Usuario beanTabla) {
        listPermisosxUsuario = new LinkedList<>();
        usuarioPermisoBl = new UsuarioPermisoBl();
        listPermisosxUsuario = usuarioPermisoBl.listarPermisosxUsuario(beanTabla.getIdUsuario());
        modeloPermisoAsig.clear();
        if (!listPermisosxUsuario.isEmpty()) {
            for (UsuarioPermiso obj : listPermisosxUsuario) {
                modeloPermisoAsig.add(obj);
            }
        }
    }

    private boolean existePermiso(int idpermiso, long idUsuario) {
        boolean est = false;
        UsuarioPermiso temp = new UsuarioPermiso();
        usuarioPermisoBl = new UsuarioPermisoBl();

        temp = usuarioPermisoBl.buscarUsuarioPermiso(idpermiso, idUsuario);
        if (temp != null && temp.getIdusuariopermiso() > 0) {
            est = true;
        } else {
            est = false;
        }
        return est;
    }

    private void quitarPermiso() {
        int res = 0;
        //Update permiso seleccionado a ANU
        usuarioPermisoBl = new UsuarioPermisoBl();
        if (usuarioPermisoSelect.getIdusuariopermiso() > 0 && usuarioPermisoSelect != null) {
            res = usuarioPermisoBl.quitarPermiso(usuarioPermisoSelect.getIdusuariopermiso());
            if (res == Constante.SUCCESS) {
                Mensajes.mensajeSistemaInformacion(null, Constante.EL_PERMISO_FUE_DESHABILITADO);
                //Actualizar lista de permisos
                listPermisosUserSelect(beanTabla);
                personalizarTablas();
            } else {
                Mensajes.mensajeSistemaInformacion(null, Constante.ERROR_EN_LA_OPERACION_REALIZADA);
            }
        } else {

        }
    }

    private void selectUserPermisoAsig() {
        if (tblPermisoAsig.getRowSelectionAllowed() && tblPermisoAsig.getSelectedRow() != -1) {
            usuarioPermisoSelect = modeloPermisoAsig.get(tblPermisoAsig.getSelectedRow());
            btnQuitarPermiso.setEnabled(true);
        }
    }

    private boolean isUserSelected() {
        return (tblUsuarios.getRowSelectionAllowed() && tblUsuarios.getSelectedRow() != -1);
    }

    private boolean isPermisoSelected() {
        return tblPermisoDis.getRowSelectionAllowed();
    }

    private boolean isModuloSelected() {
        return (tblModuloDisponible.getRowSelectionAllowed() && tblModuloDisponible.getSelectedRow() != -1);
    }

    private void selectRol() {
        if (isModuloSelected()) {
            rolSelect = new Rol();
            rolSelect = modeloRolDisponible.get(tblModuloDisponible.getSelectedRow());
            jButton2.setEnabled(true);
        }
    }

    private boolean existeRolAsignado(long idUsuario, int idrol) {
        oUsuarioRolBl = new UsuarioRolBl();
        return oUsuarioRolBl.existeRolAsignado(idUsuario, idrol);
    }

    private void quitarRol() {
        int res = 0;
        oUsuarioRolBl = new UsuarioRolBl();
        if (usuarioRolAsigSelect()) {
            res = oUsuarioRolBl.quitarRol(usuarioPermisoAsig.getIdUsuarioRol());
            if (res == Constante.SUCCESS) {
                Mensajes.mensajeSistemaInformacion(null, Constante.EL_ROL_FUE_DESHABILITADO);
                //Actualizar lista de roles asignados
                listarModulosAsignados();
                personalizarTablas();
            } else {
                Mensajes.mensajeSistemaInformacion(null, Constante.ERROR_EN_LA_OPERACION_REALIZADA);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un módulo asignado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean usuarioRolAsigSelect() {
        if (tblModuloAsignado.getRowSelectionAllowed() && tblModuloAsignado.getSelectedRow() != -1) {
            usuarioPermisoAsig = new UsuarioRol();
            usuarioPermisoAsig = modeloUsuarioRol.get(tblModuloAsignado.getSelectedRow());
            btnQuitarRol.setEnabled(true);
            return true;
        } else {
            return false;
        }
    }

}
