
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.Rol;
import lissa.bl.RolBl;
import lissa.gui.JF_Principal;

public class RolCtrl {
    private JF_Principal root;
    private RolBl bl;
    
    public RolCtrl(JF_Principal root) {
        this.root = root;
    }
    
    public void rellenaRol(JComboBox cbxi) {
        bl = new RolBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listar();
        cbxi.addItem(new Rol());
        for (int i = 0; i < list.size(); i++) {
            Rol objt = (Rol) list.get(i);
            objt.setOp(Rol.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    
    public ArrayList<Rol> rellenaRolxUsuario(JComboBox cbxi, long idUser) {
        bl = new RolBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listarxUsuario(idUser);
        cbxi.addItem(new Rol());
        for (int i = 0; i < list.size(); i++) {
            Rol objt = (Rol) list.get(i);
            objt.setOp(Rol.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);
        return list;
    }
    
    
    public void recuperaDatosEstadoCivil(int id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }
    
    private void selectComboGenerico(int id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            Rol object = (Rol) cbxr.getItemAt(i);
            if (i > 0 && object.getIdrol()== id) {
                //cbxr.setSelectedIndex(i); o
                cbxr.setSelectedItem(object);

            }
        }
    }
}
