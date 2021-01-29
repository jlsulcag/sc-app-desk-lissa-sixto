
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.AreaConsumo;
import lissa.dao.AreaConsumoDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class AreaConsumoBl extends AbstractBL<AreaConsumo>{
    private AreaConsumoDao dao;

    @Override
    public AbstractDA getDAO() {
        dao = new AreaConsumoDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (AreaConsumoDao) dao;
    }

    @Override
    public AreaConsumo registrar(AreaConsumo bean) {
        return save(bean);
    }

    @Override
    public int actualizar(AreaConsumo bean) {
        return update(bean);
    }

    @Override
    public int eliminar(AreaConsumo bean) {
        return delete(bean);
    }

    @Override
    public List<AreaConsumo> listar() {
        return list();
    }

    @Override
    public ArrayList<AreaConsumo> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<AreaConsumo> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AreaConsumo buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AreaConsumo buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
