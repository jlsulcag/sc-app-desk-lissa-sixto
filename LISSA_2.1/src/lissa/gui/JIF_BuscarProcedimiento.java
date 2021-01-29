package lissa.gui;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;
import lissa.be.Beneficio;
import lissa.be.Procedimiento;
import lissa.be.ProcedimientoTarifario;
import lissa.be.Usuario;
import lissa.bl.ProcedimientoBl;
import lissa.bl.ProcedimientoTarifarioBl;
import lissa.table.ModeloBuscarProcedimiento;
import org.rx.cr.util.Utilitarios;

public class JIF_BuscarProcedimiento extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloBuscarProcedimiento oModeloBuscarProcedimiento;
    private ProcedimientoTarifario oProcedimientoTarifario;
    private ProcedimientoTarifarioBl oProcedimientoTarifarioBl;
    private List<Procedimiento> listLaboratorio;
    private Usuario oUsuario;
    private Beneficio oBeneficio;
    private int invocador;
    public static final int JIF_CITA = 1;
    public static final int JIF_ATENCION = 2;
    public static final int JIF_PRINCIPAL = 3;

    public JIF_BuscarProcedimiento(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloBuscarProcedimiento = new ModeloBuscarProcedimiento();
        tblResultados.setModel(oModeloBuscarProcedimiento);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txfBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();

        setClosable(true);
        setTitle("Buscar Procedimiento");

        jLabel7.setText("Procedimiento : ");

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
        tblResultados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblResultadosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblResultadosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txfBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBusquedaKeyReleased
        buscarProcedimiento();
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            tblResultados.requestFocus();
        }
    }//GEN-LAST:event_txfBusquedaKeyReleased

    private void tblResultadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblResultadosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            oProcedimientoTarifario = oModeloBuscarProcedimiento.get(tblResultados.getSelectedRow());
            switch (getInvocador()) {
                case JIF_CITA:
                    root.jifRegistrarCita.enviaDatosProcedimiento(oProcedimientoTarifario);
                    break;
                case JIF_ATENCION:
                    root.jifEmitirComprobante.enviaDatosProcedimiento(oProcedimientoTarifario);
                    break;
            }
            this.doDefaultCloseAction();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            inicializar();
            txfBusqueda.requestFocus();
        }
    }//GEN-LAST:event_tblResultadosKeyPressed

    private void tblResultadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblResultadosKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblResultadosKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txfBusqueda;
    // End of variables declaration//GEN-END:variables

    private void buscarProcedimiento() {
        //Validar Si tiene permiso para visualizar precio de procedimientos
        //sin permiso ve una tabla con
        oProcedimientoTarifarioBl = new ProcedimientoTarifarioBl();
        String ref = txfBusqueda.getText().trim().toUpperCase();
        oModeloBuscarProcedimiento.clear();
        List<ProcedimientoTarifario> listProcedimientos = new LinkedList<>();
        if (!ref.equals("")) {
            listProcedimientos = oProcedimientoTarifarioBl.listarRefAct(ref);
            if (!listProcedimientos.isEmpty()) {
                for (ProcedimientoTarifario obj : listProcedimientos) {
                    oModeloBuscarProcedimiento.add(obj);
                }
                personalizaVistaTabla();
            }
        } else {
            inicializar();
        }
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaAnchoColumnaTabla(0, tblResultados, 80);
        Utilitarios.formateaAnchoColumnaTabla(1, tblResultados, 100);
        Utilitarios.formateaAnchoColumnaTabla(4, tblResultados, 60);

        Utilitarios.alinearDatosColumnaTablaDerecha(4, tblResultados);
    }

    void inicializar() {
        txfBusqueda.setText("");
        oModeloBuscarProcedimiento.clear();
        oModeloBuscarProcedimiento.enviaUser(oUsuario);
        personalizaVistaTabla();

    }

    void enviarUser(Usuario oUsuario) {
        this.oUsuario = oUsuario;
    }

    void enviaBeneficio(Beneficio beneficio) {
        this.oBeneficio = beneficio;
    }

    public int getInvocador() {
        return invocador;
    }

    public void setInvocador(int invocador) {
        this.invocador = invocador;
    }

}
