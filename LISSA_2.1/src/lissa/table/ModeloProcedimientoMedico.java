package lissa.table;

import lissa.be.ComprobanteDetalle;
import lissa.be.Usuario;
import lissa.be.UsuarioPermiso;
import lissa.bl.UsuarioPermisoBl;
import lissa.util.Utilitarios;
import org.rx.cr.gui.table.AbstractTableModel;

public class ModeloProcedimientoMedico extends AbstractTableModel<ComprobanteDetalle> {

    private Usuario oUsuario;
    private UsuarioPermiso oUsuarioPermiso;
    private UsuarioPermisoBl oUsuarioPermisoBl;

    public ModeloProcedimientoMedico() {
        super.setTitles(new String[]{"ID", "Procedimiento", "Médico", "Importe"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        oUsuarioPermisoBl = new UsuarioPermisoBl();
        oUsuarioPermiso = oUsuarioPermisoBl.buscarUsuarioPermiso(1, oUsuario.getIdUsuario());
        ComprobanteDetalle bean = get(fil);
        switch (col) {
            case 0:
                return Utilitarios.numberFormat(bean.getIdcomprobantedetalle(), "######");
            case 1:
                return bean.getConcepto();
            case 2:
                if (bean.getMedicoByIdMedicoAtiende() != null) {
                    return bean.getMedicoByIdMedicoAtiende().getPersona().getApellidoPaterno().trim() + " "
                            + bean.getMedicoByIdMedicoAtiende().getPersona().getApellidoMaterno().trim() + " "
                            + bean.getMedicoByIdMedicoAtiende().getPersona().getNombre().trim();
                } else {
                    return "";
                }

            case 3:
                if (oUsuarioPermiso != null) {
                    if (bean.getProcedimientoTarifario().getTarifario().getEsconvenio() == 1) {
                        return bean.getMontoPagado();
                    } else {
                        return bean.getMontoPagado();
                    }
                } else {
                    if (bean.getProcedimientoTarifario().getTarifario().getEsconvenio() == 1) {
                        return "**.**";
                    } else {
                        return bean.getMontoPagado();
                    }
                }

            default:
                return null;
        }
    }

    public void enviaUser(Usuario oUsuario) {
        this.oUsuario = oUsuario;
    }

}
