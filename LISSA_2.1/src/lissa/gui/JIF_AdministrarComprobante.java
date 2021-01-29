package lissa.gui;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lissa.be.Comprobante;
import lissa.be.Atencion;
import lissa.be.Persona;
import lissa.bl.PersonaBl;
import lissa.bl.ComprobanteBl;
import lissa.bl.PacienteBl;
import lissa.ds.DSConeccion;
import lissa.reportes.ReportGeneric;
import lissa.table.ModeloAdminComprobante;
import lissa.table.ModeloComprobante;
import lissa.table.ModeloPersonas;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import net.sf.jasperreports.engine.JRException;

public class JIF_AdministrarComprobante extends javax.swing.JInternalFrame {

    private JF_Principal root = null;
    private ComprobanteBl oBlComprobante = null;
    private Comprobante oComprobante = null;
    private Persona beanTablaPer = null;
    private Comprobante beanTablaComp = null;
    private ModeloPersonas oModeloPersonas = null;
    private ModeloAdminComprobante oModeloAdminComprobante = null;

    //Variables para el reporte
    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;

    private ArrayList<Comprobante> listComprobante = null;
    private Persona oPersona = null;
    private PersonaBl oBlPersona = null;
    private ArrayList<Persona> listPacientes;
    private Atencion oPaciente = null;
    private PacienteBl oPacienteBl = null;

    public JIF_AdministrarComprobante(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloPersonas = new ModeloPersonas();
        tblResultados.setModel(oModeloPersonas);
        oModeloAdminComprobante = new ModeloAdminComprobante();
        tblComprobantes.setModel(oModeloAdminComprobante);
        personalizaVistaTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txfPaciente = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblComprobantes = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        rbtnActivo = new javax.swing.JRadioButton();
        rbtnAnulado = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaMotivoAnulacion = new javax.swing.JTextArea();
        btnAnular = new javax.swing.JButton();
        btnReImprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Administrar Comprobantes");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

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

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/search.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Dni / Apellidos y Nombres :");

        txfPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfPacienteActionPerformed(evt);
            }
        });

        tblComprobantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblComprobantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblComprobantesMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblComprobantes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfPaciente)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txfPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Administrar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));

        buttonGroup1.add(rbtnActivo);
        rbtnActivo.setText("Activo");

        buttonGroup1.add(rbtnAnulado);
        rbtnAnulado.setText("Anulado");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rbtnAnulado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbtnActivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnActivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnAnulado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Motivo de Anulación"));

        txaMotivoAnulacion.setColumns(20);
        txaMotivoAnulacion.setRows(5);
        jScrollPane2.setViewportView(txaMotivoAnulacion);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        btnReImprimir.setText("Re Imprimir");
        btnReImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnular))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnular)
                    .addComponent(btnReImprimir))
                .addGap(0, 11, Short.MAX_VALUE))
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarPaciente();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseReleased
        if (tblResultados.getSelectedRow() != -1 && tblResultados.getRowSelectionAllowed()) {
            beanTablaPer = (Persona) oModeloPersonas.get(tblResultados.getSelectedRow());
            if (beanTablaPer != null) {
                oBlComprobante = new ComprobanteBl();
                listComprobante = oBlComprobante.listar(beanTablaPer);
                if (!listComprobante.isEmpty()) {
                    oModeloAdminComprobante.addAll(listComprobante);
                } else {
                    JOptionPane.showMessageDialog(null, "No Existe Comprobante para esta persona", "Atención", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        } else {
            Mensajes.tblSelected();
        }
        personalizaVistaTabla();

    }//GEN-LAST:event_tblResultadosMouseReleased

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        anularBoleta();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnAnularActionPerformed

    private void btnReImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReImprimirActionPerformed
        reimprimir();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnReImprimirActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        resetComponent();
        personalizaVistaTabla();
    }//GEN-LAST:event_formInternalFrameClosing

    private void txfPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPacienteActionPerformed
        btnBuscar.doClick();
    }//GEN-LAST:event_txfPacienteActionPerformed

    private void tblComprobantesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComprobantesMouseReleased
        beanTablaComp = (Comprobante) oModeloAdminComprobante.get(tblComprobantes.getSelectedRow());
        if (beanTablaComp.getEstado().equals("ACT")) {
            this.rbtnActivo.setSelected(true);
            this.txaMotivoAnulacion.setText("");
        } else if (beanTablaComp.getEstado().equals("ANU") || beanTablaComp.getEstado() == null) {
            this.rbtnAnulado.setSelected(true);
            this.txaMotivoAnulacion.setText(beanTablaComp.getMotivoAnulacion());
        }
    }//GEN-LAST:event_tblComprobantesMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnReImprimir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rbtnActivo;
    private javax.swing.JRadioButton rbtnAnulado;
    private javax.swing.JTable tblComprobantes;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextArea txaMotivoAnulacion;
    private javax.swing.JTextField txfPaciente;
    // End of variables declaration//GEN-END:variables

    private void buscarComprobante() {
        oBlComprobante = new ComprobanteBl();
        oComprobante = new Comprobante();

        if (!txfPaciente.getText().toUpperCase().trim().equals("")) {
            String nombres = txfPaciente.getText().toUpperCase().trim();
            listComprobante = oBlComprobante.buscarXNombre(nombres);

            //unan vez obtenido la lista de comprobantes para un paciente
            //se debe buscar cada objeto que senecite y este asociado a este
            for (Comprobante listComprobante1 : listComprobante) {

            }
            if (!listComprobante.isEmpty()) {
//                oModeloComprobante.addAll(listComprobante);
            } else {
                JOptionPane.showMessageDialog(null, "No existen comprobantes para este paciente", "Atención", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese los parámetros de búsqueda", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void anularBoleta() {
        oComprobante = new Comprobante();
        oBlComprobante = new ComprobanteBl();
        if (beanTablaComp != null && tblComprobantes.getSelectedRow() != -1) {
            if (!beanTablaComp.getEstado().trim().equals("ANU")) {
                oComprobante = beanTablaComp;
                if (rbtnAnulado.isSelected()) {
                    oComprobante.setEstado("ANU");
                    oComprobante.setMotivoAnulacion(txaMotivoAnulacion.getText().toUpperCase().trim());
                    oBlComprobante.actualizar(oComprobante);
                    JOptionPane.showMessageDialog(null, "Comprobante anulado", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    resetComponent();
                } else {
                    JOptionPane.showMessageDialog(null, "Cambie el estado del comprobante", "Atención", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El comprobante ya está anulado", "Atención", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un comprobante", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void reimprimir() {
        if (beanTablaComp != null && tblComprobantes.getSelectedRow() != -1) {
            if (beanTablaComp.getEstado().equals("ACT")) {
                if (beanTablaComp.getTipoComprobante().getIdtipocomprobante() == 1) {
                    imprimirFactura(beanTablaComp);
                } else if (beanTablaComp.getTipoComprobante().getIdtipocomprobante() == 2) {
                    imprimirBoleta(beanTablaComp);
                } else {
                    JOptionPane.showMessageDialog(null, "Este comprobante no se puede re-imprimir", "Atención", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El comprobante está anulado", "Atención", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un comprobante válido", "Atención", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetComponent() {
        txfPaciente.setText("");
        txaMotivoAnulacion.setText("");
        rbtnActivo.setSelected(false);
        rbtnAnulado.setSelected(false);
        oModeloAdminComprobante.clear();
        oModeloPersonas.clear();
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblResultados, 80);
        Utilitarios.formateaColumna(0, tblComprobantes, 80);
        Utilitarios.formateaColumna(1, tblComprobantes, 80);
    }

    private void buscarPaciente() {
        oBlPersona = new PersonaBl();
        listPacientes = oBlPersona.buscar(txfPaciente.getText().toUpperCase().trim());
        if (!listPacientes.isEmpty()) {
            oModeloPersonas.addAll(listPacientes);
        }
    }

    private void imprimirFactura(Comprobante beanTablaComp) {
        try {
            ds = new lissa.ds.DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport("FacturaElectronica", new String[]{"ID_COMPROBANTE"}, new Object[]{beanTablaComp.getIdcomprobante()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Comprobante");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
        } catch (Exception ex) {
            Logger.getLogger(JIF_AdministrarComprobante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void imprimirBoleta(Comprobante beanTablaComp) {
        try {
            ds = new lissa.ds.DSConeccion(root.getConfig());
            reportGenric = new ReportGeneric(ds.getConeccion());
            reportGenric.setReportParent("/lissa/reportes/");
            reportPanel = reportGenric.mkReport("BoletaElectronica", new String[]{"ID_COMPROBANTE"}, new Object[]{beanTablaComp.getIdcomprobante()});
            reportVisor = new JInternalFrame();
            reportVisor.setTitle("Comprobante");
            reportVisor.setIconifiable(true);
            reportVisor.setClosable(true);
            reportVisor.getContentPane().add(reportPanel);
            root.insertarInternalFrames(reportVisor);
            reportVisor.setMaximum(true);
        } catch (Exception ex) {
            Logger.getLogger(JIF_AdministrarComprobante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
