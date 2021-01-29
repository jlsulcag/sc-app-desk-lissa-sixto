package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.TipoHistoriaClinica;
import lissa.bl.TipoHistoriaClinicaBl;
import lissa.gui.JF_Principal;

public class TipoHCCtrl {

    private JF_Principal root;
    private TipoHistoriaClinicaBl bl;
    private String defaultSelect;

    public TipoHCCtrl(JF_Principal root) {
        this.root = root;
    }

    public void rellenaTipoHC(JComboBox cbxi) {
        bl = new TipoHistoriaClinicaBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listar();
        cbxi.addItem(new TipoHistoriaClinica());
        for (int i = 0; i < list.size(); i++) {
            TipoHistoriaClinica objt = (TipoHistoriaClinica) list.get(i);
            objt.setOp(TipoHistoriaClinica.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }

    public void recuperaDatosTipoHC(int id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }

    private void selectComboGenerico(int id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            TipoHistoriaClinica object = (TipoHistoriaClinica) cbxr.getItemAt(i);
            if (i > 0 && object.getIdtipohc() == id) {
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
            TipoHistoriaClinica object = (TipoHistoriaClinica) cbx.getItemAt(i);
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
