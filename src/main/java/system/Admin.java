package system;

import system.database.StudentAPI;
import system.database.TeacherAPI;

public class Admin  {
    private String id;
    private String name;
    private String email;
    private String mobileNumber;

    private static long idCounter = 0;
    private final TeacherAPI teacherAPI;

    public Admin() {
        teacherAPI = new TeacherAPI();

        id = String.valueOf(idCounter++);
        this.name = "";
        this.email = "";
        this.mobileNumber = "";
    }

    public Admin(String name) {
        teacherAPI = new TeacherAPI();

        id = String.valueOf(idCounter++);
        this.name = name;
        this.email = "";
        this.mobileNumber = "";
    }

    public Admin(String name, String email) {
        teacherAPI = new TeacherAPI();

        id = String.valueOf(idCounter++);
        this.name = name;
        this.email = email;
        this.mobileNumber = "";
    }

    public Admin(String name, String email, String mobileNumber) {
        teacherAPI = new TeacherAPI();

        id = String.valueOf(idCounter++);
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    void addTeacher() {

    }

    void removeTeacher() {
    }

    void viewAllTeachers() {
    }

    void viewTeacherDetails() {

    }

    void updateTeacherData() {

    }

    void addStudent() {

    }

    void removeStudent() {

    }

    void viewAllStudents() {

    }

    void viewStudentDetails() {

    }

    void updateStudentData() {

    }

}
