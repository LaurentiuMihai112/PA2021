import java.time.LocalTime;

public class Church extends Location implements Visitable {

    public Church(String name, LocalTime openingHour, LocalTime closingHour, String address, int rank, int entryFee) {
        super(name, address, LocationType.CHURCH);
        super.setOpeningHour(openingHour);
        super.setClosingHour(closingHour);
    }

}
