
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.PaqueteFondoSolidaridad;
import lissa.util.AbstractDA;

public class PaqueteFSDao extends AbstractDA<PaqueteFondoSolidaridad>{
    
    @Override
    public PaqueteFondoSolidaridad registrar(PaqueteFondoSolidaridad bean) {
        return save(bean);
    }

    @Override
    public int actualizar(PaqueteFondoSolidaridad bean) {
        return update(bean);
    }

    @Override
    public int eliminar(PaqueteFondoSolidaridad bean) {
        return delete(bean);
    }

    @Override
    public List<PaqueteFondoSolidaridad> listar() {
        return list(PaqueteFondoSolidaridad.class);
    }

    @Override
    public ArrayList<PaqueteFondoSolidaridad> listar(String hql) {
        hql = "From PaqueteFondoSolidaridad a order by 1 asc";
        return list(hql);
    }

    @Override
    public List<PaqueteFondoSolidaridad> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PaqueteFondoSolidaridad buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PaqueteFondoSolidaridad buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
