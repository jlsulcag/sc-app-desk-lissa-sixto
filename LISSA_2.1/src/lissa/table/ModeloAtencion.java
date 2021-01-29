
package lissa.table;

import lissa.be.Atencion;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloAtencion extends AbstractTableModel<Atencion>{
    public ModeloAtencion() {
        super.setTitles(new String[]{"ID","N° Ingreso", "Fecha", "Tipo Atencion"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        Atencion bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdatencion(),"######"); 
            case 1: return Utilitarios.numberFormat(bean.getNumeroAtencion(), "######");
            case 2: return Utilitarios.formatFecha(bean.getFechaIngreso());
            case 3: return bean.getTipoIngreso();
            default: return null;
        }
    }
}
