
package lissa.table;

import lissa.be.HistorialAtencionFps;
import lissa.be.Servicio;
import lissa.bl.ServicioBl;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloHistorialFps extends AbstractTableModel<HistorialAtencionFps>{
    public ModeloHistorialFps() {
        super.setTitles(new String[]{"ID", "Fecha de Atención", "Monto Utilizado", "Saldo"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        HistorialAtencionFps bean = get(fil);
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdhistorialatencionfps(),"######");         
            case 1: return Utilitarios.formatFecha(bean.getFechaAtencion());
            case 2: return bean.getMontoUtilizado();
            case 3: return bean.getSaldo();
            default: return null;
        }
    }
}
