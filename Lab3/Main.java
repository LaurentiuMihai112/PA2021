import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        City myCity = new City();
        Location v1 = new Hotel("1", LocalTime.of(9, 45, 0), LocalTime.of(10, 30, 0), "a1", 10, 100);
        myCity.addLocation(v1);
        Location v2 = new Museum("2", LocalTime.of(9, 30, 0), LocalTime.of(10, 30, 0), "a2", 10, 100);
        myCity.addLocation(v2);
        Location v3 = new Museum("3", LocalTime.of(10, 30, 0), LocalTime.of(10, 30, 0), "a3", 10, 100);
        myCity.addLocation(v3);
        Location v4 = new Church("4", LocalTime.of(9, 30, 0), LocalTime.of(10, 30, 0), "a4", 10, 100);
        myCity.addLocation(v4);
        Location v5 = new Church("5", LocalTime.of(9, 15, 0), LocalTime.of(10, 30, 0), "a5", 10, 100);
        myCity.addLocation(v5);
        Location v6 = new Restaurant("6", LocalTime.of(9, 30, 0), LocalTime.of(10, 30, 0), "a6", 10, 100);
        myCity.addLocation(v6);

        v1.addToMap(v2, 10);
        v1.addToMap(v3, 50);
        v2.addToMap(v3, 20);
        v2.addToMap(v4, 20);
        v2.addToMap(v5, 10);
        v3.addToMap(v2, 20);
        v3.addToMap(v4, 20);
        v4.addToMap(v5, 30);
        v4.addToMap(v6, 10);
        v5.addToMap(v4, 30);
        v5.addToMap(v6, 20);
        v6.addToMap(v1, 30);

        System.out.println(myCity);
        myCity.visitableNotPayableLocations();
        myCity.sortLocations();
        System.out.println(myCity);
        List<Location> myPreferences = new ArrayList<>();
        myPreferences.add(v2);
        myPreferences.add(v4);
        myPreferences.add(v6);
        TravelPlan MyPlan = new TravelPlan(myCity, myPreferences, v1);
        MyPlan.printTotalCost();
        MyPlan.createVisitingPlan(4, 50);
    }
}
