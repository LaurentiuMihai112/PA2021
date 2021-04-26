
public class Main {
    public static void main(String[] args) {

        Problem firstProblem = new Problem();
        System.out.println(firstProblem);
        Solution firstSolution = new Solution(firstProblem);
        firstSolution.greedyAlgorithm();

        Problem secondProblem = new Problem(30,30);
        System.out.println(secondProblem);
        Solution secondSolution = new Solution(secondProblem);
        secondSolution.minimalSolution();

/*        Problem thirdProblem = new Problem(10);
        Factory factory1 = new Factory("F1", 100);
        thirdProblem.addSource(factory1);
        thirdProblem.addSource(factory1);*/
    }
}
