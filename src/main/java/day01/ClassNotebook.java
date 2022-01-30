package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ClassNotebook {
    private List<Student> studentList = new ArrayList<>();
    private Map<Student, List<Integer>> notebook = new TreeMap<>();

    public void addStudent(Student student) {
        notebook.put(student, new ArrayList<>());
    }

    public void addMark(int id, int mark) {
        for (Map.Entry<Student, List<Integer>> nb : notebook.entrySet()) {
            if (nb.getKey().getStudentId() == id) {
                nb.getValue().add(mark);
            }
        }
    }

    public Map<Student, List<Integer>> getNotebook() {
        return notebook;
    }
}