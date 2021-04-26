import App.Entitites.Actor;
import App.Manager;
import App.Repositories.ActorRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindActorByNameTest {
    static EntityManager entityManager;

    @BeforeAll
    public static void createEntityManager() {
        Manager manager = Manager.getInstance();
        entityManager = manager.entityManagerFactory.createEntityManager();
    }

    @Test
    @DisplayName("Find by name should find one actor,the correct one")
    public void testFindById() {
        Actor actor = ActorRepository.findById(12);
        assertEquals( "Charlize Theron",actor.getName());
    }
}
