public class Destination {
    private String name;
    private int demand;

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public Destination(String name, int demand) {
        this.name = name;
        this.demand = demand;
    }

    public Destination() {
        this.demand = 0;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : ";
    }

    public void setName(String name) {
        this.name = name;
    }

    public Destination(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return demand == that.demand && name.equals(that.name);
    }
}
