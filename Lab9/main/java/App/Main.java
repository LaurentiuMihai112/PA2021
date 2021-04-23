package App;

import App.Entitites.Actor;
import App.Entitites.Director;
import App.Entitites.Genre;
import App.Entitites.Movie;
import App.Repositories.ActorRepository;
import App.Repositories.DirectorRepository;
import App.Repositories.GenreRepository;
import App.Repositories.MovieRepository;

import javax.persistence.EntityManager;

public class Main {


    public static void main(final String[] args) {
        Manager manager = Manager.getInstance();
        Movie movie = new Movie();
        movie.setTitle("Monster Hunter");
        movie.setReleaseDate("10/05/2020");
        movie.setDuration(100L);
        movie.setScore((short) 9);
        Genre genre = new Genre();
        genre.setName("Action");
        movie.addGenres(genre);
        Actor actor = new Actor();
        actor.setName("Charlize Theron");
        Director director = new Director();
        director.setName("George Miller");
        EntityManager entityManager = manager.entityManagerFactory.createEntityManager();
        MovieRepository.create(movie);
        ActorRepository.create(actor);
        DirectorRepository.create(director);
        GenreRepository.create(genre);
        System.out.println(MovieRepository.findByName("Monster Hunter"));
        manager.entityManagerFactory.close();
    }
}