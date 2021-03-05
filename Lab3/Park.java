import java.time.LocalTime;

public class Park extends Location implements Visitable {
    private LocalTime openingHour, closingHour;

    public Park(String name, LocalTime openingHour, LocalTime closingHour, String address, int rank, int entryFee) {
        super(name, address, LocationType.PARK);
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
