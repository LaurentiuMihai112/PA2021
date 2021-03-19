package Compulsory.Items;

import Compulsory.Exceptions.InvalidYearException;

import java.time.Year;

public class Song extends Item {

    private Year releaseYear;

    public Song(String name, String location, Integer releaseYear) {
        super(name, location, ItemType.SONG);
        try {
            if (releaseYear < 0 || releaseYear > 2025)
                throw new InvalidYearException();
            this.releaseYear = Year.of(releaseYear);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void setReleaseYear(Integer releaseYear) {

    }
}
