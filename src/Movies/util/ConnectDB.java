
package Movies.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectDB {
     private static final String USERNAME="root";
    private static final String PASSWORD="root";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/movies";
    

    public static Connection conDB() throws SQLException{
            Connection conn  = null;
         try {
          
             Class.forName("com.mysql.cj.jdbc.Driver");
             
                  conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
  
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
         }
               return conn ;
    }
}