package App.Repositories;

import App.Entitites.Genre;
import App.Manager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class GenreRepository {
    private static EntityManager entityManager = Manager.getInstance().entityManagerFactory.createEntityManager();

    public static Genre findById(int id) {
        return entityManager.find(Genre.class, id);
    }

    public static Genre findByName(String name) {
        TypedQuery<Genre> query = entityManager.createQuery("SELECT g FROM Genre g where g.name=:title", Genre.class);
        query.setParameter("title", name);
        if (query.getResultList().isEmpty())
            return null;
        return query.getSingleResult();

    }

    public static Genre create(Genre genre) {
        Genre existingGenre = findByName(genre.getName());
        if (existingGenre == null) {
            entityManager.getTransaction().begin();
            entityManager.persist(genre);
            entityManager.getTransaction().commit();
        }
        return genre;
    }
}
