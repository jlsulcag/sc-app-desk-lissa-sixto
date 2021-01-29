package lissa.gui;

import lissa.be.Atencionhc;
import lissa.be.Cie10;
import lissa.be.HistoriaClinica;
import lissa.be.Persona;
import lissa.be.Rol;
import lissa.be.Usuario;
import lissa.bl.ItemsComprobanteBl;
import lissa.util.Utilitarios;

public class JIF_HistoriaClinica extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private JPanel_HistoriaClinica jPanel_HistoriaClinica = null;
    private Usuario userTemp;
    private Persona perTemp;
    private Rol rolTemp;

    public JIF_HistoriaClinica(JF_Principal root) {
        initComponents();
        this.root = root;
        jPanel_HistoriaClinica = new JPanel_HistoriaClinica(root);
        jScrollPane1.setViewportView(jPanel_HistoriaClinica);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();

        setClosable(true);
        setIconifiable(true);
        setTitle("Historia Clínica");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        resetComponent();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void cargarDatosHistoriaClinica(HistoriaClinica hc) {
        jPanel_HistoriaClinica.cargarDatosHistoriaClinica(hc);
    }

    void cargarCie10(Cie10 cie10) {
        jPanel_HistoriaClinica.cargardatosCie10(cie10);
    }

    void cargarDatosHistorial(Atencionhc oAtencion) {
        jPanel_HistoriaClinica.cargarDatosHistorial(oAtencion);
    }
    
    void resetComponent() {
        jPanel_HistoriaClinica.resetComponentTodo();
    }

    void cargarDatosUser(Usuario user, Persona oPersona, Rol oRol) {
        userTemp = user;
        perTemp = oPersona;
        rolTemp = oRol;
        jPanel_HistoriaClinica.cargarDatosUser(user, oPersona, oRol);
    }

}
