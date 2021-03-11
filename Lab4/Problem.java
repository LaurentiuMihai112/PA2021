
import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;


public class Problem {
    protected List<Student> studentsList = new LinkedList<>();
    protected TreeSet<School> schoolsSet = new TreeSet<>();
    protected Map<Student, List<School>> studentsPreferences = new HashMap<>();
    protected Map<School, List<Student>> schoolPreferences = new HashMap<>();

    /**
     * implements the objects in the example
     */
    public Problem() {
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[]::new);
        students[0].setScore(10);
        students[1].setScore(9.5);
        students[2].setScore(9.2);
        students[3].setScore(8.9);
        var schools = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new School("H" + i))
                .toArray(School[]::new);
        schools[0].setCapacity(1);
        schools[1].setCapacity(2);
        schools[2].setCapacity(2);

        students[0].setRanks(Arrays.asList(schools[0], schools[1], schools[2]));
        students[1].setRanks(Arrays.asList(schools[0], schools[1], schools[2]));
        students[2].setRanks(Arrays.asList(schools[0], schools[1]));
        students[3].setRanks(Arrays.asList(schools[0], schools[2]));

        schools[0].setPreferences(Arrays.asList(students[3], students[0], students[1], students[2]));
        schools[1].setPreferences(Arrays.asList(students[0], students[2], students[1]));
        schools[2].setPreferences(Arrays.asList(students[0], students[1], students[3]));

        studentsList.addAll(Arrays.asList(students));
        schoolsSet.addAll(Arrays.asList(schools));
        for (Student student : studentsList) {
            studentsPreferences.put(student, student.getRanks());
        }
        for (School school : schoolsSet) {
            schoolPreferences.put(school, school.getPreferences());
        }
        System.out.println("The students are: ");
        System.out.println(studentsList);
        System.out.println("Their preferences are: ");
        System.out.println(studentsPreferences);
        System.out.println("The schools are: ");
        System.out.println(schoolsSet);
        System.out.println("Their preferences are: ");
        System.out.println(schoolPreferences);
    }

    public Problem(int numberOfSchools, int numberOfStudents) {
        Faker faker = new Faker();
        Random value = new Random();
        var students = IntStream.rangeClosed(0, numberOfStudents - 1)
                .mapToObj(i -> new Student(faker.name().name()))
                .toArray(Student[]::new);
        for (var student : students) {
            float score = value.nextFloat() * 10;
            if (score < 5)
                score += 2;
            student.setScore(score);
        }
        var schools = IntStream.rangeClosed(0, numberOfSchools - 1)
                .mapToObj(i -> new School(faker.name().lastName() + " High School"))
                .toArray(School[]::new);
        for (var school : schools) {
            school.setCapacity(value.nextInt(numberOfStudents/numberOfSchools)*2);
        }
        for (var student : students) {
            List<School> pref = new ArrayList<>();
            for (var school : schools) {
                double probability = value.nextDouble();
                if (probability <= 0.5) {
                    pref.add(school);
                }
            }
            student.setRanks(pref);
        }
        studentsList.addAll(Arrays.asList(students));
        schoolsSet.addAll(Arrays.asList(schools));
        for (Student student : studentsList) {
            studentsPreferences.put(student, student.getRanks());
        }
        System.out.println("The students are: ");
        System.out.println(studentsList);
        System.out.println("Their preferences are: ");
        System.out.println(studentsPreferences);
        System.out.println("The schools are: ");
        System.out.println(schoolsSet);
    }

}
