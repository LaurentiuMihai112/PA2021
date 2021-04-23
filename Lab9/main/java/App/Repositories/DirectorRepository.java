package App.Repositories;

import App.Entitites.Director;
import App.Manager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DirectorRepository {
    private static EntityManager entityManager = Manager.getInstance().entityManagerFactory.createEntityManager();

    public static Director findById(int id) {
        return entityManager.find(Director.class, id);
    }

    public static Director findByName(String name) {
        TypedQuery<Director> query = entityManager.createQuery("SELECT d FROM Director d where d.name=:title", Director.class);
        query.setParameter("title", name);
        if (query.getResultList().isEmpty())
            return null;
        return query.getSingleResult();

    }

    public static Director create(Director director) {
        Director existingDirector = findByName(director.getName());
        if (existingDirector == null) {
            entityManager.getTransaction().begin();
            entityManager.persist(director);
            entityManager.getTransaction().commit();
        }
        return director;
    }
}
