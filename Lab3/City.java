import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private int numberOfLocations;
    private List<Location> locationsList;

    public void visitableNotPayableLocations() {

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
        String names="";
        for(Location l:locationsList){
            names=names+l.getName()+" ("+l.getType()+")"+"\n";
        }
        names+="\n\n";
        for(Location l:locationsList){
            names=names+l.getName()+"->"+l.getMyMap()+"\n";
        }
        return names;
    }
}
