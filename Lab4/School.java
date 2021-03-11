import com.sun.source.tree.Scope;

import java.util.LinkedList;
import java.util.List;

public class School implements Comparable<School> {
    private String name;
    private int capacity;
    private List<Student> preferences = new LinkedList<>();

    public School(String name, int capacity, List<Student> preferences) {
        this.name = name;
        this.capacity = capacity;
        this.preferences = preferences;
    }

    public School(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPreferences(List<Student> preferences) {
        this.preferences = preferences;
    }

    public List<Student> getPreferences() {
        return preferences;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(School other) {
        if (this.capacity == 0 || other.capacity == 0) {
            return this.name.compareTo(other.name);
        } else {
            if (this.capacity == other.capacity)
                return 0;
            else if (this.capacity > other.capacity)
                return 1;
            return -1;
        }

    }
}
