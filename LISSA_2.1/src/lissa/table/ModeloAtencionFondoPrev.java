
package lissa.table;

import lissa.be.Comprobante;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloAtencionFondoPrev extends AbstractTableModel<Comprobante>{
    public ModeloAtencionFondoPrev() {
        super.setTitles(new String[]{"ID","Fecha", "Paciente", "Cajero"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        Comprobante bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdcomprobante(),"######"); 
            case 1: return Utilitarios.formatFecha(bean.getFechaComprobante());
            case 2: return bean.getAtencion().getPersona().getNombre();
            case 3: return bean.getCaja().getUsuario().getNombre();
            //case 4: return bean.getBeneficio().getNombreBeneficio();
            default: return null;
        }
    }
}
