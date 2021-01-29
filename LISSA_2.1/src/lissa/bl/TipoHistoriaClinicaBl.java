
package lissa.bl;

import java.util.ArrayList;
import lissa.be.TipoHistoriaClinica;
import lissa.dao.TipoHistoriaClinicaDao;
import org.hibernate.HibernateException;

public class TipoHistoriaClinicaBl {
    private TipoHistoriaClinicaDao dao;
    
    public ArrayList<TipoHistoriaClinica> listar() throws HibernateException {
        dao = new TipoHistoriaClinicaDao();
        return dao.listar();
    }
}
