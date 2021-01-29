
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.UsuarioPermiso;
import lissa.dao.UsuarioPermisodao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class UsuarioPermisoBl extends AbstractBL<UsuarioPermiso>{
    private UsuarioPermisodao dao;

    @Override
    public AbstractDA getDAO() {
        dao = new UsuarioPermisodao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (UsuarioPermisodao) dao;
    }

    @Override
    public UsuarioPermiso registrar(UsuarioPermiso bean) {
        return save(bean);
    }

    @Override
    public int actualizar(UsuarioPermiso bean) {
        return update(bean);
    }

    @Override
    public int eliminar(UsuarioPermiso bean) {
        return delete(bean);
    }

    @Override
    public List<UsuarioPermiso> listar() {
        return list();
    }

    @Override
    public ArrayList<UsuarioPermiso> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<UsuarioPermiso> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioPermiso buscar(long id) {
        return search(id);
    }

    @Override
    public UsuarioPermiso buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    /*
    public UsuarioPermiso buscarPermiso(long idUsuario, int idpermiso) {
        dao = new UsuarioPermisodao();
        return dao.buscarPermiso(idUsuario, idpermiso);
    }
    */
    public List<UsuarioPermiso> listarPermisosxUsuario(long idUsuario) {
        dao = new UsuarioPermisodao();
        return  dao.listarPermisosxUsuario(idUsuario);
    }

    public UsuarioPermiso buscarUsuarioPermiso(int idpermiso, long idUsuario) {
        dao = new UsuarioPermisodao();
        return  dao.buscarUsuarioPermiso(idpermiso, idUsuario);
    }

    public int quitarPermiso(int idusuariopermiso) {
        dao = new UsuarioPermisodao();
        return  dao.quitarPermiso(idusuariopermiso);
    }
    
} 
