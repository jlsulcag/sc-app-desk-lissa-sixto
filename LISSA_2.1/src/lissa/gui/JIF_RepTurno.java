package lissa.gui;

import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lissa.be.Caja;
import lissa.be.TipoComprobante;
import lissa.bl.TipoComprobanteBl;
import lissa.bl.CajaBl;
import lissa.ds.DSConeccion;
import lissa.reportes.ReportGeneric;
import lissa.table.ModeloCaja;

public class JIF_RepTurno extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloCaja modeloCaja;
    private ArrayList<Caja> listCajas;
    private CajaBl cajaBl;
    private Caja oCaja;
    private TipoComprobante oTipoComprobante;
    private TipoComprobanteBl oBlTipoComprobante;
    private ArrayList<TipoComprobante> listTipoComprobante;

    //Variables para el reporte
    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;

    //
    public JIF_RepTurno(JF_Principal root) {
        initComponents();
        this.root = root;
        modeloCaja = new ModeloCaja();
        tblCajas.setModel(modeloCaja);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCajas = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Reporte de Arqueo de Caja");

        jButton2.setText("Generar Arqueo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblCajas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCajas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblCajasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblCajas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Refresh.png"))); // NOI18N
        jButton1.setToolTipText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCajasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCajasMouseReleased
        if (tblCajas.getRowSelectionAllowed()) {
            obtenerDatosCaja();
        }
    }//GEN-LAST:event_tblCajasMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listarCajas();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (isParamValidos()) {
            generarReporte();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese todos los parámetros", "Atención", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblCajas;
    // End of variables declaration//GEN-END:variables

    private void listarCajas() {
        cajaBl = new CajaBl();
        modeloCaja.clear();
        listCajas = cajaBl.listar();
        if (!listCajas.isEmpty()) {
            modeloCaja.addAll(listCajas);
        }
    }

    private void obtenerDatosCaja() {
        oCaja = new Caja();
        oCaja = modeloCaja.get(tblCajas.getSelectedRow());
    }

    private void generarReporte() {
        if (oCaja.getAreaCaja().getModulo().trim().equals("CAJA 01 - CLINICA")) {
            try {
                ds = new DSConeccion(root.getConfig());
                reportGenric = new ReportGeneric(ds.getConeccion());
                reportGenric.setReportParent("/lissa/reportes/");
                reportPanel = reportGenric.mkReport("ReportePorTurno", new String[]{"ID_CAJA"}, new Object[]{oCaja.getIdcaja()});
                reportVisor = new JInternalFrame();
                reportVisor.setTitle("Reporte por turno");
                reportVisor.setIconifiable(true);
                reportVisor.setClosable(true);
                reportVisor.getContentPane().add(reportPanel);
                root.insertarInternalFrames(reportVisor);
                reportVisor.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(JIF_RepTurno.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(JIF_RepTurno.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (oCaja.getAreaCaja().getModulo().trim().equals("CAJA 02 - FARMACIA")) {
            try {
                ds = new DSConeccion(root.getConfig());
                reportGenric = new ReportGeneric(ds.getConeccion());
                reportGenric.setReportParent("/lissa/reportes/");
                reportPanel = reportGenric.mkReport("FarReportePorTurno", new String[]{"ID_CAJA"}, new Object[]{oCaja.getIdcaja()});
                reportVisor = new JInternalFrame();
                reportVisor.setTitle("Reporte por turno");
                reportVisor.setIconifiable(true);
                reportVisor.setClosable(true);
                reportVisor.getContentPane().add(reportPanel);
                root.insertarInternalFrames(reportVisor);
                reportVisor.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(JIF_RepTurno.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(JIF_RepTurno.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }

    }

    private boolean isParamValidos() {
        return (tblCajas.getSelectedRow() != -1);
    }

    void inicializar() {
        listarCajas();        
    }
}
