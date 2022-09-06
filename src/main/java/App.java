import system.Admin;

public class App {
    public static void main(String[] args) {
        Admin admin1 = new Admin();

        admin1.addTeacher("teacher 1", "e1@e.com", "0111");
        admin1.addTeacher("teacher 2", "e2@e.com", "0112");
        admin1.addTeacher("teacher 3", "e3@e.com", "0113");


        System.out.println("*****************************************************");
        admin1.viewAllTeachers();
        System.out.println("*****************************************************\n");

        admin1.removeTeacher("1");

        System.out.println("*****************************************************");
        admin1.viewAllTeachers();
        System.out.println("*****************************************************\n");

        System.out.println("*****************************************************");
        admin1.viewTeacherDetails("2");
        admin1.viewTeacherDetails("1");
        System.out.println("*****************************************************\n");

        System.out.println("*****************************************************");
        admin1.updateTeacherData("0", "updated teacher");
        admin1.viewTeacherDetails("0");
        System.out.println("*****************************************************\n");
    }
}
