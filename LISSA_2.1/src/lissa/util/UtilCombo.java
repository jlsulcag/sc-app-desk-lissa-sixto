//package lissa.util;
//
//import java.util.ArrayList;
//import javax.swing.JComboBox;
//import lissa.be.PeEstadoCivil;
//import lissa.be.TipoDocIdentidad;
//import lissa.bl.EstadoCivilBl;
//import lissa.bl.TipoDocIdentidadBl;
//import lissa.gui.JF_Principal;
//
//public class UtilCombo {
//
//    private JF_Principal root;
//    private TipoDocIdentidadBl oTipoDocIdentidadBl;
//    private EstadoCivilBl oEstadoCivilBl;
//
//    public UtilCombo(JF_Principal root) {
//        this.root = root;
//    }
//
//    public void recuperaDatosTipoDocumento(int id, JComboBox jcbx) {
//        selectComboGenerico(id, jcbx);
//    }
//
//    public void recuperaDatosGenero(int id, JComboBox jcbx) {
//        selectComboGenerico(id, jcbx);
//    }
//
//    public void recuperaDatosEstadoCivil(int id, JComboBox jcbx) {
//        selectComboGenerico(id, jcbx);
//    }
//
//    private void selectComboGenerico(int id, JComboBox cbxr) {
//        for (int i = 0; i < cbxr.getItemCount(); i++) {
//            BContenedor object = (BContenedor) cbxr.getItemAt(i);
//            if (i > 0 && object.getId_contenedor() == id) {
//                //cbxr.setSelectedIndex(i); o
//                cbxr.setSelectedItem(object);
//
//            }
//        }
//    }
//
//    public void rellenaTipoDocumento(JComboBox cbxi) {
//        oTipoDocIdentidadBl = new TipoDocIdentidadBl();
//        cbxi.removeAllItems();
//        ArrayList list = oTipoDocIdentidadBl.listar();
//        cbxi.addItem(new TipoDocIdentidad());
//        for (int i = 0; i < list.size(); i++) {
//            TipoDocIdentidad objt = (TipoDocIdentidad) list.get(i);
//            objt.setOp(TipoDocIdentidad.DATO);
//            cbxi.addItem(objt);
//        }
//        cbxi.setSelectedIndex(0);
//
//    }
////    public void rellenaGenero(JComboBox cbxi){
////         
////            cbxi.removeAllItems();                        
////            ArrayList list = daoc.listarGenero();
////            cbxi.addItem(new BContenedor());
////            for (int i = 0; i < list.size(); i++) {
////                BContenedor objt = (BContenedor)list.get(i);
////                objt.setOp(BContenedor.DATO);
////                cbxi.addItem(objt);
////            }
////            cbxi.setSelectedIndex(0);    
////      
////    }
//
//    public void rellenaEstadoCivil(JComboBox cbxi1, JComboBox cbxi2) {
//        cbxi2.removeAllItems();
//        for (int i = 0; i < cbxi1.getItemCount(); i++) {
//            cbxi2.addItem(cbxi1.getItemAt(i));
//        }
//    }
//
//    public void rellenaEstadoCivilVaron(JComboBox cbxi) {
//        oEstadoCivilBl = new EstadoCivilBl();
//        cbxi.removeAllItems();
//        ArrayList list = oEstadoCivilBl.listar();
//        cbxi.addItem(new PeEstadoCivil());
//        for (int i = 0; i < list.size(); i++) {
//            PeEstadoCivil objt = (PeEstadoCivil) list.get(i);
//            objt.setOp(PeEstadoCivil.DATO);
//            cbxi.addItem(objt);
//        }
//        cbxi.setSelectedIndex(0);
//
//    }
////    public void rellenaEstadoCivilMujer(JComboBox cbxi){
////      if (root.getConfig()!=null) {
////        DAOContenedor daoc=null;
////         DSConeccion ds=null;     
////        try {
////            cbxi.removeAllItems();
////            ds = new DSConeccion(root.getConfig());
////            daoc = new DAOContenedor(ds.getConeccion());                         
////            ArrayList list = daoc.listarEstadoCivilMujer();
////            cbxi.addItem(new BContenedor());
////            for (int i = 0; i < list.size(); i++) {
////                BContenedor objt = (BContenedor)list.get(i);
////                objt.setOp(BContenedor.DATO);
////                cbxi.addItem(objt);
////            }
////            cbxi.setSelectedIndex(0);
////            daoc.conectionClose();
////        } catch (SQLException ex) {
////            try {
////                daoc.conectionClose();
////            } catch (SQLException ex1) {
////                Logger.getLogger(UtilContenedor.class.getName()).log(Level.SEVERE, null, ex1);
////            }
////            Logger.getLogger(UtilContenedor.class.getName()).log(Level.SEVERE, null, ex);        
////        }    
////      }        
////    }
////    
////    
////    //////////////////////////////////////////////////////
////    public boolean esVaron(JComboBox cbxi,int id_genero){
////        for (int i = 0; i < cbxi.getItemCount(); i++) {
////            BContenedor objt = (BContenedor)cbxi.getItemAt(i);
////                if (objt.getId_contenedor()==id_genero && objt.getNombre_tabla().toLowerCase().trim().equals("masculino")) {
////                    return true;
////                } 
////        }
////        return false;
////    }
////    public boolean esMujer(JComboBox cbxi,int id_genero){
////        for (int i = 0; i < cbxi.getItemCount(); i++) {
////            BContenedor objt = (BContenedor)cbxi.getItemAt(i);
////                if (objt.getId_contenedor()==id_genero && objt.getNombre_tabla().toLowerCase().trim().equals("femenino")) {
////                    return true;
////                } 
////        }
////        return false;
////    }
//    //////////////////////////////////////////////////////
//
//    private void eventoGenerico(JComboBox cbxi, JTextField txfc) {
//        BContenedor objt = (BContenedor) cbxi.getSelectedItem();
//        if (objt != null && cbxi.getSelectedIndex() > 0) {
//            txfc.setText(Utilitarios.numberFormat(Integer.parseInt(objt.getId_subtabla().trim()), "#"));
//        } else if (cbxi.getSelectedIndex() == 0) {
//            txfc.setText("");
//        }
//    }
//
//    public void eventoTipoDocumento(JComboBox cbxi) {
//        eventoGenerico(cbxi);
//    }
//
//    public void eventoGenero(JComboBox cbxi) {
//        eventoGenerico(cbxi);
//    }
//
//    public void eventoEstadoCivil(JComboBox cbxi) {
//        eventoGenerico(cbxi);
//    }
//
//    public void defaultComboContenedor(String ref, JComboBox cbxi) {
//        for (int i = 0; i < cbxi.getItemCount(); i++) {
//            BContenedor obj = (BContenedor) cbxi.getItemAt(i);
//
//            if (i > 0 && obj.getNombre_tabla().toLowerCase().trim().equals(ref.toLowerCase().trim())) {
//                cbxi.setSelectedIndex(i);
//            }
//        }
//    }
//}
