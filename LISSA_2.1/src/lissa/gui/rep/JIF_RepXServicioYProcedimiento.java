package lissa.gui.rep;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lissa.be.Procedimiento;
import lissa.be.Servicio;
import lissa.controller.ProcedimientoCtrl;
import lissa.controller.ServicioCtrl;
import lissa.ds.DSConeccion;
import lissa.gui.JF_Principal;
import lissa.reportes.ReportGeneric;

/**
 *
 * @author JSULCAG
 */
public class JIF_RepXServicioYProcedimiento extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ServicioCtrl oServicioCtrl;
    private ProcedimientoCtrl oProcedimientoCtrl;
    //Variables para el reporte
    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;
    //fin

    public JIF_RepXServicioYProcedimiento(JF_Principal root) {
        initComponents();
        this.root = root;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jdcDesde = new com.toedter.calendar.JDateChooser();
        jdcHasta = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxServicio = new javax.swing.JComboBox();
        cbxProcedimiento = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("REP0101 - Atenciones por Servicio y Procedimiento");

        jLabel1.setText("Servicio :");

        jLabel2.setText("procedimiento :");

        jLabel3.setText("Desde :");

        jLabel4.setText("Hasta :");

        cbxServicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxServicioItemStateChanged(evt);
            }
        });

        cbxProcedimiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProcedimientoItemStateChanged(evt);
            }
        });

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(39, 39, 39)
                        .addComponent(cbxServicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jdcDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdcHasta, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                            .addComponent(cbxProcedimiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jdcDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
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

    private void cbxProcedimientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProcedimientoItemStateChanged
        
    }//GEN-LAST:event_cbxProcedimientoItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        generar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxServicioItemStateChanged
        if (cbxServicio.getSelectedIndex() > 0) {
            rellenaCbxProcedimiento();
        } else {
            cbxProcedimiento.removeAllItems();
        }
    }//GEN-LAST:event_cbxServicioItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxProcedimiento;
    private javax.swing.JComboBox cbxServicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdcDesde;
    private com.toedter.calendar.JDateChooser jdcHasta;
    // End of variables declaration//GEN-END:variables

    public void iniciar() {
        cargarCbxServicio();
        jdcDesde.setDate(null);
        jdcHasta.setDate(null);
    }

    private void cargarCbxServicio() {
        oServicioCtrl = new ServicioCtrl(root);
        oServicioCtrl.rellenaCbx(cbxServicio);
    }

    private void rellenaCbxProcedimiento() {
        oProcedimientoCtrl = new ProcedimientoCtrl(root);
        oProcedimientoCtrl.rellenaCbxXidDependiente(cbxProcedimiento, ((Servicio) cbxServicio.getSelectedItem()).getIdservicio());
    }

    private void generar() {
        if (isdatosValidos()) {
            generarReporte();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese todos los parámetros", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    private boolean isdatosValidos() {
        return (cbxServicio.getSelectedIndex() > 0
                && cbxProcedimiento.getSelectedIndex() > 0
                && jdcDesde.getDate() != null
                && jdcHasta.getDate() != null);
    }

    private void generarReporte() {
        try {
            ds = new DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport("REP0101", new String[]{"ID_SERVICIO", "ID_PROCEDIMIENTO" ,"FECHA_DESDE", "FECHA_HASTA"}, new Object[]{((Servicio)cbxServicio.getSelectedItem()).getIdservicio(),((Procedimiento)cbxProcedimiento.getSelectedItem()).getIdprocedimiento(), jdcDesde.getDate(), jdcHasta.getDate()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Reporte");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.setMaximizable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
        } catch (Exception ex) {
            Logger.getLogger(JIF_RepXServicioYProcedimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
