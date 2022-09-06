package system.database;

import system.Teacher;

import java.util.*;

public class TeacherAPI {
    private final Database db;

    public TeacherAPI() {
        this.db = Database.getInstance();
    }

    public void addTeacher(Teacher teacher) {
        db.teachers.put(teacher.getId(), teacher);
    }

    public void removeTeacher(String teacherID) {
        db.teachers.remove(teacherID);
    }

    public Teacher getTeacher(String teacherID) {
        return db.teachers.get(teacherID);
    }
    public List<Teacher> getTeachers() {
        return new ArrayList<>(db.teachers.values());
    }

    public void updateTeacher(String teacherID, String name) {
        Teacher teacher = getTeacher(teacherID);
        if (teacher != null) {
            teacher.setName(name);
            db.teachers.put(teacher.getId(), teacher);
        }
    }

    public void updateTeacher(String teacherID, String name, String email) {
        Teacher teacher = getTeacher(teacherID);
        if (teacher != null) {
            teacher.setName(name);
            teacher.setEmail(email);
            db.teachers.put(teacher.getId(), teacher);
        }
    }

    public void updateTeacher(String teacherID, String name, String email, String mobilePhone) {
        Teacher teacher = getTeacher(teacherID);
        if (teacher != null) {
            teacher.setName(name);
            teacher.setEmail(email);
            teacher.setMobileNumber(mobilePhone);
            db.teachers.put(teacher.getId(), teacher);
        }
    }
}
