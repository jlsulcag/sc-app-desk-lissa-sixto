
package lissa.bl;

import java.util.ArrayList;
import lissa.be.Rol;
import lissa.dao.RolDao;

public class RolBl {
    private RolDao dao;

    public RolBl() {
    }    
    
    public int registrar(Rol obj){
        dao = new RolDao();
        return dao.registrar(obj);
    }
    
    public ArrayList<Rol> listar(){
        dao = new RolDao();
        return dao.listar();
    }
    
    public ArrayList<Rol> listarxUsuario(long idUser){
        dao = new RolDao();
        return dao.listarxUsuario(idUser);
    }
    
    public Rol buscarId(int id) {
        dao = new RolDao();
        return dao.buscarId(id);
    }
}
