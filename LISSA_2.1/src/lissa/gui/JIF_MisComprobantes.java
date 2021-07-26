package lissa.gui;

import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.DetalleVenta;
import lissa.be.Venta;
import lissa.bl.DetalleVentaBl;
import lissa.bl.VentaBl;
import lissa.table.ModeloComprobanteElectronicoAdmision;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Constants;

public class JIF_MisComprobantes extends javax.swing.JInternalFrame {

    public JF_Principal root;
    private ModeloComprobanteElectronicoAdmision oModeloComprobanteElectronicoAdmision;
    private Venta oVenta;
    private VentaBl oVentaBl;
    private List<Venta> listVentas;
    private DetalleVentaBl oDetalleVentaBl;
    private List<DetalleVenta> listDetalleVenta;

    public JIF_MisComprobantes(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloComprobanteElectronicoAdmision = new ModeloComprobanteElectronicoAdmision();
        tblResultados.setModel(oModeloComprobanteElectronicoAdmision);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jdcFechaEmision = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txfusuario = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanelResultados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Mis Comprobantes");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jLabel1.setText("Fecha de emisión :");

        jLabel2.setText("Usuario :");

        txfusuario.setEnabled(false);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
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
                .addComponent(jdcFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfusuario, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addComponent(btnBuscar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jdcFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txfusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelResultados.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblResultadosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultados);

        jButton1.setText("Enviar a Sunat");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelResultadosLayout = new javax.swing.GroupLayout(jPanelResultados);
        jPanelResultados.setLayout(jPanelResultadosLayout);
        jPanelResultadosLayout.setHorizontalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelResultadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanelResultadosLayout.setVerticalGroup(
            jPanelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        listarComprobantes();
        personalizaTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseReleased
        obtenerDatos();
    }//GEN-LAST:event_tblResultadosMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Metodo pendiente  hasta su validación
        enviarASunat();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Constants declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelResultados;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFechaEmision;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txfusuario;
    // End of variables declaration//GEN-END:variables

    void inicializar() {
        Utilitarios.fechaActual(jdcFechaEmision);
        txfusuario.setText(root.getUser().getNombre().trim());
        oModeloComprobanteElectronicoAdmision.clear();
        personalizaTabla();
    }

    private void personalizaTabla() {
        Utilitarios.formateaColumna(0, tblResultados, 80);
        Utilitarios.formateaColumna(1, tblResultados, 200);
        Utilitarios.formateaColumna(2, tblResultados, 150);
        Utilitarios.formateaColumna(4, tblResultados, 80);
        Utilitarios.formateaColumna(5, tblResultados, 80);
        Utilitarios.formateaColumna(6, tblResultados, 120);

    }

    private void listarComprobantes() {
        oVentaBl = new VentaBl();
        listVentas = oVentaBl.listarXusuarioYFecha(root.getUser(), Utilitarios.castDate_UTIL_SQL(jdcFechaEmision.getDate()));
        oModeloComprobanteElectronicoAdmision.clear();
        if (!listVentas.isEmpty()) {
            for (Venta obj : listVentas) {
                oModeloComprobanteElectronicoAdmision.add(obj);
            }
        } else {
            Mensajes.msjResultVacio();
        }
    }

    private void obtenerDatos() {
        oDetalleVentaBl = new DetalleVentaBl();
        if (isFilaSelected()) {
            oVenta = oModeloComprobanteElectronicoAdmision.get(tblResultados.getSelectedRow());
            //Obtener el detalle de las ventas de la fila seleccionada
            listDetalleVenta = oDetalleVentaBl.listarDetallesxidVenta(oVenta.getIdventa());
        }
    }

    private boolean isFilaSelected() {
        return (tblResultados.getSelectedRow() != -1 && tblResultados.getRowSelectionAllowed());
    }

    private void enviarASunat() {
        int res = -1;
        oVentaBl = new VentaBl();
        if (oVenta.getEstadoSunat().equals("NO ENVIADO")) {
            res = oVentaBl.enviarComprobanteElectronicoASunat(oVenta, listDetalleVenta);
            if (res == Constants.SUCCESS) {
                Mensajes.msjRegCorrecta();
            } else {
                Mensajes.msjRegError();
            }
        }else if(oVenta.getEstadoSunat().equals("ENVIADO")){
            JOptionPane.showMessageDialog(null, "El comprobante ya fue ENVIADO a SUNAT ...", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "El comprobante debe estar como NO ENVIADO ...", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
