import system.Admin;
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
    }
}
