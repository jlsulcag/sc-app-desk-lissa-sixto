package lissa.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import lissa.be.Almacen;
import lissa.be.AlmacenProducto;
import lissa.be.DetalleVenta;
import lissa.be.FarComprobante;
import lissa.be.Kardex;
import lissa.be.PrecioProducto;
import lissa.be.Producto;
import lissa.be.Usuario;
import lissa.be.dto.AlmacenProductoDTO;
import lissa.bl.AlmacenProductoBl;
import lissa.bl.KardexBl;
import lissa.bl.PrecioProductoBl;
import lissa.gui.JF_Principal;
import lissa.table.ModeloAlmacenProductoDTO;
import lissa.table.ModeloVentaProducto;
import lissa.util.AbstractDA;
import lissa.util.Utilitarios;
import lissa.util.HibernateUtil;
import lissa.util.Mensajes;
import lissa.util.Constants;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AlmacenProductoDao extends AbstractDA<AlmacenProducto> {

    private Session sesion;
    private Transaction tx;
    private ArrayList<AlmacenProducto> list;
    private AlmacenProducto obj;
    private int SUCCESS = 1;
    private int ERROR = 0;
    private PrecioProducto oPrecioProducto;

    @Override
    public AlmacenProducto registrar(AlmacenProducto bean) {
        return save(bean);
    }

    @Override
    public int actualizar(AlmacenProducto bean) {
        return update(bean);
    }

    @Override
    public int eliminar(AlmacenProducto bean) {
        return delete(bean);
    }

    public long buscar(int idproducto, int idalmacen) {
        long res = 0;
        try {
            iniciarOperacion();
            String hql = "select sum(ap.stockActual) from AlmacenProducto ap inner join ap.producto p inner join ap.almacen a where a.idalmacen = " + idalmacen + " and p.idproducto = " + idproducto + " group by p";
            Query query = sesion.createQuery(hql);
            if (query.uniqueResult() == null) {
                res = 0;
            } else {
                res = (long) query.uniqueResult();
            }
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            sesion.close();
        }
        return res;
    }

    @Override
    public List<AlmacenProducto> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AlmacenProducto> listar(String hql) {
        hql = "from AlmacenProducto ap order by ap.producto.nombre asc, ap.fechaVencimiento asc";
        return list(hql);
    }

    @Override
    public List<AlmacenProducto> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AlmacenProducto buscar(long id) {
        return search(AlmacenProducto.class, id);
    }

    @Override
    public AlmacenProducto buscar(String ref) {
        //String query = "from AlmacenProducto ap where ap.lote = '" + ref + "'";
        return search(ref);
    }

    @Override
    public long id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<AlmacenProducto> listRef(String ref, String almacen) {
        try {
            iniciarOperacion();
            String hql = "select ap from AlmacenProducto ap left join fetch ap.producto p left join fetch ap.almacen al left join fetch p.formaFarmaceutica ff left join fetch p.presentacion pr left join fetch p.laboratorio lab where p.nombre like '%" + ref + "%' and al.nombre = '" + almacen + "' and ap.stockActual>0 order by p.idproducto, ap.fechaVencimiento asc";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<AlmacenProducto>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } finally {
            sesion.close();
        }
        return list;
    }
    
    public ArrayList<AlmacenProducto> listProductosRef(String ref, String almacen, int op) {
        StringBuilder sql = new StringBuilder();
        try {
            iniciarOperacion();
            sql.append("select ap from AlmacenProducto ap ");
            sql.append("left join fetch ap.producto p left join fetch ap.almacen al ");
            sql.append("left join fetch p.formaFarmaceutica ff left join fetch p.presentacion pr ");
            sql.append("left join fetch p.laboratorio lab ");
            if(op == Constants.BUSQ_X_PRODUCTO){
                sql.append("where p.nombre like concat('%', :ref, '%') ");
            } else if(op == Constants.BUSQ_X_PRINCIPIO_ACTIVO){
                sql.append("where p.principioActivo like concat('%', :ref, '%') ");
            } else if(op == Constants.BUSQ_X_ACCION_FARMACOLOGICA){
                sql.append("where p.accionTerapeutica like concat('%', :ref, '%') ");
            }            
            sql.append("and al.nombre =:almacen ");
            sql.append("and ap.stockActual>=0 order by p.idproducto, ap.fechaVencimiento asc ");            
            Query query = sesion.createQuery(sql.toString());
            query.setParameter("ref", ref);
            query.setParameter("almacen", almacen);
            list = (ArrayList<AlmacenProducto>) query.list();
        } catch (HibernateException e) {
            list=new ArrayList<>();
            manejaExcepcion(e);
        } finally {
            sesion.close();
        }
        return list;
    }

    public ArrayList<AlmacenProducto> listStockxAlmacenProducto(String almacen, String producto) {
        try {
            iniciarOperacion();
            String hql = "select A from AlmacenProducto A left join fetch A.almacen B left join fetch A.producto C left join fetch C.formaFarmaceutica ff left join fetch C.presentacion pr left join fetch C.laboratorio lab where B.nombre like '%" + almacen + "%' and C.nombre like '%" + producto + "%'";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<AlmacenProducto>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } finally {
            sesion.close();
        }
        return list;
    }

    public ArrayList<AlmacenProducto> listXAlmacen(String almacen) {
        StringBuilder hql = new StringBuilder();
        try {
            iniciarOperacion();
            hql.append("from AlmacenProducto ap left join fetch ap.producto p ")
                    .append("left join fetch ap.almacen al ")
                    .append("left join fetch p.formaFarmaceutica ff ")
                    .append("left join fetch p.presentacion pr ")
                    .append("left join fetch p.laboratorio lab ")
                    .append("where ap.almacen.nombre =:almacen ")
                    .append("and ap.stockActual>0 ");
            Query query = sesion.createQuery(hql.toString());
            query.setParameter("almacen", almacen);
            list = (ArrayList<AlmacenProducto>) query.list();
        } catch (HibernateException e) {
            list = new ArrayList<>();
            Mensajes.ErrorFatal(e);
        } finally {
            sesion.close();
        }
        return list;
    }

    public AlmacenProducto buscarProductoxAlmacenyLote(String lote, Almacen almacen, Producto oProducto) {
        StringBuilder hql = new StringBuilder();
        try {
            iniciarOperacion();
            hql.append("from AlmacenProducto ap ")
                    .append("where ap.almacen.nombre = :almacen ")
                    .append("and lote = :lote ")
                    .append("and ap.producto.idproducto = :idprod ");
                    //.append("and ap.stockActual > 0");            
            Query query = sesion.createQuery(hql.toString()).setMaxResults(1);
            query.setParameter("almacen", almacen.getNombre());
            query.setParameter("lote", lote);
            query.setParameter("idprod", oProducto.getIdproducto());
            obj = (AlmacenProducto) query.uniqueResult();
            //tx.commit();

        } catch (HibernateException e) {
            Mensajes.ErrorFatal(e);
            obj = null;
        } finally{
            sesion.close();
        }
        return obj;
    }

    public ArrayList<AlmacenProducto> listarProductosPorVencer(int dias) {
        try {
            iniciarOperacion();
            String hql = "select ap from AlmacenProducto ap inner join ap.producto p inner join ap.almacen a "
                    + "where (current_date < ap.fechaVencimiento and ap.fechaVencimiento-current_date < " + dias + ") and ap.stockActual>0 "
                    + "order by ap.fechaVencimiento asc, a.nombre desc";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<AlmacenProducto>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        return list;
    }

    public ArrayList<AlmacenProducto> listarProductosPorFechaVencimiento(Date fecha) {
        try {
            iniciarOperacion();
            String hql = "select ap from AlmacenProducto ap left join fetch ap.producto p left join fetch ap.almacen a left join fetch p.formaFarmaceutica ff left join fetch p.presentacion pr left join fetch p.laboratorio lab where ap.fechaVencimiento <= '" + Utilitarios.castDate_UTIL_SQL(fecha) + "' and ap.stockActual>0 order by ap.fechaVencimiento asc, a.nombre desc";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<AlmacenProducto>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        return list;
    }

    public List<AlmacenProducto> listarProductosVencidos() {
        List<AlmacenProducto> temp = new ArrayList<>();
        try {
            iniciarOperacion();
            String hql = "select ap from AlmacenProducto ap inner join ap.producto p inner join ap.almacen a "
                    + "where (current_date > ap.fechaVencimiento) and ap.stockActual>0 "
                    + "order by ap.fechaVencimiento asc, a.nombre desc";
            Query query = sesion.createQuery(hql);
            temp = query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        return temp;
    }

    public List<AlmacenProducto> listRef(String ref) {
        try {
            iniciarOperacion();
//            String hql = "select ap from AlmacenProducto ap inner join ap.producto p inner join ap.almacen al where p.nombre like '%"+ref+"%' and al.nombre = '"+almacen+"' and ap.stockActual>0";
            String hql = "select ap from AlmacenProducto ap left join fetch ap.producto p left join fetch ap.almacen al left join fetch p.formaFarmaceutica ff left join fetch p.presentacion pr left join fetch p.laboratorio lab where p.nombre like '%" + ref + "%' and ap.stockActual>0";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<AlmacenProducto>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } finally {
            sesion.close();
        }
        return list;
    }

    public AlmacenProducto buscarxAlmacen(Long idAlmacenproducto, long idAlmacenAfectado) {
        obj = new AlmacenProducto();
        try {
            iniciarOperacion();
            String hql = "from AlmacenProducto ap where ap.almacen.idalmacen = " + idAlmacenAfectado + " and ap.idalmacenproducto = " + idAlmacenproducto;
            Query query = sesion.createQuery(hql).setMaxResults(1);
            obj = (AlmacenProducto) query.uniqueResult();
            tx.commit();
            sesion.close();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Error en busqueda de producto en almacen ... Consulte al Administrador del Sistema \n ID PRODUCTO = " + idAlmacenproducto, "Error Fatal", JOptionPane.ERROR_MESSAGE);
            manejaExcepcion(e);

        }
        return obj;
    }

    public int buscarxAlmacenyIdproducto(long idproducto, long idalmacen) {
        int res = 0;
        try {
            iniciarOperacion();
            String hql = "select max(ap.ordenRegistro) from AlmacenProducto ap where ap.almacen.idalmacen = " + idalmacen + " and ap.producto.idproducto = " + idproducto;
            Query query = sesion.createQuery(hql);
            if (query.uniqueResult() == null) {
                res = 0;
            } else {
                res = (int) query.uniqueResult();
            }
            tx.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en busqueda de producto en almacen ... Consulte al Administrador del Sistema \n ID PRODUCTO = " + idproducto, "Error Fatal", JOptionPane.ERROR_MESSAGE);
        } finally {
            sesion.close();
        }

        return res;

    }

    public AlmacenProducto buscarxIdalmacenproducto(Long idAlmacenproducto) {
        String hql = "from AlmacenProducto a where a.idalmacenproducto = " + idAlmacenproducto;
        return buscar(hql);
    }

    public int ajustar(AlmacenProducto temp, Kardex kardex) {
        int res = -1;
        try {
            iniciarOperacion();
            sesion.update(temp);
            //Registrar kardex
            registrarKardex(temp, kardex);
            tx.commit();
            return SUCCESS;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            return ERROR;
        } finally {
            cerrarSesion();
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

    public void cerrarSesion() {
        sesion.close();
    }

    private void manejaExcepcion(HibernateException he) {
        tx.rollback();
        Mensajes.ErrorFatal(he);
    }

    private void registrarKardex(AlmacenProducto temp, Kardex oKardex) {
        //Kardex oKardex = new Kardex();
        KardexBl oKardexBl = new KardexBl();
        oKardex.setAlmacenByIdOrigen(null);
        oKardex.setAlmacenByIdDestino(null);
        oKardex.setIdFarcomprobante(null);
        oKardex.setOperacion("AJUSTE DE INVENTARIO");
        oKardex.setFechaMov(new Date());
        oKardex.setHoraMov(Utilitarios.horaActual());
        oKardex.setTipoOperacion(oKardex.getCantidad().compareTo(BigDecimal.ZERO) == 1 ? "SALIDA" : "ENTRADA");
        oKardex.setIdAlmacenAfectado(temp.getAlmacen().getIdalmacen());
        oKardex.setComprobante("");
        oKardex.setNumSerie("");
        oKardex.setOrigen("");
        oKardex.setDestino("");
        oKardex.setObservacion(oKardex.getObservacion().trim());
        oKardex.setNumComprobante(0);
        oKardex.setGrupoNumeracion(1);
        oKardex.setIdProducto(Long.parseLong(temp.getProducto().getIdproducto() + ""));
        oKardex.setCantidad(oKardex.getCantidad().abs());
        //Buscar precio actual delcant producto
        PrecioProducto oPrecioProducto = new PrecioProducto();
        PrecioProductoBl oPrecioProductoBl = new PrecioProductoBl();
        oPrecioProducto = oPrecioProductoBl.buscarxIdAlmacenProducto(temp.getIdalmacenproducto());
        if (oPrecioProducto != null) {
            oKardex.setValorUnit(oPrecioProducto.getPvSugerido());
        }
        //fin busqueda de precio actual
        oKardex.setIdAlmacenproducto(temp.getIdalmacenproducto());
        oKardex.setEstado(1);
        //Obtener el ultimo numero de orden de registro de kardex
        long nro = oKardexBl.nroOrdenregistro(oKardex.getIdProducto());
        oKardex.setNroOrden(nro + 1);
        //Obtener stock  actual del producto
        AlmacenProductoBl oAlmacenProductoBl = new AlmacenProductoBl();
        AlmacenProducto ap = oAlmacenProductoBl.buscar(temp.getIdalmacenproducto());
        oKardex.setStockActual(oKardex.getTipoOperacion().equals("ENTRADA") ? ap.getStockActual().add(oKardex.getCantidad()) : ap.getStockActual().subtract(oKardex.getCantidad()));

        //fin
        sesion.save(oKardex);
    }

    public int registrarMovimiento(Almacen origen, Almacen destino, FarComprobante oFarComprobante, Date fechaMov, String perOrigen, String perDestino, String glosa, ModeloVentaProducto oModeloVentaProducto, Usuario userTemp, String numComp) {
        int r = -1;
        try {
            iniciarOperacion();
            for (int i = 0; i < oModeloVentaProducto.getRowCount(); i++) {
                //buscar en almacen por producto y nombre de almacen para su actualizacion y lote y retornar el objeto a actualizar
                DetalleVenta oDetalleVenta = oModeloVentaProducto.get(i);
                //Actualizar stock en origen
                AlmacenProductoBl oAlmacenProductoBl = new AlmacenProductoBl();
                AlmacenProducto oAlmacenProducto = buscarxIdalmacenProducto(oDetalleVenta.getIdAlmacenproducto());
                if (oAlmacenProducto != null) {
                    oAlmacenProducto.setStockActual(oAlmacenProducto.getStockActual().subtract(oDetalleVenta.getCantidadVenta()));
                }
                sesion.update(oAlmacenProducto);
                //actualizar stock en destino
                //se debe buscar por almacen, lote y producto debido a que el producto ya puedee existir en farmacia
                AlmacenProducto oAlmacenProductoDestino = buscarProductoxAlmacenyLote(destino, oDetalleVenta.getLote(), oDetalleVenta.getProducto());
                //System.out.println("almacen producto .........."+oAlmacenProductoDestino.getIdalmacenproducto());
                if (oAlmacenProductoDestino != null) {
                    oAlmacenProductoDestino.setStockActual(oAlmacenProductoDestino.getStockActual().add(oDetalleVenta.getCantidadVenta()));
                    sesion.update(oAlmacenProductoDestino);
                } else {//registrar uno nuevo
                    oAlmacenProductoDestino = new AlmacenProducto();
                    oAlmacenProductoDestino.setProducto(oDetalleVenta.getProducto());
                    oAlmacenProductoDestino.setAlmacen(destino);
                    oAlmacenProductoDestino.setStockActual(oDetalleVenta.getCantidadVenta());
                    oAlmacenProductoDestino.setFechaRegistro(new Date());
                    oAlmacenProductoDestino.setFechaUltAct(new Date());
                    oAlmacenProductoDestino.setEstado(Boolean.TRUE);
                    oAlmacenProductoDestino.setLote(oDetalleVenta.getLote() != null ? oDetalleVenta.getLote() : "");
                    //fecha de vencimiento por lote
                    //buscar en el almacen principal  los datos adicionale del producto
                    AlmacenProducto temp = new AlmacenProducto();
                    //temp = oAlmacenProductoBl.buscarProductoxAlmacenyLote(oDetalleVenta.getLote(), (Almacen) cbxOrigen.getSelectedItem(), oDetalleVenta.getProducto());
                    temp = oAlmacenProductoBl.buscarxIdalmacenproducto(oDetalleVenta.getIdAlmacenproducto());
                    if (temp != null) {
                        oAlmacenProductoDestino.setFechaVencimiento(temp.getFechaVencimiento() != null ? temp.getFechaVencimiento() : null);
                        oAlmacenProductoDestino.setValorCompraUnitario(temp.getValorCompraUnitario());
                        oAlmacenProductoDestino.setPrecioCompraUnitario(temp.getPrecioCompraUnitario());
                    }
                    sesion.save(oAlmacenProductoDestino);
                    //Buscar  el precio del producto de  no existir se proceder a registrar
                    PrecioProductoBl oPrecioProductoBl = new PrecioProductoBl();
                    oPrecioProducto = new PrecioProducto();
                    //oPrecioProducto = oPrecioProductoBl.buscarxIdAlmacenProducto(oDetalleVenta.getIdAlmacenproducto());
                    oPrecioProducto.setAlmacenProducto(oAlmacenProductoDestino);
                    oPrecioProducto.setPvMin(oDetalleVenta.getPvMin());
                    oPrecioProducto.setPvMax(oDetalleVenta.getPvMax());
                    oPrecioProducto.setPvSugerido(oDetalleVenta.getPrecioVenta());
                    oPrecioProducto.setFechaInicio(new Date());
                    oPrecioProducto.setFechaFin(null);
                    oPrecioProducto.setIdUsuario(userTemp.getIdUsuario());
                    oPrecioProducto.setEstado(1);
                    sesion.save(oPrecioProducto);

                }
                //registrar kardex almacen
                //salida de almacen
                Kardex oKardex = new Kardex();
                KardexBl oKardexBl = new KardexBl();
                oKardex.setAlmacenByIdOrigen(origen);
                oKardex.setIdAlmacenAfectado(origen.getIdalmacen());
                oKardex.setAlmacenByIdDestino(destino);

                oKardex.setIdFarcomprobante(oFarComprobante.getIdfarcomprobante());
                oKardex.setTipoOperacion("SALIDA");
                oKardex.setOperacion("DISTRIBUCION");
                oKardex.setFechaMov(new Date());
                oKardex.setHoraMov(Utilitarios.horaActual());
                oKardex.setComprobante(oFarComprobante.getComprobante().trim());
                oKardex.setNumSerie("");
                oKardex.setNumComprobante(Long.parseLong(numComp));
                oKardex.setOrigen(perOrigen);
                oKardex.setDestino(perDestino);
                oKardex.setObservacion(glosa);
                oKardex.setGrupoNumeracion(1);
                oKardex.setIdProducto(Long.parseLong(oDetalleVenta.getProducto().getIdproducto() + ""));
                oKardex.setCantidad(oDetalleVenta.getCantidadVenta());
                //oKardex.setIdAlmacenproducto(oDetalleVenta.getIdAlmacenproducto());
                oKardex.setIdAlmacenproducto(oAlmacenProducto.getIdalmacenproducto());
                oKardex.setValorUnit(BigDecimal.ZERO);
                oKardex.setEstado(1);
                //Obtener el ultimo numero de orden de registro de kardex
                long nro = oKardexBl.nroOrdenregistro(oKardex.getIdProducto());
                oKardex.setNroOrden(nro + 1);
                //obtener el stock actual y restarlo la cantidad de salida
                oAlmacenProductoBl = new AlmacenProductoBl();
                oAlmacenProducto = oAlmacenProductoBl.buscarxAlmacen(oKardex.getIdAlmacenproducto(), oKardex.getIdAlmacenAfectado());
                if (oAlmacenProducto != null) {
                    oKardex.setStockActual(oAlmacenProducto.getStockActual().subtract(oDetalleVenta.getCantidadVenta()));
                }
                sesion.save(oKardex);
                //ingreso a farmacia
                Kardex oKardexIngreso = new Kardex();

                oKardexIngreso.setAlmacenByIdOrigen(origen);
                oKardexIngreso.setIdAlmacenAfectado(destino.getIdalmacen());
                oKardexIngreso.setAlmacenByIdDestino(destino);
                oKardexIngreso.setIdFarcomprobante(oFarComprobante.getIdfarcomprobante());
                oKardexIngreso.setTipoOperacion("ENTRADA");
                oKardexIngreso.setOperacion("DISTRIBUCION");
                oKardexIngreso.setFechaMov(new Date());
                oKardexIngreso.setHoraMov(Utilitarios.horaActual());
                oKardexIngreso.setComprobante(oFarComprobante.getComprobante().trim());
                oKardexIngreso.setNumSerie("");
                oKardexIngreso.setNumComprobante(Long.parseLong(numComp));
                oKardexIngreso.setOrigen(perOrigen);
                oKardexIngreso.setDestino(perDestino);
                oKardexIngreso.setObservacion(glosa);
                oKardexIngreso.setGrupoNumeracion(1);
                oKardexIngreso.setIdProducto(Long.parseLong(oDetalleVenta.getProducto().getIdproducto() + ""));
                oKardexIngreso.setCantidad(oDetalleVenta.getCantidadVenta());
                oKardexIngreso.setValorUnit(BigDecimal.ZERO);
                //oKardexIngreso.setIdAlmacenproducto(oDetalleVenta.getIdAlmacenproducto());
                oKardexIngreso.setIdAlmacenproducto(oAlmacenProductoDestino.getIdalmacenproducto());
                oKardexIngreso.setEstado(1);
                //Obntener el ultimo numero de orden de registro de kardex
                long nro1 = oKardexBl.nroOrdenregistro(oKardexIngreso.getIdProducto());
                oKardexIngreso.setNroOrden(nro1 + 1);
                //obtener el stock actual y sumarle la cantidad de ingreso
                oAlmacenProductoBl = new AlmacenProductoBl();
                //oAlmacenProducto = oAlmacenProductoBl.buscarxAlmacen(oKardexIngreso.getIdAlmacenproducto(), oKardexIngreso.getIdAlmacenAfectado());
                oAlmacenProducto = oAlmacenProductoBl.buscarProductoxAlmacenyLote(oDetalleVenta.getLote(), oKardexIngreso.getAlmacenByIdDestino(), oDetalleVenta.getProducto());
                if (oAlmacenProducto != null) {
                    oKardexIngreso.setStockActual(oAlmacenProducto.getStockActual().add(oDetalleVenta.getCantidadVenta()));
                } else {
                    oKardexIngreso.setStockActual(oKardexIngreso.getCantidad());
                }
                sesion.save(oKardexIngreso);
            }
            tx.commit();
            r = SUCCESS;
        } catch (HibernateException e) {
            manejaExcepcion(e);
            r = ERROR;
        } finally {
            cerrarSesion();
        }
        return r;
    }

    private AlmacenProducto buscarxIdalmacenProducto(long idalmacenproducto) {
        AlmacenProductoBl oAlmacenProductoBl = new AlmacenProductoBl();
        return oAlmacenProductoBl.buscarxIdalmacenproducto(idalmacenproducto);

    }

    private AlmacenProducto buscarProductoxAlmacenyLote(Almacen almacen, String lote, Producto oProducto) {
        AlmacenProductoBl oAlmacenProductoBl = new AlmacenProductoBl();
        return oAlmacenProductoBl.buscarProductoxAlmacenyLote(lote, almacen, oProducto);
    }

    public int registrarInventarioInicial(ModeloAlmacenProductoDTO oModeloAlmacenProductoDTO, Usuario usuario) {
        int r = -1;
        try {
            iniciarOperacion();
            for (int i = 0; i < oModeloAlmacenProductoDTO.getRowCount(); i++) {
                AlmacenProductoDTO ap = oModeloAlmacenProductoDTO.get(i);
                
                AlmacenProducto oAlmacenProducto = new AlmacenProducto();
                oAlmacenProducto.setProducto(ap.getProducto());
                oAlmacenProducto.setAlmacen(ap.getAlmacen());
                oAlmacenProducto.setStockActual(ap.getStockActual());
                oAlmacenProducto.setPrecioCompraUnitario(ap.getPrecioCompraUnit());
                oAlmacenProducto.setFechaRegistro(new Date());
                oAlmacenProducto.setFechaVencimiento(ap.getFechaVencimiento());
                oAlmacenProducto.setLote(ap.getLote());
                sesion.save(oAlmacenProducto);
                
                //Save precio producto
                oPrecioProducto = new PrecioProducto();
                    
                oPrecioProducto.setAlmacenProducto(oAlmacenProducto);
                oPrecioProducto.setPvMin(BigDecimal.ZERO);
                oPrecioProducto.setPvMax(BigDecimal.ZERO);
                oPrecioProducto.setPvSugerido(ap.getPrecioVentaUnit());
                oPrecioProducto.setFechaInicio(new Date());
                oPrecioProducto.setFechaFin(null);
                oPrecioProducto.setIdUsuario(usuario.getIdUsuario());
                oPrecioProducto.setEstado(1);
                sesion.save(oPrecioProducto);                
            }
            tx.commit();
            r = SUCCESS;
            
        } catch (HibernateException e) {
            manejaExcepcion(e);
            r = ERROR;
        }finally{
            cerrarSesion();
        }
        return r;
    }
    
    public List<AlmacenProducto> listByAlmacenAndRef(Almacen almacen, String ref) {
        StringBuilder hql = new StringBuilder();
        List<AlmacenProducto> lista = null;
        try {
            iniciarOperacion();
            hql.append("from AlmacenProducto ap left join fetch ap.producto p ")
                    .append("left join fetch ap.almacen al ")
                    .append("left join fetch p.formaFarmaceutica ff ")
                    .append("left join fetch p.presentacion pr ")
                    .append("left join fetch p.laboratorio lab ")
                    .append("where al.nombre =:almacen ")
                    .append("and p.nombre like :ref ");
                    //.append("and ap.stockActual>0 ");
            Query query = sesion.createQuery(hql.toString());
            query.setParameter("almacen", almacen.getNombre().trim());
            query.setParameter("ref", "%"+ref+"%");
            lista = query.list();
        } catch (HibernateException e) {
            lista = new ArrayList<>();
            Mensajes.ErrorFatal(e);
        } finally {
            sesion.close();
        }
        return lista;
    }

}
