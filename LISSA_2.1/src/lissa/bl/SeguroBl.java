/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.bl;

import java.util.ArrayList;
import java.util.List;
import lissa.be.SeguroVida;
import lissa.dao.PersonaDao;
import lissa.dao.SeguroDao;

/**
 *
 * @author Jorge Luis Sulca González
 */
public class SeguroBl {
    private SeguroDao dao;
    //.....
    //private PresentacionDao daoFamilia;
    private ArrayList<SeguroVida> list;
    //.....
    public SeguroVida registrarPersona(SeguroVida oSeguroVida) {
        dao = new SeguroDao();
        return dao.registrarSeguro(oSeguroVida);
    }
    
    public List<SeguroVida> listar(){
        dao = new SeguroDao();
        return dao.listar();
    }
    
    public void eliminar(SeguroVida oSeguroVida) {
        dao = new SeguroDao();
        dao.eliminar(oSeguroVida);
    }
    
    public SeguroVida buscar(int id) {
        dao = new SeguroDao();
        return dao.buscar(id);
    }
    ///
     public ArrayList<SeguroVida> buscarF(String ref) {
        dao = new SeguroDao();
        list = dao.buscarF(ref);
        return list;
    }
    ///
     public int actualizar(SeguroVida obj){
         dao = new SeguroDao();
        return dao.actualizar(obj);
     }
}
