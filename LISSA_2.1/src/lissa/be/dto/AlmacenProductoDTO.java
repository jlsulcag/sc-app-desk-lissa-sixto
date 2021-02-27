
package lissa.be.dto;

import java.math.BigDecimal;
import java.util.Date;
import lissa.be.Almacen;
import lissa.be.Producto;

public class AlmacenProductoDTO {

    private Long id;
    private Producto producto;
    private Almacen almacen;
    private BigDecimal stockActual;
    private Date fechaRegistro;
    private Boolean estado;
    private BigDecimal precioCompraUnit;
    private BigDecimal precioVentaUnit;
    private String lote;
    private Date fechaVencimiento;

    public AlmacenProductoDTO() {
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public BigDecimal getStockActual() {
        return stockActual;
    }

    public void setStockActual(BigDecimal stockActual) {
        this.stockActual = stockActual;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public BigDecimal getPrecioCompraUnit() {
        return precioCompraUnit;
    }

    public void setPrecioCompraUnit(BigDecimal precioCompraUnit) {
        this.precioCompraUnit = precioCompraUnit;
    }

    public BigDecimal getPrecioVentaUnit() {
        return precioVentaUnit;
    }

    public void setPrecioVentaUnit(BigDecimal precioVentaUnit) {
        this.precioVentaUnit = precioVentaUnit;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    
}
