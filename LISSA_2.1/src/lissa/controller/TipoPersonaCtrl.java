
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.TipoPersona;
import lissa.bl.TipoPersonaBl;
import lissa.gui.JF_Principal;

/**
 *
 * @author JSULCAG
 */
public class TipoPersonaCtrl {
    private JF_Principal root;
    private TipoPersonaBl bl;
    private String defaultAlmacen;
    
    public TipoPersonaCtrl(JF_Principal root) {
        this.root = root;
    }
    
    public void rellenaCbx(JComboBox cbxi) {
        bl = new TipoPersonaBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listar();
        cbxi.addItem(new TipoPersona());
        for (int i = 0; i < list.size(); i++) {
            TipoPersona objt = (TipoPersona) list.get(i);
            objt.setOp(TipoPersona.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    public void recuperaDatosTipoOperacion(int id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }
    
    private void selectComboGenerico(int id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            TipoPersona object = (TipoPersona) cbxr.getItemAt(i);
            if (i > 0 && object.getIdtipopersona()== id) {
                //cbxr.setSelectedIndex(i); o
                cbxr.setSelectedItem(object);

            }
        }
    }
    
    public void defaultSelectCbx(String nombreAlmacen, JComboBox cbxAlmacen) {
        setDefaultAlmacen(nombreAlmacen);
        selectDefaultCbx(cbxAlmacen);
    }
    
    private void selectDefaultCbx(JComboBox cbx) {
        for (int i = 0; i < cbx.getItemCount(); i++) {
            TipoPersona object = (TipoPersona) cbx.getItemAt(i);
            if (i > 0 && object.toString().toLowerCase().trim().equals(getDefaultAlmacen().toLowerCase().trim())) {
                //cbxr.setSelectedIndex(i); o
                cbx.setSelectedItem(object);

            }
        }
    }

    public String getDefaultAlmacen() {
        return defaultAlmacen;
    }

    public void setDefaultAlmacen(String defaultAlmacen) {
        this.defaultAlmacen = defaultAlmacen;
    }

}
