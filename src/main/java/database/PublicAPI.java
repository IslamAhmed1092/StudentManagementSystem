package database;

import exception.NotFoundException;
import model.Course;
import user.Admin;
import user.Student;
import user.Teacher;

public class PublicAPI {

    private final static Database db = Database.getInstance();

    public static Admin getAdmin(String id) throws NotFoundException {
        Admin admin = db.admins.get(id);

        if(admin == null) throw new NotFoundException("Admin not found");

        return new Admin(admin);
    }

    public static Teacher getTeacher(String id) throws NotFoundException {
        Teacher teacher = db.teachers.get(id);

        if(teacher == null) throw new NotFoundException("Teacher Not Found");

        return new Teacher(teacher);
    }

    public static Student getStudent(String id) throws NotFoundException {
        Student student = db.students.get(id);

        if(student == null) throw new NotFoundException("Teacher Not Found");


        return new Student(student);
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
