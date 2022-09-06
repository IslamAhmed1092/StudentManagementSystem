package system.database;

import system.Admin;
import system.Course;
import system.Student;
import system.Teacher;

import java.util.ArrayList;

class Database {
    public ArrayList<Teacher> teachers;
    public ArrayList<Student> students;

    public ArrayList<Course> courses;

    private static Database db = null;

    private Database() {
        teachers = new ArrayList<>();
        students = new ArrayList<>();
    }

    public static Database getInstance() {
        if (db != null) {
            return db;
        }

        db = new Database();
        return db;
    }

}
