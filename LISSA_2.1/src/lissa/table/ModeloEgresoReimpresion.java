/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.table;

import lissa.be.EgresoDetalle;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

/**
 *
 * @author JSULCAG
 */
public class ModeloEgresoReimpresion extends AbstractTableModel<EgresoDetalle>{
    
    public ModeloEgresoReimpresion() {
        super.setTitles(new String[]{"ID","Numero", "Fecha", "Motivo", "Monto"});
    }
    
    @Override
    public Object getObjectCell(int fil, int col)  {
        EgresoDetalle bean = get(fil);        
        switch(col){
            case 0: return bean.getIdegresodetalle();
            case 1: return bean.getEgreso().getNumero();
            case 2: return Utilitarios.formatFecha(bean.getEgreso().getFecha());
            case 3: return bean.getEgreso().getMotivo();
            case 4: return bean.getEgreso().getMonto();
            default: return null;
        }
    }
}
