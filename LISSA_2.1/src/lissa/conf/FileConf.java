package lissa.conf;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;
import lissa.util.Utilitarios;
import lissa.util.UtilitariosFicheros;

public class FileConf {
    public static final int NUEVALINEA=10;
    private InputStreamReader isr;
    private OutputStreamWriter osw;
    private final String NAME_CONF_FILE="lissa.conf";
    private String user;
    private String password;
    private String port;
    private String db;       
    private String ip;    
    private File ftmp;
    
    private String user_db_root;
    private String passworddb_root;
    private String dir_backup_db;
    
    public static String CLIENT_ID="U2lzdGVtYSBkZSBSZWdpc3RybyBDaXZpbCAgLSBUQU1CTw==";
    public static String VENDOR_ID="RURFU1NDTyBTLkEuQy4=";
    
    static {
        CLIENT_ID=UtilitariosFicheros.decodeBASE64Binary(CLIENT_ID);
        VENDOR_ID=UtilitariosFicheros.decodeBASE64Binary(VENDOR_ID);
    }
    
    
    public FileConf(){      
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(FileConf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean loadConf(){
        try {            
            ftmp = new File(Utilitarios.getCurentPath()+File.separator+"conf"+File.separator+NAME_CONF_FILE);               
            isr = new InputStreamReader(new FileInputStream(ftmp));  
            load();           
            isr.close();
            return true;
        }catch (FileNotFoundException ex) {
            //System.err.println(ex);
            return false;
        }catch (IOException ex) {
            //System.err.println(ex);
            return false;
        }catch(Exception ex){
            //System.err.println(ex);
            return false;
        }
    }
    private void load() throws IOException, Exception{               
        String line;  
        while (isr.ready()) {
            line = decodeStringBase64ASSCII(readLine().trim());            
            if(line.startsWith("host=")){
                setHost(getInfoConf(line));                
            }else if(line.startsWith("port=")){
                setPort(getInfoConf(line));                 
            }else if(line.startsWith("db=")){
                setDb(getInfoConf(line));                 
            }else if(line.startsWith("user=")){
                setUser(getInfoConf(line));                 
            }else if(line.startsWith("password=")){
                setPassword(getInfoConf(line)); 
            }else if(line.startsWith("user_db_root=")){
                setUser_db_root(getInfoConf(line)); 
            }else if(line.startsWith("passworddb_root=")){
                setPassword_db_root(getInfoConf(line));
            }else if(line.startsWith("dir_backup_db=")){
                setDir_backup_db(getInfoConf(line));                  
                ftmp.delete();
                ftmp=null;
            }else{
              throw new Exception("Error de Sintaxis Archivo Erroneo");
            }          
        }
    }
    private String readLine() throws IOException{
        String aux="";
        boolean fl = false;
        while (isr.ready() && !fl) {
           int cr = isr.read();
            if (cr!=NUEVALINEA) {
              aux+=(char)cr;
            } else {
               fl=true;
            }
        }
      return aux;
    }    
    private String getInfoConf(String inf){
       String tmpinf;
       int ps;
       ps = inf.indexOf("=");
       tmpinf=inf.substring(ps+1,inf.length());
        return tmpinf;
    }
   
    public void saveConf(){
        try {        
            ftmp = new File("conf");
            if (!ftmp.exists()) {
               ftmp.mkdir(); 
            }
            ftmp = new File(Utilitarios.getCurentPath()+File.separator+"conf"+File.separator+NAME_CONF_FILE);
            osw = new OutputStreamWriter(new FileOutputStream(ftmp));
            save();
            osw.close();
            ftmp=null;
        } 
        catch (FileNotFoundException ex) {}
        catch (IOException ex) {}
    }
    private void save() throws IOException{
      osw.write(encodeStringASSCIIBase64("host="+getHost()) +"\n");      
      osw.write(encodeStringASSCIIBase64("port="+getPort()) +"\n");
      osw.write(encodeStringASSCIIBase64("db="+getDb()) +"\n");
      osw.write(encodeStringASSCIIBase64("user="+getUser()) +"\n");
      osw.write(encodeStringASSCIIBase64("password="+getPassword())+"\n");
      osw.write(encodeStringASSCIIBase64("user_db_root="+getUser_db_root())+"\n");
      osw.write(encodeStringASSCIIBase64("passworddb_root="+getPassword_db_root())+"\n");
      osw.write(encodeStringASSCIIBase64("dir_backup_db="+getDir_backup_db())+"\n");       
    }

    
    public String encodeStringASSCIIBase64(String ref){    
       return DatatypeConverter.printBase64Binary(ref.getBytes());
    }
    public String decodeStringBase64ASSCII(String ref){
       return new String(DatatypeConverter.parseBase64Binary(ref));
    }
    public String getUser() {
        return user.trim();
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password.trim();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port.trim();
    }

    public void setPort(String port) {
        this.port = port;
    }
    
    public String getHost() {
        return ip.trim();
    }

    public void setHost(String ip) {
        this.ip = ip;
    }

    public String getDb() {
        return db.trim();
    }

    public void setDb(String db) {
        this.db = db;
    }
    
    @Override
    public String toString(){
      return "\nHost : "+getHost()
            +"\nPort : "+getPort()
            +"\nDb : "+getDb()
            +"\nUser : "+getUser()
            +"\nPass : "+getPassword()
            +"\nUser Root : "+getUser_db_root()
            +"\nPass Root : "+getPassword_db_root()
            +"\nDB BackUp Dir : "+getDir_backup_db();
    }

    public String getUser_db_root() {
        return user_db_root;
    }

    public void setUser_db_root(String user_db_root) {
        this.user_db_root = user_db_root;
    }

    public String getPassword_db_root() {
        return passworddb_root;
    }

    public void setPassword_db_root(String passworddb_root) {
        this.passworddb_root = passworddb_root;
    }

    public String getDir_backup_db() {
        return dir_backup_db;
    }

    public void setDir_backup_db(String dir_backup_db) {
        this.dir_backup_db = dir_backup_db;
    }
    public static void main(String[] args) {
        /*System.out.println(new SirecConf().decodeStringBase64ASSCII("aG9zdD0xOTIuMTY4LjEuMjEy"));
        System.out.println(new SirecConf().decodeStringBase64ASSCII("cG9ydD01NDMy"));
        System.out.println(new SirecConf().decodeStringBase64ASSCII("ZGI9bXVuaWNpcGlv"));
        System.out.println(new SirecConf().decodeStringBase64ASSCII("dXNlcj1zeXNtdW5p"));
        System.out.println(new SirecConf().decodeStringBase64ASSCII("cGFzc3dvcmQ9c3lzbXVuaWFkbWluMjAxMg=="));
        System.out.println(new SirecConf().decodeStringBase64ASSCII("dXNlcl9kYl9yb290PXBvc3RncmVz"));
        System.out.println(new SirecConf().decodeStringBase64ASSCII("cGFzc3dvcmRkYl9yb290PXNpcmVjYWRtaW4yMDEy"));
        System.out.println(new SirecConf().decodeStringBase64ASSCII("ZGlyX2JhY2t1cF9kYj1EOlxiYWNrdXBfZGF0YV9yZWdpc3Ryb19jaXZpbA=="));
        System.out.println(new SirecConf().decodeStringBase64ASSCII(""));*/
        System.out.println(FileConf.CLIENT_ID+" - "+FileConf.VENDOR_ID);
        
    }
}
