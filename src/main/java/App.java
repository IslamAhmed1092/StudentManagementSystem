import system.Admin;
import system.Student;
import system.Teacher;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Admin admin1 = new Admin();

        admin1.addTeacher("teacher 1", "e1@e.com", "0111");
        admin1.addTeacher("teacher 2", "e2@e.com", "0112");
        admin1.addTeacher("teacher 3", "e3@e.com", "0113");


        System.out.println("*****************************************************");
        List<Teacher> teachers1 = admin1.viewAllTeachers();

        for (Teacher teacher : teachers1) {
            System.out.println(teacher);
        }

        System.out.println("*****************************************************\n");

        admin1.removeTeacher("1");

        System.out.println("*****************************************************");
        List<Teacher> teachers2 = admin1.viewAllTeachers();

        for (Teacher teacher : teachers2) {
            System.out.println(teacher);
        }
        System.out.println("*****************************************************\n");

        System.out.println("*****************************************************");
        System.out.println(admin1.viewTeacherDetails("2"));
        System.out.println(admin1.viewTeacherDetails("1"));
        System.out.println("*****************************************************\n");


        System.out.println("*****************************************************");
        Teacher teacher0 = admin1.viewTeacherDetails("0");
        teacher0.setName("updated teacher");
        System.out.println(admin1.viewTeacherDetails("0"));
        System.out.println("*****************************************************\n");

        System.out.println("*****************************************************");
        admin1.updateTeacherData(teacher0);
        System.out.println(admin1.viewTeacherDetails("0"));
        System.out.println("*****************************************************\n");

        Admin admin2 = new Admin("New Admin");

        System.out.println("*****************************************************");
        List<Teacher> teachers3 = admin2.viewAllTeachers();

        for (Teacher teacher : teachers3) {
            System.out.println(teacher);
        }
        System.out.println("*****************************************************\n");

        admin2.addStudent("student 1", "", "", 20, "", "M");
        admin2.addStudent("student 2", "", "", 21, "", "F");
        admin2.addStudent("student 3", "", "", 22, "", "M");

        System.out.println("*****************************************************");
        List<Student> students1 = admin2.viewAllStudents();

        for (Student student : students1) {
            System.out.println(student);
        }

        System.out.println("*****************************************************\n");

        admin2.removeStudent("0");

        System.out.println("*****************************************************");
        List<Student> students2 = admin2.viewAllStudents();

        for (Student student : students2) {
            System.out.println(student);
        }
        System.out.println("*****************************************************\n");

        System.out.println("*****************************************************");
        System.out.println(admin2.viewStudentDetails("1"));
        System.out.println(admin2.viewStudentDetails("0"));
        System.out.println("*****************************************************\n");


        System.out.println("*****************************************************");
        Student student2 = admin2.viewStudentDetails("2");
        student2.setName("updated student");
        System.out.println(admin2.viewStudentDetails("2"));
        System.out.println("*****************************************************\n");

        System.out.println("*****************************************************");
        admin2.updateStudentData(student2);
        System.out.println(admin2.viewStudentDetails("2"));
        System.out.println("*****************************************************\n");

    }
}
