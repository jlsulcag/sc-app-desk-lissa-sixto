
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.Tarifario;
import lissa.bl.TarifarioBl;
import lissa.gui.JF_Principal;

public class TarifarioCtrl {
    private JF_Principal root;
    private TarifarioBl bl;
    private String defaultValue;
    
    public TarifarioCtrl(JF_Principal root) {
        this.root = root;
    }
    
    public void rellenaCbx(JComboBox cbxi) {
        bl = new TarifarioBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listarFull();
        cbxi.addItem(new Tarifario());
        for (int i = 0; i < list.size(); i++) {
            Tarifario objt = (Tarifario) list.get(i);
            objt.setOp(Tarifario.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    public void recuperaDatosCbx(long id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }
    
    private void selectComboGenerico(long id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            Tarifario object = (Tarifario) cbxr.getItemAt(i);
            if (i > 0 && object.getIdtarifario()== id) {
                //cbxr.setSelectedIndex(i); o
                cbxr.setSelectedItem(object);

            }
        }
    }
    
    public void defaultSelectValue(String value, JComboBox cbxAlmacen) {
        setDefaultValue(value);
        selectDefaultCbx(cbxAlmacen);
    }
    
    private void selectDefaultCbx(JComboBox cbx) {
        for (int i = 0; i < cbx.getItemCount(); i++) {
            Tarifario object = (Tarifario) cbx.getItemAt(i);
            if (i > 0 && object.toString().toLowerCase().trim().equals(getDefaultValue().toLowerCase().trim())) {
                //cbxr.setSelectedIndex(i); o
                cbx.setSelectedItem(object);

            }
        }
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
