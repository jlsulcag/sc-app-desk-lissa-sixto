package lissa.bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lissa.be.Cita;
import lissa.be.CitaDetalle;
import lissa.be.Medico;
import lissa.be.Persona;
import lissa.dao.CitaDao;
import lissa.table.ModeloCitaDetalle;

public class CitaBl {

    private CitaDao dao;

    public Cita registrar(Cita obj) {
        dao = new CitaDao();
        return dao.registrar(obj);
    }

    public int actualizar(Cita obj) {
        dao = new CitaDao();
        return dao.actualizar(obj);
    }

    public ArrayList<Cita> listar() {
        dao = new CitaDao();
        return dao.listar();
    }

    public ArrayList<Cita> listarPorMedico(Medico medico) {
        dao = new CitaDao();
        return dao.listarPorMedico(medico);
    }

    public ArrayList<Cita> listarPorPacienteFecha(String pac, Date fecha) {
        dao = new CitaDao();
        return dao.listarPorPacienteFecha(pac, fecha);
    }

    public int registrar(Cita oCita, ModeloCitaDetalle oModeloCitaDetalle) {
        dao = new CitaDao();
        return dao.registrar(oCita, oModeloCitaDetalle);
    }

    public List<CitaDetalle> listarxServicioFecha(long idservicio, Date date) {
        dao = new CitaDao();
        return dao.listarxServicioFecha(idservicio, date);
    }

    public List<CitaDetalle> listarxMedicoFecha(int idMedico, Date date) {
        dao = new CitaDao();
        return dao.listarxMedicoFecha(idMedico, date);
    }

    public List<CitaDetalle> listarCitas(Date fecha, int idmedico, long idservicio) {
        dao = new CitaDao();
        return dao.listarCitas(fecha, idmedico, idservicio);
    }

    public Cita buscarXPersona(Persona beanTablaPersona) {
        dao = new CitaDao();
        return dao.buscarXPersona(beanTablaPersona);
    }

    public int maxNumero() {
        dao = new CitaDao();
        return dao.maxNumero();
    }
}
