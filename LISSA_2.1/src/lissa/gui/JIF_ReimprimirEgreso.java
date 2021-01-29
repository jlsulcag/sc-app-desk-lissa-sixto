
package lissa.gui;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import lissa.be.Egreso;
import lissa.be.EgresoDetalle;
import lissa.be.Medico;
import lissa.bl.EgresoDetalleBl;
import lissa.controller.MedicoCtrl;
import lissa.ds.DSConeccion;
import lissa.reportes.ReportGeneric;
import lissa.table.ModeloEgresoReimpresion;
import lissa.util.Mensajes;
import org.rx.cr.util.Utilitarios;

/**
 *
 * @author JSULCAG
 */
public class JIF_ReimprimirEgreso extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloEgresoReimpresion oModeloEgresoReimpresion;
    private MedicoCtrl oMedicoCtrl;
    private EgresoDetalleBl oEgresoDetalleBl;
    private List<EgresoDetalle> listEgresos;
    private EgresoDetalle oEgresoDetalle;
    //Variables para el reporte
    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;
    
    public JIF_ReimprimirEgreso(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloEgresoReimpresion = new ModeloEgresoReimpresion();
        tblEgresos.setModel(oModeloEgresoReimpresion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbxMedico = new javax.swing.JComboBox();
        btnProcesar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEgresos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setTitle("Reimprimir Egresos");

        jLabel3.setText("Medico :");

        btnProcesar.setText("Procesar");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        tblEgresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblEgresos);

        jButton2.setText("Re-Imprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnProcesar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(cbxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcesar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        listarEgresos();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        imprimirEgreso();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcesar;
    private javax.swing.JComboBox cbxMedico;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblEgresos;
    // End of variables declaration//GEN-END:variables

    void iniciar() {
        cargarMedicos();
        oModeloEgresoReimpresion.clear();
        personalizaVistaTabla();
    }

    private void cargarMedicos() {
        oMedicoCtrl = new MedicoCtrl(root);
        oMedicoCtrl.rellenaMedico(cbxMedico);
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaAnchoColumnaTabla(0, tblEgresos, 50);
        Utilitarios.formateaAnchoColumnaTabla(1, tblEgresos, 60);
        Utilitarios.formateaAnchoColumnaTabla(2, tblEgresos, 80);
        Utilitarios.formateaAnchoColumnaTabla(4, tblEgresos, 50);
        
        Utilitarios.alinearDatosColumnaTablaDerecha(4, tblEgresos);
    }

    private void listarEgresos() {
        oEgresoDetalleBl = new EgresoDetalleBl();
        listEgresos = new LinkedList<>();
        oModeloEgresoReimpresion.clear();
        if(cbxMedico.getSelectedIndex()>0){
            listEgresos = oEgresoDetalleBl.listarxMedico(((Medico)cbxMedico.getSelectedItem()).getIdMedico());
            if(!listEgresos.isEmpty()){
                for (EgresoDetalle obj : listEgresos) {
                    oModeloEgresoReimpresion.add(obj);
                }
            }else{
            
            }
        }else{
            
        }
    }

    private void imprimirConstancia(Egreso oEgreso) {
        try {
            ds = new DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport("PagoMedicos", new String[]{"ID_EGRESO"}, new Object[]{oEgreso.getIdegreso()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Reporte");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.setResizable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
            reset();
        } catch (Exception ex) {
            Logger.getLogger(JIF_ReimprimirEgreso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void imprimirEgreso() {
        oEgresoDetalle = new EgresoDetalle();
        if(tblEgresos.getRowSelectionAllowed() && tblEgresos.getSelectedRow() != -1){
            oEgresoDetalle = oModeloEgresoReimpresion.get(tblEgresos.getSelectedRow());
            if(oEgresoDetalle != null){
                imprimirConstancia(oEgresoDetalle.getEgreso());
            }
        }else{
            Mensajes.tblSelected();
        }
    }

    private void reset() {
        cbxMedico.setSelectedIndex(0);
        oModeloEgresoReimpresion.clear();
        personalizaVistaTabla();
    }
}
