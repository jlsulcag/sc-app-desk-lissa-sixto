package lissa.gui.rep;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lissa.be.ComprobanteDetalle;
import lissa.bl.ItemsComprobanteBl;
import lissa.gui.JF_Principal;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class JIF_Sabanon extends javax.swing.JInternalFrame {

    private JF_Principal root;
    private ArrayList<ComprobanteDetalle> listComprobanteDetalle;
    private ItemsComprobanteBl oComprobanteDetalleBl;

    public JIF_Sabanon(JF_Principal root) {
        initComponents();
        this.root = root;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jdcFechaDesde = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jdcFechaHasta = new com.toedter.calendar.JDateChooser();
        btnGenerar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Planilla de Atención");

        jLabel2.setText("Desde : ");

        jLabel3.setText("Hasta :");

        btnGenerar.setText("Procesar");
        btnGenerar.setToolTipText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcFechaDesde, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGenerar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcFechaDesde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcFechaHasta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerar)
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

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        generarReporte();
    }//GEN-LAST:event_btnGenerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jdcFechaDesde;
    private com.toedter.calendar.JDateChooser jdcFechaHasta;
    // End of variables declaration//GEN-END:variables

    private boolean isdatosValidos() {
        return (jdcFechaDesde.getDate() != null
                && jdcFechaHasta.getDate() != null);
    }

    private void paintComconent() {
        Utilitarios.paintJdcVacio(jdcFechaDesde);
        Utilitarios.paintJdcVacio(jdcFechaHasta);
    }

    private void resetPaintComponent() {
        Utilitarios.resetPaintJdc(jdcFechaDesde);
        Utilitarios.resetPaintJdc(jdcFechaHasta);
    }

    private void generarReporte() {
        oComprobanteDetalleBl = new ItemsComprobanteBl();
        if (isdatosValidos()) {
            listComprobanteDetalle = oComprobanteDetalleBl.listarSabanon(jdcFechaDesde.getDate(), jdcFechaHasta.getDate());
            if (!listComprobanteDetalle.isEmpty()) {
                generarSabanonExcel(listComprobanteDetalle);
            } else {
                JOptionPane.showMessageDialog(null, "No existen Resultados", "Atención", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            Mensajes.msjValidarIngreso();
            paintComconent();
        }
    }

    private void generarSabanonExcel(ArrayList<ComprobanteDetalle> listComprobanteDetalle) {

        try {
            ComprobanteDetalle obj;
            //Crear titulos de las columnas
            String titulos[] = {"FECHA", "SERVICIO", "PROCEDIMIENTO", "PACIENTE", "N° DNI", "N° HC", "MEDICO ASIGNADO",
                "MEDICO DERIVA", "TIPO PACIENTE", "SEGURO", "BENEFICIO", "EDAD", "MONTO", "TIPO COMPROBANTE", "N° COMPROBANTE",
                "MEDICO QUE ATIENDE", "OBSERVACION", "NRO CARTA", "ESTADO", "MOTIVO ANULACION"};
            //Definir  ruta del archivo
            String ruta = System.getProperty("user.home") + "/Sabanon.xls";
            //Definir File que  contenga el archivo
            File archivo = new File(ruta);
            //Validar  la exietencia del archivo
            if (archivo.exists()) {
                archivo.delete();
            }
            archivo.createNewFile();
            //Creamos el libro excel
            Workbook libro = new HSSFWorkbook();
            //inicializar  flujo de datos
            FileOutputStream file = new FileOutputStream(archivo);
            //Creamos la hoja dentro del libro
            Sheet hoja = (Sheet) libro.createSheet("Sabanon");
            //Escribir los datos en la hoja
            //Creamos una fila en la hoja en la posicion 0
            Row fila = hoja.createRow(0);

            // Creamos el estilo de celda del color VERDE
            HSSFCellStyle styleGroup1 = (HSSFCellStyle) libro.createCellStyle();
            styleGroup1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            styleGroup1.setFillForegroundColor(HSSFColor.GREEN.index);
            //fin de estilo de cabecera
            //Creamos el encabezado
            for (int i = 0; i < titulos.length; i++) {
                Cell celda = fila.createCell(i);
                celda.setCellValue(titulos[i]);
                celda.setCellStyle(styleGroup1);
            }

            //Hacer  el ciclo de acuerdo a la cantidad de datos
            for (int i = 0; i < listComprobanteDetalle.size(); i++) {
                obj = new ComprobanteDetalle();
                obj = listComprobanteDetalle.get(i);
                //la clase row nos permite crear las filas
                Row fila1 = hoja.createRow(i + 1);
                //cantidad de celdas de datos

                for (int j = 0; j < titulos.length; j++) {
                    int iterador = 0;
                    Cell celda1 = fila1.createCell(j);
                    switch (j) {
                        case 0:
                            if (obj.getComprobante().getAtencion() != null) {
                                celda1.setCellValue(obj.getComprobante().getAtencion().getFechaIngreso());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;
                        case 1:
                            if (obj.getProcedimientoTarifario() != null) {
                                celda1.setCellValue(obj.getProcedimientoTarifario().getProcedimiento().getServicio().getDenominacion());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;
                        case 2:
                            if (obj.getProcedimientoTarifario() != null) {
                                if (obj.getProcedimientoTarifario().getProcedimiento() != null) {
                                    celda1.setCellValue(obj.getProcedimientoTarifario().getProcedimiento().getDenominacion());
                                } else {
                                    celda1.setCellValue("");
                                }
                            } else {
                                celda1.setCellValue(obj.getConcepto());
                            }

                            break;
                        case 3:
                            if (obj.getComprobante().getAtencion().getPersona() != null) {
                                celda1.setCellValue(obj.getComprobante().getAtencion().getPersona().getApellidoPaterno().trim()
                                        + " " + obj.getComprobante().getAtencion().getPersona().getApellidoMaterno().trim()
                                        + " " + obj.getComprobante().getAtencion().getPersona().getNombre().trim());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;

                        case 4:
                            if (obj.getIdcomprobantedetalle() != 0 && obj.getComprobante().getIdcomprobante() != 0 && obj.getComprobante().getAtencion().getIdatencion() != 0 && obj.getComprobante().getAtencion().getPersona().getIdpersona() != 0 && obj.getComprobante().getAtencion().getPersona().getNumeroDocumento() != null) {
                                celda1.setCellValue(obj.getComprobante().getAtencion().getPersona().getNumeroDocumento().trim());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;

                        case 5:
                            if (obj != null && obj.getComprobante() != null && obj.getComprobante().getAtencion() != null && obj.getComprobante().getAtencion().getHistoriaClinica() != null && obj.getComprobante().getAtencion().getHistoriaClinica().getNumerohc() != null) {
                                celda1.setCellValue(obj.getComprobante().getAtencion().getHistoriaClinica().getNumerohc());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;

                        case 6:
                            if (obj.getMedicoByIdMedicoAtiende() != null) {
                                celda1.setCellValue(obj.getMedicoByIdMedicoAtiende().getPersona().getNombre().trim()
                                        + " " + obj.getMedicoByIdMedicoAtiende().getPersona().getApellidoPaterno().trim()
                                        + " " + obj.getMedicoByIdMedicoAtiende().getPersona().getApellidoMaterno().trim());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;
                        case 7:
                            if (obj.getMedicoByIdMedicoDeriva() != null) {
                                celda1.setCellValue(obj.getMedicoByIdMedicoDeriva().getPersona().getNombre().trim()
                                        + " " + obj.getMedicoByIdMedicoDeriva().getPersona().getApellidoPaterno().trim()
                                        + " " + obj.getMedicoByIdMedicoDeriva().getPersona().getApellidoMaterno().trim());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;
                        case 8:
                            if (obj.getComprobante().getAtencion() != null) {
                                celda1.setCellValue(obj.getComprobante().getAtencion().getTipoPaciente());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;

                        case 9:
                            if (obj.getComprobante().getBeneficio() != null) {
                                celda1.setCellValue(obj.getComprobante().getBeneficio().getSeguroVida().getDescripcion().trim());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;
                        case 10:
                            if (obj.getComprobante().getBeneficio() != null) {
                                celda1.setCellValue(obj.getComprobante().getBeneficio().getNombreBeneficio().trim());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;
                        case 11:
                            if (obj.getComprobante().getAtencion() != null && obj.getComprobante().getAtencion().getEdad() != null) {
                                celda1.setCellValue(obj.getComprobante().getAtencion().getEdad());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;
                        case 12:
                            celda1.setCellValue(Double.parseDouble(obj.getMontoPagado().toString()));
                            break;
                        case 13:
                            if (obj.getComprobante().getTipoComprobante() != null) {
                                celda1.setCellValue(obj.getComprobante().getTipoComprobante().getDenominacion());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;
                        case 14:
                            if (obj.getComprobante() != null) {
                                celda1.setCellValue(obj.getComprobante().getNumero());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;
                        case 15:
                            if (obj.getMedicoatiendereal() != null) {
                                celda1.setCellValue(obj.getMedicoatiendereal().getPersona().getNombre().trim()
                                        + " " + obj.getMedicoatiendereal().getPersona().getApellidoPaterno().trim()
                                        + " " + obj.getMedicoatiendereal().getPersona().getApellidoMaterno().trim());
                            } else {
                                celda1.setCellValue("");
                            }
                            break;
                        case 16:
                            celda1.setCellValue(obj.getObservacion());
                            break;
                        case 17:
                            celda1.setCellValue(obj.getComprobante().getNumeroCarta());
                            break;
                        case 18:
                            celda1.setCellValue(obj.getComprobante().getEstado().trim());
                            break;
                        case 19:
                            celda1.setCellValue(obj.getComprobante().getMotivoAnulacion() != null ? obj.getComprobante().getMotivoAnulacion().trim() : "");
                            break;
                    }

                }

            }
            /*Escribimos en el libro*/
            libro.write(file);
            //

            /**
             * Primero obtenemos la primera hoja del excel, despues la primera
             * columna que viene siendo la cabecera y despues la cantidad de
             * celdas que tiene esa columna para darle autosize a cada celda en
             * el for.
             */
            for (int i = 0; i < libro.getSheetAt(0).getRow(0)
                    .getLastCellNum(); i++) {
                libro.getSheetAt(0).autoSizeColumn((short) i);
            }
            /*Cerramos el flujo*/
            file.close();
            Mensajes.msjArchivoGeneradoConExito(System.getProperty("user.home"));
        } catch (IOException ex) {
            Logger.getLogger(JIF_Sabanon.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
