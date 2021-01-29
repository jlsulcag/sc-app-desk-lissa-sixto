package lissa.table;

import lissa.be.ComprobanteDetalle;
import lissa.util.Utilitarios;
import org.rx.cr.gui.table.AbstractTableModel;

public class ModeloRegistrarPagoMedicos extends AbstractTableModel<ComprobanteDetalle> {

    public ModeloRegistrarPagoMedicos() {
        super.setTitles(new String[]{"ID", "Comprobante", "Tipo Atención", "Fecha", "Paciente", "HC", "Procedimiento", "Medico Deriva", "Medico Atiende", "Monto Cobrado","S/. Deriva", "S/. Atiende"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        ComprobanteDetalle bean = get(fil);
        switch (col) {
            case 0:
                return Utilitarios.numberFormat(bean.getIdcomprobantedetalle(), "######");
            case 1:
                return bean.getComprobante().getSerie().trim()+"-"+ Utilitarios.numberFormat(bean.getComprobante().getNumero(), "########");
            case 2:
                return bean.getComprobante().getAtencion().getTipoIngreso().trim();
            case 3:
                return Utilitarios.formatFecha(bean.getComprobante().getAtencion().getFechaIngreso());
            case 4:
                return (bean.getComprobante().getAtencion().getPersona().getNombre().trim() + " "
                        + bean.getComprobante().getAtencion().getPersona().getApellidoPaterno().trim() + " "
                        + bean.getComprobante().getAtencion().getPersona().getApellidoMaterno().trim());
            case 5:
                if (bean.getComprobante().getAtencion().getHistoriaClinica() != null) {
                    return bean.getComprobante().getAtencion().getHistoriaClinica().getNumerohc();
                } else {
                    return "";
                }
            case 6:
                if (bean.getProcedimientoTarifario() != null) {
                    return bean.getProcedimientoTarifario().getProcedimiento().getDenominacion();
                } else {
                    return bean.getConcepto();
                }

            case 7:
                if (bean.getMedicoByIdMedicoDeriva() != null) {
                    return (bean.getMedicoByIdMedicoDeriva().getPersona().getNombre().trim() + " "
                            + bean.getMedicoByIdMedicoDeriva().getPersona().getApellidoPaterno().trim() + " "
                            + bean.getMedicoByIdMedicoDeriva().getPersona().getApellidoMaterno().trim());
                } else {
                    return "";
                }            
            case 8:
                if (bean.getMedicoatiendereal() != null) {
                    return (bean.getMedicoatiendereal().getPersona().getNombre().trim() + " "
                            + bean.getMedicoatiendereal().getPersona().getApellidoPaterno().trim() + " "
                            + bean.getMedicoatiendereal().getPersona().getApellidoMaterno().trim());
                } else {
                    return "";
                }
            case 9:
                return bean.getComprobante().getTotalImporteVenta();
            case 10:
                return bean.getMontoDerivacion();
            case 11:
                return bean.getMontoAtencion();

            default:
                return null;
        }
    }

}
