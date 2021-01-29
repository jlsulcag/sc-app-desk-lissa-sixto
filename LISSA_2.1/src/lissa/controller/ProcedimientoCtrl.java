
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.Procedimiento;
import lissa.bl.ProcedimientoBl;
import lissa.bl.ServicioBl;
import lissa.gui.JF_Principal;

public class ProcedimientoCtrl {
    private JF_Principal root;
    private ProcedimientoBl bl;
    private String defaultValue;
    
    public ProcedimientoCtrl(JF_Principal root) {
        this.root = root;
    }
    
    public void rellenaCbx(JComboBox cbxi) {
        bl = new ProcedimientoBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listarTodo();
        cbxi.addItem(new Procedimiento());
        for (int i = 0; i < list.size(); i++) {
            Procedimiento objt = (Procedimiento) list.get(i);
            objt.setOp(Procedimiento.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    
    public void rellenaCbxXidDependiente(JComboBox cbxi, long idpadre) {
        bl = new ProcedimientoBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listarxIdPadre(idpadre);
        cbxi.addItem(new Procedimiento());
        for (int i = 0; i < list.size(); i++) {
            Procedimiento objt = (Procedimiento) list.get(i);
            objt.setOp(Procedimiento.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    public void recuperaDatosCbx(long id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }
    
    private void selectComboGenerico(long id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            Procedimiento object = (Procedimiento) cbxr.getItemAt(i);
            if (i > 0 && object.getIdprocedimiento()== id) {
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
            Procedimiento object = (Procedimiento) cbx.getItemAt(i);
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
