package system;

public class Student {

    String id;
    String name;
    String email;
    String mobileNumber;
    int age;
    String address;
    String gender;

    public Student(Student other) {
        this.id = other.id;
        this.name = other.name;
        this.email = other.email;
        this.mobileNumber = other.mobileNumber;
        this.age = other.age;
        this.address = other.address;
        this.gender = other.gender;
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

    public void viewEnrolledCourses() {

    }

    public void viewAssignments(String courseID) {

    }

    public void submitAssignment(AssignmentSubmission assignmentSubmission) {

    }
}
