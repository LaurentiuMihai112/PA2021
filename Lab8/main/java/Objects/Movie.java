package Objects;

public class Movie {
    private String idMovie;
    private String title;
    private String date;
    private String duration;
    private String rating;
    private static Integer id = 0;

    public Movie(String idMovie, String title, String date, String duration, String rating) {
        this.idMovie = idMovie;
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.rating = rating;
    }

    public Movie(String title, String date, String duration, String rating) {
        id++;
        this.idMovie = id.toString();
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.rating = rating;
    }

    public String getIdMovie() {
        return idMovie;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDuration() {
        return duration;
    }

    public String getRating() {
        return rating;
    }
}
