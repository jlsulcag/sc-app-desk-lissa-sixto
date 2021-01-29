
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Especialidad;
import lissa.be.Medico;
import lissa.be.MedicoEspecialidad;
import lissa.dao.MedicoEspecialidadDao;

public class MedicoEspecialidadBl {
    private MedicoEspecialidadDao dao;

    public MedicoEspecialidadBl() {
    }
    
    public int registrar(MedicoEspecialidad obj){
        dao = new MedicoEspecialidadDao();
        return dao.registrar(obj);
    }
    
     public ArrayList<MedicoEspecialidad> listar(int id) {
        dao = new MedicoEspecialidadDao();
        return dao.listar(id);
    }

    public int eliminar(Especialidad oEspecialidad, Medico oMedico) {
        dao = new MedicoEspecialidadDao();
        return dao.eliminar(oEspecialidad, oMedico);
    }

    public List<MedicoEspecialidad> listarXMedico(int idMedico) {
        dao = new MedicoEspecialidadDao();
        return dao.listarXMedico(idMedico);
    }
}
