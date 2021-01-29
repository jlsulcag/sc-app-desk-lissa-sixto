
package lissa.controller;

import java.util.List;
import javax.swing.JComboBox;
import lissa.be.PaqueteFondoSolidaridad;
import lissa.bl.PaqueteFSBl;
import lissa.gui.JF_Principal;

public class PaqueteFSCtrl {
    private JF_Principal root;
    private PaqueteFSBl bl;
    private String defaultItem;

    public PaqueteFSCtrl(JF_Principal root) {
        this.root = root;
    }

    public void rellenaCbx(JComboBox cbxi) {
        bl = new PaqueteFSBl();
        cbxi.removeAllItems();
        List list = bl.list("");
        cbxi.addItem(new PaqueteFondoSolidaridad());
        for (int i = 0; i < list.size(); i++) {
            PaqueteFondoSolidaridad objt = (PaqueteFondoSolidaridad) list.get(i);
            objt.setOp(PaqueteFondoSolidaridad.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }

    public void recuperaDatosCbx(int id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }

    private void selectComboGenerico(int id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            PaqueteFondoSolidaridad object = (PaqueteFondoSolidaridad) cbxr.getItemAt(i);
            if (i > 0 && object.getIdpaquetefs() == id) {
                //cbxr.setSelectedIndex(i); o
                cbxr.setSelectedItem(object);

            }
        }
    }

    public void defaultSelectCbx(String nombre, JComboBox cbx) {
        setDefaultItem(nombre);
        selectDefaultCbx(cbx);
    }

    private void selectDefaultCbx(JComboBox cbx) {
        for (int i = 0; i < cbx.getItemCount(); i++) {
            PaqueteFondoSolidaridad object = (PaqueteFondoSolidaridad) cbx.getItemAt(i);
            if (i > 0 && object.toString().toLowerCase().trim().equals(getDefaultItem().toLowerCase().trim())) {
                //cbxr.setSelectedIndex(i); o
                cbx.setSelectedItem(object);

            }
        }
    }

    public String getDefaultItem() {
        return defaultItem;
    }

    public void setDefaultItem(String defaultItem) {
        this.defaultItem = defaultItem;
    }
}
