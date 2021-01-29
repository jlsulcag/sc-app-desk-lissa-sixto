package lissa.be;
// Generated 14-abr-2016 18:27:18 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SeguroVida generated by hbm2java
 */
public class SeguroVida implements java.io.Serializable {

    private int idSeguroVida;
    private String descripcion;
    private Date fechaReg;
    private Boolean estado;
    private int esconvenio;
    private int tieneCarta;
    
    /*
    private int esconvenio;
    private int porcCubierto;
    */
    private Set<Beneficio> beneficios = new HashSet<Beneficio>(0);
    private Set<SeguroVidaUsaPersona> seguroVidaUsaPersonas = new HashSet<SeguroVidaUsaPersona>(0);
    public static final int DEFECTO = -1, DATO = 3;
    private int op = -1;

    public SeguroVida() {
    }

    public SeguroVida(int idSeguroVida) {
        this.idSeguroVida = idSeguroVida;
    }

    public SeguroVida(int idSeguroVida, String descripcion, Date fechaReg, Boolean estado, Set<Beneficio> beneficios, Set<SeguroVidaUsaPersona> seguroVidaUsaPersonas) {
        this.idSeguroVida = idSeguroVida;
        this.descripcion = descripcion;
        this.fechaReg = fechaReg;
        this.estado = estado;
        this.beneficios = beneficios;
        this.seguroVidaUsaPersonas = seguroVidaUsaPersonas;
    }

    public int getIdSeguroVida() {
        return this.idSeguroVida;
    }

    public void setIdSeguroVida(int idSeguroVida) {
        this.idSeguroVida = idSeguroVida;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaReg() {
        return this.fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Set<Beneficio> getBeneficios() {
        return this.beneficios;
    }

    public void setBeneficios(Set<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }

    public Set<SeguroVidaUsaPersona> getSeguroVidaUsaPersonas() {
        return this.seguroVidaUsaPersonas;
    }

    public void setSeguroVidaUsaPersonas(Set<SeguroVidaUsaPersona> seguroVidaUsaPersonas) {
        this.seguroVidaUsaPersonas = seguroVidaUsaPersonas;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }
    
    @Override
    public String toString() {
        switch (op) {
            case DATO:
                return getDescripcion();
            default:
                return "<SELECCIONE>";
        }
    }

    public int getEsconvenio() {
        return esconvenio;
    }

    public void setEsconvenio(int esconvenio) {
        this.esconvenio = esconvenio;
    }

    public int getTieneCarta() {
        return tieneCarta;
    }

    public void setTieneCarta(int tieneCarta) {
        this.tieneCarta = tieneCarta;
    }

}
