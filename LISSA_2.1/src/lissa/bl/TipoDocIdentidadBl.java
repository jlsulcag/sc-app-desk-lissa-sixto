
package lissa.bl;

import java.util.ArrayList;
import lissa.be.TipoDocidentidad;
import lissa.dao.TipoDocIdentidadDao;
import org.hibernate.HibernateException;

public class TipoDocIdentidadBl {
    private TipoDocIdentidadDao dao;
    
    public ArrayList<TipoDocidentidad> listar() throws HibernateException {
        dao = new TipoDocIdentidadDao();
        return dao.listar();
    }
}
