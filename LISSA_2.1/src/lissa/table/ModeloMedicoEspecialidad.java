
package lissa.table;

import lissa.be.MedicoEspecialidad;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloMedicoEspecialidad  extends AbstractTableModel<MedicoEspecialidad>{

    public ModeloMedicoEspecialidad() {
        super.setTitles(new String[]{"ID","Especialidad"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        MedicoEspecialidad bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdmedicoespecialidad(),"######"); 
            case 1: return bean.getEspecialidad().getDenominacion().trim();            
            default: return null;
        }
    }
    
}
