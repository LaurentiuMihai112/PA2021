import java.time.LocalTime;
import java.util.HashMap;
import java.util.Objects;

public abstract class Location implements Comparable {
    private HashMap<Location, Integer> myMap = new HashMap<>();
    private String name, address;
    private LocationType type;

    public Location(String name, String address, LocationType type) {
        this.name = name;
        this.address = address;
        this.type = type;
    }

    public LocationType getType() {
        return type;
    }

    public HashMap<Location, Integer> getMyMap() {
        return myMap;
    }

    public void addToMap(Location location, int cost) {
        myMap.put(location, cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return name.equals(location.name) && Objects.equals(address, location.address);
    }

    @Override
    public String toString() {
        return "Location:" + name + '\'';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public int compareTo(Location other) {
        return this.name.compareTo(other.name);
        //not safe, check if name is null before
    }

}
