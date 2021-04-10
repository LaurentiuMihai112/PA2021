import java.util.List;
import java.util.ListIterator;

public class TravelPlan {
    private final City city;
    private final Location startingLocation;
    private final List<Location> preferences;
    private int[][] distances;
    private final int[] visitedLocation;
    private int visitedLocations = 0;

    public TravelPlan(City city, List<Location> preferences, Location startingLocation) {
        this.preferences = preferences;
        this.city = city;
        this.startingLocation = startingLocation;
        this.visitedLocation = new int[city.getNumberOfLocations()];
    }

    public void floydWarshall() {

        int i, j, k, n = city.getNumberOfLocations();
        int[][] dist = new int[n][n];
        for (Location start : city.getLocationsList()) {
            var distance = start.getMyMap();
            for (Location end : city.getLocationsList()) {
                dist[city.getLocationsList().indexOf(start)][city.getLocationsList().indexOf(end)] = distance.getOrDefault(end, 9999);
            }
        }
        for (k = 0; k < n; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        distances = dist;
    }

    public void printTotalCost() {
        floydWarshall();
        ListIterator<Location> it = preferences.listIterator();
        Location first = startingLocation, second;
        int cost, totalCost = 0;
        while (it.hasNext()) {
            second = it.next();
            cost = distances[city.getLocationsList().indexOf(first)][city.getLocationsList().indexOf(second)];
            System.out.println(first + " -> " + second + " " + cost);
            first = second;
            totalCost += cost;
        }
        System.out.println("Total cost: " + totalCost);
    }

    private Location nextBestLocation(Location current) {
        Location next = null;
        int index = -1;
        int min = 1000;
        int n = city.getNumberOfLocations();
        for (int j = 0; j < n; j++) {
            if (distances[city.getLocationsList().indexOf(current)][j] < min && visitedLocation[j] == 0) {
                index = j;
                min = distances[city.getLocationsList().indexOf(current)][j];
                next = city.getLocationsList().get(j);
            }
        }
        if (index != -1) {
            visitedLocation[index] = 1;
            visitedLocations++;
        }
        return next;
    }

    public void createVisitingPlan(int numberOfDays, int numberOfMinutes) {
        Location current = startingLocation;
        for (int day = 1; day <= numberOfDays; day++) {
            if (visitedLocations == city.getNumberOfLocations()) {
                break;
            }
            System.out.println("Day " + day);
            System.out.println(startingLocation);
            int minutesLeft = numberOfMinutes;
            while (minutesLeft > 0) {
                Location next = nextBestLocation(current);
                if (next == null) {
                    System.out.println(startingLocation);
                    break;
                }
                if (next == startingLocation) {
                    System.out.println(next);
                    break;
                }
                if (minutesLeft - distances[city.getLocationsList().indexOf(current)][city.getLocationsList().indexOf(next)] < 0 && distances[city.getLocationsList().indexOf(current)][city.getLocationsList().indexOf(next)] != 9999) {
                    System.out.println(next);
                    System.out.println(startingLocation);
                    break;
                }
                minutesLeft -= distances[city.getLocationsList().indexOf(current)][city.getLocationsList().indexOf(next)];
                System.out.println(next);
                current = next;
            }
        }
    }
}
