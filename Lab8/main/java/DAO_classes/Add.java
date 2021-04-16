package DAO_classes;

import Objects.Actor;
import Objects.Director;
import Objects.Genre;
import Objects.Movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Add {
    static public void addGenre(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("genre: ");
        String genreName = scanner.nextLine();
        Statement statement = connection.createStatement();
        Genre genre = new Genre(genreName);
        String sql = String.format("INSERT INTO movies VALUES('%s','%s')", genre.getIdGenre(), genre.getGenre());
        System.out.println(sql);
        statement.execute(sql);
    }

    public static void addGenre(Connection connection, Genre genre) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = String.format("Insert into genres values('%s','%s')", genre.getIdGenre(), genre.getGenre());
        statement.execute(sql);
    }

    static public void addMovie(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("release date: ");
        String date = scanner.nextLine();
        System.out.print("Duration: ");
        Integer duration = scanner.nextInt();
        System.out.print("Rating: ");
        Float rating = scanner.nextFloat();
        Movie movie = new Movie(title, date, duration.toString(), rating.toString());
        Statement statement = connection.createStatement();
        String sql = String.format("INSERT INTO movies VALUES('%s','%s','%s',%s,%s)", movie.getIdMovie(), movie.getTitle(), movie.getDate(), movie.getDuration(), movie.getDuration());
        statement.execute(sql);

    }

    static public void addActor(Connection connection, Actor actor) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = String.format("INSERT INTO actors VALUES('%s','%s')", actor.getIdActor(), actor.getName());
        statement.executeQuery(sql);
    }

    static public void addDirector(Connection connection, Director director) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = String.format("INSERT INTO directors VALUES('%s','%s')", director.getIdDirector(), director.getName());
        statement.executeQuery(sql);
    }

    static public void addMovie(Connection connection, Movie movie) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = String.format("INSERT INTO movies VALUES('%s','%s','%s',%s,%s)", movie.getIdMovie(), movie.getTitle(), movie.getDate(), movie.getDuration(), movie.getRating());
        statement.executeQuery(sql);
    }

    public static void addGenreToMovie(Connection connection, String movie, Integer idGen) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = String.format("Insert into movies_to_genres values('%s','%d')", movie, idGen);
        statement.execute(sql);
    }
}
