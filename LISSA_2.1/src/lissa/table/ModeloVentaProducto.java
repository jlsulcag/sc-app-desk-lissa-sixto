
package lissa.table;

import java.math.BigDecimal;
import lissa.be.DetalleVenta;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloVentaProducto extends AbstractTableModel<DetalleVenta>{
    
    public ModeloVentaProducto() {
        super.setTitles(new String[]{"ID","Cantidad", "Producto y/o descripción", "Laboratorio","Presentación", "P/Venta", "Sub Total"});
    }    
    
    @Override
    public Object getObjectCell(int fil, int col)  {
        DetalleVenta bean = get(fil);
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIddetalleventa(),"######"); 
            case 1: return bean.getCantidadVenta().setScale(0);
            case 2: return bean.getProducto().getNombre();
            case 3: if( bean.getProducto().getLaboratorio()!= null){
                return bean.getProducto().getLaboratorio().getDenominacion();
            }else{return "";}
            case 4: if( bean.getProducto().getPresentacion()!= null){
                return bean.getProducto().getPresentacion().getDenominacion();
            }else{return "";}
            case 5: return bean.getPrecioVenta().setScale(2);
            case 6: return bean.getPrecioVenta().multiply(bean.getCantidadVenta()).setScale(2);
            default: return null;
        }
    }
}
