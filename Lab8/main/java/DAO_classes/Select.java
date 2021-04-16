package DAO_classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
    static public void printAllGenres(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM GENRES";
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            System.out.println(result.getString(1) + "\t\t" + result.getString(2));
        }
        System.out.println("\n\n");
    }

    static public void printAllMovies(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM MOVIES";
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            System.out.println(result.getString(1) + "\t\t" + result.getString(2) + "\t\t" + result.getString(3) + "\t\t" + result.getString(4) + "\t\t" + result.getString(5));
        }
        System.out.println("\n\n");
    }
}
