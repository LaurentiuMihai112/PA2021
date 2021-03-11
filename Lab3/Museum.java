import java.time.LocalTime;

public class Museum extends Location implements Visitable, Payable {

    private int entryFee;

    public Museum(String name, LocalTime openingHour, LocalTime closingHour, String address, int rank, int entryFee) {
        super(name, address, LocationType.MUSEUM);
        super.setOpeningHour(openingHour);
        super.setClosingHour(closingHour);
    }

    @Override
    public int getEntryFee() {
        return entryFee;
    }

}
