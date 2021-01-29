/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Almacen;
import lissa.dao.AlmacenDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

/**
 *
 * @author SISTEMAS
 */
public class AlmacenBl extends AbstractBL<Almacen>{
    private AlmacenDao dao;
    
    @Override
    public AbstractDA getDAO() {
        dao = new AlmacenDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (AlmacenDao) dao;
    }

    @Override
    public Almacen registrar(Almacen bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Almacen bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Almacen bean) {
        return delete(bean);
    }

    @Override
    public List<Almacen> listar() {
        return list();
    }

    @Override
    public ArrayList<Almacen> listar(String hql) {
        dao = new AlmacenDao();
        return dao.listar(hql);
    }

    @Override
    public List<Almacen> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Almacen buscar(long id) {
        return search(id);
    }

    @Override
    public Almacen buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
