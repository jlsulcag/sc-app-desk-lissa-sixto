
package lissa.gui.farmacia;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.AlmacenProducto;
import lissa.bl.AlmacenProductoBl;
import lissa.gui.JF_Principal;
import lissa.table.ModeloProductosVencidos;
import lissa.util.Utilitarios;

/**
 *
 * @author JSULCAG
 */
public class JIF_ProductosVencidos extends javax.swing.JInternalFrame {
    private JF_Principal root;
    private AlmacenProductoBl oAlmacenProductoBl;
    private List<AlmacenProducto> listAlmacenProducto;
    private ModeloProductosVencidos oModeloProductosVencidos;
    
    public JIF_ProductosVencidos(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloProductosVencidos = new ModeloProductosVencidos();
        tblResultados.setModel(oModeloProductosVencidos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Productos Vencidos");

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblResultados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResultados;
    // End of variables declaration//GEN-END:variables

    public void inicializar() {
        oAlmacenProductoBl = new AlmacenProductoBl();
        oModeloProductosVencidos.clear();
        listAlmacenProducto = oAlmacenProductoBl.listarProductosVencidos();
        if(!listAlmacenProducto.isEmpty()){
            for (AlmacenProducto obj : listAlmacenProducto) {
                oModeloProductosVencidos.add(obj);
            }
        }else{
            oModeloProductosVencidos.clear();
            JOptionPane.showMessageDialog(null, "No existen productos Vencidos", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
        personalizarVistaTabla();
    }
    
    private void personalizarVistaTabla() {
        Utilitarios.formateaColumna(0, tblResultados, 60);
        Utilitarios.formateaColumna(2, tblResultados, 100);
        Utilitarios.formateaColumna(3, tblResultados, 100);
        Utilitarios.formateaColumna(4, tblResultados, 100);
        Utilitarios.formateaColumna(5, tblResultados, 100);
        Utilitarios.formateaColumna(6, tblResultados, 50);
        Utilitarios.formateaColumna(7, tblResultados, 80);
    }
}
