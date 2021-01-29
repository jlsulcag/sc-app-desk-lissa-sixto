package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.TipoComprobante;
import lissa.dao.TipoComprobanteDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

/**
 *
 * @author Jorge Luis Sulca González
 */
public class TipoComprobanteBl extends AbstractBL<TipoComprobante>{
    private TipoComprobanteDao dao;

    @Override
    public AbstractDA getDAO() {
        dao = new TipoComprobanteDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (TipoComprobanteDao) dao;
    }

    @Override
    public TipoComprobante registrar(TipoComprobante bean) {
        return save(bean);
    }

    @Override
    public int actualizar(TipoComprobante bean) {
        return update(bean);
    }

    @Override
    public int eliminar(TipoComprobante bean) {
        return delete(bean);
    }

    @Override
    public List<TipoComprobante> listar() {
        return list();
    }

    @Override
    public ArrayList<TipoComprobante> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<TipoComprobante> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoComprobante buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoComprobante buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList listarAct() {
        dao = new TipoComprobanteDao();
        return dao.listarAct();
    }
    
}
