package Objects;

public class Director {
    String idDirector;
    String name;
    static Integer id = 0;

    public Director(String idDirector, String name) {
        this.idDirector = idDirector;
        this.name = name;
    }

    public Director(String name) {
        this.idDirector = id.toString();
        this.name = name;
        id += 1;
    }

    public String getIdDirector() {
        return idDirector;
    }

    public String getName() {
        return name;
    }
}
