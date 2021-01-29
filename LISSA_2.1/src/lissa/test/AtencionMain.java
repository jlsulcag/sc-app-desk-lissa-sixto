package lissa.test;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import lissa.be.Atencionhc;
import lissa.be.HistoriaClinica;
import lissa.bl.AtencionBl;

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
        bl.registrar(obj);
        
        JSpinner timeSpinner  = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner , "HH:mm:ss");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date());
        
        
    }

}
