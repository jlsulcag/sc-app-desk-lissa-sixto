
package lissa.table;

import lissa.be.Comprobante;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloComprobante extends AbstractTableModel<Comprobante>{

    public ModeloComprobante() {
        super.setTitles(new String[]{"Fecha", "Comprobante", "N°", "Paciente", "Importe"});
    }

    
    @Override
    public Object getObjectCell(int fil, int col)  {
        Comprobante bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.formatFecha(bean.getFechaComprobante());                              
            case 1: return bean.getTipoComprobante().getDenominacion();
            case 2: return bean.getNumero(); 
            case 3: return bean.getAtencion().getPersona().getApellidoPaterno() + " " + 
                    bean.getAtencion().getPersona().getApellidoMaterno() + " " + 
                    bean.getAtencion().getPersona().getNombre(); 
            case 4: return bean.getMontoTotal();
            default: return null;
        }
    }
    
}
