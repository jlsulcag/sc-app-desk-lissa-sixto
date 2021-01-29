
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.Laboratorio;
import lissa.bl.LaboratorioBl;
import lissa.gui.JF_Principal;

public class LaboratorioCtrl {
    private LaboratorioBl bl;
    private JF_Principal root;

    public LaboratorioCtrl(JF_Principal root) {
        this.root = root;
    }    
    
    public void rellenaCbx(JComboBox cbxi) {
        bl = new LaboratorioBl();
        cbxi.removeAllItems();
        ArrayList list = (ArrayList) bl.listar("");
        cbxi.addItem(new Laboratorio());
        for (int i = 0; i < list.size(); i++) {
            Laboratorio objt = (Laboratorio) list.get(i);
            objt.setOp(Laboratorio.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    
    public void recuperaDatosCbx(long id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }
    
    private void selectComboGenerico(long id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            Laboratorio object = (Laboratorio) cbxr.getItemAt(i);
            if (i > 0 && object.getIdlaboratorio()== id) {
                //cbxr.setSelectedIndex(i); o
                cbxr.setSelectedItem(object);

            }
        }
    }
}
