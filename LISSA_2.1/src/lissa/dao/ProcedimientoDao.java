
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Procedimiento;
import lissa.util.AbstractDA;

public class ProcedimientoDao extends AbstractDA<Procedimiento>{

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
        return list(Procedimiento.class);
    }

    @Override
    public ArrayList<Procedimiento> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<Procedimiento> listar(long id) {
        throw new UnsupportedOperationException("Metodo no definido");
    }

    @Override
    public Procedimiento buscar(long id) {
        return search(Procedimiento.class, id);
    }

    @Override
    public Procedimiento buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId(Procedimiento.class);
    }

    public List<Procedimiento> listarRef(String ref) {
        String hql = "select a from Procedimiento a left join fetch a.servicio b where (b.denominacion || ' ' || b.denominacion) like '%"+ref+"%'";
        return listar(hql);
    }

    public List<Procedimiento> listarLaboratorio() {
        String hql = "select a from Procedimiento a left join fetch a.servicio b where b.denominacion = 'LABORATORIO'";
        return listar(hql);
    }

    public ArrayList listarTodo() {
        String hql = "select a from Procedimiento a left join fetch a.servicio b";
        return listar(hql);
    }

    public ArrayList listarxIdPadre(long idpadre) {
        String hql = "select a from Procedimiento a left join fetch a.servicio b where b.idservicio = "+idpadre;
        return listar(hql);
    }
    
}
