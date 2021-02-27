
package lissa.gui.farmacia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lissa.be.Almacen;
import lissa.be.AlmacenProducto;
import lissa.be.Producto;
import lissa.be.dto.AlmacenProductoDTO;
import lissa.bl.AlmacenProductoBl;
import lissa.bl.ProductoBl;
import lissa.controller.AlmacenCtrl;
import lissa.gui.JF_Principal;
import lissa.gui.JIF_BuscarHistoriaClinica;
import lissa.table.ModeloAlmacenProductoDTO;
import lissa.table.ModeloProductoMigrar;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Variables;

public class JIF_InventarioInicial extends javax.swing.JInternalFrame {
    private JF_Principal root;
    private AlmacenProducto oAlmacenProducto;
    private AlmacenProductoBl oAlmacenProductoBl;
    private ModeloProductoMigrar oModeloProductoMigrar;
    private ModeloAlmacenProductoDTO oModeloAlmacenProductoDTO;
    private ProductoBl oProductoBl;
    private Producto oProducto;
    private ArrayList<Producto> listProducto;
    private AlmacenCtrl oAlmacenCtrl;
    List<AlmacenProductoDTO> listItem;
    
    public JIF_InventarioInicial(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloProductoMigrar = new ModeloProductoMigrar();
        tblProducto.setModel(oModeloProductoMigrar);
        
        oModeloAlmacenProductoDTO = new ModeloAlmacenProductoDTO();
        tblDetalle.setModel(oModeloAlmacenProductoDTO);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfProducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txfFarmacia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txfPrecioVenta = new javax.swing.JTextField();
        cbxFarmacia = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txfPrecioCompra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txfLote = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jdcFechaVencimiento = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txfBusqProducto = new javax.swing.JTextField();
        pnlDetalle = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setTitle("Inventario Inicial");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Descripción :");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        txfProducto.setEnabled(false);

        jLabel6.setText("Stock :");

        txfFarmacia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setText("Precio Compra :");

        txfPrecioVenta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        cbxFarmacia.setEnabled(false);

        jLabel9.setText("Precio Venta :");

        txfPrecioCompra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel2.setText("Lote :");

        jLabel3.setText("Fecha Vencimiento :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxFarmacia, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txfFarmacia))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txfLote, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfPrecioVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(txfPrecioCompra))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxFarmacia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfFarmacia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txfPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txfPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdcFechaVencimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlDetalle.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblDetalle);

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Save16.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

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
                    .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(isDatosValidos()){
            addItems();            
        }else{
            Mensajes.msjValidarIngreso();
        }
    }//GEN-LAST:event_btnAddActionPerformed

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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        registrar();
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbxFarmacia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jdcFechaVencimiento;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JTable tblDetalle;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txfBusqProducto;
    private javax.swing.JTextField txfFarmacia;
    private javax.swing.JTextField txfLote;
    private javax.swing.JTextField txfPrecioCompra;
    private javax.swing.JTextField txfPrecioVenta;
    private javax.swing.JTextField txfProducto;
    // End of variables declaration//GEN-END:variables

    public void inicializar() {
        resetComponent();
        cargarCbxDestino();
        defaultFarmacia();        
        oModeloAlmacenProductoDTO.clear();
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
        Utilitarios.formateaColumna(2, tblDetalle, 80);
        Utilitarios.formateaColumna(3, tblDetalle, 80);
        Utilitarios.formateaColumna(4, tblDetalle, 80);
    }

    private void filtrarProducto(String ref) {
        oProductoBl = new ProductoBl();
        listProducto = oProductoBl.listRef(ref, Variables.BUSQ_X_PRODUCTO);
        oModeloProductoMigrar.clear();
        if(!listProducto.isEmpty()){
            oModeloProductoMigrar.addAll(listProducto);
        }
    }

    private boolean isDatosValidos() {
        return (oProducto != null &&
                !txfProducto.getText().trim().equals("") &&
                !txfFarmacia.getText().trim().equals("") &&
                !txfPrecioVenta.getText().trim().equals(""));
    }
    
    private void cargarCbxDestino() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.rellenaAlmacen(cbxFarmacia);
    }
    
    private void defaultFarmacia() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.defaultSelectAlmacen("FARMACIA", cbxFarmacia);
    }

    private void resetComponent() {
        listarProductos();
        personalizaVistaTabla();
        txfProducto.setText("");
        txfFarmacia.setText("");
        txfPrecioVenta.setText("");
        txfPrecioCompra.setText("");
        txfBusqProducto.setText("");
        txfLote.setText("");
        jdcFechaVencimiento.setDate(null);
    }

    private void addItems() {
        List<AlmacenProductoDTO> list = new ArrayList();                
        
        AlmacenProductoDTO dto = new AlmacenProductoDTO();
        dto.setProducto(oProducto);
        dto.setAlmacen((Almacen) cbxFarmacia.getSelectedItem());
        dto.setStockActual(txfFarmacia.getText().trim().equals("")?BigDecimal.ZERO:new BigDecimal(txfFarmacia.getText().trim()));
        dto.setFechaRegistro(new Date());
        dto.setPrecioCompraUnit(txfPrecioCompra.getText().trim().equals("")?BigDecimal.ZERO:new BigDecimal(txfPrecioCompra.getText().trim()));
        dto.setPrecioVentaUnit(txfPrecioVenta.getText().trim().equals("")?BigDecimal.ZERO:new BigDecimal(txfPrecioVenta.getText().trim()));
        dto.setLote(txfLote.getText().trim().equals("")?"":txfLote.getText().trim());
        dto.setFechaVencimiento(jdcFechaVencimiento.getDate());
        oModeloAlmacenProductoDTO.add(dto);
        
        resetComponent();

    }

    private void registrar() {
        int res = -1;
        if(oModeloAlmacenProductoDTO.size()>0){
            oAlmacenProductoBl = new AlmacenProductoBl();
            res=oAlmacenProductoBl.registrarInventarioInicial(oModeloAlmacenProductoDTO, root.getUser());
            if(Variables.SUCCESS==res){
                Mensajes.msjRegCorrecta();
                oModeloAlmacenProductoDTO.clear();
                resetComponent();
            }
        }else{
            Mensajes.msjNoExisteItemsTabla(); 
        } 
    }
    
    
}
