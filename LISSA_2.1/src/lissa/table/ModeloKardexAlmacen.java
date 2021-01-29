package lissa.table;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lissa.be.AlmacenProducto;
import lissa.be.Kardex;
import lissa.bl.AlmacenProductoBl;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloKardexAlmacen extends AbstractTableModel<Kardex> {

    private AlmacenProductoBl oAlmacenProductoBl;
    private AlmacenProducto oAlmacenProducto;

    public ModeloKardexAlmacen() {
        super.setTitles(new String[]{"Fecha", "Detalle", "Cant", "V. Unit", "V. Total", "Cant", "V. Unit", "V. Total", "Cant", "V. Unit", "V. Total"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        Kardex bean = get(fil);
        oAlmacenProductoBl = new AlmacenProductoBl();
        oAlmacenProducto = new AlmacenProducto();
        oAlmacenProducto = oAlmacenProductoBl.buscarxAlmacen(bean.getIdAlmacenproducto(), bean.getIdAlmacenAfectado());
        switch (col) {
            case 0:
                return Utilitarios.formatFecha(bean.getFechaMov());
            case 1:
                return bean.getOperacion();
            case 2:
                return bean.getTipoOperacion().equals("ENTRADA") ? bean.getCantidad() : "";
            case 3:
                return bean.getTipoOperacion().equals("ENTRADA") ? bean.getValorUnit() : "";
            case 4:
                return bean.getTipoOperacion().equals("ENTRADA") ? bean.getValorUnit().multiply(bean.getCantidad()) : "";

            case 5:
                return bean.getTipoOperacion().equals("SALIDA") ? bean.getCantidad() : "";
            case 6:
                return bean.getTipoOperacion().equals("SALIDA") ? bean.getValorUnit() : "";
            case 7:
                return bean.getTipoOperacion().equals("SALIDA") ? bean.getValorUnit().multiply(bean.getCantidad()) : "";

            case 8:
                return bean.getStockActual();
            case 9:
                return bean.getValorUnit();
            case 10:
                return bean.getValorUnit().multiply(bean.getStockActual()).setScale(2, RoundingMode.HALF_UP);
            default:
                return null;
        }
    }
    /*
     @Override
     public Object getObjectCell(int fil, int col)  {
     Kardex bean = get(fil);
     /*
     switch(col){
     case 0: return Utilitarios.formatFecha(bean.getKardex().getFechaMov()); 
     case 1: return bean.getKardex().getComprobante();
     case 2: return bean.getKardex().getTipoOperacion();
     case 3: return bean.getKardex().getOperacion();
     case 4:if(bean.getKardex().getAlmacenByIdOrigen() != null){
     return bean.getKardex().getAlmacenByIdOrigen().getNombre();
     } else{
     return "-";
     }              
            
     case 5: if(bean.getKardex().getAlmacenByIdDestino()!= null){
     return bean.getKardex().getAlmacenByIdDestino().getNombre();
     }else{
     return "-";
     } 
     case 6: if(bean.getKardex().getAlmacenByIdOrigen() != null && bean.getKardex().getAlmacenByIdDestino() == null){
     return bean.getStockAntOrig();
     }else if(bean.getKardex().getAlmacenByIdDestino() != null && bean.getKardex().getAlmacenByIdOrigen() == null){
     return bean.getStockAnt();
     }else if(bean.getKardex().getAlmacenByIdOrigen() != null && bean.getKardex().getAlmacenByIdDestino() != null){
     if(bean.getKardex().getAlmacenByIdAlmacenAfectado().getNombre().equals("ALMACEN")){
     return bean.getStockAntOrig();
     }else{
     return bean.getStockAnt();
     }
                
     }else if(bean.getKardex().getAlmacenByIdOrigen() == null && bean.getKardex().getAlmacenByIdDestino() == null){
     if(bean.getKardex().getAlmacenByIdAlmacenAfectado().getNombre().equals("ALMACEN")){
     return bean.getStockAntOrig();
     }else{
     return bean.getStockAnt();
     }
     }
     case 7: return bean.getCantidad();            
     case 8: if(bean.getKardex().getAlmacenByIdOrigen() != null && bean.getKardex().getAlmacenByIdDestino() == null){
     return bean.getStockActOrig();
     }else if(bean.getKardex().getAlmacenByIdDestino() != null && bean.getKardex().getAlmacenByIdOrigen() == null){
     return bean.getStockActual();
     }else if(bean.getKardex().getAlmacenByIdOrigen() != null && bean.getKardex().getAlmacenByIdDestino() != null){
     if(bean.getKardex().getAlmacenByIdAlmacenAfectado().getNombre().equals("ALMACEN")){
     return bean.getStockActOrig();
     }else{
     return bean.getStockActual();
     }
                
     }else if(bean.getKardex().getAlmacenByIdOrigen() == null && bean.getKardex().getAlmacenByIdDestino() == null){
     if(bean.getKardex().getAlmacenByIdAlmacenAfectado().getNombre().equals("ALMACEN")){
     return bean.getStockActOrig();
     }else{
     return bean.getStockActual();
     }
     }
                
     default: return null;
                
     return null;
     }
     */
}
