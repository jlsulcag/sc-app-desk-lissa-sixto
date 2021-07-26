package lissa.gui;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lissa.be.Atencion;
import lissa.be.Beneficio;
import lissa.be.Caja;
import lissa.be.Comprobante;
import lissa.be.ComprobanteDetalle;
import lissa.be.FondoSolidaridad;
import lissa.be.Persona;
import lissa.be.TipoComprobante;
import lissa.be.TipoDocidentidad;
import lissa.be.Usuario;
import lissa.bl.BoletaBl;
import lissa.bl.ComprobanteBl;
import lissa.bl.ItemsComprobanteBl;
import lissa.bl.OrganizacionBl;
import lissa.bl.PersonaBl;
import lissa.controller.TipoComprobanteCtrl;
import lissa.controller.TipoDocIdentidadCtrl;
import lissa.ds.DSConeccion;
import static lissa.gui.JIF_AdministrarPersonaJuridica.JIF_EMITIR_COMPROBANTE2;
import lissa.reportes.ReportGeneric;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Constants;
import org.openfact.client.OpenfactClientFactory;
import org.openfact.client.OrganizationClient;
import org.openfact.client.oauth.TokenManager;
import org.openfact.client.services.DocumentsService;
import org.openfact.client.services.representations.idm.DocumentRequestRepresentation;
import org.openfact.client.services.representations.idm.DocumentResponseRepresentation;
import org.openfact.client.services.representations.idm.LineRepresentation;

/*
* ID    SM          DESCRIPCION
* 001   001-2019    Agregar campos  para envio de comprobantes posteriores a SUNAT
*/

public class JIF_CobroCaja extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private Comprobante oComprobante;
    private ComprobanteBl oComprobanteBl;
    private BoletaBl oBlBoleta;
    private String tipoComprobante = null;
    private Usuario oUsuario;
    private Caja oCaja;
    private Persona oPersonaPaciente;
    private Atencion oAtencion;
    private Beneficio oBeneficio;
    private FondoSolidaridad oFondoSolidaridad;
    private List<ComprobanteDetalle> listComprobanteDetalle;
    private JIF_EmitirComprobante jifEmitirComprobante;
    private BigDecimal montoTotalTemp;
    private BigDecimal montoSubTotal;
    private BigDecimal montoIGV;
    private BigDecimal montoTotal;
    private BoletaBl oBLBoleta;
    private ItemsComprobanteBl oComprobanteDetalleBl;
    private TipoComprobanteCtrl oTipoComprobanteCtrl;
    private TipoDocIdentidadCtrl oTipoDocIdentidadCtrl;
    private String numeroCarta;
    private Persona oPersona;
    private PersonaBl oPersonaBl;

    //Variables para el reporte
    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;
    //fin

    public JIF_CobroCaja(JF_Principal root) {
        initComponents();
        this.root = root;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txfSubTotal = new javax.swing.JTextField();
        txfIgv = new javax.swing.JTextField();
        txfTotal = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txfPagoCon = new javax.swing.JTextField();
        txfVuelto = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txfPersona = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txfDni = new javax.swing.JTextField();
        chbxReplicar = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxComprobante = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txfSerie = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txfNumComprobante = new javax.swing.JTextField();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txfRuc = new javax.swing.JTextField();
        txfRazonSocial = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbxTipoDoc = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        txfCorreo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txfDireccion = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Cobro en Caja");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setText("Sub Total : ");

        jLabel7.setText("IGV : ");

        jLabel8.setText("Total : ");

        txfSubTotal.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txfSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfSubTotal.setEnabled(false);

        txfIgv.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txfIgv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfIgv.setEnabled(false);

        txfTotal.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txfTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfTotal.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfIgv)
                    .addComponent(txfTotal)
                    .addComponent(txfSubTotal, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfSubTotal)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfIgv)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfTotal)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel11.setText("Pago con : ");

        jLabel12.setText("Vuelto : ");

        txfPagoCon.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txfPagoCon.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txfVuelto.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txfVuelto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfVuelto.setPreferredSize(new java.awt.Dimension(4, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfPagoCon, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(txfVuelto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txfPagoCon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnGuardar.setText("Registrar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Paciente"));

        jLabel4.setText("Paciente :");

        txfPersona.setEnabled(false);

        jLabel10.setText("DNI : ");

        txfDni.setEnabled(false);

        chbxReplicar.setText("Replicar");
        chbxReplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbxReplicarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(txfPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(3, 3, 3)
                .addComponent(txfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(chbxReplicar)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(chbxReplicar))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Boleta/Factura"));

        jLabel1.setText("Tipo Comprobante :");

        cbxComprobante.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxComprobanteItemStateChanged(evt);
            }
        });
        cbxComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxComprobanteActionPerformed(evt);
            }
        });

        jLabel13.setText("Serie :");

        txfSerie.setEnabled(false);

        jLabel2.setText("N° :");

        txfNumComprobante.setEnabled(false);

        jLabel3.setText("Fecha :");

        jLabel5.setText("Nro. Doc : ");

        txfRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfRucKeyReleased(evt);
            }
        });

        txfRazonSocial.setEnabled(false);

        jLabel9.setText("Tipo Doc : ");

        cbxTipoDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoDocActionPerformed(evt);
            }
        });

        jLabel14.setText("Correo Electronico :");

        jLabel15.setText("Dirección :");

        txfDireccion.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15))
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxTipoDoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxComprobante, 0, 207, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txfSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(txfRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfRazonSocial))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txfDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(cbxComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txfSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txfNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(cbxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        btnRegresar.setText("Regresar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)))
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void cbxComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxComprobanteActionPerformed
        if (cbxComprobante.getSelectedIndex() > 0) {
            configurarComprobante();
            calcularMontos();
        }
    }//GEN-LAST:event_cbxComprobanteActionPerformed

    private void cbxComprobanteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxComprobanteItemStateChanged

    }//GEN-LAST:event_cbxComprobanteItemStateChanged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        registrar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txfRucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfRucKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String ref = txfRuc.getText().toUpperCase().trim();
            if (!ref.equals("")) {
                if (cbxTipoDoc.getSelectedIndex() > 0) {
                    if (cbxTipoDoc.getSelectedItem().toString().equals("RUC")) {
                        buscarPersonaXRuc(ref);
                    } else {
                        buscarPersonaXDni(ref);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un Tipo de Documento", "Atención", JOptionPane.INFORMATION_MESSAGE);
                }

            } else {
                Mensajes.msjParametroVacio();
            }
        }
    }//GEN-LAST:event_txfRucKeyReleased

    private void cbxTipoDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoDocActionPerformed
        validarTipoDoc();
    }//GEN-LAST:event_cbxTipoDocActionPerformed

    private void chbxReplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbxReplicarActionPerformed
        if (chbxReplicar.isSelected()) {
            replicarDatos();
        } else {
            borrarReplica();
        }
    }//GEN-LAST:event_chbxReplicarActionPerformed


    // Constants declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox cbxComprobante;
    private javax.swing.JComboBox cbxTipoDoc;
    private javax.swing.JCheckBox chbxReplicar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTextField txfCorreo;
    private javax.swing.JTextField txfDireccion;
    private javax.swing.JTextField txfDni;
    private javax.swing.JTextField txfIgv;
    private javax.swing.JTextField txfNumComprobante;
    private javax.swing.JTextField txfPagoCon;
    private javax.swing.JTextField txfPersona;
    private javax.swing.JTextField txfRazonSocial;
    private javax.swing.JTextField txfRuc;
    private javax.swing.JTextField txfSerie;
    private javax.swing.JTextField txfSubTotal;
    private javax.swing.JTextField txfTotal;
    private javax.swing.JTextField txfVuelto;
    // End of variables declaration//GEN-END:variables

    private void buscarPersonaJuridica(int JIF_EMITIR_COMPROBANTE) {
        root.jifAdministrarPersonaJuridica.setInvocador(JIF_EMITIR_COMPROBANTE2);
        try {
            root.insertarInternalFrames(root.jifAdministrarPersonaJuridica);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Atención", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void configurarComprobante() {
        oComprobante = new Comprobante();
        oBlBoleta = new BoletaBl();
        oComprobante.setTipoComprobante((TipoComprobante) cbxComprobante.getSelectedItem());
        oComprobante.setGrupoNumeracion(((TipoComprobante) cbxComprobante.getSelectedItem()).getGrupoNumeracion());
        txfNumComprobante.setText("" + Utilitarios.numberFormat(generarNumeracionComprobante(), "########"));

        switch (((TipoComprobante) cbxComprobante.getSelectedItem()).getDenominacion().trim()) {
            case "BOLETA":
                tipoComprobante = Constants.BOLETA;
                txfSerie.setText("");
                break;
            case "FACTURA":
                tipoComprobante = Constants.FACTURA;
                txfSerie.setText("");
                break;
            case "BOLETA ELECTRONICA":
                tipoComprobante = Constants.BOLETA_ELECTRONICA;
                txfSerie.setText("BC01");
                break;
            case "FACTURA ELECTRONICA":
                tipoComprobante = Constants.FACTURA_ELECTRONICA;
                txfSerie.setText("FC01");
                break;
            case "ORDEN DE SERVICIO":
                tipoComprobante = Constants.ORDEN_SERVICIO;
                txfSerie.setText("OC01");
                break;
            default:
                JOptionPane.showMessageDialog(null, "No existe comprobante configurado", "Atención", JOptionPane.INFORMATION_MESSAGE);
                cbxComprobante.setSelectedIndex(0);
                txfSerie.setText("");
                break;
        }
    }

    private long generarNumeracionComprobante() {
        oBlBoleta = new BoletaBl();
        return oBlBoleta.obtenerUltNumero(oComprobante.getGrupoNumeracion()) + 1;
    }

    void inicializar(Usuario oUsuario, Caja Ocaja, Persona oPersona, List<ComprobanteDetalle> listComprobanteDetalle, BigDecimal montoTotal, JIF_EmitirComprobante aThis, Atencion oAtencion) {
        this.listComprobanteDetalle = listComprobanteDetalle;
        this.oUsuario = oUsuario;
        this.oPersonaPaciente = oPersona;
        this.oCaja = Ocaja;
        this.montoTotalTemp = montoTotal;
        this.jifEmitirComprobante = aThis;
        this.oAtencion = oAtencion;
        this.numeroCarta = "";
        //setear  valore de seguro
        if (oBeneficio != null) {
            this.oBeneficio = null;
        }
        if (oFondoSolidaridad != null) {
            this.oFondoSolidaridad = null;
        }
        //Cargar Combo tipo de comprobante desde la bd y  que esten  en estado ACT        
        llenarCbxTipoComprobante();
        llenarCbxTipoDoc();
        //Setear todos los campos
        ResetCampos();
    }

    void inicializar(Usuario oUsuario, Caja Ocaja, Persona oPersona, List<ComprobanteDetalle> listComprobanteDetalle, BigDecimal montoTotal, JIF_EmitirComprobante aThis, Atencion oAtencion, Beneficio oBeneficio, String numeroCarta) {
        this.listComprobanteDetalle = listComprobanteDetalle;
        this.oUsuario = oUsuario;
        this.oPersonaPaciente = oPersona;
        this.oCaja = Ocaja;
        this.montoTotalTemp = montoTotal;
        this.jifEmitirComprobante = aThis;
        this.oAtencion = oAtencion;
        this.oBeneficio = oBeneficio;
        this.numeroCarta = numeroCarta;
        //setear  valore sde seguro
        if (oFondoSolidaridad != null) {
            this.oFondoSolidaridad = null;
        }
        //Cargar Combo tipo de comprobante desde la bd y  que esten  en estado ACT        
        llenarCbxTipoComprobante();
        llenarCbxTipoDoc();
        //Setear todos los campos
        ResetCampos();
    }

    void inicializar(Usuario oUsuario, Caja Ocaja, Persona oPersona, List<ComprobanteDetalle> listComprobanteDetalle, BigDecimal montoTotal, JIF_EmitirComprobante aThis, Atencion oAtencion, Beneficio oBeneficio, FondoSolidaridad oFondoSolidaridad) {
        this.listComprobanteDetalle = listComprobanteDetalle;
        this.oUsuario = oUsuario;
        this.oPersonaPaciente = oPersona;
        this.oCaja = Ocaja;
        this.montoTotalTemp = montoTotal;
        this.jifEmitirComprobante = aThis;
        this.oAtencion = oAtencion;
        this.oBeneficio = oBeneficio;
        this.oFondoSolidaridad = oFondoSolidaridad;
        this.numeroCarta = "";
        //Cargar Combo tipo de comprobante desde la bd y  que esten  en estado ACT        
        llenarCbxTipoComprobante();
        llenarCbxTipoDoc();
        //Setear todos los campos
        ResetCampos();
    }

    private void ResetCampos() {
        cbxComprobante.setSelectedIndex(0);
        cbxTipoDoc.setSelectedIndex(0);
        txfNumComprobante.setText("");
        Utilitarios.fechaActual(jdcFecha);
        txfPersona.setText("");
        txfDni.setText("");
        txfRuc.setText("");
        txfRazonSocial.setText("");
        txfPagoCon.setText("");
        txfVuelto.setText("");
        txfSubTotal.setText("");
        txfIgv.setText("");
        txfTotal.setText("");
        txfSerie.setText("");
        txfDireccion.setText("");
        txfCorreo.setText("");
        chbxReplicar.setSelected(false);

        if (oPersonaPaciente != null) {
            txfPersona.setText(oPersonaPaciente.getApellidoPaterno().trim() + " " + oPersonaPaciente.getApellidoMaterno().trim() + " " + oPersonaPaciente.getNombre().trim());
            txfDni.setText(oPersonaPaciente.getNumeroDocumento().trim());
        }
    }

    //Metodo que  calcula los montos segun tipo de comprobante y cantidad de items en la boeta
    private void calcularMontos() {
        resetTotales();
        /*
         if (((TipoComprobante) cbxComprobante.getSelectedItem()).getDenominacion().trim().equals("FACTURA ELECTRONICA")
         || ((TipoComprobante) cbxComprobante.getSelectedItem()).getDenominacion().trim().equals("FACTURA")) {
         montoSubTotal = montoTotalTemp.divide(new BigDecimal("1.18"), 2, RoundingMode.HALF_UP);
         montoIGV = montoTotalTemp.subtract(montoSubTotal).setScale(2, RoundingMode.HALF_UP);
         montoTotal = montoTotalTemp;
         } else {            
         montoSubTotal = new BigDecimal("0.00");
         montoIGV = new BigDecimal("0.00");            
         montoTotal = montoTotalTemp;
         }
         */
        //Se debe calcular todos los conceptos  sin importar el tipo de comprobante
        montoSubTotal = montoTotalTemp.divide(Constants.CIEN_IGV, 2, RoundingMode.HALF_UP);
        montoIGV = montoTotalTemp.subtract(montoSubTotal).setScale(2, RoundingMode.HALF_UP);
        montoTotal = montoTotalTemp;
        //impresion de totales
        txfSubTotal.setText(montoSubTotal.toString());
        txfIgv.setText(montoIGV.toString());
        txfTotal.setText(montoTotal.toString());

    }

    private void resetTotales() {
        montoSubTotal = BigDecimal.ZERO;
        montoIGV = BigDecimal.ZERO;
        montoTotal = BigDecimal.ZERO;
    }

    private void registrar() {
        int res = 0;
        if (isDatosValidos()) {
            //Metodo transaccional para registrar comprobante y su detalle
            res = registrarComprobantes(listComprobanteDetalle);
            if (res == Constants.SUCCESS) {
                Mensajes.msjRegCorrecta();
                //emitirFacturaElectronica(oComprobante, listComprobanteDetalle);
                imprimirComprobante(tipoComprobante);
                ResetCampos();
                this.doDefaultCloseAction();
                //mandar a cerra  la ventana de atencion
                jifEmitirComprobante.doDefaultCloseAction();
            } else {
                Mensajes.msjRegError();
            }
            //Fin metodo transaccional
            /*
             oComprobante = registrarComprobante();
             if (oComprobante != null) {
             for (ComprobanteDetalle obj : listComprobanteDetalle) {
             oComprobanteDetalleBl = new ItemsComprobanteBl();
             obj.setComprobante(oComprobante);
             oComprobanteDetalleBl.registrar(obj);
             res++;
             }
             if (res == listComprobanteDetalle.size()) {
             Mensajes.msjRegCorrecta();
             imprimirComprobante(tipoComprobante);
             //registrarComprobanteElectronico(oComprobante, listComprobanteDetalle);
             ResetCampos();
             this.doDefaultCloseAction();
             //mandar a cerra  la ventana de atencion
             jifEmitirComprobante.doDefaultCloseAction();
             } else {
             Mensajes.msjRegError();
             }
             }
             */
        } else {
            Mensajes.msjValidarIngreso();
        }

    }

    private boolean isDatosValidos() {
        if (cbxComprobante.getSelectedItem().toString().trim().equals("ORDEN DE SERVICIO")) {
            return (cbxComprobante.getSelectedIndex() > 0
                    && !txfNumComprobante.getText().equals("")
                    && jdcFecha.getDate() != null);
        } else {
            return (oPersona != null
                    && cbxComprobante.getSelectedIndex() > 0
                    && cbxTipoDoc.getSelectedIndex() > 0
                    && !txfRuc.getText().equals("")
                    && !txfRazonSocial.getText().equals("")
                    && !txfNumComprobante.getText().equals("")
                    && !txfDireccion.getText().equals("")
                    && jdcFecha.getDate() != null);
        }

    }

    private Comprobante registrarComprobante() {
        oComprobanteBl = new ComprobanteBl();
        oComprobante.setFechaComprobante(jdcFecha.getDate());
        //Falta Persona Juridica
        oComprobante.setFechaReg(new Date());
        oComprobante.setNumero(generarNumeracionComprobante());
        oComprobante.setSubTotal(montoSubTotal);
        oComprobante.setMontoIgv(montoIGV);
        oComprobante.setMontoTotal(montoTotal);
        oComprobante.setMotivoAnulacion("");
        oComprobante.setIdUsuario(oUsuario.getIdUsuario());
        oComprobante.setNumeroOperacion(obtenerNumeroOperacion());
        oComprobante.setAtencion(oAtencion);
        oComprobante.setCaja(oCaja);
        oComprobante.setEstado("ACT");
        oComprobante.setBeneficio(oBeneficio != null ? oBeneficio : null);
        oComprobante.setFondoSolidaridad(oFondoSolidaridad != null ? oFondoSolidaridad : null);

        return oComprobanteBl.registrar(oComprobante);

    }

    private Integer obtenerNumeroOperacion() {
        oBLBoleta = new BoletaBl();
        return oBLBoleta.obtenerNumeroOperacion() + 1;
    }

    private void imprimirComprobante(String tipoComprobante) {
        try {
            ds = new lissa.ds.DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport(tipoComprobante, new String[]{"ID_COMPROBANTE"}, new Object[]{oComprobante.getIdcomprobante()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Comprobante");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.setMaximizable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
        } catch (Exception ex) {
            Logger.getLogger(JIF_CobroCaja.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void llenarCbxTipoComprobante() {
        oTipoComprobanteCtrl = new TipoComprobanteCtrl(root);
        oTipoComprobanteCtrl.rellenaTipoComprobante(cbxComprobante);
    }

    private int registrarComprobantes(List<ComprobanteDetalle> listComprobanteDetalle) {
        oComprobanteBl = new ComprobanteBl();
        oComprobante.setFechaComprobante(jdcFecha.getDate());
        oComprobante.setOrganizacion(new OrganizacionBl().buscar(1));
        oComprobante.setClientepersonanatural(oPersona);
        oComprobante.setFechaReg(new Date());
        oComprobante.setHoraReg(Utilitarios.horaActual());
        oComprobante.setSerie(txfSerie.getText().trim());
        oComprobante.setNumero(generarNumeracionComprobante());
        oComprobante.setSubTotal(montoSubTotal);
        oComprobante.setMontoIgv(montoIGV);
        oComprobante.setMontoTotal(montoTotal);
        oComprobante.setMotivoAnulacion("");
        oComprobante.setIdUsuario(oUsuario.getIdUsuario());
        oComprobante.setNumeroOperacion(obtenerNumeroOperacion());
        oComprobante.setAtencion(oAtencion);
        oComprobante.setCaja(oCaja);
        oComprobante.setEstado("ACT");
        oComprobante.setBeneficio(oBeneficio != null ? oBeneficio : null);
        oComprobante.setFondoSolidaridad(oFondoSolidaridad != null ? oFondoSolidaridad : null);
        oComprobante.setNumeroCarta(numeroCarta != null ? numeroCarta : "");
        oComprobante.setTipoDocCliente(cbxTipoDoc.getSelectedIndex() > 0 ? (TipoDocidentidad) cbxTipoDoc.getSelectedItem() : null);
        oComprobante.setCorreo_cliente_temp(!txfCorreo.getText().trim().equals("") ? txfCorreo.getText().trim() : "");
        //efact
        oComprobante.setTotalValorVentaOpGravadas(montoSubTotal);
        oComprobante.setTotalValorVentaOpeInafectas(BigDecimal.ZERO);
        oComprobante.setTotalValorVentaOpeExoneradas(BigDecimal.ZERO);
        oComprobante.setTotalSumatoriaIgv(montoIGV);
        oComprobante.setTotalSumatoriaIsc(BigDecimal.ZERO);
        oComprobante.setTotalSumatoriaOtrosTributos(BigDecimal.ZERO);
        oComprobante.setTotalSumatoriaOtrosCargos(BigDecimal.ZERO);
        oComprobante.setTotalSumatoriaDescuentos(BigDecimal.ZERO);
        oComprobante.setTotalImporteVenta(oComprobante.getTotalValorVentaOpGravadas()
                .add(oComprobante.getTotalValorVentaOpeInafectas()
                        .add(oComprobante.getTotalValorVentaOpeExoneradas()
                                .add(oComprobante.getTotalSumatoriaIgv()
                                        .add(oComprobante.getTotalSumatoriaIsc()
                                                .add(oComprobante.getTotalSumatoriaOtrosTributos()
                                                        .add(oComprobante.getTotalSumatoriaOtrosCargos())))))));
        oComprobante.setTipoMoneda("PEN");
        oComprobante.setTotalOpeGratuitas(BigDecimal.ZERO);

        return oComprobanteBl.registrar(oComprobante, listComprobanteDetalle, oAtencion);
    }

    private void buscarPersona(int JIF_COBRO_CAJA) {
        root.jifAdministrarPersonanatural.setInvocador(JIF_COBRO_CAJA);
        root.insertarInternalFrames(root.jifAdministrarPersonanatural);
        root.jifAdministrarPersonanatural.inicializar();
    }

    void cargarDatosPersona(Persona beanTabla) {
        oPersona = beanTabla;
        if (cbxComprobante.getSelectedItem().toString().equals("FACTURA ELECTRONICA")) {
            txfRuc.setText(oPersona.getRuc().trim());
        } else {
            txfRuc.setText(oPersona.getNumeroDocumento().trim());
        }
        txfRazonSocial.setText(oPersona.getTipoPersona().getDescripcion().trim().equals("PERSONA NATURAL") ? oPersona.getNombre().trim() + " " + oPersona.getApellidoPaterno().trim() + " " + oPersona.getApellidoMaterno().trim() : oPersona.getApellidoPaterno().trim());
        txfDireccion.setText(!oPersona.getDireccion().trim().equals("") ? oPersona.getDireccion().trim() : "");
    }

    private void llenarCbxTipoDoc() {
        oTipoDocIdentidadCtrl = new TipoDocIdentidadCtrl(root);
        oTipoDocIdentidadCtrl.rellenaTipoDocumento(cbxTipoDoc);
    }

    private void buscarPersonaXDni(String ref) {
        oPersonaBl = new PersonaBl();
        oPersona = oPersonaBl.buscarPersonaXDni(ref);
        if (oPersona != null) {
            txfRazonSocial.setText(oPersona.getNombre().trim() + " " + oPersona.getApellidoPaterno().trim() + " " + oPersona.getApellidoMaterno().trim());
            txfCorreo.setText(oPersona.getCorreoElectronico() != null ? oPersona.getCorreoElectronico().trim() : "");
            txfDireccion.setText(!oPersona.getDireccion().trim().equals("") ? oPersona.getDireccion().trim() : "");
        } else {
            insertarJifBuscaPersona(ref);
        }
    }

    private void insertarJifBuscaPersona(String ref) {
        int op;
        op = JOptionPane.showConfirmDialog(null, "No Existe persona con N° Doc : " + ref + " \n¿Desea registrar a la persona?", "Atención", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            root.jifAdministrarPersonanatural.setInvocador(JIF_AdministrarPersonaNatural.JIF_COBRO_CAJA);
            root.insertarInternalFrames(root.jifAdministrarPersonanatural);
            root.jifAdministrarPersonanatural.inicializar();
        }
    }

    private void buscarPersonaXRuc(String ref) {
        oPersonaBl = new PersonaBl();
        oPersona = oPersonaBl.buscarPersonaXRuc(ref);
        if (oPersona != null) {
            txfRazonSocial.setText(!oPersona.getRazonSocial().trim().equals("") ? oPersona.getRazonSocial().trim() : oPersona.getNombre().trim() + " " + oPersona.getApellidoPaterno().trim() + " " + oPersona.getApellidoMaterno().trim());
            txfCorreo.setText(oPersona.getCorreoElectronico() != null ? oPersona.getCorreoElectronico().trim() : "");
            txfDireccion.setText(!oPersona.getDireccion().trim().equals("") ? oPersona.getDireccion().trim() : "");
        } else {
            insertarJifBuscaPersona(ref);
        }
    }

    private void validarTipoDoc() {
        if (cbxComprobante.getSelectedIndex() > 0) {
            if (((TipoComprobante) cbxComprobante.getSelectedItem()).getDenominacion().trim().equals("FACTURA ELECTRONICA")) {
                if (!((TipoDocidentidad) cbxTipoDoc.getSelectedItem()).getDocumento().trim().equals("RUC")) {
                    JOptionPane.showMessageDialog(null, "Tipo de documento invalido ", "Error", JOptionPane.ERROR_MESSAGE);
                    cbxTipoDoc.setSelectedIndex(0);
                }
            }
        }

    }

    private void replicarDatos() {
        try {
            if (oPersonaPaciente != null) {
                oPersona = oPersonaPaciente;
                //cargar tipo doc DNI en automatico
                TipoDocIdentidadCtrl tipo = new TipoDocIdentidadCtrl(root);
                tipo.defaultSelectCbx("DNI", cbxTipoDoc);
                //Cargar demas datos
                txfRuc.setText(oPersona.getNumeroDocumento().trim());
                txfRazonSocial.setText(oPersona.getNombre().trim() + " " + oPersona.getApellidoPaterno().trim() + " " + oPersona.getApellidoMaterno().trim());
                txfCorreo.setText(oPersona.getCorreoElectronico() != null ? oPersona.getCorreoElectronico().trim() : "");
                txfDireccion.setText(!oPersona.getDireccion().trim().equals("") ? oPersona.getDireccion().trim() : "");
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe paciente cargado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            Mensajes.ErrorGenerico(e);
        }
    }

    private void borrarReplica() {
        if(oPersona != null){
            oPersona = null;
        }
        cbxTipoDoc.setSelectedIndex(0);
        txfRuc.setText("");
        txfRazonSocial.setText("");
        txfCorreo.setText("");
        txfDireccion.setText("");
    }

}
