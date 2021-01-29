
package lissa.table;
import lissa.util.Utilitarios;
import lissa.be.Presentacion;
import org.rx.cr.table.AbstractTableModel;


public class ModeloPresentacion extends AbstractTableModel<Presentacion>{
    public ModeloPresentacion(){
        super.setTitles(new String[]{"ID","Denominacion"});
    }
    @Override
    public Object getObjectCell(int fil, int col) {
        Presentacion bean = get(fil);
        switch(col){
            case 0:return Utilitarios.numberFormat(bean.getIdpresentacion(),"####");
            case 1:return bean.getDenominacion().trim();
            default: return null;
        }
    }
    
}
