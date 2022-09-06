package system.database;

import system.Teacher;

import java.util.*;
import java.util.stream.Collectors;

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
        Teacher teacher = db.teachers.get(teacherID);

        return (teacher!=null)? new Teacher(teacher) : null;
    }
    public List<Teacher> getTeachers() {
        return db.teachers.values().stream().map(Teacher::new).collect(Collectors.toList());
    }

    public void updateTeacherData(Teacher teacher) {
        if(db.teachers.containsKey(teacher.getId()))
            db.teachers.put(teacher.getId(), teacher);

    }

}
