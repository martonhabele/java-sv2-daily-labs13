package day01;

public class Student implements Comparable<Student> {
    private String studentName;
    private int studentId;

    public Student(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public int compareTo(Student o) {
        return studentId - o.studentId;
    }
}