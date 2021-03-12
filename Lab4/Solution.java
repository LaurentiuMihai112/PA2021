import java.util.List;

public class Solution {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public Solution(Problem problem) {
        problem.studentsList.sort(Student::compareTo);
        System.out.println("Students ordered by their score:");
        System.out.println(problem.studentsList);
        System.out.println("\nRepartition\n");
        for (Student student : problem.studentsList) {
            List<School> pref = student.getRanks();
            if (student.getScore() >= 5) {
                for (School school : pref) {
                    if (school.getCapacity() != 0) {
                        System.out.format("%s %s %.2f -> %s %s\n",ANSI_GREEN , student ,student.getScore(),school , ANSI_RESET);
                        school.setCapacity(school.getCapacity() - 1);
                        break;
                    }
                }
            }else{
                System.out.format("%s %s %.2f %s\n",ANSI_RED,student,student.getScore(),ANSI_RESET);
            }
        }
    }
}
