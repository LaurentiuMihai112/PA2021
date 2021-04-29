package DAO_classes;

import database.ConnectionDB;
import objects.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Add {
    static public void addUser(User user) throws SQLException {
        Connection connection = ConnectionDB.getInstance().connection;
        Statement statement = connection.createStatement();
        String sql = String.format("INSERT INTO USERS VALUES(%d,'%s')", user.getId(), user.getName());
        statement.execute(sql);
    }

    static public void addFriend(User user, User friend) throws SQLException {
        Connection connection = ConnectionDB.getInstance().connection;
        Statement statement = connection.createStatement();
        String sql = String.format("INSERT INTO friends VALUES(%d,%d)", user.getId(), friend.getId());
        statement.execute(sql);
        sql = String.format("INSERT INTO friends VALUES(%d,%d)", friend.getId(), user.getId());
        statement.execute(sql);
    }
    public static void addMessage(User user, String message) throws SQLException {
        Connection connection = ConnectionDB.getInstance().connection;
        Statement statement = connection.createStatement();
    }
}
