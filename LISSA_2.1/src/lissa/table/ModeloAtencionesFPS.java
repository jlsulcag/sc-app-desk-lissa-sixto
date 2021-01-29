package lissa.table;

import lissa.be.ComprobanteDetalle;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloAtencionesFPS extends AbstractTableModel<ComprobanteDetalle>{

    public ModeloAtencionesFPS() {
        super.setTitles(new String[]{"ID", "Fecha", "Procedimiento", "Tipo Ingreso"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        ComprobanteDetalle bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdcomprobantedetalle(),"######"); 
            case 1: return Utilitarios.formatFecha(bean.getComprobante().getFechaComprobante());
            case 2: return bean.getConcepto();
            case 3: return bean.getComprobante().getAtencion().getTipoIngreso();
            default: return null;
        }
    }
    
}
