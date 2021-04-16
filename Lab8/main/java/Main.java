import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    public static void main(String[] args) {
        try {
            new MovieManager();
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

}