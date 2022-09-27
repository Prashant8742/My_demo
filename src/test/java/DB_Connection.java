import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connection {

    public DB_Connection() throws SQLException {
       String  Server="localhost//SQLEXPRESS01;Database=master;Trusted_Connection=True";
        String dbURL = "jdbc:sqlserver://localhost//sqlexpress;user=sa;password=secret";
        Connection conn = DriverManager.getConnection(dbURL);
        if (conn != null) {
            System.out.println("Connected");
        }


        String user = "sa";
        String pass = "secret";
        conn = DriverManager.getConnection(dbURL, user, pass);
    }
}
