package lissa.bl;

import java.util.ArrayList;
import lissa.be.HistoriaClinica;
import lissa.be.Persona;
import lissa.be.TipoHistoriaClinica;
import lissa.dao.HistoriaClinicaDao;

public class HistoriaClinicaBl {

    private HistoriaClinicaDao dao;
    private ArrayList<HistoriaClinica> list;

    public HistoriaClinica registrar(HistoriaClinica obj) {
        dao = new HistoriaClinicaDao();
        return dao.registrar(obj);
    }

    public int generarHC() {
        dao = new HistoriaClinicaDao();
        return dao.generarHC();
    }

    public int generarHCxTipo(TipoHistoriaClinica obj) {
        dao = new HistoriaClinicaDao();
        return dao.generarHCxTipo(obj);
    }

    public HistoriaClinica buscarXdniPersona(String numeroDocumento) {
        dao = new HistoriaClinicaDao();
        return dao.buscarXdniPersona(numeroDocumento);
    }

    public ArrayList<HistoriaClinica> buscar(String ref) {
        dao = new HistoriaClinicaDao();
        list = dao.buscar(ref);
        return list;
    }

    public HistoriaClinica buscarIdPaciente(int idpersona) {
        dao = new HistoriaClinicaDao();
        return dao.buscar(idpersona);
    }

    public HistoriaClinica buscar(Persona per, TipoHistoriaClinica thc) {
        dao = new HistoriaClinicaDao();
        return dao.buscar(per, thc);
    }

    public HistoriaClinica buscar(Persona per) {
        dao = new HistoriaClinicaDao();
        return dao.buscar(per);
    }

    public ArrayList<HistoriaClinica> listar(int idPersona) {
        dao = new HistoriaClinicaDao();
        return dao.listar(idPersona);
    }
}
