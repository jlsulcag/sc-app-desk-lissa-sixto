
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.FormaFarmaceutica;
import lissa.dao.FormaFarmaceuticaDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class FormaFarmaceuticaBl extends AbstractBL<FormaFarmaceutica>{
    private FormaFarmaceuticaDao dao;
    private ArrayList<FormaFarmaceutica> list;

    public FormaFarmaceuticaBl() {
    }

    @Override
    public AbstractDA getDAO() {
        dao = new FormaFarmaceuticaDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (FormaFarmaceuticaDao) dao;
    }

    @Override
    public FormaFarmaceutica registrar(FormaFarmaceutica bean) {
        return save(bean);
    }

    @Override
    public int actualizar(FormaFarmaceutica bean) {
        return update(bean);
    }

    @Override
    public int eliminar(FormaFarmaceutica bean) {
        return delete(bean);
    }

    @Override
    public List<FormaFarmaceutica> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<FormaFarmaceutica> listar(String hql) {
        dao = new FormaFarmaceuticaDao();
        return dao.listar(hql);
    }

    @Override
    public List<FormaFarmaceutica> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FormaFarmaceutica buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FormaFarmaceutica buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      ///
     public ArrayList<FormaFarmaceutica> buscarF(String ref) {
        dao = new FormaFarmaceuticaDao();
        list = dao.buscarF(ref);
        return list;
    }
    ///
    
}
