
package lissa.table;

import lissa.be.FondoPrevisionTemp;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloFondoPrevisionTemp extends AbstractTableModel<FondoPrevisionTemp>{
    public ModeloFondoPrevisionTemp() {
        super.setTitles(new String[]{"ID","Cod Socio", "Importe", "Fecha"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        FondoPrevisionTemp bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdFondoprevtemp(),"######");
            case 1: return bean.getCodSocio();
            case 2: return bean.getImportePago();            
            case 3: return Utilitarios.formatFecha(bean.getFechaUltimoPago());
            default: return null;
        }
    }
}
