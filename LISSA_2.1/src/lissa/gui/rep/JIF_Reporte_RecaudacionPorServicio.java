
package lissa.gui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lissa.be.Servicio;
import lissa.bl.ServicioBl;
import lissa.ds.DSConeccion;
import lissa.gui.JF_Principal;
import lissa.gui.JIF_Reporte_RecaudacionDiariaTipoDocFecha;
import lissa.reportes.ReportGeneric;
import lissa.util.Utilitarios;
import net.sf.jasperreports.engine.JRException;


public class JIF_Reporte_RecaudacionPorServicio extends javax.swing.JInternalFrame {

    private JF_Principal root;

    //Variables para el reporte
    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;
    //fin
    private ServicioBl oBLServicio = null;
    private ArrayList<Servicio> listServicio = null;
    String servicio = "";
    
    public JIF_Reporte_RecaudacionPorServicio(JF_Principal root) {
        initComponents();
        this.root = root;
        //cargarCbxServicios();
        fechaActual();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jdcFechaDesde = new com.toedter.calendar.JDateChooser();
        btnGenerar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jdcFechaHasta = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);
        setTitle("REP0104 - Recaudación por Servicio y Procedimiento");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setText("Desde : ");

        btnGenerar.setText("Generar");
        btnGenerar.setToolTipText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        jLabel4.setText("Hasta :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcFechaDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jdcFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jdcFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerar)
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdcFechaDesde;
    private com.toedter.calendar.JDateChooser jdcFechaHasta;
    // End of variables declaration//GEN-END:variables

    private void generarReporte() {
//        if(cbxTipoDoc.getSelectedIndex()>0){
//            servicio = cbxTipoDoc.getSelectedItem().toString().trim();
//            if(servicio.equals("TODOS")){
//                reporteGeneral();
//            }else{
//                reporteXServicio();
//            }            
//        }
        reporteGeneral();
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
            reportPanel = reportGenric.mkReport("REP0104", new String[]{"FECHA_DESDE", "FECHA_HASTA"}, new Object[]{jdcFechaDesde.getDate(), jdcFechaHasta.getDate()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Reporte");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.setMaximizable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
        } catch (JRException ex) {
            Logger.getLogger(JIF_Reporte_RecaudacionDiariaTipoDocFecha.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(JIF_Reporte_RecaudacionDiariaTipoDocFecha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private void reporteXServicio() {
//
//        try {
//            //ds = new DSConeccion("localhost", "5432", "lissadb", "postgres", "12345678");
//            ds = new DSConeccion(root.getConfig());
//            reportGenric = new ReportGeneric(ds.getConeccion());
//            reportGenric.setReportParent("/lissa/reportes/");
//            reportPanel = reportGenric.mkReport("RecaudacionDiariaXServicio", new String[]{"FECHA_DESDE", "FECHA_HASTA", "SERVICIO"}, new Object[]{jdcFechaDesde.getDate(), jdcFechaHasta.getDate(), cbxTipoDoc.getSelectedItem().toString().trim()});
//            reportVisor = new JInternalFrame();
//            reportVisor.setTitle("Reporte");
//            reportVisor.setIconifiable(true);
//            reportVisor.setClosable(true);
//            reportVisor.getContentPane().add(reportPanel);
//            root.insertarInternalFrames(reportVisor);
//            reportVisor.setMaximum(true);
//        } catch (JRException ex) {
//            Logger.getLogger(JIF_Reporte_RecaudacionDiariaTipoDocFecha.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(JIF_Reporte_RecaudacionDiariaTipoDocFecha.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
    private boolean isdatosValidos() {
        return (jdcFechaDesde.getDate() != null
                && jdcFechaHasta.getDate() != null);
    }

    private void paintComconent() {
//        Utilitarios.paintCbxVacio(cbxTipoDoc);
        Utilitarios.paintJdcVacio(jdcFechaDesde);
        Utilitarios.paintJdcVacio(jdcFechaHasta);
    }

    private void resetPaintComponent() {
//        Utilitarios.resetPaintCbx(cbxTipoDoc);
        Utilitarios.resetPaintJdc(jdcFechaDesde);
        Utilitarios.resetPaintJdc(jdcFechaHasta);
    }

//    private void cargarCbxServicios() {
//        oBLServicio =  new ServicioBl();
//        listServicio = oBLServicio.listar();
//        cbxTipoDoc.removeAllItems();
//        cbxTipoDoc.addItem("<SELECCIONE>");
//        cbxTipoDoc.addItem("TODOS");
//        for (Servicio tipoMedico : listServicio) {
//            tipoMedico.setOp(Servicio.DATO);
//            cbxTipoDoc.addItem(tipoMedico);
//        }
//    }
}
