
package lissa.table;
import lissa.be.Persona;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloPersonas extends AbstractTableModel<Persona>{

    public ModeloPersonas() {
        super.setTitles(new String[]{"ID","Apellidos y Nombres "});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        Persona bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdpersona(),"######"); 
            case 1: return bean.getApellidoPaterno().trim()+" "+bean.getApellidoMaterno().trim()+" "+bean.getNombre().trim();            
            default: return null;
        }
    }
    
}
