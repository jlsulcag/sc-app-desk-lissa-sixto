
package lissa.table;

import lissa.be.Beneficio;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloBeneficio extends AbstractTableModel<Beneficio>{

    public ModeloBeneficio() {
        super.setTitles(new String[]{"ID", "Beneficio", "% Cubierto"});
    }

    
    @Override
    public Object getObjectCell(int fil, int col) {
        Beneficio bean = get(fil);
        switch(col){
            case 0:return Utilitarios.numberFormat(bean.getIdbeneficio(), "####");
            case 1:return bean.getNombreBeneficio().trim();
            case 2:return bean.getPorcCubierto();
            default:return null;
        }
    }
    
}
