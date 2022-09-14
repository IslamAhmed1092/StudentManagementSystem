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
        teacherAPI.add(teacher);
    }

    public void removeTeacher(String teacherID) {
        teacherAPI.remove(teacherID);
    }

    public Teacher viewTeacherDetails(String teacherID) {
        return teacherAPI.get(teacherID);
    }

    public List<Teacher> viewAllTeachers() {
        return teacherAPI.getAll();
    }

    public void updateTeacherData(Teacher teacher) {
        teacherAPI.update(teacher);
    }

    public void addStudent(String name, String email, String mobileNumber, int age, String address, String gender) {
        Student student = new Student(name, email, mobileNumber, age, address, gender);
        studentAPI.add(student);
    }

    public void removeStudent(String studentID) {
        studentAPI.remove(studentID);
    }

    public Student viewStudentDetails(String studentID) {
        return studentAPI.get(studentID);
    }

    public List<Student> viewAllStudents() {
        return studentAPI.getAll();
    }

    public void updateStudentData(Student student) {
        studentAPI.update(student);
    }



    public void addCourse(String name, String teacherId) {
        Course course = new Course(name, teacherId);
        courseAPI.add(course);
    }

    public void removeCourse(String courseID) {
        courseAPI.remove(courseID);
    }

    public Course viewCourseDetails(String courseID) {
        return courseAPI.get(courseID);
    }

    public List<Course> viewAllCourses() {
        return courseAPI.getAll();
    }

    public void updateCoursesData(Course course) {
        courseAPI.update(course);
    }


    @Override
    public String toString() {
        return String.format("Admin [ID = %s, Name = %s, Email = %s, Mobile Number = %s]", id, name, email, mobileNumber);
    }
}
