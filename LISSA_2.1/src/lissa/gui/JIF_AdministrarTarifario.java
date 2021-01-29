package lissa.gui;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import lissa.be.Procedimiento;
import lissa.be.ProcedimientoTarifario;
import lissa.be.Servicio;
import lissa.be.Tarifario;
import lissa.be.Usuario;
import lissa.be.UsuarioPermiso;
import lissa.bl.ProcedimientoTarifarioBl;
import lissa.bl.UsuarioPermisoBl;
import lissa.controller.ProcedimientoCtrl;
import lissa.controller.ServicioCtrl;
import lissa.controller.TarifarioCtrl;
import lissa.table.ModeloBuscarProcedimiento;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_AdministrarTarifario extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private TarifarioCtrl oTarifarioCtrl;
    private ServicioCtrl oServicioCtrl;
    private ProcedimientoCtrl oProcedimientoCtrl;
    private ProcedimientoTarifario oProcedimientoTarifario;
    private ProcedimientoTarifario oProcedimientoTarifarioTab;
    private ProcedimientoTarifario oProcedimientoTarifarioTemp;
    private ProcedimientoTarifarioBl oProcedimientoTarifarioBl;
    private ModeloBuscarProcedimiento oModeloBuscarProcedimiento;
    private int operacion = -1;
    public static final int NUEVO = 1, EDITAR = 2;
    private List<ProcedimientoTarifario> listProcedimiento;
    private Usuario oUsuario;
    private UsuarioPermiso oUsuarioPermiso;
    private UsuarioPermisoBl oUsuarioPermisoBl;

    public JIF_AdministrarTarifario(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloBuscarProcedimiento = new ModeloBuscarProcedimiento();
        tblResultados.setModel(oModeloBuscarProcedimiento);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txfBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txfCosto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxtarifario = new javax.swing.JComboBox();
        cbxServicio = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbxProcedimiento = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        rbtnHabilitado = new javax.swing.JRadioButton();
        rbtnDeshabilitado = new javax.swing.JRadioButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setClosable(true);
        setTitle("Administrar Tarifario");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados de búsqueda"));

        txfBusqueda.setBackground(new java.awt.Color(255, 255, 204));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txfBusqueda)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Servicio - Procedimiento"));

        jLabel2.setText("Costo S/.  : ");

        txfCosto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txfCosto.setEnabled(false);
        txfCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCostoKeyReleased(evt);
            }
        });

        jLabel4.setText("Tarifario : ");

        jLabel5.setText("Servicio : ");

        cbxtarifario.setEnabled(false);

        cbxServicio.setEnabled(false);
        cbxServicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxServicioItemStateChanged(evt);
            }
        });

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Procedimiento :");

        cbxProcedimiento.setEnabled(false);

        jLabel3.setText("Estado :");

        buttonGroup1.add(rbtnHabilitado);
        rbtnHabilitado.setText("Habilitado");
        rbtnHabilitado.setEnabled(false);

        buttonGroup1.add(rbtnDeshabilitado);
        rbtnDeshabilitado.setText("Des Habilitado");
        rbtnDeshabilitado.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxProcedimiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbxtarifario, 0, 332, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txfCosto)
                    .addComponent(cbxServicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbtnHabilitado)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnDeshabilitado)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxtarifario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rbtnHabilitado)
                    .addComponent(rbtnDeshabilitado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)
                    .addComponent(btnEditar)
                    .addComponent(btnNuevo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        registrar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txfCostoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCostoKeyReleased
        Utilitarios.validaCaracterNumericoMoneda(evt, txfCosto);
    }//GEN-LAST:event_txfCostoKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        preparaNuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        preparaEditar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tblResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseReleased
        obtenerDatos();
    }//GEN-LAST:event_tblResultadosMouseReleased

    private void txfBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBusquedaKeyReleased
        buscar();
        personalizaTabla();
    }//GEN-LAST:event_txfBusquedaKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbxServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxServicioItemStateChanged
        if (cbxServicio.getSelectedIndex() > 0) {
            rellenaCbxProcedimiento();
        } else {
            cbxProcedimiento.removeAllItems();
        }
    }//GEN-LAST:event_cbxServicioItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbxProcedimiento;
    private javax.swing.JComboBox cbxServicio;
    private javax.swing.JComboBox cbxtarifario;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnDeshabilitado;
    private javax.swing.JRadioButton rbtnHabilitado;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txfBusqueda;
    private javax.swing.JTextField txfCosto;
    // End of variables declaration//GEN-END:variables

    void iniciar() {
        operacion = -1;
        txfBusqueda.requestFocus();
        txfBusqueda.setText("");
        txfCosto.setText("");
        cargarCbxTarifario();
        cargarCbxServicio();
        estadoBotones(true, false, false, false);
        oModeloBuscarProcedimiento.clear();
        personalizaTabla();
        habilitaDeshabilitaDatosServicio(false);
        oProcedimientoTarifario = null;
        oProcedimientoTarifarioBl = null;
        oModeloBuscarProcedimiento.enviaUser(oUsuario);
        buttonGroup1.clearSelection();
    }

    public void cargarCbxTarifario() {
        oTarifarioCtrl = new TarifarioCtrl(root);
        oTarifarioCtrl.rellenaCbx(cbxtarifario);
    }

    private void cargarCbxServicio() {
        oServicioCtrl = new ServicioCtrl(root);
        oServicioCtrl.rellenaCbx(cbxServicio);
    }

    private void registrar() {
        if (isDatosValidos()) {
            if (operacion == NUEVO) {
                oProcedimientoTarifario = new ProcedimientoTarifario();
                oProcedimientoTarifarioBl = new ProcedimientoTarifarioBl();
                oProcedimientoTarifario.setTarifario((Tarifario) cbxtarifario.getSelectedItem());
                oProcedimientoTarifario.setProcedimiento((Procedimiento) cbxProcedimiento.getSelectedItem());
                oProcedimientoTarifario.setCosto(new BigDecimal(txfCosto.getText().trim()));
                oProcedimientoTarifario.setEstado(rbtnHabilitado.isSelected()==true?1:0);
                oProcedimientoTarifario = oProcedimientoTarifarioBl.registrar(oProcedimientoTarifario);

                if (oProcedimientoTarifario.getIdprocedimientotarifario() > 0) {
                    Mensajes.msjRegCorrecta();
                    iniciar();
                } else {
                    Mensajes.msjRegError();
                }
            } else if (operacion == EDITAR) {
                if (oProcedimientoTarifarioTab != null) {
                    oProcedimientoTarifarioBl = new ProcedimientoTarifarioBl();
                    oProcedimientoTarifarioTemp = new ProcedimientoTarifario();
                    oProcedimientoTarifarioTemp.setIdprocedimientotarifario(oProcedimientoTarifarioTab.getIdprocedimientotarifario());
                    oProcedimientoTarifarioTemp.setTarifario((Tarifario) cbxtarifario.getSelectedItem());
                    oProcedimientoTarifarioTemp.setProcedimiento((Procedimiento) cbxProcedimiento.getSelectedItem());
                    oProcedimientoTarifarioTemp.setCosto(new BigDecimal(txfCosto.getText().trim()));
                    oProcedimientoTarifarioTemp.setEstado(rbtnHabilitado.isSelected()==true?1:0);
                    if (oProcedimientoTarifarioBl.actualizar(oProcedimientoTarifarioTemp) == 0) {
                        Mensajes.msjActCorrecta();
                        iniciar();
                    } else {
                        Mensajes.msjActErronea();
                    }

                }

            }

        } else {
            Mensajes.msjValidarIngreso();
        }
    }

    private boolean isDatosValidos() {
        return (cbxtarifario.getSelectedIndex() > 0
                && cbxServicio.getSelectedIndex() > 0
                && cbxProcedimiento.getSelectedIndex() > 0
                && !txfCosto.getText().trim().equals(""));
    }

    private void estadoBotones(boolean nuevo, boolean editar, boolean guardar, boolean cancelar) {
        btnNuevo.setEnabled(nuevo);
        btnEditar.setEnabled(editar);
        btnGuardar.setEnabled(guardar);
        btnCancelar.setEnabled(cancelar);
    }

    private void preparaNuevo() {
        operacion = 1;
        txfBusqueda.setText("");
        oModeloBuscarProcedimiento.clear();
        personalizaTabla();
        habilitaDeshabilitaDatosServicio(true);
        estadoBotones(false, false, true, true);
    }

    private void personalizaTabla() {
        Utilitarios.formateaColumna(0, tblResultados, 60);
        Utilitarios.formateaColumna(4, tblResultados, 60);
        Utilitarios.alinearDatosColumnaTablaDerecha(4, tblResultados);
    }

    private void habilitaDeshabilitaDatosServicio(boolean estado) {
        cbxtarifario.setEnabled(estado);
        cbxServicio.setEnabled(estado);
        cbxProcedimiento.setEnabled(estado);
        txfCosto.setEnabled(estado);
        rbtnHabilitado.setEnabled(estado);
        rbtnDeshabilitado.setEnabled(estado);
    }

    private void cancelar() {
        iniciar();
    }

    private void preparaEditar() {
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            operacion = 2;
            habilitaDeshabilitaDatosServicio(true);
            estadoBotones(false, false, true, true);
        }

    }

    private void obtenerDatos() {
        oUsuarioPermisoBl = new UsuarioPermisoBl();
        oUsuarioPermiso = oUsuarioPermisoBl.buscarUsuarioPermiso(1, oUsuario.getIdUsuario());
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            oProcedimientoTarifarioTab = oModeloBuscarProcedimiento.get(tblResultados.getSelectedRow());
            if (oProcedimientoTarifarioTab != null) {
                oTarifarioCtrl.recuperaDatosCbx(oProcedimientoTarifarioTab.getTarifario().getIdtarifario(), cbxtarifario);
                oServicioCtrl.recuperaDatosCbx(oProcedimientoTarifarioTab.getProcedimiento().getServicio().getIdservicio(), cbxServicio);
                oProcedimientoCtrl.recuperaDatosCbx(oProcedimientoTarifarioTab.getProcedimiento().getIdprocedimiento(), cbxProcedimiento);                
                if (oUsuarioPermiso == null && oProcedimientoTarifarioTab.getTarifario().getEsconvenio() == 1) {
                    txfCosto.setText("**.**");
                } else {
                    txfCosto.setText(oProcedimientoTarifarioTab.getCosto().toString());
                }
                rbtnHabilitado.setSelected((oProcedimientoTarifarioTab.getEstado() == 1));
                rbtnDeshabilitado.setSelected((oProcedimientoTarifarioTab.getEstado() == 0));
                estadoBotones(false, true, false, true);
                habilitaDeshabilitaDatosServicio(false);
            }
        } else {
            Mensajes.tblSelected();
        }
    }

    private void buscar() {
        listProcedimiento = new LinkedList<>();
        oProcedimientoTarifarioBl = new ProcedimientoTarifarioBl();
        oModeloBuscarProcedimiento.clear();
        if (!txfBusqueda.getText().trim().toUpperCase().equals("")) {
            String ref = txfBusqueda.getText().trim().toUpperCase();
            listProcedimiento = oProcedimientoTarifarioBl.listarRef(ref);
            if (!listProcedimiento.isEmpty()) {
                for (ProcedimientoTarifario procedimiento : listProcedimiento) {
                    oModeloBuscarProcedimiento.add(procedimiento);
                }
            } else {
                oModeloBuscarProcedimiento.clear();
            }
        } else {
            oModeloBuscarProcedimiento.clear();
        }
    }

    private void rellenaCbxProcedimiento() {
        oProcedimientoCtrl = new ProcedimientoCtrl(root);
        oProcedimientoCtrl.rellenaCbxXidDependiente(cbxProcedimiento, ((Servicio) cbxServicio.getSelectedItem()).getIdservicio());
    }

    void enviarDatosUsuario(Usuario user) {
        this.oUsuario = user;
    }
}
