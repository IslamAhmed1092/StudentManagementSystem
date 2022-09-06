package system;

import system.database.StudentAPI;
import system.database.TeacherAPI;

import java.util.List;

public class Admin {
    private String id;
    private String name;
    private String email;
    private String mobileNumber;

    private static long idCounter = 0;
    private final TeacherAPI teacherAPI;

    public Admin() {
        this("", "", "");
    }

    public Admin(String name) {
        this(name, "", "");
    }

    public Admin(String name, String email) {
        this(name, email, "");
    }

    public Admin(String name, String email, String mobileNumber) {
        teacherAPI = new TeacherAPI();

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

    public void addTeacher(String name, String email, String mobileNumber) {
        Teacher teacher = new Teacher(name, email, mobileNumber);
        teacherAPI.addTeacher(teacher);
    }

    public void removeTeacher(String teacherID) {
        teacherAPI.removeTeacher(teacherID);
    }

    public Teacher viewTeacherDetails(String teacherID) {
        return teacherAPI.getTeacher(teacherID);
    }

    public List<Teacher> viewAllTeachers() {
        return teacherAPI.getTeachers();
    }

    public void updateTeacherData(Teacher teacher) {
        teacherAPI.updateTeacherData(teacher);
    }

    public void addStudent() {

    }

    public void removeStudent() {

    }

    public void viewAllStudents() {

    }

    public void viewStudentDetails() {

    }

    public void updateStudentData() {

    }

    @Override
    public String toString() {
        return String.format("Admin [ID = %s, Name = %s, Email = %s, Mobile Number = %s]", id, name, email, mobileNumber);
    }
}
