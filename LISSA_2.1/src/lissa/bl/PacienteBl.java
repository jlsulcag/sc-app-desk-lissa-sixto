
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Atencion;
import lissa.dao.PacienteDao;

public class PacienteBl {
    private PacienteDao dao;
    private ArrayList<Atencion> list;
    private List<Atencion> list2;
    
    public long registrar(Atencion obj) {
        dao = new PacienteDao();
        return dao.registrar(obj);
    }
    
    public void actualizar(Atencion obj) {
        dao = new PacienteDao();
        dao.actualizar(obj);
    }
    
    public Atencion buscarPacienteXid(long id) {
        dao = new PacienteDao();
        return dao.buscar(id);
    }
    
    public ArrayList<Atencion> buscarPersonaJuridica(String ref) {
        dao = new PacienteDao();
        list = dao.buscarPersonaJuridica(ref);
        return list;
    }
    
    public List<Atencion> buscarXIdPersona(Integer id) {
        dao = new PacienteDao();
        list2 = dao.buscarXIdPersona(id);
        return list2;
    }

    public Integer ultimoNumAtencion() {
        dao = new PacienteDao();
        return dao.ultimoNumAtencion();
    }

    public ArrayList<Atencion> listarIngresosPaciente(long idPersona) {
        dao = new PacienteDao();
        return dao.listarIngresosPaciente(idPersona);
    }
}
