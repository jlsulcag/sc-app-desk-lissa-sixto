
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.EgresoDetalle;
import lissa.dao.EgresoDetalleDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

/**
 *
 * @author JSULCAG
 */
public class EgresoDetalleBl extends AbstractBL<EgresoDetalle>{
    private EgresoDetalleDao dao;

    @Override
    public AbstractDA getDAO() {
        dao = new EgresoDetalleDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (EgresoDetalleDao) dao;
    }

    @Override
    public EgresoDetalle registrar(EgresoDetalle bean) {
        return save(bean);
    }

    @Override
    public int actualizar(EgresoDetalle bean) {
        return update(bean);
    }

    @Override
    public int eliminar(EgresoDetalle bean) {
        return delete(bean);
    }

    @Override
    public List<EgresoDetalle> listar() {
        return list();
    }

    @Override
    public ArrayList<EgresoDetalle> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<EgresoDetalle> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EgresoDetalle buscar(long id) {
        return search(id);
    }

    @Override
    public EgresoDetalle buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }

    public List<EgresoDetalle> listarxMedico(int idMedico) {
        dao = new EgresoDetalleDao();
        return dao.listarxMedico(idMedico);
    }
    
}
