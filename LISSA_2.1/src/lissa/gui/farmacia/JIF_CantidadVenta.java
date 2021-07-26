package lissa.gui.farmacia;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;
import lissa.be.AlmacenProducto;
import lissa.be.DetalleVenta;
import lissa.be.PrecioProducto;
import lissa.bl.PrecioProductoBl;
import lissa.gui.JF_Principal;
import lissa.util.Utilitarios;
import lissa.util.Constants;

/**
 *
 * @author JSULCAG
 */
public class JIF_CantidadVenta extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private AlmacenProducto oAlmacenProducto;
    private DetalleVenta oDetalleVenta;
    private PrecioProductoBl oPrecioProductoBl;
    private PrecioProducto oPrecioProducto;

    private int invocador;
    public static final int JIF_VENTAS = 1;
    public static final int JIF_ALMACEN = 2;
    public static final int JIF_NOTASALIDA = 3;

    public JIF_CantidadVenta(JF_Principal root) {
        initComponents();
        this.root = root;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txfCantidad = new javax.swing.JTextField();
        txfPrecioSugerido = new javax.swing.JTextField();
        txfPrecioMin = new javax.swing.JTextField();
        txfPrecioMax = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cantidad");

        jPanel2.setLayout(new java.awt.GridLayout(2, 4));

        jLabel1.setText("Cantidad");
        jPanel2.add(jLabel1);

        jLabel2.setText("Precio Sugerido");
        jPanel2.add(jLabel2);

        jLabel3.setText("Precio Min");
        jPanel2.add(jLabel3);

        jLabel4.setText("Precio Max");
        jPanel2.add(jLabel4);

        txfCantidad.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txfCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfCantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCantidadKeyReleased(evt);
            }
        });
        jPanel2.add(txfCantidad);

        txfPrecioSugerido.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txfPrecioSugerido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfPrecioSugerido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfPrecioSugeridoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfPrecioSugeridoKeyReleased(evt);
            }
        });
        jPanel2.add(txfPrecioSugerido);

        txfPrecioMin.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txfPrecioMin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfPrecioMin.setEnabled(false);
        jPanel2.add(txfPrecioMin);

        txfPrecioMax.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txfPrecioMax.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfPrecioMax.setEnabled(false);
        jPanel2.add(txfPrecioMax);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (!txfCantidad.getText().trim().equals("")) {
            cargarDatos();
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txfCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txfPrecioSugerido.requestFocus();
        }
    }//GEN-LAST:event_txfCantidadKeyPressed

    private void txfPrecioSugeridoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPrecioSugeridoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAceptar.doClick();
        }
    }//GEN-LAST:event_txfPrecioSugeridoKeyPressed

    private void txfCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadKeyReleased
        Utilitarios.validaCaracterNumerico(evt, txfCantidad);
    }//GEN-LAST:event_txfCantidadKeyReleased

    private void txfPrecioSugeridoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPrecioSugeridoKeyReleased
        Utilitarios.validaCaracterNumericoMoneda(evt, txfPrecioSugerido);
    }//GEN-LAST:event_txfPrecioSugeridoKeyReleased


    // Constants declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txfCantidad;
    private javax.swing.JTextField txfPrecioMax;
    private javax.swing.JTextField txfPrecioMin;
    private javax.swing.JTextField txfPrecioSugerido;
    // End of variables declaration//GEN-END:variables

    void enviarDatos(AlmacenProducto obj, int invocador) {
        resetComponent();
        oAlmacenProducto = obj;
        setInvocador(invocador);
        oPrecioProductoBl = new PrecioProductoBl();
        oPrecioProducto = new PrecioProducto();
        oPrecioProducto = oPrecioProductoBl.buscarxIdAlmacenProducto(oAlmacenProducto.getIdalmacenproducto());
        if (oPrecioProducto != null) {
            txfPrecioSugerido.setText(oPrecioProducto.getPvSugerido().toString());
            txfPrecioMin.setText(oPrecioProducto.getPvMin().toString());
            txfPrecioMax.setText(oPrecioProducto.getPvMax().toString());
        }

    }

    public int getInvocador() {
        return invocador;
    }

    public void setInvocador(int invocador) {
        this.invocador = invocador;
    }

    private void cargarDatos() {
        oDetalleVenta = new DetalleVenta();
        oDetalleVenta.setProducto(oAlmacenProducto.getProducto());
        oDetalleVenta.setPrecioVenta(txfPrecioSugerido.getText().trim().equals("") ? BigDecimal.ZERO : new BigDecimal(txfPrecioSugerido.getText().trim()));
        oDetalleVenta.setLote(oAlmacenProducto.getLote() == null?"":oAlmacenProducto.getLote());
        oDetalleVenta.setIdAlmacenproducto(oAlmacenProducto.getIdalmacenproducto());
        oDetalleVenta.setPvMin(new BigDecimal(txfPrecioMin.getText().trim()));
        oDetalleVenta.setPvMax(new BigDecimal(txfPrecioMax.getText().trim()));
        oDetalleVenta.setPrecioVenta(new BigDecimal(txfPrecioSugerido.getText().trim()).setScale(6, RoundingMode.HALF_UP));
        oDetalleVenta.setUnidadMedida("NIU");

        if ((new BigDecimal(txfCantidad.getText().trim())).compareTo(oAlmacenProducto.getStockActual()) == 1) {
            JOptionPane.showMessageDialog(null, "Stock no disponible", "Atención", JOptionPane.INFORMATION_MESSAGE);
            txfCantidad.setText("");
            txfCantidad.requestFocus();
        } else {
            oDetalleVenta.setCantidadVenta(new BigDecimal(txfCantidad.getText().trim()).setScale(0, RoundingMode.HALF_UP));
            oDetalleVenta.setPrecioUnitarioItem(oDetalleVenta.getPrecioVenta());
            oDetalleVenta.setValorUnitarioItem((oDetalleVenta.getPrecioVenta().divide(Constants.CIEN_IGV, 4, RoundingMode.HALF_UP)).setScale(6, RoundingMode.HALF_UP));                        
            oDetalleVenta.setMontoIgvItem((oDetalleVenta.getValorUnitarioItem().multiply(oDetalleVenta.getCantidadVenta()).multiply(Constants.IGV)).setScale(6, RoundingMode.HALF_UP));
            oDetalleVenta.setSubTotal((oDetalleVenta.getValorUnitarioItem().multiply(oDetalleVenta.getCantidadVenta())).setScale(6, RoundingMode.HALF_UP));            
            oDetalleVenta.setMontoTotal((oDetalleVenta.getPrecioUnitarioItem().multiply(oDetalleVenta.getCantidadVenta())).setScale(6, RoundingMode.HALF_UP));
            
            switch (getInvocador()) {
                case JIF_VENTAS:
                    root.jifRegVentas.enviaDatosProducto(oDetalleVenta);
                    break;
                case JIF_ALMACEN:
                    root.jifAlmacen.enviaDatosProducto(oDetalleVenta);
                    break;
                case JIF_NOTASALIDA:
                    root.jifNotaSalidafar.enviaDatosProducto(oDetalleVenta);
                    break;
            }
            resetComponent();
            this.doDefaultCloseAction();

        }
    }

    private void resetComponent() {
        txfCantidad.setText("");
        txfPrecioMin.setText("");
        txfPrecioMax.setText("");
        txfPrecioSugerido.setText("");
        buttonGroup1.clearSelection();
        txfCantidad.requestFocus();
    }

}
