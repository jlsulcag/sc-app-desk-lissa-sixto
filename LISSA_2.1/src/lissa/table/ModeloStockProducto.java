package lissa.table;

import lissa.be.AlmacenProducto;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloStockProducto extends AbstractTableModel<AlmacenProducto> {

    public ModeloStockProducto() {
        super.setTitles(new String[]{"ID", "Descripción producto", "Presentación", "Laboratorio", "Stock Disponible"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        AlmacenProducto bean = get(fil);
        switch (col) {
            case 0:
                return Utilitarios.numberFormat(bean.getProducto().getIdproducto(), "######");
            case 1:
                return bean.getProducto().getNombre();
            case 2:
                if (bean.getProducto().getPresentacion() != null) {
                    return bean.getProducto().getPresentacion().getDenominacion();
                }else{return "";}
            case 3:
                if (bean.getProducto().getLaboratorio() != null) {
                    return bean.getProducto().getLaboratorio().getDenominacion();
                }else{return "";}
            case 4:
                return bean.getStockActual();
            default:
                return null;
        }
    }

}
