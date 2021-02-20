package lissa.gui.farmacia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.Almacen;
import lissa.be.Kardex;
import lissa.be.Producto;
import lissa.bl.KardexBl;
import lissa.bl.ProductoBl;
import lissa.controller.AlmacenCtrl;
import lissa.gui.JF_Principal;
import lissa.table.ModeloKardexAlmacen;
import lissa.table.ModeloProducto;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Variables;

public class JIF_KardexAlmacen extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloKardexAlmacen oModeloKardexAlmacen;
    private ProductoBl oProductoBl;
    private ArrayList<Producto> listProducto;
    private AlmacenCtrl oAlmacenCtrl;
    private ModeloProducto oModeloProducto;
    private Producto oProducto;
    private Kardex oKardex;
    private KardexBl oKardexBl;
    private List<Kardex> listKardex;

    public JIF_KardexAlmacen(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloKardexAlmacen = new ModeloKardexAlmacen();
        tblKardex.setModel(oModeloKardexAlmacen);
        oModeloProducto = new ModeloProducto();
        tblProductos.setModel(oModeloProducto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxAlmacen = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKardex = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txfProducto = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Kardex");

        jLabel1.setText("Producto : ");

        jLabel4.setText("Almacen :");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblProductosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kardex", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tblKardex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblKardex);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INVENTARIO");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SALIDAS");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ENTRADAS");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txfProducto.setBackground(new java.awt.Color(255, 255, 204));
        txfProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfProductoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxAlmacen, 0, 306, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(cbxAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void txfProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfProductoKeyReleased
        buscarProducto();
    }//GEN-LAST:event_txfProductoKeyReleased

    private void tblProductosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseReleased
        cargarKardex();
        personalizaTablas();
    }//GEN-LAST:event_tblProductosMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxAlmacen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblKardex;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txfProducto;
    // End of variables declaration//GEN-END:variables

    public void inicializar() {
        //cargarCbxProducto();
        cargarCbxAlmacen();
        defaultAlmacen();
        txfProducto.setText("");
        oModeloKardexAlmacen.clear();
        oModeloProducto.clear();
        personalizaTablas();
    }
    /*
     private void cargarCbxProducto() {
     oProductoBl = new ProductoBl();
     listProducto= oProductoBl.listar("");
     cbxProducto.removeAllItems();
     cbxProducto.addItem("<Seleccione>");
     if(!listProducto.isEmpty()){
     for (Producto oProducto : listProducto) {
     oProducto.setOp(Producto.DATO);
     cbxProducto.addItem(oProducto);
     }
     }
     }
     */
    /*
     private boolean isDatosValidos() {
     return (cbxProducto.getSelectedIndex() > 0);
     }
     */

    private void cargarCbxAlmacen() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.rellenaAlmacen(cbxAlmacen);
    }

    private void defaultAlmacen() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.defaultSelectAlmacen("ALMACEN", cbxAlmacen);
    }

    private void buscarProducto() {
        if (isDatosValidos()) {
            oProductoBl = new ProductoBl();
            listProducto = oProductoBl.listRef(txfProducto.getText().trim().toUpperCase(), Variables.BUSQ_X_PRODUCTO);
            oModeloProducto.clear();
            if(!listProducto.isEmpty()){
                oModeloProducto.addAll(listProducto);
            }
        } else {
            inicializar();
        }
        oModeloKardexAlmacen.clear();
        personalizaTablas();
        
    }

    private boolean isDatosValidos() {
        return (cbxAlmacen.getSelectedIndex() > 0
                && !txfProducto.getText().trim().equals(""));
    }

    private void personalizaTablas() {
        Utilitarios.formateaColumna(0, tblProductos, 50);
        Utilitarios.formateaColumna(2, tblProductos, 80);
        Utilitarios.formateaColumna(3, tblProductos, 120);
        Utilitarios.formateaColumna(4, tblProductos, 120);
        Utilitarios.formateaColumna(5, tblProductos, 120);
        Utilitarios.formateaColumna(8, tblProductos, 50);
        Utilitarios.alinearDatosColumnaTablaDerecha(8, tblProductos);
        
        Utilitarios.formateaColumna(0, tblKardex, 60);
        Utilitarios.formateaColumna(2, tblKardex, 60);
        Utilitarios.formateaColumna(3, tblKardex, 60);
        Utilitarios.formateaColumna(4, tblKardex, 60);
        Utilitarios.formateaColumna(5, tblKardex, 60);
        Utilitarios.formateaColumna(6, tblKardex, 60);
        Utilitarios.formateaColumna(7, tblKardex, 60);
        Utilitarios.formateaColumna(8, tblKardex, 60);
        Utilitarios.formateaColumna(9, tblKardex, 60);
        Utilitarios.formateaColumna(10, tblKardex, 60);
        
        Utilitarios.alinearDatosColumnaTablaDerecha(2, tblKardex);
        Utilitarios.alinearDatosColumnaTablaDerecha(3, tblKardex);
        Utilitarios.alinearDatosColumnaTablaDerecha(4, tblKardex);
        Utilitarios.alinearDatosColumnaTablaDerecha(5, tblKardex);
        Utilitarios.alinearDatosColumnaTablaDerecha(6, tblKardex);
        Utilitarios.alinearDatosColumnaTablaDerecha(7, tblKardex);
        Utilitarios.alinearDatosColumnaTablaDerecha(8, tblKardex);
        Utilitarios.alinearDatosColumnaTablaDerecha(9, tblKardex);
        Utilitarios.alinearDatosColumnaTablaDerecha(10, tblKardex);
    }

    private void cargarKardex() {        
        oModeloKardexAlmacen.clear();
        oKardexBl = new KardexBl();
        listKardex = new LinkedList<>();
        if(tblProductos.getSelectedRow() != -1 && tblProductos.getRowSelectionAllowed()){
            oProducto = oModeloProducto.get(tblProductos.getSelectedRow());
            if(oProducto != null){
                listKardex = oKardexBl.listarxProducto(oProducto.getIdproducto(), ((Almacen)cbxAlmacen.getSelectedItem()).getIdalmacen());
                System.out.println("List kardex ... "+listKardex.size());
                System.out.println("procuto ... "+oProducto.getIdproducto());
                if(!listKardex.isEmpty()){
                    for (Kardex obj : listKardex) {
                        oModeloKardexAlmacen.add(obj);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No existen movimientos par el producto con ID = "+oProducto.getIdproducto(), "Atención", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
