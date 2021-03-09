package lissa.table;

import lissa.be.AlmacenProducto;
import lissa.be.PrecioProducto;
import lissa.bl.PrecioProductoBl;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloBusqProducto extends AbstractTableModel<AlmacenProducto> {
    private PrecioProductoBl oPrecioProductoBl;
    private PrecioProducto oPrecioProducto;

    public ModeloBusqProducto() {
        super.setTitles(new String[]{"ID", "Producto", "Laboratorio", "Stock", "Lote", "Vencimiento", "Precio Venta", "Princ Activo", "Acción Terapéutica"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        AlmacenProducto bean = get(fil);
        switch (col) {
            case 0:
                return Utilitarios.numberFormat(bean.getIdalmacenproducto(), "######");
            case 1:
                return bean.getProducto().getNombre();
            case 2:
                if (bean.getProducto().getLaboratorio() != null) {
                    return bean.getProducto().getLaboratorio().getDenominacion();
                } else {
                    return "";
                }            
            case 3:
                return bean.getStockActual();
            case 4:
                return bean.getLote();
            case 5:
                if (bean.getFechaVencimiento() != null) {
                    return Utilitarios.formatFecha(bean.getFechaVencimiento());
                } else {
                    return "";
                }
            case 6:
                oPrecioProductoBl = new PrecioProductoBl(); 
                oPrecioProducto = new PrecioProducto();
                oPrecioProducto = oPrecioProductoBl.buscarxIdAlmacenProducto(bean.getIdalmacenproducto());
                if(oPrecioProducto != null){
                    return oPrecioProducto.getPvSugerido();
                }else{
                    return "";
                }
            case 7:
                if(bean.getProducto().getPrincipioActivo() != null && !bean.getProducto().getPrincipioActivo().equalsIgnoreCase("")){
                    return bean.getProducto().getPrincipioActivo();
                }else{
                    return "";
                } 
            case 8:
                if(bean.getProducto().getAccionTerapeutica() != null && !bean.getProducto().getAccionTerapeutica().equalsIgnoreCase("")){
                    return bean.getProducto().getAccionTerapeutica();
                }else{
                    return "";
                }
            default:
                return null;
        }
    }
}
