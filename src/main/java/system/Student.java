package system;

import system.database.CourseAPI;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String id;
    private String name;
    private String email;
    private String mobileNumber;
    private int age;
    private String address;
    private String gender;

    private List<String> enrolledCourses;
    private static long idCounter = 0;

    private final CourseAPI courseAPI;


    public Student(String name, String email, String mobileNumber, int age, String address, String gender) {
        this.id = String.valueOf(idCounter++);
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.address = address;
        this.gender = gender;
        enrolledCourses = new ArrayList<>();

        courseAPI = new CourseAPI();
    }


    @SuppressWarnings({"IncompleteCopyConstructor"})
    public Student(Student other) {
        this.id = other.id;
        this.name = other.name;
        this.email = other.email;
        this.mobileNumber = other.mobileNumber;
        this.age = other.age;
        this.address = other.address;
        this.gender = other.gender;
        this.enrolledCourses = new ArrayList<>(other.enrolledCourses);
        this.courseAPI = new CourseAPI();
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

    public void viewAssignments(String courseID) {

    }

    public void submitAssignment(AssignmentSubmission assignmentSubmission) {

    }


    // ADD enrolled courses to the print
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
        sb.append("]");

        return sb.toString();
    }
}
