package db;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Serangga
 */
public class database {
    private static Connection koneksi;
    
    public static Connection getConn() throws SQLException {
        if(koneksi == null) {
            new Driver();
            
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/moxfi","root","");
        }
        
        return koneksi;
    }
}
