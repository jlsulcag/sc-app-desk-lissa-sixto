
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.FarComprobante;
import lissa.bl.FarComprobanteBl;
import lissa.gui.JF_Principal;

/**
 *
 * @author JSULCAG
 */
public class FarComprobanteCtrl {
    private JF_Principal root;
    private FarComprobanteBl bl;
    private String defaultItem;

    public FarComprobanteCtrl(JF_Principal root) {
        this.root = root;
    }

    public void rellenaTipoComprobante(JComboBox cbxi, String ref) {
        bl = new FarComprobanteBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listarxTipo(ref);
        cbxi.addItem(new FarComprobante());
        for (int i = 0; i < list.size(); i++) {
            FarComprobante objt = (FarComprobante) list.get(i);
            objt.setOp(FarComprobante.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }

    public void recuperaDatosTipoComprobante(int id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }

    private void selectComboGenerico(int id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            FarComprobante object = (FarComprobante) cbxr.getItemAt(i);
            if (i > 0 && object.getIdfarcomprobante() == id) {
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
            FarComprobante object = (FarComprobante) cbx.getItemAt(i);
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
