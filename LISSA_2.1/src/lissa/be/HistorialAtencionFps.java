package lissa.be;
// Generated 19/06/2017 06:04:33 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * HistorialAtencionFps generated by hbm2java
 */
public class HistorialAtencionFps  implements java.io.Serializable {


     private long idhistorialatencionfps;
     private FondoSolidaridad fondoSolidaridad;
     private int idPaqueteFps;
     private int idServicioFps;
     private long idVenta;
     private BigDecimal montoDisponible;
     private int cantDisponible;
     private BigDecimal montoUtilizado;
     private BigDecimal saldo;
     private long numRegistro;
     private Date fechaAtencion;

    public HistorialAtencionFps() {
    }

   
    public long getIdhistorialatencionfps() {
        return this.idhistorialatencionfps;
    }
    
    public void setIdhistorialatencionfps(long idhistorialatencionfps) {
        this.idhistorialatencionfps = idhistorialatencionfps;
    }
    public FondoSolidaridad getFondoSolidaridad() {
        return this.fondoSolidaridad;
    }
    
    public void setFondoSolidaridad(FondoSolidaridad fondoSolidaridad) {
        this.fondoSolidaridad = fondoSolidaridad;
    }
    public int getIdPaqueteFps() {
        return this.idPaqueteFps;
    }
    
    public void setIdPaqueteFps(int idPaqueteFps) {
        this.idPaqueteFps = idPaqueteFps;
    }
    public int getIdServicioFps() {
        return this.idServicioFps;
    }
    
    public void setIdServicioFps(int idServicioFps) {
        this.idServicioFps = idServicioFps;
    }
    public long getIdVenta() {
        return this.idVenta;
    }
    
    public void setIdVenta(long idVenta) {
        this.idVenta = idVenta;
    }
    public BigDecimal getMontoDisponible() {
        return this.montoDisponible;
    }
    
    public void setMontoDisponible(BigDecimal montoDisponible) {
        this.montoDisponible = montoDisponible;
    }
    public int getCantDisponible() {
        return this.cantDisponible;
    }
    
    public void setCantDisponible(int cantDisponible) {
        this.cantDisponible = cantDisponible;
    }
    public BigDecimal getMontoUtilizado() {
        return this.montoUtilizado;
    }
    
    public void setMontoUtilizado(BigDecimal montoUtilizado) {
        this.montoUtilizado = montoUtilizado;
    }
    public BigDecimal getSaldo() {
        return this.saldo;
    }
    
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
    public long getNumRegistro() {
        return this.numRegistro;
    }
    
    public void setNumRegistro(long numRegistro) {
        this.numRegistro = numRegistro;
    }

    /**
     * @return the fechaAtencion
     */
    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    /**
     * @param fechaAtencion the fechaAtencion to set
     */
    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }




}


