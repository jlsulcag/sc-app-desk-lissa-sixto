package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.FondoPrevisionTemp;
import lissa.be.FondoSolidaridad;
import lissa.be.Persona;
import lissa.dao.FondoPrevisionDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class FondoPrevisionBl extends AbstractBL<FondoSolidaridad> {

    private FondoPrevisionDao dao;

    @Override
    public AbstractDA getDAO() {
        dao = new FondoPrevisionDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (FondoPrevisionDao) dao;
    }

    @Override
    public FondoSolidaridad registrar(FondoSolidaridad bean) {
        return  save(bean);
    }

    @Override
    public int actualizar(FondoSolidaridad bean) {
        return update(bean);
    }

    @Override
    public int eliminar(FondoSolidaridad bean) {
        return delete(bean);
    }

    @Override
    public List<FondoSolidaridad> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<FondoSolidaridad> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FondoSolidaridad> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FondoSolidaridad buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FondoSolidaridad buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //    public int registrar(FondoSolidaridad obj) {
//        dao = new FondoPrevisionDao();
//        return dao.registrar(obj);
//    }
    public ArrayList<FondoSolidaridad> listarxidPersona(long id) {
        dao = new FondoPrevisionDao();
        return dao.listarxidPersona(id);
    }

    public FondoSolidaridad buscarXIdSocio(int idSocio) {
        dao = new FondoPrevisionDao();
        return dao.buscarXIdSocio(idSocio);
    }

    public FondoSolidaridad obtenerUltimo(String numeroDocumento) {
        dao = new FondoPrevisionDao();
        return dao.obtenerUltimo(numeroDocumento);
    }

    public FondoSolidaridad buscarxFecha(FondoPrevisionTemp oFondoPrevisionTemp, Persona Opersona) {
        dao = new FondoPrevisionDao();
        return dao.buscarxFecha(oFondoPrevisionTemp, Opersona);
    }
}
