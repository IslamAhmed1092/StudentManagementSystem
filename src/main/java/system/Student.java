package system;

import system.database.AssignmentAPI;
import system.database.CourseAPI;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private int age;
    private String address;
    private String gender;

    private List<String> enrolledCourses;

    private final CourseAPI courseAPI;
    private final AssignmentAPI assignmentAPI;


    public Student(String name, String email, String mobileNumber, int age, String address, String gender) {
        super(name, email, mobileNumber);
        this.age = age;
        this.address = address;
        this.gender = gender;
        enrolledCourses = new ArrayList<>();

        courseAPI = new CourseAPI();
        this.assignmentAPI = new AssignmentAPI();
    }


    @SuppressWarnings({"IncompleteCopyConstructor"})
    public Student(Student other) {
        super(other);
        this.age = other.age;
        this.address = other.address;
        this.gender = other.gender;
        this.enrolledCourses = new ArrayList<>(other.enrolledCourses);
        this.courseAPI = new CourseAPI();
        this.assignmentAPI = new AssignmentAPI();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Course> viewEnrolledCourses() {
        return courseAPI.getCourses(enrolledCourses);
    }

    public List<Assignment> viewAssignments(String courseID) {
        return assignmentAPI.getCourseAssignments(courseID);
    }

    public void submitAssignment(AssignmentSubmission assignmentSubmission) {
        assignmentAPI.submitAssignment(assignmentSubmission);
    }


    public void enrollToCourse(String courseID) {
        enrolledCourses.add(courseID);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Student [ID = %s, Name = %s, Email = %s, Mobile Number = %s, Age = %d, Address = %s, Gender = %s, "
                , id, name, email, mobileNumber, age, address, gender));

        sb.append("Enrolled courses = ");

        sb.append("[");
        for (int i = 0; i < enrolledCourses.size(); i++) {
            sb.append(enrolledCourses.get(i));
            if(i != enrolledCourses.size()-1) sb.append(", ");
        }
        sb.append("]]");

        return sb.toString();
    }
}
