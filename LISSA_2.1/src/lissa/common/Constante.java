
package lissa.common;

import javax.swing.JOptionPane;

public class Constante {
    
    public static  final int ESTADO_ACT = 1;
    public static  final int ESTADO_ANU = 0;
    public static  final int SUCCESS = 1;
    public static  final int ERROR = 0;
    
    //Tipo de mensaje de advertencia o error
    public static final int ERROR_MESSAGE = JOptionPane.ERROR_MESSAGE;
    public static final int INFORMATION_MESSAGE = JOptionPane.INFORMATION_MESSAGE;
    public static final int WARNING_MESSAGE = JOptionPane.WARNING_MESSAGE;
    public static final int QUESTION_MESSAGE = JOptionPane.QUESTION_MESSAGE;
    
    //Titulos ventanas de advertencia o error
    public static final String ERROR_TITLE = "Error";
    public static final String INFORMATION_TITLE = "Atención";
    public static final String WARNING_TITLE = "Precaución";
    public static final String QUESTION_TITLE = "¿Esta seguro de ejecutar la acción?";
    
    //Mensajes de sistema
    public static  final String EL_USUARIO_YA_CUENTA_CON_EL_PERMISO = "El usuario ya cuenta con el permiso";
    public static  final String EL_PERMISO_FUE_DESHABILITADO = "El permiso fue deshabilitado";
    public static  final String ERROR_EN_LA_OPERACION_REALIZADA = "Error en la transacción";
    public static  final String SELECCIONE_USUARIO = "Seleccione Usuario";
    public static  final String SELECCIONE_PERMISO = "Seleccione Permiso";
    public static  final String EL_USUARIO_YA_CUENTA_CON_EL_ROL = "El usuario ya cuenta con el Rol";
    public static  final String EL_ROL_FUE_DESHABILITADO = "El rol fue deshabilitado";
}
