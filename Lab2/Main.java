
public class Main {
    public static void main(String[] args) {

        Problem firstProblem = new Problem();
        System.out.println(firstProblem);
        Solution firstSolution = new Solution();
        firstSolution.solution(firstProblem);

        Problem secondProblem = new Problem(10, 10);
        System.out.println(secondProblem);
        Solution secondSolution = new Solution();
        secondSolution.solution(secondProblem);

        Problem thirdProblem = new Problem(10);
        Factory factory1 = new Factory("F1", 100);
        thirdProblem.addSource(factory1);
        thirdProblem.addSource(factory1);
        System.out.println(thirdProblem);
        Solution thirdSolution = new Solution();
        secondSolution.solution(thirdProblem);
    }
}
