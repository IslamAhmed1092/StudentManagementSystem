package ui;

import user.Admin;
import user.Teacher;
import user.User;
import utils.Color;

import java.util.List;
import java.util.Scanner;

public class AdminUI implements UserUI {

    private static final Scanner scanner = new Scanner(System.in);
    private Admin admin;

    @Override
    public void start(User user) {
        admin = (Admin) user;
        System.out.println("starting admin functionality");

        loop1: while(true) {
            System.out.println(Color.CYAN_BOLD_BRIGHT + "\n1. Add Teacher" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "2. Remove Teacher" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "3. View All Teachers" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "4. View Teacher Details" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "5. Update Teacher Data" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "6. Add Student" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "7. Remove Student" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "8. View All Students" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "9. View Student Details" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "10. Update Student Data" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "0. Log out" + Color.RESET);

            String in = scanner.nextLine();

            switch (in) {
                case "1":
                    addTeacher();
                    break;
                case "2":
                    removeTeacher();
                    break;
                case "3":
                    viewAllTeachers();
                    break;
                case "4":
                    viewTeacherDetails();
                    break;
                case "5":
                    updateTeacherData();
                    break;
                case "6":
                    addStudent();
                    break;
                case "7":
                    removeStudent();
                    break;
                case "8":
                    viewAllStudents();
                    break;
                case "9":
                    viewStudentDetails();
                    break;
                case "10":
                    updateStudentData();
                    break;
                case "0":
                    break loop1;
            }

        }
    }

    private void addTeacher() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Teacher Name" + Color.RESET);
        String name = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Teacher Email" + Color.RESET);
        String email = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Teacher Mobile Number" + Color.RESET);
        String mobileNumber = scanner.nextLine();

        admin.addTeacher(name, email, mobileNumber);
    }

    private void removeTeacher() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Teacher ID" + Color.RESET);
        String id = scanner.nextLine();

        admin.removeTeacher(id);
    }

    private void viewAllTeachers() {
        for (Teacher teacher: admin.viewAllTeachers()) {
            System.out.println(teacher);
        }
    }

    private void viewTeacherDetails() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Teacher ID" + Color.RESET);
        String id = scanner.nextLine();

        System.out.println(admin.viewTeacherDetails(id));
    }

    private void updateTeacherData() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Teacher ID" + Color.RESET);
        String id = scanner.nextLine();

        Teacher teacher = admin.viewTeacherDetails(id);
        System.out.println(teacher);

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Teacher Name (blank for no change)" + Color.RESET);
        String in = scanner.nextLine();
        if(!in.isEmpty()) teacher.setName(in);

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Teacher Email (blank for no change)" + Color.RESET);
        in = scanner.nextLine();
        if(!in.isEmpty()) teacher.setEmail(in);

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Teacher Mobile Number (blank for no change)" + Color.RESET);
        in = scanner.nextLine();
        if(!in.isEmpty()) teacher.setName(in);


        admin.updateTeacherData(teacher);
    }

    private void addStudent() {

    }

    private void removeStudent() {

    }

    private void viewAllStudents() {

    }

    private void viewStudentDetails() {

    }

    private void updateStudentData() {

    }
}
