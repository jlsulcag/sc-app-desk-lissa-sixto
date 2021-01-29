package lissa.gui;

import javax.swing.JOptionPane;
import lissa.be.Persona;
import lissa.be.Usuario;
import lissa.bl.UsuarioBl;
import org.apache.commons.codec.digest.DigestUtils;

public class JIF_CambiarContraseña extends javax.swing.JInternalFrame {

    private JF_Principal root = null;
    private Persona oPersona = null;
    private Usuario oUsuario = null;
    private Usuario oUsuarioTemp = null;
    private UsuarioBl oBlUsuario = null;

    public JIF_CambiarContraseña(JF_Principal root) {
        initComponents();
        this.root = root;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txfUsuario = new javax.swing.JTextField();
        txfCuenta = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        txfContraseniaNueva = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        txfContraseniaActual = new javax.swing.JPasswordField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cambiar Contraseña");
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

        jLabel1.setText("Cuenta : ");

        jLabel3.setText("Usuario : ");

        jLabel4.setText("Contraseña Nueva : ");

        txfUsuario.setEnabled(false);

        txfCuenta.setEnabled(false);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Save.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txfContraseniaNueva.setMaximumSize(new java.awt.Dimension(255, 2147483647));
        txfContraseniaNueva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfContraseniaNuevaKeyReleased(evt);
            }
        });

        jLabel5.setText("Contraseña actual : ");

        txfContraseniaActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfContraseniaActualKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addComponent(txfContraseniaNueva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfUsuario)
                    .addComponent(txfContraseniaActual))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txfContraseniaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txfContraseniaNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (isContrasenia()) {
            if (!txfContraseniaNueva.getText().trim().equals("")) {
                actualizarContrasenia();
                JOptionPane.showMessageDialog(null, "La contraseña fue actualizada", "Atención", JOptionPane.INFORMATION_MESSAGE);
                resetcomponent();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese la contraseña nueva", "Atención", JOptionPane.INFORMATION_MESSAGE);
                txfContraseniaNueva.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "La contraseña actual es incorrecta", "Atención", JOptionPane.INFORMATION_MESSAGE);
            txfContraseniaActual.setText("");
            txfContraseniaActual.requestFocus();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        
    }//GEN-LAST:event_formInternalFrameClosing

    private void txfContraseniaActualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfContraseniaActualKeyReleased
        if(txfContraseniaActual.getText().length()>0){
            txfContraseniaActual.setText(txfContraseniaActual.getText().toUpperCase());
        }
    }//GEN-LAST:event_txfContraseniaActualKeyReleased

    private void txfContraseniaNuevaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfContraseniaNuevaKeyReleased
        if(txfContraseniaNueva.getText().length()>0){
            txfContraseniaNueva.setText(txfContraseniaNueva.getText().toUpperCase());
        }
    }//GEN-LAST:event_txfContraseniaNuevaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txfContraseniaActual;
    private javax.swing.JPasswordField txfContraseniaNueva;
    private javax.swing.JTextField txfCuenta;
    private javax.swing.JTextField txfUsuario;
    // End of variables declaration//GEN-END:variables

    public void cargarDatosUser(Usuario user, Persona persona) {
        this.setoPersona(persona);
        this.setoUsuario(user);

        txfUsuario.setText(getoPersona().getNombre().trim() + " " + getoPersona().getApellidoPaterno().trim() + " " + getoPersona().getApellidoMaterno().trim());
        txfCuenta.setText(getoUsuario().getNombre().trim());
    }

    public Persona getoPersona() {
        return oPersona;
    }

    public void setoPersona(Persona oPersona) {
        this.oPersona = oPersona;
    }

    public Usuario getoUsuario() {
        return oUsuario;
    }

    public void setoUsuario(Usuario oUsuario) {
        this.oUsuario = oUsuario;
    }

    private void resetcomponent() {
        txfContraseniaActual.setText("");
        txfContraseniaNueva.setText("");
    }

    private boolean isContrasenia() {
        boolean contrasenia = false;
        String passActual = DigestUtils.md5Hex(txfContraseniaActual.getText().trim());
        if (getoUsuario().getContrasenia().trim().equals(passActual)) {
            contrasenia = true;
        } else {
            contrasenia = false;
        }
        return contrasenia;
    }

    private void actualizarContrasenia() {
        oUsuarioTemp = new Usuario();
        oBlUsuario = new UsuarioBl();

        oUsuarioTemp.setIdUsuario(getoUsuario().getIdUsuario());
        oUsuarioTemp.setNombre(getoUsuario().getNombre());
        oUsuarioTemp.setPersona(getoPersona());
        oUsuarioTemp.setContrasenia(DigestUtils.md5Hex(txfContraseniaNueva.getText().trim()));
        oUsuarioTemp.setEstado(true);

        oBlUsuario.actualizar(oUsuarioTemp);
    }
}
