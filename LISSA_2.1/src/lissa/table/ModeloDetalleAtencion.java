/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.table;

import lissa.be.ComprobanteDetalle;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

/**
 *
 * @author JSULCAG
 */
public class ModeloDetalleAtencion extends AbstractTableModel<ComprobanteDetalle> {

    public ModeloDetalleAtencion() {
        super.setTitles(new String[]{"ID", "Servicio", "Carta", "Médico"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        ComprobanteDetalle bean = get(fil);
        switch (col) {
            case 0:
                return Utilitarios.numberFormat(bean.getIdcomprobantedetalle(), "######");
            case 1:
                return bean.getConcepto();
            case 2:
                return bean.getComprobante().getNumeroCarta();
            case 3:
                if (bean.getMedicoByIdMedicoAtiende() != null) {
                    return bean.getMedicoByIdMedicoAtiende().getPersona().getApellidoPaterno().trim() + " "
                            + bean.getMedicoByIdMedicoAtiende().getPersona().getApellidoMaterno().trim() + " "
                            + bean.getMedicoByIdMedicoAtiende().getPersona().getNombre().trim();
                } else {
                    return "";
                }
            default:
                return null;
        }
    }
}
