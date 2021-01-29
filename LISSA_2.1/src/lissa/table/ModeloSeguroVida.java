/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.table;

import lissa.be.SeguroVida;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

/**
 *
 * @author SISTEMAS
 */
public class ModeloSeguroVida extends AbstractTableModel<SeguroVida>{
    public ModeloSeguroVida(){
        super.setTitles(new String[]{"ID","Descripcion","Fecha"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        SeguroVida bean = get(fil);
        switch(col){
            case 0:return Utilitarios.numberFormat(bean.getIdSeguroVida(), "####");
            case 1:return bean.getDescripcion().trim();
            case 2:return Utilitarios.formatFecha(bean.getFechaReg());
            default:return null;
        }
    }
}
