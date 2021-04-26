import App.Entitites.Genre;
import App.Manager;
import App.Repositories.GenreRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindGenreByNameTest {
    static EntityManager entityManager;

    @BeforeAll
    public static void createEntityManager() {
        Manager manager = Manager.getInstance();
        entityManager = manager.entityManagerFactory.createEntityManager();
    }

    @Test
    @DisplayName("Find by name should find one genre, the correct one")
    public void testFindById() {
        Genre genre = GenreRepository.findById(14);
        assertEquals( "Action",genre.getName());
    }
}
