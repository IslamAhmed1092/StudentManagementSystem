package system.database;

import system.Admin;
import system.Student;
import system.Teacher;

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
}
