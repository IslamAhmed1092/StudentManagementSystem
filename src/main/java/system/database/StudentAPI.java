package system.database;

import system.Course;
import system.Student;
import system.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentAPI implements ApiServices<Student> {
    private final Database db;

    public StudentAPI() {
        this.db = Database.getInstance();
    }

    public void add(Student student) {
        db.students.put(student.getId(), student);
    }

    public void remove(String studentID) {
        db.students.remove(studentID);
    }

    public Student get(String studentID) {
        Student student = db.students.get(studentID);

        return (student!=null)? new Student(student) : null;
    }

    public List<Student> getAll() {
        return db.students.values().stream().map(Student::new).collect(Collectors.toList());
    }

    public void update(Student student) {
        if(db.students.containsKey(student.getId()))
            db.students.put(student.getId(), student);
    }

    public void assignStudentToCourse(String studentID, String courseID) {
        db.students.get(studentID).enrollToCourse(courseID);
        db.courses.get(courseID).enrollStudent(studentID);
    }
}
