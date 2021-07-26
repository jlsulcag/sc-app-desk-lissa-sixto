package lissa.gui;

import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lissa.be.Comprobante;
import lissa.bl.ComprobanteBl;
import lissa.bl.DetalleVentaBl;
import lissa.ds.DSConeccion;
import lissa.gui.JF_Principal;
import lissa.gui.JIF_BuscarPersonaNatural;
import lissa.reportes.ReportGeneric;
import lissa.table.ModeloComprobanteClinica;
import lissa.util.Mensajes;
import lissa.util.Reportes;
import lissa.util.Utilitarios;
import lissa.util.Constants;

public class JIF_BuscarComprobante extends javax.swing.JInternalFrame {

    private Reportes rep;
    private JF_Principal root;
    private ModeloComprobanteClinica oModeloComprobanteClinica;
    //Variables para el reporte
    private ReportGeneric reportGenric = null;
    private JPanel reportPanel = null;
    private DSConeccion ds = null;
    private JInternalFrame reportVisor = null;
    //
    private Comprobante oComprobante;
    private Comprobante oComprobanteTemp;
    private ComprobanteBl oComprobanteBl;
    private List<Comprobante> listComprobante;

    public JIF_BuscarComprobante(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloComprobanteClinica = new ModeloComprobanteClinica();
        tblResultados.setModel(oModeloComprobanteClinica);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txfNumComprobante = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        btnImprimir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txfMotivoAnulacion = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Buscar Comprobante");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setText("N° Comprobante :");

        txfNumComprobante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNumComprobanteKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(604, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

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
        tblResultados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblResultadosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultados);

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jButton2.setText("Anular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Motivo de anulación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txfMotivoAnulacion)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txfMotivoAnulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImprimir)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimir)
                    .addComponent(jButton2))
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

    private void tblResultadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblResultadosKeyReleased

    }//GEN-LAST:event_tblResultadosKeyReleased

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        imprimirComprobante();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void tblResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseReleased
        obtenerDatos();
    }//GEN-LAST:event_tblResultadosMouseReleased

    private void txfNumComprobanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNumComprobanteKeyReleased
        Utilitarios.validaCaracterNumerico(evt, txfNumComprobante);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txfNumComprobante.getText().trim().equals("")) {
                buscarComprobantexNumero(Long.parseLong(txfNumComprobante.getText().trim().toUpperCase()));
                personalizarTabla();
            } else {
                Mensajes.msjValidarIngreso();
            }
        }
    }//GEN-LAST:event_txfNumComprobanteKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        anularComprobante();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Constants declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txfMotivoAnulacion;
    private javax.swing.JTextField txfNumComprobante;
    // End of variables declaration//GEN-END:variables

    private void buscarComprobantexNumero(long numero) {
        oComprobanteBl = new ComprobanteBl();
        oModeloComprobanteClinica.clear();
        listComprobante = oComprobanteBl.buscarXnumComprobante(numero);
        if (!listComprobante.isEmpty()) {
            for (Comprobante obj : listComprobante) {
                oModeloComprobanteClinica.add(obj);
            }
        } else {
            Mensajes.msjResultVacio();
        }
    }

    private void personalizarTabla() {
        Utilitarios.formateaColumna(0, tblResultados, 80);
    }

    private void obtenerDatos() {
        if (tblResultados.getSelectedRow() != -1 && tblResultados.getRowSelectionAllowed()) {
            oComprobante = oModeloComprobanteClinica.get(tblResultados.getSelectedRow());
        }
    }

    private void anularComprobante() {
        long res = -1;
        if (isDatosValidos()) {
            if (oComprobante.getEstado().trim().equals("ACT")) {
                oComprobanteTemp = oComprobante;
                oComprobanteTemp.setEstado("ANU");
                oComprobanteTemp.setMotivoAnulacion(txfMotivoAnulacion.getText().trim().toUpperCase());

                res = oComprobanteBl.actualizar(oComprobanteTemp);
                if (res == 0) {
                    Mensajes.msjActCorrecta();
                    inicializar();
                    resetObjects();
                } else {
                    Mensajes.msjActErronea();
                }
            } else if (oComprobante.getEstado().trim().equals("ANU")) {
                Mensajes.docAnulado();
            }

        } else {
            Mensajes.msjValidarIngreso();
        }
    }

    private boolean isDatosValidos() {
        return (tblResultados.getSelectedRow() != -1
                && tblResultados.getRowSelectionAllowed()
                && !txfMotivoAnulacion.getText().trim().equals(""));
    }

    void inicializar() {
        txfNumComprobante.setText("");
        oModeloComprobanteClinica.clear();
        personalizarTabla();
        txfMotivoAnulacion.setText("");
    }

    private void resetObjects() {
        oComprobante = null;
        oComprobanteTemp = null;
    }

    private void imprimirComprobante() {
        String tipoComprobante = "";
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            if (oComprobante.getEstado().trim().equals("ACT")) {
                switch (oComprobante.getTipoComprobante().getDenominacion().trim()) {
                    case "BOLETA":
                        tipoComprobante = Constants.BOLETA;
                        break;
                    case "FACTURA":
                        tipoComprobante = Constants.FACTURA;
                        break;
                    case "ORDEN DE SERVICIO":
                        tipoComprobante = Constants.ORDEN_SERVICIO;
                        break;
                    case "BOLETA ELECTRONICA":
                        tipoComprobante = Constants.BOLETA_ELECTRONICA;
                        break;
                    case "FACTURA ELECTRONICA":
                        tipoComprobante = Constants.FACTURA_ELECTRONICA;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "No existe comprobante configurado", "Atención", JOptionPane.INFORMATION_MESSAGE);
                }
                if (!tipoComprobante.equals("")) {
                    rep = new Reportes(root);
                    rep.comprobanteClinica(tipoComprobante, oComprobante.getIdcomprobante());
                }
            } else if (oComprobante.getEstado().trim().equals("ANU")) {
                Mensajes.docAnulado();
            }
        } else {
            Mensajes.tblSelected();
        }
    }

}
