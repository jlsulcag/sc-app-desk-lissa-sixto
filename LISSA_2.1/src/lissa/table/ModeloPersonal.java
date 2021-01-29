
package lissa.table;
import lissa.be.Persona;
import lissa.be.Usuario;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloPersonal extends AbstractTableModel<Usuario>{

    public ModeloPersonal() {
        super.setTitles(new String[]{"ID","Apellidos y Nombres ", "Usuario"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        Usuario bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdUsuario(),"######"); 
            case 1: return bean.getPersona().getApellidoPaterno().trim()+" "+bean.getPersona().getApellidoMaterno().trim()+" "+bean.getPersona().getNombre().trim(); 
            case 2: return bean.getNombre();
            default: return null;
        }
    }
    
}
