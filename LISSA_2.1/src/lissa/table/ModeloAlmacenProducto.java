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
 * @author jlsulcag
 */
public class ModeloAlmacenProducto extends AbstractTableModel<AlmacenProducto>{
    
    public ModeloAlmacenProducto() {
        super.setTitles(new String[]{"ID","Producto", "Lote", "Concentracion", "Forma Farmaceutica", "Presentación", "Laboratorio", "Fracción"});
    }    

    @Override
    public Object getObjectCell(int fil, int col)  {
        AlmacenProducto bean = get(fil);
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdalmacenproducto(),"######"); 
            case 1: return bean.getProducto().getNombre();
            case 2: return bean.getLote();
            case 3: return bean.getProducto().getConcentracion();
            case 4: if(bean.getProducto().getFormaFarmaceutica() != null){
                return bean.getProducto().getFormaFarmaceutica().getDenominacion();
            }else{return "";}
            case 5: if(bean.getProducto().getPresentacion() != null){
                return bean.getProducto().getPresentacion().getDenominacion();
            }else{return "";}
            case 6: if(bean.getProducto().getLaboratorio() != null){
                return bean.getProducto().getLaboratorio().getDenominacion();
            }else{return "";}
            case 7: return bean.getProducto().getFraccion();
            default: return null;
        }
    }
    
}
