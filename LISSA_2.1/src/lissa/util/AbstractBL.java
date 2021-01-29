package lissa.util;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBL<T> implements DAO<T>{
    public abstract AbstractDA getDAO();
    public abstract void setDA(AbstractDA dao);
    @Deprecated
    public T save(T bean) {
        return (T) getDAO().registrar(bean);
    }
    @Deprecated
    public int update(T bean) {
        return getDAO().actualizar(bean);
    }
    @Deprecated
    public int delete(T bean) {
        return getDAO().eliminar(bean);
    }
    @Deprecated
    public List<T> list() {
        return getDAO().listar();
    }
//    @Deprecated
//    public List<T> list(Class c) {
//        return getDAO().listar(c);
//    }
    @Deprecated
    public ArrayList<T> list(String ref) {
        return getDAO().listar(ref);
    }
    @Deprecated
    public List<T> list(long id) {
        return getDAO().listar(id);
    }
    @Deprecated
    public T search(long id) {
        return (T)getDAO().buscar(id);
    }
    @Deprecated
    public T search(String ref) {
        return (T)getDAO().buscar(ref);
    }
    @Deprecated
    public long maxId() {
        return getDAO().id();
    }
}
