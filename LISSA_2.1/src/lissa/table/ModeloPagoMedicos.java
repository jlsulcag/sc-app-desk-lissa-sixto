package lissa.table;

import lissa.be.ComprobanteDetalle;
import lissa.be.MedicoDerivaAtiende;
import lissa.be.Usuario;
import lissa.bl.UsuarioBl;
import lissa.util.Utilitarios;
import org.rx.cr.gui.table.AbstractTableModel;

public class ModeloPagoMedicos extends AbstractTableModel<MedicoDerivaAtiende> {

    public ModeloPagoMedicos() {
        super.setTitles(new String[]{"ID", "Tipo Atención", "Fecha Doc", "Paciente", "HC", "Procedimiento", "Motivo", "Estado", "Pagado por", "Monto", ""});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        MedicoDerivaAtiende bean = get(fil);
        switch (col) {
            case 0:
                return Utilitarios.numberFormat(bean.getIdmedicoderivaatiende(), "######");
            case 1:
                return bean.getComprobanteDetalle().getComprobante().getAtencion().getTipoIngreso();
            case 2:
                return Utilitarios.formatFecha(bean.getComprobanteDetalle().getComprobante().getFechaComprobante());
            case 3:
                return (bean.getComprobanteDetalle().getComprobante().getAtencion().getPersona().getNombre().trim() + " "
                        + bean.getComprobanteDetalle().getComprobante().getAtencion().getPersona().getApellidoPaterno().trim() + " "
                        + bean.getComprobanteDetalle().getComprobante().getAtencion().getPersona().getApellidoMaterno().trim());
            case 4:
                if (bean.getComprobanteDetalle().getComprobante().getAtencion().getHistoriaClinica() != null) {
                    return bean.getComprobanteDetalle().getComprobante().getAtencion().getHistoriaClinica().getNumerohc();
                } else {
                    return "";
                }
            case 5:
                if (bean.getComprobanteDetalle().getProcedimientoTarifario() != null) {
                    return bean.getComprobanteDetalle().getProcedimientoTarifario().getProcedimiento().getDenominacion();
                } else {
                    return "";
                }
            case 6:
                return bean.getMotivo();
            case 7:
                return bean.getEstadoPago();
            case 8:
                if (bean.getUsuariopago() != null) {
                    return bean.getUsuariopago().getNombre().trim();
                } else {
                    return "";
                }
            case 9:
                return bean.getMonto();
            case 10:
                return bean.isSeleccionado();
            default:
                return null;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 10:
                get(rowIndex).setSeleccionado(Boolean.parseBoolean(aValue.toString()));
                break;
        }
    }
}
