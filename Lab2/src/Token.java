public class Token implements Comparable<Token> {
    Source source;
    Destination destination;
    Integer price;

    /**
     * A token model te price required to deliver an unit of something
     * from a given source to a given location
     */
    public Token(Source source, Destination destination, Integer price) {
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    @Override
    public int compareTo(Token o) {
        return this.price.compareTo(o.price);
    }

    @Override
    public String toString() {
        return "( " + source + "(" + source.getSupply() + ")" + "->" + destination + "(" + destination.getDemand() + ")" + " )=" + price;
    }
}
