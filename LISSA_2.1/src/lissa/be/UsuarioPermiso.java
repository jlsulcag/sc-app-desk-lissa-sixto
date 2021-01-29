package lissa.be;
// Generated 01/10/2018 12:21:27 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * UsuarioPermiso generated by hbm2java
 */
public class UsuarioPermiso  implements java.io.Serializable {


     private int idusuariopermiso;
     private Permiso permiso;
     private Usuario usuario;
     private Date fechaAct;
     private Usuario userReg;
     private int estado;

    public UsuarioPermiso() {
    }

	
    public UsuarioPermiso(int idusuariopermiso, Permiso permiso, Usuario usuario, Date fechaAct, int estado) {
        this.idusuariopermiso = idusuariopermiso;
        this.permiso = permiso;
        this.usuario = usuario;
        this.fechaAct = fechaAct;
        this.estado = estado;
    }
   
    public int getIdusuariopermiso() {
        return this.idusuariopermiso;
    }
    
    public void setIdusuariopermiso(int idusuariopermiso) {
        this.idusuariopermiso = idusuariopermiso;
    }
    public Permiso getPermiso() {
        return this.permiso;
    }
    
    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Date getFechaAct() {
        return this.fechaAct;
    }
    
    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }
    public int getEstado() {
        return this.estado;
    }
    
    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Usuario getUserReg() {
        return userReg;
    }

    public void setUserReg(Usuario userReg) {
        this.userReg = userReg;
    }




}


