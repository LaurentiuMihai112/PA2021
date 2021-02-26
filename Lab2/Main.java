
public class Main {
    public static void main(String[] args) {
        Problem p1 = new Problem();

        System.out.println(p1);
        p1.solution();

        Problem p2 = new Problem(100, 100);
        System.out.println(p2);
        p2.solution();
    }
}
