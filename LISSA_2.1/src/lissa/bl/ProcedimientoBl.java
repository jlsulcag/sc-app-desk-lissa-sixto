
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Procedimiento;
import lissa.dao.ProcedimientoDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class ProcedimientoBl extends AbstractBL<Procedimiento>{
    private ProcedimientoDao dao;

    @Override
    public AbstractDA getDAO() {
        dao = new ProcedimientoDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (ProcedimientoDao) dao;
    }

    @Override
    public Procedimiento registrar(Procedimiento bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Procedimiento bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Procedimiento bean) {
        return delete(bean);
    }

    @Override
    public List<Procedimiento> listar() {
        return list();
    }

    @Override
    public ArrayList<Procedimiento> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<Procedimiento> listar(long id) {
        return list(id);
    }

    @Override
    public Procedimiento buscar(long id) {
        return search(id);
    }

    @Override
    public Procedimiento buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    
    public List<Procedimiento> listarRef(String ref){
        dao = new ProcedimientoDao();
        return dao.listarRef(ref);
    }

    public List<Procedimiento> listarLaboratorio() {
        dao = new ProcedimientoDao();
        return dao.listarLaboratorio();
    }

    public ArrayList listarTodo() {
        dao = new ProcedimientoDao();
        return dao.listarTodo();
    }

    public ArrayList listarxIdPadre(long idpadre) {
        dao = new ProcedimientoDao();
        return dao.listarxIdPadre(idpadre);
    }
}
