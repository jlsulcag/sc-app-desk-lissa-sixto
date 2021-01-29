package lissa.bl;

import java.util.ArrayList;
import lissa.be.PersonaEmpresa;
import lissa.dao.PersonaEmpresaDao;

public class PersonaEmpresaBl {

    private PersonaEmpresaDao dao;
    private ArrayList<PersonaEmpresa> list;

    public PersonaEmpresa registrar(PersonaEmpresa obj) {
        dao = new PersonaEmpresaDao();
        return dao.registrar(obj);
    }

    public int actualizar(PersonaEmpresa obj) {
        dao = new PersonaEmpresaDao();
        return dao.actualizar(obj);
    }

    public PersonaEmpresa buscarXidPersJur(int id) {
        dao = new PersonaEmpresaDao();
        return dao.buscarXidPersJur(id);
    }
}
