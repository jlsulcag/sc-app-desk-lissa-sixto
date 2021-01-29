
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.FondoSolidaridad;
import lissa.be.HistorialAtencionFps;
import lissa.dao.HistorialAtencionFpsDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class HistorialAtencionBl extends AbstractBL<HistorialAtencionFps>{
    private HistorialAtencionFpsDao dao;
    @Override
    public AbstractDA getDAO() {
        dao = new HistorialAtencionFpsDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (HistorialAtencionFpsDao) dao;
    }

    @Override
    public HistorialAtencionFps registrar(HistorialAtencionFps bean) {
        return save(bean);
    }

    @Override
    public int actualizar(HistorialAtencionFps bean) {
        return update(bean);
    }

    @Override
    public int eliminar(HistorialAtencionFps bean) {
        return delete(bean);
    }

    @Override
    public List<HistorialAtencionFps> listar() {
        return list();
    }

    @Override
    public ArrayList<HistorialAtencionFps> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HistorialAtencionFps> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HistorialAtencionFps buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HistorialAtencionFps buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public HistorialAtencionFps buscarUltimoRegistro(FondoSolidaridad obj) {
        dao = new HistorialAtencionFpsDao();
        return dao.buscarUltimoRegistro(obj);
    }
    
}
