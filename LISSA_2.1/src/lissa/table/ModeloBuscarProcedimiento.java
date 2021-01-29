package lissa.table;

import lissa.be.Procedimiento;
import lissa.be.ProcedimientoTarifario;
import lissa.be.Usuario;
import lissa.be.UsuarioPermiso;
import lissa.bl.UsuarioPermisoBl;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

public class ModeloBuscarProcedimiento extends AbstractTableModel<ProcedimientoTarifario> {

    private Usuario oUsuario;
    private UsuarioPermiso oUsuarioPermiso;
    private UsuarioPermisoBl oUsuarioPermisoBl;

    public ModeloBuscarProcedimiento() {
        super.setTitles(new String[]{"ID", "Tarifario", "Servicio", "Procedimiento", "Costo"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        oUsuarioPermisoBl = new UsuarioPermisoBl();
        oUsuarioPermiso = oUsuarioPermisoBl.buscarUsuarioPermiso(1, oUsuario.getIdUsuario());
        ProcedimientoTarifario bean = get(fil);
        switch (col) {
            case 0:
                return Utilitarios.numberFormat(bean.getProcedimiento().getIdprocedimiento(), "######");
            case 1:
                return bean.getTarifario().getNombre().trim();
            case 2:
                return bean.getProcedimiento().getServicio().getDenominacion().trim();
            case 3:
                return bean.getProcedimiento().getDenominacion().trim();
            case 4:
                if (oUsuarioPermiso != null) {
                    if (bean.getTarifario().getEsconvenio() == 1) {
                        return bean.getCosto();
                    } else {
                        return bean.getCosto();
                    }
                } else {
                    if (bean.getTarifario().getEsconvenio() == 1) {
                        return "**.**";
                    } else {
                        return bean.getCosto();
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
