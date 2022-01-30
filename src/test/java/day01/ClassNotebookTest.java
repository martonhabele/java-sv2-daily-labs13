package day01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClassNotebookTest {
    @Test
    void testAddStudents() {
        ClassNotebook classNotebook = new ClassNotebook();
        Student student = new Student("John", 1);
        classNotebook.addStudent(student);

        assertEquals(1, classNotebook.getNotebook().size());
        assertTrue(classNotebook.getNotebook().containsKey(student));
    }

    @Test
    void testAddMark() {
        ClassNotebook classNotebook = new ClassNotebook();
        Student s1 = new Student("Jack", 3);
        Student s2 = new Student("John", 1);
        Student s3 = new Student("Jill", 2);
        classNotebook.addStudent(s1);
        classNotebook.addStudent(s2);
        classNotebook.addStudent(s3);

        classNotebook.addMark(1, 5);
        assertEquals(5, classNotebook.getNotebook().get(s2).get(0));
    }
}