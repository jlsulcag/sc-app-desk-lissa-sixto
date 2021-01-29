/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.bl;


import java.util.ArrayList;
import java.util.List;
import lissa.be.SeguroVidaUsaPersona;
import lissa.dao.SeguroPersonaDao;

/**
 *
 * @author Jorge Luis Sulca González
 */
public class SeguroPersonaBl {
    private SeguroPersonaDao dao;
    
    public int registrar(SeguroVidaUsaPersona oSeguroPersona) {
        dao = new SeguroPersonaDao();
        return dao.registrar(oSeguroPersona);
    }
    
    public ArrayList<SeguroVidaUsaPersona> listar(long id) {
        dao = new SeguroPersonaDao();
        return dao.listar(id);
    }

    public void eliminar(int idSeguroVida) {
        dao = new SeguroPersonaDao();
        dao.eliminar(idSeguroVida);
    }

    public SeguroVidaUsaPersona buscarSeguroPersona(long idPersona, int idSeguro) {
        dao = new SeguroPersonaDao();
        return dao.buscarSeguroPersona(idPersona, idSeguro);
    }
}
