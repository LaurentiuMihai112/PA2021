package Optional.Items;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Item> items = new ArrayList<>();

    public Catalog() {
    }

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item findById(Integer id) {
        return items.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

}
