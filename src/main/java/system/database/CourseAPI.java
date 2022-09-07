package system.database;

import system.Course;
import system.Teacher;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CourseAPI {
    private final Database db;

    public CourseAPI() {
        this.db = Database.getInstance();
    }

    public void addCourse(Course course) {
        db.courses.put(course.getId(), course);
    }

    public void removeCourse(String courseID) {
        db.teachers.remove(courseID);
    }

    public Course getCourse(String courseID) {
        Course course = db.courses.get(courseID);

        return (course!=null)? new Course(course) : null;
    }
    public List<Course> getCourses(List<String> ids) {
        List<Course> selectedCourses = ids.stream().map(db.courses::get).filter(Objects::nonNull).collect(Collectors.toList());
        return selectedCourses.stream().map(Course::new).collect(Collectors.toList());
    }

    public List<Course> getCourses() {
        return db.courses.values().stream().map(Course::new).collect(Collectors.toList());
    }

    public void updateCourseData(Course course) {
        if(db.courses.containsKey(course.getId()))
            db.courses.put(course.getId(), course);

    }

}
