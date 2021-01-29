
package lissa.reportes;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class ReportGeneric {
    
    JPanel jp = new JPanel();
    private String reportParent;

    private Connection connection;

    public ReportGeneric(Connection connection) {
        this.connection = connection;
    }

    public JPanel mkReport(String nomRef) throws JRException{
        try {
            JPanel reportPanel = null;
            JasperReport jasperReport = null;
            URL urlReport = null;
            JasperPrint jasperPrint = null;   
            Map parametro = null;
                
                urlReport = getClass().getResource(getReportParent()+nomRef + ".jasper");
                jasperReport = (JasperReport) JRLoader.loadObject(urlReport);
                parametro = new HashMap();
                //paramet.put("keyn",valor);
                jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, connection);
                reportPanel = new JRViewer(jasperPrint);    
                connection.close();
             return reportPanel;
        } catch (SQLException ex) {
            try {
                connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex1);
                return null;
            }
            Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public JPanel mkReport(String nomRef,Map prmt) throws JRException{
        try {
            JPanel reportPanel = null;
            JasperReport jasperReport = null;
            URL urlReport = null;
            JasperPrint jasperPrint=null;
            Map paramet =null;
            
            urlReport = getClass().getResource(getReportParent()+nomRef+".jasper");
            jasperReport = (JasperReport)JRLoader.loadObject(urlReport);
            paramet = prmt;     
            jasperPrint = JasperFillManager.fillReport(jasperReport, paramet,connection);
            reportPanel = new JRViewer(jasperPrint);
            connection.close();
            return reportPanel;
        } catch (SQLException ex) {
            try {
                connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex1);
                return null;
            }
            Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public JPanel mkReport(String nomRef,String[] keys,Object[] values) throws JRException, Exception{
        try {
            JPanel reportPanel = null;
            JasperReport jasperReport = null;
            URL urlReport = null;
            JasperPrint jasperPrint=null;
            Map paramet =null;

            urlReport = getClass().getResource(getReportParent()+nomRef+".jasper");
            jasperReport = (JasperReport) JRLoader.loadObject(urlReport);
            
            paramet = new HashMap();
              if (keys.length == values.length && keys!=null && values!=null) {
                  for (int i = 0; i < values.length; i++) {
                     paramet.put(keys[i],values[i]);
                  }
              } else {
                connection.close();
                throw new Exception("Parametros Invalidos(Llaves y Valores cantidades diferentes) o Nulos");
              }
            jasperPrint = JasperFillManager.fillReport(jasperReport, paramet,connection);
            reportPanel = new JRViewer(jasperPrint);
            connection.close();
            return reportPanel;
        } catch (SQLException ex) {
            try {
                connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex1);
                return null;
            }
            Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public String getReportParent() {
        return reportParent;
    }

    public void setReportParent(String reportParent) {
        this.reportParent = reportParent;
    }
}
