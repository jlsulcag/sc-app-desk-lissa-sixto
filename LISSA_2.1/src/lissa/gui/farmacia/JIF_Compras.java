package lissa.gui.farmacia;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
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
import lissa.be.FarComprobante;
import lissa.be.Kardex;
import lissa.be.Persona;
import lissa.be.PrecioProducto;
import lissa.be.Producto;
import lissa.be.Rol;
import lissa.be.Usuario;
import lissa.bl.AlmacenProductoBl;
import lissa.bl.CompraBl;
import lissa.bl.DetalleCompraBl;
import lissa.bl.KardexBl;
import lissa.bl.PersonaBl;
import lissa.bl.PrecioProductoBl;
import lissa.controller.AlmacenCtrl;
import lissa.controller.FarComprobanteCtrl;
import lissa.controller.ProveedorCtrl;
import lissa.controller.TipoComprobanteCtrl;
import lissa.ds.DSConeccion;
import lissa.gui.JF_Principal;
import lissa.gui.JIF_AdministrarPersonaNatural;
import lissa.reportes.ReportGeneric;
import lissa.table.ModeloBusqProducto;
import lissa.table.ModeloCompraProducto;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Constants;

public class JIF_Compras extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private Producto oProducto;
    private ModeloCompraProducto oModeloCompraProducto;
    private DetalleCompra oDetalleCompra;
    private Compra oCompra;
    private CompraBl oCompraBl;
    private DetalleCompraBl oDetalleCompraBl;
    private DetalleCompra beanTabla;
    private Persona oPersonaProveedor;
    private PersonaBl oPersonaBl;
    //----------
    private TipoComprobanteCtrl oTipoComprobanteCtrl;
    private FarComprobanteCtrl oFarComprobanteCtrl;
    private ProveedorCtrl oProveedorCtrl;
    private AlmacenCtrl oAlmacenCtrl;
    //----------

    private Usuario userTemp;
    private Persona perTemp;
    private Rol rolTemp;

    public static final BigDecimal IGV = new BigDecimal("0.18");
    private BigDecimal valorNeto = new BigDecimal("0.00");
    private BigDecimal valorIgv = new BigDecimal("0.00");
    private BigDecimal valorBruto = new BigDecimal("0.00");
    private BigDecimal valorDescuento = new BigDecimal("0.00");
    private BigDecimal valorTotal = new BigDecimal("0.00");
    private BigDecimal pvMin = new BigDecimal("0.00");
    private BigDecimal pvMax = new BigDecimal("0.00");

    private JComboBox cbxAlmacen;
    private Kardex oKardex;
    private KardexBl oKardexBl;
    private AlmacenProducto oAlmacenProducto;
    private AlmacenProductoBl oAlmacenProductoBl;
    //
    private List<AlmacenProducto> listAlmacenProducto;
    private ModeloBusqProducto oModeloBusqProducto;
    int filaSelect;
    private PrecioProducto oPrecioProducto;
    private PrecioProductoBl oPrecioProductoBl;
    //-------------------------------------------------------
    private BigDecimal cant = new BigDecimal("0.00");
    private BigDecimal valorUnitario = new BigDecimal("0.00");
    private BigDecimal valor_compra = new BigDecimal("0.00");
    private double desc_unico;
    private BigDecimal valor_desc_item = new BigDecimal("0.00");
    private BigDecimal valor_igv_item = new BigDecimal("0.00");
    private BigDecimal fra = new BigDecimal("0.00");
    private BigDecimal valor_total_item = new BigDecimal("0.00");

    private BigDecimal valor_desc_total = new BigDecimal("0.00");
    private BigDecimal valor_total = new BigDecimal("0.00");
    ;
    private BigDecimal prec_compra_fraccion = new BigDecimal("0.00");
    private BigDecimal prec_compra_unidad = new BigDecimal("0.00");
    public static final BigDecimal CIEN = new BigDecimal("100");
    //Variables para el reporte
    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;

    public JIF_Compras(JF_Principal root) {
        initComponents();
        this.root = root;
        cbxAlmacen = new JComboBox();        
        oModeloCompraProducto = new ModeloCompraProducto();
        tblProductos.setModel(oModeloCompraProducto);
        personalizaTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txfUnidad = new javax.swing.JTextField();
        chbxBono = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txfNumeroComprobante = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxTipoComprobante = new javax.swing.JComboBox();
        txfSerie = new javax.swing.JTextField();
        txfRuc = new javax.swing.JTextField();
        txfRazonSocial = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txfNumeroLote = new javax.swing.JTextField();
        jdcFechaVencimiento = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txfValorUnitario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txfDescuentoItem = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txfCantidad = new javax.swing.JTextField();
        txfDesc1 = new javax.swing.JTextField();
        txfDesc2 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txfPrecioUnitario = new javax.swing.JTextField();
        txfTotalUnidades = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        txfValorBruto = new javax.swing.JTextField();
        txfValorIgv = new javax.swing.JTextField();
        txfValorTotal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txfValorDescuento = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txfValorCompraNeto = new javax.swing.JTextField();
        btnQuitar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jdcFechaCompra = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txfPvMin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txfPvMax = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txfPrecioSugerido = new javax.swing.JTextField();
        txfUtiMin = new javax.swing.JTextField();
        txfUtiMax = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registro de Compras");
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

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del producto"));

        jLabel1.setText("Producto :");

        txfProducto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfProducto.setEnabled(false);

        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        jLabel25.setText("Unidad :");

        txfUnidad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfUnidad.setEnabled(false);

        chbxBono.setText("Reg x Unidad");
        chbxBono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxBonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(chbxBono, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(txfUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbxBono)))
                    .addComponent(btnBuscarProducto))
                .addGap(1, 1, 1))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del comprobante"));

        jLabel15.setText("N° Comprobante :");

        txfNumeroComprobante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfNumeroComprobanteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNumeroComprobanteKeyReleased(evt);
            }
        });

        jLabel6.setText("Proveedor :");

        jLabel2.setText("Comprobante :");

        txfSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfSerieKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfSerieKeyReleased(evt);
            }
        });

        txfRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfRucKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfRucKeyReleased(evt);
            }
        });

        txfRazonSocial.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfRuc)
                    .addComponent(cbxTipoComprobante, 0, 155, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfNumeroComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                    .addComponent(txfRazonSocial))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(cbxTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txfNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(txfRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la compra"));

        jLabel3.setText("Cantidad :");

        jLabel4.setText("N° Lote :");

        jLabel5.setText("Fecha Vencimiento :");

        txfNumeroLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfNumeroLoteKeyPressed(evt);
            }
        });

        jdcFechaVencimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jdcFechaVencimientoKeyPressed(evt);
            }
        });

        jLabel8.setText("Valor Unitario :");

        txfValorUnitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfValorUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfValorUnitarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfValorUnitarioKeyReleased(evt);
            }
        });

        jLabel13.setText("Descuento (S/.) :");

        txfDescuentoItem.setEditable(false);
        txfDescuentoItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfDescuentoItem.setText("0.00");

        jLabel18.setText("Descuento (%) :");

        txfCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfCantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCantidadKeyReleased(evt);
            }
        });

        txfDesc1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfDesc1.setPreferredSize(new java.awt.Dimension(60, 20));
        txfDesc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfDesc1KeyPressed(evt);
            }
        });

        txfDesc2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfDesc2.setPreferredSize(new java.awt.Dimension(60, 20));
        txfDesc2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfDesc2KeyPressed(evt);
            }
        });

        jLabel26.setText("Precio Unitario :");

        txfPrecioUnitario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfPrecioUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfPrecioUnitarioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfPrecioUnitarioKeyReleased(evt);
            }
        });

        txfTotalUnidades.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfTotalUnidades.setEnabled(false);
        txfTotalUnidades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfTotalUnidadesKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfDescuentoItem, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(txfCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txfTotalUnidades)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfNumeroLote)
                    .addComponent(jdcFechaVencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfDesc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfDesc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txfNumeroLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18)
                                .addComponent(txfDesc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txfDesc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(txfValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26)
                                .addComponent(txfPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txfTotalUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(txfDescuentoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addComponent(jdcFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de productos"));

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

        txfValorBruto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txfValorBruto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfValorBruto.setText("0.00");

        txfValorIgv.setEditable(false);
        txfValorIgv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txfValorIgv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfValorIgv.setText("0.00");

        txfValorTotal.setEditable(false);
        txfValorTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txfValorTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfValorTotal.setText("0.00");

        jLabel20.setText("Valor Compra Bruto :");

        jLabel21.setText("IGV (18%)");

        jLabel22.setText("Total ");

        jLabel17.setText("Descuento :");

        txfValorDescuento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txfValorDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfValorDescuento.setText("0.00");
        txfValorDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfValorDescuentoKeyReleased(evt);
            }
        });

        jLabel23.setText("Valor Compra Neto :");

        txfValorCompraNeto.setEditable(false);
        txfValorCompraNeto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txfValorCompraNeto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfValorCompraNeto.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfValorBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfValorDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfValorCompraNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfValorIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txfValorBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel17)
                        .addComponent(txfValorDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23)
                        .addComponent(txfValorCompraNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)
                        .addComponent(txfValorIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/remove.png"))); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.setToolTipText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/cancel16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Save16.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha/Hora"));

        jLabel16.setText("Fecha :");

        jdcFechaCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jdcFechaCompraKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jdcFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(jdcFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Venta"));

        jLabel9.setText("% Utilidad :");

        jLabel10.setText("Min");

        jLabel11.setText("Max");

        txfPvMin.setEditable(false);
        txfPvMin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel7.setText("PV Min : ");

        jLabel12.setText("PV Max :");

        txfPvMax.setEditable(false);
        txfPvMax.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel14.setText("Precio Sugerido :");

        txfPrecioSugerido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfPrecioSugerido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfPrecioSugeridoActionPerformed(evt);
            }
        });

        txfUtiMin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfUtiMin.setText("25");
        txfUtiMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfUtiMinKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfUtiMinKeyReleased(evt);
            }
        });

        txfUtiMax.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfUtiMax.setText("50");
        txfUtiMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfUtiMaxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfUtiMaxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfUtiMin, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfUtiMax, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfPvMin, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfPvMax, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfPrecioSugerido, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(txfPvMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(txfPvMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txfPrecioSugerido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfUtiMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfUtiMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(8, 8, 8)
                        .addComponent(btnQuitar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitar)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        abrirJifBuscarProducto();
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (isDatosValidosCompraProducto()) {
            agregarDetalleCompra();
            if (oModeloCompraProducto.size() > 0) {
                calcularTotales();
                //calularValorNeto();
            } else {
                resetTotales();
            }
            resetcomponentCompra();
            resetPaintComponentProducto();
        } else {
            Mensajes.msjValidarIngreso();
            paintComponentProducto();
        }
        personalizaTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        registrar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txfValorDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfValorDescuentoKeyReleased
        calularValorNeto();
    }//GEN-LAST:event_txfValorDescuentoKeyReleased

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if (tblProductos.getSelectedRow() != -1 && tblProductos.getRowSelectionAllowed()) {
            recalcularMontos();
        } else {
            Mensajes.tblSelected();
        }
        personalizaTabla();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void txfValorUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfValorUnitarioKeyReleased
        if (oProducto != null) {
            if (!txfCantidad.getText().trim().equals("")) {
                calcularPrecioConIgv();
                calcularPrecioCompraNeto();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Cargue los datos del producto", "Error", JOptionPane.ERROR_MESSAGE);
            txfValorUnitario.setText("");
        }

    }//GEN-LAST:event_txfValorUnitarioKeyReleased

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        personalizaTabla();
        txfSerie.requestFocus();
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        personalizaTabla();
    }//GEN-LAST:event_formInternalFrameClosing

    private void tblProductosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseReleased
        filaSelect = tblProductos.getSelectedRow();
    }//GEN-LAST:event_tblProductosMouseReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        resetComponentFull();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txfSerieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfSerieKeyReleased
        Utilitarios.validaCaracterAlfabeticoNumerico(evt, txfSerie);
    }//GEN-LAST:event_txfSerieKeyReleased

    private void txfNumeroComprobanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNumeroComprobanteKeyReleased
        Utilitarios.validaCaracterNumerico(evt, txfNumeroComprobante);
    }//GEN-LAST:event_txfNumeroComprobanteKeyReleased

    private void txfSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfSerieKeyPressed
        Utilitarios.requestFocusEnter(txfNumeroComprobante, evt);
    }//GEN-LAST:event_txfSerieKeyPressed

    private void txfNumeroComprobanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNumeroComprobanteKeyPressed
        Utilitarios.requestFocusEnter(jdcFechaCompra, evt);
    }//GEN-LAST:event_txfNumeroComprobanteKeyPressed

    private void jdcFechaCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcFechaCompraKeyPressed
        Utilitarios.requestFocusEnter(txfRuc, evt);
    }//GEN-LAST:event_jdcFechaCompraKeyPressed

    private void txfNumeroLoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNumeroLoteKeyPressed
        Utilitarios.requestFocusEnter(txfDesc1, evt);
        Utilitarios.requestFocusEnter(txfDesc1, evt);
    }//GEN-LAST:event_txfNumeroLoteKeyPressed

    private void txfCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadKeyPressed
        Utilitarios.validaCaracterNumerico(evt, txfCantidad);
        Utilitarios.requestFocusEnter(txfNumeroLote, evt);
    }//GEN-LAST:event_txfCantidadKeyPressed

    private void txfRucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfRucKeyReleased
        Utilitarios.validaCaracterNumerico(evt, txfRuc);
    }//GEN-LAST:event_txfRucKeyReleased

    private void txfRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfRucKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarXRuc();
        }
    }//GEN-LAST:event_txfRucKeyPressed

    private void txfDesc1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfDesc1KeyPressed
        Utilitarios.requestFocusEnter(txfDesc2, evt);
    }//GEN-LAST:event_txfDesc1KeyPressed

    private void txfDesc2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfDesc2KeyPressed
        Utilitarios.requestFocusEnter(txfValorUnitario, evt);
    }//GEN-LAST:event_txfDesc2KeyPressed

    private void txfValorUnitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfValorUnitarioKeyPressed
        Utilitarios.requestFocusEnter(jdcFechaVencimiento, evt);
    }//GEN-LAST:event_txfValorUnitarioKeyPressed

    private void txfUtiMinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUtiMinKeyPressed
        Utilitarios.requestFocusEnter(txfUtiMax, evt);
    }//GEN-LAST:event_txfUtiMinKeyPressed

    private void txfUtiMaxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUtiMaxKeyPressed
        Utilitarios.requestFocusEnter(txfPrecioSugerido, evt);
    }//GEN-LAST:event_txfUtiMaxKeyPressed

    private void txfPrecioSugeridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPrecioSugeridoActionPerformed
        btnAgregar.doClick();
    }//GEN-LAST:event_txfPrecioSugeridoActionPerformed

    private void jdcFechaVencimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcFechaVencimientoKeyPressed
        Utilitarios.requestFocusEnter(txfUtiMin, evt);
    }//GEN-LAST:event_jdcFechaVencimientoKeyPressed

    private void txfPrecioUnitarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPrecioUnitarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPrecioUnitarioKeyPressed

    private void txfPrecioUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPrecioUnitarioKeyReleased
        if (oProducto != null) {
            if (!txfCantidad.getText().trim().equals("")) {
                calcularPrecioSinIgv();
                calcularPrecioCompraNeto();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Cargue los datos del producto", "Error", JOptionPane.ERROR_MESSAGE);
            txfValorUnitario.setText("");
        }
    }//GEN-LAST:event_txfPrecioUnitarioKeyReleased

    private void txfTotalUnidadesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTotalUnidadesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTotalUnidadesKeyPressed

    private void txfCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadKeyReleased
        calcularTotalProductos();
    }//GEN-LAST:event_txfCantidadKeyReleased

    private void txfUtiMinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUtiMinKeyReleased
        if (oProducto != null) {
            if (!txfValorUnitario.getText().trim().equals("") && !txfCantidad.getText().trim().equals("")) {
                calcularPrecioCompraNeto();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cargue los datos del producto", "Error", JOptionPane.ERROR_MESSAGE);
            txfValorUnitario.setText("");
        }
    }//GEN-LAST:event_txfUtiMinKeyReleased

    private void txfUtiMaxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUtiMaxKeyReleased
        if (oProducto != null) {
            if (!txfValorUnitario.getText().trim().equals("") && !txfCantidad.getText().trim().equals("")) {
                calcularPrecioCompraNeto();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cargue los datos del producto", "Error", JOptionPane.ERROR_MESSAGE);
            txfValorUnitario.setText("");
        }
    }//GEN-LAST:event_txfUtiMaxKeyReleased

    private void chbxBonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxBonoActionPerformed
        calcularTotalProductos();
    }//GEN-LAST:event_chbxBonoActionPerformed


    // Constants declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox cbxTipoComprobante;
    private javax.swing.JCheckBox chbxBono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFechaCompra;
    private com.toedter.calendar.JDateChooser jdcFechaVencimiento;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txfCantidad;
    private javax.swing.JTextField txfDesc1;
    private javax.swing.JTextField txfDesc2;
    private javax.swing.JTextField txfDescuentoItem;
    private javax.swing.JTextField txfNumeroComprobante;
    private javax.swing.JTextField txfNumeroLote;
    private javax.swing.JTextField txfPrecioSugerido;
    private javax.swing.JTextField txfPrecioUnitario;
    private javax.swing.JTextField txfProducto;
    private javax.swing.JTextField txfPvMax;
    private javax.swing.JTextField txfPvMin;
    private javax.swing.JTextField txfRazonSocial;
    private javax.swing.JTextField txfRuc;
    private javax.swing.JTextField txfSerie;
    private javax.swing.JTextField txfTotalUnidades;
    private javax.swing.JTextField txfUnidad;
    private javax.swing.JTextField txfUtiMax;
    private javax.swing.JTextField txfUtiMin;
    private javax.swing.JTextField txfValorBruto;
    private javax.swing.JTextField txfValorCompraNeto;
    private javax.swing.JTextField txfValorDescuento;
    private javax.swing.JTextField txfValorIgv;
    private javax.swing.JTextField txfValorTotal;
    private javax.swing.JTextField txfValorUnitario;
    // End of variables declaration//GEN-END:variables

    private void abrirJifBuscarProducto() {
        root.jifAdminProducto.setInvocador(JIF_AdminProducto.JIF_COMPRAS);
        root.insertarInternalFrames(root.jifAdminProducto);
        root.jifAdminProducto.inicializarJif();
    }

    void enviaDatosProducto(Producto obj) {
        oProducto = obj;
        txfProducto.setText(oProducto.getNombre());
        txfUnidad.setText(oProducto.getPresentacion().getDenominacion());
        txfCantidad.requestFocus();
    }

    private boolean isDatosValidosCompraProducto() {
        return (!txfCantidad.getText().trim().equals("")
                && !txfValorUnitario.getText().trim().equals("")
                && !txfNumeroLote.getText().trim().equals("")
                && !txfDescuentoItem.getText().trim().equals("")
                && !txfPrecioSugerido.getText().trim().equals(""));
    }

    private void paintComponentProducto() {
        Utilitarios.paintBorderTxfVacio(txfValorUnitario);
        Utilitarios.paintBorderTxfVacio(txfNumeroLote);
        Utilitarios.paintBorderTxfVacio(txfDescuentoItem);
        Utilitarios.paintBorderTxfVacio(txfPrecioSugerido);
    }

    private void resetPaintComponentProducto() {
        Utilitarios.resetPaintBorderTxf(txfValorUnitario);
        Utilitarios.resetPaintBorderTxf(txfNumeroLote);
        Utilitarios.resetPaintBorderTxf(txfDescuentoItem);
        Utilitarios.resetPaintBorderTxf(txfPrecioSugerido);
    }

    private void resetcomponentCompra() {
        oProducto = null;
        txfProducto.setText("");
        txfUnidad.setText("");
        chbxBono.setSelected(false);
        txfCantidad.setText("");
        txfTotalUnidades.setText("");
        txfValorUnitario.setText("");
        txfPrecioUnitario.setText("");
        txfNumeroLote.setText("");
        jdcFechaVencimiento.setDate(null);
        txfUtiMin.setText("25");
        txfUtiMax.setText("50");
        txfPvMin.setText("");
        txfPvMax.setText("");
        txfPrecioSugerido.setText("");
        txfDescuentoItem.setText("0.00");
        txfDesc1.setText("");
        txfDesc2.setText("");

    }

    //----------
    private void cargarCbx() {
        cargarTipoComprobanteFar();
        cargarAlmacen();
    }
    
    private void cargarTipoComprobanteFar() {
        oFarComprobanteCtrl = new FarComprobanteCtrl(root);
        oFarComprobanteCtrl.rellenaTipoComprobante(cbxTipoComprobante, FarComprobante.COMPRA);
        defaultCbxTipoComprobanteFar();

    }

    private void defaultCbxTipoComprobanteFar() {
        oFarComprobanteCtrl = new FarComprobanteCtrl(root);
        oFarComprobanteCtrl.defaultSelectCbx("factura", cbxTipoComprobante);
    }

    private void cargarAlmacen() {
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.rellenaAlmacen(cbxAlmacen);
    }

    public void cargarDatosUser(Usuario user, Persona oPersona, Rol oRol) {
        userTemp = user;
        perTemp = oPersona;
        rolTemp = oRol;
    }

    private boolean isDatosValidos() {
        return (cbxTipoComprobante.getSelectedIndex() > 0
                && !txfNumeroComprobante.getText().trim().equals("")
                && jdcFechaCompra.getDate() != null
                && oModeloCompraProducto.size() > 0
                && !txfValorBruto.getText().trim().equals("")
                && !txfValorCompraNeto.getText().trim().equals("")
                && !txfValorIgv.getText().trim().equals("")
                && !txfValorTotal.getText().trim().equals(""));
    }

    private void paintComponent() {
        Utilitarios.paintCbxVacio(cbxTipoComprobante);
        Utilitarios.paintBorderTxfVacio(txfNumeroComprobante);
        Utilitarios.paintJdcVacio(jdcFechaCompra);
        Utilitarios.paintBorderTxfVacio(txfValorBruto);
        Utilitarios.paintBorderTxfVacio(txfValorCompraNeto);
        Utilitarios.paintBorderTxfVacio(txfValorIgv);
        Utilitarios.paintBorderTxfVacio(txfValorTotal);
    }

    private void resetPaintComponent() {
        Utilitarios.resetPaintCbx(cbxTipoComprobante);
        Utilitarios.resetPaintBorderTxf(txfNumeroComprobante);
        Utilitarios.resetPaintJdc(jdcFechaCompra);
        Utilitarios.resetPaintBorderTxf(txfValorBruto);
        Utilitarios.resetPaintBorderTxf(txfValorCompraNeto);
        Utilitarios.resetPaintBorderTxf(txfValorIgv);
        Utilitarios.resetPaintBorderTxf(txfValorTotal);
    }

    private void calcularTotales() {
        /*
         Para calcular el valor de compra bruto no es necesrio aplicar  el igv a cada uno de los items
         Entonces dicho calculo  se realizará  al margen de que comnprobante sea
         */
        valorBruto = valorBruto.add(oDetalleCompra.getPrecioCompra().setScale(2, RoundingMode.HALF_UP));
        valor_desc_total = valor_desc_total.add(oDetalleCompra.getDescuentoItem());
        valorNeto = valorBruto.subtract(valor_desc_total);
        if (cbxTipoComprobante.getSelectedItem().toString().equals("FACTURA")) {
            valorIgv = valorNeto.multiply(IGV).setScale(2, RoundingMode.HALF_UP);
            valorTotal = valorNeto.add(valorIgv).setScale(2, RoundingMode.HALF_UP);
        } else {
            valorIgv = new BigDecimal("0.00");
            valorTotal = valorNeto.add(valorIgv).setScale(2, RoundingMode.HALF_UP);
        }
        txfValorBruto.setText(valorBruto.toString());
        txfValorDescuento.setText(valor_desc_total.toString());
        txfValorCompraNeto.setText(valorNeto.toString());
        txfValorIgv.setText(valorIgv.toString());
        txfValorTotal.setText(valorTotal.toString());
    }

    private void calularValorNeto() {
        valorDescuento = new BigDecimal(txfValorDescuento.getText().trim());
        valorNeto = valorBruto.subtract(valorDescuento).setScale(2, RoundingMode.HALF_UP);
        if (cbxTipoComprobante.getSelectedItem().toString().equals("FACTURA")) {
            valorIgv = valorNeto.multiply(IGV).setScale(2, RoundingMode.HALF_UP);
            valorTotal = valorNeto.add(valorIgv).setScale(2, RoundingMode.HALF_UP);
        } else {
            valorIgv = new BigDecimal("0.00");
            valorTotal = valorNeto.add(valorIgv).setScale(2, RoundingMode.HALF_UP);
        }

        //setear campos
        txfValorCompraNeto.setText(valorNeto.toString());
        txfValorIgv.setText(valorIgv.toString());
        txfValorTotal.setText(valorTotal.toString());
    }

    private void resetTotales() {
        txfValorBruto.setText("0.00");
        txfValorDescuento.setText("");
        txfValorCompraNeto.setText("0.00");
        txfValorIgv.setText("0.00");
        txfValorTotal.setText("0.00");
    }

    private void recalcularMontos() {
        beanTabla = oModeloCompraProducto.get(tblProductos.getSelectedRow());
        oModeloCompraProducto.remove(tblProductos.getSelectedRow());
        //Quitar tambien del modelo almacenProducto 
        //quitarAlmacenProducto(filaSelect);
        valorBruto = valorBruto.subtract(beanTabla.getPrecioCompra());
        resetTotales();
        txfValorBruto.setText(valorBruto.toString());
    }

    private void agregarDetalleCompra() {
        oDetalleCompra = new DetalleCompra();
        oDetalleCompra.setProducto(oProducto);
        //Cantidad por unidad de medida
        oDetalleCompra.setCantidad(Integer.parseInt(txfCantidad.getText().trim()));
        oDetalleCompra.setIsUnitario(isUnitario());
        oDetalleCompra.setLote(txfNumeroLote.getText().toUpperCase().trim());
        oDetalleCompra.setFechaVencimiento(jdcFechaVencimiento.getDate());
        //almacena el valor de compra unitario
        oDetalleCompra.setValorCompraUnitario(new BigDecimal(txfValorUnitario.getText().trim()));
        oDetalleCompra.setDescuentoItem(valor_desc_item);
        oDetalleCompra.setPrecioCompra(oDetalleCompra.getValorCompraUnitario().multiply(new BigDecimal(txfCantidad.getText().trim())));
        oDetalleCompra.setPorcDesc1(txfDesc1.getText().trim().equals("") ? 0 : Double.valueOf(txfDesc1.getText().trim()));
        oDetalleCompra.setPorcDesc2(txfDesc2.getText().trim().equals("") ? 0 : Double.valueOf(txfDesc2.getText().trim()));
        oDetalleCompra.setIgvItem(valor_igv_item);

        //valores de venta temporales
        oDetalleCompra.setPvMin(new BigDecimal(txfPvMin.getText().trim()));
        oDetalleCompra.setPvMax(new BigDecimal(txfPvMax.getText().trim()));
        oDetalleCompra.setPvSugerido(new BigDecimal(txfPrecioSugerido.getText().trim()));
        //fin de temporales

        oModeloCompraProducto.add(oDetalleCompra);
        recalculaDescuentoTotal(oDetalleCompra.getDescuentoItem());
    }

    private void resetComponentFull() {
        defaultCbxTipoComprobanteFar();
        txfSerie.setText("");
        txfNumeroComprobante.setText("");
        jdcFechaCompra.setDate(null);
        txfCantidad.setText("");
        txfValorUnitario.setText("");
        txfNumeroLote.setText("");
        jdcFechaVencimiento.setDate(null);
        txfDescuentoItem.setText("0.00");
        txfUtiMin.setText("25");
        txfUtiMax.setText("50");
        txfPvMin.setText("");
        txfPvMax.setText("");
        txfPrecioSugerido.setText("");
        oModeloCompraProducto.clear();
        txfValorBruto.setText("0.00");
        txfValorDescuento.setText("0.00");
        txfValorCompraNeto.setText("0.00");
        txfValorIgv.setText("0.00");
        txfValorTotal.setText("0.00");
        txfRuc.setText("");
        txfRazonSocial.setText("");
        if (oPersonaProveedor != null) {
            oPersonaProveedor = null;
        }
        personalizaTabla();
        resetcomponentCompra();
        resetPaintComponent();
        resetPaintComponentProducto();
        resetValoresTotales();
    }

    public void personalizaTabla() {
        Utilitarios.formateaColumna(0, tblProductos, 50);
        Utilitarios.formateaColumna(2, tblProductos, 70);
        Utilitarios.formateaColumna(3, tblProductos, 70);
        Utilitarios.formateaColumna(4, tblProductos, 100);
        Utilitarios.formateaColumna(5, tblProductos, 90);
        Utilitarios.formateaColumna(6, tblProductos, 70);
        Utilitarios.formateaColumna(7, tblProductos, 90);
        Utilitarios.formateaColumna(8, tblProductos, 90);
        Utilitarios.alinearDatosColumnaTablaCentro(2, tblProductos);
        Utilitarios.alinearDatosColumnaTablaCentro(3, tblProductos);
        Utilitarios.alinearDatosColumnaTablaCentro(4, tblProductos);
        Utilitarios.alinearDatosColumnaTablaDerecha(5, tblProductos);
        Utilitarios.alinearDatosColumnaTablaDerecha(6, tblProductos);
        Utilitarios.alinearDatosColumnaTablaDerecha(7, tblProductos);
        Utilitarios.alinearDatosColumnaTablaDerecha(8, tblProductos);
    }

    private void resetValoresTotales() {
        valorBruto = new BigDecimal("0.00");
        valorDescuento = new BigDecimal("0.00");
        valorNeto = new BigDecimal("0.00");
        valorIgv = new BigDecimal("0.00");
        valorTotal = new BigDecimal("0.00");

        //
        valorUnitario = new BigDecimal("0.00");
        cant = new BigDecimal("0.00");
        fra = new BigDecimal("0.00");
        valor_compra = new BigDecimal("0.00");
        desc_unico = 0;
        valor_desc_item = new BigDecimal("0.00");
        valor_desc_total = new BigDecimal("0.00");
        valor_total = new BigDecimal("0.00");;
        prec_compra_fraccion = new BigDecimal("0.00");
        prec_compra_unidad = new BigDecimal("0.00");
    }

    private void recalculaDescuentoTotal(BigDecimal descuentoItem) {
        valorDescuento = valorDescuento.add(descuentoItem);
        txfValorDescuento.setText(valorDescuento.toString());
    }

    private void calcularPrecioCompraNeto() {
        //Valor unitario sin IGV
        valorUnitario = new BigDecimal(txfValorUnitario.getText().trim()).setScale(2, RoundingMode.HALF_UP);
        cant = new BigDecimal(txfCantidad.getText().trim()).setScale(2, RoundingMode.HALF_UP);
        fra = new BigDecimal(oProducto.getFraccion().toString()).setScale(2, RoundingMode.HALF_UP);
        valor_compra = valorUnitario.multiply(cant).setScale(2, RoundingMode.HALF_UP);
        //Variables para capturar los valores de los descuentos respectivos
        Double desc1;
        Double desc2;
        desc1 = txfDesc1.getText().trim().equals("") ? 0 : Double.valueOf(txfDesc1.getText().trim());
        desc2 = txfDesc2.getText().trim().equals("") ? 0 : Double.valueOf(txfDesc2.getText().trim());
        // desc_unico almacena el valor del descuento en porcentaje basado en la formula de descuento unico
        desc_unico = ((desc1 + desc2) - (desc1 * desc2) / 100);
        valor_desc_item = valor_compra.multiply((new BigDecimal(desc_unico)).divide(CIEN, 4, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
        //Aplicado a  la diferencia entre el valor_compra - Valor descuento item
        valor_igv_item = (valor_compra.subtract(valor_desc_item)).multiply(IGV).setScale(2, RoundingMode.HALF_UP);
        //
        valor_total_item = valor_compra.subtract(valor_desc_item).setScale(2, RoundingMode.HALF_UP);
        //Precio de compra por fraccion
        prec_compra_fraccion = valor_total_item.divide(cant, 2, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
        //Precio de compra unitario --> para calcular los precios de venta
        prec_compra_unidad = prec_compra_fraccion.divide(fra, 4, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
        //monto real pagado por item
        /*
        System.out.println("-----------------------------------------------------");
        System.out.println("Valor Unitario " + valorUnitario);
        System.out.println("Cantidad " + cant);
        System.out.println("Fraccion " + fra);
        System.out.println("Valor compra " + valor_compra);
        System.out.println("Valor desc item " + valor_desc_item);
        System.out.println("Valor igv item " + valor_igv_item);
        System.out.println("valor con descuento  " + valor_total_item);
        System.out.println("Precio de compra unitario  " + prec_compra_unidad);
         */
        calcularPreciosVenta(prec_compra_unidad);
    }

    private void calcularPreciosVenta(BigDecimal prec_compra_unidad) {
        //se debe agregar el igv para obtener  el precio  de venta
        BigDecimal igv = prec_compra_unidad.multiply(IGV);
        BigDecimal precioMasIGV = prec_compra_unidad.add(igv);
        pvMin = precioMasIGV.add(precioMasIGV.multiply(txfUtiMin.getText().trim().equals("") ? BigDecimal.ZERO : new BigDecimal(txfUtiMin.getText().trim())).divide(CIEN, 2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
        txfPvMin.setText(pvMin.toString());

        pvMax = precioMasIGV.add(precioMasIGV.multiply(txfUtiMax.getText().trim().equals("") ? BigDecimal.ZERO : new BigDecimal(txfUtiMax.getText().trim())).divide(CIEN, 2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
        txfPvMax.setText(pvMax.toString());
        //Formula comercial que permite obtener mejores utilidades
        /*
         pvMin = (prec_compra_unidad.divide(CIEN.subtract(new BigDecimal(jsMin.getValue().toString())), 4, RoundingMode.HALF_UP)).multiply(CIEN).setScale(2, RoundingMode.HALF_UP);
         txfPvMin.setText(pvMin.toString());

         pvMax = (prec_compra_unidad.divide(CIEN.subtract(new BigDecimal(jsMax.getValue().toString())), 4, RoundingMode.HALF_UP)).multiply(CIEN).setScale(2, RoundingMode.HALF_UP);
         txfPvMax.setText(pvMax.toString());
         */
    }

    private void buscarXRuc() {
        String ref = txfRuc.getText().toUpperCase().trim();
        if (!ref.equals("")) {
            buscarPersonaXRuc(ref);
        } else {
            Mensajes.msjParametroVacio();
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
            Mensajes.ErrorReporte(ex);
            //Logger.getLogger(JIF_Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void calcularPrecioConIgv() {
        BigDecimal valorUnitario = txfValorUnitario.getText().trim().equals("") ? new BigDecimal("0.00") : new BigDecimal(txfValorUnitario.getText().trim()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal precioUnitario = valorUnitario.add(valorUnitario.multiply(Constants.IGV)).setScale(2, RoundingMode.HALF_UP);
        txfPrecioUnitario.setText(precioUnitario.toString());
    }

    private void calcularPrecioSinIgv() {
        BigDecimal precioUnitario = txfPrecioUnitario.getText().trim().equals("") ? new BigDecimal("0.00") : new BigDecimal(txfPrecioUnitario.getText().trim()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal valorUnitario = precioUnitario.divide(Constants.CIEN_IGV, RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);

        txfValorUnitario.setText(valorUnitario.toString());
    }

    private void calcularTotalUnidades() {
        int totalUnidades = Integer.parseInt(txfCantidad.getText().trim());
        txfTotalUnidades.setText(totalUnidades + "");
    }

    private void calcularTotalUnidadesXFraccion() {
        if (oProducto != null) {
            int totalUnidades = Integer.parseInt(txfCantidad.getText().trim()) * oProducto.getFraccion();
            txfTotalUnidades.setText(totalUnidades + "");
        }

    }

    private boolean isUnitario() {
        return chbxBono.isSelected();
    }

    private void calcularTotalProductos() {
        if (!txfCantidad.getText().trim().equals("") && oProducto != null) {
            if (chbxBono.isSelected()) {
                calcularTotalUnidades();
            } else {
                calcularTotalUnidadesXFraccion();
            }
        } else {
            txfCantidad.setText("");
        }
    }

    private void buscarPersonaXRuc(String ref) {
        oPersonaBl = new PersonaBl();
        oPersonaProveedor = oPersonaBl.buscarPersonaXRuc(ref);
        if (oPersonaProveedor != null) {
            txfRazonSocial.setText(!oPersonaProveedor.getRazonSocial().trim().equals("") ? oPersonaProveedor.getRazonSocial().trim() : oPersonaProveedor.getNombre().trim() + " " + oPersonaProveedor.getApellidoPaterno().trim() + " " + oPersonaProveedor.getApellidoMaterno().trim());
            txfRuc.setText(oPersonaProveedor.getRuc().trim());
        } else {
            insertarJifBuscaPersonaProveedor(ref);
        }
    }

    private void insertarJifBuscaPersonaProveedor(String ref) {
        int op;
        op = JOptionPane.showConfirmDialog(null, "No Existe persona con N° Doc : " + ref + " \n¿Desea registrar a la persona?", "Atención", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            root.jifAdministrarPersonanatural.setInvocador(JIF_AdministrarPersonaNatural.JIF_COMPRAS);
            root.insertarInternalFrames(root.jifAdministrarPersonanatural);
            root.jifAdministrarPersonanatural.inicializar();
        }
    }

    public void cargarDatosProveedor(Persona beanTabla) {
        oPersonaProveedor = beanTabla;
        txfRazonSocial.setText(!oPersonaProveedor.getRazonSocial().trim().equals("") ? oPersonaProveedor.getRazonSocial().trim() : oPersonaProveedor.getNombre().trim() + " " + oPersonaProveedor.getApellidoPaterno().trim() + " " + oPersonaProveedor.getApellidoMaterno().trim());
        txfRuc.setText(oPersonaProveedor.getRuc().trim());
    }

    private void registrar() {
        int r = -1;
        if (isDatosValidos()) {
            oCompra = new Compra();
            oCompraBl = new CompraBl();
            //Buscar el id comprobante segun denominacion
            if (cbxTipoComprobante.getSelectedIndex() != 0) {
                oCompra.setFarComprobante((FarComprobante) cbxTipoComprobante.getSelectedItem());
            }
            oCompra.setPersonaProveedor(oPersonaProveedor);
            oCompra.setNumeroComprobante(txfNumeroComprobante.getText().toUpperCase().trim());
            oCompra.setFechaCompra(jdcFechaCompra.getDate());
            oCompra.setSerie(txfSerie.getText().toUpperCase().trim());
            //Mandar la hora de registro del sistema de forma automatica
            oCompra.setHoraReg(Utilitarios.horaActual());
            oCompra.setFechaReg(new Date());
            oCompra.setValorBruto(new BigDecimal(txfValorBruto.getText().toUpperCase().trim()));
            oCompra.setValorDescuento(new BigDecimal(txfValorDescuento.getText().toUpperCase().trim()));
            oCompra.setValorNeto(new BigDecimal(txfValorCompraNeto.getText().toUpperCase().trim()));
            oCompra.setValorIgv(new BigDecimal(txfValorIgv.getText().toUpperCase().trim()));
            oCompra.setValorTotal(new BigDecimal(txfValorTotal.getText().toUpperCase().trim()));
            oCompra.setEstado("ACT");
            oCompra.setMotivoAunulacion("");
            //Buscar el maximo numero de compra
            oCompra.setUsuarioReg(userTemp);
            r = oCompraBl.registrar(oCompra, oModeloCompraProducto);
            if (r == Constants.SUCCESS) {
                Mensajes.msjRegCorrecta();
                imprimirComprobante(oCompra);
                resetComponentFull();                
            }

        } else {
            Mensajes.msjValidarIngreso();
            paintComponent();
        }
        personalizaTabla();
    }

    public void inicializar() {
        cargarCbx();
        oAlmacenCtrl = new AlmacenCtrl(root);
        oAlmacenCtrl.defaultSelectAlmacen("almacen", cbxAlmacen);
        resetComponentFull();
    }

}
