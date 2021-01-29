
package lissa.bl;

import java.util.ArrayList;
import lissa.be.FondoPrevisionTemp;
import lissa.dao.FondoSolidaridadTempDao;

public class FondoSolidaridadTempBl {
    private FondoSolidaridadTempDao dao;
    private ArrayList<FondoPrevisionTemp> list;
    
    public FondoPrevisionTemp buscarXDni(String ref) {
        dao = new FondoSolidaridadTempDao();
        return dao.buscarXDni(ref);
    }
    
    public ArrayList<FondoPrevisionTemp> buscarXCodSocio(String ref) {
        dao = new FondoSolidaridadTempDao();
        list = dao.buscarXCodSocio(ref);
        return list;
    }
    
    public ArrayList<FondoPrevisionTemp> buscarXNombres(String ref) {
        dao = new FondoSolidaridadTempDao();
        list = dao.buscarXNombres(ref);
        return list;
    }
    
    public ArrayList<FondoPrevisionTemp> buscarBesterpXDni(String dni) {
        dao = new FondoSolidaridadTempDao();
        return dao.buscarBesterpXDni(dni);
    }

    public ArrayList<FondoPrevisionTemp> buscarBesterpXCodSocio(String codSocio) {
        dao = new FondoSolidaridadTempDao();
        return dao.buscarBesterpXCodSocio(codSocio);
    }
}
