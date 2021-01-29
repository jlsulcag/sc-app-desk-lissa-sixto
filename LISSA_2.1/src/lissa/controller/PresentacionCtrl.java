
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.Presentacion;
import lissa.bl.PresentacionBl;
import lissa.gui.JF_Principal;

public class PresentacionCtrl {
    private JF_Principal root;
    private PresentacionBl bl;

    public PresentacionCtrl(JF_Principal root) {
        this.root = root;
    }
    
    public void rellenaFamilia(JComboBox cbxi) {
        bl = new PresentacionBl();
        cbxi.removeAllItems();
        ArrayList list = (ArrayList) bl.listar("");
        cbxi.addItem(new Presentacion());
        for (int i = 0; i < list.size(); i++) {
            Presentacion objt = (Presentacion) list.get(i);
            objt.setOp(Presentacion.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    
    public void recuperaDatosCbx(long id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }
    
    private void selectComboGenerico(long id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            Presentacion object = (Presentacion) cbxr.getItemAt(i);
            if (i > 0 && object.getIdpresentacion()== id) {
                //cbxr.setSelectedIndex(i); o
                cbxr.setSelectedItem(object);

            }
        }
    }
}
