package lissa.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import lissa.util.Utilitarios;

public class JP_Print_HistoriaClinica extends javax.swing.JPanel implements Printable {

    private JF_Principal root;
    private String fecha_registro;
    private String numero_hc;
    private String ape_paterno;
    private String ape_materno;
    private String nombres;
    private String sexo;
    private String edad;
    private String lugar_nacimiento;
    private String procedencia;
    private String fecha_nacimiento;
    private String grado_instruccion;
    private String estado_civil;
    private String ocupacion;
    private String dni;
    private String celular;

    private RenderingHints render1 = new RenderingHints(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
    private RenderingHints render2 = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    private RenderingHints render3 = new RenderingHints(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
    private RenderingHints render4 = new RenderingHints(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
    private RenderingHints render5 = new RenderingHints(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
    private RenderingHints render6 = new RenderingHints(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    private RenderingHints render7 = new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

    private RenderingHints render8 = new RenderingHints(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    private RenderingHints render9 = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);

    public JP_Print_HistoriaClinica(JF_Principal root) {
        initComponents();
        this.root = root;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new PrintDataActa();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/hc5.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private PrintDataActa jLabel1;
    /*
    private javax.swing.JLabel jLabel1;
    */
    // End of variables declaration//GEN-END:variables

    void imprimirHc() {
        try {
            //Utilitarios.imprimirSilencioso(this);
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/acta_blanca_recurso.png")));
            Utilitarios.imprimirDialogo((Printable) this);
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/hc5.jpg")));
        } catch (PrinterException ex) {
            Logger.getLogger(JP_Print_HistoriaClinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void clearData() {
        setFecha_registro("");
        setNumero_hc("");
        setApe_paterno("");
        setApe_materno("");
        setNombres("");
        setSexo("");
        setEdad("");
        setLugar_nacimiento("");
        setProcedencia("");
        setFecha_nacimiento("");
        setGrado_instruccion("");
        setEstado_civil("");
        setOcupacion("");
        setDni("");
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getNumero_hc() {
        return numero_hc;
    }

    public void setNumero_hc(String numero_hc) {
        this.numero_hc = numero_hc;
    }

    public String getApe_paterno() {
        return ape_paterno;
    }

    public void setApe_paterno(String ape_paterno) {
        this.ape_paterno = ape_paterno;
    }

    public String getApe_materno() {
        return ape_materno;
    }

    public void setApe_materno(String ape_materno) {
        this.ape_materno = ape_materno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getGrado_instruccion() {
        return grado_instruccion;
    }

    public void setGrado_instruccion(String grado_instruccion) {
        this.grado_instruccion = grado_instruccion;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    void pintarDatos() {
        repaint();
    }

    private void aplicarNitidez(Graphics2D g2D) {
        g2D.addRenderingHints(render1);
        g2D.addRenderingHints(render2);
        g2D.addRenderingHints(render3);
        g2D.addRenderingHints(render4);
        g2D.addRenderingHints(render5);
        g2D.addRenderingHints(render6);
        g2D.addRenderingHints(render7);
        g2D.addRenderingHints(render8);
        g2D.addRenderingHints(render9);
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        return Utilitarios.imprimir(graphics, pageFormat, pageIndex, this);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public class PrintDataActa extends JLabel {

        private int xT = 0;
        private int yT = 0;
        private String textReference;
        private Utilitarios util = new Utilitarios();

        public PrintDataActa() {

        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2D = (Graphics2D) g;

            //Graphics2D g2Dhc = (Graphics2D) g;
            g2D.setFont(util.getArialNormal(22f)); //25
            //g2Dhc.setFont(util.getArialNormal(25f)); //25

            //g2D.setFont(util.getErikaEdesscoTypeItalic(22f)); 
            aplicarNitidez(g2D);
            //aplicarNitidez(g2Dhc);

            int ref_x = 22, ref_y = -2;
            String raya = "--";
            ////////////////////////////////////////
            g2D.drawString(getNumero_hc().toUpperCase(), ref_x + 1200, ref_y + 200);
            g2D.drawString(getFecha_registro().toUpperCase(), ref_x + 200, ref_y + 480);
            g2D.drawString(Utilitarios.horaActual(), ref_x + 800, ref_y + 480);
            g2D.drawString(getApe_paterno().toUpperCase().trim() + " " + getApe_materno().toUpperCase().trim() + " " + getNombres().toUpperCase(), ref_x + 350, ref_y + 520);
            g2D.drawString(getSexo().toUpperCase(), ref_x + 200, ref_y + 560);
            g2D.drawString(getEdad().toUpperCase(), ref_x + 600, ref_y + 560);
            g2D.drawString(getDni().toUpperCase(), ref_x + 1100, ref_y + 560);
            g2D.drawString(getFecha_nacimiento().toUpperCase(), ref_x + 200, ref_y + 640);
            g2D.drawString(getLugar_nacimiento().toUpperCase(), ref_x + 500, ref_y + 640);
            g2D.drawString(getProcedencia().toUpperCase(), ref_x + 1000, ref_y + 640);
            g2D.drawString(getGrado_instruccion().toUpperCase(), ref_x + 340, ref_y + 680);
            g2D.drawString(getEstado_civil().toUpperCase(), ref_x + 650, ref_y + 680);
            g2D.drawString(getOcupacion().toUpperCase(), ref_x + 1150, ref_y + 680);
            g2D.drawString(getCelular().toUpperCase(), ref_x + 1180, ref_y + 715);
        }

        public int getxT() {
            return xT;
        }

        public void setxT(int xT) {
            this.xT = xT;
        }

        public int getyT() {
            return yT;
        }

        public void setyT(int yT) {
            this.yT = yT;
        }

        public String getTextReference() {
            return textReference;
        }

        public void setTextReference(String textReference) {
            this.textReference = textReference;
        }
    }
}
