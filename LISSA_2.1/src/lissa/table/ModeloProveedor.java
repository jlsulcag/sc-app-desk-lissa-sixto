
package lissa.table;

import lissa.be.Proveedor;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloProveedor extends AbstractTableModel<Proveedor>{
    
    public ModeloProveedor() {
        super.setTitles(new String[]{"ID", "Razón Social", "N° Ruc"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        Proveedor bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdproveedor(),"######"); 
            case 1: return bean.getPersonaJuridica().getRazonSocial();                    
            case 2: return bean.getPersonaJuridica().getNumeroRuc();
            default: return null;
        }
    }
}
