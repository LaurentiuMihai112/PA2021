package App.Repositories;

import App.Entitites.Movie;
import App.Manager;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class MovieRepository {
    private static EntityManager entityManager = Manager.getInstance().entityManagerFactory.createEntityManager();

    public static Movie findById(int id) {
        return entityManager.find(Movie.class, id);
    }

    public static Movie findByName(String name) {
        TypedQuery<Movie> query = entityManager.createQuery("SELECT m FROM Movie m where m.title=:title", Movie.class);
        query.setParameter("title", name);
        if (query.getResultList().isEmpty())
            return null;
        return query.getSingleResult();

    }

    public static Movie create(Movie movie) {
        Movie existingMovie = findByName(movie.getTitle());
        if (existingMovie == null) {
            entityManager.getTransaction().begin();
            entityManager.persist(movie);
            entityManager.getTransaction().commit();
        }
        return movie;
    }

}
