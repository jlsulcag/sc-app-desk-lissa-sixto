package lissa.table;

import lissa.be.Persona;
import lissa.be.Venta;
import lissa.bl.PersonaBl;
import lissa.util.Utilitarios;
import org.rx.cr.table.AbstractTableModel;

/**
 *
 * @author JSULCAG
 */
public class ModeloComprobanteElectronicoAdmision extends AbstractTableModel<Venta> {

    private PersonaBl oPersonaBl;
    private Persona oPersona;

    public ModeloComprobanteElectronicoAdmision() {
        super.setTitles(new String[]{"Fecha", "Comprobante", "N°", "Cliente", "Importe", "Estado", "Envio Sunat"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        Venta bean = get(fil);
        switch (col) {
            case 0:
                return Utilitarios.formatFecha(bean.getFechaVenta());
            case 1:
                return bean.getFarComprobante().getComprobante();
            case 2:
                return bean.getSerie() + " - "+Utilitarios.numberFormat(bean.getNumComprobante(), "########");
            case 3:
                if (bean.getClientepersonanatural() != null) {
                    return bean.getClientepersonanatural().getApellidoPaterno().trim() + " "
                            + bean.getClientepersonanatural().getApellidoMaterno().trim() + " "
                            + bean.getClientepersonanatural().getNombre().trim();
                } else {
                    return "";
                }

            case 4:
                return bean.getTotal();
            case 5:
                return bean.getEstado();
            case 6:
                return bean.getEstadoSunat();
            default:
                return null;
        }
    }

}
