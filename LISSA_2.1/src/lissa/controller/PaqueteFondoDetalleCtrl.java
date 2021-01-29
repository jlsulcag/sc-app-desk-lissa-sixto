
package lissa.controller;

import java.util.List;
import javax.swing.JComboBox;
import lissa.be.PaqueteFondoDetalle;
import lissa.bl.PaqueteFondoDetalleBl;
import lissa.gui.JF_Principal;

public class PaqueteFondoDetalleCtrl {
    private JF_Principal root;
    private PaqueteFondoDetalleBl bl;
    private String defaultItem;

    public PaqueteFondoDetalleCtrl(JF_Principal root) {
        this.root = root;
    }

    public void rellenaCbx(JComboBox cbxi, int id) {
        bl = new PaqueteFondoDetalleBl();
        cbxi.removeAllItems();
        List list = bl.listarxIdPaquete(id);
        cbxi.addItem(new PaqueteFondoDetalle());
        for (int i = 0; i < list.size(); i++) {
            PaqueteFondoDetalle objt = (PaqueteFondoDetalle) list.get(i);
            objt.setOp(PaqueteFondoDetalle.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }

    public void recuperaDatosCbx(int id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }

    private void selectComboGenerico(int id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            PaqueteFondoDetalle object = (PaqueteFondoDetalle) cbxr.getItemAt(i);
            if (i > 0 && object.getIdpaquetefondo() == id) {
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
            PaqueteFondoDetalle object = (PaqueteFondoDetalle) cbx.getItemAt(i);
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
