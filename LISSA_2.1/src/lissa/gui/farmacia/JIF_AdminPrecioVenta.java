package lissa.gui.farmacia;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import lissa.be.AlmacenProducto;
import lissa.be.PrecioProducto;
import lissa.be.Usuario;
import lissa.bl.AlmacenProductoBl;
import lissa.bl.PrecioProductoBl;
import lissa.gui.JF_Principal;
import lissa.table.ModeloAdminPrecio;
import lissa.util.Utilitarios;

public class JIF_AdminPrecioVenta extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloAdminPrecio oModeloAdminPrecio;
    private List<AlmacenProducto> listAlmacenProducto;
    private AlmacenProducto oAlmacenProducto;
    private AlmacenProductoBl oAlmacenProductoBl;
    private PrecioProducto oPrecioProducto;
    private PrecioProductoBl oPrecioProductoBl;
    private Usuario oUsuario;

    public JIF_AdminPrecioVenta(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloAdminPrecio = new ModeloAdminPrecio();
        tblResultados.setModel(oModeloAdminPrecio);
        personalizaTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txfPvMin = new javax.swing.JTextField();
        txfPvmax = new javax.swing.JTextField();
        txfPrecSugerido = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Administrar Precios");

        jLabel1.setText("Producto :");

        txfBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBusquedaKeyReleased(evt);
            }
        });

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblResultadosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultados);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Precio Vigente"));

        jLabel2.setText("PV Min :");

        jLabel3.setText("PV Max :");

        jLabel4.setText("PV Sugerido :");

        txfPvMin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txfPvmax.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txfPrecSugerido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(347, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfPvMin, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txfPvmax, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txfPrecSugerido, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txfPvMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfPvmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfPrecSugerido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfBusqueda))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBusquedaKeyReleased
        buscar();
        personalizaTabla();
    }//GEN-LAST:event_txfBusquedaKeyReleased

    private void tblResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseReleased
        selectProducto();
    }//GEN-LAST:event_tblResultadosMouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        actualizarPrecios();
        resetComponents();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        resetComponents();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txfBusqueda;
    private javax.swing.JTextField txfPrecSugerido;
    private javax.swing.JTextField txfPvMin;
    private javax.swing.JTextField txfPvmax;
    // End of variables declaration//GEN-END:variables

    private void buscar() {
        listAlmacenProducto = new LinkedList<>();
        oAlmacenProductoBl = new AlmacenProductoBl();
        oModeloAdminPrecio.clear();
        if (!txfBusqueda.getText().trim().equals("")) {
            listAlmacenProducto = oAlmacenProductoBl.listRef(txfBusqueda.getText().toUpperCase().trim(), "FARMACIA");
            if (!listAlmacenProducto.isEmpty()) {
                for (AlmacenProducto obj : listAlmacenProducto) {
                    oModeloAdminPrecio.add(obj);
                }
            }
        }
    }

    private void selectProducto() {
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            oAlmacenProducto = oModeloAdminPrecio.get(tblResultados.getSelectedRow());
            oPrecioProducto = buscarPrecioAct(oAlmacenProducto.getIdalmacenproducto());
            if (oPrecioProducto != null) {
                imprimirPrecios(oPrecioProducto, oAlmacenProducto);
            }
        }
    }

    private PrecioProducto buscarPrecioAct(Long idalmacenproducto) {
        oPrecioProductoBl = new PrecioProductoBl();
        return oPrecioProductoBl.buscarxIdAlmacenProducto(idalmacenproducto);
    }

    private void imprimirPrecios(PrecioProducto oPrecioProducto, AlmacenProducto oAlmacenProducto) {
        txfPvMin.setText(oPrecioProducto.getPvMin().toString());
        txfPvmax.setText(oPrecioProducto.getPvMax().toString());
        txfPrecSugerido.setText(oPrecioProducto.getPvSugerido().toString());
    }

    private void actualizarPrecios() {
        /*
         Actualizar  el precio original y poneerlo en estado 0
         Registrar el nuevo precio con estado 1
         */
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            PrecioProducto pp = new PrecioProducto();
            oPrecioProductoBl = new PrecioProductoBl();
            if (oPrecioProducto != null) {
                //actualizar
                oPrecioProducto.setFechaFin(new Date());
                oPrecioProducto.setEstado(0);
                oPrecioProductoBl.actualizar(oPrecioProducto);
            }
            //registrar
            //pp = oPrecioProducto;
            pp.setAlmacenProducto(oAlmacenProducto);
            pp.setPvMin(txfPvMin.getText().trim().equals("")?BigDecimal.ZERO:new BigDecimal(txfPvMin.getText().trim()));
            pp.setPvMax(txfPvmax.getText().trim().equals("")?BigDecimal.ZERO:new BigDecimal(txfPvmax.getText().trim()));
            pp.setPvSugerido(txfPrecSugerido.getText().trim().equals("")?BigDecimal.ZERO:new BigDecimal(txfPrecSugerido.getText().trim()));
            pp.setFechaInicio(new Date());
            pp.setFechaFin(null);
            pp.setIdUsuario(getoUsuario().getIdUsuario());
            pp.setEstado(1);
            oPrecioProductoBl.registrar(pp);
        }

    }

    private void resetComponents() {
        txfBusqueda.setText("");
        oModeloAdminPrecio.clear();
        txfPvMin.setText("");
        txfPvmax.setText("");
        txfPrecSugerido.setText("");
        personalizaTabla();
    }

    private void personalizaTabla() {
        Utilitarios.formateaColumna(0, tblResultados, 50);
        Utilitarios.formateaColumna(4, tblResultados, 60);
        Utilitarios.formateaColumna(5, tblResultados, 70);
        Utilitarios.formateaColumna(6, tblResultados, 70);
        Utilitarios.formateaColumna(7, tblResultados, 70);
        Utilitarios.alinearDatosColumnaTablaDerecha(4, tblResultados);
        Utilitarios.alinearDatosColumnaTablaDerecha(7, tblResultados);
    }

    public void enviaUser(Usuario user) {
        setoUsuario(user);
    }

    public Usuario getoUsuario() {
        return oUsuario;
    }

    public void setoUsuario(Usuario oUsuario) {
        this.oUsuario = oUsuario;
    }

    public void iniciar() {
        resetComponents();
    }
}
