
package lissa.table;

import lissa.be.Caja;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloCaja extends AbstractTableModel<Caja>{
    
    public ModeloCaja() {
        super.setTitles(new String[]{"ID","Fecha Apertura", "Usuario", "Area", "Estado"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        Caja bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdcaja(),"######"); 
            case 1: return Utilitarios.formatFecha(bean.getFechaApertura())+ " - "+bean.getHoraApertura();
            case 2: return bean.getUsuario().getNombre();
            case 3: return bean.getAreaCaja().getModulo();
            case 4: return bean.getEstado();
            default: return null;
        }
    }
}
