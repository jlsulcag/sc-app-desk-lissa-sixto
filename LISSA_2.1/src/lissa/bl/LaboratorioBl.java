
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Laboratorio;
import lissa.dao.LaboratorioDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;


public class LaboratorioBl extends AbstractBL<Laboratorio>{
    private LaboratorioDao dao;
   //.....
    //private PresentacionDao daoFamilia;
    private ArrayList<Laboratorio> list;
    //.....
    @Override
    public AbstractDA getDAO() {
        dao = new LaboratorioDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (LaboratorioDao) dao;
    }

    @Override
    public Laboratorio registrar(Laboratorio bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Laboratorio obj) {
        return update(obj);
    }

    @Override
    public int eliminar(Laboratorio bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Laboratorio> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public List<Laboratorio> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Laboratorio buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Laboratorio buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Laboratorio> listar(String hql) {
        dao = new LaboratorioDao();
        return dao.listar(hql);
    }
     ///
     public ArrayList<Laboratorio> buscarF(String ref) {
        dao = new LaboratorioDao();
        list = dao.buscarF(ref);
        return list;
    }
    ///
}
