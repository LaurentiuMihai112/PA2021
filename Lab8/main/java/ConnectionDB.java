import java.sql.*;

public class ConnectionDB {
    final private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    final private String user = "lorenzo";
    final private String pass = "LORENZO";
    public Connection connection;

    public ConnectionDB() {
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
