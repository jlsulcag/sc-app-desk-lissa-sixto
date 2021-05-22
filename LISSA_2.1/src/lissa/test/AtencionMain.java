package lissa.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import lissa.be.Atencionhc;
import lissa.bl.AtencionBl;
import lissa.util.Utilitarios;

public class AtencionMain {

    public static void main(String[] args) {
        Atencionhc obj;
        AtencionBl bl;

        obj = new Atencionhc();
        bl = new AtencionBl();

        obj.setFechaAtencion(new Date());

        Calendar c = new GregorianCalendar();
        int hora, minutos, segundos;

        hora = c.get(Calendar.HOUR_OF_DAY);
        minutos = c.get(Calendar.MINUTE);
        segundos = c.get(Calendar.SECOND);

        //obj.setHoraAtencion(new Time(hora, minutos, segundos));
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");

        System.out.println(date.format(now));
        System.out.println(hour.format(now));
        System.out.println(now);

        obj.setHoraAtencion(hour.format(now));
        //bl.registrar(obj);

        JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date());

        /*--------------------*/
        BigDecimal test = new BigDecimal("1.754208");
       //System.out.println("... " + test.setScale(2, RoundingMode.HALF_UP));

//        BigDecimal cant = new BigDecimal("9.00");
//        BigDecimal pvu = new BigDecimal("0.42");
        BigDecimal cant = new BigDecimal("0.686");
        BigDecimal pvu = new BigDecimal("4.237300");
        BigDecimal cant2 = new BigDecimal("9.58");
        BigDecimal pvu2 = new BigDecimal("0.42");
        cant = cant.setScale(2, BigDecimal.ROUND_HALF_UP);
        pvu = pvu.setScale(2, RoundingMode.HALF_UP);
//        cant2 = cant.setScale(2, BigDecimal.ROUND_HALF_UP);
//        pvu2 = pvu.setScale(2, RoundingMode.HALF_UP);
        

//        System.out.println("cantidad : " + Utilitarios.redondearCustomPrecios(cant,2));
//        System.out.println("pvu : " + Utilitarios.redondearCustomPrecios(pvu,2));

        System.out.println("cantidad 2 : " + cant);
        System.out.println("pvu 2 : " + pvu);

    }


}
