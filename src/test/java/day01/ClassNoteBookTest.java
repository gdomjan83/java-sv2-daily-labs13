package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {
    ClassNoteBook classNoteBook = new ClassNoteBook();
    Student student1 = new Student(2, "DG");
    Student student2 = new Student(1, "ZA");
    Student student3 = new Student(3, "KKK");
    @BeforeEach
    void init() {

        classNoteBook.addStudent(student1);
        classNoteBook.addStudent(student2);
        classNoteBook.addStudent(student3);
    }

    @Test
    void testAddMark() {
        classNoteBook.addMark(1, 5);
        classNoteBook.addMark(1, 4);
        classNoteBook.addMark(2, 2);

        assertEquals(4, classNoteBook.getStudents().get(student2).get(1));
        assertEquals(2, classNoteBook.getStudents().get(student1).get(0));
    }
}