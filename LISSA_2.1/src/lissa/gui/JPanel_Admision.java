package lissa.gui;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import lissa.be.Caja;
import lissa.be.FondoPrevisionTemp;
import lissa.be.FondoSolidaridad;
import lissa.be.HistoriaClinica;
import lissa.be.ComprobanteDetalle;
import lissa.be.Atencion;
import lissa.be.Cita;
import lissa.be.EstadoCivil;
import lissa.be.Persona;
import lissa.be.PersonaJuridica;
import lissa.be.Rol;
import lissa.be.SeguroVida;
import lissa.be.SeguroVidaUsaPersona;
import lissa.be.TipoDocidentidad;
import lissa.be.TipoHistoriaClinica;
import lissa.be.Usuario;
import lissa.bl.CitaBl;
import lissa.bl.PersonaBl;
import lissa.bl.FondoPrevisionBl;
import lissa.bl.HistoriaClinicaBl;
import lissa.bl.ItemsComprobanteBl;
import lissa.bl.SeguroBl;
import lissa.bl.SeguroPersonaBl;
import lissa.bl.EstadoCivilBl;
import lissa.bl.FondoSolidaridadTempBl;
import lissa.bl.PacienteBl;
import lissa.bl.TipoDocIdentidadBl;
import lissa.bl.TipoHistoriaClinicaBl;
import lissa.bl.TipoPersonaBl;
import lissa.controller.EstadoCivilCtrl;
import lissa.controller.TipoDocIdentidadCtrl;
import lissa.controller.TipoHCCtrl;
import lissa.table.ModeloDetalleAtencion;
import lissa.table.ModeloFondoPrevision;
import lissa.table.ModeloFondoPrevisionTemp;
import lissa.table.ModeloAtencion;
import lissa.table.ModeloPersonas;
import lissa.table.ModeloAtencionesFPS;
import lissa.table.ModelosSeguroVida;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Variables;

public class JPanel_Admision extends javax.swing.JPanel {

    private JF_Principal root;
    private Persona oPersona = null;
    private Persona oPersonaTemp = null;
    private PersonaBl oBLPersona = null;
    private ModeloPersonas modeloPersonas;
    private SeguroVida oSeguroVida;
    private SeguroBl blSeguro;
    private int generaHC = 0;

    //Objetos para los seguros asignados  a una pesona
    private SeguroVidaUsaPersona oSeguroPersona;
    private SeguroPersonaBl blSeguroPersona;
    private ArrayList<SeguroVidaUsaPersona> listIdSeguros;

    private Persona beanTablaPersona;
    private SeguroVida beanTabla;
    private HistoriaClinica oHistoriaClinica = null;
    private HistoriaClinica oHistoriaClinicaTemp;
    private HistoriaClinicaBl oBlHistoriaClinica = null;
    private Atencion oAtencion;
    private PacienteBl oPacienteBl;
    //Objetos para el seguro
    private List<SeguroVida> listSeguro;
    private ModelosSeguroVida oModeloSeguro;

    private int banBoton = 0;
    private int GENEROHC = 0;
    private FondoSolidaridad oFondoSolidaridad = null;
    private FondoPrevisionBl oBlFondoPrevision = null;
    private FondoPrevisionTemp oFondoPrevisionTemp = null;
    private FondoSolidaridadTempBl oFondoSolidaridadTempBl = null;
    private ModeloFondoPrevision oModeloFondoPrevision;
    private ModeloFondoPrevisionTemp oModeloFondoPrevisionTemp;

    private EstadoCivilBl estadoCivilBl;
    private ArrayList<EstadoCivil> listEstadoCivil;
    private TipoDocIdentidadBl oTipoDocIdentidadBl;
    private ArrayList<TipoDocidentidad> listTipoDocIdentidad;
    private TipoDocIdentidadCtrl oTipoDocIdentidadCtrl;
    private TipoHCCtrl oTipoHCCtrl;
    private EstadoCivilCtrl oEstadoCivilCtrl;
    private ModeloAtencion oModeloPaciente = null;
    private ArrayList<Atencion> listPaciente;
    private ArrayList<ComprobanteDetalle> listItemsComprobante;
    private ModeloDetalleAtencion oModeloDetalleAtencion;
    private ItemsComprobanteBl oItemsComprobanteBl;
    private ModeloAtencionesFPS oModeloAtencionesFPS;
    private ComprobanteDetalle oComprobanteDetalle;
    private ItemsComprobanteBl oComprobanteDetalleBl;
    private List<ComprobanteDetalle> listComprobanteDetalle;

    private Usuario userTemp;
    //private Persona perTemp;
    private Rol rolTemp;

    private Caja oCaja;
    private PacienteBl oBlPaciente;
    private FondoPrevisionBl oFondoSolidaridadBl;
    private JComboBox cbxTipoHCBusq;
    private JComboBox cbxTipohc;
    private Cita oCita;
    private CitaBl oCitaBl;

    public JPanel_Admision(JF_Principal root) throws SQLException {
        initComponents();
        this.root = root;
        modeloPersonas = new ModeloPersonas();
        tblResultados.setModel(modeloPersonas);
        oModeloSeguro = new ModelosSeguroVida();
        tblSeguros.setModel(oModeloSeguro);
        oModeloFondoPrevision = new ModeloFondoPrevision();
        tblFondoPrevision.setModel(oModeloFondoPrevision);
        oModeloFondoPrevisionTemp = new ModeloFondoPrevisionTemp();
        tblFondoPrevisionTemp.setModel(oModeloFondoPrevisionTemp);
        oModeloPaciente = new ModeloAtencion();
        tblIngresos.setModel(oModeloPaciente);
        oModeloDetalleAtencion = new ModeloDetalleAtencion();
        tblServicios.setModel(oModeloDetalleAtencion);
        oModeloAtencionesFPS = new ModeloAtencionesFPS();
        tblAtencionesFondo.setModel(oModeloAtencionesFPS);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        txfBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txfHistoriaClinica = new javax.swing.JTextField();
        btnGenerarHC = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txfApePaterno = new javax.swing.JTextField();
        txfApeMaterno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txfNombres = new javax.swing.JTextField();
        txfnNumDni = new javax.swing.JTextField();
        txfTelefono = new javax.swing.JTextField();
        jdcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        cbxSexo = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        txfGradoInstruccion = new javax.swing.JTextField();
        txfLugarProcedencia = new javax.swing.JTextField();
        txfLugarNacimiento = new javax.swing.JTextField();
        cbxTipoDoc = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        txfCorreo = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        cbxEstadoCivil = new javax.swing.JComboBox();
        jLabel44 = new javax.swing.JLabel();
        txfOcupacion = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxAutorizaUsoDatos = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        txfDireccion = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cbxTipoIngreso = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cbxTipoPaciente = new javax.swing.JComboBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblIngresos = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblServicios = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbxSeguro = new javax.swing.JComboBox();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSeguros = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblFondoPrevisionTemp = new javax.swing.JTable();
        btnGuardarFondoPrev = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFondoPrevision = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblAtencionesFondo = new javax.swing.JTable();
        btnConsultar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txfNumeroCita = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txfFechaCita = new javax.swing.JTextField();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BÚSQUEDA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txfBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBusquedaActionPerformed(evt);
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
        jScrollPane1.setViewportView(tblResultados);

        jLabel10.setText("Apellidos y Nombres/DNI:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(txfBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HISTORIA CLÍNICA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("N° :");

        txfHistoriaClinica.setEditable(false);
        txfHistoriaClinica.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txfHistoriaClinica.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnGenerarHC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Ok-icon.png"))); // NOI18N
        btnGenerarHC.setToolTipText("Generar HC");
        btnGenerarHC.setEnabled(false);
        btnGenerarHC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarHCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfHistoriaClinica, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGenerarHC, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(txfHistoriaClinica)
                    .addComponent(btnGenerarHC))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE LA PERSONA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Apellido Paterno :");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Apellido Materno :");

        txfApePaterno.setEnabled(false);
        txfApePaterno.setPreferredSize(new java.awt.Dimension(234, 20));

        txfApeMaterno.setEnabled(false);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Nombres :");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Fecha de  Nacimiento :");

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Tipo Doc :");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Correo electrónico :");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Grado de instrucción :");

        txfNombres.setEnabled(false);
        txfNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombresActionPerformed(evt);
            }
        });

        txfnNumDni.setEnabled(false);
        txfnNumDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfnNumDniActionPerformed(evt);
            }
        });
        txfnNumDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfnNumDniKeyReleased(evt);
            }
        });

        txfTelefono.setEnabled(false);

        jdcFechaNacimiento.setEnabled(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Sexo :");

        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<SELECCIONE>", "FEMENINO", "MASCULINO" }));
        cbxSexo.setEnabled(false);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Lugar de Procedencia :");

        txfGradoInstruccion.setEnabled(false);

        txfLugarProcedencia.setEnabled(false);

        txfLugarNacimiento.setEnabled(false);
        txfLugarNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfLugarNacimientoActionPerformed(evt);
            }
        });

        cbxTipoDoc.setEnabled(false);
        cbxTipoDoc.setMaximumSize(new java.awt.Dimension(28, 20));

        jLabel40.setText("Telefono :");

        txfCorreo.setEnabled(false);

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel41.setText("Estado civil :");

        cbxEstadoCivil.setEnabled(false);

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel44.setText("Ocupación :");

        txfOcupacion.setEnabled(false);

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel45.setText("Nº Doc :");

        jLabel52.setText("Lugar de Nacimiento :");

        jLabel4.setText("Autoriza uso de datos :");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cbxAutorizaUsoDatos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<SELECCIONE>", "SI", "NO", "REVOCÓ" }));
        cbxAutorizaUsoDatos.setEnabled(false);

        jLabel18.setText("Dirección :");

        txfDireccion.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfnNumDni, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfApePaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txfOcupacion, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(txfDireccion))
                                .addGap(19, 19, 19)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfLugarProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfApeMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfGradoInstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbxSexo, 0, 185, Short.MAX_VALUE)
                                .addComponent(txfLugarNacimiento))
                            .addComponent(cbxAutorizaUsoDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(txfNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txfApePaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txfApeMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(cbxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(txfnNumDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(jLabel41)
                            .addComponent(cbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txfLugarProcedencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel52)
                    .addComponent(txfLugarNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(txfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel15)
                    .addComponent(txfGradoInstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(txfOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxAutorizaUsoDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INGRESO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Ok-icon.png"))); // NOI18N
        jButton1.setText("Registrar Ingreso");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel17.setText("Tipo Ingreso :");

        cbxTipoIngreso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<SELECCIONE>", "CONSULTA", "RE-EVALUACION", "OCUPACIONAL", "OTROS" }));
        cbxTipoIngreso.setEnabled(false);
        cbxTipoIngreso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoIngresoItemStateChanged(evt);
            }
        });

        jLabel12.setText("Tipo Paciente :");

        cbxTipoPaciente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<SELECCIONE>", "PARTICULAR", "SOCIO", "SEGURO", " " }));
        cbxTipoPaciente.setEnabled(false);
        cbxTipoPaciente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoPacienteItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipoIngreso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(25, 25, 25)
                .addComponent(cbxTipoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton1))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(cbxTipoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(cbxTipoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3))
        );

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ATENCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tblIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblIngresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblIngresosMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tblIngresos);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SERVICIO/PROCEDIMIENTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tblServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tblServicios);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("ATENCION", jPanel15);

        jLabel2.setText("Seguro :");

        cbxSeguro.setEnabled(false);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/add.png"))); // NOI18N
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/remove.png"))); // NOI18N
        btnQuitar.setEnabled(false);
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        tblSeguros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblSeguros);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSeguro, 0, 863, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(btnQuitar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbxSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SEGUROS", jPanel4);

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

        btnGuardarFondoPrev.setText(">>");
        btnGuardarFondoPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarFondoPrevActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 51));
        jLabel23.setText("Besterp");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 51));
        jLabel24.setText("Lissa");

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

        tblAtencionesFondo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(tblAtencionesFondo);

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarFondoPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnConsultar)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel23)
                        .addGap(291, 291, 291)
                        .addComponent(jLabel24)
                        .addGap(175, 468, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(btnConsultar))
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(btnGuardarFondoPrev)
                        .addGap(75, 75, 75))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
        );

        jTabbedPane1.addTab("FONDO DE PREVISIÓN", jPanel7);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/new.png"))); // NOI18N
        btnNuevo.setPreferredSize(new java.awt.Dimension(65, 40));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/edit.png"))); // NOI18N
        btnEditar.setEnabled(false);
        btnEditar.setPreferredSize(new java.awt.Dimension(65, 40));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/Save.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setPreferredSize(new java.awt.Dimension(65, 40));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/cancel.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(65, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lissa/resources/distributor-report-icon.png"))); // NOI18N
        jButton3.setToolTipText("Ficha de Datos");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CITA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("N° :");

        txfNumeroCita.setEditable(false);
        txfNumeroCita.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txfNumeroCita.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Fecha :");

        txfFechaCita.setEditable(false);
        txfFechaCita.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txfFechaCita.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfNumeroCita, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfFechaCita, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfNumeroCita)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txfFechaCita))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTabbedPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txfBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBusquedaActionPerformed
        btnBuscar.doClick();
    }//GEN-LAST:event_txfBusquedaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarPersona();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblResultadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultadosMouseReleased
        oModeloFondoPrevisionTemp.clear();
        oModeloFondoPrevision.clear();
        oModeloSeguro.clear();
        oModeloPaciente.clear();
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            try {
                resetComponent();
                obtenerDatosPaciente();
                jButton1.setEnabled(true);
                estadoDatosIngreso(true);
                estadoTextFields(false);
                activarBotones(true, true, false, true);
            } catch (SQLException ex) {
                Logger.getLogger(JPanel_Admision.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un item", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_tblResultadosMouseReleased

    private void btnGenerarHCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarHCActionPerformed
        if (oHistoriaClinica == null) {
            generaHC = 1;
            generarHistoriaClinica();
        } else {
            JOptionPane.showMessageDialog(null, "No se puede generar una nueva HC para el paciente", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnGenerarHCActionPerformed

    private void txfNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombresActionPerformed

    private void txfnNumDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfnNumDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfnNumDniActionPerformed

    private void txfnNumDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfnNumDniKeyReleased
        if (cbxTipoDoc.getSelectedItem().toString().trim().equals("DNI")) {
            Utilitarios.validaNumeroCaracteres(txfnNumDni, 8);
        }
        Utilitarios.validaCaracterNumerico(evt, txfnNumDni);
        txfnNumDni.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_txfnNumDniKeyReleased

    private void txfLugarNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfLugarNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfLugarNacimientoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Registrar el nuevo ingreso del paciente
        if (isDatosValidos()) {
            if (idDatosValidosIngreso()) {
                resetPaintDatosIngreso();
                long id = registrarIngresoPaciente();
                if (id != 0) {
                    //Mensajes.msjRegCorrecta();
                    cargarJifAtencion();
                    btnCancelar.doClick();
                } else {
                    Mensajes.msjRegError();
                }
            } else {
                paintDatosIngreso();
                Mensajes.msjValidarIngreso();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor actualice los datos del paciente", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        configuraNuevo();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblResultados.getSelectedRow() != -1) {
            configuraActualizar();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una persona", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        configuraGuardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        configuraCancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        resetComponent();
    }//GEN-LAST:event_formComponentHidden

    private void cbxTipoIngresoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoIngresoItemStateChanged

    }//GEN-LAST:event_cbxTipoIngresoItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        //Verificar conexión a la base de datos del besterp, si existe buscar fondo de prevision
        //Listar Fondo de Prevision desde el  BESTERP
        if (beanTablaPersona != null) {
            if (!txfnNumDni.getText().trim().equals("")) {
                ArrayList<FondoPrevisionTemp> listFpBesterp = new ArrayList<>();
                if (beanTablaPersona.getNumeroDocumento() != null) {
                    listFpBesterp = LlenarPagoFondoPrevision(beanTablaPersona.getNumeroDocumento().trim());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese N° DNI", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cargue los datos de la persona", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void tblFondoPrevisionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFondoPrevisionMouseReleased
        obtenerFPS();
    }//GEN-LAST:event_tblFondoPrevisionMouseReleased

    private void btnGuardarFondoPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarFondoPrevActionPerformed
        //si esta seleccionado una fila
        if (oFondoPrevisionTemp != null) {
            //validar si el fondo ya existe no debe registrarse
            if (existeFondo()) {
                JOptionPane.showMessageDialog(null, "El fondo ya se encuentra registrado", "Atención", JOptionPane.INFORMATION_MESSAGE);
            } else {
                registrarFondoPrev();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un fondo de previsión", Mensajes.getTituloAtencion(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarFondoPrevActionPerformed

    private void tblFondoPrevisionTempMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFondoPrevisionTempMouseReleased
        if (tblFondoPrevisionTemp.getRowSelectionAllowed()) {
            obtenerDatosFondoPrevTemp();
        }
    }//GEN-LAST:event_tblFondoPrevisionTempMouseReleased

    private void tblIngresosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIngresosMouseReleased
        if (tblResultados.getRowSelectionAllowed() && tblResultados.getSelectedRow() != -1) {
            oAtencion = oModeloPaciente.get(tblIngresos.getSelectedRow());
            if (oAtencion != null) {
                listarServicios(oAtencion);
                personalizaVistaTabla();
            }

        }
    }//GEN-LAST:event_tblIngresosMouseReleased

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        quitarEliminar();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        llenarTablaSeguros();
        personalizaVistaTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cbxTipoPacienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoPacienteItemStateChanged

    }//GEN-LAST:event_cbxTipoPacienteItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGenerarHC;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarFondoPrev;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuitar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cbxAutorizaUsoDatos;
    private javax.swing.JComboBox cbxEstadoCivil;
    private javax.swing.JComboBox cbxSeguro;
    private javax.swing.JComboBox cbxSexo;
    private javax.swing.JComboBox cbxTipoDoc;
    private javax.swing.JComboBox cbxTipoIngreso;
    private javax.swing.JComboBox cbxTipoPaciente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdcFechaNacimiento;
    private javax.swing.JTable tblAtencionesFondo;
    private javax.swing.JTable tblFondoPrevision;
    private javax.swing.JTable tblFondoPrevisionTemp;
    private javax.swing.JTable tblIngresos;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTable tblSeguros;
    private javax.swing.JTable tblServicios;
    private javax.swing.JTextField txfApeMaterno;
    private javax.swing.JTextField txfApePaterno;
    private javax.swing.JTextField txfBusqueda;
    private javax.swing.JTextField txfCorreo;
    private javax.swing.JTextField txfDireccion;
    private javax.swing.JTextField txfFechaCita;
    private javax.swing.JTextField txfGradoInstruccion;
    private javax.swing.JTextField txfHistoriaClinica;
    private javax.swing.JTextField txfLugarNacimiento;
    private javax.swing.JTextField txfLugarProcedencia;
    private javax.swing.JTextField txfNombres;
    private javax.swing.JTextField txfNumeroCita;
    private javax.swing.JTextField txfOcupacion;
    private javax.swing.JTextField txfTelefono;
    private javax.swing.JTextField txfnNumDni;
    // End of variables declaration//GEN-END:variables

    private void personalizaVistaTabla() {
        Utilitarios.formateaColumna(0, tblSeguros, 60);
        Utilitarios.formateaColumna(0, tblFondoPrevision, 60);
        Utilitarios.formateaColumna(0, tblResultados, 60);
        Utilitarios.formateaColumna(0, tblIngresos, 60);
        Utilitarios.formateaColumna(1, tblIngresos, 60);
        Utilitarios.formateaColumna(2, tblIngresos, 60);
        Utilitarios.formateaColumna(0, tblServicios, 60);
        Utilitarios.formateaColumna(2, tblServicios, 60);
    }

    private void buscarPersona() {
        oPersona = new Persona();
        oBLPersona = new PersonaBl();
        String ref = txfBusqueda.getText().trim().toUpperCase();
        modeloPersonas.clear();
        if (!ref.equals("")) {
            if (!oBLPersona.buscar(ref).isEmpty()) {
                modeloPersonas.addAll(oBLPersona.buscar(ref));
            } else {
                JOptionPane.showMessageDialog(null, "No existe resultados de búsqueda", "Atención", JOptionPane.INFORMATION_MESSAGE);                
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese parámetros de búsqueda", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }

        personalizaVistaTabla();
    }

    private void configuraGuardar() {
        //CUANDO EL REGISTRO DEL PACIENTE ES NUEVO
        if (banBoton == 1) {
            if (isDatosValidos()) {
                if (isDniValido()) {
                    if (registrar() == Variables.SUCCESS) {
                        Mensajes.msjRegCorrecta();
                        modeloPersonas.clear();
                        modeloPersonas.add(buscarPersonaXDni());
                        oModeloSeguro.clear();
                        oModeloFondoPrevision.clear();
                        personalizaVistaTabla();
                        resetComponent();
                        resetPaintComponent();
                        estadoTextFields(false);
                    } else {
                        Mensajes.msjRegError();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "La persona con el N° de DNI ya se encuentra registrado", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    txfnNumDni.setText("");
                    txfnNumDni.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos", "Atención", JOptionPane.INFORMATION_MESSAGE);
                paintComponent();
            }

        } else if (banBoton == 2) {
            if (isDatosValidos()) {
                if (actualizar() == Variables.SUCCESS) {
                    Mensajes.msjActCorrecta();
                    modeloPersonas.clear();
                    modeloPersonas.add(buscarPersonaXDni());
                    oModeloSeguro.clear();
                    oModeloFondoPrevision.clear();
                    oModeloDetalleAtencion.clear();
                    oModeloPaciente.clear();
                    personalizaVistaTabla();
                    resetComponent();
                    resetPaintComponent();
                } else {
                    Mensajes.msjActErronea();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos", "Atención", JOptionPane.INFORMATION_MESSAGE);
                paintComponent();
            }

        }

        personalizaVistaTabla();
    }

    void resetComponent() {
        this.txfApePaterno.setText("");
        this.txfApeMaterno.setText("");
        this.txfNombres.setText("");
        this.jdcFechaNacimiento.setDate(null);
        this.txfnNumDni.setText("");
        this.txfDireccion.setText("");
        this.txfTelefono.setText("");
        this.txfHistoriaClinica.setText("");
        this.cbxSexo.setSelectedIndex(0);
        this.txfGradoInstruccion.setText("");
        this.txfLugarNacimiento.setText("");
        this.txfLugarProcedencia.setText("");
        this.txfBusqueda.setText("");
        this.jButton1.setEnabled(false);
        this.cbxEstadoCivil.setSelectedIndex(0);
        this.txfCorreo.setText("");
        txfNumeroCita.setText("");
        txfFechaCita.setText("");
        cbxTipoIngreso.setSelectedIndex(0);
        jTabbedPane1.setSelectedIndex(0);
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        cbxTipoDoc.setSelectedIndex(0);
        cbxAutorizaUsoDatos.setSelectedIndex(0);
        cbxTipoPaciente.setSelectedIndex(0);
        if (oCita != null) {
            oCita = null;
        }
        if(oPersona != null){
            oPersona = null;
        }
        if(oPersonaTemp != null){
            oPersonaTemp = null;
        }
        if(oHistoriaClinica != null){
            oHistoriaClinica = null;
        }
        if(oHistoriaClinicaTemp != null){
            oHistoriaClinicaTemp = null;
        }        
        generaHC = 0;
    }

    private void activarBotones(boolean guardar, boolean cancelar) {
        btnGuardar.setEnabled(guardar);
        btnCancelar.setEnabled(cancelar);
    }

    private void configuraCancelar() {
        resetComponent();
        estadoDatosIngreso(false);
        resetPaintComponent();
        estadoTextFields(false);
        activarBotones(true, false, false, true);
        modeloPersonas.clear();
        oModeloFondoPrevision.clear();
        oModeloFondoPrevisionTemp.clear();
        oModeloDetalleAtencion.clear();
        oModeloPaciente.clear();
        oModeloSeguro.clear();
        personalizaVistaTabla();
    }

    private int registrar() {
        oPersona = new Persona();
        oBLPersona = new PersonaBl();

        oPersona.setApellidoPaterno(txfApePaterno.getText().trim().toUpperCase());
        oPersona.setApellidoMaterno(txfApeMaterno.getText().trim().toUpperCase());
        oPersona.setNombre(txfNombres.getText().trim().toUpperCase());
        oPersona.setNumeroDocumento(txfnNumDni.getText().trim().toUpperCase());
        oPersona.setFechaNacimiento(jdcFechaNacimiento.getDate());
        oPersona.setTelefono(txfTelefono.getText().trim());
        oPersona.setSexo(cbxSexo.getSelectedIndex() > 0 ? cbxSexo.getSelectedItem().toString().toUpperCase().trim() : "");
        oPersona.setEstado(1);
        oPersona.setFechaReg(new Date());
        oPersona.setGradoInstruccion(txfGradoInstruccion.getText().toUpperCase().trim());
        oPersona.setLugarNacimiento(txfLugarNacimiento.getText().toUpperCase().trim());
        oPersona.setLugarProcedencia(txfLugarProcedencia.getText().toUpperCase().trim());
        oPersona.setOcupacion(txfOcupacion.getText().toUpperCase().trim());
        oPersona.setCorreoElectronico(txfCorreo.getText().toUpperCase().trim());
        oPersona.setTipoDocidentidad(cbxTipoDoc.getSelectedIndex() > 0 ? (TipoDocidentidad) cbxTipoDoc.getSelectedItem() : null);
        oPersona.setEstadoCivil(cbxEstadoCivil.getSelectedIndex() > 0 ? (EstadoCivil) cbxEstadoCivil.getSelectedItem() : null);
        oPersona.setAutorizaUsoDatos(cbxAutorizaUsoDatos.getSelectedIndex() > 0 ? cbxAutorizaUsoDatos.getSelectedItem().toString().trim() : "");
        oPersona.setTipoPersona(new TipoPersonaBl().buscarxId(1));
        oPersona.setRazonSocial("");
        oPersona.setRuc("");
        oPersona.setDireccion(txfDireccion.getText().toUpperCase().trim());
        oPersona.setEsproveedor(0);

        if (generaHC == 1 & !txfHistoriaClinica.getText().equals("")) {
            oHistoriaClinica = new HistoriaClinica();
            //validar  si el numero de historia clinica  ya existe
            oHistoriaClinica.setNumerohc(Integer.parseInt(txfHistoriaClinica.getText().trim()));
            oHistoriaClinica.setFechaRegistro(new Date());
            oHistoriaClinica.setTipoHistoriaClinica((TipoHistoriaClinica) cbxTipohc.getSelectedItem());
            oHistoriaClinica.setEstado(0);//0 = NUEVO 
        }

        return oBLPersona.registrar(oPersona, oHistoriaClinica, oModeloSeguro);        
    }

    private long registrarIngresoPaciente() {
        oAtencion = new Atencion();
        oPacienteBl = new PacienteBl();
        oAtencion.setPersona(beanTablaPersona);
        oAtencion.setFechaIngreso(new Date());
        oAtencion.setNumeroAtencion(ultimoNumAtencion());
        oAtencion.setTipoIngreso(cbxTipoIngreso.getSelectedItem().toString());
        oAtencion.setTipoPaciente(cbxTipoPaciente.getSelectedItem().toString());
        oAtencion.setIdUseradmision(userTemp.getIdUsuario());
        if (oHistoriaClinica != null) {
            oAtencion.setHistoriaClinica(oHistoriaClinica);
        }
        oAtencion.setEstado("REG");
        oAtencion.setCita(oCita != null ? oCita : null);
        oAtencion.setEdad(beanTablaPersona.getFechaNacimiento() != null ? Utilitarios.obtenerEdad(beanTablaPersona.getFechaNacimiento()) : null);
        return oPacienteBl.registrar(oAtencion);
    }

    private int actualizar() {
        oPersonaTemp = new Persona();
        oBLPersona = new PersonaBl();

        oPersonaTemp.setIdpersona(beanTablaPersona.getIdpersona());
        oPersonaTemp.setApellidoPaterno(txfApePaterno.getText().trim().toUpperCase());
        oPersonaTemp.setApellidoMaterno(txfApeMaterno.getText().trim().toUpperCase());
        oPersonaTemp.setNombre(txfNombres.getText().trim().toUpperCase());
        oPersonaTemp.setNumeroDocumento(txfnNumDni.getText().trim());
        oPersonaTemp.setFechaNacimiento(jdcFechaNacimiento.getDate());
        oPersonaTemp.setTelefono(txfTelefono.getText().trim());
        oPersonaTemp.setEstado(1);
        oPersonaTemp.setFechaReg(beanTablaPersona.getFechaReg());
        oPersonaTemp.setGradoInstruccion(txfGradoInstruccion.getText().toUpperCase().trim());
        oPersonaTemp.setLugarNacimiento(txfLugarNacimiento.getText().toUpperCase().trim());
        oPersonaTemp.setLugarProcedencia(txfLugarProcedencia.getText().toUpperCase().trim());
        oPersonaTemp.setSexo(cbxSexo.getSelectedIndex() == 0 ? "" : cbxSexo.getSelectedItem().toString().toUpperCase().trim());
        oPersonaTemp.setOcupacion(txfOcupacion.getText().toUpperCase().trim());
        oPersonaTemp.setCorreoElectronico(txfCorreo.getText().toUpperCase().trim());
        oPersonaTemp.setTipoDocidentidad(cbxTipoDoc.getSelectedIndex() > 0 ? (TipoDocidentidad) cbxTipoDoc.getSelectedItem() : null);
        oPersonaTemp.setEstadoCivil(cbxEstadoCivil.getSelectedIndex() > 0 ? (EstadoCivil) cbxEstadoCivil.getSelectedItem() : null);
        oPersonaTemp.setAutorizaUsoDatos(cbxAutorizaUsoDatos.getSelectedIndex() > 0 ? cbxAutorizaUsoDatos.getSelectedItem().toString().trim() : "");
        oPersonaTemp.setTipoPersona(beanTablaPersona.getTipoPersona() != null ? beanTablaPersona.getTipoPersona() : new TipoPersonaBl().buscarxId(1));
        oPersonaTemp.setRazonSocial(!beanTablaPersona.getRazonSocial().trim().equals("") ? beanTablaPersona.getRazonSocial().trim() : "");
        oPersonaTemp.setRuc(!beanTablaPersona.getRuc().trim().equals("") ? beanTablaPersona.getRuc().trim() : "");
        oPersonaTemp.setEsproveedor(beanTablaPersona.getEsproveedor());
        oPersonaTemp.setDireccion(txfDireccion.getText().toUpperCase().trim());

        //Registrar Historia Clinica para pacientes que  no cuenten con uno
        if (generaHC == 1) {
            oHistoriaClinicaTemp = new HistoriaClinica();
            oBlHistoriaClinica = new HistoriaClinicaBl();
            //validar  si el numero de historia clinica  ya existe
            oHistoriaClinicaTemp.setNumerohc(Integer.parseInt(txfHistoriaClinica.getText().trim()));
            oHistoriaClinicaTemp.setFechaRegistro(new Date());
            oHistoriaClinicaTemp.setTipoHistoriaClinica((TipoHistoriaClinica) cbxTipohc.getSelectedItem());
            oHistoriaClinicaTemp.setEstado(0);//0 = NUEVO
        }

        return oBLPersona.actualizar(oPersonaTemp, oHistoriaClinicaTemp, oModeloSeguro);       
    }


    private void llenarCbxSeguro() {
        blSeguro = new SeguroBl();
        listSeguro = blSeguro.listar();
        cbxSeguro.removeAllItems();
        cbxSeguro.addItem("<Seleccione>");
        for (SeguroVida seguro : listSeguro) {
            seguro.setOp(SeguroVida.DATO);
            cbxSeguro.addItem(seguro);
        }
    }

    private void llenarTablaSeguros() {
        if (cbxSeguro.getSelectedIndex() != 0) {
            oSeguroVida = new SeguroVida();
            oSeguroVida.setIdSeguroVida(((SeguroVida) cbxSeguro.getSelectedItem()).getIdSeguroVida());
            oSeguroVida.setDescripcion(cbxSeguro.getSelectedItem().toString());
            if (!existeSeguroDuplicadoTemp() && !existeSeguroDuplicadoDb()) {
                oModeloSeguro.add(oSeguroVida);
            } else {
                JOptionPane.showMessageDialog(null, "El seguro seleccionado ya existe", "Atención", JOptionPane.INFORMATION_MESSAGE);
            }
            cbxSeguro.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un seguro", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private boolean existeSeguroDuplicadoTemp() {
        boolean val = false;
        for (int i = 0; i < oModeloSeguro.getRowCount(); i++) {
            for (int j = 0; j < oModeloSeguro.getColumnCount(); j++) {
                if (oSeguroVida.getIdSeguroVida() == Integer.parseInt(oModeloSeguro.getValueAt(i, j).toString())) {
                    val = true;
                    i = oModeloSeguro.getRowCount();
                } else {
                    val = false;
                }
                j = oModeloSeguro.getColumnCount();
            }
        }
        return val;
    }

    private boolean existeSeguroDuplicadoDb() {
        SeguroVida seguro = new SeguroVida();
        boolean val = false;
        if (oModeloSeguro.size() > 0) {
            for (int i = 0; i < oModeloSeguro.size(); i++) {
                seguro = (SeguroVida) oModeloSeguro.get(i);
                if (oSeguroVida.getIdSeguroVida() != seguro.getIdSeguroVida()) {
                    val = false;
                } else {
                    JOptionPane.showMessageDialog(null, "El seguro seleccionado ya existe", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    val = true;
                }
            }
        }

        return val;
    }


    public boolean existeSeguroPersona(long idPersona, int idSeguro) {
        blSeguroPersona = new SeguroPersonaBl();
        SeguroVidaUsaPersona temp = new SeguroVidaUsaPersona();
        boolean existe = false;
        temp = blSeguroPersona.buscarSeguroPersona(idPersona, idSeguro);
        if (temp == null) {
            existe = false;
        } else {
            existe = true;
        }
        return existe;
    }

    private void obtenerDatosTabla() {
        beanTabla = (SeguroVida) oModeloSeguro.get(tblSeguros.getSelectedRow());
        Utilitarios.recuperaDatosSeguro(beanTabla.getIdSeguroVida(), this.cbxSeguro);
    }

    private ArrayList<SeguroVidaUsaPersona> listarSegurosPorPersona() {
        blSeguroPersona = new SeguroPersonaBl();
        return blSeguroPersona.listar(beanTablaPersona.getIdpersona());

    }

    private void listarSegurosBD() {
        blSeguro = new SeguroBl();
        listIdSeguros = listarSegurosPorPersona();
        if (!listIdSeguros.isEmpty()) {
            oModeloSeguro.clear();
            for (SeguroVidaUsaPersona svup : listIdSeguros) {
                oModeloSeguro.add(blSeguro.buscar(svup.getSeguroVida().getIdSeguroVida()));
            }
            personalizaVistaTabla();
        }

    }

    private void quitarEliminar() {
        oSeguroPersona = new SeguroVidaUsaPersona();
        blSeguroPersona = new SeguroPersonaBl();
        if (tblSeguros.getSelectedRow() != -1) {
            //obtenerDatosTabla();
//            if (beanTabla.getIdSeguroVida() != 0) {
//                //eliminar desde  la base de datos
//                //blSeguro.eliminar(beanTabla);
//                blSeguroPersona.eliminar(beanTabla.getIdSeguroVida());
//
//            } else {
            //eliminar de forma temporal
            oModeloSeguro.remove(tblSeguros.getSelectedRow());
            //}

        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un elemento de la lista", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
        }
        cbxSeguro.setSelectedIndex(0);
    }

    private void administrarPaciente() {
        root.insertarInternalFrames(root.jifAdministrarPersonanatural);
    }

    void cargarDatosPersona(Persona beanTabla) {
        HistoriaClinica hc = new HistoriaClinica();
        this.oPersona = beanTabla;
        //txfNombres.setText(oPersona.getApellidoPaterno().toUpperCase() + " " + oPersona.getApellidoMaterno().toUpperCase() + " " + oPersona.getNombre().toUpperCase());
        //txfNumDoc.setText(oPersona.getNumeroDocumento());
        hc = obtenerHistoriaClinica(oPersona.getNumeroDocumento());
        if (hc != null) {
            txfHistoriaClinica.setText(Utilitarios.numberFormat(hc.getNumerohc(), "######"));
        }

        //listarSegurosBD();
    }

    private boolean isDatosValidos() {
        return (!this.txfNombres.getText().trim().equals("")
                && !this.txfApePaterno.getText().trim().equals("")
                && !this.txfApeMaterno.getText().trim().equals("")
                && this.cbxTipoDoc.getSelectedIndex() > 0
                && !this.txfnNumDni.getText().trim().equals("")
                && jdcFechaNacimiento.getDate() != null
                && !txfTelefono.getText().trim().equals("")
                && !txfDireccion.getText().trim().equals(""));

    }

    private void generarHistoriaClinica() {
        if (cbxTipohc.getSelectedIndex() > 0) {
            oBlHistoriaClinica = new HistoriaClinicaBl();
            int numHC = 0;
            numHC = oBlHistoriaClinica.generarHCxTipo((TipoHistoriaClinica) cbxTipohc.getSelectedItem()) + 1;
            txfHistoriaClinica.setText("" + Utilitarios.numberFormat(numHC, "######"));
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione el tipo de historia a generar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private HistoriaClinica registrarHistoriaClinica() {
        oHistoriaClinica = new HistoriaClinica();
        oBlHistoriaClinica = new HistoriaClinicaBl();
        //validar  si el numero de historia clinica  ya existe
        oHistoriaClinica.setNumerohc(Integer.parseInt(txfHistoriaClinica.getText().trim()));
        oHistoriaClinica.setFechaRegistro(new Date());
        oHistoriaClinica.setPersona(oPersona);
        oHistoriaClinica.setTipoHistoriaClinica((TipoHistoriaClinica) cbxTipohc.getSelectedItem());
        oHistoriaClinica.setEstado(0);//0 = NUEVO

        return oBlHistoriaClinica.registrar(oHistoriaClinica);
    }

    private HistoriaClinica obtenerHistoriaClinica(String numeroDocumento) {
        oHistoriaClinica = new HistoriaClinica();
        oBlHistoriaClinica = new HistoriaClinicaBl();
        oHistoriaClinica = oBlHistoriaClinica.buscarXdniPersona(numeroDocumento);
        return oHistoriaClinica;
    }

    private void activarBotones(boolean nuevo, boolean modificar, boolean guardar, boolean cancelar) {
        btnNuevo.setEnabled(nuevo);
        btnEditar.setEnabled(modificar);
        btnGuardar.setEnabled(guardar);
        btnCancelar.setEnabled(cancelar);
    }

    private void estadoTextFields(boolean e) {
        this.txfApePaterno.setEnabled(e);
        this.txfApeMaterno.setEnabled(e);
        this.txfNombres.setEnabled(e);
        this.jdcFechaNacimiento.setEnabled(e);
        this.txfnNumDni.setEnabled(e);
        this.txfDireccion.setEnabled(e);
        this.txfTelefono.setEnabled(e);
        this.cbxSexo.setEnabled(e);
        this.txfGradoInstruccion.setEnabled(e);
        this.txfLugarNacimiento.setEnabled(e);
        this.txfLugarProcedencia.setEnabled(e);
        this.btnGenerarHC.setEnabled(e);
        this.btnAgregar.setEnabled(e);
        this.btnQuitar.setEnabled(e);
        this.cbxSeguro.setEnabled(e);
        this.cbxTipoDoc.setEnabled(e);
        this.cbxTipohc.setEnabled(e);
        txfCorreo.setEnabled(e);
        this.cbxEstadoCivil.setEnabled(e);
        this.txfOcupacion.setEnabled(e);
        cbxAutorizaUsoDatos.setEnabled(e);
    }

    private void obtenerDatosPaciente() throws SQLException {
        //resetComponent();
        beanTablaPersona = (Persona) modeloPersonas.get(tblResultados.getSelectedRow());
        this.txfNombres.setText(beanTablaPersona.getNombre().trim().length()>=20?((beanTablaPersona.getNombre().trim().substring(0, 20))+"..."):beanTablaPersona.getNombre().trim());
        this.txfApePaterno.setText(beanTablaPersona.getApellidoPaterno().trim());
        this.txfApeMaterno.setText(beanTablaPersona.getApellidoMaterno().trim());
        this.txfDireccion.setText(beanTablaPersona.getDireccion() != null ? beanTablaPersona.getDireccion().trim() : "");
        this.jdcFechaNacimiento.setDate(beanTablaPersona.getFechaNacimiento());
        //Recuperar tipo de documento
        if (beanTablaPersona.getTipoDocidentidad() == null) {
            cbxTipoDoc.setSelectedIndex(0);
        } else {
            oTipoDocIdentidadCtrl.recuperaDatosTipoDocumento(beanTablaPersona.getTipoDocidentidad().getIdtipodocidentidad(), cbxTipoDoc);
        }
        if (beanTablaPersona.getNumeroDocumento() != null) {
            this.txfnNumDni.setText(beanTablaPersona.getNumeroDocumento());
        } else {
            this.txfnNumDni.setText("");
        }
        this.txfTelefono.setText(beanTablaPersona.getTelefono());
        this.txfGradoInstruccion.setText(beanTablaPersona.getGradoInstruccion());
        this.txfLugarNacimiento.setText(beanTablaPersona.getLugarNacimiento());
        this.txfLugarProcedencia.setText(beanTablaPersona.getLugarProcedencia());
        if (beanTablaPersona.getSexo() == null || beanTablaPersona.getSexo().equals("")) {
            this.cbxSexo.setSelectedIndex(0);
        } else {
            this.cbxSexo.setSelectedItem(beanTablaPersona.getSexo());
        }
        //Recuperar estado civil
        if (beanTablaPersona.getEstadoCivil() == null) {
            cbxEstadoCivil.setSelectedIndex(0);
        } else {
            oEstadoCivilCtrl.recuperaDatosEstadoCivil(beanTablaPersona.getEstadoCivil().getIdestadocivil(), cbxEstadoCivil);
        }

        if (beanTablaPersona.getAutorizaUsoDatos() == null || beanTablaPersona.getAutorizaUsoDatos().equals("")) {
            this.cbxAutorizaUsoDatos.setSelectedIndex(0);
        } else {
            this.cbxAutorizaUsoDatos.setSelectedItem(beanTablaPersona.getAutorizaUsoDatos());
        }

        /*Listar Ingresos por fecha. que permita conocer el historial de ingresos*/
        listarIngresosPaciente(beanTablaPersona.getIdpersona());
        //Buscar Numero de historia clinica del paciente seleccionado
        obtenerHistoriaClinica(beanTablaPersona);
        //Buscar y cargar los  seguros  con los que  cuenta el paciente
        listarSegurosBD();
        //Listar fondo de prevision registrados en LISSA por ultima fecha de pago
        obtenerFPSLissa(beanTablaPersona);
        //Obtener ultima  cita en estado REG
        obtenerUltimaCita(beanTablaPersona);
    }

    private void configuraNuevo() {
        banBoton = 1;
        tblResultados.setEnabled(true);
        modeloPersonas.clear();
        oModeloFondoPrevision.clear();
        oModeloFondoPrevisionTemp.clear();
        oModeloSeguro.clear();
        oModeloDetalleAtencion.clear();
        oModeloPaciente.clear();
        cbxTipoIngreso.setEnabled(true);
        resetComponent();
        resetPaintComponent();
        estadoTextFields(true);
        activarBotones(false, false, true, true);

    }

    public void paintComponent() {
        Utilitarios.paintCbxVacio(cbxTipoDoc);
        Utilitarios.paintBorderTxfVacio(txfNombres);
        Utilitarios.paintBorderTxfVacio(txfApePaterno);
        Utilitarios.paintBorderTxfVacio(txfApeMaterno);
        Utilitarios.paintBorderTxfVacio(txfnNumDni);
        Utilitarios.paintJdcVacio(jdcFechaNacimiento);
        Utilitarios.paintBorderTxfVacio(txfTelefono);
        Utilitarios.paintBorderTxfVacio(txfDireccion);
    }

    public void resetPaintComponent() {
        Utilitarios.resetPaintCbx(cbxTipoDoc);
        Utilitarios.resetPaintBorderTxf(txfNombres);
        Utilitarios.resetPaintBorderTxf(txfApePaterno);
        Utilitarios.resetPaintBorderTxf(txfApeMaterno);
        Utilitarios.resetPaintBorderTxf(txfnNumDni);
        Utilitarios.resetPaintBorderTxf(txfTelefono);
        Utilitarios.resetPaintJdc(jdcFechaNacimiento);
        Utilitarios.resetPaintBorderTxf(txfDireccion);
    }

    private boolean isDniValido() {
        oBLPersona = new PersonaBl();
        boolean existeDni = false;
        if (oBLPersona.buscarPersonaXDni(txfnNumDni.getText().trim()) != null) {
            existeDni = false;
        } else {
            existeDni = true;
        }
        return existeDni;
    }

    private Persona buscarPersonaXDni() {
        oBLPersona = new PersonaBl();
        return oBLPersona.buscarPersonaXDni(txfnNumDni.getText().trim());
    }

    private void configuraActualizar() {
        banBoton = 2;
        estadoTextFields(true);
        activarBotones(true, false, true, true);
    }

    private Integer ultimoNumAtencion() {
        oPacienteBl = new PacienteBl();
        return oPacienteBl.ultimoNumAtencion() + 1;
    }
    private FondoPrevisionTemp buscarFondoPrevTemp(String dni) {
        oFondoSolidaridadTempBl = new FondoSolidaridadTempBl();
        return oFondoSolidaridadTempBl.buscarXDni(dni);
    }
    private ArrayList<FondoPrevisionTemp> LlenarPagoFondoPrevision(String dni) {
        oFondoSolidaridadTempBl = new FondoSolidaridadTempBl();
        ArrayList<FondoPrevisionTemp> listFondoPrev = oFondoSolidaridadTempBl.buscarBesterpXDni(dni);
        if (!listFondoPrev.isEmpty() && listFondoPrev != null) {
            oModeloFondoPrevisionTemp.addAll(listFondoPrev);
        }
        return listFondoPrev;
    }

    private ArrayList<FondoPrevisionTemp> llenarFondoPrevisionXCodSocio(String codSocio) {
        oFondoSolidaridadTempBl = new FondoSolidaridadTempBl();
        ArrayList<FondoPrevisionTemp> listFondoPrev = oFondoSolidaridadTempBl.buscarBesterpXCodSocio(codSocio);
        if (!listFondoPrev.isEmpty() && listFondoPrev != null) {
            oModeloFondoPrevisionTemp.addAll(listFondoPrev);
        }
        return listFondoPrev;
    }

    private void obtenerDatosFondoPrevTemp() {
        oFondoPrevisionTemp = oModeloFondoPrevisionTemp.get(tblFondoPrevisionTemp.getSelectedRow());
    }

    private void registrarFondoPrev() {
        oFondoSolidaridad = new FondoSolidaridad();
        oFondoSolidaridad.setPersona(beanTablaPersona);
        oFondoSolidaridad.setFechaReg(oFondoPrevisionTemp.getFechaUltimoPago());
        oFondoSolidaridad.setEstado(Boolean.TRUE);
        oFondoSolidaridad.setImporte(oFondoPrevisionTemp.getImportePago());
        oBlFondoPrevision.registrar(oFondoSolidaridad);
        oModeloFondoPrevision.add(oFondoSolidaridad);
    }

    private void llenarCbxTipoDoc() {
        oTipoDocIdentidadBl = new TipoDocIdentidadBl();
        listTipoDocIdentidad = oTipoDocIdentidadBl.listar();
        if (!listTipoDocIdentidad.isEmpty()) {
            cbxTipoDoc.removeAllItems();
            cbxTipoDoc.addItem("<Seleccionar>");
            for (TipoDocidentidad obj : listTipoDocIdentidad) {
                obj.setOp(TipoDocidentidad.DATO);
                cbxTipoDoc.addItem(obj);
            }
        }
    }

    private void llenarCbxEstadoCivil() {
        estadoCivilBl = new EstadoCivilBl();
        listEstadoCivil = estadoCivilBl.listar();
        if (!listEstadoCivil.isEmpty()) {
            cbxEstadoCivil.removeAllItems();
            cbxEstadoCivil.addItem("<Seleccionar>");
            for (EstadoCivil obj : listEstadoCivil) {
                obj.setOp(EstadoCivil.DATO);
                cbxEstadoCivil.addItem(obj);
            }
        }
    }

    private void listarIngresosPaciente(long idPersona) {
        oPacienteBl = new PacienteBl();
        listPaciente = oPacienteBl.listarIngresosPaciente(idPersona);
        if (!listPaciente.isEmpty()) {
            oModeloPaciente.addAll(listPaciente);
        } else {
            oModeloPaciente.clear();
        }
    }

    private void listarServicios(Atencion oPaciente) {
        oItemsComprobanteBl = new ItemsComprobanteBl();
        listItemsComprobante = oItemsComprobanteBl.listarServicios(oPaciente);
        if (!listItemsComprobante.isEmpty()) {
            oModeloDetalleAtencion.addAll(listItemsComprobante);
        } else {
            oModeloDetalleAtencion.clear();
        }
    }

    void resetFullComponent() {
        configuraCancelar();
    }

    private void openJifBuscarPersona() {
        root.jifBuscarPersonaJuridica.setInvocador(JIF_BuscarPersonaJuridica.JIF_ADMISION);
        root.insertarInternalFrames(root.jifBuscarPersonaJuridica);
        root.jifBuscarPersonaJuridica.enviarPanel(this);
    }

    private void insetarAtencionPaciente() {
        oBlPaciente = new PacienteBl();
        if (beanTablaPersona != null) {
            oAtencion = oBlPaciente.buscarPacienteXid(beanTablaPersona.getIdpersona());
            if (oAtencion != null && oAtencion.getEstado().equals("REG")) {
                root.jifEmitirComprobante.cargarDatosUsuario(getUserTemp());
                //
                root.jifEmitirComprobante.EnviarDatosCaja(oCaja);
                root.jifEmitirComprobante.EnviarDatosAtencion(oAtencion);
                root.jifEmitirComprobante.inicializar();
                root.jifEmitirComprobante.enviarDatosPaciente(beanTablaPersona);
                root.insertarInternalFrames(root.jifEmitirComprobante);
            } else {
                JOptionPane.showMessageDialog(null, "Registre un nuevo ingreso", "Atención", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    void cargarDatos(Usuario user, Rol oRol) {
        setUserTemp(user);
        //perTemp = oPersona;
        rolTemp = oRol;
    }

    public Usuario getUserTemp() {
        return userTemp;
    }

    public void setUserTemp(Usuario userTemp) {
        this.userTemp = userTemp;
    }

    void enviarDatosCaja(Caja oCaja) {
        this.oCaja = oCaja;
    }

    private boolean existeFondo() {
        oFondoSolidaridadBl = new FondoPrevisionBl();
        oFondoSolidaridad = oFondoSolidaridadBl.buscarxFecha(oFondoPrevisionTemp, beanTablaPersona);
        if (oFondoSolidaridad != null) {
            return true;
        } else {
            return false;
        }
    }

    void iniciar() {
        llenarCbxSeguro();
        //llenarCbxTipoHc();
        cbxTipoHCBusq = new JComboBox();
        cbxTipohc = new JComboBox();
        oTipoHCCtrl = new TipoHCCtrl(root);
        oTipoHCCtrl.rellenaTipoHC(cbxTipohc);
        oTipoHCCtrl.rellenaTipoHC(cbxTipoHCBusq);
        oTipoHCCtrl.defaultSelectCbx("HISTORIA CLINICA AMBULATORIA", cbxTipohc);
        oTipoHCCtrl.defaultSelectCbx("HISTORIA CLINICA AMBULATORIA", cbxTipoHCBusq);
        //llenarCbxTipoDoc();
        oTipoDocIdentidadCtrl = new TipoDocIdentidadCtrl(root);
        oTipoDocIdentidadCtrl.rellenaTipoDocumento(cbxTipoDoc);
        //llenarCbxEstadoCivil();
        oEstadoCivilCtrl = new EstadoCivilCtrl(root);
        oEstadoCivilCtrl.rellenaEstadoCivil(cbxEstadoCivil);
        //llenarCbxTipoPaciente

        //FormateTabla
        personalizaVistaTabla();
    }

    private void cargarJifAtencion() {
        if (beanTablaPersona != null) {
            if (oCaja != null) {
                insetarAtencionPaciente();
            } else {
                JOptionPane.showMessageDialog(null, "Aperture caja antes realizar cualquier operación", "Atención", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cargue los datos de un persona", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean idDatosValidosIngreso() {
        return (cbxTipoIngreso.getSelectedIndex() > 0
                && cbxTipoPaciente.getSelectedIndex() > 0);
    }

    private void paintDatosIngreso() {
        Utilitarios.paintCbxVacio(cbxTipoIngreso);
        Utilitarios.paintCbxVacio(cbxTipoPaciente);
    }

    private void resetPaintDatosIngreso() {
        Utilitarios.resetPaintCbx(cbxTipoIngreso);
        Utilitarios.resetPaintCbx(cbxTipoPaciente);
    }

    private void obtenerHistoriaClinica(Persona beanTablaPersona) {
        try {
            oBlHistoriaClinica = new HistoriaClinicaBl();
            oHistoriaClinica = oBlHistoriaClinica.buscar(beanTablaPersona, (TipoHistoriaClinica) cbxTipoHCBusq.getSelectedItem());
            if (oHistoriaClinica != null) {
                txfHistoriaClinica.setText(Utilitarios.numberFormat(oHistoriaClinica.getNumerohc(), "######"));
                if (oHistoriaClinica.getTipoHistoriaClinica() == null) {
                    cbxTipohc.setSelectedIndex(0);
                } else {
                    //Recuperar tipo Historia Clinica
                    oTipoHCCtrl.recuperaDatosTipoHC(oHistoriaClinica.getTipoHistoriaClinica().getIdtipohc(), cbxTipohc);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR FATAL " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void obtenerFPSLissa(Persona beanTablaPersona) {
        try {
            oBlFondoPrevision = new FondoPrevisionBl();
            List<FondoSolidaridad> listfs;
            if (beanTablaPersona != null) {
                listfs = oBlFondoPrevision.listarxidPersona(beanTablaPersona.getIdpersona());
                if (!listfs.isEmpty()) {
                    for (FondoSolidaridad obj : listfs) {
                        oModeloFondoPrevision.add(obj);
                    }

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR FATAL " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void estadoDatosIngreso(boolean b) {
        cbxTipoIngreso.setEnabled(b);
        cbxTipoPaciente.setEnabled(b);
    }

    private void obtenerFPS() {
        if (tblFondoPrevision.getRowSelectionAllowed() && tblFondoPrevision.getSelectedRow() != -1) {
            oFondoSolidaridad = oModeloFondoPrevision.get(tblFondoPrevision.getSelectedRow());
            oModeloAtencionesFPS.clear();
            if (oFondoSolidaridad != null) {
                listarAtencionesxFPS(oFondoSolidaridad.getIdFondosolidaridad());
            }
        }
    }

    private void listarAtencionesxFPS(long idFondosolidaridad) {
        oComprobanteDetalleBl = new ItemsComprobanteBl();
        listComprobanteDetalle = oComprobanteDetalleBl.listarAtencionesxFPS(idFondosolidaridad);
        for (ComprobanteDetalle obj : listComprobanteDetalle) {
            oModeloAtencionesFPS.add(obj);
        }
    }

    private void obtenerUltimaCita(Persona beanTablaPersona) {
        oCita = new Cita();
        oCitaBl = new CitaBl();
        txfNumeroCita.setText("");
        txfFechaCita.setText("");
        oCita = oCitaBl.buscarXPersona(beanTablaPersona);
        if (oCita != null) {
            txfFechaCita.setText(Utilitarios.formatFecha(oCita.getFechaCita()));
            txfNumeroCita.setText(oCita.getNumero() + "");
        }
    }

}
