package Business.Connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
/**
 *
 * @author 11204974
 */
public class DBDataSource {
    private final static String DB_NAME = "DB_TECNICAS.db";
    private final static String DB_CONN_STRING = "jdbc:sqlite://" + System.getProperty("user.dir") + "/DB/" + DB_NAME;
    private final static String USER_NAME = "";
    private final static String PASSWORD = "";
    private static DataSource dataSource;
    private static Connection connection;
    
    public static Connection connectDB() throws Exception {
        
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection(DB_CONN_STRING, USER_NAME, PASSWORD);
        return connection;
    }
    
    private static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBDataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}