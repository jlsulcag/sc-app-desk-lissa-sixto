package lissa.be;
// Generated 14-abr-2016 18:27:18 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * HistoriaClinica generated by hbm2java
 */
public class HistoriaClinica  implements java.io.Serializable {


     private long idhistoriaclinica;
     private Persona persona;
     private TipoHistoriaClinica tipoHistoriaClinica;
     private Integer numerohc;
     private Date fechaRegistro;
     private int estado;
     private Set<Atencionhc> atencionhcs = new HashSet<Atencionhc>(0);     
     private Set<Atencion> atencions = new HashSet<Atencion>(0); 

    public HistoriaClinica() {
    }

	
    public HistoriaClinica(int idhistoriaclinica, Persona persona) {
        this.idhistoriaclinica = idhistoriaclinica;
        this.persona = persona;
    }
    
   
    public long getIdhistoriaclinica() {
        return this.idhistoriaclinica;
    }
    
    public void setIdhistoriaclinica(long idhistoriaclinica) {
        this.idhistoriaclinica = idhistoriaclinica;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public TipoHistoriaClinica getTipoHistoriaClinica() {
        return this.tipoHistoriaClinica;
    }
    
    public void setTipoHistoriaClinica(TipoHistoriaClinica tipoHistoriaClinica) {
        this.tipoHistoriaClinica = tipoHistoriaClinica;
    }
    public Integer getNumerohc() {
        return this.numerohc;
    }
    
    public void setNumerohc(Integer numerohc) {
        this.numerohc = numerohc;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public Set<Atencionhc> getAtencionhcs() {
        return atencionhcs;
    }

    public void setAtencionhcs(Set<Atencionhc> atencionhcs) {
        this.atencionhcs = atencionhcs;
    }

    public Set<Atencion> getAtencions() {
        return atencions;
    }

    public void setAtencions(Set<Atencion> atencions) {
        this.atencions = atencions;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


}


