package system.database;

import system.*;

import java.util.*;

class Database {
    public Map<String, Teacher> teachers;
    public Map<String, Student> students;

    public Map<String, Course> courses;

    public Map<String, List<Assignment>> assignments;

    public Set<CourseAttendance> courseAttendances;

    private static Database db = null;

    private Database() {
        teachers = new HashMap<>();
        students = new HashMap<>();
        courses = new HashMap<>();
        assignments = new HashMap<>();
        courseAttendances = new TreeSet<>();
    }

    public static Database getInstance() {
        if (db != null) {
            return db;
        }

        db = new Database();
        return db;
    }

}
