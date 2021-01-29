package lissa.gui;

import lissa.be.Servicio;
import lissa.be.Tarifario;
import lissa.bl.ServicioBl;
import lissa.controller.TarifarioCtrl;
import lissa.util.Mensajes;

public class JIF_ServicioAdd extends javax.swing.JInternalFrame {
    private JF_Principal root;
    private Servicio oServicio;
    private ServicioBl oServicioBl;
    private TarifarioCtrl oTarifarioCtrl;
    private JIF_AdministrarProcedimiento jifAdminProcedimiento;

    public JIF_ServicioAdd(JF_Principal root) {
        initComponents();
        this.root = root;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfServicio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txfCodigo = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Agregar Servicio");

        jLabel1.setText("Servicio :");

        txfServicio.setBackground(new java.awt.Color(255, 255, 204));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Código :");

        txfCodigo.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13)
                        .addComponent(txfServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfCodigo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        preparaGuardar();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txfCodigo;
    private javax.swing.JTextField txfServicio;
    // End of variables declaration//GEN-END:variables

    private void preparaGuardar() {
        if (isDatosValidos()) {
            guardar();
        } else {
            Mensajes.msjRegError();
        }
    }

    private boolean isDatosValidos() {
        return (!txfServicio.getText().trim().equals("")
                && !txfCodigo.getText().trim().equals(""));
    }

    private void guardar() {
        oServicio = new Servicio();
        oServicioBl = new ServicioBl();
        
        oServicio.setDenominacion(txfServicio.getText().trim().toUpperCase());
        oServicio.setCodigo(txfCodigo.getText().trim().toUpperCase());
        oServicio.setEstado(1);
        
        oServicio = oServicioBl.registrar(oServicio);
        if(oServicio.getIdservicio() != 0){
            Mensajes.msjRegCorrecta();
            iniciar();
            this.doDefaultCloseAction();
        }else{
            Mensajes.msjRegError();
        }
              
    }
    
    public  void iniciar(){
        oTarifarioCtrl = new TarifarioCtrl(root);
        txfServicio.setText("");
        txfCodigo.setText("");
    }

    public void enviaJif(JIF_AdministrarProcedimiento aThis) {
        jifAdminProcedimiento = aThis;
    }
}
