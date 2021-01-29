
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.HistoriaClinica;
import lissa.be.Medico;
import lissa.be.Persona;
import lissa.be.SeguroVidaUsaPersona;
import lissa.dao.PersonaDao;
import lissa.table.ModeloMedicoEspecialidad;
import lissa.table.ModeloSeguroVida;
import lissa.table.ModelosSeguroVida;
public class PersonaBl {

    private PersonaDao daoPersona;
    private ArrayList<Persona> list;
    private PersonaDao dao;
   
    public Persona registrarPersona(Persona oPersona) {
        PersonaDao oDAOPersona = new PersonaDao();
        return oDAOPersona.registrarPersona(oPersona);
    }    
    
    public ArrayList<Persona> buscar(String ref) {
        daoPersona = new PersonaDao();
        list = daoPersona.buscar(ref);
        return list;
    }

    public Persona buscarPersonaXDni(String numeroDocumento) {
        daoPersona = new PersonaDao();
        return daoPersona.buscarPersonaXDni(numeroDocumento);
    }

    public int actualizar(Persona oPersona) {
        daoPersona = new PersonaDao();
        return daoPersona.actualizar(oPersona);
    }

    public Persona buscarPersonaXid(long id) {
        dao = new PersonaDao();
        return dao.buscar(id);
    }

    public ArrayList<Persona> listar() {
        dao = new PersonaDao();
        return dao.listar();
    }

    public ArrayList<Persona> buscarxNombres(String nombres) {
        dao = new PersonaDao();
        return dao.buscarxNombres(nombres);
    }

    public List<Persona> listarPersonaXDoc(String ref) {
        dao = new PersonaDao();
        return dao.listarPersonaXDoc(ref);
    }
    
    public List<Persona> listarPersonaXNombres(String ref) {
        dao = new PersonaDao();
        return dao.listarPersonaXNombres(ref);
    }

    public Persona buscarPersonaXRuc(String ref) {
        daoPersona = new PersonaDao();
        return daoPersona.buscarPersonaXRuc(ref);
    }

    public int registrarPersonaMedico(Persona oPersona, Medico oMedico, ModeloMedicoEspecialidad oModeloEspecialidad) {
        dao = new PersonaDao();
        return dao.registrarPersonaMedico(oPersona, oMedico, oModeloEspecialidad);
    }

    public int actualizarPersonaMedico(Persona oPersona, Medico oMedico) {
        dao = new PersonaDao();
        return dao.actualizarPersonaMedico(oPersona, oMedico);
    }

    public int actualizar(Persona oPersona, HistoriaClinica oHistoriaClinica, ModelosSeguroVida msv) {
        dao = new PersonaDao();
        return dao.actualizar(oPersona, oHistoriaClinica, msv);
    }

    public int registrar(Persona oPersona, HistoriaClinica oHistoriaClinica, ModelosSeguroVida oModeloSeguro) {
        dao = new PersonaDao();
        return dao.registrar(oPersona, oHistoriaClinica, oModeloSeguro);
    }

}
