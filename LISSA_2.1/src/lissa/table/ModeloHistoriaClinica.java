
package lissa.table;
import lissa.be.HistoriaClinica;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloHistoriaClinica extends AbstractTableModel<HistoriaClinica>{

    public ModeloHistoriaClinica() {
        super.setTitles(new String[]{"ID","Apellidos y Nombres ", "N° DNI", "Historia Clínica"});
    }
    @Override
    public Object getObjectCell(int fil, int col)  {
        HistoriaClinica bean = get(fil);        
        switch(col){
            case 0: return Utilitarios.numberFormat(bean.getIdhistoriaclinica(),"######"); 
            case 1: return bean.getPersona().getApellidoPaterno()+" "+bean.getPersona().getApellidoMaterno()+" "+bean.getPersona().getNombre();            
            case 2: return bean.getPersona().getNumeroDocumento();
            case 3: return Utilitarios.numberFormat(bean.getNumerohc(), "######");
            default: return null;
        }
    }
    
}
