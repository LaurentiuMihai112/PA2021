import DAO_classes.Add;
import DAO_classes.Find;
import DAO_classes.Select;
import Objects.Actor;
import Objects.Director;
import Objects.Genre;
import Objects.Movie;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class MovieManager {
    private final ConnectionDB connectionDB;

    public MovieManager() throws SQLException, IOException {
        connectionDB = ConnectionDB.getInstance();
        /*        generateTables();*/
//        getMovieRealData();
//        System.exit(0);
        printCommands();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(">>> ");
            String command = scanner.nextLine();
            switch (command.toLowerCase()) {
                case "print movies":
                    Select.printAllMovies(connectionDB.connection);
                    break;
                case "print genres":
                    Select.printAllGenres(connectionDB.connection);
                    break;
                case "add movie":
                    Add.addMovie(connectionDB.connection);
                    break;
                case "add genre":
                    Add.addGenre(connectionDB.connection);
                    break;
                case "find movie by id":
                    Find.findMovieById(connectionDB.connection);
                    break;
                case "find genre by id":
                    Find.findGenreById(connectionDB.connection);
                    break;
                case "find movie by name":
                    Find.findMovieByName(connectionDB.connection);
                    break;
                case "find genre by name":
                    Find.findGenreByName(connectionDB.connection);
                    break;
                case "find movies by genre":
                    Find.findMoviesByGenre(connectionDB.connection);
                    break;
                case "help":
                    printCommands();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Not valid");

            }
        }
    }

    private void getMovieRealData() throws IOException, SQLException {
        FileInputStream file = new FileInputStream("F:/Programare Avansata/Lab8/IMDB movies.xls");
        HSSFWorkbook wb = new HSSFWorkbook(file);
        HSSFSheet sheet = wb.getSheetAt(0);

        Integer idGen = 0;
        Map<String, Integer> genresMap = new HashMap<>();
        List<String> actorsList = new ArrayList<>();
        List<String> directorList = new ArrayList<>();

        for (Row row : sheet) {
            if (row.getRowNum() % 500 == 0)
                System.out.println(row.getRowNum());
            Add.addMovie(connectionDB.connection, new Movie(row.getCell(0).toString(), row.getCell(1).toString(), row.getCell(2).toString(), row.getCell(3).toString(), row.getCell(4).toString()));
            String[] genres = row.getCell(5).toString().split(", ");
            var dir = row.getCell(6);
            var act = row.getCell(7);
            if (dir != null) {
                String[] directors = row.getCell(6).toString().split(", ");
                for (var director : directors) {
                    if (!directorList.contains(director)) {
                        Add.addDirector(connectionDB.connection, new Director(director));
                        directorList.add(director);
                    }
                }
            }
            if (act != null) {
                String[] actors = row.getCell(7).toString().split(", ");
                for (var actor : actors) {
                    if (!actorsList.contains(actor)) {
                        Add.addActor(connectionDB.connection, new Actor(actor));
                        actorsList.add(actor);
                    }
                }
            }
            for (var genre : genres) {
                if (!genresMap.containsKey(genre)) {
                    genresMap.put(genre, idGen);
                    Add.addGenre(connectionDB.connection, new Genre(idGen.toString(), genre));
                    Add.addGenreToMovie(connectionDB.connection, row.getCell(0).toString(), idGen);
                    idGen++;
                } else {
                    Add.addGenreToMovie(connectionDB.connection, row.getCell(0).toString(), genresMap.get(genre));
                }
            }
        }
    }


    private void printCommands() {
        System.out.println("print movies\nprint genres\nadd movie\nadd genre\nfind movie by id\nfind genre by id\nfind movie by name\nfind genre by name\nfind movies by genre");
    }

    private void generateTables() throws SQLException {
        Statement statement = connectionDB.connection.createStatement();
        String sql = "CREATE TABLE movies (id varchar2(10) PRIMARY KEY, title VARCHAR2(300) NOT NULL, release_date varchar2(30) ,duration number(4),score number(5))";
        statement.execute(sql);
        sql = "create table genres(id varchar2(10) primary key, name varchar2(30))";
        statement.execute(sql);
        sql = " create table directors(id varchar2(10) primary key, name varchar2(50))";
        statement.execute(sql);
        sql = "create table actors(id varchar2(10) primary key, name varchar2(50))";
        statement.execute(sql);
        sql = " create table movies_to_genres(movie_id varchar2(10), genre_id  varchar2(10))";
        statement.execute(sql);
        sql = "alter table movies_to_genres add foreign key (movie_id) references movies(id)";
        statement.execute(sql);
        sql = "alter table movies_to_genres add foreign key (genre_id) references genres(id)";
        statement.execute(sql);
    }
}
