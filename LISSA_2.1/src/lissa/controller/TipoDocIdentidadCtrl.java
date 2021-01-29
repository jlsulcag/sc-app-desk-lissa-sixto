
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.TipoDocidentidad;
import lissa.bl.TipoDocIdentidadBl;
import lissa.gui.JF_Principal;

public class TipoDocIdentidadCtrl {
    private JF_Principal root;
    private TipoDocIdentidadBl bl;
    private String defaultSelect;
    
    public TipoDocIdentidadCtrl(JF_Principal root) {
        this.root = root;
    }
    
    public void rellenaTipoDocumento(JComboBox cbxi) {
        bl = new TipoDocIdentidadBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listar();
        cbxi.addItem(new TipoDocidentidad());
        for (int i = 0; i < list.size(); i++) {
            TipoDocidentidad objt = (TipoDocidentidad) list.get(i);
            objt.setOp(TipoDocidentidad.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    public void recuperaDatosTipoDocumento(long id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }
    
    private void selectComboGenerico(long id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            TipoDocidentidad object = (TipoDocidentidad) cbxr.getItemAt(i);
            if (i > 0 && object.getIdtipodocidentidad() == id) {
                //cbxr.setSelectedIndex(i); o
                cbxr.setSelectedItem(object);

            }
        }
    }
    
    public void defaultSelectCbx(String nombre, JComboBox cbx) {
        setDefaultSelect(nombre);
        selectDefaultCbx(cbx);
    }

    private void selectDefaultCbx(JComboBox cbx) {
        for (int i = 0; i < cbx.getItemCount(); i++) {
            TipoDocidentidad object = (TipoDocidentidad) cbx.getItemAt(i);
            if (i > 0 && object.toString().toLowerCase().trim().equals(getDefaultSelect().toLowerCase().trim())) {
                //cbxr.setSelectedIndex(i); o
                cbx.setSelectedItem(object);

            }
        }
    }

    public String getDefaultSelect() {
        return defaultSelect;
    }

    public void setDefaultSelect(String defaultSelect) {
        this.defaultSelect = defaultSelect;
    }
    
    
}
