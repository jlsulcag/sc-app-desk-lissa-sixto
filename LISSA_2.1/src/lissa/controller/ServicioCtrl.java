
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.Servicio;
import lissa.bl.ServicioBl;
import lissa.gui.JF_Principal;

public class ServicioCtrl {
    private JF_Principal root;
    private ServicioBl bl;
    private String defaultValue;
    
    public ServicioCtrl(JF_Principal root) {
        this.root = root;
    }
    
    public void rellenaCbx(JComboBox cbxi) {
        bl = new ServicioBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listarTodo();
        cbxi.addItem(new Servicio());
        for (int i = 0; i < list.size(); i++) {
            Servicio objt = (Servicio) list.get(i);
            objt.setOp(Servicio.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    
    public void rellenaCbxXidDependiente(JComboBox cbxi, long idpadre) {
        bl = new ServicioBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listarxIdPadre(idpadre);
        cbxi.addItem(new Servicio());
        for (int i = 0; i < list.size(); i++) {
            Servicio objt = (Servicio) list.get(i);
            objt.setOp(Servicio.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    public void recuperaDatosCbx(long id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }
    
    private void selectComboGenerico(long id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            Servicio object = (Servicio) cbxr.getItemAt(i);
            if (i > 0 && object.getIdservicio()== id) {
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
            Servicio object = (Servicio) cbx.getItemAt(i);
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
