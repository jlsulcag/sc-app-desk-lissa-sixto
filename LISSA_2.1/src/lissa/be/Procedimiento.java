package lissa.be;
// Generated 19/09/2018 03:22:57 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Procedimiento generated by hbm2java
 */
public class Procedimiento  implements java.io.Serializable {


     private long idprocedimiento;
     private Servicio servicio;
     private String denominacion;
     private int estado;
     private String codigo;
     private Set<ProcedimientoTarifario> procedimientoTarifarios = new HashSet<ProcedimientoTarifario>(0);
     private Set<ComprobanteDetalle> comprobanteDetalles = new HashSet<ComprobanteDetalle>(0);
     private boolean  seleccionado;
     public static final int DEFECTO = -1, DATO = 3;
    private int op = -1;

    public Procedimiento() {
    }
    public long getIdprocedimiento() {
        return this.idprocedimiento;
    }
    
    public void setIdprocedimiento(long idprocedimiento) {
        this.idprocedimiento = idprocedimiento;
    }
    public Servicio getServicio() {
        return this.servicio;
    }
    
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public String getDenominacion() {
        return this.denominacion;
    }
    
    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    public int getEstado() {
        return this.estado;
    }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public Set<ComprobanteDetalle> getComprobanteDetalles() {
        return this.comprobanteDetalles;
    }
    
    public void setComprobanteDetalles(Set<ComprobanteDetalle> comprobanteDetalles) {
        this.comprobanteDetalles = comprobanteDetalles;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public Set<ProcedimientoTarifario> getProcedimientoTarifarios() {
        return procedimientoTarifarios;
    }

    public void setProcedimientoTarifarios(Set<ProcedimientoTarifario> procedimientoTarifarios) {
        this.procedimientoTarifarios = procedimientoTarifarios;
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
                return getDenominacion();
            default:
                return "<SELECCIONE>";
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}


