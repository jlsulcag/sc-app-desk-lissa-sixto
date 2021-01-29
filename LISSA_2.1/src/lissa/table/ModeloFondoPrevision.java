
package lissa.table;
import lissa.be.FondoSolidaridad;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloFondoPrevision extends AbstractTableModel<FondoSolidaridad>{

    public ModeloFondoPrevision() {
        super.setTitles(new String[]{"ID", "Importe", "Fecha"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        FondoSolidaridad bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdFondosolidaridad(),"######");           
            case 1: return bean.getImporte();            
            case 2: return Utilitarios.formatFecha(bean.getFechaReg());
            default: return null;
        }
    }
    
}
