package lissa.table;
import lissa.be.UsuarioPermiso;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;

public class ModeloPermisoxUsuario extends AbstractTableModel<UsuarioPermiso> {

    public ModeloPermisoxUsuario() {
        setTitles(new String[]{"ID","Codigo", "Descripción", "Fecha Act"});
    }

    
    @Override
    public Object getObjectCell(int i, int i1) {
        UsuarioPermiso bean = get(i);        
        switch(i1){
            case 0: return numberFormat(bean.getIdusuariopermiso(),"####");
            case 1: return bean.getPermiso().getCodigo();
            case 2: return bean.getPermiso().getPermiso().trim().toUpperCase();
            case 3: return Utilitarios.formatFecha(bean.getFechaAct());
            default: return null;
        }
    }
    
}
