package lissa.gui.farmacia;

import lissa.be.FormaFarmaceutica;
import lissa.be.Laboratorio;
import lissa.be.Presentacion;
import lissa.be.Producto;
import lissa.bl.ProductoBl;
import lissa.controller.FormaFarmaceuticaCtrl;
import lissa.controller.LaboratorioCtrl;
import lissa.controller.PresentacionCtrl;
import lissa.gui.JF_Principal;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Constants;

public class JIF_NuevoProducto extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private Producto oProducto;
    private ProductoBl oProductoBl;
    private PresentacionCtrl oPresentacionCtrl;
    private FormaFarmaceuticaCtrl oFormaFarmaceuticaCtrl;
    private LaboratorioCtrl oLaboratorioCtrl;

    //Invocador
    private int invocador;
    public static final int JIF_ADMINPRODUCTO = 1;
    private int operacion = -1;
    public static final int NUEVO = 1, EDITAR = 2;

    public JIF_NuevoProducto(JF_Principal root) {
        initComponents();
        this.root = root;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txfProducto = new javax.swing.JTextField();
        txfCodigo = new javax.swing.JTextField();
        txfConcentracion = new javax.swing.JTextField();
        txfFraccion = new javax.swing.JTextField();
        cbxPresentacion = new javax.swing.JComboBox();
        cbxFormaFarmaceutica = new javax.swing.JComboBox();
        cbxLaboratorio = new javax.swing.JComboBox();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAddFamilia = new javax.swing.JButton();
        btnAddClase = new javax.swing.JButton();
        btnAddLaboratorio = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txfPrincipioActivo = new javax.swing.JTextField();
        chbxGenerico = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txfAccionTerapeutica = new javax.swing.JTextField();

        setClosable(true);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Descripción/Producto :");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Codigo :");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Concentración :");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Presentación :");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Fracción :");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Laboratorio :");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        txfFraccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfFraccionKeyReleased(evt);
            }
        });

        cbxFormaFarmaceutica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFormaFarmaceuticaActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/delete-icon.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Save16.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAddFamilia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        btnAddFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFamiliaActionPerformed(evt);
            }
        });

        btnAddClase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        btnAddClase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClaseActionPerformed(evt);
            }
        });

        btnAddLaboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        btnAddLaboratorio.setPreferredSize(new java.awt.Dimension(49, 20));
        btnAddLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLaboratorioActionPerformed(evt);
            }
        });

        jLabel9.setText("Forma farmaceutica :");

        jLabel6.setText("Principio Activo(Contenido) :");

        chbxGenerico.setText("Génerico");

        jLabel8.setText("Acción terapéutica(Uso) :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfConcentracion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txfProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                            .addComponent(txfCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfPrincipioActivo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfAccionTerapeutica, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbxGenerico))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txfFraccion, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbxLaboratorio, javax.swing.GroupLayout.Alignment.LEADING, 0, 397, Short.MAX_VALUE)
                                .addComponent(cbxPresentacion, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbxFormaFarmaceutica, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnAddLaboratorio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(btnAddFamilia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnAddClase, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(chbxGenerico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txfPrincipioActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txfAccionTerapeutica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfConcentracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxFormaFarmaceutica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnAddFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAddClase, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(cbxLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txfFraccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(18, 18, 18))
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

    private void txfFraccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfFraccionKeyReleased
        Utilitarios.validaCaracterNumerico(evt, txfFraccion);
    }//GEN-LAST:event_txfFraccionKeyReleased

    private void cbxFormaFarmaceuticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFormaFarmaceuticaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFormaFarmaceuticaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        resetComponent();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Metodo  para guardar datos del producto
        int i = 0;
        Producto temp;
        if (isDatosValidos()) {
            if (getOperacion() == NUEVO) {
                temp = registrar();
                if (temp.getIdproducto() != 0) {
                    Mensajes.msjRegCorrecta();
                    resetComponent();
                    resetPaintComponentes();
                    this.doDefaultCloseAction();
                    root.jifAdminProducto.actualizarLista();
                } else {
                    Mensajes.msjRegError();
                }
            } else if (getOperacion() == EDITAR) {
                int res = -1;
                res = actualizar();
                if (res == 0) {
                    Mensajes.msjActCorrecta();
                    resetComponent();
                    resetPaintComponentes();
                    this.doDefaultCloseAction();
                    root.jifAdminProducto.actualizarLista();
                } else {
                    Mensajes.msjActErronea();
                }

            }

        } else {
            Mensajes.msjValidarIngreso();
            paintComponentes();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAddFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFamiliaActionPerformed
        operacion = NUEVO;
        insertarJifNuevoFamilia();
        root.jifRegPresentacion.enviarJif(this);
    }//GEN-LAST:event_btnAddFamiliaActionPerformed

    private void btnAddClaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClaseActionPerformed
        operacion = NUEVO;
        insertarJifNuevoClase();
        root.jifFormaFarmaceutica.enviarJif(this);
    }//GEN-LAST:event_btnAddClaseActionPerformed

    private void btnAddLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLaboratorioActionPerformed
        operacion = NUEVO;
        insertarJifNuevoLaboratorio();
        root.jifRegLaboratorio.enviarJif(this);
    }//GEN-LAST:event_btnAddLaboratorioActionPerformed


    // Constants declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddClase;
    private javax.swing.JButton btnAddFamilia;
    private javax.swing.JButton btnAddLaboratorio;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cbxFormaFarmaceutica;
    private javax.swing.JComboBox cbxLaboratorio;
    private javax.swing.JComboBox cbxPresentacion;
    private javax.swing.JRadioButton chbxGenerico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txfAccionTerapeutica;
    private javax.swing.JTextField txfCodigo;
    private javax.swing.JTextField txfConcentracion;
    private javax.swing.JTextField txfFraccion;
    private javax.swing.JTextField txfPrincipioActivo;
    private javax.swing.JTextField txfProducto;
    // End of variables declaration//GEN-END:variables
    public int getInvocador() {
        return invocador;
    }

    public void setInvocador(int invocador) {
        this.invocador = invocador;
    }

    private void cargarPresentacion() {
        oPresentacionCtrl = new PresentacionCtrl(root);
        oPresentacionCtrl.rellenaFamilia(cbxPresentacion);
    }

    private void cargarFormaFarmaceutica() {
        oFormaFarmaceuticaCtrl = new FormaFarmaceuticaCtrl(root);
        oFormaFarmaceuticaCtrl.rellenaCbx(cbxFormaFarmaceutica);
    }

    private void cargarLaboratorio() {
        oLaboratorioCtrl = new LaboratorioCtrl(root);
        oLaboratorioCtrl.rellenaCbx(cbxLaboratorio);
    }

//    private void cargarUnidadMedida() {
//        oUnidadMedidaCtrl = new UnidadMedidaCtrl(root);
//        oUnidadMedidaCtrl.rellenaCbx(cbxUnidadMedida);
//    }
    private boolean isDatosValidos() {
        return (!txfProducto.getText().trim().equals("")
                && cbxPresentacion.getSelectedIndex() > 0
                && cbxFormaFarmaceutica.getSelectedIndex() > 0
                && cbxLaboratorio.getSelectedIndex() > 0);
    }

    private Producto registrar() {
        oProducto = new Producto();
        oProductoBl = new ProductoBl();

        oProducto.setNombre(txfProducto.getText().toUpperCase().trim());
        oProducto.setCodigo(txfCodigo.getText().toUpperCase().trim());
        oProducto.setConcentracion(txfConcentracion.getText().toUpperCase().trim());
        oProducto.setPrincipioActivo(txfPrincipioActivo.getText().toUpperCase().trim());
        oProducto.setAccionTerapeutica(txfAccionTerapeutica.getText().toUpperCase().trim());
        oProducto.setGenerico(chbxGenerico.isSelected()?Constants.ES_GENERICO:Constants.NO_GENERICO);
        if (!txfFraccion.getText().trim().equals("")) {
            oProducto.setFraccion(Integer.parseInt(txfFraccion.getText().trim()));
        } else {
            oProducto.setFraccion(0);
        }
        oProducto.setPresentacion((Presentacion) cbxPresentacion.getSelectedItem());
        oProducto.setFormaFarmaceutica((FormaFarmaceutica) cbxFormaFarmaceutica.getSelectedItem());
        oProducto.setLaboratorio((Laboratorio) cbxLaboratorio.getSelectedItem());
        return oProductoBl.registrar(oProducto);
    }

    private void resetComponent() {
        txfProducto.setText("");
        txfCodigo.setText("");
        txfConcentracion.setText("");
        txfFraccion.setText("");
        cbxPresentacion.setSelectedIndex(0);
        cbxFormaFarmaceutica.setSelectedIndex(0);
        cbxLaboratorio.setSelectedIndex(0);
        txfPrincipioActivo.setText("");
        txfAccionTerapeutica.setText("");
        chbxGenerico.setSelected(Boolean.FALSE);
        resetPaintComponentes();
    }

    void enviaDatos(Producto oProducto) {
        this.oProducto = oProducto;
        txfProducto.setText(this.oProducto.getNombre());
        txfCodigo.setText(this.oProducto.getCodigo());
        txfConcentracion.setText(this.oProducto.getConcentracion());
        txfFraccion.setText(this.oProducto.getFraccion() + "");
        txfPrincipioActivo.setText(this.oProducto.getPrincipioActivo());
        txfAccionTerapeutica.setText(this.oProducto.getAccionTerapeutica());
        chbxGenerico.setSelected(this.oProducto.getGenerico()==Constants.ES_GENERICO?Boolean.TRUE:Boolean.FALSE);
        if (this.oProducto.getPresentacion() == null) {
            cbxPresentacion.setSelectedIndex(0);
        } else {
            oPresentacionCtrl.recuperaDatosCbx(this.oProducto.getPresentacion().getIdpresentacion(), cbxPresentacion);
        }
        if (this.oProducto.getFormaFarmaceutica() == null) {
            cbxFormaFarmaceutica.setSelectedIndex(0);
        } else {
            oFormaFarmaceuticaCtrl.recuperaDatosCbx(this.oProducto.getFormaFarmaceutica().getIdformafarmaceutica(), cbxFormaFarmaceutica);
        }
        if (this.oProducto.getLaboratorio() == null) {
            cbxLaboratorio.setSelectedIndex(0);
        } else {
            oLaboratorioCtrl.recuperaDatosCbx(this.oProducto.getLaboratorio().getIdlaboratorio(), cbxLaboratorio);
        }

    }

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }

    private int actualizar() {
        int res = -1;
        Producto proAct = new Producto();
        oProductoBl = new ProductoBl();

        proAct.setIdproducto(oProducto.getIdproducto());
        proAct.setNombre(txfProducto.getText().toUpperCase().trim());
        proAct.setCodigo(txfCodigo.getText().toUpperCase().trim());
        proAct.setConcentracion(txfConcentracion.getText().toUpperCase().trim());
        proAct.setFraccion(Integer.parseInt(txfFraccion.getText().trim()));
        proAct.setPresentacion((Presentacion) cbxPresentacion.getSelectedItem());
        proAct.setFormaFarmaceutica((FormaFarmaceutica) cbxFormaFarmaceutica.getSelectedItem());
        proAct.setLaboratorio((Laboratorio) cbxLaboratorio.getSelectedItem());
        proAct.setPrincipioActivo(txfPrincipioActivo.getText().toUpperCase().trim());
        proAct.setAccionTerapeutica(txfAccionTerapeutica.getText().toUpperCase().trim());
        proAct.setGenerico(chbxGenerico.isSelected()?Constants.ES_GENERICO:Constants.NO_GENERICO);
        return oProductoBl.actualizar(proAct);
    }

    private void insertarJifNuevoFamilia() {
        //Cambia valor del invocador
        root.jifRegPresentacion.setInvocador(JIF_RegPresentacion.JIF_REGFAMILIA);
        //Inserta el nuevo Internal Frame
        root.insertarInternalFrames(root.jifRegPresentacion);

    }

    private void insertarJifNuevoClase() {
        //Cambia valor del invocador
        root.jifFormaFarmaceutica.setInvocador(JIF_RegFormaFarmaceutica.JIF_REGCLASE);
        //Inserta el nuevo Internal Frame
        root.insertarInternalFrames(root.jifFormaFarmaceutica);
    }

    private void insertarJifNuevoLaboratorio() {
        //Cambia valor del invocador
        root.jifRegLaboratorio.setInvocador(JIF_RegLaboratorio.JIF_REGLABORATORIO);
        //Inserta el nuevo Internal Frame
        root.insertarInternalFrames(root.jifRegLaboratorio);
    }

//    private void insertarJifNuevoUnidadMedida() {
//        //Cambia valor del invocador
//        root.jifRegUnidadMedida.setInvocador(JIF_RegUnidadMedida.JIF_REGLAUNIDADMEDIDA);
//        //Inserta el nuevo Internal Frame
//        root.insertarInternalFrames(root.jifRegUnidadMedida);
//    }
    void actualizarFormaFarmaceutica() {
        cargarFormaFarmaceutica();
    }

    void actualizarPresentacion() {
        cargarPresentacion();
    }

    void actualizarLaboratorio() {
        cargarLaboratorio();
    }

    void inicializar() {
        cargarPresentacion();
        cargarFormaFarmaceutica();
        cargarLaboratorio();
        resetComponent();
    }

    private void paintComponentes() {
        Utilitarios.paintBorderTxfVacio(txfProducto);
        Utilitarios.paintCbxVacio(cbxPresentacion);
        Utilitarios.paintCbxVacio(cbxFormaFarmaceutica);
        Utilitarios.paintCbxVacio(cbxLaboratorio);
    }

    private void resetPaintComponentes() {
        Utilitarios.resetPaintBorderTxf(txfProducto);
        Utilitarios.resetPaintCbx(cbxPresentacion);
        Utilitarios.resetPaintCbx(cbxFormaFarmaceutica);
        Utilitarios.resetPaintCbx(cbxLaboratorio);
    }
}
