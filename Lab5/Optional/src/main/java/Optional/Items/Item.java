package Optional.Items;

import java.io.Serializable;

public abstract class Item implements Serializable {
    private Integer id;
    private static Integer number = 0;
    private String name;
    private String location;
    private ItemType type;

    public Item(String name, String location, ItemType type) {
        this.id = number;
        number++;
        this.name = name;
        this.location = location;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type + " : " + id + " " + name + " " + location;
    }
}
