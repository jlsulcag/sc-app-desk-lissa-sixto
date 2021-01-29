
package lissa.controller;

import javax.swing.JComboBox;
import java.util.ArrayList;
import lissa.be.Almacen;
import lissa.bl.AlmacenBl;
import lissa.gui.JF_Principal;


public class AlmacenCtrl {
    private JF_Principal root;
    private AlmacenBl bl;
    private String defaultAlmacen;
    
    public AlmacenCtrl(JF_Principal root) {
        this.root = root;
    }
    
    public void rellenaAlmacen(JComboBox cbxi) {
        bl = new AlmacenBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listar("");
        cbxi.addItem(new Almacen());
        for (int i = 0; i < list.size(); i++) {
            Almacen objt = (Almacen) list.get(i);
            objt.setOp(Almacen.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    public void recuperaDatosTipoComprobante(int id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }
    
    private void selectComboGenerico(int id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            Almacen object = (Almacen) cbxr.getItemAt(i);
            if (i > 0 && object.getIdalmacen()== id) {
                //cbxr.setSelectedIndex(i); o
                cbxr.setSelectedItem(object);

            }
        }
    }
    
    public void defaultSelectAlmacen(String nombreAlmacen, JComboBox cbxAlmacen) {
        setDefaultAlmacen(nombreAlmacen);
        selectDefaultCbx(cbxAlmacen);
    }
    
    private void selectDefaultCbx(JComboBox cbx) {
        for (int i = 0; i < cbx.getItemCount(); i++) {
            Almacen object = (Almacen) cbx.getItemAt(i);
            if (i > 0 && object.toString().toLowerCase().trim().equals(getDefaultAlmacen().toLowerCase().trim())) {
                //cbxr.setSelectedIndex(i); o
                cbx.setSelectedItem(object);

            }
        }
    }

    /**
     * @return the defaultAlmacen
     */
    public String getDefaultAlmacen() {
        return defaultAlmacen;
    }

    /**
     * @param defaultAlmacen the defaultAlmacen to set
     */
    public void setDefaultAlmacen(String defaultAlmacen) {
        this.defaultAlmacen = defaultAlmacen;
    }
}
