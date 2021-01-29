package lissa.table;

import lissa.be.ComprobanteDetalle;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

/**
 *
 * @author JSULCAG
 */
public class ModeloComprobanteDetalle extends AbstractTableModel<ComprobanteDetalle> {

    public ModeloComprobanteDetalle() {
        super.setTitles(new String[]{"ID", "Fecha Atención", "Servicio", "Procedimiento", "Medico Atiende", "Importe", "Estado"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        ComprobanteDetalle bean = get(fil);
        switch (col) {
            case 0:
                return bean.getIdcomprobantedetalle();
            case 1:
                if (bean.getFechaAtencion() != null) {
                    return Utilitarios.formatFecha(bean.getFechaAtencion());
                } else {
                    return "";
                }
            case 2:
                if (bean.getProcedimientoTarifario() != null) {
                    return bean.getProcedimientoTarifario().getProcedimiento().getServicio().getDenominacion().trim();
                } else {
                    return "";
                }
            case 3:
                if (bean.getProcedimientoTarifario() != null) {
                    return bean.getProcedimientoTarifario().getProcedimiento().getDenominacion().trim();
                } else {
                    return "";
                }

            case 4:
                if (bean.getMedicoatiendereal() != null) {
                    return (bean.getMedicoatiendereal().getPersona().getNombre() + " "
                            + bean.getMedicoatiendereal().getPersona().getApellidoPaterno() + " "
                            + bean.getMedicoatiendereal().getPersona().getApellidoMaterno());
                } else {
                    return "";
                }
            case 5:
                if (bean.getComprobante().getBeneficio() != null) {
                    return bean.getMontoCubierto();
                } else {
                    return bean.getMontoPagado();
                }
            case 6:
                if (bean.getEstado() != null) {
                    return bean.getEstado();
                } else {
                    return "";
                }
            default:
                return null;
        }
    }

}
