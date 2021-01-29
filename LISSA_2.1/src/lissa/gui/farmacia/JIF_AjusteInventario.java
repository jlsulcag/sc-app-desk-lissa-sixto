package lissa.gui.farmacia;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.AlmacenProducto;
import lissa.be.Kardex;
import lissa.be.PrecioProducto;
import lissa.bl.AlmacenProductoBl;
import lissa.bl.KardexBl;
import lissa.bl.PrecioProductoBl;
import lissa.gui.JF_Principal;
import lissa.table.ModeloBusqProducto;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_AjusteInventario extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloBusqProducto oModeloBusqProducto;
    private List<AlmacenProducto> listAlmacenProducto;
    private AlmacenProducto oAlmacenProducto;
    private AlmacenProductoBl oAlmacenProductoBl;
    private Kardex oKardex;
    private KardexBl oKardexBl;
    private PrecioProducto oPrecioProducto;
    private PrecioProductoBl oPrecioProductoBl;

    public JIF_AjusteInventario(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloBusqProducto = new ModeloBusqProducto();
        tblResultados.setModel(oModeloBusqProducto);
        personalizaTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txfBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfStockActual = new javax.swing.JTextField();
        txfStockFisico = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txfMotivoAjuste = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txfDiferencia = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Ajuste de Inventario");

        jLabel2.setText("Producto :");

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Operación"));

        jLabel1.setText("Stock Actual :");

        jLabel3.setText("Stock Fisico :");

        txfStockActual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfStockActual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfStockActual.setEnabled(false);

        txfStockFisico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfStockFisico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfStockFisico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfStockFisicoKeyReleased(evt);
            }
        });

        jLabel4.setText("Motivo Ajuste :");

        jLabel5.setText("Diferencia :");

        txfDiferencia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfDiferencia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfDiferencia.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txfStockActual, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfStockFisico, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txfMotivoAjuste))
                .addContainerGap(422, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txfMotivoAjuste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txfStockActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txfStockFisico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txfDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
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
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
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
                    .addComponent(jLabel2)
                    .addComponent(txfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        obtenerDatos();
    }//GEN-LAST:event_tblResultadosMouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        guardarDatos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txfStockFisicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfStockFisicoKeyReleased
        Utilitarios.validaCaracterNumerico(evt, txfStockFisico);
        if (!txfStockFisico.getText().trim().equals("")) {
            calcularDiferencia();
        } else {
            txfDiferencia.setText("");
        }
    }//GEN-LAST:event_txfStockFisicoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        resetComponent();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txfBusqueda;
    private javax.swing.JTextField txfDiferencia;
    private javax.swing.JTextField txfMotivoAjuste;
    private javax.swing.JTextField txfStockActual;
    private javax.swing.JTextField txfStockFisico;
    // End of variables declaration//GEN-END:variables

    private void personalizaTabla() {
        Utilitarios.formateaColumna(0, tblResultados, 50);
        Utilitarios.formateaColumna(2, tblResultados, 150);
        Utilitarios.formateaColumna(3, tblResultados, 150);
        Utilitarios.formateaColumna(4, tblResultados, 50);
        Utilitarios.formateaColumna(5, tblResultados, 70);
        Utilitarios.formateaColumna(6, tblResultados, 70);
        Utilitarios.formateaColumna(7, tblResultados, 70);
        Utilitarios.formateaColumna(8, tblResultados, 100);
        Utilitarios.alinearDatosColumnaTablaCentro(4, tblResultados);
        Utilitarios.alinearDatosColumnaTablaDerecha(7, tblResultados);

    }

    private void buscar() {
        listAlmacenProducto = new LinkedList<>();
        oAlmacenProductoBl = new AlmacenProductoBl();
        oModeloBusqProducto.clear();
        if (!txfBusqueda.getText().trim().equals("")) {
            listAlmacenProducto = oAlmacenProductoBl.listRef(txfBusqueda.getText().toUpperCase().trim());
            if (!listAlmacenProducto.isEmpty()) {
                for (AlmacenProducto obj : listAlmacenProducto) {
                    oModeloBusqProducto.add(obj);
                }
            }
        }
    }

    private void obtenerDatos() {
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            oAlmacenProducto = oModeloBusqProducto.get(tblResultados.getSelectedRow());
            imprimeValores(oAlmacenProducto);
        }
    }

    private void imprimeValores(AlmacenProducto oAlmacenProducto) {
        txfStockActual.setText(oAlmacenProducto.getStockActual().toString());

    }

    private void guardarDatos() {
        int r = -1;
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            if (isdatosValidosStock()) {
                //Metodo transaccional para ajuste de inventario
                AlmacenProducto temp = new AlmacenProducto();
                AlmacenProductoBl oAlmacenProductoBl = new AlmacenProductoBl();
                oAlmacenProducto = oModeloBusqProducto.get(tblResultados.getSelectedRow());
                temp = oAlmacenProducto;
                temp.setStockActual(new BigDecimal(txfStockFisico.getText().trim()));
                //set kardex
                Kardex kardex = new Kardex();
                kardex.setCantidad(new BigDecimal(txfDiferencia.getText().trim()));
                kardex.setObservacion(txfMotivoAjuste.getText().trim().toUpperCase());
                r = oAlmacenProductoBl.ajustar(temp, kardex);
                if (r == 1) {
                    Mensajes.msjRegCorrecta();
                    resetComponent();
                } else {
                    Mensajes.msjRegError();
                }
                /*
                 ///////////////////////////////////////////////////////////////////////////////////
                 //if (Integer.parseInt(txfDiferencia.getText().trim()) != 0) {
                 oAlmacenProducto = oModeloBusqProducto.get(tblResultados.getSelectedRow());
                 //Actualizar  stock de almacen
                 //AlmacenProducto temp = new AlmacenProducto();
                 //AlmacenProductoBl oAlmacenProductoBl = new AlmacenProductoBl();

                 temp = oAlmacenProducto;
                 temp.setStockActual(new BigDecimal(txfStockFisico.getText().trim()));
                 int res = -1;
                 res = oAlmacenProductoBl.actualizar(temp);
                 if (res == 0) {//Actualizacion exitosa
                 //Generar kardex por ajuste de inventario
                 Kardex obj = new Kardex();
                 obj = registrarKardex(temp);
                 if (obj.getIdkardex() != 0) {
                 Mensajes.msjRegCorrecta();
                 resetComponent();
                 } else {
                 Mensajes.msjRegError();
                 }
                 } else {
                 Mensajes.msjActErronea();
                 }
                 //} else {
                 //JOptionPane.showMessageDialog(null, "No existen cambios de stock", "Atención", JOptionPane.INFORMATION_MESSAGE);
                 //}
                 */
            } else {
                Mensajes.msjValidarIngreso();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe item seleccionado", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private Kardex registrarKardex(AlmacenProducto temp) {
        oKardex = new Kardex();
        oKardexBl = new KardexBl();
        oKardex.setAlmacenByIdOrigen(null);
        oKardex.setAlmacenByIdDestino(null);
        oKardex.setIdFarcomprobante(null);
        oKardex.setOperacion("AJUSTE DE INVENTARIO");
        oKardex.setFechaMov(new Date());
        oKardex.setHoraMov("");
        if ((new BigDecimal(txfDiferencia.getText().trim())).compareTo(BigDecimal.ZERO) == 1) {
            oKardex.setTipoOperacion("SALIDA");
        } else {
            oKardex.setTipoOperacion("ENTRADA");
        }
        oKardex.setIdAlmacenAfectado(temp.getAlmacen().getIdalmacen());
        oKardex.setComprobante("");
        oKardex.setNumSerie("");
        oKardex.setOrigen("");
        oKardex.setDestino("");
        oKardex.setObservacion(txfMotivoAjuste.getText().trim().toUpperCase());
        oKardex.setNumComprobante(0);
        oKardex.setGrupoNumeracion(1);
        oKardex.setIdProducto(Long.parseLong(temp.getProducto().getIdproducto() + ""));
        oKardex.setCantidad((new BigDecimal(txfDiferencia.getText().trim())).abs());
        //Buscar precio actual del producto
        oPrecioProducto = new PrecioProducto();
        oPrecioProductoBl = new PrecioProductoBl();
        oPrecioProducto = oPrecioProductoBl.buscarxIdAlmacenProducto(temp.getIdalmacenproducto());
        if (oPrecioProducto != null) {
            oKardex.setValorUnit(oPrecioProducto.getPvSugerido());
        }
        //fin busqueda de precio actual
        oKardex.setIdAlmacenproducto(temp.getIdalmacenproducto());
        oKardex.setEstado(1);
        //Obtener el ultimo numero de orden de registro de kardex
        long nro = oKardexBl.nroOrdenregistro(oKardex.getIdProducto());
        oKardex.setNroOrden(nro + 1);
        //Obtener stock  actual del producto
        oAlmacenProductoBl = new AlmacenProductoBl();
        AlmacenProducto ap = oAlmacenProductoBl.buscar(temp.getIdalmacenproducto());
        oKardex.setStockActual(ap.getStockActual());

        oKardexBl.registrar(oKardex);

        return oKardex;

    }

    private void calcularDiferencia() {
        try {
            BigDecimal diferencia = BigDecimal.ZERO;
            diferencia = (new BigDecimal(txfStockActual.getText().trim())).subtract(new BigDecimal(txfStockFisico.getText().trim())).setScale(2, RoundingMode.HALF_UP);
            //diferencia = Integer.valueOf(txfStockActual.getText().trim()) - Integer.valueOf(txfStockFisico.getText().trim());
            txfDiferencia.setText(diferencia.toString());
        } catch (Exception e) {
            Mensajes.ErrorGenerico(e);
        }

    }

    private boolean isdatosValidosStock() {
        return (!txfStockActual.getText().trim().equals("")
                && !txfStockFisico.getText().trim().equals(""));
    }

    private void resetComponent() {
        txfBusqueda.setText("");
        oModeloBusqProducto.clear();
        txfMotivoAjuste.setText("");
        txfStockActual.setText("");
        txfStockFisico.setText("");
        txfDiferencia.setText("");
        personalizaTabla();
    }

    public void iniciar() {
        resetComponent();
    }
}
