import java.time.LocalTime;

public class Restaurant extends Location implements Visitable, Payable, Classifiable {

    private LocalTime openingHour, closingHour;
    private int entryFee, rank;

    public Restaurant(String name, LocalTime openingHour, LocalTime closingHour, String address, int rank, int entryFee) {
        super(name, address, LocationType.RESTAURANT);
    }

    public void setOpeningHour(LocalTime openingHour) {
        this.openingHour = openingHour;
    }

    public void setClosingHour(LocalTime closingHour) {
        this.closingHour = closingHour;
    }

    public void setEntryFee(int entryFee) {
        this.entryFee = entryFee;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public int getEntryFee() {
        return entryFee;
    }

    @Override
    public LocalTime getOpeningHour() {
        return openingHour;
    }

    @Override
    public LocalTime getClosingHour() {
        return closingHour;
    }

}
