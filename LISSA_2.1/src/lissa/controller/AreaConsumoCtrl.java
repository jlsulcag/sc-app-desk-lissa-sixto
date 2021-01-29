
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.AreaConsumo;
import lissa.bl.AreaConsumoBl;
import lissa.gui.JF_Principal;

public class AreaConsumoCtrl {
    private JF_Principal root;
    private AreaConsumoBl bl;
    private String defaultValor;

    public AreaConsumoCtrl(JF_Principal root) {
        this.root = root;
    }
    
    public void rellenaAlmacen(JComboBox cbxi) {
        bl = new AreaConsumoBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listar("");
        cbxi.addItem(new AreaConsumo());
        for (int i = 0; i < list.size(); i++) {
            AreaConsumo objt = (AreaConsumo) list.get(i);
            objt.setOp(AreaConsumo.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    public void recuperaDatosTipoComprobante(int id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }
    
    private void selectComboGenerico(int id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            AreaConsumo object = (AreaConsumo) cbxr.getItemAt(i);
            if (i > 0 && object.getIdareaconsumo()== id) {
                //cbxr.setSelectedIndex(i); o
                cbxr.setSelectedItem(object);

            }
        }
    }
    
    public void defaultSelectAlmacen(String nombreAlmacen, JComboBox cbxAlmacen) {
        setDefaultValor(nombreAlmacen);
        selectDefaultCbx(cbxAlmacen);
    }
    
    private void selectDefaultCbx(JComboBox cbx) {
        for (int i = 0; i < cbx.getItemCount(); i++) {
            AreaConsumo object = (AreaConsumo) cbx.getItemAt(i);
            if (i > 0 && object.toString().toLowerCase().trim().equals(getDefaultValor().toLowerCase().trim())) {
                //cbxr.setSelectedIndex(i); o
                cbx.setSelectedItem(object);

            }
        }
    }

    public String getDefaultValor() {
        return defaultValor;
    }

    public void setDefaultValor(String defaultValor) {
        this.defaultValor = defaultValor;
    }
    
}
