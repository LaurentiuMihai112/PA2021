import App.Entitites.Movie;
import App.Manager;
import App.Repositories.MovieRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMovieByNameTest {
    static EntityManager entityManager;

    @BeforeAll
    public static void createEntityManager() {
        Manager manager = Manager.getInstance();
        entityManager = manager.entityManagerFactory.createEntityManager();
    }

    @Test
    @DisplayName("Find by name should find one movie, the correct one")
    public void testFindById() {
        Movie movie = MovieRepository.findById(11);
        assertEquals(movie.getTitle(), "Monster Hunter");
    }
}
