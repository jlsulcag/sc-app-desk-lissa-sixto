package lissa.be;
// Generated 19/04/2018 04:37:19 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Compra generated by hbm2java
 */
public class Compra  implements java.io.Serializable {


     private long idcompra;
     private FarComprobante farComprobante;
     private Persona personaProveedor;
     private Usuario usuarioReg;
     private String numeroComprobante;
     private Date fechaCompra;     
     private String serie;
     private String horaReg;
     private Date fechaReg;
     private BigDecimal valorNeto;
     private BigDecimal valorIgv;
     private BigDecimal valorBruto;
     private String estado;
     private String motivoAunulacion;
     private int numeroCompra;
     
     private BigDecimal valorDescuento;
     private BigDecimal valorTotal;
     private AlmacenProducto oAlmacenProducto;
     private Set<DetalleCompra> detalleCompras = new HashSet<DetalleCompra>(0);

    public Compra() {
    }

    public long getIdcompra() {
        return this.idcompra;
    }
    
    public void setIdcompra(long idcompra) {
        this.idcompra = idcompra;
    }
    public FarComprobante getFarComprobante() {
        return this.farComprobante;
    }
    
    public void setFarComprobante(FarComprobante farComprobante) {
        this.farComprobante = farComprobante;
    }
    public String getNumeroComprobante() {
        return this.numeroComprobante;
    }
    
    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }
    public Date getFechaCompra() {
        return this.fechaCompra;
    }
    
    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    public String getSerie() {
        return this.serie;
    }
    
    public void setSerie(String serie) {
        this.serie = serie;
    }
    public String getHoraReg() {
        return this.horaReg;
    }
    
    public void setHoraReg(String horaReg) {
        this.horaReg = horaReg;
    }
    public Date getFechaReg() {
        return this.fechaReg;
    }
    
    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }
    public BigDecimal getValorNeto() {
        return this.valorNeto;
    }
    
    public void setValorNeto(BigDecimal valorNeto) {
        this.valorNeto = valorNeto;
    }
    public BigDecimal getValorIgv() {
        return this.valorIgv;
    }
    
    public void setValorIgv(BigDecimal valorIgv) {
        this.valorIgv = valorIgv;
    }
    public BigDecimal getValorBruto() {
        return this.valorBruto;
    }
    
    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getMotivoAunulacion() {
        return this.motivoAunulacion;
    }
    
    public void setMotivoAunulacion(String motivoAunulacion) {
        this.motivoAunulacion = motivoAunulacion;
    }
    public int getNumeroCompra() {
        return this.numeroCompra;
    }
    
    public void setNumeroCompra(int numeroCompra) {
        this.numeroCompra = numeroCompra;
    }
    public BigDecimal getValorDescuento() {
        return this.valorDescuento;
    }
    
    public void setValorDescuento(BigDecimal valorDescuento) {
        this.valorDescuento = valorDescuento;
    }
    public BigDecimal getValorTotal() {
        return this.valorTotal;
    }
    
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    public Set<DetalleCompra> getDetalleCompras() {
        return this.detalleCompras;
    }
    
    public void setDetalleCompras(Set<DetalleCompra> detalleCompras) {
        this.detalleCompras = detalleCompras;
    }

    public AlmacenProducto getoAlmacenProducto() {
        return oAlmacenProducto;
    }

    public void setoAlmacenProducto(AlmacenProducto oAlmacenProducto) {
        this.oAlmacenProducto = oAlmacenProducto;
    }

    public Persona getPersonaProveedor() {
        return personaProveedor;
    }

    public void setPersonaProveedor(Persona personaProveedor) {
        this.personaProveedor = personaProveedor;
    }

    public Usuario getUsuarioReg() {
        return usuarioReg;
    }

    public void setUsuarioReg(Usuario usuarioReg) {
        this.usuarioReg = usuarioReg;
    }




}


