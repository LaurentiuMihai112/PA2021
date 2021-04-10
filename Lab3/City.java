import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private int numberOfLocations;
    private final List<Location> locationsList;

    public void visitableNotPayableLocations() {
        List<Location> newList = new ArrayList<>();
        for (Location location : locationsList) {
            if (location instanceof Visitable && !(location instanceof Payable)) {
                newList.add(location);
            }
        }
        System.out.println("The free visitable locations are:");
        newList.sort(Location::compareByOpeningHour);
        for (Location location : newList) {
            System.out.print(location + " ");
            System.out.println(location.getOpeningHour());
        }
        System.out.println();
    }

    public List<Location> getLocationsList() {
        return locationsList;
    }

    public int getNumberOfLocations() {
        return numberOfLocations;
    }

    public void sortLocations() {
        locationsList.sort(Location::compareTo);
    }

    public City() {
        this.numberOfLocations = 0;
        locationsList = new ArrayList<>();
    }

    public void addLocation(Location myLocation) {
        locationsList.add(myLocation);
        numberOfLocations++;
    }

    @Override
    public String toString() {
        StringBuilder names = new StringBuilder();
        for (Location l : locationsList) {
            names.append(l.getName()).append(" (").append(l.getType()).append(")").append("\n");
        }
        names.append("\n\n");
        for (Location l : locationsList) {
            names.append(l.getName()).append("->").append(l.getMyMap()).append("\n");
        }
        return names.toString();
    }
}
