/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.table;

import lissa.be.AlmacenProducto;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

/**
 *
 * @author JSULCAG
 */
public class ModeloProductosVencidos extends AbstractTableModel<AlmacenProducto>{
    public ModeloProductosVencidos() {
        super.setTitles(new String[]{"ID","Producto", "Forma Farmaceutica", "Presentación", "Laboratorio", "Almacen", "Stock Actual", "Fecha Vencimiento"});
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
            default: return null;
        }
    }
}
