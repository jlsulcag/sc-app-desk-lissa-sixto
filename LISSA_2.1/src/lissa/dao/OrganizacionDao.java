/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lissa.dao;

import java.util.ArrayList;
import java.util.List;
import lissa.be.Organizacion;
import lissa.util.AbstractDA;


public class OrganizacionDao extends AbstractDA<Organizacion>{

    @Override
    public Organizacion registrar(Organizacion bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Organizacion bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Organizacion bean) {
        return delete(bean);
    }

    @Override
    public List<Organizacion> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Organizacion> listar(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Organizacion> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Organizacion buscar(long id) {
        return search(Organizacion.class, id);
    }

    @Override
    public Organizacion buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
