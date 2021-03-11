import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TravelPlan {
    private City city;
    private Location startingLocation;
    private List<Location> preferences = new ArrayList<>();
    private int distances[][];

    public TravelPlan(City city, List<Location> preferences, Location startingLocation) {
        this.preferences = preferences;
        this.city = city;
        this.startingLocation = startingLocation;
    }

    public void floydWarshall() {

        int i, j, k, n = city.getNumberOfLocations();
        int dist[][] = {{0, 10, 50, 0, 0, 0}, {10, 0, 20, 20, 10, 0}, {50, 20, 0, 20, 0, 0}, {0, 20, 20, 0, 30, 10}, {0, 10, 0, 30, 0, 20}, {0, 0, 0, 10, 20, 0}};

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if(dist[i][j]==0)
                    dist[i][j]=100000;
            }
        }
        for (k = 0; k < n; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        distances = dist;

    }

    public void printTotalCost() {
        this.floydWarshall();
        ListIterator<Location> it = preferences.listIterator();
        Location first = startingLocation, second;
        int cost=0,totalCost=0;
        while (it.hasNext()) {
            second = it.next();
            cost=distances[city.getLocationsList().indexOf(first)][city.getLocationsList().indexOf(second)];
            System.out.println(first + " -> " + second + " " + cost);
            first = second;
            totalCost+=cost;
        }
        System.out.println("Total cost: "+totalCost);
    }
}
