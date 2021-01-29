package lissa.table;

import lissa.be.ComprobanteDetalle;
import lissa.util.Utilitarios;
import org.rx.cr.gui.table.AbstractTableModel;

public class ModeloAdminAtencion extends AbstractTableModel<ComprobanteDetalle> {

    public ModeloAdminAtencion() {
        super.setTitles(new String[]{"ID", "Tipo Atención", "Fecha Ingreso", "Paciente", "HC", "Procedimiento", "Medico Asignado", "Medico Atiende", "Observaciones", "Estado"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        ComprobanteDetalle bean = get(fil);
        switch (col) {
            case 0:
                return Utilitarios.numberFormat(bean.getIdcomprobantedetalle(), "######");
            case 1:
                return bean.getComprobante().getAtencion().getTipoIngreso().trim();
            case 2:
                return Utilitarios.formatFecha(bean.getComprobante().getAtencion().getFechaIngreso());
            case 3:
                return (bean.getComprobante().getAtencion().getPersona().getNombre().trim() + " "
                        + bean.getComprobante().getAtencion().getPersona().getApellidoPaterno().trim() + " "
                        + bean.getComprobante().getAtencion().getPersona().getApellidoMaterno().trim());
            case 4:
                if (bean.getComprobante().getAtencion().getHistoriaClinica() != null) {
                    return bean.getComprobante().getAtencion().getHistoriaClinica().getNumerohc();
                } else {
                    return "";
                }
            case 5:
                if (bean.getProcedimientoTarifario() != null) {
                    return bean.getProcedimientoTarifario().getProcedimiento().getDenominacion();
                } else {
                    return bean.getConcepto();
                }

            case 6:
                if (bean.getMedicoByIdMedicoAtiende() != null) {
                    return (bean.getMedicoByIdMedicoAtiende().getPersona().getNombre().trim() + " "
                            + bean.getMedicoByIdMedicoAtiende().getPersona().getApellidoPaterno().trim() + " "
                            + bean.getMedicoByIdMedicoAtiende().getPersona().getApellidoMaterno().trim());
                } else {
                    return "";
                }
            case 7:
                if (bean.getMedicoatiendereal() != null) {
                    return (bean.getMedicoatiendereal().getPersona().getNombre().trim() + " "
                            + bean.getMedicoatiendereal().getPersona().getApellidoPaterno().trim() + " "
                            + bean.getMedicoatiendereal().getPersona().getApellidoMaterno().trim());
                } else {
                    return "";
                }
            case 8:
                if (bean.getObservacionTriaje() != null) {
                    return bean.getObservacionTriaje().trim();
                } else {
                    return "";
                }
            case 9:
                return bean.getEstado().trim();
            default:
                return null;
        }
    }

}
