package lissa.bl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lissa.be.ProcedimientoTarifario;
import lissa.dao.ProcedimientoTarifarioDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

/**
 *
 * @author JSULCAG
 */
public class ProcedimientoTarifarioBl extends AbstractBL<ProcedimientoTarifario> {

    private ProcedimientoTarifarioDao dao;

    @Override
    public AbstractDA getDAO() {
        dao = new ProcedimientoTarifarioDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (ProcedimientoTarifarioDao) dao;
    }

    @Override
    public ProcedimientoTarifario registrar(ProcedimientoTarifario bean) {
        return save(bean);
    }

    @Override
    public int actualizar(ProcedimientoTarifario bean) {
        return update(bean);
    }

    @Override
    public int eliminar(ProcedimientoTarifario bean) {
        return delete(bean);
    }

    @Override
    public List<ProcedimientoTarifario> listar() {
        return list();
    }

    @Override
    public ArrayList<ProcedimientoTarifario> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<ProcedimientoTarifario> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcedimientoTarifario buscar(long id) {
        return search(id);
    }

    @Override
    public ProcedimientoTarifario buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }

    public List<ProcedimientoTarifario> listarRef(String ref) {
        dao = new ProcedimientoTarifarioDao();
        return dao.listarRef(ref);
    }

    public List<ProcedimientoTarifario> listarRefAct(String ref) {
        dao = new ProcedimientoTarifarioDao();
        return dao.listarRefAct(ref);

    }

    public List<ProcedimientoTarifario> listarFull() {
        dao = new ProcedimientoTarifarioDao();
        return dao.listarFull();
    }

}
