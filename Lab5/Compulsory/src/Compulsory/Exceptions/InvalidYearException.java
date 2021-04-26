package Compulsory.Exceptions;

public class InvalidYearException extends Exception {
    public InvalidYearException() {
        super("Year must not be negative or too far in the future");
    }
}
