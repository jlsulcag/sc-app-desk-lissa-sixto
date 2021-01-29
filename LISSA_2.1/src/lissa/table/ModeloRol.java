package lissa.table;
import lissa.be.Rol;
import org.rx.cr.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;

public class ModeloRol extends AbstractTableModel<Rol> {

    public ModeloRol() {
        setTitles(new String[]{"ID","Modulo"});
    }

    
    @Override
    public Object getObjectCell(int i, int i1) {
        Rol bean = get(i);        
        switch(i1){
            case 0: return numberFormat(bean.getIdrol(),"####");
            case 1: return bean.getDenominacion();
            default: return null;
        }
    }
    
}
