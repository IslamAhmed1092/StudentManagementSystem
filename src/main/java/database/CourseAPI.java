package database;

import model.Course;
import model.CourseAttendance;
import user.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CourseAPI implements ApiServices<Course>{
    private final Database db;

    public CourseAPI() {
        this.db = Database.getInstance();
    }

    public void add(Course course) {
        db.courses.put(course.getId(), course);
    }

    public void remove(String courseID) {
        db.teachers.remove(courseID);
    }

    public Course get(String courseID) {
        Course course = db.courses.get(courseID);

        return (course!=null)? new Course(course) : null;
    }

    public List<Student> getStudentsByCourseID(String courseID) {
        Course course = db.courses.get(courseID);

        if(course == null)
            return new ArrayList<>();
        else {
            List<Student> courseStudents = course.getStudents().stream().map(db.students::get).filter(Objects::nonNull).collect(Collectors.toList());
            return courseStudents.stream().map(Student::new).collect(Collectors.toList());
        }
    }

    public List<Course> getCourses(List<String> ids) {
        List<Course> selectedCourses = ids.stream().map(db.courses::get).filter(Objects::nonNull).collect(Collectors.toList());
        return selectedCourses.stream().map(Course::new).collect(Collectors.toList());
    }

    public List<Course> getAll() {
        return db.courses.values().stream().map(Course::new).collect(Collectors.toList());
    }

    public void update(Course course) {
        if(db.courses.containsKey(course.getId()))
            db.courses.put(course.getId(), course);

    }

    public void submitCourseAttendance(List<CourseAttendance> courseAttendances) {
        db.courseAttendances.addAll(courseAttendances);
    }

}
