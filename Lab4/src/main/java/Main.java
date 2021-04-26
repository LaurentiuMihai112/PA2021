import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Problem example = new Problem();
        Solution mySolution = new Solution(example);
        Problem randomProblem = new Problem(10, 100);
        Solution myOtherSolution = new Solution(randomProblem);
        randomProblem.schoolsAcceptable(Arrays.asList(randomProblem.getRandomSchool()));
        randomProblem.studentsAcceptable(randomProblem.getRandomStudent());
    }
}
