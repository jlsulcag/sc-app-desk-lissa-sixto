package lissa.gui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;
import javax.swing.JOptionPane;
import lissa.be.Persona;
import lissa.be.TipoPersona;
import lissa.bl.PersonaBl;
import lissa.controller.TipoPersonaCtrl;
import lissa.table.ModeloPersonas;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_AdministrarPersonaNatural extends javax.swing.JInternalFrame {

    private JF_Principal root;
    //variables para las tablas
    private ModeloPersonas oModeloPersonas;

    //Objetos para persona
    private Persona oPersona = null;
    private PersonaBl oPersonaBl = null;
    private List<Persona> listPersonas;

    private Persona beanTabla;

    //banderas
    private int banBoton = 0;
    private int invocador;
    public static final int JIF_PERSONA_JURIDICA = 1;
    public static final int JIF_CITA = 2;
    public static final int JIF_USUARIO = 3;
    public static final int JIF_VENTAS = 4;
    public static final int JIF_VENTAS2 = 6;
    public static final int JIF_COBRO_CAJA = 5;
    public static final int JIF_COMPRAS = 7;
    public static final int JIF_REGISTRAR_MEDICO = 8;
    //public static final int JIF_EMITIR_COMPROBANTE2 = 2;

    public JIF_AdministrarPersonaNatural(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloPersonas = new ModeloPersonas();
        tblResultados.setModel(oModeloPersonas);
        personalizaVistaTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfApePaterno = new javax.swing.JTextField();
        txfApeMaterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txfNombres = new javax.swing.JTextField();
        txfnNumDni = new javax.swing.JTextField();
        txfTelefono = new javax.swing.JTextField();
        jdcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        cbxTipoPersona = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        chbxProveedor = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        txfNroRuc = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txfDirección = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        chbxTieneruc = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        txfNombesBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txfNdiRucBusqueda = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnCargar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Maestro de personas");
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la persona", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setText("Apellido Paterno / Razon Social :");

        jLabel3.setText("Apellido Materno :");

        txfApePaterno.setEnabled(false);

        txfApeMaterno.setEnabled(false);

        jLabel4.setText("Nombres :");

        jLabel5.setText("Fecha de  Nacimiento :");

        jLabel7.setText("Nº DNI :");

        jLabel9.setText("Telefono :");

        txfNombres.setEnabled(false);
        txfNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombresActionPerformed(evt);
            }
        });

        txfnNumDni.setEnabled(false);
        txfnNumDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfnNumDniKeyReleased(evt);
            }
        });

        txfTelefono.setEnabled(false);

        jdcFechaNacimiento.setEnabled(false);

        jLabel6.setText("Tipo Persona :");

        cbxTipoPersona.setEnabled(false);
        cbxTipoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoPersonaActionPerformed(evt);
            }
        });

        jLabel8.setText("Proveedor :");

        jLabel11.setText("Nº RUC :");

        txfNroRuc.setEnabled(false);
        txfNroRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNroRucKeyReleased(evt);
            }
        });

        jLabel12.setText("Dirección :");

        jLabel13.setText("Persona Natural con Ruc ?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                        .addComponent(txfApePaterno)
                        .addComponent(txfApeMaterno)
                        .addComponent(txfNombres)
                        .addComponent(txfnNumDni)
                        .addComponent(txfTelefono)
                        .addComponent(cbxTipoPersona, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chbxProveedor)
                        .addComponent(txfNroRuc)
                        .addComponent(txfDirección))
                    .addComponent(chbxTieneruc))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfApePaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txfApeMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txfnNumDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txfDirección, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(chbxTieneruc))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txfNroRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(chbxProveedor))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txfNombesBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombesBusquedaActionPerformed(evt);
            }
        });
        txfNombesBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNombesBusquedaKeyReleased(evt);
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

        jLabel1.setText("Apellidos y Nombres / Razon Social :");

        jLabel10.setText("N° DNI / RUC :");

        txfNdiRucBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNdiRucBusquedaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfNdiRucBusqueda)
                    .addComponent(txfNombesBusqueda)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txfNdiRucBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txfNombesBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/cancel.png"))); // NOI18N
        btnCancelar.setEnabled(false);
        btnCancelar.setPreferredSize(new java.awt.Dimension(65, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Save.png"))); // NOI18N
        btnGuardar.setEnabled(false);
        btnGuardar.setPreferredSize(new java.awt.Dimension(65, 40));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/edit.png"))); // NOI18N
        btnEditar.setEnabled(false);
        btnEditar.setPreferredSize(new java.awt.Dimension(65, 40));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/new.png"))); // NOI18N
        btnNuevo.setPreferredSize(new java.awt.Dimension(65, 40));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/arrow.png"))); // NOI18N
        btnCargar.setToolTipText("Cargar");
        btnCargar.setPreferredSize(new java.awt.Dimension(65, 40));
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombresActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        configuraGuardar();
        personalizaVistaTabla();
        //resetComponent();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tblResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseReleased
        try {
            if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
                obtenerDatosTabla();
                estadoTextFieldsPN(false);
                activarBotones(true, true, false, true);
                resetPaintComponent();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIF_AdministrarPersonaNatural.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblResultadosMouseReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        configuraNuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblResultados.getSelectedRow() != -1) {
            configuraActualizar();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una persona", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
        personalizaVistaTabla();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        configuraCancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        if (beanTabla == null || beanTabla.getIdpersona() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione una persona", "Atencion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (isDatosValidos()) {
                cargarDatosPersona();
                this.doDefaultCloseAction();
                oModeloPersonas.clear();
                beanTabla = null;
                resetComponent();
            } else {
                JOptionPane.showMessageDialog(null, "Actualice la informacion de la persona antes de cargar", "Atencion", JOptionPane.INFORMATION_MESSAGE);
                paintComponent();
            }
        }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void txfNombesBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombesBusquedaActionPerformed

    }//GEN-LAST:event_txfNombesBusquedaActionPerformed

    private void txfnNumDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfnNumDniKeyReleased
        Utilitarios.validaCaracterNumerico(evt, txfnNumDni);
        Utilitarios.validaNumeroCaracteres(txfnNumDni, 8);
        txfnNumDni.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_txfnNumDniKeyReleased

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        resetComponent();
        oModeloPersonas.clear();
    }//GEN-LAST:event_formInternalFrameClosing

    private void txfNdiRucBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNdiRucBusquedaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarPersonaxNroDoc();
            personalizaVistaTabla();
        }
    }//GEN-LAST:event_txfNdiRucBusquedaKeyReleased

    private void txfNombesBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombesBusquedaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarPersonaxNombres();
            personalizaVistaTabla();
        }
    }//GEN-LAST:event_txfNombesBusquedaKeyReleased

    private void cbxTipoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoPersonaActionPerformed
        configuraInterfazPersona();
    }//GEN-LAST:event_cbxTipoPersonaActionPerformed

    private void txfNroRucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNroRucKeyReleased
        Utilitarios.validaCaracterNumerico(evt, txfnNumDni);
        Utilitarios.validaNumeroCaracteres(txfnNumDni, 8);
    }//GEN-LAST:event_txfNroRucKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cbxTipoPersona;
    private javax.swing.JCheckBox chbxProveedor;
    private javax.swing.JCheckBox chbxTieneruc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFechaNacimiento;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txfApeMaterno;
    private javax.swing.JTextField txfApePaterno;
    private javax.swing.JTextField txfDirección;
    private javax.swing.JTextField txfNdiRucBusqueda;
    private javax.swing.JTextField txfNombesBusqueda;
    private javax.swing.JTextField txfNombres;
    private javax.swing.JTextField txfNroRuc;
    private javax.swing.JTextField txfTelefono;
    private javax.swing.JTextField txfnNumDni;
    // End of variables declaration//GEN-END:variables

    private Persona buscarPersonaXDni() {
        oPersonaBl = new PersonaBl();
        if (((TipoPersona) cbxTipoPersona.getSelectedItem()).getDescripcion().equals("PERSONA NATURAL")) {
            return oPersonaBl.buscarPersonaXDni(txfnNumDni.getText().trim());
        } else if (((TipoPersona) cbxTipoPersona.getSelectedItem()).getDescripcion().equals("PERSONA JURIDICA")) {
            return oPersonaBl.buscarPersonaXDni(txfNroRuc.getText().trim());
        } else {
            return new Persona();
        }

    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblResultados, 80);
    }

    private void buscarPersona() {
        oPersona = new Persona();
        oPersonaBl = new PersonaBl();
        String ref = txfNombesBusqueda.getText().trim().toUpperCase();
        oModeloPersonas.addAll(oPersonaBl.buscar(ref));
        personalizaVistaTabla();
        //txfBusqueda.setText("");
        estadoTextFieldsPN(false);
    }

    private void obtenerDatosTabla() throws SQLException {
        resetComponent();
        TipoPersonaCtrl oTipoPersonaCtrl = new TipoPersonaCtrl(root);
        beanTabla = (Persona) oModeloPersonas.get(tblResultados.getSelectedRow());
        oTipoPersonaCtrl.defaultSelectCbx(beanTabla.getTipoPersona().getDescripcion().trim(), cbxTipoPersona);
        this.txfNombres.setText(beanTabla.getNombre().trim());
        this.txfApePaterno.setText(beanTabla.getApellidoPaterno().trim());
        this.txfApeMaterno.setText(beanTabla.getApellidoMaterno().trim());
        this.jdcFechaNacimiento.setDate(beanTabla.getFechaNacimiento());
        this.txfnNumDni.setText(beanTabla.getNumeroDocumento());
        this.txfTelefono.setText(beanTabla.getTelefono());
        chbxProveedor.setSelected(beanTabla.getEsproveedor() == 1 ? true : false);
        txfNroRuc.setText(beanTabla.getRuc().trim());
        txfDirección.setText(beanTabla.getDireccion().trim());
    }

    private void configuraGuardar() {
        if (banBoton == 1) {
            if (isDatosValidos()) {
                if (isValidoNumeroCaracteresDoc()) {
                    if (isDniValido()) {
                        if (registrarPersona() != null) {
                            JOptionPane.showMessageDialog(null, Mensajes.getRegCorrecto(), Mensajes.getTituloAtencion(), JOptionPane.INFORMATION_MESSAGE);
                            oModeloPersonas.clear();
                            oModeloPersonas.add(buscarPersonaXDni());
                            resetComponent();
                            resetPaintComponent();
                            estadoTextFieldsPN(false);
                        } else {
                            JOptionPane.showMessageDialog(null, Mensajes.getRegError(), Mensajes.getTituloError(), JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El N° de DNI ya existe", "Atención", JOptionPane.INFORMATION_MESSAGE);
                        txfnNumDni.setText("");
                        txfnNumDni.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un Numero de Documento Válido", "Atención", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos", "Atención", JOptionPane.INFORMATION_MESSAGE);
                paintComponent();
            }

        } else if (banBoton == 2) {
            if (isDatosValidos()) {
                if (actualizarPersona() != 0) {
                    Mensajes.msjActCorrecta();
                    oModeloPersonas.clear();
                    oModeloPersonas.add(buscarPersonaXDni());
                    resetComponent();
                } else {
                    Mensajes.msjActErronea();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos", "Atención", JOptionPane.INFORMATION_MESSAGE);
                paintComponent();
            }

        }
    }

    private void configuraNuevo() {
        banBoton = 1;
        tblResultados.setEnabled(true);
        oModeloPersonas.clear();
        resetComponent();
        resetPaintComponent();
        cbxTipoPersona.setEnabled(true);
        //estadoTextFields(true);
        activarBotones(false, false, true, true);
        personalizaVistaTabla();
    }

    private void configuraActualizar() {
        banBoton = 2;
        switch (beanTabla.getTipoPersona().getDescripcion()) {
            case "PERSONA NATURAL":
                estadoTextFieldsPN(true);
                break;
            case "PERSONA JURIDICA":
                estadoTextFieldsPJ(true);
                break;
        }
        activarBotones(true, false, true, true);
    }

    private boolean isDatosValidos() {
        switch (((TipoPersona) cbxTipoPersona.getSelectedItem()).getDescripcion().trim()) {
            case "PERSONA NATURAL":
                return (cbxTipoPersona.getSelectedIndex() > 0
                        && !this.txfApePaterno.getText().trim().equals("")
                        && !this.txfApeMaterno.getText().trim().equals("")
                        && !this.txfNombres.getText().trim().equals("")
                        && !this.txfnNumDni.getText().trim().equals(""));
            case "PERSONA JURIDICA":
                return (cbxTipoPersona.getSelectedIndex() > 0
                        && !this.txfApePaterno.getText().trim().equals("")
                        && !this.txfNroRuc.getText().trim().equals(""));
            default:
                return false;
        }

    }

    public void paintComponent() {

        switch (((TipoPersona) cbxTipoPersona.getSelectedItem()).getDescripcion().trim()) {
            case "PERSONA NATURAL":
                Utilitarios.paintTxfVacio(txfNombres);
                Utilitarios.paintTxfVacio(txfApePaterno);
                Utilitarios.paintTxfVacio(txfApeMaterno);
                Utilitarios.paintTxfVacio(txfnNumDni);
            case "PERSONA JURIDICA":
                Utilitarios.paintTxfVacio(txfApePaterno);
                Utilitarios.paintTxfVacio(txfNroRuc);
        }
    }

    public void resetPaintComponent() {
        Utilitarios.resetPaintTxf(txfNombres);
        Utilitarios.resetPaintTxf(txfApePaterno);
        Utilitarios.resetPaintTxf(txfApeMaterno);
        Utilitarios.resetPaintTxf(txfnNumDni);
    }

    private void resetComponent() {
        this.txfApePaterno.setText("");
        this.txfApeMaterno.setText("");
        this.txfNombres.setText("");
        this.jdcFechaNacimiento.setDate(null);
        this.txfnNumDni.setText("");
        this.txfTelefono.setText("");
        txfNroRuc.setText("");
        cbxTipoPersona.setSelectedIndex(0);
        chbxProveedor.setSelected(false);
        txfNdiRucBusqueda.setText("");
        txfNombesBusqueda.setText("");
        txfDirección.setText("");
        chbxTieneruc.setSelected(false);
    }

    private void activarBotones(boolean nuevo, boolean modificar, boolean guardar, boolean cancelar) {
        btnNuevo.setEnabled(nuevo);
        btnEditar.setEnabled(modificar);
        btnGuardar.setEnabled(guardar);
        btnCancelar.setEnabled(cancelar);
    }

    private void configuraCancelar() {
        resetComponent();
        resetPaintComponent();
        estadoTextFieldsPN(false);
        activarBotones(true, false, false, true);
        oModeloPersonas.clear();
        oPersona = null;
        personalizaVistaTabla();
    }

    private Persona registrarPersona() {
        Persona per = new Persona();
        switch (((TipoPersona) cbxTipoPersona.getSelectedItem()).getDescripcion().trim()) {
            case "PERSONA NATURAL":
                if (chbxTieneruc.isSelected()) {
                    if (isValidoCaracteresRuc()) {
                        oPersona = new Persona();
                        oPersonaBl = new PersonaBl();
                        oPersona.setTipoPersona((TipoPersona) cbxTipoPersona.getSelectedItem());
                        oPersona.setApellidoPaterno(txfApePaterno.getText().trim().toUpperCase());
                        oPersona.setApellidoMaterno(txfApeMaterno.getText().trim().toUpperCase());
                        oPersona.setNombre(txfNombres.getText().trim().toUpperCase());
                        oPersona.setNumeroDocumento(txfnNumDni.getText().trim().toUpperCase());
                        oPersona.setFechaNacimiento(jdcFechaNacimiento.getDate());
                        oPersona.setTelefono(txfTelefono.getText().trim());
                        oPersona.setEstado(1);
                        oPersona.setFechaReg(new Date());
                        oPersona.setEsproveedor(chbxProveedor.isSelected() ? 1 : 0);
                        oPersona.setRazonSocial("");
                        oPersona.setDireccion(!txfDirección.getText().trim().equals("") ? txfDirección.getText().toUpperCase().trim() : "");
                        oPersona.setRuc(txfNroRuc.getText().toUpperCase().trim());
                        per = oPersonaBl.registrarPersona(oPersona);
                    } else {
                        JOptionPane.showMessageDialog(null, "El RUC debe contener 11 caracteres", "Atención", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    oPersona = new Persona();
                    oPersonaBl = new PersonaBl();
                    oPersona.setTipoPersona((TipoPersona) cbxTipoPersona.getSelectedItem());
                    oPersona.setApellidoPaterno(txfApePaterno.getText().trim().toUpperCase());
                    oPersona.setApellidoMaterno(txfApeMaterno.getText().trim().toUpperCase());
                    oPersona.setNombre(txfNombres.getText().trim().toUpperCase());
                    oPersona.setNumeroDocumento(txfnNumDni.getText().trim().toUpperCase());
                    oPersona.setFechaNacimiento(jdcFechaNacimiento.getDate());
                    oPersona.setTelefono(txfTelefono.getText().trim());
                    oPersona.setEstado(1);
                    oPersona.setFechaReg(new Date());
                    oPersona.setEsproveedor(chbxProveedor.isSelected() ? 1 : 0);
                    oPersona.setRazonSocial("");
                    oPersona.setDireccion(!txfDirección.getText().trim().equals("") ? txfDirección.getText().toUpperCase().trim() : "");
                    oPersona.setRuc("");
                    per = oPersonaBl.registrarPersona(oPersona);
                }

            case "PERSONA JURIDICA":
                if (isValidoCaracteresRuc()) {
                    oPersona = new Persona();
                    oPersonaBl = new PersonaBl();
                    oPersona.setTipoPersona((TipoPersona) cbxTipoPersona.getSelectedItem());
                    oPersona.setApellidoPaterno(txfApePaterno.getText().trim().toUpperCase());
                    oPersona.setApellidoMaterno("");
                    oPersona.setNombre("");
                    oPersona.setNumeroDocumento(txfNroRuc.getText().trim().toUpperCase());
                    oPersona.setFechaNacimiento(null);
                    oPersona.setTelefono("");
                    oPersona.setEstado(1);
                    oPersona.setFechaReg(new Date());
                    oPersona.setRuc(txfNroRuc.getText().trim().toUpperCase());
                    oPersona.setEsproveedor(chbxProveedor.isSelected() ? 1 : 0);
                    oPersona.setRazonSocial(txfApePaterno.getText().trim().toUpperCase());
                    oPersona.setDireccion(!txfDirección.getText().trim().equals("") ? txfDirección.getText().toUpperCase().trim() : "");
                    per = oPersonaBl.registrarPersona(oPersona);
                } else {
                    JOptionPane.showMessageDialog(null, "El RUC debe contener 11 caracteres", "Atención", JOptionPane.ERROR_MESSAGE);
                }

        }
        return per;

    }

    private int actualizarPersona() {
        int res = 0;
        if (((TipoPersona) cbxTipoPersona.getSelectedItem()).getDescripcion().trim().equals("PERSONA NATURAL")) {
            if (chbxTieneruc.isSelected()) {
                if (isValidoCaracteresRuc()) {
                    oPersona = new Persona();
                    oPersonaBl = new PersonaBl();

                    oPersona.setIdpersona(beanTabla.getIdpersona());
                    oPersona.setSexo(beanTabla.getSexo() != null ? beanTabla.getSexo().trim() : "");
                    oPersona.setTipoDocidentidad(beanTabla.getTipoDocidentidad() != null ? beanTabla.getTipoDocidentidad() : null);
                    oPersona.setFechaNacimiento(beanTabla.getFechaNacimiento() != null ? beanTabla.getFechaNacimiento() : null);
                    oPersona.setEstadoCivil(beanTabla.getEstadoCivil() != null ? beanTabla.getEstadoCivil() : null);
                    oPersona.setLugarNacimiento(beanTabla.getLugarNacimiento() != null ? beanTabla.getLugarNacimiento().trim() : "");
                    oPersona.setGradoInstruccion(beanTabla.getGradoInstruccion() != null ? beanTabla.getGradoInstruccion().trim() : "");
                    oPersona.setOcupacion(beanTabla.getOcupacion() != null ? beanTabla.getOcupacion().trim() : "");
                    oPersona.setAutorizaUsoDatos(beanTabla.getAutorizaUsoDatos() != null ? beanTabla.getAutorizaUsoDatos().trim() : "");

                    oPersona.setTipoPersona((TipoPersona) cbxTipoPersona.getSelectedItem());
                    oPersona.setApellidoPaterno(txfApePaterno.getText().trim().toUpperCase());
                    oPersona.setApellidoMaterno(txfApeMaterno.getText().trim().toUpperCase());
                    oPersona.setNombre(txfNombres.getText().trim().toUpperCase());
                    oPersona.setNumeroDocumento(txfnNumDni.getText().trim());
                    oPersona.setFechaNacimiento(jdcFechaNacimiento.getDate());
                    oPersona.setTelefono(txfTelefono.getText().trim());
                    oPersona.setEstado(beanTabla.getEstado());
                    oPersona.setEsproveedor(chbxProveedor.isSelected() ? 1 : 0);
                    oPersona.setRuc(txfNroRuc.getText().toUpperCase().trim());
                    oPersona.setDireccion(!txfDirección.getText().trim().equals("") ? txfDirección.getText().toUpperCase().trim() : "");
                    oPersona.setRazonSocial("");
                    res = oPersonaBl.actualizar(oPersona);
                } else {
                    JOptionPane.showMessageDialog(null, "El RUC debe contener 11 caracteres", "Atención", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                oPersona = new Persona();
                oPersonaBl = new PersonaBl();

                oPersona.setIdpersona(beanTabla.getIdpersona());
                oPersona.setSexo(beanTabla.getSexo() != null ? beanTabla.getSexo().trim() : "");
                oPersona.setTipoDocidentidad(beanTabla.getTipoDocidentidad() != null ? beanTabla.getTipoDocidentidad() : null);
                oPersona.setFechaNacimiento(beanTabla.getFechaNacimiento() != null ? beanTabla.getFechaNacimiento() : null);
                oPersona.setEstadoCivil(beanTabla.getEstadoCivil() != null ? beanTabla.getEstadoCivil() : null);
                oPersona.setLugarNacimiento(beanTabla.getLugarNacimiento() != null ? beanTabla.getLugarNacimiento().trim() : "");
                oPersona.setGradoInstruccion(beanTabla.getGradoInstruccion() != null ? beanTabla.getGradoInstruccion().trim() : "");
                oPersona.setOcupacion(beanTabla.getOcupacion() != null ? beanTabla.getOcupacion().trim() : "");
                oPersona.setAutorizaUsoDatos(beanTabla.getAutorizaUsoDatos() != null ? beanTabla.getAutorizaUsoDatos().trim() : "");

                oPersona.setTipoPersona((TipoPersona) cbxTipoPersona.getSelectedItem());
                oPersona.setApellidoPaterno(txfApePaterno.getText().trim().toUpperCase());
                oPersona.setApellidoMaterno(txfApeMaterno.getText().trim().toUpperCase());
                oPersona.setNombre(txfNombres.getText().trim().toUpperCase());
                oPersona.setNumeroDocumento(txfnNumDni.getText().trim());
                oPersona.setFechaNacimiento(jdcFechaNacimiento.getDate());
                oPersona.setTelefono(txfTelefono.getText().trim());
                oPersona.setEstado(beanTabla.getEstado());
                oPersona.setEsproveedor(chbxProveedor.isSelected() ? 1 : 0);
                oPersona.setRuc(txfNroRuc.getText().toUpperCase().trim());
                oPersona.setRazonSocial("");
                oPersona.setDireccion(!txfDirección.getText().trim().equals("") ? txfDirección.getText().toUpperCase().trim() : "");
                res = oPersonaBl.actualizar(oPersona);
            }

        } else if (((TipoPersona) cbxTipoPersona.getSelectedItem()).getDescripcion().trim().equals("PERSONA JURIDICA")) {
            if (isValidoCaracteresRuc()) {
                oPersona = new Persona();
                oPersonaBl = new PersonaBl();

                oPersona.setIdpersona(beanTabla.getIdpersona());
                oPersona.setSexo(beanTabla.getSexo() != null ? beanTabla.getSexo().trim() : "");
                oPersona.setTipoDocidentidad(beanTabla.getTipoDocidentidad() != null ? beanTabla.getTipoDocidentidad() : null);
                oPersona.setFechaNacimiento(beanTabla.getFechaNacimiento() != null ? beanTabla.getFechaNacimiento() : null);
                oPersona.setEstadoCivil(beanTabla.getEstadoCivil() != null ? beanTabla.getEstadoCivil() : null);
                oPersona.setLugarNacimiento(beanTabla.getLugarNacimiento() != null ? beanTabla.getLugarNacimiento().trim() : "");
                oPersona.setGradoInstruccion(beanTabla.getGradoInstruccion() != null ? beanTabla.getGradoInstruccion().trim() : "");
                oPersona.setOcupacion(beanTabla.getOcupacion() != null ? beanTabla.getOcupacion().trim() : "");
                oPersona.setAutorizaUsoDatos(beanTabla.getAutorizaUsoDatos() != null ? beanTabla.getAutorizaUsoDatos().trim() : "");

                oPersona.setTipoPersona((TipoPersona) cbxTipoPersona.getSelectedItem());
                oPersona.setApellidoPaterno(txfApePaterno.getText().trim().toUpperCase());
                oPersona.setApellidoMaterno("");
                oPersona.setNombre("");
                oPersona.setNumeroDocumento(txfNroRuc.getText().trim().toUpperCase());
                oPersona.setFechaNacimiento(null);
                oPersona.setTelefono(txfTelefono.getText().trim());
                oPersona.setEstado(1);
                oPersona.setFechaReg(new Date());
                oPersona.setRuc(txfNroRuc.getText().toUpperCase().trim());
                oPersona.setEsproveedor(chbxProveedor.isSelected() ? 1 : 0);
                oPersona.setRazonSocial(txfApePaterno.getText().trim().toUpperCase());
                oPersona.setDireccion(!txfDirección.getText().trim().equals("") ? txfDirección.getText().toUpperCase().trim() : "");
                res = oPersonaBl.actualizar(oPersona);
            } else {
                JOptionPane.showMessageDialog(null, "El RUC debe contener 11 caracteres", "Atención", JOptionPane.ERROR_MESSAGE);
            }

        }
        //Validar  Dni        
        return res;
    }

    private void cargarDatosPersona() {
        //root.jifAdmisionPaciente.cargarDatosPersona(beanTabla);
        switch (getInvocador()) {
            case JIF_CITA:
                root.jifRegistrarCita.cargarDatosPersona(beanTabla);
                break;
            case JIF_USUARIO:
                root.jifRegistrarUsuario.cargarDatosPersona(beanTabla);
                break;
            //case JIF_VENTAS:
            //root.jifRegVentas.cargarDatosPaciente(beanTabla);
            //break;
            case JIF_VENTAS2:
                root.jifRegVentas.cargarDatosPersonaCliente(beanTabla);
                break;
            case JIF_COBRO_CAJA:
                root.jifCobroCaja.cargarDatosPersona(beanTabla);
                break;
            case JIF_COMPRAS:
                root.jifCompras.cargarDatosProveedor(beanTabla);
                break;
            case JIF_REGISTRAR_MEDICO:
                root.jifAdministrarMedico.cargarDatosPerona(beanTabla);
                break;
        }

    }

    private boolean isDniValido() {
        oPersonaBl = new PersonaBl();
        boolean existeDni = false;
        switch (((TipoPersona) cbxTipoPersona.getSelectedItem()).getDescripcion()) {
            case "PERSONA NATURAL":
                if (oPersonaBl.buscarPersonaXDni(txfnNumDni.getText().trim()) != null) {
                    existeDni = false;
                } else {
                    existeDni = true;
                }
                break;
            case "PERSONA JURIDICA":
                if (oPersonaBl.buscarPersonaXDni(txfNroRuc.getText().trim()) != null) {
                    existeDni = false;
                } else {
                    existeDni = true;
                }
                break;
        }

        return existeDni;
    }

    public int getInvocador() {
        return invocador;
    }

    public void setInvocador(int invocador) {
        this.invocador = invocador;
    }

    public void inicializar() {
        cargarCbcTipoPersona();
        txfNombesBusqueda.setText("");
        txfNdiRucBusqueda.setText("");
        oModeloPersonas.clear();
        personalizaVistaTabla();
        resetComponent();
    }

    private void cargarCbcTipoPersona() {
        TipoPersonaCtrl oTipoPersonaCtrl = new TipoPersonaCtrl(root);
        oTipoPersonaCtrl.rellenaCbx(cbxTipoPersona);
    }

    private void buscarPersonaxNroDoc() {
        String ref = txfNdiRucBusqueda.getText().trim();
        if (!ref.equals("")) {
            oPersonaBl = new PersonaBl();
            listPersonas = new LinkedList<>();
            oModeloPersonas.clear();
            listPersonas = oPersonaBl.listarPersonaXDoc(ref);
            for (Persona obj : listPersonas) {
                oModeloPersonas.add(obj);
            }
        } else {
            Mensajes.msjParametroVacio();
        }
    }

    private void buscarPersonaxNombres() {
        String ref = txfNombesBusqueda.getText().toUpperCase().trim();
        if (!ref.equals("")) {
            oPersonaBl = new PersonaBl();
            listPersonas = new LinkedList<>();
            oModeloPersonas.clear();
            listPersonas = oPersonaBl.listarPersonaXNombres(ref);
            for (Persona obj : listPersonas) {
                oModeloPersonas.add(obj);
            }
        } else {
            Mensajes.msjParametroVacio();
        }
    }

    private void configuraInterfazPersona() {
        if (cbxTipoPersona.getSelectedIndex() > 0) {
            if (((TipoPersona) cbxTipoPersona.getSelectedItem()).getDescripcion().equals("PERSONA NATURAL")) {
                estadoTextFieldsPN(true);
            } else if (((TipoPersona) cbxTipoPersona.getSelectedItem()).getDescripcion().equals("PERSONA JURIDICA")) {
                estadoTextFieldsPJ(true);
            }
        }
    }

    private void estadoTextFieldsPN(Boolean e) {
        this.txfApePaterno.setEnabled(e);
        this.txfApeMaterno.setEnabled(e);
        this.txfNombres.setEnabled(e);
        this.jdcFechaNacimiento.setEnabled(e);
        this.txfnNumDni.setEnabled(e);
        this.txfTelefono.setEnabled(e);
        txfNroRuc.setEnabled(e);
        txfDirección.setEnabled(e);
    }

    private void estadoTextFieldsPJ(Boolean e) {
        estadoTextFieldsPN(false);
        txfApePaterno.setEnabled(e);
        txfNroRuc.setEnabled(e);
        txfTelefono.setEnabled(e);
        txfDirección.setEnabled(e);
    }

    public boolean isValidoRuc() {
        return (!txfNroRuc.getText().trim().equals("")
                && Utilitarios.getNumeroCaracteres(txfNroRuc) == 11);
    }

    private boolean isValidoCaracteresRuc() {
        return (Utilitarios.getNumeroCaracteres(txfNroRuc) == 11
                && !txfNroRuc.getText().trim().equals(""));
    }

    private boolean isValidoNumeroCaracteresDoc() {
        switch (((TipoPersona) cbxTipoPersona.getSelectedItem()).getDescripcion().trim()) {
            case "PERSONA NATURAL":
                return (Utilitarios.getNumeroCaracteres(txfnNumDni) == 8);
            case "PERSONA JURIDICA":
                return (Utilitarios.getNumeroCaracteres(txfNroRuc) == 11);
            default:
                return false;
        }
    }

}
