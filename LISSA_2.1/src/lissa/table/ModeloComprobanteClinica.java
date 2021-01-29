package lissa.table;

import lissa.be.Comprobante;
import lissa.be.Persona;
import lissa.bl.PersonaBl;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

/**
 *
 * @author JSULCAG
 */
public class ModeloComprobanteClinica extends AbstractTableModel<Comprobante> {

    public ModeloComprobanteClinica() {
        super.setTitles(new String[]{"ID", "Fecha", "Paciente", "Comprobante", "N° Comp", "Convenio", "N° Carta", "Importe", "Estado"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        Comprobante bean = get(fil);
        switch (col) {
            case 0:
                return Utilitarios.numberFormat(bean.getIdcomprobante(), "######");
            case 1:
                return Utilitarios.formatFecha(bean.getFechaComprobante());
            case 2:
                if (bean.getAtencion().getPersona() != null) {
                    return bean.getAtencion().getPersona().getNombre().trim() + " "
                            + bean.getAtencion().getPersona().getApellidoPaterno().trim() + " "
                            + bean.getAtencion().getPersona().getApellidoMaterno().trim();
                } else {
                    return "";
                }

            case 3:
                return bean.getTipoComprobante().getDenominacion();
            case 4:
                return Utilitarios.numberFormat(bean.getNumero(), "########");
            case 5:
                if (bean.getBeneficio() != null) {
                    return bean.getBeneficio().getSeguroVida().getDescripcion();
                } else {
                    return "";
                }

            case 6:
                if (bean.getNumeroCarta() != null) {
                    return bean.getNumeroCarta();
                } else {
                    return "";
                }

            case 7:
                return bean.getMontoTotal();
            case 8:
                return bean.getEstado();
            default:
                return null;
        }
    }

}
