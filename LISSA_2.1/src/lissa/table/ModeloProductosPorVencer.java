
package lissa.table;


import java.util.Date;
import lissa.be.AlmacenProducto;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloProductosPorVencer extends AbstractTableModel<AlmacenProducto>{

    public ModeloProductosPorVencer() {
        super.setTitles(new String[]{"ID","Producto", "Forma Farmaceutica", "Presentación", "Laboratorio", "Almacen", "Stock Actual", "Fecha Vencimiento", "Estado"});
    }    
    
    @Override
    public Object getObjectCell(int fil, int col)  {
        AlmacenProducto bean = get(fil);
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdalmacenproducto(),"######"); 
            case 1: return bean.getProducto().getNombre();
            case 2: return bean.getProducto().getFormaFarmaceutica().getDenominacion();
            case 3: return bean.getProducto().getPresentacion().getDenominacion();
            case 4: return bean.getProducto().getLaboratorio().getDenominacion();
            case 5: return bean.getAlmacen().getNombre();
            case 6: return bean.getStockActual();
            case 7: return Utilitarios.formatFecha(bean.getFechaVencimiento());
            case 8: if (bean.getFechaVencimiento().after(new Date())){
                    return "POR VENCER";
                }else{
                return "VENCIDO";
            }
                
            default: return null;
        }
    }
}
