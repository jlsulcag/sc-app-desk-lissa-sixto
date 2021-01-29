
package lissa.bl;

import java.util.List;
import lissa.be.TipoMedico;
import lissa.dao.TipoMedicoDao;

public class TipoMedicoBl {
    private TipoMedicoDao dao;
    
    public List<TipoMedico> listar(){
        dao = new TipoMedicoDao();
        return dao.listar();
    }
    
    public TipoMedico buscar(Integer id) {
        dao = new TipoMedicoDao();
        return dao.buscar(id);
    }
}
