package lissa.be;
// Generated 05/12/2018 11:29:23 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;




/**
 * CitaDetalle generated by hbm2java
 */
public class CitaDetalle  implements java.io.Serializable {


     private long idcitadetalle;
     private Cita cita;
     private ProcedimientoTarifario procedimientoTarifario;
     private Medico medico;
     private BigDecimal costo;

    public CitaDetalle() {
    }
   
    public long getIdcitadetalle() {
        return this.idcitadetalle;
    }
    
    public void setIdcitadetalle(long idcitadetalle) {
        this.idcitadetalle = idcitadetalle;
    }

    public ProcedimientoTarifario getProcedimientoTarifario() {
        return procedimientoTarifario;
    }

    public void setProcedimientoTarifario(ProcedimientoTarifario procedimientoTarifario) {
        this.procedimientoTarifario = procedimientoTarifario;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }
   
}


