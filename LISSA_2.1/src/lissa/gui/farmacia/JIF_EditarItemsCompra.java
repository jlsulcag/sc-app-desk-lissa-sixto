/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.gui.farmacia;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;
import lissa.be.DetalleCompra;
import lissa.bl.DetalleCompraBl;
import lissa.gui.JF_Principal;
import lissa.util.Utilitarios;
import lissa.util.Constants;

public class JIF_EditarItemsCompra extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private DetalleCompra oDetalleCompra;
    private DetalleCompraBl oDetalleCompraBl;

    private BigDecimal cant = new BigDecimal("0.00");
    private BigDecimal valorUnitario = new BigDecimal("0.00");
    private BigDecimal valor_compra = new BigDecimal("0.00");
    private double desc_unico;
    private BigDecimal valor_desc_item = new BigDecimal("0.00");
    private BigDecimal valor_igv_item = new BigDecimal("0.00");
    private BigDecimal fra = new BigDecimal("0.00");
    private BigDecimal valor_total_item = new BigDecimal("0.00");
    private BigDecimal valor_desc_total = new BigDecimal("0.00");
    private BigDecimal valor_total = new BigDecimal("0.00");
    ;
    private BigDecimal prec_compra_fraccion = new BigDecimal("0.00");
    private BigDecimal prec_compra_unidad = new BigDecimal("0.00");
    public static final BigDecimal CIEN = new BigDecimal("100");

    public static final BigDecimal IGV = new BigDecimal("0.18");
    private BigDecimal valorNeto = new BigDecimal("0.00");
    private BigDecimal valorIgv = new BigDecimal("0.00");
    private BigDecimal valorBruto = new BigDecimal("0.00");
    private BigDecimal valorDescuento = new BigDecimal("0.00");
    private BigDecimal valorTotal = new BigDecimal("0.00");
    private BigDecimal pvMin = new BigDecimal("0.00");
    private BigDecimal pvMax = new BigDecimal("0.00");

    public JIF_EditarItemsCompra(JF_Principal root) {
        initComponents();
        this.root = root;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfProducto = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txfUnidad = new javax.swing.JTextField();
        chbxBono = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txfNumeroLote = new javax.swing.JTextField();
        jdcFechaVencimiento = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txfValorUnitario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txfDescuentoItem = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txfCantidad = new javax.swing.JTextField();
        txfDesc1 = new javax.swing.JTextField();
        txfDesc2 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txfPrecioUnitario = new javax.swing.JTextField();
        txfTotalUnidades = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Editar Items");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del producto"));

        jLabel1.setText("Producto :");

        txfProducto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfProducto.setEnabled(false);

        jLabel25.setText("Unidad :");

        txfUnidad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfUnidad.setEnabled(false);

        chbxBono.setText("Reg x Unidad");
        chbxBono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxBonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(txfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(chbxBono, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txfUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chbxBono))
                .addGap(1, 1, 1))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la compra"));

        jLabel3.setText("Cantidad :");

        jLabel4.setText("N° Lote :");

        jLabel5.setText("Fecha Vencimiento :");

        txfNumeroLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfNumeroLoteKeyPressed(evt);
            }
        });

        jdcFechaVencimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jdcFechaVencimientoKeyPressed(evt);
            }
        });

        jLabel8.setText("Valor Unitario :");

        txfValorUnitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfValorUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfValorUnitarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfValorUnitarioKeyReleased(evt);
            }
        });

        jLabel13.setText("Descuento (S/.) :");

        txfDescuentoItem.setEditable(false);
        txfDescuentoItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfDescuentoItem.setText("0.00");

        jLabel18.setText("Descuento (%) :");

        txfCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfCantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCantidadKeyReleased(evt);
            }
        });

        txfDesc1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfDesc1.setPreferredSize(new java.awt.Dimension(60, 20));
        txfDesc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfDesc1KeyPressed(evt);
            }
        });

        txfDesc2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfDesc2.setPreferredSize(new java.awt.Dimension(60, 20));
        txfDesc2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfDesc2KeyPressed(evt);
            }
        });

        jLabel26.setText("Precio Unitario :");

        txfPrecioUnitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfPrecioUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfPrecioUnitarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfPrecioUnitarioKeyReleased(evt);
            }
        });

        txfTotalUnidades.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfTotalUnidades.setEnabled(false);
        txfTotalUnidades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfTotalUnidadesKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfDescuentoItem, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(txfCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txfTotalUnidades)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfNumeroLote)
                    .addComponent(jdcFechaVencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfDesc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfDesc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txfNumeroLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18)
                                .addComponent(txfDesc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txfDesc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(txfValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26)
                                .addComponent(txfPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txfTotalUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(txfDescuentoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(jdcFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5))
        );

        jButton1.setText("Cancelar");

        jButton2.setText("Guardar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chbxBonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxBonoActionPerformed
        calcularTotalProductos();
    }//GEN-LAST:event_chbxBonoActionPerformed

    private void txfNumeroLoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNumeroLoteKeyPressed
        Utilitarios.requestFocusEnter(txfDesc1, evt);
        Utilitarios.requestFocusEnter(txfDesc1, evt);
    }//GEN-LAST:event_txfNumeroLoteKeyPressed

    private void jdcFechaVencimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcFechaVencimientoKeyPressed
        
    }//GEN-LAST:event_jdcFechaVencimientoKeyPressed

    private void txfValorUnitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfValorUnitarioKeyPressed
        Utilitarios.requestFocusEnter(jdcFechaVencimiento, evt);
    }//GEN-LAST:event_txfValorUnitarioKeyPressed

    private void txfValorUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfValorUnitarioKeyReleased
        if (oDetalleCompra != null) {
            calcularPrecioConIgv();
            calcularPrecioCompraNeto();
        } else {
            JOptionPane.showMessageDialog(null, "Error al cargar datos", "Error", JOptionPane.ERROR_MESSAGE);
            txfValorUnitario.setText("");
        }
    }//GEN-LAST:event_txfValorUnitarioKeyReleased

    private void txfCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadKeyPressed
        Utilitarios.validaCaracterNumerico(evt, txfCantidad);
        Utilitarios.requestFocusEnter(txfNumeroLote, evt);
    }//GEN-LAST:event_txfCantidadKeyPressed

    private void txfCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadKeyReleased
        calcularTotalProductos();
    }//GEN-LAST:event_txfCantidadKeyReleased

    private void txfDesc1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfDesc1KeyPressed
        Utilitarios.requestFocusEnter(txfDesc2, evt);
    }//GEN-LAST:event_txfDesc1KeyPressed

    private void txfDesc2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfDesc2KeyPressed
        Utilitarios.requestFocusEnter(txfValorUnitario, evt);
    }//GEN-LAST:event_txfDesc2KeyPressed

    private void txfPrecioUnitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPrecioUnitarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPrecioUnitarioKeyPressed

    private void txfPrecioUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPrecioUnitarioKeyReleased
        if (oDetalleCompra != null) {
            if (!txfCantidad.getText().trim().equals("")) {
                calcularPrecioSinIgv();
                calcularPrecioCompraNeto();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cargue los datos del producto", "Error", JOptionPane.ERROR_MESSAGE);
            txfValorUnitario.setText("");
        }
    }//GEN-LAST:event_txfPrecioUnitarioKeyReleased

    private void txfTotalUnidadesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTotalUnidadesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTotalUnidadesKeyPressed


    // Constants declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chbxBono;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private com.toedter.calendar.JDateChooser jdcFechaVencimiento;
    private javax.swing.JTextField txfCantidad;
    private javax.swing.JTextField txfDesc1;
    private javax.swing.JTextField txfDesc2;
    private javax.swing.JTextField txfDescuentoItem;
    private javax.swing.JTextField txfNumeroLote;
    private javax.swing.JTextField txfPrecioUnitario;
    private javax.swing.JTextField txfProducto;
    private javax.swing.JTextField txfTotalUnidades;
    private javax.swing.JTextField txfUnidad;
    private javax.swing.JTextField txfValorUnitario;
    // End of variables declaration//GEN-END:variables

    void inicializarItem(DetalleCompra obj) {
        oDetalleCompra = new DetalleCompra();
        oDetalleCompraBl = new DetalleCompraBl();
        oDetalleCompra = oDetalleCompraBl.buscarXId(obj);
        if (oDetalleCompra != null) {
            txfProducto.setText(oDetalleCompra.getProducto().getNombre().trim());
            txfUnidad.setText(oDetalleCompra.getProducto().getPresentacion().getDenominacion().trim());
            chbxBono.setSelected(oDetalleCompra.getIsUnitario());
            txfCantidad.setText(oDetalleCompra.getCantidad().toString());
            txfTotalUnidades.setText(oDetalleCompra.getIsUnitario() ? txfCantidad.getText().trim() : (Integer.parseInt(txfCantidad.getText().trim()) * oDetalleCompra.getProducto().getFraccion()) + "");
            txfNumeroLote.setText(oDetalleCompra.getLote() != null ? oDetalleCompra.getLote().trim() : "");
            txfDesc1.setText(String.valueOf(oDetalleCompra.getPorcDesc1()));
            txfDesc2.setText(String.valueOf(oDetalleCompra.getPorcDesc2()));
            txfValorUnitario.setText(oDetalleCompra.getValorCompraUnitario().toString());
            //Calcular Precio Unitario
            if (!txfValorUnitario.getText().trim().equals("")) {
                calcularPrecioConIgv();
                calcularPrecioCompraNeto();
            } else {
                JOptionPane.showMessageDialog(null, "No existe valor unitario", "Error", JOptionPane.ERROR_MESSAGE);
            }
            //Fin calcular precio unitario
            jdcFechaVencimiento.setDate(oDetalleCompra.getFechaVencimiento() != null? oDetalleCompra.getFechaVencimiento():null);
        }

    }

    private void calcularTotalProductos() {
        if (!txfCantidad.getText().trim().equals("") && oDetalleCompra.getProducto() != null) {
            if (chbxBono.isSelected()) {
                calcularTotalUnidades();
            } else {
                calcularTotalUnidadesXFraccion();
            }
        } else {
            txfCantidad.setText("");
        }
    }
    
    private void calcularTotalUnidades() {
        int totalUnidades = Integer.parseInt(txfCantidad.getText().trim());
        txfTotalUnidades.setText(totalUnidades + "");
    }

    private void calcularTotalUnidadesXFraccion() {
        if (oDetalleCompra != null) {
            int totalUnidades = Integer.parseInt(txfCantidad.getText().trim()) * oDetalleCompra.getProducto().getFraccion();
            txfTotalUnidades.setText(totalUnidades + "");
        }

    }

    private void calcularPrecioConIgv() {
        BigDecimal valorUnitario = txfValorUnitario.getText().trim().equals("") ? new BigDecimal("0.00") : new BigDecimal(txfValorUnitario.getText().trim()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal precioUnitario = valorUnitario.add(valorUnitario.multiply(Constants.IGV)).setScale(2, RoundingMode.HALF_UP);
        txfPrecioUnitario.setText(precioUnitario.toString());
    }

    private void calcularPrecioSinIgv() {
        BigDecimal precioUnitario = txfPrecioUnitario.getText().trim().equals("") ? new BigDecimal("0.00") : new BigDecimal(txfPrecioUnitario.getText().trim()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal valorUnitario = precioUnitario.divide(Constants.CIEN_IGV, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);

        txfValorUnitario.setText(valorUnitario.toString());
    }

    private void calcularPrecioCompraNeto() {
        //Valor unitario sin IGV
        valorUnitario = new BigDecimal(txfValorUnitario.getText().trim()).setScale(2, RoundingMode.HALF_UP);
        cant = new BigDecimal(txfCantidad.getText().trim()).setScale(2, RoundingMode.HALF_UP);
        fra = new BigDecimal(oDetalleCompra.getProducto().getFraccion().toString()).setScale(2, RoundingMode.HALF_UP);
        valor_compra = valorUnitario.multiply(cant).setScale(2, RoundingMode.HALF_UP);
        //Variables para capturar los valores de los descuentos respectivos
        Double desc1;
        Double desc2;
        desc1 = txfDesc1.getText().trim().equals("") ? 0 : Double.valueOf(txfDesc1.getText().trim());
        desc2 = txfDesc2.getText().trim().equals("") ? 0 : Double.valueOf(txfDesc2.getText().trim());
        // desc_unico almacena el valor del descuento en porcentaje basado en la formula de descuento unico
        desc_unico = ((desc1 + desc2) - (desc1 * desc2) / 100);
        valor_desc_item = valor_compra.multiply((new BigDecimal(desc_unico)).divide(CIEN, 4, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
        valor_igv_item = (valor_compra.subtract(valor_desc_item)).multiply(IGV).setScale(2, RoundingMode.HALF_UP);
        valor_total_item = valor_compra.subtract(valor_desc_item).setScale(2, RoundingMode.HALF_UP);
        //Precio de compra por fraccion
        prec_compra_fraccion = valor_total_item.divide(cant, 2, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
        //Precio de compra unitario
        prec_compra_unidad = prec_compra_fraccion.divide(fra, 4, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
        //monto real pagado por item
        /*
        System.out.println("-----------------------------------------------------");
        System.out.println("Valor Unitario " + valorUnitario);
        System.out.println("Cantidad " + cant);
        System.out.println("Fraccion " + fra);
        System.out.println("Valor compra " + valor_compra);
        System.out.println("Valor desc item " + valor_desc_item);
        System.out.println("Valor igv item " + valor_igv_item);
        System.out.println("valor con descuento  " + valor_total_item);
        System.out.println("Precio de compra unitario  " + prec_compra_unidad);
         */
        
    }

}
