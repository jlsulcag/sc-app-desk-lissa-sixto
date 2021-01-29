package lissa.gui;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import lissa.be.PersonaJuridica;
import lissa.bl.PersonaJuridicaBl;
import lissa.table.ModeloPersonaJuridica;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_BuscarPersonaJuridica extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private PersonaJuridica oPersonaJuridica;
    private PersonaJuridica oPersonaJuridicaTabla; 
    private PersonaJuridicaBl oPersonaJuridicaBl;
    private ArrayList<PersonaJuridica> listPersona;
    private ModeloPersonaJuridica oModeloPersonaJuridica;
    private JPanel_Admision jpAdmision;
    //Invocador
    private int invocador;
    //Variables para determinar que ventana es la que llama
    public static final int JIF_ADMISION = 1;

    public JIF_BuscarPersonaJuridica(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloPersonaJuridica = new ModeloPersonaJuridica();
        tblPersonaJuridica.setModel(oModeloPersonaJuridica);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txfRuc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonaJuridica = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txfRazonSocial = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Buscar Persona Juridica");
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

        txfRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfRucKeyPressed(evt);
            }
        });

        tblPersonaJuridica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPersonaJuridica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblPersonaJuridicaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblPersonaJuridica);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel1.setText("N° Ruc :");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel2.setText("Razon Social :");

        txfRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfRazonSocialKeyPressed(evt);
            }
        });

        jButton3.setText("Nuevo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txfRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPersonaJuridicaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonaJuridicaMouseReleased
        if(tblPersonaJuridica.getRowSelectionAllowed()){
            obtenerDatos();
        }
    }//GEN-LAST:event_tblPersonaJuridicaMouseReleased

    private void txfRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfRucKeyPressed
        oModeloPersonaJuridica.clear();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txfRuc.getText().toUpperCase().trim().equals("")) {
                buscarPersonaJuridicaxRuc();
            } else {

            }

        }
    }//GEN-LAST:event_txfRucKeyPressed

    private void txfRazonSocialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfRazonSocialKeyPressed
        oModeloPersonaJuridica.clear();
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!txfRazonSocial.getText().toUpperCase().trim().equals("")){
                buscarPersonaJuridicaxNombre();
            }else{
            
            }
        }
    }//GEN-LAST:event_txfRazonSocialKeyPressed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        personalizarTabla();
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        personalizarTabla();
    }//GEN-LAST:event_formInternalFrameClosing

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        resetComponent();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPersonaJuridica;
    private javax.swing.JTextField txfRazonSocial;
    private javax.swing.JTextField txfRuc;
    // End of variables declaration//GEN-END:variables

    public void buscarPersonaJuridicaxNombre() {
        oPersonaJuridicaBl = new PersonaJuridicaBl();
        String ref = txfRazonSocial.getText().trim().toUpperCase();
        listPersona = oPersonaJuridicaBl.buscarPersonaJuridica(ref);
        if (!listPersona.isEmpty()) {
            oModeloPersonaJuridica.addAll(listPersona);
        } else {
            Mensajes.msjResultVacio();
        }
        txfRuc.setText("");
        personalizarTabla();
    }

    public void personalizarTabla() {
        Utilitarios.formateaColumna(0, tblPersonaJuridica, 50);
        Utilitarios.formateaColumna(2, tblPersonaJuridica, 100);
    }

    public void buscarPersonaJuridicaxRuc() {
        if (!txfRuc.getText().trim().equals("")) {
            oPersonaJuridica = new PersonaJuridica();
            oPersonaJuridicaBl = new PersonaJuridicaBl();
            oPersonaJuridica = oPersonaJuridicaBl.buscarxRuc(txfRuc.getText().trim());
            if (oPersonaJuridica != null) {
                oModeloPersonaJuridica.add(oPersonaJuridica);
            } else {
                Mensajes.msjResultVacio();
            }
        } else {
            Mensajes.msjParametroVacio();
        }
    }

    public void resetComponent() {
        txfRuc.setText("");
        txfRazonSocial.setText("");
        oModeloPersonaJuridica.clear();
    }

    public int getInvocador() {
        return invocador;
    }

    public void setInvocador(int invocador) {
        this.invocador = invocador;
    }

    public void obtenerDatos() {
        oPersonaJuridicaTabla = oModeloPersonaJuridica.get(tblPersonaJuridica.getSelectedRow());
    }

    void enviarPanel(JPanel_Admision aThis) {
        jpAdmision = aThis;
    }

}
