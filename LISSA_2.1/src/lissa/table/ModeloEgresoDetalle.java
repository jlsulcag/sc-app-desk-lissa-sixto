
package lissa.table;

import lissa.be.EgresoDetalle;
import org.rx.cr.table.AbstractTableModel;

/**
 *
 * @author JSULCAG
 */
public class ModeloEgresoDetalle extends AbstractTableModel<EgresoDetalle>{
    
    public ModeloEgresoDetalle() {
        super.setTitles(new String[]{"ID","Descripción", "Cantidad", "Importe"});
    }
    
    @Override
    public Object getObjectCell(int fil, int col)  {
        EgresoDetalle bean = get(fil);        
        switch(col){
            case 0: return bean.getIdegresodetalle();
            case 1: return bean.getDescripcion();
            case 2: return bean.getCantidad();
            case 3: return bean.getMonto();
            default: return null;
        }
    }
}
