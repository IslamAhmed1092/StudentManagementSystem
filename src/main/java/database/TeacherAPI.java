package database;

import exception.NotFoundException;
import user.Teacher;

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

    public void remove(String teacherID) throws NotFoundException {
        Teacher teacher = db.teachers.remove(teacherID);
        if (teacher == null) throw new NotFoundException("Teacher Not Found");
    }

    public Teacher get(String teacherID) throws NotFoundException {
        Teacher teacher = db.teachers.get(teacherID);

        if(teacher == null) throw new NotFoundException("Teacher Not Found");

        return new Teacher(teacher);
    }
    public List<Teacher> getAll() {
        return db.teachers.values().stream().map(Teacher::new).collect(Collectors.toList());
    }

    public void update(Teacher teacher) throws NotFoundException {
        if(db.teachers.containsKey(teacher.getId()))
            db.teachers.put(teacher.getId(), teacher);
        else
            throw new NotFoundException("Teacher not found");

    }

}
