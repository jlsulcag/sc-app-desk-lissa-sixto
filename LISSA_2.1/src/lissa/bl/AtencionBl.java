
package lissa.bl;

import java.util.ArrayList;
import lissa.be.Atencionhc;
import lissa.be.HistoriaClinica;
import lissa.dao.AtencionDao;

public class AtencionBl {
    private AtencionDao dao;
    private ArrayList<Atencionhc> list;
    
    public Atencionhc registrar(Atencionhc obj) {
        dao = new AtencionDao();
        return dao.registrar(obj);
    }
    
    public void actualizar(Atencionhc obj) {
        dao = new AtencionDao();
        dao.actualizar(obj);
    }  

//    public Atencion2 buscarUltimaAtencion(int idhistoriaclinica) {
//        dao = new AtencionDao();
//        return dao.buscarUltimaAtencion(idhistoriaclinica);
//    }

    public ArrayList<Atencionhc> listar(HistoriaClinica hc) {
        dao = new AtencionDao();
        return dao.listar(hc);
    }
}
