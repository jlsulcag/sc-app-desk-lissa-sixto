package lissa.table;

import lissa.be.CitaDetalle;
import lissa.be.Usuario;
import lissa.be.UsuarioPermiso;
import lissa.bl.UsuarioPermisoBl;
import lissa.gui.JF_Principal;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

/**
 *
 * @author JSULCAG
 */
public class ModeloCitaDetalle extends AbstractTableModel<CitaDetalle> {
    private JF_Principal root;
    private Usuario oUsuario;
    private UsuarioPermiso oUsuarioPermiso;
    private UsuarioPermisoBl oUsuarioPermisoBl;

    public ModeloCitaDetalle(JF_Principal root) {
        this.root = root;
        super.setTitles(new String[]{"ID", "Servicio", "Procedimiento", "Medico", "Costo"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        oUsuarioPermisoBl = new UsuarioPermisoBl();
        oUsuarioPermiso = oUsuarioPermisoBl.buscarUsuarioPermiso(1, this.root.getUser().getIdUsuario());
        CitaDetalle bean = get(fil);
        switch (col) {
            case 0:
                return Utilitarios.numberFormat(bean.getIdcitadetalle(), "######");
            case 1:
                return bean.getProcedimientoTarifario().getProcedimiento().getServicio().getDenominacion().trim();
            case 2:
                return bean.getProcedimientoTarifario().getProcedimiento().getDenominacion().trim();
            case 3:
                if (bean.getMedico() != null) {
                    return bean.getMedico().getPersona().getNombre().trim() + " "
                            + bean.getMedico().getPersona().getApellidoPaterno().trim() + " "
                            + bean.getMedico().getPersona().getApellidoMaterno().trim();
                } else {
                    return "";
                }
            case 4:
                if (oUsuarioPermiso != null) {
                    if (bean.getProcedimientoTarifario().getTarifario().getEsconvenio() == 1) {
                        return bean.getCosto();
                    } else {
                        return bean.getCosto();
                    }
                } else {
                    if (bean.getProcedimientoTarifario().getTarifario().getEsconvenio() == 1) {
                        return "**.**";
                    } else {
                        return bean.getCosto();
                    }
                }
            default:
                return null;
        }
    }
    /*
    public void setOusuario(Usuario user) {
        this.oUsuario = user;
    }
*/
}
