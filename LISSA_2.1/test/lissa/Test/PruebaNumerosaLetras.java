/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.Test;

import lissa.util.Utilitarios;

/**
 *
 * @author JSULCAG
 */
public class PruebaNumerosaLetras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String num = "";
        num = Utilitarios.convertirNumero_Letras("1552,20", true);
        System.out.println("numero en letras .. "+num);
    }
    
}
