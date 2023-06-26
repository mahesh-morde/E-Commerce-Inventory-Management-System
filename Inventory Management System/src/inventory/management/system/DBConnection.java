package inventory.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    
    Connection c;
    Statement s;
    
    DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorymanagementsystem", "root", "");
            s = c.createStatement();
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
      
        }
    }
}
