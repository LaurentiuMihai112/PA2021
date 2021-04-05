package sample;

public class Token {
    public int firstNumber, secondNumber, value;

    public Token(int firstNumber, int secondNumber, int value) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + firstNumber + ',' + secondNumber + ") -> " + value;
    }
}
