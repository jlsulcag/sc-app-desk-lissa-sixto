package lissa.gui.farmacia;

import lissa.be.AreaConsumo;
import lissa.bl.AreaConsumoBl;
import lissa.gui.JF_Principal;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_RegAreaConsumo extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private AreaConsumo oAreaConsumo;
    private AreaConsumoBl oAreaConsumoBl;
    //Invocador
    private int invocador;
    public static final int JIF_REGFAMILIA = 1;
    private JIF_NotaSalidaFar jifNotaSalidaFar;


    public JIF_RegAreaConsumo(JF_Principal root) {
        this.root = root;
        initComponents();
        jifNotaSalidaFar=new JIF_NotaSalidaFar(root);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfFamilia = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Registrar Dependencia");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
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
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setText("Dependencia :");

        txfFamilia.setBackground(new java.awt.Color(255, 255, 204));
        txfFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfFamiliaActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
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
                .addComponent(txfFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (isDatosValidos()) {
            if (registrar() != null) {
                //Mensajes.msjActCorrecta();
                resetConponent();
                resetPaintComponent();
                this.doDefaultCloseAction();//Cerrar jif actual
            }else{
                Mensajes.msjRegError();
            }
            
        } else {
            Mensajes.msjValidarIngreso();
            paintComponentes();
        }
        jifNotaSalidaFar.actualizarLista();

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txfFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfFamiliaActionPerformed
        btnRegistrar.doClick();
    }//GEN-LAST:event_txfFamiliaActionPerformed

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
    private javax.swing.JTextField txfFamilia;
    // End of variables declaration//GEN-END:variables
     
    public int getInvocador() {
        return invocador;
    }

    public void setInvocador(int invocador) {
        this.invocador = invocador;
    }
    
    private boolean isDatosValidos() {
        return (!txfFamilia.getText().trim().equals(""));
    }

    private AreaConsumo registrar() {
        oAreaConsumo = new AreaConsumo();
        oAreaConsumoBl = new AreaConsumoBl();

        oAreaConsumo.setDescripcion(txfFamilia.getText().toUpperCase().trim());

        return oAreaConsumoBl.registrar(oAreaConsumo);
    }

    private void resetConponent() {
        txfFamilia.setText("");
    }
    
    private void resetConponentFull() {
        txfFamilia.setText("");
        resetPaintComponent();
    }

    private void resetPaintComponent() {
        Utilitarios.resetPaintBorderTxf(txfFamilia);
    }

    private void paintComponentes() {   
        Utilitarios.paintBorderTxfVacio(txfFamilia);
    }

    void enviarJif(JIF_NotaSalidaFar jif) {
        jifNotaSalidaFar=jif;
    }

}
