
package lissa.gui.farmacia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import lissa.be.Almacen;
import lissa.be.AlmacenProducto;
import lissa.be.Producto;
import lissa.bl.AlmacenProductoBl;
import lissa.bl.ProductoBl;
import lissa.controller.AlmacenCtrl;
import lissa.gui.JF_Principal;
import lissa.gui.JIF_BuscarHistoriaClinica;
import lissa.table.ModeloProductoMigrar;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_Migrar extends javax.swing.JInternalFrame {
    private JF_Principal root;
    private AlmacenProducto oAlmacenProducto;
    private AlmacenProductoBl oAlmacenProductoBl;
    private ModeloProductoMigrar oModeloProductoMigrar;
    private ProductoBl oProductoBl;
    private Producto oProducto;
    private ArrayList<Producto> listProducto;
    private AlmacenCtrl oAlmacenCtrl;
    
    public JIF_Migrar(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloProductoMigrar = new ModeloProductoMigrar();
        tblProducto.setModel(oModeloProductoMigrar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txfAlmacen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txfFarmacia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txfPrecio = new javax.swing.JTextField();
        cbxAlmacen = new javax.swing.JComboBox();
        cbxFarmacia = new javax.swing.JComboBox();
        btnGuardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txfBusqProducto = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Migración de Productos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Descripción :");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        txfProducto.setEnabled(false);

        jLabel2.setText("Stock :");

        txfAlmacen.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel6.setText("Stock :");

        txfFarmacia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setText("Precio :");

        txfPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        cbxAlmacen.setEnabled(false);

        cbxFarmacia.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfProducto))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxAlmacen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxFarmacia, 0, 157, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfFarmacia, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(txfAlmacen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txfFarmacia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cbxFarmacia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
        );

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Save16.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Busq"));

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblProductoMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducto);

        jLabel10.setText("Descripción :");

        txfBusqProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBusqProductoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfBusqProducto))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txfBusqProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(isDatosValidos()){
            registrarAlmacen();
            registrarFarmacia();
            resetComponent();
        }else{
            Mensajes.msjValidarIngreso();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txfBusqProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBusqProductoKeyReleased
        if(!txfBusqProducto.getText().trim().toUpperCase().equals("")){
            filtrarProducto(txfBusqProducto.getText().trim().toUpperCase());
            personalizaVistaTabla();
        }else{
            inicializar();
        }
    }//GEN-LAST:event_txfBusqProductoKeyReleased

    private void tblProductoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseReleased
        if(tblProducto.getRowSelectionAllowed() && tblProducto.getSelectedRow() != -1){
            oProducto = oModeloProductoMigrar.get(tblProducto.getSelectedRow());
            txfProducto.setText(oProducto.getNombre().trim());
        }
    }//GEN-LAST:event_tblProductoMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbxAlmacen;
    private javax.swing.JComboBox cbxFarmacia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txfAlmacen;
    private javax.swing.JTextField txfBusqProducto;
    private javax.swing.JTextField txfFarmacia;
    private javax.swing.JTextField txfPrecio;
    private javax.swing.JTextField txfProducto;
    // End of variables declaration//GEN-END:variables

    public void inicializar() {
        listarProductos();
        cargarCbxOrigen();
        cargarCbxDestino();
        defaultAlmacen();
        defaultFarmacia();
        personalizaVistaTabla();
    }

    private void listarProductos() {
        oProductoBl = new ProductoBl();
        listProducto = oProductoBl.list("");
        if(!listProducto.isEmpty()){
            oModeloProductoMigrar.addAll(listProducto);
        }
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblProducto, 80);
    }

    private void filtrarProducto(String ref) {
        oProductoBl = new ProductoBl();
        listProducto = oProductoBl.listRef(ref);
        if(!listProducto.isEmpty()){
            oModeloProductoMigrar.addAll(listProducto);
        }
    }

    private boolean isDatosValidos() {
        return (oProducto != null &&
                !txfProducto.getText().trim().equals("") &&
                !txfAlmacen.getText().trim().equals("") &&
                !txfFarmacia.getText().trim().equals("") &&
                !txfPrecio.getText().trim().equals(""));
    }
    
    private void registrarAlmacen() {
        oAlmacenProducto = new AlmacenProducto();
        oAlmacenProductoBl = new AlmacenProductoBl();
        oAlmacenProducto.setProducto(oProducto);
        oAlmacenProducto.setAlmacen((Almacen) cbxAlmacen.getSelectedItem());
        BigDecimal cant = txfAlmacen.getText().trim().equals("")?BigDecimal.ZERO:new BigDecimal(txfAlmacen.getText().trim());
        oAlmacenProducto.setStockActual(cant);
        oAlmacenProducto.setFechaRegistro(new Date());
        oAlmacenProducto.setEstado(Boolean.TRUE);
        oAlmacenProducto = oAlmacenProductoBl.registrar(oAlmacenProducto);
        //Registrar su precio
    }

    private void registrarFarmacia() {
        oAlmacenProducto = new AlmacenProducto();
        oAlmacenProductoBl = new AlmacenProductoBl();
        oAlmacenProducto.setProducto(oProducto);
        oAlmacenProducto.setAlmacen((Almacen) cbxFarmacia.getSelectedItem());
        BigDecimal cant = txfFarmacia.getText().trim().equals("")?BigDecimal.ZERO:new BigDecimal(txfFarmacia.getText().trim());
        oAlmacenProducto.setStockActual(cant);
        oAlmacenProducto.setFechaRegistro(new Date());
        oAlmacenProducto.setEstado(Boolean.TRUE);
        oAlmacenProducto = oAlmacenProductoBl.registrar(oAlmacenProducto);
        //Registrar su precio
    }    
    
    private void cargarCbxOrigen() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.rellenaAlmacen(cbxAlmacen);
    }

    private void cargarCbxDestino() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.rellenaAlmacen(cbxFarmacia);
    }
    
    private void defaultAlmacen() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.defaultSelectAlmacen("ALMACEN", cbxAlmacen);
    }

    private void defaultFarmacia() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.defaultSelectAlmacen("FARMACIA", cbxFarmacia);
    }

    private void resetComponent() {
        listarProductos();
        personalizaVistaTabla();
        txfProducto.setText("");
        txfAlmacen.setText("");
        txfFarmacia.setText("");
        txfPrecio.setText("");
        txfBusqProducto.setText("");
    }
}
