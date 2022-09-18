import model.Assignment;
import model.Course;
import user.Admin;
import user.Student;
import user.Teacher;
import user.User;
import database.PublicAPI;
import user.UserFactory;
import ui.UserUI;
import ui.UserUIFactory;
import utils.Color;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class App {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seed();

        System.out.println("\n\n\t\t\t\t\t\t\t\t" + Color.RED_BOLD_BRIGHT + " Welcome to the System" + Color.RESET);
        startApplication();
    }

    private static void seed() {
        PublicAPI.addAdmin(new Admin("admin 1", "a1@a.com", "0100"));

        PublicAPI.addTeacher(new Teacher("teacher 1", "e1@e.com", "0111"));
        PublicAPI.addTeacher(new Teacher("teacher 2", "e2@e.com", "0112"));
        PublicAPI.addTeacher(new Teacher("teacher 3", "e3@e.com", "0113"));

        PublicAPI.addStudent(new Student("student 1", "", "", 20, "", "M"));
        PublicAPI.addStudent(new Student("student 2", "", "", 21, "", "F"));
        PublicAPI.addStudent(new Student("student 3", "", "", 22, "", "M"));

        PublicAPI.addCourse(new Course("Maths", "1"));
        PublicAPI.addCourse(new Course("Database", "2"));
        PublicAPI.addCourse(new Course("Software Engineering", "1"));

        Teacher teacher = PublicAPI.getTeacher("1");
        teacher.assignStudentToCourse("5", "1");
        teacher.assignStudentToCourse("5", "2");
        teacher.assignStudentToCourse("6", "0");
        teacher.assignStudentToCourse("6", "1");

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 7);
        teacher.addAssignment(new Assignment("Assignment 1", "0", c.getTime()));
        c.add(Calendar.DATE, 1);
        teacher.addAssignment(new Assignment("Assignment 2", "1", c.getTime()));
        c.add(Calendar.DATE, 1);
        teacher.addAssignment(new Assignment("Assignment 3", "1", c.getTime()));

    }

    private static void startApplication() {

        while (true) {
            System.out.println(Color.CYAN_BOLD_BRIGHT + "\n1. Login" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "2. Sign up" + Color.RESET);

            String in = scanner.nextLine();
            int num;
            try {
                num = Integer.parseInt(in);
            } catch (Exception e) {
                continue;
            }

            switch (num) {
                case 1:
                    login();
                    break;
                case 2:
                    signup();
                    break;
                default:
                    break;
            }
        }
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\nLogin as: ");
            System.out.println(Color.CYAN_BOLD_BRIGHT + "1. Admin" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "2. Teacher" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "3. Student" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "0. back" + Color.RESET);

            String in = scanner.nextLine();
            int userType;
            try {
                userType = Integer.parseInt(in);
            } catch (Exception e) {
                continue;
            }

            if(userType != 0 && userType != 1 && userType != 2 && userType != 3) continue;

            if(userType == 0) break;

            System.out.println(Color.CYAN_BOLD_BRIGHT + "Enter your id: " + Color.RESET);
            String id = scanner.nextLine();

            UserFactory userFactory = new UserFactory();
            User user = userFactory.getUser(userType, id);

            if(user == null) continue;

            UserUIFactory userUIFactory = new UserUIFactory();
            UserUI userUI = userUIFactory.getUserUI(userType);
            userUI.start(user);
        }
    }

    private static void signup() {

        loop1: while(true) {
            System.out.println("\nSign Up as: ");
            System.out.println(Color.CYAN_BOLD_BRIGHT + "1. Admin" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "2. Teacher" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "3. Student" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "0. back" + Color.RESET);

            String in = scanner.nextLine();
            int userType;
            try {
                userType = Integer.parseInt(in);
            } catch (Exception e) {
                continue;
            }

            User user = null;
            switch (userType) {
                case 1:
                    user = createAdmin();
                    break;
                case 2:
                    user = createTeacher();
                    break;
                case 3:
                    user = createStudent();
                    break;
                case 0:
                    break loop1;
                default:
                    continue;
            }

            System.out.println(user);
            System.out.println();

            UserUIFactory userUIFactory = new UserUIFactory();
            UserUI userUI = userUIFactory.getUserUI(userType);
            userUI.start(user);

            break;

        }
    }

    private static User createAdmin() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\n1. Enter your Name" + Color.RESET);
        String name = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\n2. Enter your Email" + Color.RESET);
        String email = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\n3. Enter your Mobile Number" + Color.RESET);
        String mobileNumber = scanner.nextLine();

        Admin admin = new Admin(name, email, mobileNumber);

        PublicAPI.addAdmin(admin);

        return admin;
    }

    private static User createTeacher() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\n1. Enter your Name" + Color.RESET);
        String name = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\n2. Enter your Email" + Color.RESET);
        String email = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\n3. Enter your Mobile Number" + Color.RESET);
        String mobileNumber = scanner.nextLine();

        Teacher teacher = new Teacher(name, email, mobileNumber);

        PublicAPI.addTeacher(teacher);

        return teacher;
    }

    private static User createStudent() {

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\n1. Enter your Name" + Color.RESET);
        String name = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\n2. Enter your Email" + Color.RESET);
        String email = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\n3. Enter your Mobile Number" + Color.RESET);
        String mobileNumber = scanner.nextLine();


        int age;
        while (true) {
            System.out.println(Color.CYAN_BOLD_BRIGHT + "\n4. Enter your Age" + Color.RESET);
            String ageIn = scanner.nextLine();

            try {
                age = Integer.parseInt(ageIn);
                break;
            } catch (Exception e) {
                continue;
            }
        }

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\n5. Enter your Address" + Color.RESET);
        String address = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\n6. Enter your Gender" + Color.RESET);
        String gender = scanner.nextLine();

        Student student = new Student(name, email, mobileNumber, age, address, gender);

        PublicAPI.addStudent(student);

        return student;
    }

}
