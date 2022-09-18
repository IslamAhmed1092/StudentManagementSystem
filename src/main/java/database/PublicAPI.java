package database;

import model.Course;
import user.Admin;
import user.Student;
import user.Teacher;

public class PublicAPI {

    private final static Database db = Database.getInstance();

    public static Admin getAdmin(String id) {
        Admin admin = db.admins.get(id);

        return (admin != null)? new Admin(admin) : null;
    }

    public static Teacher getTeacher(String id) {
        Teacher teacher = db.teachers.get(id);

        return (teacher!=null)? new Teacher(teacher) : null;
    }

    public static Student getStudent(String id) {
        Student student = db.students.get(id);

        return (student!=null)? new Student(student) : null;
    }

    public static void addAdmin(Admin admin) {
        db.admins.put(admin.getId(), admin);
    }


    public static void addTeacher(Teacher teacher) {
        db.teachers.put(teacher.getId(), teacher);
    }


    public static void addStudent(Student student) {
        db.students.put(student.getId(), student);
    }

    public static void addCourse(Course course) {
        db.courses.put(course.getId(), course);
    }

}
