
package lissa.bl;

import java.util.ArrayList;
import lissa.be.EstadoCivil;
import lissa.dao.EstadoCivilDao;
import org.hibernate.HibernateException;

public class EstadoCivilBl {
    private EstadoCivilDao dao;
    
    public ArrayList<EstadoCivil> listar() throws HibernateException {
        dao = new EstadoCivilDao();
        return dao.listar();
    }
}
