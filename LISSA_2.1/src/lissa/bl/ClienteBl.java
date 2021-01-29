
package lissa.bl;

import lissa.be.Atencion;
import lissa.dao.ClienteDao;

public class ClienteBl {
    private ClienteDao dao;

    public ClienteBl() {
    }
    
    public int registrar(Atencion obj){
        dao = new ClienteDao();
        return dao.registrar(obj);
    }
}
