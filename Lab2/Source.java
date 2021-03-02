import java.util.Arrays;


public abstract class Source {
    private String name;
    private int supply;
    private int[] price;

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    public int[] getPrice() {
        return price;
    }

    public void setPrice(int[] price) {
        this.price = price;
    }

    private SourceType type;

    public Source() {
        this.name = "";
        this.supply = 0;
        this.type = SourceType.NOT_SPECIFIED;
    }

    public Source(String name, int supply, SourceType type) {
        this.name = name;
        this.supply = supply;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Source : " + type + name;
    }

    public Source(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SourceType getType() {
        return type;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return supply == source.supply && name.equals(source.name) && Arrays.equals(price, source.price) && type == source.type;
    }
}
