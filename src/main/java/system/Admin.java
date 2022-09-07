package system;

import system.database.CourseAPI;
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
    private final StudentAPI studentAPI;
    private final CourseAPI courseAPI;

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
        studentAPI = new StudentAPI();
        courseAPI = new CourseAPI();

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

    public void addStudent(String name, String email, String mobileNumber, int age, String address, String gender) {
        Student student = new Student(name, email, mobileNumber, age, address, gender);
        studentAPI.addStudent(student);
    }

    public void removeStudent(String studentID) {
        studentAPI.removeStudent(studentID);
    }

    public Student viewStudentDetails(String studentID) {
        return studentAPI.getStudent(studentID);
    }

    public List<Student> viewAllStudents() {
        return studentAPI.getStudents();
    }

    public void updateStudentData(Student student) {
        studentAPI.updateStudentData(student);
    }



    public void addCourse(String name, String teacherId) {
        Course course = new Course(name, teacherId);
        courseAPI.addCourse(course);
    }

    public void removeCourse(String courseID) {
        courseAPI.removeCourse(courseID);
    }

    public Course viewCourseDetails(String courseID) {
        return courseAPI.getCourse(courseID);
    }

    public List<Course> viewAllCourses() {
        return courseAPI.getCourses();
    }

    public void updateCoursesData(Course course) {
        courseAPI.updateCourseData(course);
    }


    @Override
    public String toString() {
        return String.format("Admin [ID = %s, Name = %s, Email = %s, Mobile Number = %s]", id, name, email, mobileNumber);
    }
}
