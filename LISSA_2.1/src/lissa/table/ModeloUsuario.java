
package lissa.table;

import lissa.be.Usuario;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloUsuario extends AbstractTableModel<Usuario>{

    public ModeloUsuario() {
        super.setTitles(new String[]{"ID","Apellidos y Nombres", "Usuario"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        Usuario bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdUsuario(),"######"); 
            case 1: return bean.getPersona().getApellidoPaterno()+" "+bean.getPersona().getApellidoMaterno()+" "+bean.getPersona().getNombre();
            case 2: return bean.getNombre();
            default: return null;
        }
    }
    
}
