
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Cuentaxcobrar;
import lissa.dao.CuentaxcobrarDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class CuentaxcobrarBl extends AbstractBL<Cuentaxcobrar>{
    private CuentaxcobrarDao dao;
    @Override
    public AbstractDA getDAO() {
        dao = new  CuentaxcobrarDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (CuentaxcobrarDao) dao;
    }

    @Override
    public Cuentaxcobrar registrar(Cuentaxcobrar bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Cuentaxcobrar bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Cuentaxcobrar bean) {
        return delete(bean);
    }

    @Override
    public List<Cuentaxcobrar> listar() {
        return list();
    }

    @Override
    public ArrayList<Cuentaxcobrar> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cuentaxcobrar> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cuentaxcobrar buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cuentaxcobrar buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Cuentaxcobrar> listarxCobrar(int idBeneficio) {
        dao = new CuentaxcobrarDao();
        return dao.listarxCobrar(idBeneficio);
    }
    
}
