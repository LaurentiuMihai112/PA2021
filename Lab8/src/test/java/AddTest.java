import DAO_classes.Find;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTest {
    static ConnectionDB connectionDB;

    @BeforeAll
    public static void database() {
        connectionDB = ConnectionDB.getInstance();
    }

    @Test
    @DisplayName("find by id should find the right movie")
    public void testFindMovieDurationById() throws SQLException {
        assertEquals("100", Find.findMovieDurationByIdFixed(connectionDB.connection, "tt0139394"));
        System.out.println("movie with id : tt0139394 should have duration 100");
    }
}
