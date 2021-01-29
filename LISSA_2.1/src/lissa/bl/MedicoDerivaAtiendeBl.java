
package lissa.bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lissa.be.MedicoDerivaAtiende;
import lissa.dao.MedicoDerivaAtiendeDao;
import lissa.util.AbstractBL;
import lissa.util.AbstractDA;

public class MedicoDerivaAtiendeBl extends AbstractBL<MedicoDerivaAtiende>{
    private MedicoDerivaAtiendeDao dao;
    @Override
    public AbstractDA getDAO() {
        dao = new MedicoDerivaAtiendeDao();
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (MedicoDerivaAtiendeDao) dao;
    }

    @Override
    public MedicoDerivaAtiende registrar(MedicoDerivaAtiende bean) {
        return save(bean);
    }

    @Override
    public int actualizar(MedicoDerivaAtiende bean) {
        return update(bean);
    }

    @Override
    public int eliminar(MedicoDerivaAtiende bean) {
        return delete(bean);
    }

    @Override
    public List<MedicoDerivaAtiende> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<MedicoDerivaAtiende> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MedicoDerivaAtiende> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MedicoDerivaAtiende buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MedicoDerivaAtiende buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //------------
     public ArrayList<MedicoDerivaAtiende> buscarXMedico(String ref) {
        dao = new MedicoDerivaAtiendeDao();
        return dao.buscarXMedico(ref);
    }

    public ArrayList<MedicoDerivaAtiende> listar(Date date, Date date0, String trim) {
        dao= new MedicoDerivaAtiendeDao();
        return dao.listar(date,date0,trim);
    }

    public List<MedicoDerivaAtiende> listarxRango(Date inicio, Date fin) {
        dao = new MedicoDerivaAtiendeDao();
        return dao.listarxRango(inicio, fin);
    }

    public List<MedicoDerivaAtiende> listarxRangoFechasYMedico(Date inicio, Date fin, int idMedico) {
        dao = new MedicoDerivaAtiendeDao();
        return dao.listarxRango(inicio, fin, idMedico);
    }
}
