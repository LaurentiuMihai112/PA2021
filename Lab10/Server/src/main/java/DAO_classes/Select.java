package DAO_classes;

import database.ConnectionDB;
import objects.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
    static public User getUserByName(String name) throws SQLException {
        Connection connection = ConnectionDB.getInstance().connection;
        Statement statement = connection.createStatement();
        String sql = String.format("Select * from users where name='%s'", name);
        ResultSet result = statement.executeQuery(sql);
        if (result.next()) {
            return new User(result.getInt("id"), result.getString("name"));
        }
        return null;
    }

    static public int getIdByName(String name) throws SQLException {
        Connection connection = ConnectionDB.getInstance().connection;
        Statement statement = connection.createStatement();
        String sql = String.format("Select * from users where name='%s'", name);
        ResultSet result = statement.executeQuery(sql);
        if (result.next()) {
            return result.getInt("id");
        }
        return -1;
    }
}
