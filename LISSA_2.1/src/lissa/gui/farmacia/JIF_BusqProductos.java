package lissa.gui.farmacia;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import lissa.be.AlmacenProducto;
import lissa.be.DetalleVenta;
import lissa.bl.AlmacenProductoBl;
import lissa.bl.DetalleVentaBl;
import lissa.gui.JF_Principal;
import lissa.table.ModeloBusqProducto;
import lissa.util.Utilitarios;
import lissa.util.Variables;

public class JIF_BusqProductos extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloBusqProducto oModeloBusqProducto;
    private AlmacenProducto oAlmacenProducto;
    private AlmacenProductoBl oAlmacenProductoBl;
    private ArrayList<AlmacenProducto> listProducto;
    private int invocador;
    public static final int JIF_VENTAS = 1;
    public static final int JIF_ALMACEN = 2;
    public static final int JIF_NOTASALIDA = 3;
    private DetalleVenta oDetalleVenta;
    private DetalleVentaBl oDetalleVentaBl;
    public static final String ALMACEN = "ALMACEN";
    public static final String FARMACIA = "FARMACIA";
    private int opBusqueda = 0;

    public JIF_BusqProductos(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloBusqProducto = new ModeloBusqProducto();
        tblProductos.setModel(oModeloBusqProducto);
        personalizaTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txfBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txfPrincipioActivo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txfAccionTerapeutica = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Busqueda de Productos");
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txfBusqueda.setBackground(new java.awt.Color(255, 255, 204));
        txfBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBusquedaKeyReleased(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Refresh.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Producto :");

        jLabel2.setText("Principio activo :");

        txfPrincipioActivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfPrincipioActivoKeyReleased(evt);
            }
        });

        jLabel3.setText("Accion terapéutica :");

        txfAccionTerapeutica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfAccionTerapeuticaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfPrincipioActivo, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
                    .addComponent(txfAccionTerapeutica)
                    .addComponent(txfBusqueda, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfPrincipioActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfAccionTerapeutica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblProductosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBusquedaKeyReleased
        setOpBusqueda(Variables.BUSQ_X_PRODUCTO);
        listProductosGeneric(evt);
    }//GEN-LAST:event_txfBusquedaKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        inicializar();
        personalizaTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        personalizaTabla();
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        personalizaTabla();
    }//GEN-LAST:event_formInternalFrameClosing

    private void tblProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            oAlmacenProducto = oModeloBusqProducto.get(tblProductos.getSelectedRow());
            root.insertarInternalFrames(root.jifCantidadVenta);
            root.jifCantidadVenta.enviarDatos(oAlmacenProducto, getInvocador());
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            txfBusqueda.setText("");
            txfBusqueda.requestFocus();
        }
    }//GEN-LAST:event_tblProductosKeyPressed

    private void txfPrincipioActivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPrincipioActivoKeyReleased
        setOpBusqueda(Variables.BUSQ_X_PRINCIPIO_ACTIVO);
        listProductosGeneric(evt);
    }//GEN-LAST:event_txfPrincipioActivoKeyReleased

    private void txfAccionTerapeuticaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfAccionTerapeuticaKeyReleased
        setOpBusqueda(Variables.BUSQ_X_ACCION_FARMACOLOGICA);
        listProductosGeneric(evt);
    }//GEN-LAST:event_txfAccionTerapeuticaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txfAccionTerapeutica;
    private javax.swing.JTextField txfBusqueda;
    private javax.swing.JTextField txfPrincipioActivo;
    // End of variables declaration//GEN-END:variables

    void inicializar() {
        resetComponent();
        switch (getInvocador()) {
            case JIF_ALMACEN:
                listarProductosAlmacen();
                break;
            case JIF_VENTAS:
                listarProductosFarmacia();
                break;
            case JIF_NOTASALIDA:
                listarProductosFarmacia();
                break;
        }
        personalizaTabla();
    }

    public int getInvocador() {
        return invocador;
    }

    public void setInvocador(int invocador) {
        this.invocador = invocador;
    }

    private void personalizaTabla() {
        Utilitarios.formateaColumna(0, tblProductos, 50);
        Utilitarios.formateaColumna(2, tblProductos, 150);
        Utilitarios.formateaColumna(3, tblProductos, 50);
        Utilitarios.formateaColumna(4, tblProductos, 50);
        Utilitarios.formateaColumna(5, tblProductos, 70);
        Utilitarios.formateaColumna(6, tblProductos, 70);
        Utilitarios.alinearDatosColumnaTablaCentro(4, tblProductos);
        Utilitarios.alinearDatosColumnaTablaDerecha(6, tblProductos);
    }

    private void resetComponent() {
        txfBusqueda.setText("");
        txfPrincipioActivo.setText("");
        txfAccionTerapeutica.setText("");
        oModeloBusqProducto.clear();
    }

    private void listarProductosAlmacen() {
        oAlmacenProductoBl = new AlmacenProductoBl();
        listProducto = oAlmacenProductoBl.listXAlmacen(ALMACEN);
        if (!listProducto.isEmpty()) {
            oModeloBusqProducto.addAll(listProducto);
        }
    }

    private void listarProductosFarmacia() {
        oAlmacenProductoBl = new AlmacenProductoBl();
        listProducto = oAlmacenProductoBl.listXAlmacen(FARMACIA);
        if (!listProducto.isEmpty()) {
            oModeloBusqProducto.addAll(listProducto);
        }
    }

    private void listProductosGeneric(KeyEvent evt) {
        switch (getOpBusqueda()) {
            case Variables.BUSQ_X_PRODUCTO:
                if (!txfBusqueda.getText().toUpperCase().trim().equals("")) {
                    String ref = txfBusqueda.getText().toUpperCase().trim();
                    listProductosRef(ref, Variables.BUSQ_X_PRODUCTO);
                } else {
                    oModeloBusqProducto.clear();
                    inicializar();
                }
                break;
            case Variables.BUSQ_X_PRINCIPIO_ACTIVO:
                if (!txfPrincipioActivo.getText().toUpperCase().trim().equals("")) {
                    String ref = txfPrincipioActivo.getText().toUpperCase().trim();
                    listProductosRef(ref, Variables.BUSQ_X_PRINCIPIO_ACTIVO);
                } else {
                    oModeloBusqProducto.clear();
                    inicializar();
                }
                break;
            case Variables.BUSQ_X_ACCION_FARMACOLOGICA:
                if (!txfAccionTerapeutica.getText().toUpperCase().trim().equals("")) {
                    String ref = txfAccionTerapeutica.getText().toUpperCase().trim();
                    listProductosRef(ref, Variables.BUSQ_X_ACCION_FARMACOLOGICA);
                } else {
                    oModeloBusqProducto.clear();
                    inicializar();
                }
                break;
            default:
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            tblProductos.requestFocus();
        }
        personalizaTabla();
    }

    private void listProductosRef(String ref, int op) {
        oAlmacenProductoBl = new AlmacenProductoBl();
        oModeloBusqProducto.clear();
        switch (getInvocador()) {
            case JIF_ALMACEN:
                listProducto = oAlmacenProductoBl.listProductosRef(ref, ALMACEN, op);
                break;
            case JIF_VENTAS:
                listProducto = oAlmacenProductoBl.listProductosRef(ref, FARMACIA, op);
                break;
            case JIF_NOTASALIDA:
                listProducto = oAlmacenProductoBl.listProductosRef(ref, FARMACIA, op);
                break;
            default:
                break;
        }
        if (!listProducto.isEmpty()) {
            oModeloBusqProducto.addAll(listProducto);
        }

    }

    public int getOpBusqueda() {
        return opBusqueda;
    }

    public void setOpBusqueda(int opBusqueda) {
        this.opBusqueda = opBusqueda;
    }
}
