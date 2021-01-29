package lissa.gui;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import lissa.be.Comprobante;
import lissa.be.ComprobanteDetalle;
import lissa.bl.ComprobanteBl;
import lissa.bl.ItemsComprobanteBl;
import lissa.ds.DSConeccion;
import lissa.reportes.ReportGeneric;
import lissa.table.ModeloComprobanteClinica;
import lissa.table.ModeloComprobanteDetalle;
import lissa.util.Mensajes;
import lissa.util.Reportes;
import lissa.util.Utilitarios;

/**
 *
 * @author JSULCAG
 */
public class JIF_GenerarPreFactura extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private Comprobante oComprobante;
    private ComprobanteBl oComprobanteBl;
    private ItemsComprobanteBl oComprobanteDetalleBl;
    private List<Comprobante> listComprobante;
    private List<ComprobanteDetalle> listComprobanteDetalle;
    private ModeloComprobanteClinica oModeloComprobanteClinica;
    private ModeloComprobanteDetalle oModeloComprobanteDetalle;

    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;

    public JIF_GenerarPreFactura(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloComprobanteClinica = new ModeloComprobanteClinica();
        tblComprobante.setModel(oModeloComprobanteClinica);
        oModeloComprobanteDetalle = new ModeloComprobanteDetalle();
        tblDetalleComprobante.setModel(oModeloComprobanteDetalle);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jdcFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jdcFechaFin = new com.toedter.calendar.JDateChooser();
        btnProcesar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txfNumeroCarta = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComprobante = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalleComprobante = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Generar Pre-Factura");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));

        jLabel1.setText("Inicio :");

        jLabel2.setText("Fecha Fin :");

        btnProcesar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        btnProcesar.setText("Buscar");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        jLabel5.setText("N° Carta :");

        txfNumeroCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNumeroCartaActionPerformed(evt);
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
                .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfNumeroCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 517, Short.MAX_VALUE)
                .addComponent(btnProcesar))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcesar)
                    .addComponent(jLabel5)
                    .addComponent(txfNumeroCarta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Comprobante"));

        tblComprobante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblComprobante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblComprobanteMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblComprobante);

        tblDetalleComprobante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblDetalleComprobante);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
        );

        jButton1.setText("Generar Pre Factura");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
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

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        filtroXFecha();
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void txfNumeroCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNumeroCartaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNumeroCartaActionPerformed

    private void tblComprobanteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComprobanteMouseReleased
        obtenerDetalles();
    }//GEN-LAST:event_tblComprobanteMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        GenerarPreFactura();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcesar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcFechaFin;
    private com.toedter.calendar.JDateChooser jdcFechaInicio;
    private javax.swing.JTable tblComprobante;
    private javax.swing.JTable tblDetalleComprobante;
    private javax.swing.JTextField txfNumeroCarta;
    // End of variables declaration//GEN-END:variables

    private void filtroXFecha() {
        String numeroCarta = !txfNumeroCarta.getText().trim().equals("")?txfNumeroCarta.getText().toUpperCase().trim():"0";
        oModeloComprobanteClinica.clear();
        oModeloComprobanteDetalle.clear();
        if (isDatosValidosFecha()) {
            oComprobanteBl = new ComprobanteBl();
            listComprobante = oComprobanteBl.buscarXRangoFecha(Utilitarios.castDate_UTIL_SQL(jdcFechaInicio.getDate()), Utilitarios.castDate_UTIL_SQL(jdcFechaFin.getDate()), numeroCarta);
            if (!listComprobante.isEmpty()) {
                for (Comprobante obj : listComprobante) {
                    oModeloComprobanteClinica.add(obj);
                    personalizaVistaTabla();
                }
            } else {
                Mensajes.msjResultVacio();
            }

        }
    }

    private boolean isDatosValidosFecha() {
        return (jdcFechaInicio.getDate() != null
                && jdcFechaFin.getDate() != null);
    }

    void iniciar() {
        Utilitarios.fechaActual(jdcFechaInicio);
        Utilitarios.fechaActual(jdcFechaFin);
        oModeloComprobanteClinica.clear();
        oModeloComprobanteDetalle.clear();
        txfNumeroCarta.setText("");
        personalizaVistaTabla();
    }

    private void obtenerDetalles() {
        if (isRowComprobanteSelected()) {
            oModeloComprobanteDetalle.clear();
            oComprobante = oModeloComprobanteClinica.get(tblComprobante.getSelectedRow());
            if (oComprobante != null) {
                listarDetalles(oComprobante);
                personalizaVistaTabla();
            }
        }
    }

    private boolean isRowComprobanteSelected() {
        return (tblComprobante.getRowSelectionAllowed() && tblComprobante.getSelectedRow() != -1);
    }

    private void listarDetalles(Comprobante oComprobante) {
        oComprobanteDetalleBl = new ItemsComprobanteBl();
        listComprobanteDetalle = new LinkedList<>();
        listComprobanteDetalle = oComprobanteDetalleBl.listarXidComprobante(oComprobante.getIdcomprobante());
        for (ComprobanteDetalle obj : listComprobanteDetalle) {
            oModeloComprobanteDetalle.add(obj);
        }
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblComprobante, 60);
        Utilitarios.formateaColumna(1, tblComprobante, 100);
        Utilitarios.formateaColumna(3, tblComprobante, 200);
        Utilitarios.formateaColumna(4, tblComprobante, 70);
        Utilitarios.formateaColumna(5, tblComprobante, 150);
        Utilitarios.formateaColumna(6, tblComprobante, 70);
        Utilitarios.formateaColumna(7, tblComprobante, 60);
        Utilitarios.formateaColumna(8, tblComprobante, 60);
        Utilitarios.alinearDatosColumnaTablaDerecha(7, tblComprobante);
        Utilitarios.alinearDatosColumnaTablaCentro(8, tblComprobante);

        Utilitarios.formateaColumna(0, tblDetalleComprobante, 60);
        Utilitarios.formateaColumna(1, tblDetalleComprobante, 100);
        Utilitarios.formateaColumna(5, tblDetalleComprobante, 60);
        Utilitarios.formateaColumna(6, tblDetalleComprobante, 60);
        Utilitarios.alinearDatosColumnaTablaDerecha(5, tblDetalleComprobante);
        Utilitarios.alinearDatosColumnaTablaCentro(6, tblDetalleComprobante);
    }

    private void GenerarPreFactura() {
        if (isRowComprobanteSelected()) {
            imprimir(oComprobante, new Locale("es", "ENGLISH"));
        } else {
            Mensajes.tblSelected();
        }
    }

    public boolean isTablaSeleccionada() {
        return (tblComprobante.getRowSelectionAllowed() && tblComprobante.getSelectedRow() != -1);
    }

    private void imprimir(Comprobante oComprobante, Locale locale) {
        try {
            ds = new DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport("REP105", new String[]{"ID_COMPROBANTE"}, new Object[]{oComprobante.getIdcomprobante()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Reporte");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
        } catch (Exception ex) {
            Logger.getLogger(JIF_GenerarPreFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
