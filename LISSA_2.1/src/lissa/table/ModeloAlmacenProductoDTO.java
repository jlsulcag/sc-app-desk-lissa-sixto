package lissa.table;

import java.math.RoundingMode;
import lissa.be.dto.AlmacenProductoDTO;
import org.rx.cr.table.AbstractTableModel;

/**
 *
 * @author JSULCAG
 */
public class ModeloAlmacenProductoDTO extends AbstractTableModel<AlmacenProductoDTO> {

    public ModeloAlmacenProductoDTO() {
        super.setTitles(new String[]{"Producto", "Almacen", "Stoc Actual", "PC Unit", "PV Unit"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        AlmacenProductoDTO bean = get(fil);
        switch (col) {
            case 0:
                return bean.getProducto().getNombre().trim();
            case 1:
                return bean.getAlmacen().getNombre();
            case 2:
                return bean.getStockActual().setScale(0, RoundingMode.HALF_UP);
            case 3:
                return bean.getPrecioCompraUnit().setScale(2, RoundingMode.HALF_UP);
            case 4:
                return bean.getPrecioVentaUnit().setScale(2, RoundingMode.HALF_UP);           
            default:
                return null;
        }
    }
}
