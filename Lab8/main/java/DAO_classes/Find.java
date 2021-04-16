package DAO_classes;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Find {
    static public void findGenreById(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ID: ");
        String id = scanner.nextLine();
        Statement statement = connection.createStatement();
        String sql = String.format("SELECT * FROM GENRES WHERE ID='%s'", id);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            System.out.println(result.getString(1) + " " + result.getString(2));
        }
        System.out.println("\n\n");
    }

    static public void findGenreByName(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Genre: ");
        String name = scanner.nextLine();
        Statement statement = connection.createStatement();
        String sql = String.format("SELECT * FROM GENRES WHERE genre='%s'", name);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            System.out.println(result.getString(1) + " " + result.getString(2));
        }
        System.out.println("\n\n");
    }

    static public void findMovieById(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        String id = scanner.nextLine();
        Statement statement = connection.createStatement();
        String sql = String.format("SELECT * FROM MOVIES WHERE ID='%s'", id);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " " + result.getString(4) + " " + result.getString(5));
        }
        System.out.println("\n\n");
    }

    static public void findMovieByName(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Title: ");
        String name = scanner.nextLine();
        Statement statement = connection.createStatement();
        String sql = String.format("SELECT * FROM MOVIES WHERE title='%s'", name);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " " + result.getString(4) + " " + result.getString(5));
        }
        System.out.println("\n\n");
    }

    static public String findMovieDurationByIdFixed(Connection connection, String id) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = String.format("select duration from movies where id='%s'", id);
        System.out.println(sql);
        ResultSet result = statement.executeQuery(sql);
        System.out.println("Aici");
        while (result.next()) {
            System.out.println(result.getString(1));
        }
        System.out.println();
        return null;
    }

    public static void findMoviesByGenre(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Genre: ");
        String name = scanner.nextLine();
        String sql = String.format("SELECT M.ID,M.TITLE,M.RELEASE_DATE,M.DURATION,M.SCORE FROM MOVIES M JOIN MOVIES_TO_GENRES MTG ON M.ID=MTG.MOVIE_ID JOIN GENRES G ON MTG.GENRE_ID=G.ID WHERE G.NAME='%s'",name);
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            System.out.println(result.getString(1) + "\t\t" + result.getString(2) + "\t\t" + result.getString(3) + "\t\t" + result.getString(4) + "\t\t" + result.getString(5));
        }
        System.out.println("\n\n");
    }
}
