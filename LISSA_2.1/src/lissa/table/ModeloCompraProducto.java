package lissa.table;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lissa.be.DetalleCompra;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

/**
 *
 * @author JSULCAG
 */
public class ModeloCompraProducto extends AbstractTableModel<DetalleCompra> {

    public ModeloCompraProducto() {
        super.setTitles(new String[]{"ID", "Producto", "Cantidad", "Lote", "Fecha Vencimiento", "Valor unitario", "IGV", "Descuento", "Valor de compra"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        DetalleCompra bean = get(fil);
        switch (col) {
            case 0:
                return Utilitarios.numberFormat(bean.getIddetallecompra(), "######");
            case 1:
                return bean.getProducto().getNombre();
            case 2:
                return bean.getCantidad();
            case 3:
                return bean.getLote();
            case 4:
                if (bean.getFechaVencimiento() != null) {
                    return Utilitarios.formatFecha(bean.getFechaVencimiento());
                } else {
                    return "";
                }
            case 5:
                return bean.getValorCompraUnitario().setScale(2, RoundingMode.HALF_UP);
            case 6:
                return bean.getIgvItem().setScale(2, RoundingMode.HALF_UP);
            case 7:
                return bean.getDescuentoItem().setScale(2, RoundingMode.HALF_UP);
            case 8:
                return bean.getPrecioCompra().setScale(2, RoundingMode.HALF_UP);
            default:
                return null;
        }
    }
}
