package lissa.be;
// Generated 10-oct-2016 10:03:30 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

/**
 * DetalleCompra generated by hbm2java
 */
public class DetalleCompra implements java.io.Serializable {

    private long iddetallecompra;
    private Compra compra;
    private Producto producto;
    private Integer cantidad;
    private String lote;
    private Date fechaVencimiento;
    private BigDecimal precioCompra;
    private BigDecimal valorCompraUnitario;
    private BigDecimal descuentoItem;
    private double porcDesc1;
    private double porcDesc2;
    private BigDecimal igvItem;
    private Boolean isUnitario;
    //variables para almacenar precio de venta temporales
    private BigDecimal pvMin;
    private BigDecimal pvMax;
    private BigDecimal pvSugerido;
    

    public DetalleCompra() {
    }

    public long getIddetallecompra() {
        return this.iddetallecompra;
    }

    public void setIddetallecompra(long iddetallecompra) {
        this.iddetallecompra = iddetallecompra;
    }

    public Compra getCompra() {
        return this.compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getLote() {
        return this.lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public BigDecimal getPrecioCompra() {
        return this.precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public BigDecimal getValorCompraUnitario() {
        return this.valorCompraUnitario;
    }

    public void setValorCompraUnitario(BigDecimal valorCompraUnitario) {
        this.valorCompraUnitario = valorCompraUnitario;
    }

    public BigDecimal getDescuentoItem() {
        return descuentoItem;
    }

    public void setDescuentoItem(BigDecimal descuentoItem) {
        this.descuentoItem = descuentoItem;
    }

    public double getPorcDesc1() {
        return this.porcDesc1;
    }

    public void setPorcDesc1(double porcDesc1) {
        this.porcDesc1 = porcDesc1;
    }

    public double getPorcDesc2() {
        return this.porcDesc2;
    }

    public void setPorcDesc2(double porcDesc2) {
        this.porcDesc2 = porcDesc2;
    }

    public BigDecimal getIgvItem() {
        return igvItem;
    }

    public void setIgvItem(BigDecimal igvItem) {
        this.igvItem = igvItem;
    }

    public Boolean getIsUnitario() {
        return isUnitario;
    }

    public void setIsUnitario(Boolean isUnitario) {
        this.isUnitario = isUnitario;
    }

    public BigDecimal getPvMin() {
        return pvMin;
    }

    public void setPvMin(BigDecimal pvMin) {
        this.pvMin = pvMin;
    }

    public BigDecimal getPvMax() {
        return pvMax;
    }

    public void setPvMax(BigDecimal pvMax) {
        this.pvMax = pvMax;
    }

    public BigDecimal getPvSugerido() {
        return pvSugerido;
    }

    public void setPvSugerido(BigDecimal pvSugerido) {
        this.pvSugerido = pvSugerido;
    }
}
