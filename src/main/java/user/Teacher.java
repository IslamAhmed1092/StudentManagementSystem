package user;

import exception.NotFoundException;
import model.Assignment;
import model.Course;
import model.CourseAttendance;
import database.AssignmentAPI;
import database.CourseAPI;
import database.StudentAPI;

import java.util.List;

public class Teacher extends User {

    private final StudentAPI studentAPI;
    private final CourseAPI courseAPI;
    private final AssignmentAPI assignmentAPI;

    public Teacher() {
        this("", "", "");
    }

    public Teacher(String name) {
        this(name, "", "");
    }

    public Teacher(String name, String email) {
        this(name, email, "");
    }

    public Teacher(String name, String email, String mobileNumber) {
        super(name, email, mobileNumber);
        this.studentAPI = new StudentAPI();
        this.courseAPI = new CourseAPI();
        this.assignmentAPI = new AssignmentAPI();
    }

    public Teacher(Teacher other) {
        super(other);
        this.studentAPI = other.studentAPI;
        this.courseAPI = other.courseAPI;
        this.assignmentAPI = other.assignmentAPI;
    }

    public String getId() {
        return id;
    }

    public void viewStudentsAssignedClasses() {
        List<Student> students = studentAPI.getAll();

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public List<Student> getStudentsInCourse(String courseID) throws NotFoundException {
        return courseAPI.getStudentsByCourseID(courseID);
    }

    public List<Course> getAllClasses() {
        return courseAPI.getAll();
    }

    public Student getStudentData(String studentId) throws NotFoundException {
        return studentAPI.get(studentId);
    }

    public void addAssignment(Assignment assignment) throws NotFoundException {
        assignmentAPI.add(assignment);
    }

    public void submitStudentsAttendance(List<CourseAttendance> courseAttendances) {
        courseAPI.submitCourseAttendance(courseAttendances);
    }

    public void assignStudentToCourse(String studentID, String courseID) throws NotFoundException {
        studentAPI.assignStudentToCourse(studentID, courseID);
    }

    @Override
    public String toString() {
        return String.format("Teacher [ID = %s, Name = %s, Email = %s, Mobile Number = %s]", id, name, email, mobileNumber);
    }
}
