package lissa.gui;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lissa.be.Usuario;
import lissa.bl.UsuarioBl;
import lissa.table.ModeloUsuario;
import lissa.util.Utilitarios;

public class JIF_BuscarCajeros extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private Usuario usuario;
    private UsuarioBl oUsuarioBl;
    private ArrayList<Usuario> listUsers;
    private ModeloUsuario modeloUsuario;
    private List<Usuario> listUsuarios;

    public JIF_BuscarCajeros(JF_Principal root) {
        initComponents();
        this.root = root;
        modeloUsuario = new ModeloUsuario();
        tblUsuarios.setModel(modeloUsuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfNombres = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txfUsuario = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
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

        jLabel1.setText("Apellidos y Nombres :");

        txfNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombresActionPerformed(evt);
            }
        });
        txfNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNombresKeyReleased(evt);
            }
        });

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblUsuariosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        jLabel2.setText("Usuario :");

        txfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfUsuarioKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfUsuario)
                            .addComponent(txfNombres)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
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

    private void tblUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMousePressed
        if(evt.getClickCount() == 2){
            enviarDatos();
            this.doDefaultCloseAction();
        }
    }//GEN-LAST:event_tblUsuariosMousePressed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        resetComponent();
    }//GEN-LAST:event_formInternalFrameClosing

    private void txfNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombresActionPerformed
        
    }//GEN-LAST:event_txfNombresActionPerformed

    private void txfNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombresKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarxApellidosyNombres();
        }
    }//GEN-LAST:event_txfNombresKeyReleased

    private void txfUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUsuarioKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarxNombreUsuario();
        }
    }//GEN-LAST:event_txfUsuarioKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txfNombres;
    private javax.swing.JTextField txfUsuario;
    // End of variables declaration//GEN-END:variables

    
    private void buscarxApellidosyNombres() {
        oUsuarioBl = new UsuarioBl();
        listUsuarios = new LinkedList<>();
        String ref = txfNombres.getText().trim().toUpperCase();
        listUsuarios = oUsuarioBl.buscarxApellidosyNombres(ref);
        for (Usuario obj : listUsuarios) {
            modeloUsuario.add(obj);
        }
        personalizarTablas();
        txfNombres.setText("");
    }
    
    private void buscarxNombreUsuario() {
        oUsuarioBl = new UsuarioBl();
        listUsuarios = new LinkedList<>();
        String ref = txfUsuario.getText().trim().toUpperCase();
        listUsuarios = oUsuarioBl.buscarxNombreUsuario(ref);
        for (Usuario obj : listUsuarios) {
            modeloUsuario.add(obj);
        }
        personalizarTablas();
        txfUsuario.setText("");
    }

    private void enviarDatos() {
        usuario = modeloUsuario.get(tblUsuarios.getSelectedRow());
        if(usuario != null){
            root.jifAbrirCaja.cargarDatosUsuario(usuario);
        }
    }

    private void resetComponent() {
        txfNombres.setText("");
        modeloUsuario.clear();
    }

    private void personalizarTablas() {
        Utilitarios.formateaColumna(0, tblUsuarios, 60);
    }
}
