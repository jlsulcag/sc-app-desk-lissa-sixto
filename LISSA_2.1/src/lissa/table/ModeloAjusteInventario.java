
package lissa.table;

import lissa.be.AlmacenProducto;
import lissa.be.PrecioProducto;
import lissa.bl.PrecioProductoBl;
import org.rx.cr.table.AbstractTableModel;

public class ModeloAjusteInventario extends AbstractTableModel<AlmacenProducto>{
    private PrecioProductoBl oPrecioProductoBl;
    private PrecioProducto oPrecioProducto;
    
    public ModeloAjusteInventario() {
        super.setTitles(new String[]{"ID", "Producto y/o descripción", "Laboratorio", "Presentación", "Stock", "Lote", "Vencimiento", "Precio Venta", "Ubicacion"});
    }
    
    @Override
    public Object getObjectCell(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
