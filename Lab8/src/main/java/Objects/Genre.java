package Objects;

public class Genre {
    String idGenre;
    String genre;
    static Integer id = 0;

    public Genre(String genre) {
        id++;
        this.idGenre = id.toString();
        this.genre = genre;
    }

    public Genre(String idGenre, String genre) {
        this.idGenre = idGenre;
        this.genre = genre;
    }

    public String getIdGenre() {
        return idGenre;
    }

    public String getGenre() {
        return genre;
    }
}
