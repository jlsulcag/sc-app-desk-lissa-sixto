
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.FarComprobante;
import lissa.dao.FarComprobanteDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

/**
 *
 * @author JSULCAG
 */
public class FarComprobanteBl extends AbstractBL<FarComprobante>{
    FarComprobanteDao dao;

    @Override
    public AbstractDA getDAO() {
        dao = new FarComprobanteDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (FarComprobanteDao) dao;
    }

    @Override
    public FarComprobante registrar(FarComprobante bean) {
        return save(bean);
    }

    @Override
    public int actualizar(FarComprobante bean) {
        return update(bean);
    }

    @Override
    public int eliminar(FarComprobante bean) {
        return delete(bean);
    }

    @Override
    public List<FarComprobante> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<FarComprobante> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FarComprobante> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FarComprobante buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FarComprobante buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<FarComprobante> listarxTipo(String ref){
        dao = new FarComprobanteDao();
        return dao.listarxTipo(ref);
    }
    
}
