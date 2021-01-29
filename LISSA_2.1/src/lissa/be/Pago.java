package lissa.be;
// Generated 14-abr-2016 18:27:18 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Pago generated by hbm2java
 */
public class Pago  implements java.io.Serializable {


     private int idpago;
     private Comprobante comprobante;
     private FormaPago formaPago;
     private Date fechaPago;
     private String horaPago;
     private BigDecimal importePago;
     private Boolean estado;

    public Pago() {
    }

	
    public Pago(int idpago) {
        this.idpago = idpago;
    }
    public Pago(int idpago, Comprobante comprobante, FormaPago formaPago, Date fechaPago, String horaPago, BigDecimal importePago, Boolean estado) {
       this.idpago = idpago;
       this.comprobante = comprobante;
       this.formaPago = formaPago;
       this.fechaPago = fechaPago;
       this.horaPago = horaPago;
       this.importePago = importePago;
       this.estado = estado;
    }
   
    public int getIdpago() {
        return this.idpago;
    }
    
    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }
    public Comprobante getComprobante() {
        return this.comprobante;
    }
    
    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
    }
    public FormaPago getFormaPago() {
        return this.formaPago;
    }
    
    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
    public Date getFechaPago() {
        return this.fechaPago;
    }
    
    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    public String getHoraPago() {
        return this.horaPago;
    }
    
    public void setHoraPago(String horaPago) {
        this.horaPago = horaPago;
    }
    public BigDecimal getImportePago() {
        return this.importePago;
    }
    
    public void setImportePago(BigDecimal importePago) {
        this.importePago = importePago;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }




}


