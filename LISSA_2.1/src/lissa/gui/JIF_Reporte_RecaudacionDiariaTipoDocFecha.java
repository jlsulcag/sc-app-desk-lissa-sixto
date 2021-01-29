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

public class JIF_Reporte_RecaudacionDiariaTipoDocFecha extends javax.swing.JInternalFrame {

    private JF_Principal root;

    //Variables para el reporte
    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;
    private int tipo_comprobante;

    public JIF_Reporte_RecaudacionDiariaTipoDocFecha(JF_Principal root) {
        initComponents();
        this.root = root;
        fechaActual();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbxTipoDoc = new javax.swing.JComboBox();
        jdcFechaDesde = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jdcFechaHasta = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RECAUDACIÓN - DETALLADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        cbxTipoDoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<SELECCIONE>", "GENERAL", "BOLETA", "FACTURA", "RECIBO" }));

        jdcFechaDesde.setDateFormatString("dd/MM/yyyy");

        jLabel1.setText("Tipo de documento : ");

        jLabel2.setText("Desde : ");

        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/sales-report-icon (1).png"))); // NOI18N
        btnGenerar.setToolTipText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        jLabel3.setText("Hasta :");

        jdcFechaHasta.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jdcFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcFechaHasta, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                    .addComponent(cbxTipoDoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGenerar)
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
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
        if (isdatosValidos()) {
            generarReporte();
            resetPaintComponent();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese todos los parámetros", "Error", JOptionPane.ERROR_MESSAGE);
            paintComconent();
        }

    }//GEN-LAST:event_btnGenerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox cbxTipoDoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
                tipo_comprobante = 1;
                reporteBoleta();
                break;
            case "BOLETA":
                tipo_comprobante = 2;
                reporteBoleta();
                break;
            case "RECIBO":
                tipo_comprobante = 3;
                reporteBoleta();
                break;
        }
    }

    private void reporteGeneral() {
        try {
            //ds = new DSConeccion("localhost", "5432", "lissadb", "postgres", "12345678");
            ds = new DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport("AtencionDiariaDetallado", new String[]{"FECHA_DESDE", "FECHA_HASTA"}, new Object[]{jdcFechaDesde.getDate(), jdcFechaHasta.getDate()});
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

    private void reporteBoleta() {

        try {
            //ds = new DSConeccion("localhost", "5432", "lissadb", "postgres", "12345678");
            ds = new DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport("AtencionDiariaDetalladoXFechaTipoDoc", new String[]{"FECHA_DESDE", "FECHA_HASTA", "TIPO_COMPROBANTE"}, new Object[]{jdcFechaDesde.getDate(), jdcFechaHasta.getDate(), tipo_comprobante});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Reportes");
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
    
    private void fechaActual() {
        Calendar c = new GregorianCalendar();
        jdcFechaDesde.setCalendar(c);
        jdcFechaHasta.setCalendar(c);
    }

    private boolean isdatosValidos() {
        return (cbxTipoDoc.getSelectedIndex() > 0
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
