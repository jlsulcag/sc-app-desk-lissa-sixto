package lissa.gui.farmacia;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lissa.be.Almacen;
import lissa.be.AlmacenProducto;
import lissa.be.AreaConsumo;
import lissa.be.DetalleVenta;
import lissa.be.FarComprobante;
import lissa.be.Kardex;
import lissa.be.Persona;
import lissa.be.Producto;
import lissa.be.Rol;
import lissa.be.Usuario;
import lissa.be.Venta;
import lissa.bl.AlmacenProductoBl;
import lissa.bl.DetalleVentaBl;
import lissa.bl.KardexBl;
import lissa.bl.OrganizacionBl;
import lissa.bl.VentaBl;
import lissa.controller.AlmacenCtrl;
import lissa.controller.AreaConsumoCtrl;
import lissa.controller.FarComprobanteCtrl;
import lissa.ds.DSConeccion;
import lissa.gui.JF_Principal;
import lissa.reportes.ReportGeneric;
import lissa.table.ModeloVentaProducto;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Variables;

public class JIF_NotaSalidaFar extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private FarComprobanteCtrl oFarComprobanteCtrl;
    private Venta oVenta;
    private VentaBl oVentaBl;
    private AlmacenCtrl oAlmacenCtrl;
    private Persona oPersona;
    private Usuario oUsuario;
    private AreaConsumoCtrl oAreaConsumoCtrl;
    private ModeloVentaProducto oModeloVentaProducto;
    private DetalleVenta oDetalleVenta;
    private DetalleVentaBl oDetalleVentBl;
    private Kardex oKardex;
    private KardexBl oKardexBl;
    private AlmacenProducto oAlmacenProducto;
    private AlmacenProductoBl oAlmacenProductoBl;
    public static final BigDecimal IGV = new BigDecimal("0.18");
    private BigDecimal montoSubTotal = new BigDecimal("0.00");
    private BigDecimal montoIgv = new BigDecimal("0.00");
    private BigDecimal montoTotal = new BigDecimal("0.00");

    //Variables para el reporte
    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;

    public JIF_NotaSalidaFar(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloVentaProducto = new ModeloVentaProducto();
        tblProductos.setModel(oModeloVentaProducto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txfPersonaOrigen = new javax.swing.JTextField();
        cbxOrigen = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txfPersonaDestino = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbxAreaConsumo = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        txfGlosa = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbxTipoComprobante = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txfNumeroComprobante = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jdcFechaMov = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Nota de Salida");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txfPersonaOrigen.setEditable(false);

        cbxOrigen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbxOrigen.setEnabled(false);

        jLabel5.setText("Origen :");

        jLabel6.setText("Responsable :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxOrigen, 0, 291, Short.MAX_VALUE)
                    .addComponent(txfPersonaOrigen))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txfPersonaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton6.setText("+");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel8.setText("Responsable :");

        jLabel9.setText("Area :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfPersonaDestino)
                    .addComponent(cbxAreaConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbxAreaConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfPersonaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Observacion"));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txfGlosa)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txfGlosa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Comprobante"));

        jLabel2.setText("Comprobante :");

        cbxTipoComprobante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbxTipoComprobante.setEnabled(false);
        cbxTipoComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoComprobanteActionPerformed(evt);
            }
        });

        jLabel3.setText("N° :");

        txfNumeroComprobante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfNumeroComprobante.setEnabled(false);

        jLabel4.setText("Fecha :");

        jdcFechaMov.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txfNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcFechaMov, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdcFechaMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbxTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txfNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/remove.png"))); // NOI18N
        jButton4.setText("Quitar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblProductos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/cancel16.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setToolTipText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Save16.png"))); // NOI18N
        jButton3.setText("Guardar");
        jButton3.setToolTipText("Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxTipoComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoComprobanteActionPerformed
        if (cbxTipoComprobante.getSelectedIndex() > 0) {
            configuraComprobante();
        }
    }//GEN-LAST:event_cbxTipoComprobanteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        root.jifBusqProductos.setInvocador(JIF_BusqProductos.JIF_NOTASALIDA);
        root.insertarInternalFrames(root.jifBusqProductos);
        root.jifBusqProductos.inicializar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        quitar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        registrar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        root.insertarInternalFrames(root.jifRegAreaConsumo);
        root.jifRegAreaConsumo.enviarJif(root.jifNotaSalidafar);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        inicializar();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxAreaConsumo;
    private javax.swing.JComboBox cbxOrigen;
    private javax.swing.JComboBox cbxTipoComprobante;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFechaMov;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txfGlosa;
    private javax.swing.JTextField txfNumeroComprobante;
    private javax.swing.JTextField txfPersonaDestino;
    private javax.swing.JTextField txfPersonaOrigen;
    // End of variables declaration//GEN-END:variables

    public void inicializar() {
        cargarCbxComprobante();
        Utilitarios.fechaActual(jdcFechaMov);
        cargarCbxOrigen();
        cargarCbxAreaConsumo();
        txfPersonaOrigen.setText(oPersona.getNombre().trim() + " " + oPersona.getApellidoPaterno().trim() + " " + oPersona.getApellidoMaterno().trim());
        //
        cbxAreaConsumo.setSelectedIndex(0);
        txfPersonaDestino.setText("");
        txfGlosa.setText("");
        oModeloVentaProducto.clear();
        personalizaTabla();
        resetMontos();
    }

    private void cargarCbxComprobante() {
        oFarComprobanteCtrl = new FarComprobanteCtrl(root);
        oFarComprobanteCtrl.rellenaTipoComprobante(cbxTipoComprobante, FarComprobante.DISTRIBUCION);
        oFarComprobanteCtrl.defaultSelectCbx("NOTA DE SALIDA", cbxTipoComprobante);
    }

    private void configuraComprobante() {
        oVenta = new Venta();
        oVenta.setGrupoNumeracion(((FarComprobante) cbxTipoComprobante.getSelectedItem()).getGrupoNumeracion());
        txfNumeroComprobante.setText("" + Utilitarios.numberFormat(generarNumeracionComprobante(), "########"));
    }

    private long generarNumeracionComprobante() {
        oVentaBl = new VentaBl();
        return oVentaBl.obtenerUltNumero(oVenta.getGrupoNumeracion()) + 1;
    }

    private void cargarCbxOrigen() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.rellenaAlmacen(cbxOrigen);
        oAlmacenCtrl.defaultSelectAlmacen("FARMACIA", cbxOrigen);
    }

    public void cargarDatosUser(Usuario user, Persona per, Rol oRol) {
        oPersona = per;
        oUsuario = user;
    }

    private void cargarCbxAreaConsumo() {
        oAreaConsumoCtrl = new AreaConsumoCtrl(root);
        oAreaConsumoCtrl.rellenaAlmacen(cbxAreaConsumo);
    }

    private void removeItem() {
        oModeloVentaProducto.remove(tblProductos.getSelectedRow());
    }

    private void personalizaTabla() {
        Utilitarios.formateaColumna(0, tblProductos, 50);
        Utilitarios.formateaColumna(1, tblProductos, 70);
        Utilitarios.formateaColumna(3, tblProductos, 90);
        Utilitarios.formateaColumna(4, tblProductos, 90);
        Utilitarios.formateaColumna(5, tblProductos, 70);
        Utilitarios.formateaColumna(6, tblProductos, 70);
        Utilitarios.alinearDatosColumnaTablaDerecha(1, tblProductos);
        Utilitarios.alinearDatosColumnaTablaCentro(5, tblProductos);
        Utilitarios.alinearDatosColumnaTablaDerecha(6, tblProductos);
    }

    void enviaDatosProducto(DetalleVenta obj) {
        oDetalleVenta = obj;
        //verificar  la existencia del producto en la lista de la tabla
        if (oModeloVentaProducto.size() == 0) {
            oModeloVentaProducto.add(oDetalleVenta);
        } else {
            for (int i = 0; i < oModeloVentaProducto.size(); i++) {
                DetalleVenta det = oModeloVentaProducto.get(i);
                if (oDetalleVenta.getIdAlmacenproducto().equals(det.getIdAlmacenproducto())) {
                    //el producto ya existe en la lista
                    JOptionPane.showMessageDialog(null, "El producto ya existe  en la lista", "Atención", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    oModeloVentaProducto.add(oDetalleVenta);
                    break;
                }
            }
        }
        //
        personalizaTabla();
        calcularMontos(oDetalleVenta);
    }

    private void registrar() {
        int res = 0;
        if (isDatosValidos()) {
            res = registrarSalida(oModeloVentaProducto);
            if (res == Variables.SUCCESS) {
                Mensajes.msjRegCorrecta();
                generarReporte();
                inicializar();
            }
        } else {
            Mensajes.msjValidarIngreso();
        }
    }

    private int registrarSalida(ModeloVentaProducto omvp) {
        oVentaBl = new VentaBl();
        oVenta.setEstadoSunat("NO ENVIADO");
        oVenta.setUsuarioReg(oUsuario);
        oVenta.setFechaVenta(jdcFechaMov.getDate());
        oVenta.setHoraVenta(Utilitarios.horaActual());
        oVenta.setFarComprobante((FarComprobante) cbxTipoComprobante.getSelectedItem());
        oVenta.setNumComprobante(generarNumeracionComprobante());
        oVenta.setGrupoNumeracion(oVenta.getGrupoNumeracion());
        oVenta.setEstado("ACT");
        oVenta.setMotivoAnulacion("");
        oVenta.setAreaConsumo((AreaConsumo) cbxAreaConsumo.getSelectedItem());
        oVenta.setSubTotal(montoSubTotal);
        oVenta.setMontoIgv(montoIgv);
        oVenta.setTotal(montoTotal);
        oVenta.setDescripcionSeguros("");
        oVenta.setNumOperacion(obtenerNumOperacion());
        oVenta.setResponsableNotasalida(txfPersonaDestino.getText().trim().toUpperCase());
        oVenta.setAlmacenOrigen((Almacen) cbxOrigen.getSelectedItem());
        oVenta.setObservacion(txfGlosa.getText().trim().toUpperCase());
        oVenta.setSerie("");
        oVenta.setCaja(root.buscarCaja());
        oVenta.setOrganizacion(new OrganizacionBl().buscar(1));
        oVenta.setUsuarioAnu(null);
        oVenta.setTipoDocCliente(null);
        oVenta.setCorreoClienteTemp("");
        //efact
        oVenta.setTotalValorVentaOpGravadas(oVenta.getSubTotal());
        oVenta.setTotalValorVentaOpeInafectas(BigDecimal.ZERO);
        oVenta.setTotalValorVentaOpeExoneradas(BigDecimal.ZERO);
        oVenta.setTotalSumatoriaIgv(oVenta.getMontoIgv());
        oVenta.setTotalSumatoriaIsc(BigDecimal.ZERO);
        oVenta.setTotalSumatoriaOtrosTributos(BigDecimal.ZERO);
        oVenta.setTotalSumatoriaOtrosCargos(BigDecimal.ZERO);
        oVenta.setTotalSumatoriaDescuentos(BigDecimal.ZERO);
        oVenta.setTotalImporteVenta(oVenta.getTotalValorVentaOpGravadas()
                .add(oVenta.getTotalValorVentaOpeInafectas()
                        .add(oVenta.getTotalValorVentaOpeExoneradas()
                                .add(oVenta.getTotalSumatoriaIgv()
                                        .add(oVenta.getTotalSumatoriaIsc()
                                                .add(oVenta.getTotalSumatoriaOtrosTributos()
                                                        .add(oVenta.getTotalSumatoriaOtrosCargos())))))));
        oVenta.setTipoMoneda("PEN");
        oVenta.setTotalOpeGratuitas(BigDecimal.ZERO);

        //----------------------------------------------------------------------
        //setear  valores para el  kardex de entrada a origen
        List<Kardex> listKardex = new LinkedList<>();
        for (int i = 0; i < omvp.getRowCount(); i++) {
            oDetalleVenta = omvp.get(i);
            oKardex = new Kardex();
            oKardexBl = new KardexBl();

            oKardex.setAlmacenByIdOrigen((Almacen) cbxOrigen.getSelectedItem());
            oKardex.setIdAlmacenAfectado(((Almacen) cbxOrigen.getSelectedItem()).getIdalmacen());
            oKardex.setTipoOperacion("SALIDA");//entrada y salida
            oKardex.setOperacion("DISTRIBUCION");
            oKardex.setFechaMov(new Date());
            oKardex.setHoraMov(Utilitarios.horaActual());
            oKardex.setComprobante(cbxTipoComprobante.getSelectedItem().toString());
            oKardex.setNumSerie("");
            oKardex.setNumComprobante(Long.parseLong(txfNumeroComprobante.getText().trim()));
            oKardex.setOrigen(((Almacen) cbxOrigen.getSelectedItem()).getNombre());
            oKardex.setDestino(((AreaConsumo) cbxAreaConsumo.getSelectedItem()).getDescripcion());
            oKardex.setObservacion("");
            oKardex.setGrupoNumeracion(1);
            oKardex.setIdProducto(Long.parseLong(oDetalleVenta.getProducto().getIdproducto() + ""));
            oKardex.setCantidad(oDetalleVenta.getCantidadVenta());
            oKardex.setValorUnit(oDetalleVenta.getPrecioVenta());
            oKardex.setIdAlmacenproducto(oDetalleVenta.getIdAlmacenproducto());
            oKardex.setEstado(1);
            //Obntener el ultimo numero de orden de registro de kardex
            long nro = oKardexBl.nroOrdenregistro(oKardex.getIdProducto());
            oKardex.setNroOrden(nro + 1);

            oAlmacenProductoBl = new AlmacenProductoBl();
            AlmacenProducto ap = oAlmacenProductoBl.buscar(oDetalleVenta.getIdAlmacenproducto());
            oKardex.setStockActual(ap.getStockActual().subtract(oKardex.getCantidad()));

            listKardex.add(oKardex);
        }

        return oVentaBl.registrar(oVenta, omvp, null, null, listKardex);
    }

    private int registrarDetalleVenta(Venta oVenta) {
        int exito = 0;
        if (oModeloVentaProducto.size() > 0) {
            for (int i = 0; i < oModeloVentaProducto.size(); i++) {
                oDetalleVenta = oModeloVentaProducto.get(i);
                oDetalleVentBl = new DetalleVentaBl();
                oDetalleVenta.setVenta(oVenta);
                oDetalleVentBl.registrar(oDetalleVenta);
                exito++;
            }
        } else {
            exito = 0;
        }
        return exito;

    }

    private boolean isDatosValidos() {
        return (cbxTipoComprobante.getSelectedIndex() > 0
                && !txfNumeroComprobante.getText().trim().equals("")
                && jdcFechaMov.getDate() != null
                && cbxOrigen.getSelectedIndex() > 0
                && cbxAreaConsumo.getSelectedIndex() > 0
                && !txfPersonaDestino.getText().trim().equals("")
                && oModeloVentaProducto.getRowCount() > 0);
    }

    void actualizarLista() {
        cargarCbxAreaConsumo();
    }

    private void calcularMontos(DetalleVenta temp) {
        if (oModeloVentaProducto.size() > 0) {
//            for (int i = 0; i < oModeloVentaProducto.size(); i++) {
//                DetalleVenta temp = oModeloVentaProducto.get(i);
            if (cbxTipoComprobante.getSelectedItem().toString().equals("FACTURA")) {
                montoTotal = montoTotal.add(temp.getPrecioVenta().multiply(temp.getCantidadVenta()));
                montoSubTotal = montoSubTotal.add(montoTotal.divide(new BigDecimal("1.18"), 4, RoundingMode.HALF_UP));
                montoIgv = montoSubTotal.multiply(IGV);
            } else {
                //montoSubTotal = montoSubTotal.add(temp.getPrecioVenta().multiply(new BigDecimal(temp.getCantidadVenta())));
                montoSubTotal = BigDecimal.ZERO;
                montoIgv = BigDecimal.ZERO;
                montoTotal = montoTotal.add(temp.getPrecioVenta().multiply(temp.getCantidadVenta()));
            }
//            }

        }
    }

    private void quitar() {
        if (tblProductos.getSelectedRow() != -1 && tblProductos.getRowSelectionAllowed()) {
            //recalculaMontos();//Primero recalcular antes de quitar el item del modelo
            quitarProducto(tblProductos.getSelectedRow());
            recalculaMontosTotales();

        } else {
            Mensajes.tblSelected();
        }
        personalizaTabla();
    }

    private void quitarProducto(int selectedRow) {
        oModeloVentaProducto.remove(selectedRow);
    }

    private void recalculaMontosTotales() {
        resetMontos();
        if (oModeloVentaProducto.size() > 0) {
            for (int i = 0; i < oModeloVentaProducto.size(); i++) {
                DetalleVenta temp = oModeloVentaProducto.get(i);
                if (cbxTipoComprobante.getSelectedItem().toString().equals("FACTURA")) {
                    montoTotal = montoTotal.add(temp.getPrecioVenta().multiply(temp.getCantidadVenta()));
                    montoSubTotal = montoTotal.divide(new BigDecimal("1.18"), 4, RoundingMode.HALF_UP);
                    montoIgv = montoSubTotal.multiply(IGV);
                } else {
                    montoSubTotal = BigDecimal.ZERO;
                    montoIgv = BigDecimal.ZERO;
                    montoTotal = montoTotal.add(temp.getPrecioVenta().multiply(temp.getCantidadVenta()));
                }
            }

        } else {
            resetMontos();
        }
    }

    private void resetMontos() {
        montoSubTotal = BigDecimal.ZERO;
        montoIgv = BigDecimal.ZERO;
        montoTotal = BigDecimal.ZERO;
    }

    private void registrarKardexAlmacen() {
        oKardex = registrarKardex();
    }

    private Kardex registrarKardex() {

        return oKardex;

    }

    private long stockAnterior(int idproducto, int idalmacen) {
        oAlmacenProductoBl = new AlmacenProductoBl();
        return oAlmacenProductoBl.buscar(idproducto, idalmacen);
    }

    private void actualizarAlmacenStock() {
        for (int i = 0; i < oModeloVentaProducto.getRowCount(); i++) {
            oAlmacenProducto = new AlmacenProducto();
            oAlmacenProductoBl = new AlmacenProductoBl();
            //buscar el producto y su stock para suactualización
            oDetalleVenta = oModeloVentaProducto.get(i);
            oAlmacenProducto = oAlmacenProductoBl.buscarxIdalmacenproducto(oDetalleVenta.getIdAlmacenproducto());
            if (oAlmacenProducto != null) {
                oAlmacenProducto.setStockActual(oAlmacenProducto.getStockActual().subtract(oDetalleVenta.getCantidadVenta()));
                oAlmacenProductoBl.actualizar(oAlmacenProducto);
            }

        }
    }

    private AlmacenProducto buscarAlmacenProductoXlote(String lote, Almacen almacen, Producto producto) {
        oAlmacenProductoBl = new AlmacenProductoBl();
        return oAlmacenProductoBl.buscarProductoxAlmacenyLote(lote, almacen, producto);
    }

    private int obtenerNumOperacion() {
        oVentaBl = new VentaBl();
        return oVentaBl.obtenerNumOperacion() + 1;
    }

    private void generarReporte() {
        try {
            ds = new DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            System.out.println("is venta ... " + oVenta.getIdventa());
            reportPanel = reportGenric.mkReport("Ventas_NotaSalida", new String[]{"ID_VENTA"}, new Object[]{oVenta.getIdventa()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Reporte ventas nota salida");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.setMaximizable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
        } catch (Exception ex) {
            Logger.getLogger(JIF_NotaSalidaFar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
