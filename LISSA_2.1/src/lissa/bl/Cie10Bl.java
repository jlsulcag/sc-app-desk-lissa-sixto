
package lissa.bl;

import java.util.ArrayList;
import lissa.be.Cie10;
import lissa.dao.Cie10Dao;

public class Cie10Bl {
    private Cie10Dao dao;
    private ArrayList<Cie10> list;
    
    public Cie10 registrar(Cie10 obj) {
        dao = new Cie10Dao();
        return dao.registrar(obj);
    }
    
    public void actualizar(Cie10 obj) {
        dao = new Cie10Dao();
        dao.actualizar(obj);
    }  
    
    public ArrayList<Cie10> buscar(String ref) {
        dao = new Cie10Dao();
        list = dao.buscar(ref);
        return list;
    }

    public Cie10 buscarXid(int idCie10) {
        dao = new Cie10Dao();
        return dao.buscarXid(idCie10);
    }
}
