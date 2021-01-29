
package lissa.gui;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lissa.ds.DSConeccion;
import lissa.reportes.ReportGeneric;
import lissa.util.Utilitarios;
import net.sf.jasperreports.engine.JRException;

public class JIF_Reporte_RecaudacionResumen extends javax.swing.JInternalFrame {
    private JF_Principal root;

    //Variables para el reporte
    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;
    private int tipo_comprobante;
    
    public JIF_Reporte_RecaudacionResumen(JF_Principal root) {
        initComponents();
        this.root = root;
        fechaActual();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxTipoDoc = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jdcFechaDesde = new com.toedter.calendar.JDateChooser();
        btnGenerar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jdcFechaHasta = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RECAUDACIÓN - HOJA RESUMEN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Tipo de documento : ");

        cbxTipoDoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<SELECCIONE>", "GENERAL", "BOLETA", "FACTURA", "RECIBO" }));

        jLabel2.setText("Desde : ");

        jdcFechaDesde.setDateFormatString("dd/MM/yyyy");

        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/sales-report-icon (1).png"))); // NOI18N
        btnGenerar.setToolTipText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        jLabel4.setText("Hasta :");

        jdcFechaHasta.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jdcFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcFechaHasta, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                    .addComponent(cbxTipoDoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGenerar)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdcFechaDesde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jdcFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        if(isdatosValidos()){
            generarReporte();
            resetPaintComponent();
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese todos los parámetros", "Error", JOptionPane.ERROR_MESSAGE);
            paintComconent();
        }
    }//GEN-LAST:event_btnGenerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox cbxTipoDoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdcFechaDesde;
    private com.toedter.calendar.JDateChooser jdcFechaHasta;
    // End of variables declaration//GEN-END:variables

    private void generarReporte() {
        switch (cbxTipoDoc.getSelectedItem().toString()) {
            case "GENERAL":
                reporteGeneral();
                break;
            case "FACTURA":
                reporteXComprobante();
                break;
            case "BOLETA":
                reporteXComprobante();
                break;
            case "RECIBO":
                reporteXComprobante();
                break;
        }
    }
    
    private void fechaActual() {
        Calendar c = new GregorianCalendar();
        jdcFechaDesde.setCalendar(c);
        jdcFechaHasta.setCalendar(c);
    }
    
    private void reporteGeneral() {
        try {
            //ds = new DSConeccion("localhost", "5432", "lissadb", "postgres", "12345678");
            ds = new DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport("RecaudacionDiariaTipoComprobanteResumenFull", new String[]{"FECHA_DESDE", "FECHA_HASTA"}, new Object[]{jdcFechaDesde.getDate(), jdcFechaHasta.getDate()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Reporte");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
        } catch (JRException ex) {
            Logger.getLogger(JIF_Reporte_RecaudacionDiariaTipoDocFecha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JIF_Reporte_RecaudacionDiariaTipoDocFecha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void reporteXComprobante() {

        try {
            //ds = new DSConeccion("localhost", "5432", "lissadb", "postgres", "12345678");
            ds = new DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport("RecaudacionDiariaTipoComprobanteResumen", new String[]{"FECHA_DESDE", "FECHA_HASTA", "COMPROBANTE"}, new Object[]{jdcFechaDesde.getDate(),jdcFechaHasta.getDate(), cbxTipoDoc.getSelectedItem().toString().trim()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Reporte");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
        } catch (JRException ex) {
            Logger.getLogger(JIF_Reporte_RecaudacionDiariaTipoDocFecha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JIF_Reporte_RecaudacionDiariaTipoDocFecha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean isdatosValidos() {
        return (cbxTipoDoc.getSelectedIndex()>0
                && jdcFechaDesde.getDate() != null
                && jdcFechaHasta.getDate() != null);
    }

    private void paintComconent() {
        Utilitarios.paintCbxVacio(cbxTipoDoc);
        Utilitarios.paintJdcVacio(jdcFechaDesde);
        Utilitarios.paintJdcVacio(jdcFechaHasta);
    }

    private void resetPaintComponent() {
        Utilitarios.resetPaintCbx(cbxTipoDoc);
        Utilitarios.resetPaintJdc(jdcFechaDesde);
        Utilitarios.resetPaintJdc(jdcFechaHasta);
    }
}
