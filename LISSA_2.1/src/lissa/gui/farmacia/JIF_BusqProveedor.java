package lissa.gui.farmacia;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import lissa.be.Proveedor;
import lissa.bl.ProveedorBl;
import lissa.gui.JF_Principal;
import lissa.table.ModeloProveedor;
import lissa.util.Utilitarios;

public class JIF_BusqProveedor extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloProveedor oModeloProveedor;
    private ProveedorBl oProveedorBl;
    private Proveedor oProveedor;
    private ArrayList<Proveedor> listProveedor;

    public JIF_BusqProveedor(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloProveedor = new ModeloProveedor();
        tblProveedor.setModel(oModeloProveedor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfRuc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txfRazonSocial = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setTitle("Buscar Proveedor");

        jLabel1.setText("N° Ruc :");

        txfRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfRucKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfRucKeyReleased(evt);
            }
        });

        jLabel2.setText("Razon Social :");

        txfRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfRazonSocialKeyPressed(evt);
            }
        });

        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblProveedorMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblProveedor);

        jToolBar1.setRollover(true);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdd);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txfRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfRucKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarXRuc();
        }
        personalizaVistaTabla();
    }//GEN-LAST:event_txfRucKeyPressed

    private void txfRazonSocialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfRazonSocialKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarXRazonSocial();
            tblProveedor.requestFocus();
        }
        personalizaVistaTabla();
    }//GEN-LAST:event_txfRazonSocialKeyPressed

    private void txfRucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfRucKeyReleased
        Utilitarios.validaCaracterNumerico(evt, txfRuc);
    }//GEN-LAST:event_txfRucKeyReleased

    private void tblProveedorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorMouseReleased
        if (tblProveedor.getRowSelectionAllowed() && tblProveedor.getSelectedRow() != -1) {
            if (evt.getClickCount() == 2) {
                //root.jifCompras.cargaDatosProveedor(oModeloProveedor.get(tblProveedor.getSelectedRow()));
                this.doDefaultCloseAction();
            }

        }
    }//GEN-LAST:event_tblProveedorMouseReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        root.insertarInternalFrames(root.jifAdministrarPersonaJuridica);
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblProveedor;
    private javax.swing.JTextField txfRazonSocial;
    private javax.swing.JTextField txfRuc;
    // End of variables declaration//GEN-END:variables

    private void buscarXRuc() {
        oProveedorBl = new ProveedorBl();
        String ruc = txfRuc.getText().trim().equals("") ? "" : txfRuc.getText().trim();
        oModeloProveedor.clear();
        oProveedor = oProveedorBl.buscar(ruc);
        if (oProveedor != null) {
            oModeloProveedor.add(oProveedor);
        }
    }

    private void buscarXRazonSocial() {
        oProveedorBl = new ProveedorBl();
        String rs = txfRazonSocial.getText().trim().equals("") ? "" : txfRazonSocial.getText().trim().toUpperCase();
        oModeloProveedor.clear();
        listProveedor = oProveedorBl.listar(rs);
        if (!listProveedor.isEmpty()) {
            oModeloProveedor.addAll(listProveedor);
        }
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblProveedor, 80);
        Utilitarios.formateaColumna(2, tblProveedor, 200);
    }

    void inicializa() {
        resetComponent();
        personalizaVistaTabla();

    }

    private void resetComponent() {
        oModeloProveedor.clear();
        txfRuc.setText("");
        txfRazonSocial.setText("");
    }
}
