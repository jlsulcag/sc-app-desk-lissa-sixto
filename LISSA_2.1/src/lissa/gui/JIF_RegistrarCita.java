package lissa.gui;

import java.math.BigDecimal;
import java.util.Date;
import javax.swing.JOptionPane;
import lissa.be.Beneficio;
import lissa.be.Cita;
import lissa.be.CitaDetalle;
import lissa.be.Medico;
import lissa.be.Persona;
import lissa.be.ProcedimientoTarifario;
import lissa.be.SeguroVida;
import lissa.be.Usuario;
import lissa.be.UsuarioPermiso;
import lissa.bl.CitaBl;
import lissa.bl.UsuarioPermisoBl;
import lissa.controller.BeneficioCtrl;
import lissa.controller.MedicoCtrl;
import lissa.controller.SeguroCtrl;
import lissa.table.ModeloCitaDetalle;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Constants;

/**
 *
 * @author JSULCAG
 */
public class JIF_RegistrarCita extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private SeguroCtrl oSeguroCtrl;
    private MedicoCtrl oMedicoCtrl;
    private ModeloCitaDetalle oModeloCitaDetalle;
    private Persona oPersona;
    private BeneficioCtrl oBeneficioCtrl;
    private Medico oMedico;
    private ProcedimientoTarifario oProcedimientoTarifario;
    private Usuario oUsuario;
    private CitaDetalle oCitaDetalle;
    private Cita oCita;
    private CitaBl oCitaBl;
    private BigDecimal totalTemp;
    private final static int ES_CONVENIO = 1;
    private UsuarioPermiso oUsuarioPermiso;
    private UsuarioPermisoBl oUsuarioPermisoBl;

    public JIF_RegistrarCita(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloCitaDetalle = new ModeloCitaDetalle(root);
        tblCitas.setModel(oModeloCitaDetalle);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txfPaciente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbxConvenio = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cbxBeneficio = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txfNumeroCarta = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txfCobertura = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txfHoraInicio = new javax.swing.JTextField();
        txfMinutoInicio = new javax.swing.JTextField();
        cbxampm = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txfNumero = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txfProcedimiento = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbxMedico = new javax.swing.JComboBox();
        txfMonto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCitas = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txfMontoTotal = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Registrar Cita");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Cita"));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Paciente :");

        txfPaciente.setEnabled(false);
        txfPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfPacienteKeyReleased(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Fecha :");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Hora Inicio :");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel11.setText("Convenio :");

        cbxConvenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxConvenioActionPerformed(evt);
            }
        });

        jLabel12.setText("Beneficio :");

        jLabel13.setText("N° Carta :");

        txfNumeroCarta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel14.setText("Cobertura :");

        txfCobertura.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel1.setText(":");

        txfHoraInicio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txfHoraInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfHoraInicioKeyReleased(evt);
            }
        });

        txfMinutoInicio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txfMinutoInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfMinutoInicioKeyReleased(evt);
            }
        });

        cbxampm.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));

        jLabel8.setText("Numero : ");

        txfNumero.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txfNumero.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txfPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txfNumeroCarta, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfCobertura, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfMinutoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxampm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cbxConvenio, javax.swing.GroupLayout.Alignment.LEADING, 0, 385, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txfPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel1)
                        .addComponent(txfHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txfMinutoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxampm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbxConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cbxBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txfNumeroCarta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txfCobertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Procedimiento :");

        txfProcedimiento.setEnabled(false);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Medico :");

        txfMonto.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txfProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbxMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txfProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txfMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblCitasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblCitas);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/cancel.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(50, 41));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Save.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/remove.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel2.setText("Total S/.");

        txfMontoTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txfMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfPacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPacienteKeyReleased
        //listarPersonas();
    }//GEN-LAST:event_txfPacienteKeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        abrirAdminPersonaNatural(JIF_AdministrarPersonaNatural.JIF_CITA);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        buscarProcedimiento();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        agregarDetalle();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void tblCitasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCitasMouseReleased
        if (tblCitas.getSelectedRow() != -1 && tblCitas.getRowSelectionAllowed()) {
            //obtenerDatosTabla();
        } else {
            System.out.println("Aqui");
        }
    }//GEN-LAST:event_tblCitasMouseReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        iniciar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txfHoraInicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfHoraInicioKeyReleased
        Utilitarios.validaCaracterNumerico(evt, txfHoraInicio);
    }//GEN-LAST:event_txfHoraInicioKeyReleased

    private void txfMinutoInicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfMinutoInicioKeyReleased
        Utilitarios.validaCaracterNumerico(evt, txfMinutoInicio);
    }//GEN-LAST:event_txfMinutoInicioKeyReleased

    private void cbxConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxConvenioActionPerformed
        cargarCbxDependendiente();
    }//GEN-LAST:event_cbxConvenioActionPerformed


    // Constants declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbxBeneficio;
    private javax.swing.JComboBox cbxConvenio;
    private javax.swing.JComboBox cbxMedico;
    private javax.swing.JComboBox cbxampm;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTable tblCitas;
    private javax.swing.JTextField txfCobertura;
    private javax.swing.JTextField txfHoraInicio;
    private javax.swing.JTextField txfMinutoInicio;
    private javax.swing.JTextField txfMonto;
    private javax.swing.JTextField txfMontoTotal;
    private javax.swing.JTextField txfNumero;
    private javax.swing.JTextField txfNumeroCarta;
    private javax.swing.JTextField txfPaciente;
    private javax.swing.JTextField txfProcedimiento;
    // End of variables declaration//GEN-END:variables

    void iniciar() {
        txfPaciente.setText("");
        jdcFecha.setDate(null);
        txfHoraInicio.setText("");
        txfMinutoInicio.setText("");
        cbxampm.setSelectedIndex(0);
        txfNumeroCarta.setText("");
        txfCobertura.setText("");
        llenaCbxConvenio();
        llenaCbxMedico();
        txfProcedimiento.setText("");
        txfMonto.setText("");
        oModeloCitaDetalle.clear();
        if (oPersona != null) {
            oPersona = null;
        }
        totalTemp = new BigDecimal("0.00");
        obtenerNumeroCita();
        //Envia user al modelo
        //oModeloCitaDetalle.setOusuario(root.getUser());
        personalizaVistaTabla();
        txfMontoTotal.setText("");
    }

    private void llenaCbxConvenio() {
        oSeguroCtrl = new SeguroCtrl(root);
        oSeguroCtrl.rellenaCbx(cbxConvenio);
    }

    private void llenaCbxMedico() {
        oMedicoCtrl = new MedicoCtrl(root);
        oMedicoCtrl.rellenaMedico(cbxMedico);
    }

    private void abrirAdminPersonaNatural(int JIF_CITA) {
        root.jifAdministrarPersonanatural.setInvocador(JIF_CITA);
        root.insertarInternalFrames(root.jifAdministrarPersonanatural);
        root.jifAdministrarPersonanatural.inicializar();
    }

    void cargarDatosPersona(Persona beanTabla) {
        oPersona = beanTabla;
        txfPaciente.setText(oPersona.getNombre().trim() + " " + oPersona.getApellidoPaterno().trim() + oPersona.getApellidoMaterno().trim());
    }

    private void cargarCbxDependendiente() {
        if (cbxConvenio.getSelectedIndex() > 0) {
            llenaCbxBeneficio();
        } else {
            cbxBeneficio.removeAllItems();
        }
    }

    private void llenaCbxBeneficio() {
        oBeneficioCtrl = new BeneficioCtrl(root);
        oBeneficioCtrl.rellenaCbx(cbxBeneficio, ((SeguroVida) cbxConvenio.getSelectedItem()).getIdSeguroVida());
    }

    private void buscarProcedimiento() {
        root.jifBuscarProcedimiento.setInvocador(JIF_BuscarProcedimiento.JIF_CITA);
        root.jifBuscarProcedimiento.enviarUser(oUsuario);
        root.insertarInternalFrames(root.jifBuscarProcedimiento);
        root.jifBuscarProcedimiento.inicializar();
    }

    void enviaDatosProcedimiento(ProcedimientoTarifario obj) {
        this.oProcedimientoTarifario = obj;
        txfProcedimiento.setText(oProcedimientoTarifario.getProcedimiento().getDenominacion().trim());
        if (esConvenio()) {
            if (obtenerPermiso(this.root.getUser().getIdUsuario(), 1) != null) {
                txfMonto.setText(oProcedimientoTarifario.getCosto().toString());
            } else {
                //no mostrar costos
                txfMonto.setText("**.**");
            }
        } else {
            txfMonto.setText(oProcedimientoTarifario.getCosto().toString());
        }
    }

    private boolean esConvenio() {
        return (oProcedimientoTarifario.getTarifario().getEsconvenio() == ES_CONVENIO);
    }

    public Usuario getoUsuario() {
        return oUsuario;
    }

    public void setoUsuario(Usuario oUsuario) {
        this.oUsuario = oUsuario;
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblCitas, 50);
        Utilitarios.formateaColumna(4, tblCitas, 80);
        Utilitarios.alinearDatosColumnaTablaDerecha(4, tblCitas);
    }

    private void agregarDetalle() {
        if (isDatosValidosDetalle()) {
            oCitaDetalle = new CitaDetalle();
            oCitaDetalle.setProcedimientoTarifario(oProcedimientoTarifario);
            oCitaDetalle.setMedico(cbxMedico.getSelectedIndex() > 0 ? (Medico) cbxMedico.getSelectedItem() : null);
            oCitaDetalle.setCosto(oProcedimientoTarifario.getCosto());
            oModeloCitaDetalle.add(oCitaDetalle);
            calcularTotal(oModeloCitaDetalle);
            personalizaVistaTabla();
            resetComponentDetalle();
        } else {
            Mensajes.msjValidarIngreso();
        }
    }

    private boolean isDatosValidosDetalle() {
        return (oProcedimientoTarifario != null);
    }

    private void guardar() {
        if (isDatosValidos()) {
            if (tieneCarta() && txfNumeroCarta.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese el numero de carta", "Atención", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (registrarCita() == Constants.SUCCESS) {
                    Mensajes.msjRegCorrecta();
                    iniciar();
                } else {
                    Mensajes.msjRegError();
                }
            }

        } else {
            Mensajes.msjValidarIngreso();
        }

    }

    private boolean isDatosValidos() {
        return (oPersona != null
                && jdcFecha != null
                && oModeloCitaDetalle.size() > 0);
    }

    private int registrarCita() {
        oCita = new Cita();
        oCitaBl = new CitaBl();
        oCita.setPersona(oPersona);
        oCita.setFechaCita(jdcFecha.getDate());
        oCita.setFechaReg(new Date());
        oCita.setIdUsuario(oUsuario.getIdUsuario());
        oCita.setEstado("REG");
        oCita.setNumero(obtenerNumeroCita());
        if (!txfHoraInicio.getText().trim().equals("") && !txfMinutoInicio.getText().trim().equals("")) {
            oCita.setHoraInicio(txfHoraInicio.getText().trim() + ":" + txfMinutoInicio.getText().trim() + " " + cbxampm.getSelectedItem());
        } else {
            oCita.setHoraInicio("");
        }
        if (cbxConvenio.getSelectedIndex() > 0 && cbxBeneficio.getSelectedIndex() > 0) {
            oCita.setBeneficio((Beneficio) cbxBeneficio.getSelectedItem());
        }
        oCita.setNumeroCarta(!txfNumeroCarta.getText().trim().equals("") ? txfNumeroCarta.getText().trim() : "");
        oCita.setCobertura(!txfCobertura.getText().trim().equals("") ? new BigDecimal(txfCobertura.getText().trim()) : null);

        return oCitaBl.registrar(oCita, oModeloCitaDetalle);
    }

    private boolean tieneCarta() {
        return (((SeguroVida) cbxConvenio.getSelectedItem()).getTieneCarta() == 1);
    }

    private void resetComponentDetalle() {
        txfProcedimiento.setText("");
        txfMonto.setText("");
        cbxMedico.setSelectedIndex(0);
        if (oProcedimientoTarifario != null) {
            oProcedimientoTarifario = null;
        }
    }

    private UsuarioPermiso obtenerPermiso(long idUsuario, int idPermiso) {
        oUsuarioPermisoBl = new UsuarioPermisoBl();
        oUsuarioPermiso = oUsuarioPermisoBl.buscarUsuarioPermiso(idPermiso, idUsuario);
        return oUsuarioPermiso;
    }

    private void calcularTotal(ModeloCitaDetalle oModeloCitaDetalle) {
        totalTemp = new BigDecimal("0.00");
        for (int i = 0; i < oModeloCitaDetalle.size(); i++) {
            totalTemp = totalTemp.add(oModeloCitaDetalle.get(i).getProcedimientoTarifario().getCosto());
            if (obtenerPermiso(this.root.getUser().getIdUsuario(), 1) != null) {
                txfMontoTotal.setText(totalTemp.toString());
            } else {
                //no mostrar costos
                txfMontoTotal.setText("**.**");
            }
            //
        }

    }

    private int obtenerNumeroCita() {
        oCitaBl = new CitaBl();
        int numeroActual = oCitaBl.maxNumero();
        if (numeroActual > 0) {
            txfNumero.setText(numeroActual + "");
        } else {
            txfNumero.setText("");
        }
        return numeroActual;
    }

}
