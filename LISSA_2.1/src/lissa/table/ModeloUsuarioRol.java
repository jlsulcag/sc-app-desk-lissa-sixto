package lissa.table;
import lissa.be.Rol;
import lissa.be.UsuarioRol;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;

public class ModeloUsuarioRol extends AbstractTableModel<UsuarioRol> {

    public ModeloUsuarioRol() {
        setTitles(new String[]{"ID","Modulo", "Fecha Act"});
    }

    
    @Override
    public Object getObjectCell(int i, int i1) {
        UsuarioRol bean = get(i);        
        switch(i1){
            case 0: return numberFormat(bean.getIdUsuarioRol(),"####");
            case 1: return bean.getRol().getDenominacion().trim();
            case 2: return Utilitarios.formatFecha(bean.getFechaReg());
            default: return null;
        }
    }
    
}
