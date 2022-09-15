import user.Admin;
import user.Student;
import user.Teacher;
import user.User;
import database.PublicAPI;
import user.UserFactory;
import ui.UserUI;
import ui.UserUIFactory;
import utils.Color;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class App {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n\n\t\t\t\t\t\t\t\t" + Test.Colors.RED_BOLD_BRIGHT + " Welcome to the System" + Test.Colors.RESET);

        startApplication();
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

                continue; and 
            }

            if(userType != 0 && userType != 1 && userType != 2 && userType != 3) continue;

            if(userType == 0) break;

            System.out.println(Color.CYAN_BOLD_BRIGHT + "Enter your id: " + Color.RESET);
            String id = scanner.nextLine();

            UserFactory userFactory = new UserFactory();
            User user = userFactory.getUser(userType, id);

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
//Can we notify that he entered bad number 
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
