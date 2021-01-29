
package lissa.gui.farmacia;

import java.util.LinkedList;
import java.util.List;
import lissa.be.DetalleVenta;
import lissa.be.FondoSolidaridad;
import lissa.be.HistorialAtencionFps;
import lissa.be.Venta;
import lissa.bl.DetalleVentaBl;
import lissa.bl.VentaBl;
import lissa.gui.JF_Principal;
import lissa.table.ModeloHistorialFps;
import lissa.table.ModeloProductosFPS;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;

public class JIF_HistorialAtencionFPS extends javax.swing.JInternalFrame {
    private JF_Principal root;
    private ModeloHistorialFps oModeloHistorialFps;
    private ModeloProductosFPS oModeloProductosFPS;
    private List<DetalleVenta> listDetalleVenta;
    
    private Venta oVenta;
    private VentaBl oVentaBl;
    private DetalleVenta oDetalleVenta;
    private DetalleVentaBl oDetalleVentaBl;
    
    public JIF_HistorialAtencionFPS(JF_Principal root) {
        initComponents();
        this.root = root;
        oModeloHistorialFps = new ModeloHistorialFps();
        tblResultados.setModel(oModeloHistorialFps);
        oModeloProductosFPS = new ModeloProductosFPS();
        tblProductos.setModel(oModeloProductosFPS);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();

        setClosable(true);
        setTitle("Historial de atenciones FPS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Atenciones"));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblProductos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseReleased
        cargarDetalles();
        personalizaTablas();
    }//GEN-LAST:event_tblResultadosMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblResultados;
    // End of variables declaration//GEN-END:variables

    void cargarHistorialFPS(FondoSolidaridad oFondoSolidaridad) {
        oModeloHistorialFps.clear();
        oModeloProductosFPS.clear();
        //LISTAR LOS PRODUCTOS  ENTREGADOS POR FECHA DE VENTA
        for (HistorialAtencionFps obj : oFondoSolidaridad.getHistorialAtencionFpses()) {            
            oModeloHistorialFps.add(obj);
        }
        personalizaTablas();
    }

    private void cargarDetalles() {
        if(tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1){
            HistorialAtencionFps temp = new HistorialAtencionFps();
            temp = oModeloHistorialFps.get(tblResultados.getSelectedRow());
            listarProductos(temp);
        }else{
            Mensajes.tblSelected();
        }
    }

    private void listarProductos(HistorialAtencionFps temp) {
        oModeloProductosFPS.clear();
        listDetalleVenta = new LinkedList<>();
        oVentaBl = new VentaBl();
        oDetalleVentaBl = new DetalleVentaBl();
        oDetalleVenta = new DetalleVenta();
        oVenta = oVentaBl.buscarXidVenta(temp.getIdVenta());
        if(oVenta.getIdventa() > 0){
            listDetalleVenta = oDetalleVentaBl.listarXVenta(oVenta);
            for (DetalleVenta obj : listDetalleVenta) {
                oModeloProductosFPS.add(obj);
            }
        }
    }

    private void personalizaTablas() {
        Utilitarios.formateaColumna(0, tblResultados, 80);
        Utilitarios.formateaColumna(2, tblResultados, 80);
        Utilitarios.formateaColumna(3, tblResultados, 80);
        Utilitarios.alinearDatosColumnaTablaDerecha(2, tblResultados);
        Utilitarios.alinearDatosColumnaTablaDerecha(3, tblResultados);
        
        Utilitarios.formateaColumna(0, tblProductos, 80);
        Utilitarios.formateaColumna(2, tblProductos, 80);
        Utilitarios.formateaColumna(3, tblProductos, 80);
        Utilitarios.formateaColumna(4, tblProductos, 80);
        Utilitarios.alinearDatosColumnaTablaDerecha(2, tblProductos);
        Utilitarios.alinearDatosColumnaTablaDerecha(3, tblProductos);
        Utilitarios.alinearDatosColumnaTablaDerecha(4, tblProductos);
    }
}
