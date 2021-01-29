
package lissa.table;

import lissa.be.Cie10;
import org.rx.cr.table.AbstractTableModel;

public class ModeloCie10 extends AbstractTableModel<Cie10>{

    public ModeloCie10() {
        super.setTitles(new String[]{"N°","Código", "Descripción"});
    }

    
    @Override
    public Object getObjectCell(int fil, int col)  {
        Cie10 bean = get(fil);        
        switch(col){
            case 0: return bean.getIdCie10();
            case 1: return bean.getCodigo();
            case 2: return bean.getDescripcion();
            default: return null;
        }
    }
    
}
