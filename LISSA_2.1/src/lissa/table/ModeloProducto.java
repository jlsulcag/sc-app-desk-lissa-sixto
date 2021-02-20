
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
        super.setTitles(new String[]{"ID","Producto", "Concentracion", "Forma Farmaceutica", "Presentación", "Laboratorio", "Principio Activo", "Accion Terapéutica","Fracción"});
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
            case 6:if(bean.getPrincipioActivo()!=null && !bean.getPrincipioActivo().equalsIgnoreCase("")){
                return bean.getPrincipioActivo();
            }else{
                return "";
            }
            case 7:if(bean.getAccionTerapeutica()!=null && !bean.getAccionTerapeutica().equalsIgnoreCase("")){
                return bean.getAccionTerapeutica();
            }else{
                return "";
            }
            case 8: return bean.getFraccion();
            default: return null;
        }
    }
    
}
