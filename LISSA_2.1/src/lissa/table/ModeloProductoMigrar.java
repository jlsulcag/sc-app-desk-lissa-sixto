/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.table;

import lissa.be.Producto;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

/**
 *
 * @author JSULCAG
 */
public class ModeloProductoMigrar extends AbstractTableModel<Producto>{
    public ModeloProductoMigrar() {
        super.setTitles(new String[]{"ID","Producto"});
    }    
    
    @Override
    public Object getObjectCell(int fil, int col)  {
        Producto bean = get(fil);
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdproducto(),"######"); 
            case 1: return bean.getNombre();
            default: return null;
        }
    }
}
