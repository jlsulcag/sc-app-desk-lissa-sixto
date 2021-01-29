package lissa.gui;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import lissa.be.Procedimiento;
import lissa.be.Servicio;
import lissa.be.Tarifario;
import lissa.bl.ProcedimientoBl;
import lissa.controller.ServicioCtrl;
import lissa.controller.TarifarioCtrl;
import lissa.table.ModeloAdminServicioProcedimiento;
import lissa.table.ModeloBuscarProcedimiento;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_AdministrarProcedimiento extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private TarifarioCtrl oTarifarioCtrl;
    private ServicioCtrl oServicioCtrl;
    private Procedimiento oProcedimiento;
    private Procedimiento oProcedimientoTab;
    private Procedimiento oProcedimientoTemp;
    private ProcedimientoBl oProcedimientoBl;
    private ModeloAdminServicioProcedimiento oModeloAdminServicioProcedimiento;
    private int operacion = -1;
    public static final int NUEVO = 1, EDITAR = 2;
    private List<Procedimiento> listProcedimiento;

    public JIF_AdministrarProcedimiento(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloAdminServicioProcedimiento = new ModeloAdminServicioProcedimiento();
        tblResultados.setModel(oModeloAdminServicioProcedimiento);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txfBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfProcedimiento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxServicio = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txfCodigo = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setClosable(true);
        setTitle("Administrar Servicios y Procedimientos");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Servicio"));

        jLabel1.setText("Procedimiento : ");

        txfProcedimiento.setEnabled(false);

        jLabel5.setText("Servicio : ");

        cbxServicio.setEnabled(false);

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Código :");

        txfCodigo.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfProcedimiento)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbxServicio, 0, 242, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txfCodigo)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfProcedimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insertarServicioAdd();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cbxServicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txfBusqueda;
    private javax.swing.JTextField txfCodigo;
    private javax.swing.JTextField txfProcedimiento;
    // End of variables declaration//GEN-END:variables

    void iniciar() {
        operacion = -1;
        txfBusqueda.requestFocus();
        txfBusqueda.setText("");
        txfProcedimiento.setText("");
        txfCodigo.setText("");
        cargarCbxServicio();
        estadoBotones(true, false, false, false);
        oModeloAdminServicioProcedimiento.clear();
        personalizaTabla();
        habilitaDeshabilitaDatosServicio(false);
        oProcedimiento = null;
        oProcedimientoBl = null;
    }

    private void cargarCbxServicio() {
        oServicioCtrl = new ServicioCtrl(root);
        oServicioCtrl.rellenaCbx(cbxServicio);

    }

    private void registrar() {
        if (isDatosValidos()) {
            if (operacion == NUEVO) {
                oProcedimiento = new Procedimiento();
                oProcedimientoBl = new ProcedimientoBl();
                oProcedimiento.setServicio((Servicio) cbxServicio.getSelectedItem());
                oProcedimiento.setDenominacion(txfProcedimiento.getText().trim().toUpperCase());
                oProcedimiento.setEstado(1);
                oProcedimiento.setCodigo(txfCodigo.getText().trim().toUpperCase());

                oProcedimiento = oProcedimientoBl.registrar(oProcedimiento);

                if (oProcedimiento.getIdprocedimiento() > 0) {
                    Mensajes.msjRegCorrecta();
                    iniciar();
                } else {
                    Mensajes.msjRegError();
                }
            } else if (operacion == EDITAR) {
                if (oProcedimientoTab != null) {
                    oProcedimientoBl = new ProcedimientoBl();
                    oProcedimientoTemp = new Procedimiento();
                    oProcedimientoTemp.setIdprocedimiento(oProcedimientoTab.getIdprocedimiento());
                    oProcedimientoTemp.setServicio((Servicio) cbxServicio.getSelectedItem());
                    oProcedimientoTemp.setDenominacion(txfProcedimiento.getText().trim().toUpperCase());
                    oProcedimientoTemp.setEstado(1);
                    oProcedimientoTemp.setCodigo(txfCodigo.getText().trim().toUpperCase());

                    if (oProcedimientoBl.actualizar(oProcedimientoTemp) == 0) {
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
        return (cbxServicio.getSelectedIndex() > 0
                && !txfProcedimiento.getText().trim().equals("")
                && !txfCodigo.getText().trim().equals(""));
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
        oModeloAdminServicioProcedimiento.clear();
        personalizaTabla();
        habilitaDeshabilitaDatosServicio(true);
        estadoBotones(false, false, true, true);
    }

    private void personalizaTabla() {
        Utilitarios.formateaColumna(0, tblResultados, 60);

    }

    private void habilitaDeshabilitaDatosServicio(boolean estado) {
        cbxServicio.setEnabled(estado);
        txfProcedimiento.setEnabled(estado);
        txfCodigo.setEnabled(estado);
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
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            oProcedimientoTab = oModeloAdminServicioProcedimiento.get(tblResultados.getSelectedRow());
            if (oProcedimientoTab != null) {
                oServicioCtrl.recuperaDatosCbx(oProcedimientoTab.getServicio().getIdservicio(), cbxServicio);
                txfProcedimiento.setText(oProcedimientoTab.getDenominacion());
                txfCodigo.setText(oProcedimientoTab.getCodigo());
                estadoBotones(false, true, false, true);
                habilitaDeshabilitaDatosServicio(false);
            }
        } else {
            Mensajes.tblSelected();
        }
    }

    private void buscar() {
        listProcedimiento = new LinkedList<>();
        oProcedimientoBl = new ProcedimientoBl();
        oModeloAdminServicioProcedimiento.clear();
        if (!txfBusqueda.getText().trim().toUpperCase().equals("")) {
            String ref = txfBusqueda.getText().trim().toUpperCase();
            listProcedimiento = oProcedimientoBl.listarRef(ref);
            if (!listProcedimiento.isEmpty()) {
                for (Procedimiento procedimiento : listProcedimiento) {
                    oModeloAdminServicioProcedimiento.add(procedimiento);
                }
            } else {
                oModeloAdminServicioProcedimiento.clear();
            }
        } else {
            oModeloAdminServicioProcedimiento.clear();
        }
    }

    private void insertarServicioAdd() {
        root.insertarInternalFrames(root.jifServicioAdd);
        root.jifServicioAdd.iniciar();
        root.jifServicioAdd.enviaJif(this);

    }
}
