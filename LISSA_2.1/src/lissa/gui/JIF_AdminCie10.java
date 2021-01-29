package lissa.gui;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lissa.be.Cie10;
import lissa.bl.Cie10Bl;
import lissa.table.ModeloCie10;
import lissa.util.Utilitarios;

public class JIF_AdminCie10 extends javax.swing.JInternalFrame {

    private int banBoton = 0;
    private ModeloCie10 modeloCie10;
    private JF_Principal root;
    private Cie10 oCie10;
    private Cie10Bl oCie10Bl;
    private Cie10 beanTabla;
    /*Invocador*/
    private int invocador;
    
    /*Variables  utilizadas  para llamar a la interfaz CIE10 desde una detereminada ventana*/
    public static final int JIF_HCAMBULATORIA = 1;
    public static final int JIF_HCOCUPACIONAL = 2;
    /*Fin declaracion de variables*/

    public JIF_AdminCie10(JF_Principal root) {
        initComponents();
        this.root = root;
        modeloCie10 = new ModeloCie10();
        tblResultados.setModel(modeloCie10);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txfBuscarCodigo = new javax.swing.JTextField();
        txfBuscarDescripcion = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        btnCargar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txfCodigo = new javax.swing.JTextField();
        txfDescripcion = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Código : ");

        jLabel2.setText("Descripción : ");

        txfBuscarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBuscarCodigoActionPerformed(evt);
            }
        });

        txfBuscarDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBuscarDescripcionActionPerformed(evt);
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
        tblResultados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblResultadosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultados);

        btnCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/arrow.png"))); // NOI18N
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfBuscarDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(txfBuscarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txfBuscarDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CIE-10", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel3.setText("Código : ");

        jLabel4.setText("Descripción : ");

        txfCodigo.setEnabled(false);

        txfDescripcion.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txfDescripcion))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
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
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addComponent(btnEditar)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar))
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        if (beanTabla == null || beanTabla.getIdCie10() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un item", "Atención", JOptionPane.INFORMATION_MESSAGE);
        } else {
            cargarDatosCie10();
            this.doDefaultCloseAction();
            resetComponent();
            modeloCie10.clear();
            beanTabla = null;
        }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        configuraNuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tblResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseReleased
        try {
            if (tblResultados.getRowSelectionAllowed()) {
                obtenerDatosTabla();
                estadoTextFields(false);
                activarBotones(true, true, false, true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIF_AdminCie10.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblResultadosMouseReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarCie10();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblResultados.getSelectedRow() != -1) {
            configuraActualizar();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un item", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txfBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBuscarCodigoActionPerformed
        btnBuscar.doClick();
    }//GEN-LAST:event_txfBuscarCodigoActionPerformed

    private void txfBuscarDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBuscarDescripcionActionPerformed
        btnBuscar.doClick();
    }//GEN-LAST:event_txfBuscarDescripcionActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        configuraCancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblResultadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblResultadosKeyReleased
        int code = evt.getKeyCode();
        char caracter = evt.getKeyChar();
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            //obtenerDatos();
            if (code == KeyEvent.VK_ENTER) {//cargar datos  al JIF que lo llama                
                if (beanTabla != null) {
                    cargarDatosCie10();
                    this.doDefaultCloseAction();
                    modeloCie10.clear();
                    beanTabla = null;
                }

            }
        }
    }//GEN-LAST:event_tblResultadosKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txfBuscarCodigo;
    private javax.swing.JTextField txfBuscarDescripcion;
    private javax.swing.JTextField txfCodigo;
    private javax.swing.JTextField txfDescripcion;
    // End of variables declaration//GEN-END:variables

    //Metodos basicos
    private Cie10 registrar() {
        oCie10 = new Cie10();
        oCie10Bl = new Cie10Bl();

        oCie10.setCodigo(txfCodigo.getText().toUpperCase().trim());
        oCie10.setDescripcion(txfDescripcion.getText().toUpperCase().trim());

        return oCie10Bl.registrar(oCie10);
    }

    private void configuraNuevo() {
        banBoton = 1;
        tblResultados.setEnabled(true);
        modeloCie10.clear();
        resetComponent();
        estadoTextFields(true);
        activarBotones(false, false, true, true);
    }

    //Metodos complementarios
    public void resetComponent() {
        this.txfCodigo.setText("");
        this.txfDescripcion.setText("");
        this.txfBuscarCodigo.setText("");
        this.txfBuscarDescripcion.setText("");
    }

    public void estadoTextFields(boolean estado) {
        this.txfCodigo.setEnabled(estado);
        this.txfDescripcion.setEnabled(estado);
    }

    public void activarBotones(boolean nuevo, boolean editar, boolean guardar, boolean cancelar) {
        this.btnNuevo.setEnabled(nuevo);
        this.btnEditar.setEnabled(editar);
        this.btnGuardar.setEnabled(guardar);
        this.btnCancelar.setEnabled(cancelar);
    }

    private void guardar() {
        if (banBoton == 1) {
            if (isDatosValidos()) {
                oCie10 = registrar();
                if (oCie10.getIdCie10() != 0) {
                    JOptionPane.showMessageDialog(null, "Registro correcto", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    modeloCie10.clear();
                    modeloCie10.add(oCie10);
                    resetComponent();
                    estadoTextFields(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Error de registro", "Atención", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese todos los campos", "Atención", JOptionPane.ERROR_MESSAGE);
            }
        } else if (banBoton == 2) {
            if (isDatosValidos()) {
                actualizar();
                resetComponent();
                modeloCie10.clear();
                modeloCie10.add(buscarCie10Xid());
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese todos los campos", "Atención", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean isDatosValidos() {
        return (!this.txfCodigo.getText().trim().equals("")
                && !this.txfDescripcion.getText().trim().equals(""));
    }

    private void obtenerDatosTabla() throws SQLException {
        resetComponent();
        beanTabla = (Cie10) modeloCie10.get(tblResultados.getSelectedRow());
        this.txfCodigo.setText(beanTabla.getCodigo().trim());
        this.txfDescripcion.setText(beanTabla.getDescripcion().trim());
    }

    private void buscarCie10() {
        oCie10Bl = new Cie10Bl();
        String ref = "";
        if (!txfBuscarCodigo.getText().toUpperCase().trim().equals("")) {
            ref = txfBuscarCodigo.getText().toUpperCase().trim();
        } else if (!txfBuscarDescripcion.getText().toUpperCase().trim().equals("")) {
            ref = txfBuscarDescripcion.getText().toUpperCase().trim();
        } else {
            ref = "";
        }
        modeloCie10.addAll(oCie10Bl.buscar(ref));
        personalizaVistaTabla();
        txfBuscarCodigo.setText("");
        txfBuscarDescripcion.setText("");
        resetComponent();
        estadoTextFields(false);
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblResultados, 80);
        Utilitarios.formateaColumna(1, tblResultados, 120);
    }

    private void configuraActualizar() {
        banBoton = 2;
        estadoTextFields(true);
        activarBotones(true, false, true, true);
    }

    private void actualizar() {
        oCie10 = new Cie10();
        oCie10Bl = new Cie10Bl();

        oCie10.setIdCie10(beanTabla.getIdCie10());
        oCie10.setCodigo(txfCodigo.getText().toUpperCase().trim());
        oCie10.setDescripcion(txfDescripcion.getText().toUpperCase().trim());

        oCie10Bl.actualizar(oCie10);
    }

    private Cie10 buscarCie10Xid() {
        oCie10Bl = new Cie10Bl();
        return oCie10Bl.buscarXid(beanTabla.getIdCie10());
    }

    private void configuraCancelar() {
        resetComponent();
        resetPaintComponent();
        estadoTextFields(false);
        activarBotones(true, false, false, true);
        btnBuscar.setEnabled(true);
        modeloCie10.clear();
        oCie10 = null;
    }

    public void resetPaintComponent() {
        Utilitarios.resetPaintTxf(txfCodigo);
        Utilitarios.resetPaintTxf(txfDescripcion);
    }

    private void cargarDatosCie10() {
        switch(getInvocador()){
            case JIF_HCAMBULATORIA: root.jifHistoriaClinica.cargarCie10(beanTabla);
                break;
        }
    }

    public int getInvocador() {
        return invocador;
    }

    public void setInvocador(int invocador) {
        this.invocador = invocador;
    }
}
