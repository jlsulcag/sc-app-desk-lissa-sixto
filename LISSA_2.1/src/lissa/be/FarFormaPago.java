package lissa.be;
// Generated 19-oct-2016 12:42:31 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;



/**
 * FarFormaPago generated by hbm2java
 */
public class FarFormaPago implements java.io.Serializable {

    private long idformapago;
    private String formaPago;
    private boolean estado;
    private Set<Venta> ventas = new HashSet<Venta>(0);                    

    private int op = -1;
    public static final int DEFECTO = -1, DATO = 3;

    public FarFormaPago() {
    }
    public long getIdformapago() {
        return this.idformapago;
    }

    public void setIdformapago(long idformapago) {
        this.idformapago = idformapago;
    }

    public String getFormaPago() {
        return this.formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        switch (getOp()) {
            case DATO:
                return getFormaPago();
            default:
                return "<SELECCIONE>";
        }
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public Set<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }

}
