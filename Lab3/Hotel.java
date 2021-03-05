import java.time.LocalTime;

public class Hotel extends Location implements Visitable, Payable, Classifiable {
    private int entryFee, rank;
    private LocalTime openingHour, closingHour;

    public Hotel(String name, LocalTime openingHour, LocalTime closingHour, String address, int rank, int entryFee) {
        super(name, address, LocationType.HOTEL);
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
