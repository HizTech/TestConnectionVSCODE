package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JorgeLPR
 */
public class ConnectionDB {

    private final String DB = "paises";
    private final String URL = "jdbc:mysql://localhost:3306/" + DB
            + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USER = "DBpaises_user";
    private final String PASS = "1234";

    public Connection openConnection() {

        Connection connect = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = (Connection) DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error " + ex.getMessage());
        }

        return connect;
    }

    public boolean closeConnection(Connection connect) {

        boolean condicion = false;

        try {
            connect.close();
            condicion = true;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return condicion;
    
    }
    
}
