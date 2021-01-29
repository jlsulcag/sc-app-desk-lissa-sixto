package lissa.gui;

import java.awt.event.KeyEvent;
import java.util.List;
import lissa.be.Medico;
import lissa.bl.MedicoBl;
import lissa.table.ModeloMedico;
import lissa.util.Utilitarios;

public class JIF_BuscarMedico extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ModeloMedico oModeloMedico;
    private List<Medico> listMedico;
    private Medico beanTabla;
    private Medico oMedico;
    private MedicoBl oMedicoBl;

    private int invocador;

    public static final int MEDICO_DERIVADOR = 1;
    public static final int MEDICO_ATIENDE = 2;
    public static final int ADMINISTRAR_ATENCION = 3;
    public static final int REALIZAR_PAGO_MEDICOS = 4;
    public static final int REGISTRAR_PAGO_MEDICOS = 5;

    public JIF_BuscarMedico(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloMedico = new ModeloMedico();
        tblResultados.setModel(oModeloMedico);
        personalizaVistaTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txfNombres = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txfNumDni = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Buscar Medico");
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
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txfNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNombresKeyReleased(evt);
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblResultadosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblResultados);

        jLabel1.setText("Apellidos y Nombres : ");

        jLabel2.setText("DNI :");

        txfNumDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNumDniKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfNombres)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfNumDni, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txfNumDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseReleased
        if (tblResultados.getRowSelectionAllowed()) {
            obtenerDatos();
        }
    }//GEN-LAST:event_tblResultadosMouseReleased

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

    }//GEN-LAST:event_formInternalFrameClosing

    private void txfNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombresKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarMedicoxNombres(txfNombres.getText().trim().toUpperCase());
            personalizaVistaTabla();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            tblResultados.requestFocus();
        }
    }//GEN-LAST:event_txfNombresKeyReleased

    private void txfNumDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNumDniKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarMedicoxDni(txfNumDni.getText().trim().toUpperCase());
            personalizaVistaTabla();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            tblResultados.requestFocus();
        }
    }//GEN-LAST:event_txfNumDniKeyReleased

    private void tblResultadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblResultadosKeyPressed
        int code = evt.getKeyCode();
        char caracter = evt.getKeyChar();
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            //obtenerDatos();
            beanTabla = oModeloMedico.get(tblResultados.getSelectedRow());
            if (code == KeyEvent.VK_ENTER) {//cargar datos  al JIF que lo llama                
                if (beanTabla != null) {
                    cargarDatosPersona();
                    this.doDefaultCloseAction();
                    oModeloMedico.clear();
                    beanTabla = null;
                }

            }
        }
    }//GEN-LAST:event_tblResultadosKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txfNombres;
    private javax.swing.JTextField txfNumDni;
    // End of variables declaration//GEN-END:variables

    private void obtenerDatos() {
        //resetComponent();
        beanTabla = (Medico) oModeloMedico.get(tblResultados.getSelectedRow());
    }

    private boolean isDatosValidos() {
        return true;
    }

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblResultados, 60);
        Utilitarios.formateaColumna(2, tblResultados, 40);
    }

    private void cargarDatosPersona() {
        switch (getInvocador()) {
            case MEDICO_DERIVADOR:
                root.jifEmitirComprobante.cargarDatosMedicoD(beanTabla);
                break;
            case MEDICO_ATIENDE:
                root.jifEmitirComprobante.cargarDatosMedicoA(beanTabla);
                break;
            case ADMINISTRAR_ATENCION:
                root.jifAdministrarAtencion.cargarDatosMedicoA(beanTabla);
                break;
            case REALIZAR_PAGO_MEDICOS:
                root.jifRealizarPagoMedicos.cargarDatosMedico(beanTabla);
                break;
            case REGISTRAR_PAGO_MEDICOS:
                root.jifRegistrarPagoMedicos.cargarDatosMedico(beanTabla);
                break;
        }
    }

    public int getInvocador() {
        return invocador;
    }

    public void setInvocador(int invocador) {
        this.invocador = invocador;
    }

    private void buscarMedicoxNombres(String nombres) {
        oMedicoBl = new MedicoBl();
        listMedico = oMedicoBl.buscar(nombres);
        oModeloMedico.clear();
        for (Medico medico : listMedico) {
            oModeloMedico.add(medico);
        }
    }

    private void buscarMedicoxDni(String dni) {
        oMedicoBl = new MedicoBl();
        oMedico = new Medico();
        oMedico = oMedicoBl.buscarMedicoXDni(dni);
        oModeloMedico.clear();
        if (oMedico != null) {
            oModeloMedico.add(oMedico);
        }
    }

    public void inicializar() {
        txfNombres.setText("");
        txfNumDni.setText("");
        oModeloMedico.clear();
        if (oMedico != null) {
            oMedico = null;
        }
        personalizaVistaTabla();
    }

}
