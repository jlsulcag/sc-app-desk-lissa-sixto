package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Beneficio;
import lissa.dao.BeneficioDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class BeneficioBl extends AbstractBL<Beneficio>{

    private BeneficioDao dao;

    public List<Beneficio> buscarXIdSeguro(Integer id) {
        dao = new BeneficioDao();
        return dao.buscarXIdSeguro(id);
    }

    @Override
    public AbstractDA getDAO() {
        dao = new BeneficioDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (BeneficioDao) dao;
    }

    @Override
    public Beneficio registrar(Beneficio bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Beneficio bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Beneficio bean) {
        return delete(bean);
    }

    @Override
    public List<Beneficio> listar() {
        return list();
    }

    @Override
    public ArrayList<Beneficio> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<Beneficio> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Beneficio buscar(long id) {
        return search(id);
    }

    @Override
    public Beneficio buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
