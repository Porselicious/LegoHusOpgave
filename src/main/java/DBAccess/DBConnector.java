package DBAccess;

/**
 *
 * @author porse
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String IP = "46.101.159.206";
    private static final String PORT = "3306";
    public static final String DATABASE = "Legohus";
    private static final String USERNAME = "rporse";
    private static final String PASSWORD = "August2017";

    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if (singleton == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
            singleton = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return singleton;
    }

}
 