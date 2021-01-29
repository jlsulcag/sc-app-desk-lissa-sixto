package lissa.gui.farmacia;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.FondoPrevisionTemp;
import lissa.be.FondoSolidaridad;
import lissa.be.PaqueteFondoSolidaridad;
import lissa.be.Persona;
import lissa.be.ServiciosFondoSolidaridad;
import lissa.bl.FondoPrevisionBl;
import lissa.bl.FondoSolidaridadTempBl;
import lissa.bl.PersonaBl;
import lissa.bl.ServicioFSBl;
import lissa.controller.PaqueteFSCtrl;
import lissa.gui.JF_Principal;
import lissa.table.ModeloFondoPrevision;
import lissa.table.ModeloFondoPrevisionTemp;
import lissa.util.Mensajes;

public class JIF_ConsultaFPS extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private FondoSolidaridadTempBl oFondoSolidaridadTempBl = null;
    private ModeloFondoPrevisionTemp oModeloFondoPrevisionTemp;
    private ModeloFondoPrevision oModeloFondoPrevision;
    private FondoPrevisionBl oBlFondoPrevision = null;
    private Persona oPersona;
    private PersonaBl oPersonaBl;
    private FondoPrevisionTemp oFondoPrevisionTemp;
    private FondoSolidaridad oFondoSolidaridad;
    private FondoPrevisionBl oFondoSolidaridadBl;
    private PaqueteFSCtrl oPaqueteFSCtrl;
    private ServiciosFondoSolidaridad oServiciosFondoSolidaridad;
    private ServicioFSBl oServicioFSBl;

    public JIF_ConsultaFPS(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloFondoPrevisionTemp = new ModeloFondoPrevisionTemp();
        tblFondoPrevisionTemp.setModel(oModeloFondoPrevisionTemp);
        oModeloFondoPrevision = new ModeloFondoPrevision();
        tblFondoPrevision.setModel(oModeloFondoPrevision);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnGuardarFondoPrev = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblFondoPrevisionTemp = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblAtencionesFondo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txfDni = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFondoPrevision = new javax.swing.JTable();
        txfNombres = new javax.swing.JTextField();
        cbxPaquete = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        rbtnActivo = new javax.swing.JRadioButton();

        setClosable(true);
        setTitle("Consulta Fondo de Prevision Social");

        btnGuardarFondoPrev.setText("Registrar FPS  >>");
        btnGuardarFondoPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarFondoPrevActionPerformed(evt);
            }
        });

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Besterp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tblFondoPrevisionTemp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblFondoPrevisionTemp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblFondoPrevisionTempMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tblFondoPrevisionTemp);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Fondo de Previsión Social", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tblAtencionesFondo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(tblAtencionesFondo);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );

        jLabel1.setText("DNI Socio :");

        txfDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfDniActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lissa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tblFondoPrevision.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblFondoPrevision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblFondoPrevisionMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tblFondoPrevision);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        txfNombres.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfNombres.setEnabled(false);

        jLabel2.setText("Paquete");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Registrar Beneficio"));

        jLabel3.setText("Estado :");

        rbtnActivo.setText("ACTIVO");
        rbtnActivo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnActivoItemStateChanged(evt);
            }
        });
        rbtnActivo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtnActivoStateChanged(evt);
            }
        });
        rbtnActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnActivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnActivo)
                .addContainerGap(259, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rbtnActivo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfDni, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfNombres)
                        .addGap(10, 10, 10)
                        .addComponent(btnConsultar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxPaquete, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btnGuardarFondoPrev, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar)
                    .addComponent(jLabel1)
                    .addComponent(txfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardarFondoPrev)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblFondoPrevisionTempMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFondoPrevisionTempMouseReleased
        if (tblFondoPrevisionTemp.getRowSelectionAllowed()) {
            obtenerDatosFondoPrevTemp();
        }
    }//GEN-LAST:event_tblFondoPrevisionTempMouseReleased

    private void btnGuardarFondoPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarFondoPrevActionPerformed
        //si esta seleccionado una fila
        if (oFondoPrevisionTemp != null) {
            //validar si el fondo ya existe no debe volver a registrarse
            //buscar fondo por fecha de pago
            if(existeFondo()){
                JOptionPane.showMessageDialog(null, "El fondo ya se encuentra registrado", "Atención", JOptionPane.INFORMATION_MESSAGE);
            }else{
                oFondoSolidaridad = registrarFondoPrev();
            } 

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un fondo de previsión", Mensajes.getTituloAtencion(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarFondoPrevActionPerformed

    private void tblFondoPrevisionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFondoPrevisionMouseReleased
        if (tblFondoPrevision.getRowSelectionAllowed() && tblFondoPrevision.getSelectedRow() != -1) {
            oFondoSolidaridad = oModeloFondoPrevision.get(tblFondoPrevision.getSelectedRow());
//            oModeloServicioFondoS.clear();
            if (oFondoSolidaridad != null) {
                //buscar si existe o no el servicio fs registrado
                if (existeServicioFS()) {
                    rbtnActivo.setSelected(Boolean.TRUE);
                } else {
                    rbtnActivo.setSelected(Boolean.FALSE);
                }
//                listarAtencionesFondo(oFondoSolidaridad);
            }
        }
    }//GEN-LAST:event_tblFondoPrevisionMouseReleased

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        //Verificar conexión a la base de datos del besterp, si existe buscar fondo de prevision
        //Listar Fondo de Prevision desde el  BESTERP
        //buscar a la persona por numero de dni
        oModeloFondoPrevision.clear();
        oModeloFondoPrevisionTemp.clear();
        oPersona = buscarPersona(txfDni.getText().trim());
        if (oPersona != null) {
            txfNombres.setText(oPersona.getNombre().trim() + " " + oPersona.getApellidoPaterno().trim() + "" + oPersona.getApellidoMaterno().trim());
            consultarFondoBesterp();//Consulta por DNI
            consultaFondoLissa();
        } else {
            JOptionPane.showMessageDialog(null, "No existe la persona, Por  favor proceda al registro", "Error", JOptionPane.ERROR_MESSAGE);
            txfNombres.setText("");
        }

    }//GEN-LAST:event_btnConsultarActionPerformed

    private void txfDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfDniActionPerformed
        btnConsultar.doClick();
    }//GEN-LAST:event_txfDniActionPerformed

    private void rbtnActivoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbtnActivoStateChanged

    }//GEN-LAST:event_rbtnActivoStateChanged

    private void rbtnActivoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtnActivoItemStateChanged
        
    }//GEN-LAST:event_rbtnActivoItemStateChanged

    private void rbtnActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnActivoActionPerformed
        registrarBeneficio();
    }//GEN-LAST:event_rbtnActivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnGuardarFondoPrev;
    private javax.swing.JComboBox cbxPaquete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JRadioButton rbtnActivo;
    private javax.swing.JTable tblAtencionesFondo;
    private javax.swing.JTable tblFondoPrevision;
    private javax.swing.JTable tblFondoPrevisionTemp;
    private javax.swing.JTextField txfDni;
    private javax.swing.JTextField txfNombres;
    // End of variables declaration//GEN-END:variables

    private void consultarFondoBesterp() {
        if (!txfDni.getText().trim().equals("")) {
            LlenarPagoFondoPrevision(txfDni.getText().trim());
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese N° DNI", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private ArrayList<FondoPrevisionTemp> LlenarPagoFondoPrevision(String dni) {
        oFondoSolidaridadTempBl = new FondoSolidaridadTempBl();
        ArrayList<FondoPrevisionTemp> listFondoPrev = oFondoSolidaridadTempBl.buscarBesterpXDni(dni);
        if (!listFondoPrev.isEmpty() && listFondoPrev != null) {
            oModeloFondoPrevisionTemp.addAll(listFondoPrev);
        }
        return listFondoPrev;
    }

    private void consultaFondoLissa() {
        //Listar fondo de prevision registrados en LISSA por ultima fecha de pago
        oBlFondoPrevision = new FondoPrevisionBl();
        List<FondoSolidaridad> listfs;
        if (oPersona != null) {
            listfs = oBlFondoPrevision.listarxidPersona(oPersona.getIdpersona());
            if (!listfs.isEmpty()) {
                for (FondoSolidaridad obj : listfs) {
                    oModeloFondoPrevision.add(obj);
                }
                
            }
        }
    }

    private Persona buscarPersona(String dni) {
        oPersonaBl = new PersonaBl();
        oPersona = oPersonaBl.buscarPersonaXDni(dni);
        return oPersona;
    }

    private void obtenerDatosFondoPrevTemp() {
        oFondoPrevisionTemp = oModeloFondoPrevisionTemp.get(tblFondoPrevisionTemp.getSelectedRow());
    }

    private FondoSolidaridad registrarFondoPrev() {
        oFondoSolidaridad = new FondoSolidaridad();
        oFondoSolidaridad.setPersona(oPersona);
        oFondoSolidaridad.setFechaReg(oFondoPrevisionTemp.getFechaUltimoPago());
        oFondoSolidaridad.setEstado(Boolean.TRUE);
        oFondoSolidaridad.setImporte(oFondoPrevisionTemp.getImportePago());
        oFondoSolidaridad = oBlFondoPrevision.registrar(oFondoSolidaridad);
        //Listar todos los fondos
        oModeloFondoPrevision.add(oFondoSolidaridad);
        return oFondoSolidaridad;
    }

    public void inicializar() {
        cargarCbxPaquete();
    }

    private void cargarCbxPaquete() {
        oPaqueteFSCtrl = new PaqueteFSCtrl(root);
        oPaqueteFSCtrl.rellenaCbx(cbxPaquete);
        oPaqueteFSCtrl.defaultSelectCbx("PRIMER AÑO", cbxPaquete);
    }

    private ServiciosFondoSolidaridad registrarServicioFondoSolidaridad(FondoSolidaridad oFondoSolidaridad) {
        oServiciosFondoSolidaridad = new ServiciosFondoSolidaridad();
        oServicioFSBl = new ServicioFSBl();
        oServiciosFondoSolidaridad.setFondoSolidaridad(oFondoSolidaridad);
        oServiciosFondoSolidaridad.setPaqueteFondoSolidaridad((PaqueteFondoSolidaridad) cbxPaquete.getSelectedItem());
        oServiciosFondoSolidaridad.setEstado("ACT");
        return oServicioFSBl.registrar(oServiciosFondoSolidaridad);
    }

    private void registrarBeneficio() {
        if (isDatosValidosBeneficio()) {
            if (existeServicioFS()) {
                JOptionPane.showMessageDialog(null, "Ya se encuentra activado", "Atención", JOptionPane.INFORMATION_MESSAGE);
            } else {
                registrarServicioFondoSolidaridad(oFondoSolidaridad);
            }
        }
    }

    private boolean isDatosValidosBeneficio() {
        return (cbxPaquete.getSelectedIndex() > 0
                && oFondoSolidaridad != null
                && rbtnActivo.isSelected());
    }

    private ServiciosFondoSolidaridad buscarEstadoFS(FondoSolidaridad oFondoSolidaridad, PaqueteFondoSolidaridad paqueteFondoSolidaridad) {
        oServicioFSBl = new ServicioFSBl();
        return oServicioFSBl.buscarBeneficio(oFondoSolidaridad, paqueteFondoSolidaridad);
    }

    private boolean existeServicioFS() {
        ServiciosFondoSolidaridad temp = buscarEstadoFS(oFondoSolidaridad, (PaqueteFondoSolidaridad) cbxPaquete.getSelectedItem());
        if (temp != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean existeFondo() {
        oFondoSolidaridadBl = new FondoPrevisionBl();
        oFondoSolidaridad = oFondoSolidaridadBl.buscarxFecha(oFondoPrevisionTemp, oPersona);
        if(oFondoSolidaridad != null){
            return true;
        }else{
            return false;
        }
    }

}
