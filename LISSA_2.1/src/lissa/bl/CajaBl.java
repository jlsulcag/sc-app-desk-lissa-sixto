
package lissa.bl;

import java.util.ArrayList;
import lissa.be.Caja;
import lissa.be.Rol;
import lissa.be.Usuario;
import lissa.dao.CajaDao;

public class CajaBl {
    private CajaDao dao;
    private ArrayList<Caja> list;
    
    public int registrar(Caja obj) {
        dao = new CajaDao();
        return dao.registrar(obj);
    }
    
    public int actualizar(Caja obj) {
        dao = new CajaDao();
        return dao.actualizar(obj);
    }  

    public ArrayList<Caja> listar() {
        dao = new CajaDao();
        return dao.listar();
    }
    
//    public ArrayList<Caja> listarxUsuario(Usuario user) {
//        dao = new CajaDao();
//        return dao.listarxUsuario(user);
//    }
    
//    public ArrayList<Caja> listarxUsuario(Usuario user) {
//        dao = new CajaDao();
//        return dao.listarxUsuario(user);
//    }

    public Caja buscarPorIdusuario(Usuario user) {
        dao = new CajaDao();
        return dao.buscarPorIdusuario(user);
    }

    public long numCajasAbi() {
        dao = new CajaDao();
        return dao.numCajasAbi();
    }

    public ArrayList<Caja> listarxUsuario(Usuario user, String caja) {
        dao = new CajaDao();
        return dao.listarxUsuario(user ,caja); //To change body of generated methods, choose Tools | Templates.
    }
}
