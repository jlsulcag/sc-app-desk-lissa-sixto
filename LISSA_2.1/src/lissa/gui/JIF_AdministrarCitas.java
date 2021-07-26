package lissa.gui;

import java.awt.Color;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.Cita;
import lissa.be.CitaDetalle;
import lissa.be.Medico;
import lissa.be.Persona;
import lissa.be.Servicio;
import lissa.be.Usuario;
import lissa.bl.CitaBl;
import lissa.bl.CitaDetalleBl;
import lissa.controller.MedicoCtrl;
import lissa.controller.ServicioCtrl;
import lissa.table.ModeloCita;
import lissa.table.ModeloCitaDetalle;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Constants;

/**
 *
 * @author JSULCAG
 */
public class JIF_AdministrarCitas extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private Cita oCita;
    private CitaBl oCitaBl;
    private ModeloCita oModeloCita;
    private ModeloCitaDetalle oModeloCitaDetalle;
    private Persona oPersona;
    private Medico oMedico;
    private Servicio oServicio;
    private Usuario oUsuario;
    private ServicioCtrl oServicioCtrl;
    private MedicoCtrl oMedicoCtrl;
    private List<CitaDetalle> listCitaDetalle;
    private List<Cita> listCitas;
    private List<CitaDetalle> listCitaDetalles;
    private CitaDetalle oCitaDetalle;
    private CitaDetalle oCitaDetalleTemp;
    private CitaDetalleBl oCitaDetalleBl;

    public JIF_AdministrarCitas(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloCita = new ModeloCita();
        tblCitas.setModel(oModeloCita);
        oModeloCitaDetalle = new ModeloCitaDetalle(root);
        tblCitaDetalle.setModel(oModeloCitaDetalle);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCitaDetalle = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCitas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        cbxServicio = new javax.swing.JComboBox();
        cbxMedico = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnProcesos = new javax.swing.JButton();

        setClosable(true);
        setTitle("Administrar Citas");

        tblCitaDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCitaDetalle);

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
        jScrollPane2.setViewportView(tblCitas);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda"));

        jLabel2.setText("Medico :");

        jLabel3.setText("Fecha :");

        jLabel4.setText("Servicio :");

        cbxServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxServicioActionPerformed(evt);
            }
        });

        cbxMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMedicoActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar");
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
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxServicio, 0, 526, Short.MAX_VALUE)
                    .addComponent(cbxMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(cbxServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(cbxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(2, 2, 2))
        );

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnProcesos.setText("Anular");
        btnProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 961, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProcesos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnProcesos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        root.insertarInternalFrames(root.jifRegistrarCita);
        root.jifRegistrarCita.setoUsuario(oUsuario);
        root.jifRegistrarCita.iniciar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void cbxServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxServicioActionPerformed
        //filtrarXServicio();
    }//GEN-LAST:event_cbxServicioActionPerformed

    private void tblCitasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCitasMouseReleased
        obtenerDatosCita();
    }//GEN-LAST:event_tblCitasMouseReleased

    private void cbxMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMedicoActionPerformed
        //filtrarXmedico();
    }//GEN-LAST:event_cbxMedicoActionPerformed

    private void btnProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesosActionPerformed
        anular();
    }//GEN-LAST:event_btnProcesosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listarCitas();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        iniciar();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Constants declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnProcesos;
    private javax.swing.JComboBox cbxMedico;
    private javax.swing.JComboBox cbxServicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTable tblCitaDetalle;
    private javax.swing.JTable tblCitas;
    // End of variables declaration//GEN-END:variables

    void iniciar() {
        cargarCbxServicio();
        cargarCbxMedico();
        jdcFecha.setDate(new Date());
        oModeloCita.clear();
        oModeloCitaDetalle.clear();
        if (oPersona != null) {
            oPersona = null;
        }
        if (oMedico != null) {
            oMedico = null;
        }
        if (oServicio != null) {
            oServicio = null;
        }
        personalizaVistaTabla();
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblCitas, 60);
        Utilitarios.formateaColumna(1, tblCitas, 80);
        Utilitarios.formateaColumna(2, tblCitas, 80);
        Utilitarios.formateaColumna(4, tblCitas, 100);
        Utilitarios.formateaColumna(6, tblCitas, 120);
        Utilitarios.formateaColumna(0, tblCitaDetalle, 60);
        Utilitarios.formateaColumna(4, tblCitaDetalle, 80);
    }

    public Usuario getoUsuario() {
        return oUsuario;
    }

    public void setoUsuario(Usuario oUsuario) {
        this.oUsuario = oUsuario;
    }

    private void cargarCbxServicio() {
        oServicioCtrl = new ServicioCtrl(root);
        oServicioCtrl.rellenaCbx(cbxServicio);
    }

    private void cargarCbxMedico() {
        oMedicoCtrl = new MedicoCtrl(root);
        oMedicoCtrl.rellenaMedico(cbxMedico);
    }
    /*
    private void filtrarXServicio() {
        oCitaBl = new CitaBl();
        listCitaDetalle = new LinkedList<>();
        oModeloCita.clear();
        oModeloCitaDetalle.clear();
        if (isDatosValidosxServicio()) {
            listCitaDetalle = oCitaBl.listarxServicioFecha(((Servicio) cbxServicio.getSelectedItem()).getIdservicio(), jdcFecha.getDate());
            for (CitaDetalle obj : listCitaDetalle) {
                oModeloCita.add(obj);
                personalizaVistaTabla();
            }
        }
    }
    
    private boolean isDatosValidosxServicio() {
        return (jdcFecha.getDate() != null
                && cbxServicio.getSelectedIndex() > 0);
    }
    */
    private void obtenerDatosCita() {
        oCitaDetalleBl = new CitaDetalleBl();
        if (tblCitas.getRowSelectionAllowed() && tblCitas.getSelectedRow() != -1) {
            oCitaDetalleTemp = oModeloCita.get(tblCitas.getSelectedRow());
            if (oCitaDetalleTemp != null) {
                listarDetalleCita(oCitaDetalleTemp.getCita().getIdcita());
                personalizaVistaTabla();
            }
        }
    }

    private void listarDetalleCita(long idcita) {
        listCitaDetalles = new LinkedList<>();
        oModeloCitaDetalle.clear();
        listCitaDetalles = oCitaDetalleBl.listarxIdCita(idcita);
        for (CitaDetalle obj : listCitaDetalles) {
            oModeloCitaDetalle.add(obj);
        }
    }
    /*
    private void filtrarXmedico() {
        oCitaBl = new CitaBl();
        listCitaDetalle = new LinkedList<>();
        oModeloCita.clear();
        oModeloCitaDetalle.clear();
        if (isDatosValidosxMedico()) {
            listCitaDetalle = oCitaBl.listarxMedicoFecha(((Medico) cbxMedico.getSelectedItem()).getIdMedico(), jdcFecha.getDate());
            for (CitaDetalle obj : listCitaDetalle) {
                oModeloCita.add(obj);
                personalizaVistaTabla();
            }
        }
    }
    
    private boolean isDatosValidosxMedico() {
        return (jdcFecha.getDate() != null
                && cbxMedico.getSelectedIndex() > 0);
    }
    */
    private void anular() {
        if (tblCitas.getRowSelectionAllowed() && tblCitas.getSelectedRow() != -1) {
            oCitaBl = new CitaBl();
            if (oCitaDetalleTemp.getCita().getEstado().equals("REG")) {
                oCitaDetalleTemp.getCita().setEstado("ANULADO");
                if (oCitaBl.actualizar(oCitaDetalleTemp.getCita()) == Constants.SUCCESS) {
                    Mensajes.procesoSatisfactorio();
                } else {
                    Mensajes.procesoError();
                }
            } else {
                JOptionPane.showMessageDialog(null, "La cita debe estar en estado REG", "Atención", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            Mensajes.tblSelected();
        }
    }

    private void listarCitas() {
        if (isFechaValida()) {
            oCitaBl = new CitaBl();
            listCitaDetalles = new LinkedList<>();
            oModeloCita.clear();
            oModeloCitaDetalle.clear();
            listCitaDetalles = oCitaBl.listarCitas(jdcFecha.getDate(), cbxMedico.getSelectedIndex() > 0 ? ((Medico) cbxMedico.getSelectedItem()).getIdMedico() : 0, cbxServicio.getSelectedIndex() > 0 ? ((Servicio) cbxServicio.getSelectedItem()).getIdservicio() : 0);
            if (!listCitaDetalles.isEmpty()) {
                for (CitaDetalle obj : listCitaDetalles) {
                    oModeloCita.add(obj);
                    personalizaVistaTabla();
                }
            }else{
                Mensajes.msjResultVacio();
            }

        } else {
            Mensajes.msjParametroFechaVacio();
        }
    }

    private boolean isFechaValida() {
        return (jdcFecha.getDate() != null);
    }
}
