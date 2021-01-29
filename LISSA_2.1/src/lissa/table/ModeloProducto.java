
package lissa.table;

import lissa.be.Producto;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

/**
 *
 * @author JSULCAG
 */
public class ModeloProducto extends AbstractTableModel<Producto>{

    public ModeloProducto() {
        super.setTitles(new String[]{"ID","Producto", "Concentracion", "Forma Farmaceutica", "Presentación", "Laboratorio", "Fracción"});
    }    
    
    @Override
    public Object getObjectCell(int fil, int col)  {
        Producto bean = get(fil);
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdproducto(),"######"); 
            case 1: return bean.getNombre();
            case 2: return bean.getConcentracion();
            case 3: if(bean.getFormaFarmaceutica() != null){
                return bean.getFormaFarmaceutica().getDenominacion();
            }else{return "";}
            case 4: if(bean.getPresentacion() != null){
                return bean.getPresentacion().getDenominacion();
            }else{return "";}
            case 5: if(bean.getLaboratorio() != null){
                return bean.getLaboratorio().getDenominacion();
            }else{return "";}
            case 6: return bean.getFraccion();
            default: return null;
        }
    }
    
}
