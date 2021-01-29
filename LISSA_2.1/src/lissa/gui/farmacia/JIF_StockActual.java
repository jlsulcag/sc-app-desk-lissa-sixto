
package lissa.gui.farmacia;

import java.util.ArrayList;
import lissa.be.AlmacenProducto;
import lissa.bl.AlmacenProductoBl;
import lissa.controller.AlmacenCtrl;
import lissa.gui.JF_Principal;
import lissa.table.ModeloStockProducto;
import lissa.util.Utilitarios;

/**
 *
 * @author JSULCAG
 */
public class JIF_StockActual extends javax.swing.JInternalFrame {
    private JF_Principal root;
    private ModeloStockProducto oModeloStockProducto;
    private AlmacenProductoBl oAlmacenProductoBl;
    private ArrayList<AlmacenProducto> listAlmacenProducto;
    private AlmacenCtrl oAlmacenCtrl;
    
    public JIF_StockActual(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloStockProducto = new ModeloStockProducto();
        tblStock.setModel(oModeloStockProducto);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfBusqProductos = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbxAlmacen = new javax.swing.JComboBox();

        setClosable(true);
        setTitle("Stock de productos");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel1.setText("Descripción :");

        txfBusqProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBusqProductosKeyReleased(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblStock);

        jLabel2.setText("Ubicación :");

        cbxAlmacen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAlmacenItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfBusqProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfBusqProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel2)
                    .addComponent(cbxAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        inicializar();
    }//GEN-LAST:event_formInternalFrameClosing

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        inicializar();
    }//GEN-LAST:event_formInternalFrameOpened

    private void cbxAlmacenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAlmacenItemStateChanged
        if(cbxAlmacen.getSelectedIndex() > 0){
            listarStockAlmacen();
        }else{
            oModeloStockProducto.clear();
        }
        personalizarTabla();
    }//GEN-LAST:event_cbxAlmacenItemStateChanged

    private void txfBusqProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBusqProductosKeyReleased
        if(!txfBusqProductos.getText().toUpperCase().trim().equals("")){
            String ref = txfBusqProductos.getText().toUpperCase().trim();
            buscar(cbxAlmacen.getSelectedItem().toString(), ref);
        }else{
            oModeloStockProducto.clear();
            listarStockAlmacen();
        }
        personalizarTabla();
    }//GEN-LAST:event_txfBusqProductosKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox cbxAlmacen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStock;
    private javax.swing.JTextField txfBusqProductos;
    // End of variables declaration//GEN-END:variables

    public void inicializar() {
        llenarCbxAlmacen();
        listarStockAlmacen();
        personalizarTabla();
    }

    private void listarStockAlmacen() {
        oModeloStockProducto.clear();
        oAlmacenProductoBl = new AlmacenProductoBl();
        listAlmacenProducto = oAlmacenProductoBl.listXAlmacen(cbxAlmacen.getSelectedItem().toString());
        if(!listAlmacenProducto.isEmpty()){
            oModeloStockProducto.addAll(listAlmacenProducto);
        }
    }

    private void llenarCbxAlmacen() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.rellenaAlmacen(cbxAlmacen);
        oAlmacenCtrl.defaultSelectAlmacen("ALMACEN", cbxAlmacen);
    }

    private void personalizarTabla() {
        Utilitarios.formateaColumna(0, tblStock, 50);
        Utilitarios.formateaColumna(2, tblStock, 130);
        Utilitarios.formateaColumna(3, tblStock, 130);
        Utilitarios.formateaColumna(4, tblStock, 100);
        Utilitarios.alinearDatosColumnaTablaCentro(4, tblStock);
    }
    private void buscar(String almacen, String ref) {
        oAlmacenProductoBl = new AlmacenProductoBl();
        listAlmacenProducto = oAlmacenProductoBl.listStockxAlmacenProducto(almacen, ref);
        if(!listAlmacenProducto.isEmpty()){
            oModeloStockProducto.addAll(listAlmacenProducto);
        }
    }
}
