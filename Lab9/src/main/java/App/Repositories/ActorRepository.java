package App.Repositories;

import App.Entitites.Actor;
import App.Manager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ActorRepository {
    private static EntityManager entityManager = Manager.getInstance().entityManagerFactory.createEntityManager();

    public static Actor findById(int id) {
        return entityManager.find(Actor.class, id);
    }

    public static Actor findByName(String name) {
        TypedQuery<Actor> query = entityManager.createQuery("SELECT a FROM Actor a where a.name=:title", Actor.class);
        query.setParameter("title", name);
        if (query.getResultList().isEmpty())
            return null;
        return query.getSingleResult();

    }

    public static Actor create(Actor actor) {
        Actor existingActor = findByName(actor.getName());
        if (existingActor == null) {
            entityManager.getTransaction().begin();
            entityManager.persist(actor);
            entityManager.getTransaction().commit();
        }
        return actor;
    }
}
