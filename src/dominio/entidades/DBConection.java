
package dominio.entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection {
   private static Connection con = null;
   
   public static synchronized Connection iniciarConexion(){
      try{
         if( con == null ){
            String driver="com.mysql.jdbc.Driver"; //el driver varia segun la DB que usemos
            String url="jdbc:mysql://localhost/clinicapilar?autoReconnect=true";
            String pwd="";
            String usr="root";
            Class.forName(driver);
            con = DriverManager.getConnection(url,usr,pwd);
         }
     }
     catch(ClassNotFoundException | SQLException ex){
        ex.printStackTrace();
     }
      
     return con;
   }
}
