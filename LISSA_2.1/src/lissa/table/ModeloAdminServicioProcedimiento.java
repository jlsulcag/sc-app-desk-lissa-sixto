/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.table;

import lissa.be.Procedimiento;
import lissa.util.Utilitarios;
import org.rx.cr.gui.table.AbstractTableModel;

/**
 *
 * @author JSULCAG
 */
public class ModeloAdminServicioProcedimiento extends AbstractTableModel<Procedimiento> {

    public ModeloAdminServicioProcedimiento() {
        super.setTitles(new String[]{"ID","Servicio", "Procedimiento"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        Procedimiento bean = get(fil);
        switch (col) {
            case 0:
                return Utilitarios.numberFormat(bean.getIdprocedimiento(), "######");
            case 1:
                return bean.getServicio().getDenominacion();
            case 2:
                return bean.getDenominacion();
            default:
                return null;
        }
    }
}
