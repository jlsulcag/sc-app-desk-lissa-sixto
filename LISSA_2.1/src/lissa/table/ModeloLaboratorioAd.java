package lissa.table;

import lissa.be.Procedimiento;
import lissa.util.Utilitarios;
import org.rx.cr.gui.table.AbstractTableModel;

public class ModeloLaboratorioAd extends AbstractTableModel<Procedimiento> {

    public ModeloLaboratorioAd() {
        super.setTitles(new String[]{"ID", "Servicio", "Procedimiento", "Costo", ""});
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
            case 3:
                //return bean.getCosto();
            case 4:
                return bean.isSeleccionado();
            default:
                return null;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 4:
                get(rowIndex).setSeleccionado(Boolean.parseBoolean(aValue.toString()));
                break;
        }
    }
}
