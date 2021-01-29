package lissa.table;
import lissa.be.Permiso;
import org.rx.cr.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;

public class ModeloPermiso extends AbstractTableModel<Permiso> {

    public ModeloPermiso() {
        setTitles(new String[]{"ID","Codigo", "Descripción"});
    }

    
    @Override
    public Object getObjectCell(int i, int i1) {
        Permiso bean = get(i);        
        switch(i1){
            case 0: return numberFormat(bean.getIdpermiso(),"####");
            case 1: return bean.getCodigo();
            case 2: return bean.getPermiso().toUpperCase().trim();
            default: return null;
        }
    }
    
}
