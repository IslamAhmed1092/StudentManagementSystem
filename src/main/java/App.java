import user.Admin;
import user.Student;
import user.Teacher;
import user.User;
import database.PublicAPI;
import user.UserFactory;
import ui.UserUI;
import ui.UserUIFactory;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class App {

    public static class Colors {
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public static final String BLACK = "\033[0;30m";   // BLACK
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String YELLOW = "\033[0;33m";  // YELLOW
        public static final String BLUE = "\033[0;34m";    // BLUE
        public static final String PURPLE = "\033[0;35m";  // PURPLE
        public static final String CYAN = "\033[0;36m";    // CYAN
        public static final String WHITE = "\033[0;37m";   // WHITE

        // Bold
        public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
        public static final String RED_BOLD = "\033[1;31m";    // RED
        public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
        public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
        public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
        public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
        public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
        public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

        // Underline
        public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
        public static final String RED_UNDERLINED = "\033[4;31m";    // RED
        public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
        public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
        public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
        public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
        public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
        public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

        // Background
        public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
        public static final String RED_BACKGROUND = "\033[41m";    // RED
        public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
        public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
        public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
        public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
        public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
        public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

        // High Intensity
        public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
        public static final String RED_BRIGHT = "\033[0;91m";    // RED
        public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
        public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
        public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
        public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
        public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
        public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

        // Bold High Intensity
        public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
        public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
        public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
        public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
        public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
        public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
        public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
        public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

        // High Intensity backgrounds
        public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
        public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
        public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
        public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
        public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
        public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
        public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
        public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
    }


    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n\n\t\t\t\t\t\t\t\t" + Test.Colors.RED_BOLD_BRIGHT + " Welcome to the System" + Test.Colors.RESET);

        startApplication();
    }

    private static void startApplication() {

        while (true) {
            System.out.println(Colors.CYAN_BOLD_BRIGHT + "\n1. Login" + Colors.RESET);
            System.out.println(Colors.CYAN_BOLD_BRIGHT + "2. Sign up" + Colors.RESET);

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
            System.out.println(Colors.CYAN_BOLD_BRIGHT + "1. Admin" + Colors.RESET);
            System.out.println(Colors.CYAN_BOLD_BRIGHT + "2. Teacher" + Colors.RESET);
            System.out.println(Colors.CYAN_BOLD_BRIGHT + "3. Student" + Colors.RESET);
            System.out.println(Colors.CYAN_BOLD_BRIGHT + "0. back" + Colors.RESET);

            String in = scanner.nextLine();
            int userType;
            try {
                userType = Integer.parseInt(in);
            } catch (Exception e) {
                continue;
            }

            if(userType != 0 && userType != 1 && userType != 2 && userType != 3) continue;

            if(userType == 0) break;

            System.out.println(Colors.CYAN_BOLD_BRIGHT + "Enter your id: " + Colors.RESET);
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
            System.out.println(Colors.CYAN_BOLD_BRIGHT + "1. Admin" + Colors.RESET);
            System.out.println(Colors.CYAN_BOLD_BRIGHT + "2. Teacher" + Colors.RESET);
            System.out.println(Colors.CYAN_BOLD_BRIGHT + "3. Student" + Colors.RESET);
            System.out.println(Colors.CYAN_BOLD_BRIGHT + "0. back" + Colors.RESET);

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
        System.out.println(Colors.CYAN_BOLD_BRIGHT + "\n1. Enter your Name" + Colors.RESET);
        String name = scanner.nextLine();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "\n2. Enter your Email" + Colors.RESET);
        String email = scanner.nextLine();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "\n3. Enter your Mobile Number" + Colors.RESET);
        String mobileNumber = scanner.nextLine();

        Admin admin = new Admin(name, email, mobileNumber);

        PublicAPI.addAdmin(admin);

        return admin;
    }

    private static User createTeacher() {
        System.out.println(Colors.CYAN_BOLD_BRIGHT + "\n1. Enter your Name" + Colors.RESET);
        String name = scanner.nextLine();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "\n2. Enter your Email" + Colors.RESET);
        String email = scanner.nextLine();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "\n3. Enter your Mobile Number" + Colors.RESET);
        String mobileNumber = scanner.nextLine();

        Teacher teacher = new Teacher(name, email, mobileNumber);

        PublicAPI.addTeacher(teacher);

        return teacher;
    }

    private static User createStudent() {

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "\n1. Enter your Name" + Colors.RESET);
        String name = scanner.nextLine();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "\n2. Enter your Email" + Colors.RESET);
        String email = scanner.nextLine();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "\n3. Enter your Mobile Number" + Colors.RESET);
        String mobileNumber = scanner.nextLine();


        int age;
        while (true) {
            System.out.println(Colors.CYAN_BOLD_BRIGHT + "\n4. Enter your Age" + Colors.RESET);
            String ageIn = scanner.nextLine();

            try {
                age = Integer.parseInt(ageIn);
                break;
            } catch (Exception e) {
                continue;
            }
        }

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "\n5. Enter your Address" + Colors.RESET);
        String address = scanner.nextLine();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "\n6. Enter your Gender" + Colors.RESET);
        String gender = scanner.nextLine();

        Student student = new Student(name, email, mobileNumber, age, address, gender);

        PublicAPI.addStudent(student);

        return student;
    }

}
