
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Kardex;
import lissa.dao.KardexDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class KardexBl extends AbstractBL<Kardex>{
    private KardexDao dao;
    @Override
    public AbstractDA getDAO() {
        dao = new KardexDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (KardexDao) dao;
    }

    @Override
    public Kardex registrar(Kardex bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Kardex bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Kardex bean) {
        return delete(bean);
    }

    @Override
    public List<Kardex> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Kardex> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Kardex> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Kardex buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Kardex buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long generarNumeracion(int grupo) {
        dao = new KardexDao();
        return dao.generarNumeracion(grupo);
    }

    public List<Kardex> listarxProducto(long idalmprod, long idalmacen) {
        dao = new KardexDao();
        return dao.listarxProducto(idalmprod, idalmacen);
    }

    public long nroOrdenregistro(Long idProducto) {
        dao = new KardexDao();
        return dao.nroOrdenregistro(idProducto);
    }
    
}
