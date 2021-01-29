
package lissa.gui;

import java.sql.SQLException;
import lissa.be.Caja;
import lissa.be.Persona;
import lissa.be.PersonaJuridica;
import lissa.be.Rol;
import lissa.be.Usuario;

public class JIF_Admision extends javax.swing.JInternalFrame {
    
    private JF_Principal root;
    private JPanel_Admision jPanelAdmision;
    private PersonaJuridica oPersonaJuridica; 
    
    private Usuario userTemp;
    private Persona perTemp;
    private Rol rolTemp;

    public JIF_Admision(JF_Principal root) throws SQLException {
        initComponents();
        this.root = root;
        jPanelAdmision = new JPanel_Admision(root);
        jScrollPane1.setViewportView(jPanelAdmision);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();

        setClosable(true);
        setTitle("Admisión");
        setPreferredSize(new java.awt.Dimension(1340, 600));
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        jPanelAdmision.resetFullComponent();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables


//    void cargarDatos(PersonaJuridica oPersonaJuridicaTabla) {
//        oPersonaJuridica = oPersonaJuridicaTabla;
//        cargarDatosPanel(oPersonaJuridica);
//    }

//    private void cargarDatosPanel(PersonaJuridica oPersonaJuridica) {
//        root.jpAdmision.cargarDatosPanel(oPersonaJuridica);
//    }

   

    void enviarDatos(Usuario user, Rol oRol) {
        jPanelAdmision.cargarDatos(user, oRol);
    }

    void enviarDatosCaja(Caja oCaja) {
        jPanelAdmision.enviarDatosCaja(oCaja);
    }

    void iniciar() {
        jPanelAdmision.iniciar();
    }

    
}
