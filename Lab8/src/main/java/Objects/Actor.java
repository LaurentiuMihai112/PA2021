package Objects;

public class Actor {
    String idActor;
    String name;
    static Integer id = 0;

    public Actor(String idActor, String name) {
        this.idActor = idActor;
        this.name = name;
    }

    public Actor(String name) {
        this.idActor = id.toString();
        this.name = name;
        id += 1;
    }

    public String getIdActor() {
        return idActor;
    }

    public String getName() {
        return name;
    }
}
