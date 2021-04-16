import static org.junit.jupiter.api.Assertions.assertEquals;

import DAO_classes.Find;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

public class AddTest {
    static ConnectionDB connectionDB;

    @BeforeAll
    public static void database() {
        connectionDB = new ConnectionDB();
    }

    @Test
    @DisplayName("find by id should find the right movie")
    public void testFindMovieDurationById() throws SQLException {
        assertEquals("100", Find.findMovieDurationByIdFixed(connectionDB.connection,"tt0139394"));
        System.out.println("movie with id 0 should have duration 100");
    }
}
