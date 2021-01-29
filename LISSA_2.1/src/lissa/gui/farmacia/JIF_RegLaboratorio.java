package lissa.gui.farmacia;

import lissa.be.Laboratorio;
import lissa.bl.LaboratorioBl;
import lissa.gui.JF_Principal;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_RegLaboratorio extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private Laboratorio oLaboratorio;
    private LaboratorioBl oLaboratorioBl;
    //Invocador
    private int invocador;
    public static final int JIF_REGLABORATORIO = 1;
    private JIF_NuevoProducto jifNuevoProducto;

    public JIF_RegLaboratorio(JF_Principal root) {
        initComponents();
        this.root = root;
        jifNuevoProducto = new JIF_NuevoProducto(root);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfLaboratorio = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Registrar Laboratorio");
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

        jLabel1.setText("Laboratorio :");

        txfLaboratorio.setBackground(new java.awt.Color(255, 255, 204));
        txfLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfLaboratorioActionPerformed(evt);
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
                .addComponent(txfLaboratorio, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar))
                .addContainerGap(20, Short.MAX_VALUE))
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

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (isDatosValidos()) {
            if (registrar() != null) {
                //Mensajes.msjActCorrecta();
                resetConponent();
                resetPaintComponent();
                this.doDefaultCloseAction(); //cerrar el jif
            } else {
                Mensajes.msjRegError();
            }

        } else {
            Mensajes.msjValidarIngreso();
            paintComponentes();
        }
        jifNuevoProducto.actualizarLaboratorio();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txfLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfLaboratorioActionPerformed
        btnRegistrar.doClick();
    }//GEN-LAST:event_txfLaboratorioActionPerformed

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
    private javax.swing.JTextField txfLaboratorio;
    // End of variables declaration//GEN-END:variables

    public int getInvocador() {
        return invocador;
    }

    public void setInvocador(int invocador) {
        this.invocador = invocador;
    }

    private boolean isDatosValidos() {
        return (!txfLaboratorio.getText().trim().equals(""));
    }

    private Laboratorio registrar() {
        oLaboratorio = new Laboratorio();
        oLaboratorioBl = new LaboratorioBl();

        oLaboratorio.setDenominacion(txfLaboratorio.getText().toUpperCase().trim());
        oLaboratorio.setEstado(Boolean.TRUE);

        return oLaboratorioBl.registrar(oLaboratorio);

    }

    private void resetConponent() {
        txfLaboratorio.setText("");
    }

    private void resetConponentFull() {
        txfLaboratorio.setText("");
        resetPaintComponent();
    }

    private void paintComponentes() {
        Utilitarios.paintBorderTxfVacio(txfLaboratorio);

    }

    private void resetPaintComponent() {
        Utilitarios.resetPaintBorderTxf(txfLaboratorio);
    }

    void enviarJif(JIF_NuevoProducto aThis) {
        jifNuevoProducto = aThis;
    }
}
