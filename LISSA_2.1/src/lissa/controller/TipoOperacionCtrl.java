
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.TipoOperacion;
import lissa.bl.TipoOperacionBl;
import lissa.gui.JF_Principal;

public class TipoOperacionCtrl {
    private JF_Principal root;
    private TipoOperacionBl bl;
    private String defaultAlmacen;
    
    public TipoOperacionCtrl(JF_Principal root) {
        this.root = root;
    }
    
    public void rellenaTipoOperacion(JComboBox cbxi) {
        bl = new TipoOperacionBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listar("");
        cbxi.addItem(new TipoOperacion());
        for (int i = 0; i < list.size(); i++) {
            TipoOperacion objt = (TipoOperacion) list.get(i);
            objt.setOp(TipoOperacion.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    public void recuperaDatosTipoOperacion(int id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }
    
    private void selectComboGenerico(int id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            TipoOperacion object = (TipoOperacion) cbxr.getItemAt(i);
            if (i > 0 && object.getIdtipooperacion()== id) {
                //cbxr.setSelectedIndex(i); o
                cbxr.setSelectedItem(object);

            }
        }
    }
    
    public void defaultSelectTipoOperacion(String nombreAlmacen, JComboBox cbxAlmacen) {
        setDefaultAlmacen(nombreAlmacen);
        selectDefaultCbx(cbxAlmacen);
    }
    
    private void selectDefaultCbx(JComboBox cbx) {
        for (int i = 0; i < cbx.getItemCount(); i++) {
            TipoOperacion object = (TipoOperacion) cbx.getItemAt(i);
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
