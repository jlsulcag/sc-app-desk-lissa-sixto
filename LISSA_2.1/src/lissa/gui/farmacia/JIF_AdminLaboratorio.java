package lissa.gui.farmacia;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import lissa.be.Laboratorio;
import lissa.bl.LaboratorioBl;
import lissa.gui.JF_Principal;
import lissa.table.ModeloLaboratorio;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_AdminLaboratorio extends javax.swing.JInternalFrame {

    private JF_Principal root;
    //variables para las tablas
    private ModeloLaboratorio modeloLaboratorio;
    private ArrayList<Laboratorio> listLaboratorio;
    //Objetos para Laboratorio
    private Laboratorio oLaboratorio = null;
    private LaboratorioBl oLaboratorioBl = null;

    private Laboratorio beanTabla;
    //banderas
    private int banBoton = 0;

    public JIF_AdminLaboratorio(JF_Principal root) {
        initComponents();
        this.root = root;
        modeloLaboratorio = new ModeloLaboratorio();
        tblResultados.setModel(modeloLaboratorio);
        personalizaVistaTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txfDenominacion = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txfBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Administración Laboratorio");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Denominacion :");

        txfDenominacion.setEnabled(false);
        txfDenominacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfDenominacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txfDenominacion)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfDenominacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));

        jLabel2.setText("Laboratorio :");

        txfBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBusquedaActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfBusqueda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/new.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/edit.png"))); // NOI18N
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Save.png"))); // NOI18N
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/cancel.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void txfDenominacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfDenominacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfDenominacionActionPerformed

    private void txfBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBusquedaActionPerformed
        btnBuscar.doClick();
    }//GEN-LAST:event_txfBusquedaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarLaboratorio();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseReleased
        if (tblResultados.getRowSelectionAllowed()) {
            obtenerDatosTabla();
            estadoTextFields(false);
            activarBotones(true, true, false, true);
            resetPaintComponent();
        }
    }//GEN-LAST:event_tblResultadosMouseReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        configuraNuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblResultados.getSelectedRow() != -1) {
            configuraActualizar();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un item", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        configuraGuardar();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        configuraCancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txfBusqueda;
    private javax.swing.JTextField txfDenominacion;
    // End of variables declaration//GEN-END:variables

    private void buscarLaboratorio() {
        oLaboratorio = new Laboratorio();
        oLaboratorioBl = new LaboratorioBl();
        String ref = txfBusqueda.getText().trim().toUpperCase();
        modeloLaboratorio.addAll(oLaboratorioBl.buscarF(ref));
        personalizaVistaTabla();
        estadoTextFields(false);
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblResultados, 80);
    }

    private void estadoTextFields(boolean e) {
        this.txfDenominacion.setEnabled(e);
    }

    private void obtenerDatosTabla() throws SecurityException {
        resetComponent();
        beanTabla = (Laboratorio) modeloLaboratorio.get(tblResultados.getSelectedRow());
        this.txfDenominacion.setText(beanTabla.getDenominacion());
    }

    private void resetComponent() {
        this.txfDenominacion.setText("");
        Utilitarios.resetPaintBorderTxf(txfDenominacion);
    }

    private void resetPaintComponent() {
        Utilitarios.resetPaintTxf(txfDenominacion);
    }

    private void actualizar() {
        //actualizarPresentacion();
        int res = actualizarLaboratorio();
        if (res == 0) {
            Mensajes.msjActCorrecta();
        } else {
            Mensajes.msjActErronea();
        }
    }

    private int actualizarLaboratorio() {
        oLaboratorio = new Laboratorio();
        oLaboratorioBl = new LaboratorioBl();

        oLaboratorio.setIdlaboratorio(beanTabla.getIdlaboratorio());
        oLaboratorio.setDenominacion(txfDenominacion.getText().trim().toUpperCase());
        oLaboratorio.setEstado(true);
        return oLaboratorioBl.actualizar(oLaboratorio);

    }

    private void activarBotones(boolean nuevo, boolean modificar, boolean guardar, boolean cancelar) {
        btnNuevo.setEnabled(nuevo);
        btnEditar.setEnabled(modificar);
        btnGuardar.setEnabled(guardar);
        btnCancelar.setEnabled(cancelar);
    }

    private void configuraGuardar() {
        if (banBoton == 1) {
            if (isDatosValidos()) {
                registrar();
                resetComponent();
                estadoTextFields(false);
                resetPaintComponent();
                buscarLaboratorio();
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                paintComponent();
            }

        } else if (banBoton == 2) {
            if (isDatosValidos()) {
                actualizar();
                //buscar por razon social y listar en la tabla
                buscarxDenominacion(txfDenominacion.getText().toUpperCase().trim());
                //resetear componentes
                resetComponent();
                estadoTextFields(false);
                resetPaintComponent();
                //buscarPersonaJuridica();
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
                paintComponent();
            }
        }

    }

    public void paintComponent() {
         Utilitarios.paintBorderTxfVacio(txfDenominacion);
    }

    private boolean isDatosValidos() {
        return (!this.txfDenominacion.getText().trim().equals(""));
    }

    private void registrar() {
        //registrarPersona();
        if (registrarLaboratorio() != null) {
            Mensajes.msjRegCorrecta();
        } else {
            Mensajes.msjRegError();
        }
    }

    private Object registrarLaboratorio() {
        oLaboratorio = new Laboratorio();
        LaboratorioBl oLaboratorioBl = new LaboratorioBl();

        oLaboratorio.setDenominacion(txfDenominacion.getText().toUpperCase().trim());
        oLaboratorio.setEstado(true);

        return oLaboratorioBl.registrar(oLaboratorio);
    }

    private void buscarxDenominacion(String denominacion) {
        oLaboratorioBl = new LaboratorioBl();
        listLaboratorio = oLaboratorioBl.buscarF(denominacion);
        if (!listLaboratorio.isEmpty()) {
            modeloLaboratorio.addAll(listLaboratorio);
        } else {
            Mensajes.msjResultVacio();
        }
        personalizaVistaTabla();
    }

    private void configuraCancelar() {
        resetComponent();
        estadoTextFields(false);
        activarBotones(true, false, false, true);
        modeloLaboratorio.clear();
        oLaboratorio = null;
        personalizaVistaTabla();
    }

    private void configuraNuevo() {
        banBoton = 1;
        tblResultados.setEnabled(true);
        modeloLaboratorio.clear();
        resetComponent();
        resetPaintComponent();
        estadoTextFields(true);
        activarBotones(false, false, true, true);
        personalizaVistaTabla();
    }

    private void configuraActualizar() {
         banBoton = 2;
        estadoTextFields(true);
        activarBotones(true, false, true, true);
    }
}
