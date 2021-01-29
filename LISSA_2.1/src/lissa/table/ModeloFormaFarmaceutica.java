
package lissa.table;

import lissa.be.FormaFarmaceutica;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;


public class ModeloFormaFarmaceutica extends AbstractTableModel<FormaFarmaceutica>{
    public ModeloFormaFarmaceutica(){
        super.setTitles(new String[]{"ID","Denominacion"});
    }
    @Override
    public Object getObjectCell(int fil, int col) {
        FormaFarmaceutica bean = get(fil);
        switch(col){
            case 0:return Utilitarios.numberFormat(bean.getIdformafarmaceutica(),"####");
            case 1:return bean.getDenominacion().trim();
            default: return null;
        }
    }
    
}
