public class Main {
    public static void main(String[] args) {
        Problem example = new Problem();
        Solution mySolution = new Solution(example);
        Problem randomProblem = new Problem(100, 10000);
        Solution myOtherSolution = new Solution(randomProblem);
    }
}
