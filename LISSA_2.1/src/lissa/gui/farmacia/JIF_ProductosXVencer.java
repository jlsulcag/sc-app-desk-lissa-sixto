package lissa.gui.farmacia;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import lissa.be.AlmacenProducto;
import lissa.bl.AlmacenProductoBl;
import lissa.ds.DSConeccion;
import lissa.gui.JF_Principal;
import lissa.reportes.ReportGeneric;
import lissa.table.ModeloProductosPorVencer;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_ProductosXVencer extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloProductosPorVencer oModeloProductosPorVencer;
    private AlmacenProductoBl oAlmacenProductoBl;
    private ArrayList<AlmacenProducto> list;

    //Variables para el reporte
    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;

    public JIF_ProductosXVencer(JF_Principal root) {
        initComponents();
        this.root = root;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jdcFechaPorVencer = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setTitle("Producntos por Vencer");

        jButton1.setText("Ver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Vencidos al :");

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblResultados);

        jButton2.setText("Imprimir");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcFechaPorVencer, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcFechaPorVencer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if (jdcFechaPorVencer.getDate() !=null) {
            listarProductosPorFechaVencimiento(jdcFechaPorVencer.getDate());
        }
        personalizarVistaTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jdcFechaPorVencer.getDate() !=null) {
            generarReporte();
        }else{
            Mensajes.msjParametroVacio();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txfDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfDiasActionPerformed
           jButton1.doClick();
    }//GEN-LAST:event_txfDiasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFechaPorVencer;
    private javax.swing.JTable tblResultados;
    // End of variables declaration//GEN-END:variables

    private void listarProductos(int dias) {
        oAlmacenProductoBl = new AlmacenProductoBl();
        oModeloProductosPorVencer.clear();
        list = oAlmacenProductoBl.listarProductosPorVencer(dias);
        if (list != null) {
            oModeloProductosPorVencer.addAll(list);
        }
    }
    
     private void listarProductosPorFechaVencimiento(Date fecha) {
        oAlmacenProductoBl = new AlmacenProductoBl();
        oModeloProductosPorVencer.clear();
        list = oAlmacenProductoBl.listarProductosPorFechaVencimiento(fecha);
        if (list != null) {
            oModeloProductosPorVencer.addAll(list);
        }
    }

    private void personalizarVistaTabla() {
        Utilitarios.formateaColumna(0, tblResultados, 60);
        Utilitarios.formateaColumna(2, tblResultados, 100);
        Utilitarios.formateaColumna(3, tblResultados, 100);
        Utilitarios.formateaColumna(4, tblResultados, 100);
        Utilitarios.formateaColumna(5, tblResultados, 100);
        Utilitarios.formateaColumna(6, tblResultados, 50);
        Utilitarios.formateaColumna(7, tblResultados, 80);
        Utilitarios.formateaColumna(8, tblResultados, 80);
    }

    public void inicializar() {
        oModeloProductosPorVencer = new ModeloProductosPorVencer();
        tblResultados.setModel(oModeloProductosPorVencer);
        personalizarVistaTabla();
    }

    private void generarReporte() {
        try {
            ds = new DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport("ReporteProdPorVencer", new String[]{"NUMDIAS"}, new Object[]{jdcFechaPorVencer.getDate()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Reporte productos por vencer");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
        } catch (Exception ex) {
            Logger.getLogger(JIF_ProductosXVencer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
