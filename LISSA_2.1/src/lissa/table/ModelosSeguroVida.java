
package lissa.table;
import lissa.be.Persona;
import lissa.be.SeguroVida;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModelosSeguroVida extends AbstractTableModel<SeguroVida>{

    public ModelosSeguroVida() {
        super.setTitles(new String[]{"ID","Seguro"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        SeguroVida bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdSeguroVida(),"######"); 
            case 1: return bean.getDescripcion();            
            default: return null;
        }
    }
    
}
