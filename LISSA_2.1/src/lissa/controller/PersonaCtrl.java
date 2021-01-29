
package lissa.controller;

import java.util.List;
import lissa.be.Persona;
import lissa.bl.PersonaBl;

public class PersonaCtrl {
    private Persona oPersona;
    private PersonaBl oPersonaBl;
    private List<Persona> list;

    public PersonaCtrl() {
    }
    
    public List<Persona> buscarPersonaXNombres(){
        System.out.println("");
        return list;
    }
}
