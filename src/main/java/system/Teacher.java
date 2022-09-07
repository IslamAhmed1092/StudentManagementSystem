package system;

import system.database.AssignmentAPI;
import system.database.CourseAPI;
import system.database.StudentAPI;

import java.util.List;

public class Teacher {

    private String id;

    private String name;

    private String email;

    private static long idCounter = 0;

    private String mobileNumber;

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
        this.studentAPI = new StudentAPI();
        this.courseAPI = new CourseAPI();
        this.assignmentAPI = new AssignmentAPI();

        this.id = String.valueOf(idCounter++);
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public Teacher(Teacher other) {
        this.id = other.id;
        this.name = other.name;
        this.email = other.email;
        this.mobileNumber = other.mobileNumber;
        this.studentAPI = other.studentAPI;
        this.courseAPI = other.courseAPI;
        this.assignmentAPI = other.assignmentAPI;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void viewStudentsAssignedClasses() {
        List<Student> students = studentAPI.getStudents();

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public List<Student> getStudentsInCourse(String courseID) {
        return courseAPI.getStudentsByCourseID(courseID);
    }

    public List<Course> getAllClasses() {
        return courseAPI.getCourses();
    }

    public Student getStudentData(String studentId) {
        return studentAPI.getStudent(studentId);
    }

    public void addAssignment(Assignment assignment) {
        assignmentAPI.addAssignment(assignment);
    }

    public void submitStudentsAttendance(List<CourseAttendance> courseAttendances) {
        courseAPI.submitCourseAttendance(courseAttendances);
    }

    @Override
    public String toString() {
        return String.format("Teacher [ID = %s, Name = %s, Email = %s, Mobile Number = %s]", id, name, email, mobileNumber);
    }
}
