package lissa.gui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;
import lissa.be.Caja;
import lissa.be.Egreso;
import lissa.be.EgresoDetalle;
import lissa.be.Persona;
import lissa.be.Usuario;
import lissa.bl.CajaBl;
import lissa.bl.EgresoBl;
import lissa.bl.EgresoDetalleBl;
import lissa.table.ModeloEgresoDetalle;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

/**
 *
 * @author JSULCAG
 */
public class JIF_Egresos extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private Usuario oUsuario;
    private Persona oPersona;
    private Egreso oEgreso;
    private EgresoBl oEgresoBl;
    private CajaBl oCajaBl;
    private Caja oCaja;
    private ModeloEgresoDetalle oModeloEgresoDetalle;
    private List<EgresoDetalle> listEgresoDetalle;
    private EgresoDetalle oEgresoDetalle;
    private EgresoDetalleBl oEgresoDetalleBl;
    public static final int SUCESS = 1, ERROR = -1;

    public JIF_Egresos(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloEgresoDetalle = new ModeloEgresoDetalle();
        tblDetalle.setModel(oModeloEgresoDetalle);
        listEgresoDetalle = new LinkedList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        cbxMotivo = new javax.swing.JComboBox();
        txfEspecifique = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txfNumeroComprobante = new javax.swing.JTextField();
        txfObservacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txfCorrespondea = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txfTipoComprobante = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txfDescripcion = new javax.swing.JTextField();
        txfCantidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txfimporte = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txfMonto = new javax.swing.JTextField();

        jTextField2.setText("jTextField2");

        setClosable(true);
        setTitle("Registrar Egreso");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Concepto Egreso"));

        jLabel1.setText("Número :");

        txfNumero.setEnabled(false);
        txfNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfNumeroKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNumeroKeyReleased(evt);
            }
        });

        jLabel2.setText("Fecha : ");

        jLabel3.setText("Motivo :");

        cbxMotivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<SELECCIONE>", "COMPRAS", "DECLARACIÓN JURADA", "OTROS", " " }));

        jLabel4.setText("Especifique :");

        jLabel5.setText("N° Comprobante :");

        jLabel7.setText("Observación :");

        jLabel8.setText("Corresponde a :");

        txfCorrespondea.setEnabled(false);

        jLabel9.setText("Tipo Comprobante :");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(37, 37, 37)
                        .addComponent(txfObservacion))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txfCorrespondea)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txfTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfNumeroComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbxMotivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfEspecifique)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txfEspecifique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txfCorrespondea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txfTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txfNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txfObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        jLabel6.setText("Descripción : ");

        jLabel10.setText("Cantidad : ");

        txfCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCantidadActionPerformed(evt);
            }
        });
        txfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCantidadKeyReleased(evt);
            }
        });

        jLabel11.setText("Importe : ");

        txfimporte.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfimporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfimporteKeyReleased(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/remove.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfimporte, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel10)
                        .addComponent(txfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txfimporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDetalle);

        jLabel12.setText("Total :");

        txfMonto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfMonto.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(txfMonto, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jButton1)
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

    private void txfNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNumeroKeyPressed

    }//GEN-LAST:event_txfNumeroKeyPressed

    private void txfNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNumeroKeyReleased
        Utilitarios.requestFocusEnter(jdcFecha, evt);
    }//GEN-LAST:event_txfNumeroKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        registrar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        buscarPersona();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        agregar();
        personalizaVistaTabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        quitar();
        personalizaVistaTabla();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txfCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCantidadActionPerformed

    private void txfCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadKeyReleased
        Utilitarios.validaCaracterNumerico(evt, txfCantidad);
    }//GEN-LAST:event_txfCantidadKeyReleased

    private void txfimporteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfimporteKeyReleased
        Utilitarios.validaCaracterNumericoMoneda(evt, txfimporte);
    }//GEN-LAST:event_txfimporteKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxMotivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTable tblDetalle;
    private javax.swing.JTextField txfCantidad;
    private javax.swing.JTextField txfCorrespondea;
    private javax.swing.JTextField txfDescripcion;
    private javax.swing.JTextField txfEspecifique;
    private javax.swing.JTextField txfMonto;
    private javax.swing.JTextField txfNumero;
    private javax.swing.JTextField txfNumeroComprobante;
    private javax.swing.JTextField txfObservacion;
    private javax.swing.JTextField txfTipoComprobante;
    private javax.swing.JTextField txfimporte;
    // End of variables declaration//GEN-END:variables

    void enviaUser(Usuario user) {
        this.oUsuario = user;
    }

    void inicializar() {
        txfNumero.setText(Utilitarios.numberFormat(obtenerNumero(), "######") + "");
        Utilitarios.fechaActual(jdcFecha);
        cbxMotivo.setSelectedIndex(0);
        txfEspecifique.setText("");
        txfCorrespondea.setText("");
        txfTipoComprobante.setText("");
        txfNumeroComprobante.setText("");
        txfMonto.setText("");
        txfObservacion.setText("");
        if (oPersona != null) {
            oPersona = null;
        }
        oModeloEgresoDetalle.clear();
        listEgresoDetalle = new LinkedList<>();
        personalizaVistaTabla();
    }

    private long obtenerNumero() {
        oEgresoBl = new EgresoBl();
        return oEgresoBl.numeroSig();
    }

    private void registrar() {
        oEgresoBl = new EgresoBl();
        oCajaBl = new CajaBl();
        if (isDatosValidos()) {
            oEgreso = new Egreso();
            oEgreso.setNumero(obtenerNumero());
            oEgreso.setFecha(jdcFecha.getDate());
            oEgreso.setMotivo(cbxMotivo.getSelectedItem().toString());
            oEgreso.setMotivoOtros(txfEspecifique.getText().trim().equals("") ? "" : txfEspecifique.getText().trim().toUpperCase());
            oEgreso.setTipoComprobante(txfTipoComprobante.getText().trim().equals("") ? "" : txfTipoComprobante.getText().trim().toUpperCase());
            oEgreso.setNroComprobante(txfNumeroComprobante.getText().trim().equals("") ? "" : txfNumeroComprobante.getText().trim().toUpperCase());
            oEgreso.setMonto(new BigDecimal(txfMonto.getText().trim()));
            oEgreso.setObservacion(txfObservacion.getText().trim().equals("") ? "" : txfObservacion.getText().trim().toUpperCase());
            oEgreso.setIdUsuario(oUsuario.getIdUsuario());
            oCaja = oCajaBl.buscarPorIdusuario(oUsuario);
            if (oCaja != null) {
                oEgreso.setIdCajaafecto(Long.parseLong(oCaja.getIdcaja() + ""));
            }
            if (oPersona != null) {
                oEgreso.setIdPersona(oPersona.getIdpersona());
            }
            oEgreso.setEstado(1);
            oEgreso = oEgresoBl.registrar(oEgreso);
            if (oEgreso != null) {
                if (registrarEgresoDetalle(oEgreso) == 1) {
                    Mensajes.msjRegCorrecta();
                    inicializar();
                } else {
                    Mensajes.msjRegError();
                }
            } else {
                Mensajes.msjRegError();
            }
        } else {

        }
    }

    private boolean isDatosValidos() {
        return (!txfNumero.getText().trim().equals("")
                && jdcFecha.getDate() != null
                && cbxMotivo.getSelectedIndex() > 0
                && !txfMonto.getText().trim().equals("")
                && oModeloEgresoDetalle.size() > 0);
    }

    private void buscarPersona() {
        root.jifBuscarPersonaNatural.setInvocador(JIF_BuscarPersonaNatural.JIF_EGRESOS);
        root.insertarInternalFrames(root.jifBuscarPersonaNatural);
        root.jifBuscarPersonaNatural.inicializar();
    }

    void cargarDatosPersona(Persona beanTabla) {
        oPersona = beanTabla;
        if (oPersona != null) {
            txfCorrespondea.setText(oPersona.getNombre().trim() + " " + oPersona.getApellidoPaterno().trim() + " " + oPersona.getApellidoMaterno().trim());
        }
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblDetalle, 50);
        Utilitarios.formateaColumna(2, tblDetalle, 70);
        Utilitarios.formateaColumna(3, tblDetalle, 70);

        Utilitarios.alinearDatosColumnaTablaDerecha(3, tblDetalle);
    }

    private void agregar() {
        if (idDatosValidosDetalle()) {
            oEgresoDetalle = new EgresoDetalle();
            oEgresoDetalle.setDescripcion(txfDescripcion.getText().trim().toUpperCase());
            oEgresoDetalle.setCantidad(Integer.parseInt(txfCantidad.getText().trim()));
            oEgresoDetalle.setMonto((new BigDecimal(txfimporte.getText().trim())).setScale(2, RoundingMode.HALF_UP));
            oModeloEgresoDetalle.add(oEgresoDetalle);
            listEgresoDetalle.add(oEgresoDetalle);
            calcularTotal(listEgresoDetalle);
            resetComponentesDetalle();
        } else {
            Mensajes.msjValidarIngreso();
        }
    }

    private boolean idDatosValidosDetalle() {
        return (!txfDescripcion.getText().trim().equals("")
                && !txfCantidad.getText().trim().equals("")
                && !txfimporte.getText().trim().equals(""));
    }

    private void calcularTotal(List<EgresoDetalle> listEgresoDetalle) {
        BigDecimal total = new BigDecimal("0.00");
        if (!listEgresoDetalle.isEmpty()) {
            for (EgresoDetalle obj : listEgresoDetalle) {
                total = total.add(obj.getMonto());
                txfMonto.setText(total.toString());
            }
        } else {
            txfMonto.setText(total.toString());
        }
    }

    private void resetComponentesDetalle() {
        txfDescripcion.setText("");
        txfCantidad.setText("");
        txfimporte.setText("");
    }

    private int registrarEgresoDetalle(Egreso oEgreso) {
        //oEgresoDetalle = new EgresoDetalle();
        oEgresoDetalleBl = new EgresoDetalleBl();
        for (EgresoDetalle obj : listEgresoDetalle) {
            oEgresoDetalle = obj;
            oEgresoDetalle.setEgreso(oEgreso);
            oEgresoDetalleBl.registrar(oEgresoDetalle);
        }
        return SUCESS;
    }

    private void quitar() {
        if (tblDetalle.getRowSelectionAllowed() && tblDetalle.getSelectedRow() != -1) {
            listEgresoDetalle.remove(oModeloEgresoDetalle.get(tblDetalle.getSelectedRow()));
            calcularTotal(listEgresoDetalle);
            oModeloEgresoDetalle.remove(tblDetalle.getSelectedRow());
        } else {
            Mensajes.tblSelected();
        }
    }
}
