
package lissa.gui.farmacia;

import lissa.be.FormaFarmaceutica;
import lissa.bl.FormaFarmaceuticaBl;
import lissa.gui.JF_Principal;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_RegFormaFarmaceutica extends javax.swing.JInternalFrame {
    private JF_Principal root;
    private FormaFarmaceutica oClase;
    private FormaFarmaceuticaBl oClaseBl;
    //Invocador
    private int invocador;
    public static final int JIF_REGCLASE = 1;
    private JIF_NuevoProducto jifNuevoProducto;
    
    
    public JIF_RegFormaFarmaceutica(JF_Principal root) {
        initComponents();
        this.root = root;
        jifNuevoProducto=new JIF_NuevoProducto(root);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfClase = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Registrar Forma Farmaceutica");
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

        jLabel1.setText("Forma Farmaceutica :");

        txfClase.setBackground(new java.awt.Color(255, 255, 204));
        txfClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfClaseActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.setToolTipText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfClase, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(isDatosValidos()){
            if(registrar() != null){
                //Mensajes.msjRegCorrecta();
                resetConponent();
                resetPaintComponent();
                this.doDefaultCloseAction();//Cerrar jif actual
            }else{
                Mensajes.msjRegError();
            }
        }else{
            Mensajes.msjValidarIngreso();
            paintComponentes();
        }
        jifNuevoProducto.actualizarFormaFarmaceutica();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txfClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfClaseActionPerformed
        btnRegistrar.doClick();
    }//GEN-LAST:event_txfClaseActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        resetConponentFull();
    }//GEN-LAST:event_formInternalFrameClosing

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        resetConponentFull();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txfClase;
    // End of variables declaration//GEN-END:variables
    
     public int getInvocador() {
        return invocador;
    }

    public void setInvocador(int invocador) {
        this.invocador = invocador;
    }
    
    
    private boolean isDatosValidos() {
        return (!txfClase.getText().trim().equals(""));
    }

    private FormaFarmaceutica registrar() {
        oClase = new FormaFarmaceutica();
        oClaseBl = new FormaFarmaceuticaBl();
        
        oClase.setDenominacion(txfClase.getText().toUpperCase().trim());
        oClase.setEstado(Boolean.TRUE);
        
        return oClaseBl.registrar(oClase);
    }

    private void resetConponent() {
        txfClase.setText("");
    }
    
    private void resetConponentFull() {
        txfClase.setText("");
        resetPaintComponent();
    }

    private void paintComponentes() {
        Utilitarios.paintBorderTxfVacio(txfClase);
    }

    private void resetPaintComponent() {
        Utilitarios.resetPaintBorderTxf(txfClase);
    }
    void enviarJif(JIF_NuevoProducto aThis) {
        jifNuevoProducto=aThis;
    }
}
