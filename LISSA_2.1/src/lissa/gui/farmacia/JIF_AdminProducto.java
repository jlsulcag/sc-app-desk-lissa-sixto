package lissa.gui.farmacia;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import lissa.be.Producto;
import lissa.bl.ProductoBl;
import lissa.gui.JF_Principal;
import lissa.table.ModeloProducto;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Variables;

public class JIF_AdminProducto extends javax.swing.JInternalFrame {

    public int getOpBusqueda() {
        return opBusqueda;
    }

    public void setOpBusqueda(int opBusqueda) {
        this.opBusqueda = opBusqueda;
    }

    private JF_Principal root;
    private int operacion = -1;
    private static final int NUEVO = 1;
    private static final int EDITAR = 2;
    private ProductoBl oProductoBl;
    private ArrayList<Producto> listProductos;
    private ModeloProducto oModeloProducto;
    private Producto oProducto;
    private int invocador;
    public static final int JIF_COMPRAS = 1;
    public static final int JIF_VENTAS = 2;
    private int opBusqueda;

    public JIF_AdminProducto(JF_Principal root) {
        this.root = root;
        initComponents();
        oModeloProducto = new ModeloProducto();
        tblProducto.setModel(oModeloProducto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txfPrincipioActivo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txfAccionTerapeutica = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Administrar producto");
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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Pencil-icon.png"))); // NOI18N
        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProductoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblProductoMouseReleased(evt);
            }
        });
        tblProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblProductoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducto);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11))); // NOI18N

        jLabel1.setText("Producto :");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfPrincipioActivo)
                    .addComponent(txfAccionTerapeutica)
                    .addComponent(txfBusqueda, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(txfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txfPrincipioActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(txfAccionTerapeutica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        operacion = NUEVO;
        insertarJifNuevoProducto();
        root.jifNuevoProducto.inicializar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tblProducto.getRowSelectionAllowed() && tblProducto.getSelectedRow() != -1) {
            operacion = EDITAR;
            insertarJifNuevoProducto();
            //Enviar datos del producto capturado a la interfaz nuevo producto
            root.jifNuevoProducto.inicializar();
            enviarDatos(oProducto);
        } else {
            Mensajes.tblSelected();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        inicializarJif();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txfBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBusquedaKeyReleased
        setOpBusqueda(Variables.BUSQ_X_PRODUCTO);
        buscarGeneric(evt);
    }//GEN-LAST:event_txfBusquedaKeyReleased

    private void tblProductoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMouseReleased
        if (tblProducto.getRowSelectionAllowed() && tblProducto.getSelectedRow() != -1) {
            oProducto = oModeloProducto.get(tblProducto.getSelectedRow());
        } else {
            Mensajes.tblSelected();
        }
    }//GEN-LAST:event_tblProductoMouseReleased

    private void tblProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMousePressed
        if (evt.getClickCount() == 2) {
            enviarDatos();
            this.doDefaultCloseAction();
        }
    }//GEN-LAST:event_tblProductoMousePressed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        personalizaTabla();
    }//GEN-LAST:event_formInternalFrameClosing

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        personalizaTabla();
    }//GEN-LAST:event_formInternalFrameOpened

    private void tblProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProductoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            enviarDatos();
            this.doDefaultCloseAction();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            txfBusqueda.setText("");
            txfBusqueda.requestFocus();
        }
    }//GEN-LAST:event_tblProductoKeyPressed

    private void txfPrincipioActivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPrincipioActivoKeyReleased
        setOpBusqueda(Variables.BUSQ_X_PRINCIPIO_ACTIVO);
        buscarGeneric(evt);
    }//GEN-LAST:event_txfPrincipioActivoKeyReleased

    private void txfAccionTerapeuticaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfAccionTerapeuticaKeyReleased
        setOpBusqueda(Variables.BUSQ_X_ACCION_FARMACOLOGICA);
        buscarGeneric(evt);
    }//GEN-LAST:event_txfAccionTerapeuticaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txfAccionTerapeutica;
    private javax.swing.JTextField txfBusqueda;
    private javax.swing.JTextField txfPrincipioActivo;
    // End of variables declaration//GEN-END:variables

    private void insertarJifNuevoProducto() {
        //Cambia valor del invocador
        root.jifNuevoProducto.setInvocador(JIF_NuevoProducto.JIF_ADMINPRODUCTO);
        //Inserta el nuevo Internal Frame
        root.insertarInternalFrames(root.jifNuevoProducto);
        //Cambiar titulo del Internal Frame
        if (operacion == NUEVO) {
            root.jifNuevoProducto.setTitle("Registrar Producto");
            root.jifNuevoProducto.setOperacion(JIF_NuevoProducto.NUEVO);
        } else if (operacion == EDITAR) {
            root.jifNuevoProducto.setTitle("Actualizar Producto");
            root.jifNuevoProducto.setOperacion(JIF_NuevoProducto.EDITAR);
        }

    }

    private void listarProducto() {
        oProductoBl = new ProductoBl();
        listProductos = oProductoBl.listar("");
        if (!listProductos.isEmpty()) {
            oModeloProducto.addAll(listProductos);
        }
        personalizaTabla();
    }

    private void buscar(String ref, int op) {
        oProductoBl = new ProductoBl();
        listProductos = oProductoBl.listRef(ref, op);
        if (!listProductos.isEmpty()) {
            oModeloProducto.addAll(listProductos);
        } else {
            oModeloProducto.clear();
        }
    }

    private void enviarDatos(Producto oProducto) {
        root.jifNuevoProducto.enviaDatos(oProducto);
    }

    public int getInvocador() {
        return invocador;
    }

    public void setInvocador(int invocador) {
        this.invocador = invocador;
    }

    private void enviarDatos() {
        oProducto = oModeloProducto.get(tblProducto.getSelectedRow());
        switch (getInvocador()) {
            case JIF_COMPRAS:
                root.jifCompras.enviaDatosProducto(oProducto);
                break;

        }
    }

    public void inicializarJif() {
        listarProducto();
        personalizaTabla();
        txfBusqueda.setText("");
        txfBusqueda.requestFocus();
        oProducto = null;
    }

    private void personalizaTabla() {
        Utilitarios.formateaColumna(0, tblProducto, 50);
        Utilitarios.formateaColumna(2, tblProducto, 100);
        Utilitarios.formateaColumna(3, tblProducto, 100);
        Utilitarios.formateaColumna(4, tblProducto, 100);
        Utilitarios.formateaColumna(5, tblProducto, 100);
        Utilitarios.formateaColumna(8, tblProducto, 50);
        Utilitarios.alinearDatosColumnaTablaDerecha(8, tblProducto);
    }

    void actualizarLista() {
        listarProducto();
    }

    private void buscarGeneric(KeyEvent evt) {
        switch (getOpBusqueda()) {
            case Variables.BUSQ_X_PRODUCTO:
                if (!txfBusqueda.getText().toUpperCase().trim().equals("")) {
                    String ref = txfBusqueda.getText().toUpperCase().trim();
                    buscar(ref, Variables.BUSQ_X_PRODUCTO);
                } else {
                    oModeloProducto.clear();
                    listarProducto();
                }
                break;
            case Variables.BUSQ_X_PRINCIPIO_ACTIVO:
                if (!txfPrincipioActivo.getText().toUpperCase().trim().equals("")) {
                    String ref = txfPrincipioActivo.getText().toUpperCase().trim();
                    buscar(ref, Variables.BUSQ_X_PRINCIPIO_ACTIVO);
                } else {
                    oModeloProducto.clear();
                    listarProducto();
                }
                break;
            case Variables.BUSQ_X_ACCION_FARMACOLOGICA:
                if (!txfAccionTerapeutica.getText().toUpperCase().trim().equals("")) {
                    String ref = txfAccionTerapeutica.getText().toUpperCase().trim();
                    buscar(ref, Variables.BUSQ_X_ACCION_FARMACOLOGICA);
                } else {
                    oModeloProducto.clear();
                    listarProducto();
                }
                break;
            default:
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            tblProducto.requestFocus();
        }
        personalizaTabla();
    }
}
