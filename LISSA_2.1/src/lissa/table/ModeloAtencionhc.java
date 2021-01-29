
package lissa.table;

import lissa.be.Atencionhc;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloAtencionhc extends AbstractTableModel<Atencionhc>{
    public ModeloAtencionhc() {
        super.setTitles(new String[]{"ID","Fecha", "Hora"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        Atencionhc bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdatencionhc(),"######"); 
            case 1: return Utilitarios.formatFecha(bean.getFechaAtencion());
            case 2: return bean.getHoraAtencion();
            default: return null;
        }
    }
}
