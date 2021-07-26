package lissa.gui.farmacia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.Almacen;
import lissa.be.AlmacenProducto;
import lissa.be.DetalleVenta;
import lissa.be.FarComprobante;
import lissa.be.Kardex;
import lissa.be.Persona;
import lissa.be.PrecioProducto;
import lissa.be.Producto;
import lissa.be.Rol;
import lissa.be.TipoOperacion;
import lissa.be.Usuario;
import lissa.bl.AlmacenProductoBl;
import lissa.bl.KardexBl;
import lissa.bl.PrecioProductoBl;
import lissa.bl.TipoOperacionBl;
import lissa.controller.AlmacenCtrl;
import lissa.controller.FarComprobanteCtrl;
import lissa.controller.TipoOperacionCtrl;
import lissa.gui.JF_Principal;
import lissa.table.ModeloVentaProducto;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Constants;

public class JIF_RegistroMovimiento extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private Usuario userTemp;
    private Persona perTemp;
    private Rol rolTemp;
    private TipoOperacionBl oTipoOperacionBl;
    private ArrayList<TipoOperacion> listTipoOperacion;
    private AlmacenCtrl oAlmacenCtrl;
    private TipoOperacionCtrl oTipoOperacionCtrl;
    private DetalleVenta oDetalleVenta;
    private ModeloVentaProducto oModeloVentaProducto;
    private Kardex oKardex;
    private Kardex oKardexIngreso;
    private KardexBl oKardexBl;
    private AlmacenProducto oAlmacenProducto;
    private AlmacenProducto oAlmacenProductoDestino;
    private AlmacenProductoBl oAlmacenProductoBl;
    private FarComprobanteCtrl oFarComprobanteCtrl;
    private int op = 0;
    private List<AlmacenProducto> listAlmacenProducto;
    private PrecioProductoBl oPrecioProductoBl;
    private PrecioProducto oPrecioProducto;

    public JIF_RegistroMovimiento(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloVentaProducto = new ModeloVentaProducto();
        tblProductos.setModel(oModeloVentaProducto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txfPersonaOrigen = new javax.swing.JTextField();
        cbxOrigen = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cbxDestino = new javax.swing.JComboBox();
        txfPersonaDestino = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txfGlosa = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbxTipoComprobante = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txfNumeroComprobante = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jdcFechaMov = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        cbxTipoOperacion = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registro de Movimientos");

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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txfPersonaOrigen.setEditable(false);

        cbxOrigen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

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
                    .addComponent(cbxOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        cbxDestino.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel7.setText("Destino :");

        jLabel8.setText("Responsable :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxDestino, 0, 304, Short.MAX_VALUE)
                    .addComponent(txfPersonaDestino))
                .addGap(57, 57, 57))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jLabel1.setText("Operación :");

        cbxTipoOperacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbxTipoOperacion.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbxTipoOperacion, 0, 180, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcFechaMov, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcFechaMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbxTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txfNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel1)
                        .addComponent(cbxTipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Save16.png"))); // NOI18N
        jButton2.setText("Guardar");
        jButton2.setToolTipText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/cancel16.png"))); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.setToolTipText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/remove.png"))); // NOI18N
        jButton4.setText("Quitar");
        jButton4.setToolTipText("Quitar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 671, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(2, 2, 2)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        root.jifBusqProductos.setInvocador(JIF_BusqProductos.JIF_ALMACEN); 
        root.jifBusqProductos.setAlmacenOrigen(((Almacen)cbxOrigen.getSelectedItem()).getNombre().trim());
        root.insertarInternalFrames(root.jifBusqProductos);        
        root.jifBusqProductos.inicializar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        registrar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        resetComponentFull();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (tblProductos.getRowSelectionAllowed() && tblProductos.getSelectedRow() != -1) {
            removeItem();
        } else {
            Mensajes.tblSelected();
        }
        personalizaTabla();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbxTipoComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoComprobanteActionPerformed
        if (cbxTipoComprobante.getSelectedIndex() > 0) {
            configuraComprobante();
        }
    }//GEN-LAST:event_cbxTipoComprobanteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox cbxDestino;
    private javax.swing.JComboBox cbxOrigen;
    private javax.swing.JComboBox cbxTipoComprobante;
    private javax.swing.JComboBox cbxTipoOperacion;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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

    public void cargarDatosUser(Usuario user, Persona oPersona, Rol oRol) {
        userTemp = user;
        perTemp = oPersona;
        rolTemp = oRol;
    }

    public void inicializar() {
        cargarCbxTipoComprobanteFar();
        cargarCbxTipoOperacion();
        cargarCbxOrigen();
        cargarCbxDestino();
        defaultValores();
        personalizaTabla();
        iniciaFecha();
    }

    private void cargarCbxTipoComprobanteFar() {
        oFarComprobanteCtrl = new FarComprobanteCtrl(root);
        oFarComprobanteCtrl.rellenaTipoComprobante(cbxTipoComprobante, FarComprobante.DISTRIBUCION);
        oFarComprobanteCtrl.defaultSelectCbx("FICHA KARDEX", cbxTipoComprobante);
    }

    private void cargarCbxTipoOperacion() {
        oTipoOperacionCtrl = new TipoOperacionCtrl(root);
        oTipoOperacionCtrl.rellenaTipoOperacion(cbxTipoOperacion);
    }

    private void cargarCbxOrigen() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.rellenaAlmacen(cbxOrigen);
    }

    private void cargarCbxDestino() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.rellenaAlmacen(cbxDestino);
    }

    private void defaultOrigen() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.defaultSelectAlmacen("ALMACEN", cbxOrigen);
    }

    private void defaultDestino() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.defaultSelectAlmacen("FARMACIA", cbxDestino);
    }

    private void defaultTipoOperacion() {
        oTipoOperacionCtrl = new TipoOperacionCtrl(root);
        oTipoOperacionCtrl.defaultSelectTipoOperacion("SALIDA", cbxTipoOperacion);
    }

    private void defaultComprobante() {
        oFarComprobanteCtrl = new FarComprobanteCtrl(root);
        oFarComprobanteCtrl.defaultSelectCbx("FICHA KARDEX", cbxTipoComprobante);
    }

    private void printDatosUser() {
        txfPersonaOrigen.setText(perTemp.getNombre().trim() + " " + perTemp.getApellidoPaterno().trim() + " " + perTemp.getApellidoMaterno().trim());
    }
    
    /*Viene datos desde Jif_cantidad*/
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
        personalizaTabla();
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

    private boolean isDatosValidos() {
        return (cbxTipoOperacion.getSelectedIndex() > 0
                && cbxTipoComprobante.getSelectedIndex() > 0
                && !txfNumeroComprobante.getText().trim().equals("")
                && jdcFechaMov.getDate() != null
                && cbxOrigen.getSelectedIndex() > 0
                && cbxDestino.getSelectedIndex() > 0
                && oModeloVentaProducto.size() > 0);
    }

    private void paintComponent() {
        Utilitarios.paintCbxVacio(cbxTipoOperacion);
        Utilitarios.paintCbxVacio(cbxTipoComprobante);
        Utilitarios.paintCbxVacio(cbxOrigen);
        Utilitarios.paintCbxVacio(cbxDestino);
        Utilitarios.paintBorderTxfVacio(txfNumeroComprobante);
        Utilitarios.paintJdcVacio(jdcFechaMov);

    }

    private void resetPaintComponent() {
        Utilitarios.resetPaintCbx(cbxTipoOperacion);
        Utilitarios.resetPaintCbx(cbxTipoComprobante);
        Utilitarios.resetPaintCbx(cbxOrigen);
        Utilitarios.resetPaintCbx(cbxDestino);
        Utilitarios.resetPaintBorderTxf(txfNumeroComprobante);
        Utilitarios.resetPaintJdc(jdcFechaMov);
    }

    private void registrarKardexAlmacen() {
        for (int i = 0; i < oModeloVentaProducto.getRowCount(); i++) {
            DetalleVenta dv = new DetalleVenta();
            dv = oModeloVentaProducto.get(i);
            //salida de almacen
            oKardex = registrarKardex(dv);
            //ingreso a farmacia
            oKardexIngreso = registrarKardexIngresoFar(dv);
        }

    }

    private Kardex registrarKardex(DetalleVenta dv) {
        oKardex = new Kardex();
        oKardexBl = new KardexBl();

        oKardex.setAlmacenByIdOrigen((Almacen) cbxOrigen.getSelectedItem());
        oKardex.setIdAlmacenAfectado(((Almacen) cbxOrigen.getSelectedItem()).getIdalmacen());
        oKardex.setAlmacenByIdDestino((Almacen) cbxDestino.getSelectedItem());

        oKardex.setIdFarcomprobante(((FarComprobante) (cbxTipoComprobante.getSelectedItem())).getIdfarcomprobante());
        oKardex.setTipoOperacion("SALIDA");
        oKardex.setOperacion("DISTRIBUCION");
        oKardex.setFechaMov(new Date());
        oKardex.setHoraMov(Utilitarios.horaActual());
        oKardex.setComprobante(cbxTipoComprobante.getSelectedItem().toString());
        oKardex.setNumSerie("");
        oKardex.setNumComprobante(Long.parseLong(txfNumeroComprobante.getText().trim()));
        oKardex.setOrigen(txfPersonaOrigen.getText().toUpperCase().trim());
        oKardex.setDestino(txfPersonaDestino.getText().toUpperCase().trim());
        oKardex.setObservacion(txfGlosa.getText().toUpperCase().trim());
        oKardex.setGrupoNumeracion(1);
        oKardex.setIdProducto(Long.parseLong(dv.getProducto().getIdproducto() + ""));
        oKardex.setCantidad(dv.getCantidadVenta());
        oKardex.setIdAlmacenproducto(dv.getIdAlmacenproducto());
        oKardex.setValorUnit(BigDecimal.ZERO);
        oKardex.setEstado(1);
        //Obntener el ultimo numero de orden de registro de kardex
        long nro = oKardexBl.nroOrdenregistro(oKardex.getIdProducto());
        oKardex.setNroOrden(nro + 1);
        //obtener el stock actual y restarlo la cantidad de salida
        oAlmacenProductoBl = new AlmacenProductoBl();
        oAlmacenProducto = oAlmacenProductoBl.buscarxAlmacen(oKardex.getIdAlmacenproducto(), oKardex.getIdAlmacenAfectado());
        if (oAlmacenProducto != null) {
            oKardex.setStockActual(oAlmacenProducto.getStockActual());
        }

        return oKardexBl.registrar(oKardex);
    }

    private Kardex registrarKardexIngresoFar(DetalleVenta dv) {
        oKardexIngreso = new Kardex();
        oKardexBl = new KardexBl();

        oKardexIngreso.setAlmacenByIdOrigen((Almacen) cbxOrigen.getSelectedItem());
        oKardexIngreso.setIdAlmacenAfectado(((Almacen) cbxDestino.getSelectedItem()).getIdalmacen());
        oKardexIngreso.setAlmacenByIdDestino((Almacen) cbxDestino.getSelectedItem());
        oKardexIngreso.setIdFarcomprobante(((FarComprobante) (cbxTipoComprobante.getSelectedItem())).getIdfarcomprobante());
        oKardexIngreso.setTipoOperacion("ENTRADA");
        oKardexIngreso.setOperacion("DISTRIBUCION");
        oKardexIngreso.setFechaMov(new Date());
        oKardexIngreso.setHoraMov(Utilitarios.horaActual());
        oKardexIngreso.setComprobante(cbxTipoComprobante.getSelectedItem().toString());
        oKardexIngreso.setNumSerie("");
        oKardexIngreso.setNumComprobante(Long.parseLong(txfNumeroComprobante.getText().trim()));
        oKardexIngreso.setOrigen(txfPersonaOrigen.getText().toUpperCase().trim());
        oKardexIngreso.setDestino(txfPersonaDestino.getText().toUpperCase().trim());
        oKardexIngreso.setObservacion(txfGlosa.getText().toUpperCase().trim());
        oKardexIngreso.setGrupoNumeracion(1);
        oKardexIngreso.setIdProducto(Long.parseLong(dv.getProducto().getIdproducto() + ""));
        oKardexIngreso.setCantidad(dv.getCantidadVenta());
        oKardexIngreso.setValorUnit(BigDecimal.ZERO);
        oKardexIngreso.setIdAlmacenproducto(dv.getIdAlmacenproducto());
        oKardexIngreso.setEstado(1);
        //Obntener el ultimo numero de orden de registro de kardex
        long nro = oKardexBl.nroOrdenregistro(oKardexIngreso.getIdProducto());
        oKardexIngreso.setNroOrden(nro + 1);
        //obtener el stock actual y sumarle la cantidad de ingreso
        oAlmacenProductoBl = new AlmacenProductoBl();
        //oAlmacenProducto = oAlmacenProductoBl.buscarxAlmacen(oKardexIngreso.getIdAlmacenproducto(), oKardexIngreso.getIdAlmacenAfectado());
        oAlmacenProducto = oAlmacenProductoBl.buscarProductoxAlmacenyLote(dv.getLote(), oKardexIngreso.getAlmacenByIdDestino(), dv.getProducto());
        if (oAlmacenProducto != null) {
            oKardexIngreso.setStockActual(oAlmacenProducto.getStockActual());
        } else {
            oKardexIngreso.setStockActual(oKardexIngreso.getCantidad());
        }
        return oKardexBl.registrar(oKardexIngreso);
    }

    private long stockAnterior(int idproducto, int idalmacen) {
        oAlmacenProductoBl = new AlmacenProductoBl();
        return oAlmacenProductoBl.buscar(idproducto, idalmacen);
    }

    private void actualizarAlmacenStock() {
        for (int i = 0; i < oModeloVentaProducto.getRowCount(); i++) {
            //buscar en almacen por producto y nombre de almacen para su actualizacion y lote y retornar el objeto a actualizar

            oDetalleVenta = oModeloVentaProducto.get(i);
            //Actualizar stock en origen
            actualizarAlmacenOrigen(oDetalleVenta, (Almacen) cbxOrigen.getSelectedItem());
            actualizarAlmacenDestino(oDetalleVenta, (Almacen) cbxDestino.getSelectedItem());

        }
    }

    private AlmacenProducto buscarAlmacenProductoXlote(String lote) {
        oAlmacenProductoBl = new AlmacenProductoBl();
        return oAlmacenProductoBl.buscar(lote);
    }

    private void actualizarAlmacenOrigen(DetalleVenta oDetalleVenta, Almacen origen) {
        int res = 0;
        oAlmacenProductoBl = new AlmacenProductoBl();

        oAlmacenProducto = buscarxIdalmacenProducto(oDetalleVenta.getIdAlmacenproducto());
        if (oAlmacenProducto != null) {
            oAlmacenProducto.setStockActual(oAlmacenProducto.getStockActual().subtract(oDetalleVenta.getCantidadVenta()));
            res = oAlmacenProductoBl.actualizar(oAlmacenProducto);
            if (res == -1) {
                JOptionPane.showMessageDialog(null, "Error al actualizar stock origen ... Consulte al Administrador del Sistema \n ID PRODUCTO = " + oAlmacenProducto.getProducto().getIdproducto(), "Error Fatal", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void actualizarAlmacenDestino(DetalleVenta oDetalleVenta, Almacen destino) {
        int res = 0;
        oAlmacenProductoBl = new AlmacenProductoBl();
        //oAlmacenProducto = buscarxIdalmacenProducto(oDetalleVenta.getIdAlmacenproducto());
        //se debe buscar por almacen, lote y producto debido a que el producto ya puedee existir en farmacia
        oAlmacenProducto = buscarProductoxAlmacenyLote(destino, oDetalleVenta.getLote(), oDetalleVenta.getProducto());
        if (oAlmacenProducto != null) {
            oAlmacenProducto.setStockActual(oAlmacenProducto.getStockActual().add(oDetalleVenta.getCantidadVenta()));
            res = oAlmacenProductoBl.actualizar(oAlmacenProducto);
            if (res == -1) {
                JOptionPane.showMessageDialog(null, "Error al actualizar stock destino ... Consulte al Administrador del Sistema \n ID PRODUCTO = " + oAlmacenProducto.getProducto().getIdproducto(), "Error Fatal", JOptionPane.ERROR_MESSAGE);
            }
        } else {//registrar uno nuevo
            oAlmacenProducto = new AlmacenProducto();
            oAlmacenProducto.setProducto(oDetalleVenta.getProducto());
            oAlmacenProducto.setAlmacen(destino);
            oAlmacenProducto.setStockActual(oDetalleVenta.getCantidadVenta());
            oAlmacenProducto.setFechaRegistro(new Date());
            oAlmacenProducto.setFechaUltAct(new Date());
            oAlmacenProducto.setEstado(Boolean.TRUE);
            oAlmacenProducto.setLote(oDetalleVenta.getLote() != null ? oDetalleVenta.getLote() : "");
            //fecha de vencimiento por lote
            //buscar en el almacen principal  los datos adicionale del producto
            AlmacenProducto temp = new AlmacenProducto();
            //temp = oAlmacenProductoBl.buscarProductoxAlmacenyLote(oDetalleVenta.getLote(), (Almacen) cbxOrigen.getSelectedItem(), oDetalleVenta.getProducto());
            temp = oAlmacenProductoBl.buscarxIdalmacenproducto(oDetalleVenta.getIdAlmacenproducto());
            if (temp != null) {
                oAlmacenProducto.setFechaVencimiento(temp.getFechaVencimiento() != null ? temp.getFechaVencimiento() : null);
                oAlmacenProducto.setValorCompraUnitario(temp.getValorCompraUnitario());
            }
            oAlmacenProductoBl.registrar(oAlmacenProducto);
            //Buscar  el precio del producto de  no existir se proceder a registrar
            oPrecioProductoBl = new PrecioProductoBl();
            oPrecioProducto = new PrecioProducto();
            oPrecioProducto = oPrecioProductoBl.buscarxIdAlmacenProducto(oDetalleVenta.getIdAlmacenproducto());
            if (oPrecioProducto == null) {//registrar precios para la farmacia
                oPrecioProducto.setAlmacenProducto(oAlmacenProducto);
                oPrecioProducto.setPvMin(oDetalleVenta.getPvMin());
                oPrecioProducto.setPvMax(oDetalleVenta.getPvMax());
                oPrecioProducto.setPvSugerido(oDetalleVenta.getPrecioVenta());
                oPrecioProducto.setFechaInicio(new Date());
                oPrecioProducto.setFechaFin(null);
                oPrecioProducto.setIdUsuario(userTemp.getIdUsuario());
                oPrecioProducto.setEstado(1);
                oPrecioProductoBl.registrar(oPrecioProducto);
            }
        }
    }

    private AlmacenProducto buscarxIdalmacenProducto(long idalmacenproducto) {
        oAlmacenProductoBl = new AlmacenProductoBl();
        return oAlmacenProductoBl.buscarxIdalmacenproducto(idalmacenproducto);

    }

    private AlmacenProducto buscarProductoxAlmacenyLote(Almacen almacen, String lote, Producto oProducto) {
        oAlmacenProductoBl = new AlmacenProductoBl();
        return oAlmacenProductoBl.buscarProductoxAlmacenyLote(lote, almacen, oProducto);
    }

    private void resetComponentFull() {
        inicializar();
//        defaultValores();
//        //generaNumeracion();
//        iniciaFecha();
//        txfNumeroComprobante.setText("");
        txfPersonaDestino.setText("");
        txfGlosa.setText("");
        oModeloVentaProducto.clear();
        resetPaintComponent();
        personalizaTabla();
    }

    private void defaultValores() {
        defaultOrigen();
        defaultDestino();
        printDatosUser();
        defaultTipoOperacion();
        //defaultComprobante();
    }

    private void iniciaFecha() {
        Utilitarios.fechaActual(jdcFechaMov);
    }

    private void generaNumeracion(int grupo) {
        oKardexBl = new KardexBl();
        long num = oKardexBl.generarNumeracion(grupo) + 1;
        txfNumeroComprobante.setText(Utilitarios.numberFormat(num, "##########"));
    }

    private void removeItem() {
        oModeloVentaProducto.remove(tblProductos.getSelectedRow());
    }

    private void configuraComprobante() {
        oKardex = new Kardex();
        switch (cbxTipoComprobante.getSelectedItem().toString()) {
            case "FICHA KARDEX":
                oKardex.setGrupoNumeracion(1);
                generaNumeracion(oKardex.getGrupoNumeracion());
                //txfNumeroComprobante.setText("" + Utilitarios.numberFormat(generarNumeracionComprobante(), "##########"));
                break;
            case "NOTA DE SALIDA":
                oKardex.setGrupoNumeracion(2);
                generaNumeracion(oKardex.getGrupoNumeracion());
                break;
        }
    }

    private void registrar() {
        int r = -1;
        if (isDatosValidos()) {
            r = registrarMovimiento();
            if(r==Constants.SUCCESS){
                Mensajes.msjRegCorrecta();
                resetComponentFull();
            }
            /*
             actualizarAlmacenStock();
             registrarKardexAlmacen();
             //inicializar();
             resetComponentFull();
             Mensajes.msjRegCorrecta();
             */
        } else {
            Mensajes.msjValidarIngreso();
            paintComponent();
        }
        personalizaTabla();
    }

    private int registrarMovimiento() {
        oAlmacenProductoBl = new AlmacenProductoBl();
        Almacen origen = (Almacen)cbxOrigen.getSelectedItem();
        Almacen destino = (Almacen)cbxDestino.getSelectedItem();
        FarComprobante oFarComprobante = (FarComprobante)cbxTipoComprobante.getSelectedItem();        
        return oAlmacenProductoBl.registrarMovimiento(origen,destino,oFarComprobante,jdcFechaMov.getDate(), txfPersonaOrigen.getText().trim(), txfPersonaDestino.getText().toUpperCase().trim(), txfGlosa.getText().toUpperCase().trim(), oModeloVentaProducto, userTemp, txfNumeroComprobante.getText().trim());
        
    }

}
