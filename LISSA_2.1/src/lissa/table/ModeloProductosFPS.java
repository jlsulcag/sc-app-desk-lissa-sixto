
package lissa.table;

import lissa.be.DetalleVenta;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloProductosFPS extends AbstractTableModel<DetalleVenta>{
    
    public ModeloProductosFPS() {
        super.setTitles(new String[]{"ID", "Producto y/o descripción","Cantidad", "P/Venta", "Sub Total"});
    }    
    
    @Override
    public Object getObjectCell(int fil, int col)  {
        DetalleVenta bean = get(fil);
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIddetalleventa(),"######"); 
            case 1: return bean.getProducto().getNombre();
            case 2: return bean.getCantidadVenta();            
            case 3: return bean.getPrecioVenta();
            case 4: return bean.getPrecioVenta().multiply(bean.getCantidadVenta());
            default: return null;
        }
    }
}
