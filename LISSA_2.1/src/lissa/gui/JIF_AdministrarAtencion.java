package lissa.gui;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.ComprobanteDetalle;
import lissa.be.Medico;
import lissa.be.Usuario;
import lissa.bl.ItemsComprobanteBl;
import lissa.table.ModeloAdminAtencion;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_AdministrarAtencion extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private Usuario oUsuario;
    private ModeloAdminAtencion oModeloAdminAtencion;
    private ArrayList<ComprobanteDetalle> listComprobanteDetalle;
    private ItemsComprobanteBl oComprobanteDetalleBl;
    private ComprobanteDetalle oComprobanteDetalle;
    private ComprobanteDetalle oComprobanteDetalleTemp;
    private Medico oMedicoAtiendeReal;//Variable para almacenar  al medico quien atiende realmente 

    public JIF_AdministrarAtencion(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloAdminAtencion = new ModeloAdminAtencion();
        tblAtenciones.setModel(oModeloAdminAtencion);

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
        jLabel4 = new javax.swing.JLabel();
        txfNumeroHc = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAtenciones = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txfMedicoReal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txfObservacion = new javax.swing.JTextField();
        btnGuardarObservacion = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Administrar Atencion");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));

        jLabel1.setText("Inicio :");

        jLabel2.setText("Fecha Fin :");

        btnProcesar.setText("Procesar");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        jLabel4.setText("N° HC :");

        txfNumeroHc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNumeroHcActionPerformed(evt);
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
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfNumeroHc, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProcesar)
                .addContainerGap(367, Short.MAX_VALUE))
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
                    .addComponent(jLabel4)
                    .addComponent(txfNumeroHc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("..."));

        jLabel3.setText("Médico Atención Real :");

        txfMedicoReal.setEnabled(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Observación :");

        btnGuardarObservacion.setText("Guardar Observación");
        btnGuardarObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarObservacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfMedicoReal, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
                    .addComponent(txfObservacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addComponent(btnGuardarObservacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txfObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarObservacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfMedicoReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insertarPantallaBusquedaMedicos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        guardarCambios();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txfNumeroHcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNumeroHcActionPerformed
        btnProcesar.doClick();
    }//GEN-LAST:event_txfNumeroHcActionPerformed

    private void btnGuardarObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarObservacionActionPerformed
        guardarObservacion();
    }//GEN-LAST:event_btnGuardarObservacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarObservacion;
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
    private javax.swing.JTextField txfMedicoReal;
    private javax.swing.JTextField txfNumeroHc;
    private javax.swing.JTextField txfObservacion;
    // End of variables declaration//GEN-END:variables

    void resetComponents() {
        jdcFechaInicio.setDate(null);
        jdcFechaFin.setDate(null);
        personalizaVistaTabla();
        if (oMedicoAtiendeReal != null) {
            oMedicoAtiendeReal = null;
        }
        if (oComprobanteDetalle != null) {
            oComprobanteDetalle = null;
        }
        oModeloAdminAtencion.clear();
        personalizaVistaTabla();
        txfMedicoReal.setText("");
    }

    void resetBusqueda() {
        if (oMedicoAtiendeReal != null) {
            oMedicoAtiendeReal = null;
        }
        if (oComprobanteDetalle != null) {
            oComprobanteDetalle = null;
        }
        oModeloAdminAtencion.clear();
        personalizaVistaTabla();
        txfMedicoReal.setText("");
        txfObservacion.setText("");
        btnProcesar.doClick();
    }

    void enviarDatos(Usuario user) {
        oUsuario = user;
        resetComponents();
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblAtenciones, 60);
        Utilitarios.formateaColumna(1, tblAtenciones, 120);
        Utilitarios.formateaColumna(2, tblAtenciones, 70);
        Utilitarios.formateaColumna(4, tblAtenciones, 80);
    }

    private void listarComprobanteDetalle() {
        listComprobanteDetalle = new ArrayList<>();
        oComprobanteDetalleBl = new ItemsComprobanteBl();
        oModeloAdminAtencion.clear();
        if (isDatosValidosBusquedaxRangoyNumeroHC()) {
            listComprobanteDetalle = oComprobanteDetalleBl.buscarxRangoYNumeroHC(jdcFechaInicio.getDate(), jdcFechaFin.getDate(), txfNumeroHc.getText().trim());
            //Validar si existe el numero de HC
            if (!listComprobanteDetalle.isEmpty()) {
                for (ComprobanteDetalle obj : listComprobanteDetalle) {
                    oModeloAdminAtencion.add(obj);
                }
            } else {
                Mensajes.NoExisteResultadoBusqueda();
            }
        } else if (isDatosValidosBusquedaxNumeroHC()) {
            listComprobanteDetalle = oComprobanteDetalleBl.buscarxNumeroHC(txfNumeroHc.getText().trim());
            //Validar si existe el numero de HC
            if (!listComprobanteDetalle.isEmpty()) {
                for (ComprobanteDetalle obj : listComprobanteDetalle) {
                    oModeloAdminAtencion.add(obj);
                }
            } else {
                Mensajes.NoExisteResultadoBusqueda();
            }

        } else if (isDatosValidosBusquedaxFecha()) {
            listComprobanteDetalle = oComprobanteDetalleBl.listarxRango(jdcFechaInicio.getDate(), jdcFechaFin.getDate());
            if (!listComprobanteDetalle.isEmpty()) {
                for (ComprobanteDetalle obj : listComprobanteDetalle) {
                    oModeloAdminAtencion.add(obj);
                }
            } else {
                Mensajes.NoExisteResultadoBusqueda();
            }
        } else {
            Mensajes.msjValidarIngreso();
        }
    }

    private boolean isDatosValidosBusquedaxFecha() {
        return (jdcFechaInicio.getDate() != null
                && jdcFechaFin.getDate() != null);
    }

    private boolean isDatosValidosBusquedaxNumeroHC() {
        return (!txfNumeroHc.getText().trim().equals(""));
    }

    private boolean isDatosValidosBusquedaxRangoyNumeroHC() {
        return (jdcFechaInicio.getDate() != null
                && jdcFechaFin.getDate() != null
                && !txfNumeroHc.getText().trim().equals(""));
    }

    private void obtenerDatos() {
        if (tblAtenciones.getRowSelectionAllowed() && tblAtenciones.getSelectedRow() != -1) {
            oComprobanteDetalle = oModeloAdminAtencion.get(tblAtenciones.getSelectedRow());
            if (oComprobanteDetalle != null) {
                if (oComprobanteDetalle.getMedicoatiendereal() != null) {
                    txfMedicoReal.setText(oComprobanteDetalle.getMedicoatiendereal().getPersona().getNombre().trim() + " "
                            + oComprobanteDetalle.getMedicoatiendereal().getPersona().getApellidoPaterno().trim() + " "
                            + oComprobanteDetalle.getMedicoatiendereal().getPersona().getApellidoMaterno().trim());
                } else if (oComprobanteDetalle.getMedicoByIdMedicoAtiende() != null) {
                    oMedicoAtiendeReal = oComprobanteDetalle.getMedicoByIdMedicoAtiende();
                    txfMedicoReal.setText(oMedicoAtiendeReal.getPersona().getNombre().trim() + " " + oMedicoAtiendeReal.getPersona().getApellidoPaterno().trim() + " " + oMedicoAtiendeReal.getPersona().getApellidoMaterno().trim());
                } else {
                    txfMedicoReal.setText("");
                    oMedicoAtiendeReal = null;
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

    void cargarDatosMedicoA(Medico beanTabla) {
        oMedicoAtiendeReal = beanTabla;
        txfMedicoReal.setText(oMedicoAtiendeReal.getPersona().getNombre().trim() + " " + oMedicoAtiendeReal.getPersona().getApellidoPaterno().trim() + " " + oMedicoAtiendeReal.getPersona().getApellidoMaterno().trim());
    }

    private void guardarCambios() {
        int res = -1;
        oComprobanteDetalleBl = new ItemsComprobanteBl();
        if (isdatosValidos()) {
            oComprobanteDetalleTemp = oComprobanteDetalle;
            oComprobanteDetalleTemp.setMedicoatiendereal(oMedicoAtiendeReal);
            oComprobanteDetalleTemp.setEstado("ACT");
            oComprobanteDetalleTemp.setFechaAtencion(new Date());
            res = oComprobanteDetalleBl.actualizar(oComprobanteDetalleTemp);
            if (res == 0) {
                Mensajes.msjRegCorrecta();
                resetBusqueda();
            } else {
                Mensajes.msjRegError();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error .. Faltan Datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isdatosValidos() {
        return (oMedicoAtiendeReal != null
                && tblAtenciones.getSelectedRow() != -1);
    }

    private void guardarObservacion() {
        int res = -1;
        oComprobanteDetalleBl = new ItemsComprobanteBl();
        if (isDatosValidosObservacion()) {
            oComprobanteDetalleTemp = oComprobanteDetalle;
            oComprobanteDetalleTemp.setObservacionTriaje(txfObservacion.getText().trim().toUpperCase());
            res = oComprobanteDetalleBl.actualizar(oComprobanteDetalleTemp);
            if (res == 0) {
                //Mensajes.msjRegCorrecta();
                resetBusqueda();
            } else {
                Mensajes.msjRegError();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error .. Ingrese Observación", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isDatosValidosObservacion() {
        return (!txfObservacion.getText().trim().equals("")
                && tblAtenciones.getSelectedRow() != -1);
    }
}
