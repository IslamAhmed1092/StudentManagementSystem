package system;

public class Teacher {

    private String id;

    private String name;

    private String email;

    private static long idCounter = 0;

    private String mobileNumber;

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
        this.id = String.valueOf(idCounter++);
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
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

    void viewStudentsAssignedClasses() {

    }

    void getStudentsInCourse(String courseID) {

    }

    void getAllClasses() {

    }

    void getStudentData(String studentId) {

    }

    void addAssignment(Assignment assignment) {

    }

    void submitStudentsAttendance(CourseAttendance[] courseAttendances) {

    }

    @Override
    public String toString() {
        return String.format("Teacher [ID = %s, Name = %s, Email = %s, Mobile Number = %s]", id, name, email, mobileNumber);
    }
}
