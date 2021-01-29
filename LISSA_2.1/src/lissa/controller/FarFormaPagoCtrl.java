
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.FarFormaPago;
import lissa.bl.FarFormaPagoBl;
import lissa.gui.JF_Principal;

public class FarFormaPagoCtrl{
    private FarFormaPagoBl bl;
    private JF_Principal root;
    private String defaulValor;

    public FarFormaPagoCtrl(JF_Principal root) {
        this.root = root;
    }    
    
    public void rellenaCbx(JComboBox cbxi) {
        bl = new FarFormaPagoBl();
        cbxi.removeAllItems();
        ArrayList list = (ArrayList) bl.listar("");
        cbxi.addItem(new FarFormaPago());
        for (int i = 0; i < list.size(); i++) {
            FarFormaPago objt = (FarFormaPago) list.get(i);
            objt.setOp(FarFormaPago.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    
    public void recuperaDatosCbx(int id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }
    
    private void selectComboGenerico(int id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            FarFormaPago object = (FarFormaPago) cbxr.getItemAt(i);
            if (i > 0 && object.getIdformapago()== id) {
                //cbxr.setSelectedIndex(i); o
                cbxr.setSelectedItem(object);

            }
        }
    }
    
    public void defaultSelectValor(String nombre, JComboBox cbx) {
        setDefaulValor(nombre);
        selectDefaultCbx(cbx);
    }
    
    private void selectDefaultCbx(JComboBox cbx) {
        for (int i = 0; i < cbx.getItemCount(); i++) {
            FarFormaPago object = (FarFormaPago) cbx.getItemAt(i);
            if (i > 0 && object.toString().toLowerCase().trim().equals(getDefaulValor().toLowerCase().trim())) {
                //cbxr.setSelectedIndex(i); o
                cbx.setSelectedItem(object);

            }
        }
    }

    public String getDefaulValor() {
        return defaulValor;
    }

    public void setDefaulValor(String defaulValor) {
        this.defaulValor = defaulValor;
    }
}
