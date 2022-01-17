package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ClassNoteBook {
    private Map<Student, List<Integer>> students = new TreeMap<>();

    public ClassNoteBook(Map<Student, List<Integer>> students) {
        this.students = students;
    }

    public Map<Student, List<Integer>> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        if (!students.containsKey(student)) {
            students.put(student, new ArrayList<Integer>());
        }
    }

    public void addMark(int id, int mark) {
        for (Student actual : students.keySet()) {
            if (id == actual.getId()) {
                students.get(id).add(mark);
            }
        }
    }
}
