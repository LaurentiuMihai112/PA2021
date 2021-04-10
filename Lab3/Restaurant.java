import java.time.LocalTime;

public class Restaurant extends Location implements Visitable, Payable, Classifiable {

    private int entryFee, rank;

    public Restaurant(String name, LocalTime openingHour, LocalTime closingHour, String address, int rank, int entryFee) {
        super(name, address, LocationType.RESTAURANT);
        super.setOpeningHour(openingHour);
        super.setClosingHour(closingHour);
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


}
