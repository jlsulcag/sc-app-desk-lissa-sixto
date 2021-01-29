/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import lissa.be.Proveedor;
import lissa.bl.ProveedorBl;

import lissa.gui.JF_Principal;

/**
 *
 * @author SISTEMAS
 */
public class ProveedorCtrl {
    private JF_Principal root;
    private ProveedorBl bl;
    
    public ProveedorCtrl(JF_Principal root) {
        this.root = root;
    }
    
    public void Proveedor(JComboBox cbxi) {
        bl = new ProveedorBl();
        cbxi.removeAllItems();
        ArrayList list = bl.listar();
        cbxi.addItem(new Proveedor());
        for (int i = 0; i < list.size(); i++) {
            Proveedor objt = (Proveedor) list.get(i);
            objt.setOp(Proveedor.DATO);
            cbxi.addItem(objt);
        }
        cbxi.setSelectedIndex(0);

    }
    public void recuperaDatosProveedor(int id, JComboBox jcbx) {
        selectComboGenerico(id, jcbx);
    }
    
    private void selectComboGenerico(int id, JComboBox cbxr) {
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            Proveedor object = (Proveedor) cbxr.getItemAt(i);
            if (i > 0 && object.getIdproveedor()== id) {
                //cbxr.setSelectedIndex(i); o
                cbxr.setSelectedItem(object);

            }
        }
    }
}
