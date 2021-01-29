
package lissa.bl;

import java.util.ArrayList;
import lissa.be.PersonaJuridica;
import lissa.dao.PersonaJuridicaDao;

public class PersonaJuridicaBl {
    private PersonaJuridicaDao dao;
    private ArrayList<PersonaJuridica> list;
    private PersonaJuridica obj;
    
    public PersonaJuridica registrar(PersonaJuridica obj) {
        dao = new PersonaJuridicaDao();
        return dao.registrar(obj);
    }
    
    public int actualizar(PersonaJuridica obj) {
        dao = new PersonaJuridicaDao();
        return dao.actualizar(obj);
    }
    
    public ArrayList<PersonaJuridica> buscarPersonaJuridica(String ref) {
        dao = new PersonaJuridicaDao();
        list = dao.buscarPersonaJuridica(ref);
        return list;
    }
    
    public PersonaJuridica buscarxRuc(String ruc) {
        dao = new PersonaJuridicaDao();
        return dao.buscarxRuc(ruc);
    }
}
