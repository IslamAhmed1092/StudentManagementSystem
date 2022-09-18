package database;

import exception.NotFoundException;
import model.Course;
import user.Student;

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

    public void remove(String studentID) throws NotFoundException {
        Student student = db.students.remove(studentID);
        if(student == null) throw new NotFoundException("Student Not Found");
    }

    public Student get(String studentID) throws NotFoundException {
        Student student = db.students.get(studentID);

        if(student == null) throw new NotFoundException("Student Not Found");

        return new Student(student);
    }

    public List<Student> getAll() {
        return db.students.values().stream().map(Student::new).collect(Collectors.toList());
    }

    public void update(Student student) throws NotFoundException {
        if(db.students.containsKey(student.getId()))
            db.students.put(student.getId(), student);
        else
            throw new NotFoundException("Student Not Found");
    }

    public void assignStudentToCourse(String studentID, String courseID) throws NotFoundException {
        Student student = db.students.get(studentID);
        Course course = db.courses.get(courseID);

        if(student == null) throw new NotFoundException("Student Not Found");
        if(course == null) throw new NotFoundException("Course Not Found");


        student.enrollToCourse(courseID);
        course.enrollStudent(studentID);
    }
}
