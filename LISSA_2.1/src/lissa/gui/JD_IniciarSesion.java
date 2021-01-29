package lissa.gui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import lissa.be.Persona;
import lissa.be.Rol;
import lissa.be.Usuario;
import lissa.be.UsuarioRol;
import lissa.bl.PersonaBl;
import lissa.bl.RolBl;
import lissa.bl.UsuarioBl;
import lissa.bl.UsuarioRolBl;
import lissa.controller.RolCtrl;
import lissa.gui.farmacia.JIF_PrincipalFarmacia;
import lissa.util.Utilitarios;
import org.apache.commons.codec.digest.DigestUtils;
import org.rx.cr.util.gui.ShapeDecorated;
import org.rx.cr.util.gui.UndecoratedMove;

public final class JD_IniciarSesion extends javax.swing.JDialog {

    private UndecoratedMove moveAdapter = null;
    private ShapeDecorated guiDecorated = null;
    private JF_Principal root = null;
    private Usuario oUsuario = null;
    private UsuarioBl oBlUsuario = null;
    private Persona oPersona = null;
    private PersonaBl oBLPersona = null;
    private Rol oRol = null;
    private RolBl oBlRol = null;
    private UsuarioRol oUsuarioRol = null;
    private UsuarioRolBl oBlUsuarioRol = null;

    private Set<UsuarioRol> rolesUsuario = null;
    private JIF_EmitirComprobante jifEmitirComprobante = null;
    private JIF_HistoriaClinica jifHistoriaClinica = null;
    private JPanel_HistoriaClinica jPanelHistoriaClinica = null;
    private RolCtrl oRolCtrl;
    private ArrayList<Rol> listRoles;

    //Ventana Inicial para el modulo de farmacia
    private JIF_PrincipalFarmacia rootFarm = null;

    public JD_IniciarSesion() {
        initComponents();
    }

    public JD_IniciarSesion(JF_Principal root) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        super(root, true);
        initComponents();
        this.root = root;
        personalizaLoguin();
        jifEmitirComprobante = new JIF_EmitirComprobante(this.root);
        jifHistoriaClinica = new JIF_HistoriaClinica(this.root);
        jPanelHistoriaClinica = new JPanel_HistoriaClinica(this.root);
    }
    /*
     public JD_IniciarSesion(JIF_PrincipalFarmacia rootFarm) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
     super(rootFarm, true);
     initComponents();
     this.rootFarm = rootFarm;
     personalizaLoguin();
     }
     */

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txfUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txpClave = new javax.swing.JPasswordField();
        cbxResponsabilidad = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(54, 119, 187), 1, true));
        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(8, 120, 192));
        jLabel2.setText("Usuario :");

        txfUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfUsuarioActionPerformed(evt);
            }
        });
        txfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfUsuarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfUsuarioKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(8, 120, 192));
        jLabel3.setText("Contraseña :");

        txpClave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txpClave.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txpClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txpClaveActionPerformed(evt);
            }
        });
        txpClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txpClaveKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txpClaveKeyReleased(evt);
            }
        });

        cbxResponsabilidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxResponsabilidadKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(8, 120, 192));
        jLabel5.setText("Responsabilidad :");

        jPanel2.setBackground(new java.awt.Color(54, 119, 187));

        jLabel1.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Users.png"))); // NOI18N
        jLabel1.setText("Datos de Usuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAceptarKeyPressed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(54, 119, 187));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 12));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txpClave)
                            .addComponent(txfUsuario)
                            .addComponent(cbxResponsabilidad, 0, 210, Short.MAX_VALUE))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txpClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxResponsabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txfUsuario.setText("");
        txpClave.setText("");
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (cbxResponsabilidad.getSelectedIndex() > 0) {
            iniciarSistemaxRol((Rol) cbxResponsabilidad.getSelectedItem());
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una Responsabilidad", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfUsuarioActionPerformed
        txpClave.requestFocus();
    }//GEN-LAST:event_txfUsuarioActionPerformed

    private void txpClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txpClaveActionPerformed
        //btnAceptar.doClick();
    }//GEN-LAST:event_txpClaveActionPerformed

    private void txfUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUsuarioKeyPressed
        escapeExit(evt);
    }//GEN-LAST:event_txfUsuarioKeyPressed

    private void txpClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txpClaveKeyPressed
        escapeExit(evt);
    }//GEN-LAST:event_txpClaveKeyPressed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        escapeExit(evt);
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarKeyPressed
        escapeExit(evt);
    }//GEN-LAST:event_btnAceptarKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void txfUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUsuarioKeyReleased
        if (txfUsuario.getText().length() > 0) {
            txfUsuario.setText(txfUsuario.getText().toUpperCase());
        }
    }//GEN-LAST:event_txfUsuarioKeyReleased

    private void txpClaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txpClaveKeyReleased
        if (txpClave.getText().length() > 0) {
            txpClave.setText(txpClave.getText().toUpperCase());
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                cbxResponsabilidad.requestFocus();
                //listar las responsabilidades o roles que tenga dicho usuario
                validarDatosUsuario();
            } catch (Exception ex) {
                Logger.getLogger(JD_IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txpClaveKeyReleased

    private void cbxResponsabilidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxResponsabilidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAceptar.doClick();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            escapeExit(evt);
        }
    }//GEN-LAST:event_cbxResponsabilidadKeyPressed

    public void personalizaLoguin() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        moveAdapter = new UndecoratedMove();
        moveAdapter.MoveAdapter(this);
        guiDecorated = new ShapeDecorated();
        guiDecorated.applyShape(this, 30f, 30f);
        Utilitarios.centreaVentana(this);
        //personalizaFondoLoguin(jPanel1);
        /*javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
         SwingUtilities.updateComponentTreeUI(JD_IniciarSesion.this);*/

    }

    public void escapeExit(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    public void validaConfFile() {
        if (root.getConfig() == null) {
            JOptionPane.showMessageDialog(this, "Configure datos del servidor", "Atencion", JOptionPane.ERROR_MESSAGE);
            root.jdConf.setVisible(true);
        }

    }

    public void validarDatosUsuario() throws Exception {
        oBlUsuario = new UsuarioBl();
        oBlUsuarioRol = new UsuarioRolBl();
        if (txfUsuario.getText().trim().length() > 0 && txpClave.getText().trim().length() > 0) {
            oUsuario = oBlUsuario.buscarUsuario(txfUsuario.getText().trim(), DigestUtils.md5Hex(txpClave.getText().trim()));
            if (oUsuario != null && oUsuario.getIdUsuario() > 0) {
                oPersona = new Persona();
                oBLPersona = new PersonaBl();
                oPersona = oBLPersona.buscarPersonaXid(oUsuario.getPersona().getIdpersona());
                if (oUsuario.getEstado() == true) {
                    //Llenar el combo con los roles del usuario logueado
                    oRolCtrl = new RolCtrl(root);
                    listRoles = oRolCtrl.rellenaRolxUsuario(cbxResponsabilidad, oUsuario.getIdUsuario());
                    if (listRoles.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "El Usuario no tiene roles asignados ", "Atencion", JOptionPane.INFORMATION_MESSAGE);
                    }

                } else {
                    txfUsuario.requestFocus();
                    JOptionPane.showMessageDialog(this, "Su cuenta se encuentra inactiva \ncontactese con el administrador ", "Atencion", JOptionPane.INFORMATION_MESSAGE);
                }

            } else {
                txpClave.setText("");
                txfUsuario.requestFocus();
                JOptionPane.showMessageDialog(this, "Usuario y/o Contraseña incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            txfUsuario.requestFocus();
            JOptionPane.showMessageDialog(this, "Ingrese su Usuario y Contraseña", "Atencion", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void iniciarSistemaxRol(Rol rol) {
        switch (rol.getDenominacion().trim()) {
            case "ADMISION":
                root.configuraInterfazAdmision();
                break;
            case "CAJA":
                root.configuraInterfazAdmision();
                break;
            case "TRIAJE":
                root.configuraInterfazTriaje();
                break;
            case "GERENCIA GENERAL":
                root.configuraInterfazJefeCaja();
                break;
            case "FARMACIA":
                root.configuraInterfazFarmacia();
                break;
            case "SISTEMAS":
                root.configuraInterfazSistemas();
                break;
            case "JEFE CAJA":
                root.configuraInterfazJefeCaja();
                break;
            default:
                dispose();
                root.configuraInterfazJefeVacio();
                break;
        }
        txfUsuario.setText("");
        txpClave.setText("");
        cbxResponsabilidad.removeAllItems();
        txfUsuario.requestFocus();
        dispose();
        root.setUser(oUsuario);
        root.setoPersona(oPersona);
        root.setoRol(rol);
        root.setTitle("LISSA 2.0 - " + rol.getDenominacion().trim() + " - "+ oUsuario.getNombre());
            //root.setVisible(true);

    }

//    public void personalizaFondoLoguin(JPanel jp) {
//        BufferedImage imagen = null;
//        URL path = getClass().getResource("/org/edessco/sisregcivil/resource/cobert_loguin.png");
//        try {
//            imagen = ImageIO.read(path);
//            jp.setBorder(new DesktopPaneBackground(imagen));
//        } catch (java.io.IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    public class DesktopPaneBackground implements Border {

        private final BufferedImage image;

        public DesktopPaneBackground(BufferedImage image) {
            this.image = image;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(0, 0, 0, 0);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawImage(image, 0, 0, c.getWidth(), c.getHeight() + 50, null);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cbxResponsabilidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txfUsuario;
    private javax.swing.JPasswordField txpClave;
    // End of variables declaration//GEN-END:variables

}
