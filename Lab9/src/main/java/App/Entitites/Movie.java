package App.Entitites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "MOVIES", schema = "STUDENT", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Movie.findByName",
                query = "SELECT m FROM Movie m WHERE m.title=:name")})

public class Movie implements Serializable {
    private int id;
    private String title;
    private String releaseDate;
    private Long duration;
    private Short score;

    @ManyToMany
    @JoinTable(name = "MOVIE_GENRE", joinColumns = {@JoinColumn(name = "movie_id")}, inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    private List<Genre> genres = new ArrayList<>();
    @ManyToMany
    private List<Actor> actors = new ArrayList<>();
    @ManyToMany
    private List<Director> directors = new ArrayList<>();

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "ID", nullable = false, length = 10)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TITLE", nullable = false, length = 300)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "RELEASE_DATE", nullable = true, length = 30)
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "DURATION", nullable = true, precision = 0)
    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "SCORE", nullable = true, precision = 0)
    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }


    public void addGenres(Genre genre) {
        this.genres.add(genre);
    }

    public void removeGenres(Genre genre) {
        this.genres.remove(genre);
    }

    public void AddActors(Actor actor) {
        actors.add(actor);
    }

    public void removeActors(Actor actor) {
        actors.remove(actor);
    }

    public void AddDirectors(Director director) {
        directors.add(director);
    }

    public void removeDirectors(Director director) {
        directors.remove(directors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie that = (Movie) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(releaseDate, that.releaseDate) && Objects.equals(duration, that.duration) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseDate, duration, score);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", duration=" + duration +
                ", score=" + score +
                '}';
    }
}
