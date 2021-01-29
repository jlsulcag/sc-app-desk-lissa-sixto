
package lissa.table;

import lissa.be.Cita;
import lissa.be.CitaDetalle;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloCita extends AbstractTableModel<CitaDetalle>{
    public ModeloCita() {
        super.setTitles(new String[]{"ID","Fecha", "Hora", "Paciente", "N° Carta", "Convenio", "Estado"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        CitaDetalle bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getCita().getIdcita(),"######"); 
            case 1: return Utilitarios.formatFecha(bean.getCita().getFechaCita());
            case 2: return bean.getCita().getHoraInicio();
            case 3: return bean.getCita().getPersona().getNombre().trim() + " " + bean.getCita().getPersona().getApellidoPaterno().trim() + " " + bean.getCita().getPersona().getApellidoMaterno().trim();
            case 4: return bean.getCita().getNumeroCarta();
            case 5: if(bean.getCita().getBeneficio() != null){
                return bean.getCita().getBeneficio().getNombreBeneficio();
            }else{
                return "";
            }
            case 6: return bean.getCita().getEstado();
            default: return null;
        }
    }
}
