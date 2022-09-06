package system.database;

import system.Admin;
import system.Course;
import system.Student;
import system.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Database {
    public Map<String, Teacher> teachers;
    public Map<String, Student> students;

    public Map<String, Course> courses;

    private static Database db = null;

    private Database() {
        teachers = new HashMap<>();
        students = new HashMap<>();
        courses = new HashMap<>();
    }

    public static Database getInstance() {
        if (db != null) {
            return db;
        }

        db = new Database();
        return db;
    }

}
