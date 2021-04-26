import java.util.Scanner;

public class example {
    static int sum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n *= 3;
        n += Integer.parseInt("10101", 2) + Integer.parseInt("FF", 16);
        n *= 6;
        int result = n;
        while (result > 9) {
            result = sum(result);
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}
