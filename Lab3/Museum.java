import java.time.LocalTime;

public class Museum extends Location implements Visitable, Payable {

    private int entryFee;
    private LocalTime openingHour, closingHour;

    public Museum(String name, LocalTime openingHour, LocalTime closingHour, String address, int rank, int entryFee) {
        super(name, address, LocationType.MUSEUM);
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
