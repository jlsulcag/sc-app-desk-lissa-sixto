package lissa.dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import lissa.be.Almacen;
import lissa.be.AlmacenProducto;
import lissa.be.Compra;
import lissa.be.DetalleCompra;
import lissa.be.Kardex;
import lissa.be.PrecioProducto;
import lissa.be.Producto;
import lissa.bl.AlmacenBl;
import lissa.bl.AlmacenProductoBl;
import lissa.bl.DetalleCompraBl;
import lissa.bl.KardexBl;
import lissa.table.ModeloCompraProducto;
import lissa.util.AbstractDA;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import lissa.util.Utilitarios;
import lissa.util.Constants;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JSULCAG
 */
public class CompraDao extends AbstractDA<Compra> {

    private Session sesion;
    private Transaction tx;
    private List<Compra> list;
    private int SUCCESS = 1;
    private int ERROR = 0;

    @Override
    public Compra registrar(Compra bean) {
        return save(bean);
    }

    @Override
    public int actualizar(Compra bean) {
        return update(bean);
    }

    @Override
    public int eliminar(Compra bean) {
        return delete(bean);
    }

    @Override
    public List<Compra> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Compra> listar(String hql) {
        return list(hql);
    }

    @Override
    public List<Compra> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Compra buscar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Compra buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Compra> listarxIdProveedor(long idproveedor) {
//        String hql = "from Compra c where c.idProveedor = "+idproveedor;
//        return listar(hql);
        try {
            iniciarOperacion();
            String hql = "from Compra a where a.idProveedor = " + idproveedor;
            list = sesion.createQuery(hql).list();
            tx.commit();
            //sesion.close();
            return list;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return null;
        }
    }

    private void iniciarOperacion() throws HibernateException {
        if (sesion != null) {
            sesion.close();
        } else {
            sesion = HibernateUtil.getSessionFactory().openSession();
            tx = sesion.beginTransaction();
        }
    }

    private void manejaExcepcion(HibernateException he) {
        tx.rollback();
        Mensajes.ErrorFatal(he);
    }

    public void cerrarSesion() {
        sesion.close();
    }

    public List<Compra> listarXNumComprobante(String num) {
        try {
            iniciarOperacion();
            String hql = "from Compra a left join fetch a.personaProveedor b where a.numeroComprobante like '" + num + "%'";
            list = sesion.createQuery(hql).list();
            tx.commit();
            sesion.close();
        } catch (HibernateException e) {
            manejaExcepcion(e);
            list = new LinkedList<>();
        }
        return list;
    }

    public int registrar(Compra oCompra, ModeloCompraProducto oModeloCompraProducto) {
        int res = -1;
        try {
            iniciarOperacion();
            sesion.save(oCompra);
            for (int i = 0; i < oModeloCompraProducto.getRowCount(); i++) {
                DetalleCompra oDetalleCompra = new DetalleCompra();
                oDetalleCompra = oModeloCompraProducto.get(i);
                oDetalleCompra.setCompra(oCompra);
                sesion.save(oDetalleCompra);

                AlmacenProducto oAlmacenProducto = new AlmacenProducto();
                AlmacenProductoBl oAlmacenProductoBl = new AlmacenProductoBl();
                oAlmacenProducto.setProducto(oDetalleCompra.getProducto());
                oAlmacenProducto.setAlmacen(new AlmacenBl().buscar(1));
                if(oDetalleCompra.getIsUnitario()){
                    oAlmacenProducto.setStockActual(new BigDecimal(oDetalleCompra.getCantidad()));
                }else{
                    oAlmacenProducto.setStockActual(new BigDecimal(oDetalleCompra.getCantidad() * oDetalleCompra.getProducto().getFraccion()));
                }                
                oAlmacenProducto.setFechaRegistro(new Date());
                oAlmacenProducto.setFechaUltAct(new Date());
                oAlmacenProducto.setLote(oDetalleCompra.getLote());
                oAlmacenProducto.setFechaVencimiento(oDetalleCompra.getFechaVencimiento());
                oAlmacenProducto.setValorCompraUnitario(((oDetalleCompra.getValorCompraUnitario()).multiply(new BigDecimal(oDetalleCompra.getCantidad()))).divide(oAlmacenProducto.getStockActual(), 2, RoundingMode.HALF_UP));
                oAlmacenProducto.setPrecioCompraUnitario(oAlmacenProducto.getValorCompraUnitario().multiply(Constants.CIEN_IGV));
                //obtener el ultimo numero de orden de registro segun id de producto
                int orden = oAlmacenProductoBl.buscarxAlmacenyIdproducto(oAlmacenProducto.getProducto().getIdproducto(), (new AlmacenBl().buscar(1)).getIdalmacen());
                oAlmacenProducto.setOrdenRegistro(orden + 1);
                oAlmacenProducto.setEstado(true);
                sesion.save(oAlmacenProducto);

                //registrar precios del producto
                registrarPrecios(oDetalleCompra, oAlmacenProducto);
                registrarKardex(oDetalleCompra, oAlmacenProducto);
            }
            tx.commit();
            res = SUCCESS;
        } catch (HibernateException e) {
            res = ERROR;
            manejaExcepcion(e);
        } finally {
            cerrarSesion();
        }
        return res;
    }

    private void registrarPrecios(DetalleCompra oDetalleCompra, AlmacenProducto oAlmacenProducto) {
        PrecioProducto oPrecioProducto = new PrecioProducto();

        oPrecioProducto.setAlmacenProducto(oAlmacenProducto);
        oPrecioProducto.setPvMin(oDetalleCompra.getPvMin());
        oPrecioProducto.setPvMax(oDetalleCompra.getPvMax());
        oPrecioProducto.setPvSugerido(oDetalleCompra.getPvSugerido());
        oPrecioProducto.setFechaInicio(new Date());
        oPrecioProducto.setIdUsuario(oDetalleCompra.getCompra().getUsuarioReg().getIdUsuario());
        oPrecioProducto.setEstado(1);

        sesion.save(oPrecioProducto);
    }

    private void registrarKardex(DetalleCompra oDetalleCompra, AlmacenProducto oAlmacenProducto) {
        Kardex oKardex = new Kardex();
        KardexBl oKardexBl = new KardexBl();
        //El origen es el proveedor = vacio
        oKardex.setAlmacenByIdDestino(new AlmacenBl().buscar(1));
        oKardex.setIdAlmacenAfectado((new AlmacenBl().buscar(1)).getIdalmacen());
        oKardex.setIdFarcomprobante((oDetalleCompra.getCompra().getFarComprobante()).getIdfarcomprobante());
        oKardex.setTipoOperacion("ENTRADA");//entrada y salida
        oKardex.setOperacion("COMPRA");
        oKardex.setFechaMov(new Date());
        oKardex.setHoraMov(Utilitarios.horaActual());
        oKardex.setComprobante((oDetalleCompra.getCompra().getFarComprobante()).getComprobante().trim());
        oKardex.setNumSerie(oDetalleCompra.getCompra().getSerie().trim());
        oKardex.setNumComprobante(Long.valueOf(oDetalleCompra.getCompra().getNumeroComprobante()));
        oKardex.setOrigen(oDetalleCompra.getCompra().getPersonaProveedor() != null? oDetalleCompra.getCompra().getPersonaProveedor().getRazonSocial():"");
        oKardex.setDestino((new AlmacenBl().buscar(1)).getNombre());
        oKardex.setObservacion("");
        oKardex.setGrupoNumeracion(1);
        oKardex.setIdProducto(Long.parseLong(oDetalleCompra.getProducto().getIdproducto() + ""));
        if(oDetalleCompra.getIsUnitario()){
            oKardex.setCantidad(new BigDecimal(oDetalleCompra.getCantidad()));
        }else{
            oKardex.setCantidad(new BigDecimal(oDetalleCompra.getCantidad()).multiply(new BigDecimal(oDetalleCompra.getProducto().getFraccion())));
        }        
        oKardex.setValorUnit(oDetalleCompra.getValorCompraUnitario());
        oKardex.setIdAlmacenproducto(oAlmacenProducto.getIdalmacenproducto());
        oKardex.setEstado(1);
        //Obntener el ultimo numero de orden de registro de kardex
        long nro = oKardexBl.nroOrdenregistro(oKardex.getIdProducto());
        oKardex.setNroOrden(nro + 1);
        oKardex.setStockAnterior(BigDecimal.ZERO);
        oKardex.setStockActual(oKardex.getCantidad());
        sesion.save(oKardex);
    }

    public int procesarAnulacion(Compra oCompraTemp2, List<DetalleCompra> listDetalleCompra) {
        int res = -1;
        DetalleCompra oDetalleCompra;
        try {
            iniciarOperacion();
            sesion.update(oCompraTemp2);
            /*Actualizar almacen stock y registrar kardex*/
            for (DetalleCompra detalleCompra : listDetalleCompra) {
                /*ACTUALIZAR ALMACEN STOCK*/
                AlmacenProducto oAlmacenProducto = new AlmacenProducto();
                AlmacenProductoBl oAlmacenProductoBl = new AlmacenProductoBl();
                //buscar en almacen por producto y nombre de almacen para su actualizacion y lote y retornar el objeto a actualizar
                //Buscar por lote
                oDetalleCompra = detalleCompra;
                oAlmacenProducto = buscarAlmacenProductoXlote(oDetalleCompra.getLote().trim(), new AlmacenBl().buscar(1), oDetalleCompra.getProducto());
                if(oAlmacenProducto != null){
                    if(oDetalleCompra.getIsUnitario()){
                        oAlmacenProducto.setStockActual(oAlmacenProducto.getStockActual().subtract(new BigDecimal(oDetalleCompra.getCantidad()))); 
                    }else{
                        oAlmacenProducto.setStockActual(oAlmacenProducto.getStockActual().subtract(new BigDecimal(oDetalleCompra.getCantidad() * oDetalleCompra.getProducto().getFraccion()))); 
                    }                                   
                    sesion.update(oAlmacenProducto);
                }                
                /*Registrar Kardex  para cada item*/
                Integer almacenDestino = 0;
                Integer almacenOrigen = 1;
                int almacenAfectado = 1;                
                registrarKardex(detalleCompra, oAlmacenProducto, "SALIDA", "ANULACION DE COMPRA", almacenOrigen, almacenDestino, almacenAfectado);
                
            }
            tx.commit();
            res = SUCCESS;
        } catch (HibernateException e) {
            res = ERROR;
            Mensajes.ErrorFatal(e);
        }

        return res;
    }
    
    private AlmacenProducto buscarAlmacenProductoXlote(String lote, Almacen oAlmacen, Producto oProducto) {
        AlmacenProductoBl oAlmacenProductoBl = new AlmacenProductoBl();
        return oAlmacenProductoBl.buscarProductoxAlmacenyLote(lote, oAlmacen, oProducto);
    }

    private void registrarKardex(DetalleCompra oDetalleCompra, AlmacenProducto oAlmacenProducto, String tipoOperacion, String operacion, Integer almacenOrigen, Integer almacenDestino, int almacenAfectado) {
        Kardex oKardex = new Kardex();
        KardexBl oKardexBl = new KardexBl();
        /*Obtener DetalleCompra y sus dependencias a fin de tener dos sus datos  poder reutilizarlos*/
        DetalleCompra oDetalleCompraTemp = new DetalleCompra();
        DetalleCompraBl oDetalleCompraBl = new DetalleCompraBl();
        
        oDetalleCompraTemp  = oDetalleCompraBl.buscarXId(oDetalleCompra);
        
        
        //El origen es el proveedor = vacio
        oKardex.setAlmacenByIdOrigen(new AlmacenBl().buscar(almacenOrigen));
        oKardex.setAlmacenByIdDestino(almacenDestino == 0?null:new AlmacenBl().buscar(almacenDestino));
        oKardex.setIdAlmacenAfectado((new AlmacenBl().buscar(almacenAfectado)).getIdalmacen());
        oKardex.setIdFarcomprobante((oDetalleCompraTemp.getCompra().getFarComprobante()).getIdfarcomprobante());
        oKardex.setTipoOperacion(tipoOperacion);//entrada y salida
        oKardex.setOperacion(operacion);
        oKardex.setFechaMov(new Date());
        oKardex.setHoraMov(Utilitarios.horaActual());
        oKardex.setComprobante((oDetalleCompraTemp.getCompra().getFarComprobante()).getComprobante().trim());
        oKardex.setNumSerie(oDetalleCompraTemp.getCompra().getSerie().trim());
        oKardex.setNumComprobante(Long.valueOf(oDetalleCompraTemp.getCompra().getNumeroComprobante()));
        oKardex.setOrigen(oDetalleCompraTemp.getCompra().getPersonaProveedor()!=null?oDetalleCompraTemp.getCompra().getPersonaProveedor().getRazonSocial():"");
        oKardex.setDestino(almacenDestino == 0?"":(new AlmacenBl().buscar(almacenDestino)).getNombre());
        oKardex.setObservacion("");
        oKardex.setGrupoNumeracion(1);
        oKardex.setIdProducto(Long.parseLong(oDetalleCompraTemp.getProducto().getIdproducto() + ""));
        oKardex.setCantidad(new BigDecimal(oDetalleCompraTemp.getCantidad()));
        oKardex.setValorUnit(oDetalleCompraTemp.getValorCompraUnitario());
        oKardex.setIdAlmacenproducto(oAlmacenProducto.getIdalmacenproducto());
        oKardex.setEstado(1);
        //Obtener el ultimo numero de orden de registro de kardex
        long nro = oKardexBl.nroOrdenregistro(oKardex.getIdProducto());
        oKardex.setNroOrden(nro + 1);
        oKardex.setStockActual(oAlmacenProducto.getStockActual());
        
        sesion.save(oKardex);
        
    }

}
