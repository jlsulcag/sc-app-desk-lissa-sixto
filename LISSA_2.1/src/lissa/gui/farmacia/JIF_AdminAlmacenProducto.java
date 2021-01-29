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
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_AdminAlmacenProducto extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloAdminPrecio oModeloAdminPrecio;
    private List<AlmacenProducto> listAlmacenProducto;
    private AlmacenProducto oAlmacenProducto;
    private AlmacenProductoBl oAlmacenProductoBl;
    private PrecioProducto oPrecioProducto;
    private PrecioProductoBl oPrecioProductoBl;
    private Usuario oUsuario;

    public JIF_AdminAlmacenProducto(JF_Principal root) {
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txfLote = new javax.swing.JTextField();
        jdcFechaVencimiento = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Administrar Inventario");

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Producto"));

        jLabel5.setText("Lote :");

        jLabel6.setText("Fecha de Vencimiento :");

        txfLote.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfLote, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdcFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(txfLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFechaVencimiento;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txfBusqueda;
    private javax.swing.JTextField txfLote;
    // End of variables declaration//GEN-END:variables

    private void buscar() {
        listAlmacenProducto = new LinkedList<>();
        oAlmacenProductoBl = new AlmacenProductoBl();
        oModeloAdminPrecio.clear();
        if (!txfBusqueda.getText().trim().equals("")) {
            listAlmacenProducto = oAlmacenProductoBl.listRef(txfBusqueda.getText().toUpperCase().trim());
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
            //oPrecioProducto = buscarPrecioAct(oAlmacenProducto.getIdalmacenproducto());
            if (oAlmacenProducto != null) {
                imprimirPrecios(oAlmacenProducto);
            }
        }
    }

    private PrecioProducto buscarPrecioAct(Long idalmacenproducto) {
        oPrecioProductoBl = new PrecioProductoBl();
        return oPrecioProductoBl.buscarxIdAlmacenProducto(idalmacenproducto);
    }

    private void imprimirPrecios(AlmacenProducto oAlmacenProducto) {
        txfLote.setText(oAlmacenProducto.getLote().trim());
        jdcFechaVencimiento.setDate(oAlmacenProducto.getFechaVencimiento());
    }

    private void actualizarPrecios() {
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {            
            if(isDatosValidos()){
                //Actualizar los  valores nuevos  para el producto seleccionado
                AlmacenProducto temp = new AlmacenProducto();
                AlmacenProductoBl oAlmacenProductoBl = new AlmacenProductoBl();
                temp  = oAlmacenProducto;
                temp.setLote(txfLote.getText().toUpperCase().trim());
                temp.setFechaVencimiento(jdcFechaVencimiento.getDate());
                oAlmacenProductoBl.actualizar(temp);
            }else{
                Mensajes.msjValidarIngreso();
            }
        }

    }

    private void resetComponents() {
        txfBusqueda.setText("");
        oModeloAdminPrecio.clear();
        txfLote.setText("");
        jdcFechaVencimiento.setDate(null);
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

    private boolean isDatosValidos() {
        return (!txfLote.getText().trim().equals("")
                && jdcFechaVencimiento.getDate() != null);
    }

    public void iniciar() {
        resetComponents();
    }
}
