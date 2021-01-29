package lissa.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lissa.be.FondoPrevisionTemp;
import lissa.ds.ConectorBesterp;
import lissa.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FondoSolidaridadTempDao {

    private Session sesion;
    private Transaction tx;
    private FondoPrevisionTemp obj;
    ArrayList<FondoPrevisionTemp> listfp;
    ResultSet rs;
    ConectorBesterp connBest;

    public ArrayList<FondoPrevisionTemp> listar(int id) {
        ArrayList<FondoPrevisionTemp> list = null;
        try {
            iniciarOperacion();
            String hql = "from FondoPrevisionTemp";
            Query query = sesion.createQuery(hql);
            list = (ArrayList<FondoPrevisionTemp>) query.list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        } finally {
            sesion.close();
        }
        return list;
    }

//    public ArrayList<FondoPrevisionTemp> buscarXDni(String ref) {
//        ArrayList<FondoPrevisionTemp> list = null;
//        try {
//            iniciarOperacion();
//            list = (ArrayList<FondoPrevisionTemp>) sesion.createQuery("from FondoPrevisionTemp fst where fst.numDoc like '%" + ref + "%'").list();
//        } catch (HibernateException e) {
//            manejaExcepcion(e);
//        }
//        tx.commit();
//        return list;
//    }
    public FondoPrevisionTemp buscarXDni(String ref) {
        try {
            iniciarOperacion();
            String hql = "from FondoPrevisionTemp fst where fst.numDoc='" + ref + "'";
            Query query = sesion.createQuery(hql);
            obj = (FondoPrevisionTemp) query.uniqueResult();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        tx.commit();
        return obj;
    }

    public ArrayList<FondoPrevisionTemp> buscarXCodSocio(String ref) {
        ArrayList<FondoPrevisionTemp> list = null;
        try {
            iniciarOperacion();
            list = (ArrayList<FondoPrevisionTemp>) sesion.createQuery("from FondoPrevisionTemp fst where fst.codSocio like '%" + ref + "%'").list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        tx.commit();
        return list;

    }

    public ArrayList<FondoPrevisionTemp> buscarXNombres(String ref) {
        ArrayList<FondoPrevisionTemp> list = null;
        try {
            iniciarOperacion();
            list = (ArrayList<FondoPrevisionTemp>) sesion.createQuery("from FondoPrevisionTemp fst where (fst.apePaterno || ' ' || "
                    + "fst.apeMaterno || ' ' || fst.nombres) like '%" + ref + "%'").list();
        } catch (HibernateException e) {
            manejaExcepcion(e);
        }
        tx.commit();
        return list;
    }

    public ArrayList<FondoPrevisionTemp> buscarBesterpXDni(String dni) {
        connBest = new ConectorBesterp();
        listfp = new ArrayList<>();
        try {
            rs = connBest.LeerBesterpFondoPrevisionDNI(dni);
            if (rs != null) {
                while ((rs.next())) {
                    obj = new FondoPrevisionTemp();
                    obj.setNombres(rs.getString("NOMTER1"));
                    obj.setApePaterno(rs.getString("APEPATERNO"));
                    obj.setApeMaterno(rs.getString("APEMATERNO"));
                    obj.setNumDoc(rs.getString("NRODOCDEF"));
                    obj.setCodSocio(rs.getString("NUMTERREMOTO"));
                    obj.setFechaUltimoPago(rs.getDate("FECDOC"));
                    obj.setImportePago(new BigDecimal(rs.getString("MTODOC")));
                    listfp.add(obj);

                }
                connBest.CerrarConexion();
            } else {
                System.out.println("ERROR DE RS - NO EXISTE RESULTADO");
            }

        } catch (SQLException ex) {
            Logger.getLogger(FondoSolidaridadTempDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listfp;
    }

    public ArrayList<FondoPrevisionTemp> buscarBesterpXCodSocio(String codSocio) {
        connBest = new ConectorBesterp();
        listfp = new ArrayList<>();
        try {
            rs = connBest.LeerBesterpFondoPrevisionSoc(codSocio);
            while ((rs.next())) {
                obj = new FondoPrevisionTemp();
                obj.setNombres(rs.getString("NOMTER1"));
                obj.setApePaterno(rs.getString("APEPATERNO"));
                obj.setApeMaterno(rs.getString("APEMATERNO"));
                obj.setNumDoc(rs.getString("NRODOCDEF"));
                obj.setCodSocio(rs.getString("NUMTERREMOTO"));
                obj.setFechaUltimoPago(rs.getDate("FECDOC"));
                obj.setImportePago(new BigDecimal(rs.getString("MTODOC")));
                listfp.add(obj);

            }
            connBest.CerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(FondoSolidaridadTempDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listfp;
    }

    private void iniciarOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }

}
