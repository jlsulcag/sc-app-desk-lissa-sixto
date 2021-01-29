package lissa.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import lissa.be.SeguroVida;
import lissa.bl.SeguroBl;
import lissa.gui.JF_Principal;

public class SeguroCtrl {
    private JF_Principal root;
    private SeguroBl bl;
    private String defaultItem;

    public SeguroCtrl(JF_Principal root) {
        this.root = root;                
    }
    
    public void rellenaCbx(JComboBox cbxi) {
        bl = new SeguroBl();
        cbxi.removeAllItems();
        List list = bl.listar();
        cbxi.addItem(new SeguroVida());
        for (int i = 0; i < list.size(); i++) {
            SeguroVida objt = (SeguroVida) list.get(i);
            objt.setOp(SeguroVida.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    
    public void recuperaDatosCbx(int id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }

    private void selectComboGenerico(int id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            SeguroVida object = (SeguroVida) cbxr.getItemAt(i);
            if (i > 0 && object.getIdSeguroVida() == id) {
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
            SeguroVida object = (SeguroVida) cbx.getItemAt(i);
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
