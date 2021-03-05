import java.time.LocalTime;

public class Church extends Location implements Visitable {

    private LocalTime openingHour, closingHour;

    public Church(String name, LocalTime openingHour, LocalTime closingHour, String address, int rank, int entryFee) {
        super(name, address, LocationType.CHURCH);
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
