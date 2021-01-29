
package lissa.table;
import lissa.be.Persona;
import lissa.be.PersonaJuridica;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloPersonaJuridica extends AbstractTableModel<PersonaJuridica>{

    public ModeloPersonaJuridica() {
        super.setTitles(new String[]{"ID","Razon Social", "RUC"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        PersonaJuridica bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdPersonaJuridica(),"######"); 
            case 1: return bean.getRazonSocial();
            case 2: return bean.getNumeroRuc();            
            default: return null;
        }
    }
    
}
