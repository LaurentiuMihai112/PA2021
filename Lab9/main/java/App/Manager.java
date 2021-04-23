package App;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    private static Manager managerInstance = null;
    public EntityManagerFactory entityManagerFactory;

    private Manager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    }

    public static Manager getInstance() {
        if (managerInstance == null) {
            managerInstance = new Manager();
        }
        return managerInstance;
    }
}
