import java.time.LocalTime;

public class Park extends Location implements Visitable {

    public Park(String name, LocalTime openingHour, LocalTime closingHour, String address, int rank, int entryFee) {
        super(name, address, LocationType.PARK);
        super.setOpeningHour(openingHour);
        super.setClosingHour(closingHour);
    }


}
