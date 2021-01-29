
package lissa.jdbcdao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import lissa.be.Venta;
import lissa.ds.DSConeccion;
import lissa.gui.JF_Principal;
import lissa.util.IDaoGeneric;
import lissa.util.Utilitarios;

/**
 *
 * @author JSULCAG
 */
public class VentaDao implements IDaoGeneric<Venta>{
    private JF_Principal root;
    private DSConeccion ds= null;
    private Connection cn = null;
    private PreparedStatement ps = null;
    private CallableStatement cstm = null;
    

    @Override
    public Venta registrar(Venta obj) throws Exception {
        try {
            ds = new DSConeccion(root.getConfig());
            cn = ds.getConeccion();
            cn.setAutoCommit(false);
            String query = "";
            cstm = cn.prepareCall("{call farmacia.registrarVenta(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            //Setear los parametros enviados  a traves  del procedimiento almacenado
            //cstm.setLong(1, obj.getIdCliente());
            //cstm.setLong(2, obj.getIdUsuario());
            cstm.setDate(3, Utilitarios.castDate_UTIL_SQL(obj.getFechaVenta()));
            cstm.setString(4, obj.getHoraVenta());
            cstm.setLong(5, obj.getFarComprobante().getIdfarcomprobante());
            cstm.setLong(6, obj.getNumComprobante());
            cstm.setInt(7, obj.getGrupoNumeracion());
            cstm.setBigDecimal(8, obj.getSubTotal());
            cstm.setBigDecimal(9, obj.getMontoIgv());
            cstm.setBigDecimal(10, obj.getTotal());
            cstm.setString(11, obj.getEstado());
            cstm.setString(12, obj.getMotivoAnulacion());
            //cstm.setInt(13, obj.getIdCaja());
            //cstm.setInt(14, obj.getIdPersonajuridica());
            cstm.setInt(15, obj.getNumOperacion());
            cstm.setString(16, obj.getDescripcionSeguros());
            cstm.setLong(17, obj.getAreaConsumo().getIdareaconsumo());
            cstm.setString(18, obj.getResponsableNotasalida());
            cstm.setLong(19, obj.getAlmacenOrigen().getIdalmacen());
            cstm.setString(20, obj.getObservacion());
            
            cstm.executeUpdate();
            
        } catch (Exception e) {
            cn.rollback();
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public int actualizar(Venta obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Venta obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venta> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venta> listar(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta buscar(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venta buscar(String ref) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
