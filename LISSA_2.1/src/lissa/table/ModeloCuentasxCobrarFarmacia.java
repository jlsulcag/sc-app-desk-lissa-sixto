package lissa.table;

import lissa.be.Cuentaxcobrar;
import lissa.util.Utilitarios;
import org.rx.cr.gui.table.AbstractTableModel;

public class ModeloCuentasxCobrarFarmacia extends AbstractTableModel<Cuentaxcobrar> {

    public ModeloCuentasxCobrarFarmacia() {
        super.setTitles(new String[]{"ID", "Fecha", "Comprobante", "Cliente", "Seguro", "Beneficio", "Total", "Dscto", "Copago", "FPS", "Crédito"});
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        Cuentaxcobrar bean = get(fil);
        switch (col) {
            case 0:
                return Utilitarios.numberFormat(bean.getIdcuentaxcobrar(), "######");
            case 1:
                return Utilitarios.formatFecha(bean.getVenta().getFechaVenta());
            case 2:
                if(bean.getVenta().getSerie().trim()!=null && bean.getVenta().getNumComprobante()!=null){
                    return bean.getVenta().getSerie().trim() + "-" + Utilitarios.numberFormat(bean.getVenta().getNumComprobante(), "########");
                }else{
                    return "";
                }
                
            case 3:
                return (bean.getVenta().getClientepersonanatural().getNombre().trim() + " "
                        + bean.getVenta().getClientepersonanatural().getApellidoPaterno().trim() + " "
                        + bean.getVenta().getClientepersonanatural().getApellidoMaterno().trim());
            case 4:
                return bean.getBeneficio().getSeguroVida().getDescripcion().trim();
            case 5:
                return bean.getBeneficio().getNombreBeneficio().trim();

            case 6:
                return bean.getVenta().getTotalImporteVenta();
            case 7:
                return bean.getMontoDesc();
            case 8:
                return bean.getMontoCopago();
            case 9:
                return bean.getMontoPagofps();
            case 10:
                return bean.getCuentaXCobrar();
            default:
                return null;
        }
    }

}
