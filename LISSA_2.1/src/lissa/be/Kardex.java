package lissa.be;

import java.math.BigDecimal;
import java.util.Date;

public class Kardex  implements java.io.Serializable {


     private long idkardex;
     private Almacen almacenByIdOrigen;
     private Almacen almacenByIdDestino;
     private Long idFarcomprobante;
     private String operacion;
     private Date fechaMov;
     private String horaMov;
     private String tipoOperacion;
     private long idAlmacenAfectado;
     private String comprobante;
     private String numSerie;
     private String origen;
     private String destino;
     private String observacion;
     private long numComprobante;
     private int grupoNumeracion;
     private Long idProducto;
     private BigDecimal cantidad;
     private BigDecimal valorUnit;
     private Long idAlmacenproducto;
     private int estado;
     private Long nroOrden;
     private BigDecimal stockAnterior;
     private BigDecimal stockActual;
     

    public Kardex() {
    }

    public long getIdkardex() {
        return idkardex;
    }

    public void setIdkardex(long idkardex) {
        this.idkardex = idkardex;
    }

    public Almacen getAlmacenByIdOrigen() {
        return almacenByIdOrigen;
    }

    public void setAlmacenByIdOrigen(Almacen almacenByIdOrigen) {
        this.almacenByIdOrigen = almacenByIdOrigen;
    }

    public Almacen getAlmacenByIdDestino() {
        return almacenByIdDestino;
    }

    public void setAlmacenByIdDestino(Almacen almacenByIdDestino) {
        this.almacenByIdDestino = almacenByIdDestino;
    }

    public Long getIdFarcomprobante() {
        return idFarcomprobante;
    }

    public void setIdFarcomprobante(Long idFarcomprobante) {
        this.idFarcomprobante = idFarcomprobante;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Date getFechaMov() {
        return fechaMov;
    }

    public void setFechaMov(Date fechaMov) {
        this.fechaMov = fechaMov;
    }

    public String getHoraMov() {
        return horaMov;
    }

    public void setHoraMov(String horaMov) {
        this.horaMov = horaMov;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public long getIdAlmacenAfectado() {
        return idAlmacenAfectado;
    }

    public void setIdAlmacenAfectado(long idAlmacenAfectado) {
        this.idAlmacenAfectado = idAlmacenAfectado;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public long getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(long numComprobante) {
        this.numComprobante = numComprobante;
    }

    public int getGrupoNumeracion() {
        return grupoNumeracion;
    }

    public void setGrupoNumeracion(int grupoNumeracion) {
        this.grupoNumeracion = grupoNumeracion;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(BigDecimal valorUnit) {
        this.valorUnit = valorUnit;
    }

    public Long getIdAlmacenproducto() {
        return idAlmacenproducto;
    }

    public void setIdAlmacenproducto(Long idAlmacenproducto) {
        this.idAlmacenproducto = idAlmacenproducto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Long getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(Long nroOrden) {
        this.nroOrden = nroOrden;
    }

    public BigDecimal getStockAnterior() {
        return stockAnterior;
    }

    public void setStockAnterior(BigDecimal stockAnterior) {
        this.stockAnterior = stockAnterior;
    }

    public BigDecimal getStockActual() {
        return stockActual;
    }

    public void setStockActual(BigDecimal stockActual) {
        this.stockActual = stockActual;
    }

   
    
}


