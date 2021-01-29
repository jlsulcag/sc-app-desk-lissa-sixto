package lissa.table;

import lissa.be.Medico;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloMedico extends AbstractTableModel<Medico> {

    public ModeloMedico() {
        super.setTitles(new String[]{"ID", "Nombres y Apellidos", "Estado"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        Medico bean = get(fil);
        switch (col) {
            case 0:
                return Utilitarios.numberFormat(bean.getIdMedico(), "######");
            case 1:
                return bean.getPersona().getNombre().trim() + " " + bean.getPersona().getApellidoPaterno().trim() + " " + bean.getPersona().getApellidoMaterno().trim();
            case 2:
                if (bean.getEstado()) {
                    return "ACT";
                }else{
                    return "ANU";
                }
            default:
                return null;
        }
    }

}
