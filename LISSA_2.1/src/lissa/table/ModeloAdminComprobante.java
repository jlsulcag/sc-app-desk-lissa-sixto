
package lissa.table;

import lissa.be.Comprobante;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloAdminComprobante extends AbstractTableModel<Comprobante>{
    public ModeloAdminComprobante() {
        super.setTitles(new String[]{"ID", "Fecha", "Comprobante", "N°", "Importe", "Estado"});
    }

    
    @Override
    public Object getObjectCell(int fil, int col)  {
        Comprobante bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdcomprobante(), "######"); 
            case 1: return Utilitarios.formatFecha(bean.getFechaComprobante()); 
            case 2: return bean.getTipoComprobante().getDenominacion();
            case 3: return bean.getNumero(); 
            case 4: return bean.getMontoTotal();
            case 5: return bean.getEstado().trim();
            default: return null;
        }
    }
}
