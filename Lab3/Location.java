import java.time.LocalTime;
import java.util.HashMap;
import java.util.Objects;

public abstract class Location implements Comparable<Location> {
    private HashMap<Location, Integer> myMap = new HashMap<>();
    private String name, address;
    private LocationType type;
    private LocalTime openingHour, closingHour;

    public LocalTime getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    public LocalTime getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
    }

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

    public int compareByOpeningHour(Location other) {
        return (this.openingHour.compareTo(other.openingHour));
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
        return "Location : " + name ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public int compareTo(Location other) {
        if (this.name == null && other.name == null) {
            return 0;
        } else if (this.name == null) {
            return -1;
        } else if (other.name == null) {
            return 1;
        } else {
            return this.name.compareTo(other.name);
        }
    }

}
