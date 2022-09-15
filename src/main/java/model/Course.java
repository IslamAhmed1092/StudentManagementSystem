package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String id;
    private String name;

    private String teacherID;

    private List<String> students;

    private static long idCounter = 0;

    public Course(String name, String teacherID) {
        this.id = String.valueOf(idCounter++);
        this.name = name;
        this.teacherID = teacherID;
        students = new ArrayList<>();
    }

    @SuppressWarnings({"IncompleteCopyConstructor"})
    public Course(Course other) {
        this.id = other.id;
        this.name = other.name;
        this.teacherID = other.teacherID;
        this.students = new ArrayList<>(other.students);
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public List<String> getStudents() {
        return students;
    }
    public void enrollStudent(String studentID) {
        students.add(studentID);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Course [ID = %s, Name = %s, Teacher ID = %s, ", id, name, teacherID));

        sb.append("students = ");

        sb.append("[");
        for (int i = 0; i < students.size(); i++) {
            sb.append(students.get(i));
            if(i != students.size()-1) sb.append(", ");
        }
        sb.append("]]");

        return sb.toString();
    }
}
