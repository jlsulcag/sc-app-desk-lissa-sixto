package lissa.controller;

import java.util.List;
import javax.swing.JComboBox;
import lissa.be.Beneficio;
import lissa.bl.BeneficioBl;
import lissa.gui.JF_Principal;

public class BeneficioCtrl {

    private JF_Principal root;
    private BeneficioBl bl;
    private String defaultItem;

    public BeneficioCtrl(JF_Principal root) {
        this.root = root;
    }

    public void rellenaCbx(JComboBox cbxi, int id) {
        bl = new BeneficioBl();
        cbxi.removeAllItems();
        List list = bl.buscarXIdSeguro(id);
        cbxi.addItem(new Beneficio());
        for (int i = 0; i < list.size(); i++) {
            Beneficio objt = (Beneficio) list.get(i);
            objt.setOp(Beneficio.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }

    public void recuperaDatosCbx(int id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }

    private void selectComboGenerico(int id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            Beneficio object = (Beneficio) cbxr.getItemAt(i);
            if (i > 0 && object.getIdbeneficio() == id) {
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
            Beneficio object = (Beneficio) cbx.getItemAt(i);
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
