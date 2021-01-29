
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.FondoSolidaridad;
import lissa.be.PaqueteFondoSolidaridad;
import lissa.be.ServiciosFondoSolidaridad;
import lissa.dao.ServiciosFSDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class ServicioFSBl extends AbstractBL<ServiciosFondoSolidaridad>{
    private ServiciosFSDao dao;
    
    @Override
    public AbstractDA getDAO() {
        dao = new ServiciosFSDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (ServiciosFSDao) dao;
    }

    @Override
    public ServiciosFondoSolidaridad registrar(ServiciosFondoSolidaridad bean) {
        return save(bean);
    }

    @Override
    public int actualizar(ServiciosFondoSolidaridad bean) {
        return update(bean);
    }

    @Override
    public int eliminar(ServiciosFondoSolidaridad bean) {
        return delete(bean);
    }

    @Override
    public List<ServiciosFondoSolidaridad> listar() {
        return list();
    }

    @Override
    public ArrayList<ServiciosFondoSolidaridad> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ServiciosFondoSolidaridad> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ServiciosFondoSolidaridad buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ServiciosFondoSolidaridad buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ServiciosFondoSolidaridad buscarBeneficio(FondoSolidaridad oFondoSolidaridad, PaqueteFondoSolidaridad paqueteFondoSolidaridad) {
        dao = new ServiciosFSDao();
        return dao.buscarBeneficio(oFondoSolidaridad, paqueteFondoSolidaridad);
    }
    
}
