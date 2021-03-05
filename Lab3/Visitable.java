import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {

    default LocalTime getOpeningHour() {
        return LocalTime.of(9, 30, 0);
    }

    default LocalTime getClosingHour() {
        return LocalTime.of(20, 0, 0);
    }

    static Duration getVisitingDuration(LocalTime openingHour, LocalTime closingHour) {
        return Duration.between(openingHour, closingHour);
    }
}
