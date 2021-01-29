
package lissa.table;

import lissa.be.Laboratorio;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloLaboratorio extends AbstractTableModel<Laboratorio>{
    public ModeloLaboratorio(){
        super.setTitles(new String[]{"ID","Denominación"});
    }
    @Override
    public Object getObjectCell(int fil, int col) {
        Laboratorio bean =get(fil);
        switch(col){
            case 0:return Utilitarios.numberFormat(bean.getIdlaboratorio(), "####");
            case 1:return bean.getDenominacion().trim();
            default:return null;
        }
    }
    
}
