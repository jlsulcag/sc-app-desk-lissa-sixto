
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.AreaCaja;
import lissa.bl.AreaCajaBl;
import lissa.gui.JF_Principal;

public class AreaCajaCtrl {
    private JF_Principal root;
    private AreaCajaBl bl;
    
    public AreaCajaCtrl(JF_Principal root) {
        this.root = root;
    }
    public void rellenaCbx(JComboBox cbxi) {
        bl = new AreaCajaBl();
        cbxi.removeAllItems();
        ArrayList list = (ArrayList) bl.listar("");
        cbxi.addItem(new AreaCaja());
        for (int i = 0; i < list.size(); i++) {
            AreaCaja objt = (AreaCaja) list.get(i);
            objt.setOp(AreaCaja.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    
    
}
