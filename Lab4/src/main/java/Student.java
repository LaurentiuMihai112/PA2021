import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private double score;
    private List<School> ranks = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, double score, List<School> ranks) {
        this.name = name;
        this.score = score;
        this.ranks = ranks;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setRanks(List<School> ranks) {
        this.ranks = ranks;
    }

    public List<School> getRanks() {
        return ranks;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Student other) {
        if (this.score == other.score)
            return 0;
        else if (this.score > other.score)
            return -1;
        return 1;
    }
}