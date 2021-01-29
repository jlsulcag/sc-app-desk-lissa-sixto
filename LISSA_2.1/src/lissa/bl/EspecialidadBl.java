
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Especialidad;
import lissa.be.Medico;
import lissa.dao.EspecialidadDao;

public class EspecialidadBl {
    private EspecialidadDao dao;
    
    public ArrayList<Especialidad> listar(){
        dao = new EspecialidadDao();
        return dao.listar();
    }
    
    public Especialidad buscar(Integer id) {
        dao = new EspecialidadDao();
        return dao.buscar(id);
    }

    public void listar(Medico oMedico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Especialidad registrar(Especialidad oEspecialidad) {
        dao = new EspecialidadDao();
        return dao.registrar(oEspecialidad);
    }
}
