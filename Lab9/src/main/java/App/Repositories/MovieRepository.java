package App.Repositories;

import App.Entitites.Movie;
import App.Manager;

import javax.persistence.EntityManager;
import java.util.List;

public class MovieRepository {
    private static EntityManager entityManager = Manager.getInstance().entityManagerFactory.createEntityManager();

    public static Movie findById(int id) {
        return entityManager.find(Movie.class, id);
    }

    public static List findByName(String name) {
         return entityManager.createNamedQuery("Movie.findByName").setParameter("name", name).getResultList();

    }

    public static Movie create(Movie movie) {
        List<Movie> existingMovies = findByName(movie.getTitle());
        if (existingMovies.isEmpty()) {
            entityManager.getTransaction().begin();
            entityManager.persist(movie);
            entityManager.getTransaction().commit();
        }
        return movie;
    }

}
