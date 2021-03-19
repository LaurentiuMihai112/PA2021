package Compulsory.Items;

import Compulsory.Exceptions.InvalidYearException;

import java.time.Year;

public class Movie extends Item {
    Year releaseYear;

    public Movie(String name, String location) {
        super(name, location, ItemType.MOVIE);
    }

    public void setReleaseYear(Integer releaseYear) {
        try {
            if (releaseYear < 0 || releaseYear > 2025)
                throw new InvalidYearException();
            this.releaseYear = Year.of(releaseYear);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
