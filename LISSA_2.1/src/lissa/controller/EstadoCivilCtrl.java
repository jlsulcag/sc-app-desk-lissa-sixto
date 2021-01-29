
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.EstadoCivil;
import lissa.bl.EstadoCivilBl;
import lissa.gui.JF_Principal;

public class EstadoCivilCtrl {
    private JF_Principal root;
    private EstadoCivilBl bl;
    
    public EstadoCivilCtrl(JF_Principal root) {
        this.root = root;
    }
    
    public void rellenaEstadoCivil(JComboBox cbxi) {
        bl = new EstadoCivilBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listar();
        cbxi.addItem(new EstadoCivil());
        for (int i = 0; i < list.size(); i++) {
            EstadoCivil objt = (EstadoCivil) list.get(i);
            objt.setOp(EstadoCivil.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    public void recuperaDatosEstadoCivil(long id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }
    
    private void selectComboGenerico(long id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            EstadoCivil object = (EstadoCivil) cbxr.getItemAt(i);
            if (i > 0 && object.getIdestadocivil()== id) {
                //cbxr.setSelectedIndex(i); o
                cbxr.setSelectedItem(object);

            }
        }
    }
}
