package lissa.gui.farmacia;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import lissa.be.Beneficio;
import lissa.be.Cuentaxcobrar;
import lissa.be.SeguroVida;
import lissa.bl.CuentaxcobrarBl;
import lissa.controller.BeneficioCtrl;
import lissa.controller.SeguroCtrl;
import lissa.ds.DSConeccion;
import lissa.gui.JF_Principal;
import lissa.reportes.ReportGeneric;
import lissa.table.ModeloCuentasxCobrarFarmacia;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_CuentasXCobrarFarmacia extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloCuentasxCobrarFarmacia oModeloCuentasxCobrarFarmacia;
    private CuentaxcobrarBl oCuentaxcobrarBl;
    private List<Cuentaxcobrar> listCtasxCobrar;
    private Cuentaxcobrar oCuentaxcobrarTemp;
    private SeguroCtrl oSeguroCtrl;
    private BeneficioCtrl oBeneficioCtrl;

    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;

    public JIF_CuentasXCobrarFarmacia(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloCuentasxCobrarFarmacia = new ModeloCuentasxCobrarFarmacia();
        tblctasxcobrar.setModel(oModeloCuentasxCobrarFarmacia);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblctasxcobrar = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxSeguro = new javax.swing.JComboBox();
        cbxBeneficio = new javax.swing.JComboBox();
        btnProcesar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cuentas por Cobrar");

        tblctasxcobrar.setModel(new javax.swing.table.DefaultTableModel(
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
        tblctasxcobrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblctasxcobrarMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblctasxcobrar);

        jButton1.setText("Pagar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Imprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jLabel1.setText("Seguro :");

        jLabel2.setText("Beneficio :");

        cbxSeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSeguroActionPerformed(evt);
            }
        });

        btnProcesar.setText("Procesar");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxSeguro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProcesar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(cbxSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcesar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1158, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
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

    private void tblctasxcobrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblctasxcobrarMouseReleased
        obtenerDatos();
    }//GEN-LAST:event_tblctasxcobrarMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cancelarCtasxCobrar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(isDatosValidos()){
            imprimirCtasxCobrar();
        }else{
            Mensajes.msjParametroVacio();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbxSeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSeguroActionPerformed
        if (cbxSeguro.getSelectedIndex() > 0) {
            cargarBeneficio();
        } else {
            cbxBeneficio.removeAllItems();
        }
    }//GEN-LAST:event_cbxSeguroActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        filtrarCtasxCobrar();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnProcesarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcesar;
    private javax.swing.JComboBox cbxBeneficio;
    private javax.swing.JComboBox cbxSeguro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblctasxcobrar;
    // End of variables declaration//GEN-END:variables

    public void inicializar() {
        llenarCbxSeguro();
        cbxBeneficio.removeAllItems();
        oModeloCuentasxCobrarFarmacia.clear();        
        personalizaVistaTabla();
        if (oCuentaxcobrarTemp != null) {
            oCuentaxcobrarTemp = null;
        }
    }

    private void listarCtasxCobrar(int idBeneficio) {
        oCuentaxcobrarBl = new CuentaxcobrarBl();
        listCtasxCobrar = oCuentaxcobrarBl.listarxCobrar(idBeneficio);
        oModeloCuentasxCobrarFarmacia.clear();
        if (!listCtasxCobrar.isEmpty()) {
            for (Cuentaxcobrar obj : listCtasxCobrar) {
                oModeloCuentasxCobrarFarmacia.add(obj);
            }
        } else {
            Mensajes.NoExisteResultadoBusqueda();
        }
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblctasxcobrar, 60);
        Utilitarios.formateaColumna(1, tblctasxcobrar, 80);
        Utilitarios.formateaColumna(2, tblctasxcobrar, 100);
        Utilitarios.formateaColumna(6, tblctasxcobrar, 70);
        Utilitarios.formateaColumna(7, tblctasxcobrar, 70);
        Utilitarios.formateaColumna(8, tblctasxcobrar, 70);
        Utilitarios.formateaColumna(9, tblctasxcobrar, 70);
        Utilitarios.formateaColumna(10, tblctasxcobrar, 70);

        Utilitarios.alinearDatosColumnaTablaDerecha(6, tblctasxcobrar);
        Utilitarios.alinearDatosColumnaTablaDerecha(7, tblctasxcobrar);
        Utilitarios.alinearDatosColumnaTablaDerecha(8, tblctasxcobrar);
        Utilitarios.alinearDatosColumnaTablaDerecha(9, tblctasxcobrar);
        Utilitarios.alinearDatosColumnaTablaDerecha(10, tblctasxcobrar);
    }

    private void obtenerDatos() {
        if (tblctasxcobrar.getRowSelectionAllowed() && tblctasxcobrar.getSelectedRow() != -1) {
            oCuentaxcobrarTemp = new Cuentaxcobrar();
            oCuentaxcobrarTemp = oModeloCuentasxCobrarFarmacia.get(tblctasxcobrar.getSelectedRow());
        } else {
            Mensajes.tblSelected();
        }
    }

    private void cancelarCtasxCobrar() {
        oCuentaxcobrarBl = new CuentaxcobrarBl();
        if (tblctasxcobrar.getRowSelectionAllowed() && tblctasxcobrar.getSelectedRow() != -1) {
            if (oCuentaxcobrarTemp != null) {
                oCuentaxcobrarTemp.setEstado("PAGADO");
                oCuentaxcobrarTemp.setFechaPago(new Date());
                oCuentaxcobrarBl.actualizar(oCuentaxcobrarTemp);
                inicializar();
            }
        } else {
            Mensajes.tblSelected();
        }

    }

    private void imprimirCtasxCobrar() {
        try {
            ds = new DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport("REP106", new String[]{"ID_BENEFICIO"}, new Object[]{((Beneficio)cbxBeneficio.getSelectedItem()).getIdbeneficio()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Reporte");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.setMaximizable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
        } catch (Exception ex) {
            Logger.getLogger(JIF_CuentasXCobrarFarmacia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarCbxSeguro() {
        oSeguroCtrl = new SeguroCtrl(root);
        oSeguroCtrl.rellenaCbx(cbxSeguro);
    }

    private void cargarBeneficio() {
        oBeneficioCtrl = new BeneficioCtrl(root);
        oBeneficioCtrl.rellenaCbx(cbxBeneficio, ((SeguroVida) cbxSeguro.getSelectedItem()).getIdSeguroVida());
    }

    private void filtrarCtasxCobrar() {
        if(isDatosValidos()){
            listarCtasxCobrar(((Beneficio)cbxBeneficio.getSelectedItem()).getIdbeneficio());
        }else{
            Mensajes.msjValidarIngreso();
        }
    }

    private boolean isDatosValidos() {
        return (cbxSeguro.getSelectedIndex()>0
                && cbxBeneficio.getSelectedIndex()>0);
    }
}
