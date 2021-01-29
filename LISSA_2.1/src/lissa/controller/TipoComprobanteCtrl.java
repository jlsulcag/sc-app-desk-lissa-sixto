package lissa.controller;

import javax.swing.JComboBox;
import java.util.ArrayList;
import lissa.bl.TipoComprobanteBl;
import lissa.gui.JF_Principal;
import lissa.be.TipoComprobante;

public class TipoComprobanteCtrl {

    private JF_Principal root;
    private TipoComprobanteBl bl;
    private String defaultItem;

    public TipoComprobanteCtrl(JF_Principal root) {
        this.root = root;
    }

    public void rellenaTipoComprobante(JComboBox cbxi) {
        bl = new TipoComprobanteBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listarAct();
        cbxi.addItem(new TipoComprobante());
        for (int i = 0; i < list.size(); i++) {
            TipoComprobante objt = (TipoComprobante) list.get(i);
            objt.setOp(TipoComprobante.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }

    public void recuperaDatosTipoComprobante(int id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }

    private void selectComboGenerico(int id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            TipoComprobante object = (TipoComprobante) cbxr.getItemAt(i);
            if (i > 0 && object.getIdtipocomprobante() == id) {
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
            TipoComprobante object = (TipoComprobante) cbx.getItemAt(i);
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
