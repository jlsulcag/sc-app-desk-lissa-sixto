
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Egreso;
import lissa.dao.EgresoDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

/**
 *
 * @author JSULCAG
 */
public class EgresoBl extends AbstractBL<Egreso>{
    private EgresoDao dao;

    @Override
    public AbstractDA getDAO() {
        dao = new EgresoDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (EgresoDao) dao;
    }

    @Override
    public Egreso registrar(Egreso bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Egreso bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Egreso bean) {
        return delete(bean);
    }

    @Override
    public List<Egreso> listar() {
        return list();
    }

    @Override
    public ArrayList<Egreso> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<Egreso> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Egreso buscar(long id) {
        return search(id);
    }

    @Override
    public Egreso buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }

    public long numeroSig() {
        dao = new EgresoDao();
        return dao.numeroSig();
    }
    
}
