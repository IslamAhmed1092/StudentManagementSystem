package system.database;

import system.Student;
import system.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentAPI {
    private final Database db;

    public StudentAPI() {
        this.db = Database.getInstance();
    }

    public void addStudent(Student student) {
        db.students.put(student.getId(), student);
    }

    public void removeStudent(String studentID) {
        db.students.remove(studentID);
    }

    public Student getStudent(String studentID) {
        Student student = db.students.get(studentID);

        return (student!=null)? new Student(student) : null;
    }

    public List<Student> getStudents() {
        return db.students.values().stream().map(Student::new).collect(Collectors.toList());
    }

    public void updateStudentData(Student student) {
        if(db.students.containsKey(student.getId()))
            db.students.put(student.getId(), student);
    }

}
