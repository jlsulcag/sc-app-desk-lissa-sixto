
package lissa.bl;

import java.util.ArrayList;
import lissa.be.TipoPersona;
import lissa.dao.TipoPersonaDao;

public class TipoPersonaBl {
    private TipoPersonaDao dao;
    
    public TipoPersona buscarxId(long id){
        dao = new TipoPersonaDao();
        return dao.buscarxId(id);
    }

    public ArrayList<TipoPersona> listar() {
        dao = new TipoPersonaDao();
        return dao.listar();
    }
}
