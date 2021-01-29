
package lissa.table;
import lissa.be.ComprobanteDetalle;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloConsulta extends AbstractTableModel<ComprobanteDetalle>{

    public ModeloConsulta() {
        super.setTitles(new String[]{"ID", "Fecha", "N° Comprobante", "Consulta"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        ComprobanteDetalle bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdcomprobantedetalle(),"######"); 
            case 1: return bean.getComprobante().getFechaComprobante();                    
            case 2: return Utilitarios.numberFormat(bean.getComprobante().getNumero(), "############");
            case 3: return bean.getProcedimientoTarifario().getProcedimiento().getDenominacion();
            default: return null;
        }
    }
    
}
