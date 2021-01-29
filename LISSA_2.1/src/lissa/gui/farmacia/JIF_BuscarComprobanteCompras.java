package lissa.gui.farmacia;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lissa.be.Almacen;
import lissa.be.AlmacenProducto;
import lissa.be.Compra;
import lissa.be.DetalleCompra;
import lissa.be.Kardex;
import lissa.be.Producto;
import lissa.be.Proveedor;
import lissa.bl.AlmacenProductoBl;
import lissa.bl.CompraBl;
import lissa.bl.DetalleCompraBl;
import lissa.bl.KardexBl;
import lissa.bl.ProveedorBl;
import lissa.controller.AlmacenCtrl;
import lissa.ds.DSConeccion;
import lissa.gui.JF_Principal;
import lissa.reportes.ReportGeneric;
import lissa.table.ModeloCompraProducto;
import lissa.table.ModeloDocCompra;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Variables;

public class JIF_BuscarComprobanteCompras extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloDocCompra oModeloDocCompra;
    private List<Compra> listCompra;
    private CompraBl oCompraBl;
    private Compra oCompra;
    private Proveedor oProveedor;
    private ProveedorBl oProveedorBl;
    private Compra oCompraTemp2;
    private DetalleCompra oDetalleCompra;
    private DetalleCompraBl oDetalleCompraBl;
    private List<DetalleCompra> listDetalleCompra;
    private Kardex oKardex;
    private KardexBl oKardexBl;
    private JComboBox cbxAlmacen;
    private AlmacenCtrl oAlmacenCtrl;
    private AlmacenProducto oAlmacenProducto;
    private AlmacenProductoBl oAlmacenProductoBl;
    private ModeloCompraProducto oModeloCompraProducto;

    //Variables para el reporte
    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;

    public JIF_BuscarComprobanteCompras(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloDocCompra = new ModeloDocCompra();
        tblResultados.setModel(oModeloDocCompra);
        cbxAlmacen = new JComboBox();
        oModeloCompraProducto = new ModeloCompraProducto();
        tblItems.setModel(oModeloCompraProducto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txfNumRuc = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txfMotivoAnulacion = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Búsqueda comprobantes de compra");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setText("N° Comprobante :");

        txfNumRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNumRucKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfNumRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(790, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfNumRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jButton2.setText("Anular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Motivo de anulación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txfMotivoAnulacion)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txfMotivoAnulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Compras"));

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Items"));

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblItemsMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblItems);

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImprimir))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimir)
                    .addComponent(jButton2))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfNumRucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNumRucKeyReleased
        Utilitarios.validaCaracterNumerico(evt, txfNumRuc);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            oModeloDocCompra.clear();
            if (!txfNumRuc.getText().trim().equals("")) {
                buscarCompraxNumComprobante(txfNumRuc.getText().trim().toUpperCase());
                personalizarTabla();
            } else {
                Mensajes.msjValidarIngreso();
            }
        }
    }//GEN-LAST:event_txfNumRucKeyReleased

    private void tblResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseReleased
        obtenerDatos();
    }//GEN-LAST:event_tblResultadosMouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        procesarAnulacion();
        JOptionPane.showMessageDialog(null, "En Desarrollo ...50%", "Atención", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        if (oCompra.getEstado().equals("ANU")) {
            Mensajes.docAnulado();
        } else {
            imprimirComprobante(oCompra);
        }

    }//GEN-LAST:event_btnImprimirActionPerformed

    private void tblItemsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemsMouseReleased
        obtenerItem();
    }//GEN-LAST:event_tblItemsMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //editar();
        JOptionPane.showMessageDialog(null, "En Desarrollo ...50%", "Atención", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblItems;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txfMotivoAnulacion;
    private javax.swing.JTextField txfNumRuc;
    // End of variables declaration//GEN-END:variables

    private void personalizarTabla() {
        System.out.println("");
    }

    private Proveedor buscarProveedorxRuc(String ruc) {
        oProveedorBl = new ProveedorBl();
        return oProveedorBl.buscar(ruc);
    }

    private void listdocsCompras(long idproveedor) {
        listCompra = new LinkedList<>();
        oCompraBl = new CompraBl();
        oModeloDocCompra.clear();
        listCompra = oCompraBl.listarxIdProveedor(idproveedor);
        for (Compra comp : listCompra) {
            oModeloDocCompra.add(comp);
        }
    }

    private void obtenerDatos() {
        //oCompra = new Compra();
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            oCompra = oModeloDocCompra.get(tblResultados.getSelectedRow());
            if (oCompra != null) {
                listarItems(oCompra);
            }
        }
    }

    private void imprimirComprobante(Compra oCompra) {

        try {
            ds = new lissa.ds.DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport("Far_ComprobanteCompra", new String[]{"ID_COMPRA"}, new Object[]{oCompra.getIdcompra()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Comprobante");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.setResizable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
        } catch (Exception ex) {
            Logger.getLogger(JIF_BuscarComprobanteCompras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //METODO TRANSACCIONAL  PARA ANULAR TODO EL PROCESO DE COMPRA
    private void procesarAnulacion() {
        int r = -1;
        if (isDatosValidos()) {
            int resAlmacenStock = -1;
            
            oCompraBl = new CompraBl();
            //oCompraTemp2 = new Compra();
            /*
            oCompraTemp2.setIdcompra(oCompra.getIdcompra());
            oCompraTemp2.setFarComprobante(oCompra.getFarComprobante());
            oCompraTemp2.setNumeroComprobante(oCompra.getNumeroComprobante());
            oCompraTemp2.setFechaCompra(oCompra.getFechaCompra());
            oCompraTemp2.setPersonaProveedor(oCompra.getPersonaProveedor());
            oCompraTemp2.setSerie(oCompra.getSerie());
            oCompraTemp2.setHoraReg(oCompra.getHoraReg());
            oCompraTemp2.setFechaReg(oCompra.getFechaReg());
            oCompraTemp2.setValorNeto(oCompra.getValorNeto());
            oCompraTemp2.setValorIgv(oCompra.getValorIgv());
            oCompraTemp2.setValorBruto(oCompra.getValorBruto());
            */
            oCompra.setEstado("ANU");
            
            oCompra.setMotivoAunulacion(txfMotivoAnulacion.getText().trim().toUpperCase());
            /*
            oCompraTemp2.setNumeroCompra(oCompra.getNumeroCompra());
            oCompraTemp2.setUsuarioReg(oCompra.getUsuarioReg());
            oCompraTemp2.setValorDescuento(oCompra.getValorDescuento());
            oCompraTemp2.setValorTotal(oCompra.getValorTotal());
            */
            r = oCompraBl.procesarAnulacion(oCompra, listDetalleCompra);

            if (r == Variables.SUCCESS) {
                Mensajes.msjRegCorrecta();
                inicializar();
            } else {
                Mensajes.msjRegError();
            }

        } else {
            Mensajes.msjValidarIngreso();
        }
    }

    private boolean isDatosValidos() {
        return (tblResultados.getRowSelectionAllowed()
                && tblResultados.getSelectedRow() != -1
                && !txfMotivoAnulacion.getText().trim().toUpperCase().equals(""));
    }

    private int anular() {
        oCompraBl = new CompraBl();
        oCompraTemp2 = new Compra();

        oCompraTemp2.setIdcompra(oCompra.getIdcompra());
        oCompraTemp2.setFarComprobante(oCompra.getFarComprobante());
        oCompraTemp2.setNumeroComprobante(oCompra.getNumeroComprobante());
        oCompraTemp2.setFechaCompra(oCompra.getFechaCompra());
        oCompraTemp2.setPersonaProveedor(oCompra.getPersonaProveedor());
        oCompraTemp2.setSerie(oCompra.getSerie());
        oCompraTemp2.setHoraReg(oCompra.getHoraReg());
        oCompraTemp2.setFechaReg(oCompra.getFechaReg());
        oCompraTemp2.setValorNeto(oCompra.getValorNeto());
        oCompraTemp2.setValorIgv(oCompra.getValorIgv());
        oCompraTemp2.setValorBruto(oCompra.getValorBruto());
        oCompraTemp2.setEstado("ANU");
        oCompraTemp2.setMotivoAunulacion(txfMotivoAnulacion.getText().trim().toUpperCase());
        oCompraTemp2.setNumeroCompra(oCompra.getNumeroCompra());
        oCompraTemp2.setUsuarioReg(oCompra.getUsuarioReg());
        oCompraTemp2.setValorDescuento(oCompra.getValorDescuento());
        oCompraTemp2.setValorTotal(oCompra.getValorTotal());

        int res = oCompraBl.actualizar(oCompraTemp2);
        return res;
    }

    private Kardex registrarKardex() {
        oKardex = new Kardex();
        oKardexBl = new KardexBl();

        //oKardex.setAlmacenByIdDestino(null); //destino = ninguno
        oKardex.setIdAlmacenAfectado(((Almacen) cbxAlmacen.getSelectedItem()).getIdalmacen()); // afectado es almacen
        oKardex.setTipoOperacion("SALIDA");
        oKardex.setOperacion("ANULACIÓN DE COMPRA");
        oKardex.setFechaMov(new Date());
        oKardex.setHoraMov(Utilitarios.horaActual());
        oKardex.setComprobante("");
        oKardex.setNumSerie("");
        oKardex.setNumComprobante(0);
        oKardex.setOrigen("");
        oKardex.setDestino("");
        oKardex.setObservacion("");

        return oKardexBl.registrar(oKardex);
    }

    public void inicializar() {
        txfNumRuc.setText("");
        txfMotivoAnulacion.setText("");
        cargarCbxAlmacen();
        oModeloDocCompra.clear();
    }

    private void cargarCbxAlmacen() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.rellenaAlmacen(cbxAlmacen);
        oAlmacenCtrl.defaultSelectAlmacen("almacen", cbxAlmacen);
    }

    /*
    private void registrarDetalleKardex(Kardex oKardex, DetalleCompra obj) {
        //for (int i = 0; i < listDetalleCompra.size(); i++) {
            oDetalleKardex = new DetalleKardex();
            oDetalleKardexBl = new DetalleKardexBl();
//            oDetalleCompra = listDetalleCompra.get(i);
            oDetalleCompra = obj;

            oDetalleKardex.setKardex(oKardex);
            oDetalleKardex.setProducto(oDetalleCompra.getProducto());
            if(oDetalleCompra.getIsUnitario()){
                oDetalleKardex.setCantidad(oDetalleCompra.getCantidad());
            }else{
                oDetalleKardex.setCantidad(oDetalleCompra.getCantidad()*oDetalleCompra.getProducto().getFraccion());
            }
            
            //Buscar Stock anterior
            long stockAnt = stockAnterior(oDetalleCompra.getProducto().getIdproducto(), ((Almacen) cbxAlmacen.getSelectedItem()).getIdalmacen());
            System.out.println("stock anterior "+stockAnt);
            
            oDetalleKardex.setStockAntOrig(Integer.parseInt(stockAnt + ""));
            oDetalleKardex.setStockActOrig(Integer.parseInt((stockAnt - oDetalleKardex.getCantidad()) + ""));
            oDetalleKardex.setStockAnt(Integer.parseInt(stockAnt + ""));
            oDetalleKardex.setStockActual(Integer.parseInt((stockAnt - oDetalleKardex.getCantidad()) + ""));
            int num = oDetalleKardexBl.maxNumMov();
            oDetalleKardex.setNumeroMovimiento(num + 1);
            //

            oDetalleKardexBl.registrar(oDetalleKardex);
        //}
    }
     */
    private long stockAnterior(int idproducto, int idalmacen) {
        oAlmacenProductoBl = new AlmacenProductoBl();
        return oAlmacenProductoBl.buscar(idproducto, idalmacen);
    }

    private int actualizarAlmacenStock(DetalleCompra obj) {
        int res = -1;
//        for (int i = 0; i < listDetalleCompra.size(); i++) {
        oAlmacenProducto = new AlmacenProducto();
        oAlmacenProductoBl = new AlmacenProductoBl();
        //buscar en almacen por producto y nombre de almacen para su actualizacion y lote y retornar el objeto a actualizar
        //Buscar por lote
        oDetalleCompra = obj;
        oAlmacenProducto = buscarAlmacenProductoXlote(oDetalleCompra.getLote(), (Almacen) cbxAlmacen.getSelectedItem(), oDetalleCompra.getProducto());
        oAlmacenProducto.setStockActual(oAlmacenProducto.getStockActual().subtract(new BigDecimal(oDetalleCompra.getCantidad() * oDetalleCompra.getProducto().getFraccion())));
        res = oAlmacenProductoBl.actualizar(oAlmacenProducto);
//        }
        return res;
    }

    private AlmacenProducto buscarAlmacenProductoXlote(String lote, Almacen oAlmacen, Producto oProducto) {
        oAlmacenProductoBl = new AlmacenProductoBl();
        return oAlmacenProductoBl.buscarProductoxAlmacenyLote(lote, oAlmacen, oProducto);
    }

    private void buscarCompraxNumComprobante(String num) {
        oCompraBl = new CompraBl();
        listCompra = oCompraBl.listarXNumComprobante(num);
        if (!listCompra.isEmpty()) {
            for (Compra obj : listCompra) {
                oModeloDocCompra.add(obj);
            }
        } else {
            Mensajes.msjResultVacio();
        }
    }

    private void listarItems(Compra compra) {
        listDetalleCompra = new LinkedList<>();
        oDetalleCompraBl = new DetalleCompraBl();
        oModeloCompraProducto.clear();
        listDetalleCompra = oDetalleCompraBl.listarXCompra(compra);
        if (!listDetalleCompra.isEmpty()) {
            for (DetalleCompra detalleCompra : listDetalleCompra) {
                oModeloCompraProducto.add(detalleCompra);
            }
        }
    }

    private void obtenerItem() {
        oDetalleCompra = new DetalleCompra();
        if (isItemSeleccionado()) {
            oDetalleCompra = oModeloCompraProducto.get(tblItems.getSelectedRow());
        }

    }

    private boolean isItemSeleccionado() {
        return (tblItems.getRowSelectionAllowed() && tblItems.getSelectedRow() != -1);
    }

    private void editar() {
        if (isItemSeleccionado() && oDetalleCompra != null) {
            root.insertarInternalFrames(root.jifEditarItemsCompra);
            root.jifEditarItemsCompra.inicializarItem(oDetalleCompra);
        } else {
            Mensajes.tblSelected();
        }
    }
}
