/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.ds;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleCallableStatement;

import oracle.jdbc.OracleTypes;

public class ConectorBesterp {

    private ResultSet rs = null;
    private Connection conexion = null;
    private String Driver_db = "oracle.jdbc.OracleDriver";
    //private String url_coneccion = "jdbc:oracle:thin:@192.168.32.96:1521:prod";
    private String url_coneccion = "jdbc:oracle:thin:@192.168.32.96:1521/prod";
    private String usuario = "clinsmmCLINSMM";
    private String password = "clinicasmm123*";

    public void CerrarConexion() throws SQLException {

        //desconectar
        try {
            conexion.close();
            //System.out.println("Cerrar conexion con servidor ... OK");
        } catch (SQLException ex) {
            System.out.println("Imposible cerrar conexion ... FAIL");

            rs = null;
        }
    }

    /////////////////////////////////////////////////////////
    public ResultSet LeerBesterpFondoPrevisionDNI(String numDNI) {
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            //conexion = DriverManager.getConnection("jdbc:oracle:thin:@192.168.32.96:1521:prod", "CLINSMM", "clinicasmm123*");
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@192.168.32.96:1521/prod", "CLINSMM", "clinicasmm123*");
            CallableStatement stmt = conexion.prepareCall("BEGIN getFPSDNIClinicaCursor(?, ?); END;");
            stmt.setString(1, numDNI); // DNI
            stmt.registerOutParameter(2, OracleTypes.CURSOR); //REF CURSOR
            stmt.execute();
            rs = ((OracleCallableStatement) stmt).getCursor(2);
//            while (rs.next()) {
//                System.out.println(rs.getString("APEPATERNO") + ":" + rs.getString("APEMATERNO") + ":" + rs.getString("NOMTER1") + ":" + rs.getString("NOMTER2") + ":" + rs.getString("MTODOC") + ":" + rs.getString("FECDOC") + ":" + rs.getString("NRODOCDEF") + ":" + rs.getString("NUMTERREMOTO"));
//            }
//            rs.close();
//            rs = null;
//            stmt.close();
//            stmt = null;
//            conexion.close();
//            conexion = null;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }

        return rs;
    }

    /////////////////////////////////////////////////////////
    
    
    /////////////////////////////////////////////////////////
    public ResultSet LeerBesterpFondoPrevisionSoc(String CodSoc) {
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            //conexion = DriverManager.getConnection("jdbc:oracle:thin:@192.168.32.96:1521:prod", "CLINSMM", "clinicasmm123*");
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@192.168.32.96:1521/prod", "CLINSMM", "clinicasmm123*");
            CallableStatement stmt = conexion.prepareCall("BEGIN getFPSCodigoClinicaCursor(?, ?); END;");
            stmt.setString(1, CodSoc); // DNI
            stmt.registerOutParameter(2, OracleTypes.CURSOR); //REF CURSOR
            stmt.execute();
            rs = ((OracleCallableStatement) stmt).getCursor(2);
//            while (rs.next()) {
//                System.out.println(rs.getString("APEPATERNO") + ":" + rs.getString("APEMATERNO") + ":" + rs.getString("NOMTER1") + ":" + rs.getString("NOMTER2") + ":" + rs.getString("MTODOC") + ":" + rs.getString("FECDOC") + ":" + rs.getString("NRODOCDEF") + ":" + rs.getString("NUMTERREMOTO"));
//            }
//            rs.close();
//            rs = null;
//            stmt.close();
//            stmt = null;
//            conexion.close();
//            conexion = null;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }

        return rs;
    }

    /////////////////////////////////////////////////////////
    
    
    /**
     * lectura de la base de datos del fondo de previcion
     *
     */
    public ResultSet LeerBesterp(String pSentencia) throws SQLException {

        try {

            Class.forName(Driver_db);
            conexion = DriverManager.getConnection(url_coneccion, usuario, password);

        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando el Driver Oracle JDBC ... FAIL");

            rs = null;
        } catch (SQLException ex) {
            System.out.println("Imposible realizar conexion con el servidor Oracle ... FAIL");

            rs = null;
        }

        //realizar consulta
        try {

            // Preparamos la consulta
            Statement s = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = s.executeQuery(pSentencia);

        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
            System.out.println("FALLO EJECUCION DE LA SENTENCIA: " + pSentencia);

            rs = null;
        }

        return rs;
    }

}
