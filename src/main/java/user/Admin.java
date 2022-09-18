package user;

import exception.NotFoundException;
import model.Course;
import database.CourseAPI;
import database.StudentAPI;
import database.TeacherAPI;

import java.util.List;

public class Admin extends User {

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
        super(name, email, mobileNumber);

        teacherAPI = new TeacherAPI();
        studentAPI = new StudentAPI();
        courseAPI = new CourseAPI();

    }

    public Admin(Admin other) {
        super(other);
        this.studentAPI = other.studentAPI;
        this.courseAPI = other.courseAPI;
        this.teacherAPI = other.teacherAPI;
    }

    public void addTeacher(String name, String email, String mobileNumber) {
        Teacher teacher = new Teacher(name, email, mobileNumber);
        teacherAPI.add(teacher);
    }

    public void removeTeacher(String teacherID) throws NotFoundException {
        teacherAPI.remove(teacherID);
    }

    public Teacher viewTeacherDetails(String teacherID) throws NotFoundException {
        return teacherAPI.get(teacherID);
    }

    public List<Teacher> viewAllTeachers() {
        return teacherAPI.getAll();
    }

    public void updateTeacherData(Teacher teacher) throws NotFoundException {
        teacherAPI.update(teacher);
    }

    public void addStudent(String name, String email, String mobileNumber, int age, String address, String gender) {
        Student student = new Student(name, email, mobileNumber, age, address, gender);
        studentAPI.add(student);
    }

    public void removeStudent(String studentID) throws NotFoundException {
        studentAPI.remove(studentID);
    }

    public Student viewStudentDetails(String studentID) throws NotFoundException {
        return studentAPI.get(studentID);
    }

    public List<Student> viewAllStudents() {
        return studentAPI.getAll();
    }

    public void updateStudentData(Student student) throws NotFoundException {
        studentAPI.update(student);
    }


    public void addCourse(String name, String teacherId) {
        Course course = new Course(name, teacherId);
        courseAPI.add(course);
    }

    public void removeCourse(String courseID) throws NotFoundException {
        courseAPI.remove(courseID);
    }

    public Course viewCourseDetails(String courseID) throws NotFoundException {
        return courseAPI.get(courseID);
    }

    public List<Course> viewAllCourses() {
        return courseAPI.getAll();
    }

    public void updateCourseData(Course course) throws NotFoundException {
        courseAPI.update(course);
    }


    @Override
    public String toString() {
        return String.format("Admin [ID = %s, Name = %s, Email = %s, Mobile Number = %s]", id, name, email, mobileNumber);
    }
}
