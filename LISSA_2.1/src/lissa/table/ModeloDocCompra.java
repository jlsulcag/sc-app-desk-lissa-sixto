package lissa.table;

import lissa.be.Compra;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloDocCompra extends AbstractTableModel<Compra> {
    public ModeloDocCompra() {
        super.setTitles(new String[]{"ID", "Proveedor", "Coprobante N°", "Fecha", "Valor Bruto", "IGV", "Descuento", "Valor Total", "Estado"});

    }

    @Override
    public Object getObjectCell(int fil, int col) {
        Compra bean = get(fil);
        switch (col) {
            case 0:
                return Utilitarios.numberFormat(bean.getIdcompra(), "######");
            case 1:
                if (bean.getPersonaProveedor() != null) {
                    return bean.getPersonaProveedor().getRazonSocial().trim();
                } else {
                    return "";
                }

            case 2:
                return bean.getSerie() + " - " + bean.getNumeroComprobante();
            case 3:
                return Utilitarios.formatFecha(bean.getFechaCompra());
            case 4:
                return bean.getValorBruto();

            case 5:
                return bean.getValorIgv();
            case 6:
                return bean.getValorDescuento();
            case 7:
                return bean.getValorTotal();
            case 8:
                return bean.getEstado();
            default:
                return null;
        }
    }
}
