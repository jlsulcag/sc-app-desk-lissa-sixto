package lissa.gui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import lissa.be.ComprobanteDetalle;
import lissa.be.Medico;
import lissa.be.MedicoDerivaAtiende;
import lissa.be.Usuario;
import lissa.bl.ItemsComprobanteBl;
import lissa.bl.MedicoDerivaAtiendeBl;
import lissa.table.ModeloRegistrarPagoMedicos;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_RegistrarPagoMedicos extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private Usuario oUsuario;
    private ModeloRegistrarPagoMedicos oModeloRegistrarPagoMedicos;
    private ArrayList<ComprobanteDetalle> listComprobanteDetalle;
    private ItemsComprobanteBl oComprobanteDetalleBl;
    private ComprobanteDetalle oComprobanteDetalle;
    private ComprobanteDetalle oComprobanteDetalleTemp;
    private Medico oMedicoAtiendeReal;//Variable para almacenar  al medico quien atiende realmente 
    private MedicoDerivaAtiende oMedicoDerivaAtiende;
    private MedicoDerivaAtiendeBl oMedicoDerivaAtiendeBl;
    private Medico oMedico;

    public JIF_RegistrarPagoMedicos(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloRegistrarPagoMedicos = new ModeloRegistrarPagoMedicos();
        tblAtenciones.setModel(oModeloRegistrarPagoMedicos);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jdcFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jdcFechaFin = new com.toedter.calendar.JDateChooser();
        btnProcesar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txfMedico = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAtenciones = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txfMedicoDeriva = new javax.swing.JTextField();
        txfMedicoAtiende = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Registrar Pago a Médicos");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));

        jLabel1.setText("Inicio :");

        jLabel2.setText("Fecha Fin :");

        btnProcesar.setText("Procesar");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        jLabel5.setText("Medico :");

        txfMedico.setEnabled(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProcesar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jdcFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcesar)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jButton1)
                        .addComponent(jLabel5)
                        .addComponent(txfMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Atenciones"));

        tblAtenciones.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAtenciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblAtencionesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblAtenciones);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Pago a Medicos"));

        jLabel3.setText("Médico Deriva :");

        jButton3.setText("Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Médico Atiende :");

        txfMedicoDeriva.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txfMedicoDeriva.setForeground(new java.awt.Color(0, 102, 204));
        txfMedicoDeriva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txfMedicoAtiende.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        txfMedicoAtiende.setForeground(new java.awt.Color(0, 102, 204));
        txfMedicoAtiende.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(txfMedicoDeriva, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfMedicoAtiende, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 625, Short.MAX_VALUE)
                .addComponent(jButton3))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton3)
                    .addComponent(jLabel4)
                    .addComponent(txfMedicoDeriva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfMedicoAtiende, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        listarComprobanteDetalle();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void tblAtencionesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAtencionesMouseReleased
        obtenerDatos();
    }//GEN-LAST:event_tblAtencionesMouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        guardarCambios();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscarMedico(JIF_BuscarMedico.REGISTRAR_PAGO_MEDICOS);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcesar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFechaFin;
    private com.toedter.calendar.JDateChooser jdcFechaInicio;
    private javax.swing.JTable tblAtenciones;
    private javax.swing.JTextField txfMedico;
    private javax.swing.JTextField txfMedicoAtiende;
    private javax.swing.JTextField txfMedicoDeriva;
    // End of variables declaration//GEN-END:variables

    void resetComponents() {
        Utilitarios.fechaActual(jdcFechaInicio);
        Utilitarios.fechaActual(jdcFechaFin);
        if (oMedicoAtiendeReal != null) {
            oMedicoAtiendeReal = null;
        }
        if (oComprobanteDetalle != null) {
            oComprobanteDetalle = null;
        }
        oModeloRegistrarPagoMedicos.clear();
        personalizaVistaTabla();
        txfMedicoDeriva.setText("");
        txfMedicoAtiende.setText("");
        if(oMedico != null){
            oMedico = null;
        }
        txfMedico.setText("");
    }

    void resetBusqueda() {
        personalizaVistaTabla();
        if (oMedicoAtiendeReal != null) {
            oMedicoAtiendeReal = null;
        }
        if (oComprobanteDetalle != null) {
            oComprobanteDetalle = null;
        }
        oModeloRegistrarPagoMedicos.clear();
        txfMedicoDeriva.setText("");
        txfMedicoAtiende.setText("");
        btnProcesar.doClick();
    }

    void enviarDatos(Usuario user) {
        oUsuario = user;
        resetComponents();
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblAtenciones, 60);
        Utilitarios.formateaColumna(2, tblAtenciones, 120);
        Utilitarios.formateaColumna(3, tblAtenciones, 80);
        Utilitarios.formateaColumna(5, tblAtenciones, 80);
        Utilitarios.formateaColumna(9, tblAtenciones, 80);
        Utilitarios.formateaColumna(10, tblAtenciones, 80);
        Utilitarios.formateaColumna(11, tblAtenciones, 80);

        Utilitarios.alinearDatosColumnaTablaDerecha(9, tblAtenciones);
        Utilitarios.alinearDatosColumnaTablaDerecha(10, tblAtenciones);
    }

    private void listarComprobanteDetalle() {
        listComprobanteDetalle = new ArrayList<>();
        oComprobanteDetalleBl = new ItemsComprobanteBl();
        oModeloRegistrarPagoMedicos.clear();
        if (isDatosValidosBusqueda()) {
            listComprobanteDetalle = oComprobanteDetalleBl.listarxRango(jdcFechaInicio.getDate(), jdcFechaFin.getDate(), oMedico.getIdMedico());
            for (ComprobanteDetalle obj : listComprobanteDetalle) {
                oModeloRegistrarPagoMedicos.add(obj);
            }
        } else {
            Mensajes.msjValidarIngreso();
        }
    }

    private boolean isDatosValidosBusqueda() {
        return (jdcFechaInicio.getDate() != null
                && jdcFechaFin.getDate() != null
                && !txfMedico.getText().trim().equals(""));
    }

    private void obtenerDatos() {
        if (tblAtenciones.getRowSelectionAllowed() && tblAtenciones.getSelectedRow() != -1) {
            oComprobanteDetalle = oModeloRegistrarPagoMedicos.get(tblAtenciones.getSelectedRow());
            if (oComprobanteDetalle != null) {
                if (oComprobanteDetalle.getMontoDerivacion() != null) {
                    txfMedicoDeriva.setText(oComprobanteDetalle.getMontoDerivacion().toString());
                } else {
                    txfMedicoDeriva.setText("");
                }
                if (oComprobanteDetalle.getMontoAtencion() != null) {
                    txfMedicoAtiende.setText(oComprobanteDetalle.getMontoAtencion().toString());
                } else {
                    txfMedicoAtiende.setText("");
                }

            }
        } else {
            Mensajes.tblSelected();
        }
    }

    private void insertarPantallaBusquedaMedicos() {
        root.jifBuscarMedico.setInvocador(JIF_BuscarMedico.ADMINISTRAR_ATENCION);
        root.insertarInternalFrames(root.jifBuscarMedico);
        root.jifBuscarMedico.inicializar();
    }

    private void guardarCambios() {
        int res = -1;
        int res2 = -1;
        oComprobanteDetalleBl = new ItemsComprobanteBl();
        if (isdatosValidos()) {
            oComprobanteDetalleTemp = oComprobanteDetalle;
            if (oComprobanteDetalleTemp.getMedicoatiendereal() != null) {
                oComprobanteDetalleTemp.setMontoDerivacion(!txfMedicoDeriva.getText().trim().equals("") ? new BigDecimal(txfMedicoDeriva.getText().trim()) : new BigDecimal("0.00"));
                oComprobanteDetalleTemp.setMontoAtencion(!txfMedicoAtiende.getText().trim().equals("") ? new BigDecimal(txfMedicoAtiende.getText().trim()) : new BigDecimal("0.00"));
                res = oComprobanteDetalleBl.actualizar(oComprobanteDetalleTemp);
                if (res == 0) {
                    //Registrar MedicoDerivaAtiende, aqui se almacena el pago a medicos detallado
                    oMedicoDerivaAtiendeBl = new MedicoDerivaAtiendeBl();
                    if (oComprobanteDetalleTemp.getMedicoByIdMedicoDeriva() != null && oComprobanteDetalleTemp.getMontoDerivacion().compareTo(new BigDecimal("0.00")) == 1) {
                        oMedicoDerivaAtiende = new MedicoDerivaAtiende();
                        oMedicoDerivaAtiende.setComprobanteDetalle(oComprobanteDetalleTemp);
                        oMedicoDerivaAtiende.setMedico(oComprobanteDetalleTemp.getMedicoByIdMedicoDeriva());
                        oMedicoDerivaAtiende.setMonto(oComprobanteDetalleTemp.getMontoDerivacion());
                        oMedicoDerivaAtiende.setEstadoPago("DEBE");
                        oMedicoDerivaAtiende.setMotivo("DERIVACION");
                        oMedicoDerivaAtiende.setFechaReg(new Date());
                        oMedicoDerivaAtiendeBl.registrar(oMedicoDerivaAtiende);
                    }
                    if (oComprobanteDetalle.getMedicoatiendereal() != null && oComprobanteDetalleTemp.getMontoAtencion().compareTo(new BigDecimal("0.00")) == 1) {
                        oMedicoDerivaAtiende = new MedicoDerivaAtiende();
                        oMedicoDerivaAtiende.setComprobanteDetalle(oComprobanteDetalleTemp);
                        oMedicoDerivaAtiende.setMedico(oComprobanteDetalleTemp.getMedicoatiendereal());
                        oMedicoDerivaAtiende.setMonto(oComprobanteDetalleTemp.getMontoAtencion());
                        oMedicoDerivaAtiende.setEstadoPago("DEBE");
                        oMedicoDerivaAtiende.setMotivo("ATENCION");
                        oMedicoDerivaAtiende.setFechaReg(new Date());
                        oMedicoDerivaAtiendeBl.registrar(oMedicoDerivaAtiende);
                    }
                    Mensajes.msjRegCorrecta();
                    resetBusqueda();
                } else {
                    Mensajes.msjRegError();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe medico asignado para  la atención ...", "Atención", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese montos a pagar a los médicos o especialistas", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean isdatosValidos() {
        return (tblAtenciones.getSelectedRow() != -1
                && !txfMedicoAtiende.getText().trim().equals(""));
    }

    private void buscarMedico(int REGISTRAR_PAGO_MEDICOS) {
        root.jifBuscarMedico.setInvocador(REGISTRAR_PAGO_MEDICOS);
        try {
            root.insertarInternalFrames(root.jifBuscarMedico);
            root.jifBuscarMedico.inicializar();
        } catch (Exception e) {
            Mensajes.ErrorGenerico(e);
        }
    }

    void cargarDatosMedico(Medico beanTabla) {
        oMedico = new Medico();
        oMedico = beanTabla;
        txfMedico.setText(oMedico.getPersona().getNombre().trim()+" "+oMedico.getPersona().getApellidoPaterno().trim()+" "+oMedico.getPersona().getApellidoMaterno().trim());
    }
}
