package system.database;

import system.Teacher;

import java.util.*;
import java.util.stream.Collectors;

public class TeacherAPI implements ApiServices<Teacher>{
    private final Database db;

    public TeacherAPI() {
        this.db = Database.getInstance();
    }

    public void add(Teacher teacher) {
        db.teachers.put(teacher.getId(), teacher);
    }

    public void remove(String teacherID) {
        db.teachers.remove(teacherID);
    }

    public Teacher get(String teacherID) {
        Teacher teacher = db.teachers.get(teacherID);

        return (teacher!=null)? new Teacher(teacher) : null;
    }
    public List<Teacher> getAll() {
        return db.teachers.values().stream().map(Teacher::new).collect(Collectors.toList());
    }

    public void update(Teacher teacher) {
        if(db.teachers.containsKey(teacher.getId()))
            db.teachers.put(teacher.getId(), teacher);

    }

}
