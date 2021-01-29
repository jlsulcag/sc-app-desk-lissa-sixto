
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Tarifario;
import lissa.dao.TarifarioDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class TarifarioBl extends AbstractBL<Tarifario>{

    private TarifarioDao dao;
    
    @Override
    public AbstractDA getDAO() {
        dao = new TarifarioDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (TarifarioDao) dao;
    }

    @Override
    public Tarifario registrar(Tarifario bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Tarifario bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Tarifario bean) {
        return delete(bean);
    }

    @Override
    public List<Tarifario> listar() {
        return list();
    }

    @Override
    public ArrayList<Tarifario> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<Tarifario> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tarifario buscar(long id) {
        return search(id);
    }

    @Override
    public Tarifario buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }

    public ArrayList listarFull() {
        dao = new TarifarioDao();
        return dao.listarFull();
    }
    
}
