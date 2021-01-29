
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.Medico;
import lissa.bl.MedicoBl;
import lissa.gui.JF_Principal;

public class MedicoCtrl {
    private JF_Principal root;
    private MedicoBl bl;
    
    public MedicoCtrl(JF_Principal root) {
        this.root = root;
    }
    
    public void rellenaMedico(JComboBox cbxi) {
        bl = new MedicoBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listar();
        cbxi.addItem(new Medico());
        for (int i = 0; i < list.size(); i++) {
            Medico objt = (Medico) list.get(i);
            objt.setOp(Medico.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    public void recuperaDatosMedico(int id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }
    
    private void selectComboGenerico(int id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            Medico object = (Medico) cbxr.getItemAt(i);
            if (i > 0 && object.getIdMedico()== id) {
                //cbxr.setSelectedIndex(i); o
                cbxr.setSelectedItem(object);

            }
        }
    }
}
