
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.FormaFarmaceutica;
import lissa.bl.FormaFarmaceuticaBl;
import lissa.gui.JF_Principal;

public class FormaFarmaceuticaCtrl {
    private JF_Principal root;
    private FormaFarmaceuticaBl bl;

    public FormaFarmaceuticaCtrl(JF_Principal root) {
        this.root = root;
    }
    
    public void rellenaCbx(JComboBox cbxi) {
        bl = new FormaFarmaceuticaBl();
        cbxi.removeAllItems();
        ArrayList list = (ArrayList) bl.listar("");
        cbxi.addItem(new FormaFarmaceutica());
        for (int i = 0; i < list.size(); i++) {
            FormaFarmaceutica objt = (FormaFarmaceutica) list.get(i);
            objt.setOp(FormaFarmaceutica.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    
    public void recuperaDatosCbx(long id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }
    
    private void selectComboGenerico(long id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            FormaFarmaceutica object = (FormaFarmaceutica) cbxr.getItemAt(i);
            if (i > 0 && object.getIdformafarmaceutica()== id) {
                //cbxr.setSelectedIndex(i); o
                cbxr.setSelectedItem(object);

            }
        }
    }
    
}
