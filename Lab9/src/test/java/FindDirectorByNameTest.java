import App.Entitites.Director;
import App.Manager;
import App.Repositories.DirectorRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindDirectorByNameTest {
    static EntityManager entityManager;

    @BeforeAll
    public static void createEntityManager() {
        Manager manager = Manager.getInstance();
        entityManager = manager.entityManagerFactory.createEntityManager();
    }

    @Test
    @DisplayName("Find by name should find one director, the correct one")
    public void testFindById() {
        Director director = DirectorRepository.findById(13);
        assertEquals("George Miller",director.getName() );
    }
}
