
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Caja;
import lissa.be.Usuario;
import lissa.dao.UsuarioDao;

public class UsuarioBl {
    private UsuarioDao dao;
    private ArrayList<Usuario> list;

    public UsuarioBl() {
    }
    
    public Usuario registrar(Usuario obj){
        dao = new UsuarioDao();
        return dao.registrar(obj);
    }

    public Usuario buscarUsuario(String usuario, String clave) {
        dao = new UsuarioDao();
        return dao.buscarUsuario(usuario, clave);
    }

    public int actualizar(Usuario obj) {
        dao = new UsuarioDao();
        return dao.actualizar(obj);
    }
    
    public List<Usuario> buscarxApellidosyNombres(String ref) {
        dao = new UsuarioDao();
        return dao.buscarxApellidosyNombres(ref);
    }
    
    public List<Usuario> buscarxNombreUsuario(String ref) {
        dao = new UsuarioDao();
        return dao.buscarxNombreUsuario(ref);
    }

    public Usuario buscarXIdCaja(Caja oCaja) {
        dao = new  UsuarioDao();
        return dao.buscarXIdCaja(oCaja);
    }

    public Usuario buscarXid(long idUser) {
        dao = new  UsuarioDao();
        return dao.buscarXid(idUser);
    }
}
