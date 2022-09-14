import system.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class App {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
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

    public static void main(String[] args) {
        Admin admin1 = new Admin();


        System.out.println("\n\n####################" + Colors.RED_BOLD_BRIGHT + " Testing Admin " + Colors.RESET + "#######################\n\n");


        System.out.println(Colors.CYAN_BOLD_BRIGHT + "1. adding 3 teacher\n" + Colors.RESET);
        admin1.addTeacher("teacher 1", "e1@e.com", "0111");
        admin1.addTeacher("teacher 2", "e2@e.com", "0112");
        admin1.addTeacher("teacher 3", "e3@e.com", "0113");

        System.out.println();


        System.out.println(Colors.CYAN_BOLD_BRIGHT + "2. viewing added teachers\n" + Colors.RESET);

        List<Teacher> teachers1 = admin1.viewAllTeachers();
        for (Teacher teacher : teachers1) {
            System.out.println(teacher);
        }

        System.out.println();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "3. removing teacher with id 2\n" + Colors.RESET);
        admin1.removeTeacher("3");

        System.out.println("list after removing: ");
        List<Teacher> teachers2 = admin1.viewAllTeachers();

        for (Teacher teacher : teachers2) {
            System.out.println(teacher);
        }

        System.out.println();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "4. viewing teacher details for id 2 and 3\n" + Colors.RESET);
        System.out.println(admin1.viewTeacherDetails("2"));
        System.out.println(admin1.viewTeacherDetails("3"));

        System.out.println();


        System.out.println(Colors.CYAN_BOLD_BRIGHT + "5. updating name of teacher with id 1\n" + Colors.RESET);
        Teacher teacher0 = admin1.viewTeacherDetails("1");
        teacher0.setName("updated teacher");
        admin1.updateTeacherData(teacher0);
        System.out.println(admin1.viewTeacherDetails("1"));

        System.out.println();

        Admin admin2 = new Admin("New Admin");

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "6. adding 3 students\n" + Colors.RESET);
        admin2.addStudent("student 1", "", "", 20, "", "M");
        admin2.addStudent("student 2", "", "", 21, "", "F");
        admin2.addStudent("student 3", "", "", 22, "", "M");

        System.out.println();


        System.out.println(Colors.CYAN_BOLD_BRIGHT + "7. viewing added students\n" + Colors.RESET);

        List<Student> students1 = admin2.viewAllStudents();
        for (Student student : students1) {
            System.out.println(student);
        }

        System.out.println();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "8. removing student with id 7\n" + Colors.RESET);

        admin2.removeStudent("7");

        System.out.println("list after removing: ");
        List<Student> students2 = admin2.viewAllStudents();

        for (Student student : students2) {
            System.out.println(student);
        }

        System.out.println();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "9. viewing student details for id 6 and 7\n" + Colors.RESET);

        System.out.println(admin2.viewStudentDetails("6"));
        System.out.println(admin2.viewStudentDetails("7"));

        System.out.println();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "10. updating name of student with id 5\n" + Colors.RESET);
        Student student2 = admin2.viewStudentDetails("5");
        student2.setName("updated student");
        admin2.updateStudentData(student2);
        System.out.println(admin2.viewStudentDetails("5"));

        System.out.println();


        System.out.println(Colors.CYAN_BOLD_BRIGHT + "11. adding 3 courses\n" + Colors.RESET);
        admin2.addCourse("Maths", "1");
        admin2.addCourse("Database", "2");
        admin2.addCourse("Software Engineering", "1");

        System.out.println();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "12. viewing added courses\n" + Colors.RESET);

        List<Course> courses1 = admin2.viewAllCourses();
        for (Course course : courses1) {
            System.out.println(course);
        }

        System.out.println();

        System.out.println("\n\n####################" + Colors.RED_BOLD_BRIGHT + " Testing Teacher " + Colors.RESET + "#######################\n\n");

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "1. assigning students to courses\n" + Colors.RESET);
        Teacher teacher = admin1.viewTeacherDetails("1");
        teacher.assignStudentToCourse("5", "1");
        teacher.assignStudentToCourse("5", "2");
        teacher.assignStudentToCourse("6", "0");
        teacher.assignStudentToCourse("6", "1");


        System.out.println(Colors.CYAN_BOLD_BRIGHT + "2. viewing assigned classes for students\n" + Colors.RESET);
        teacher.viewStudentsAssignedClasses();
        System.out.println();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "3. getting student in course 2\n" + Colors.RESET);
        for (Student student : teacher.getStudentsInCourse("2")) {
            System.out.println(student);
        }
        System.out.println();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "4. getting all classes\n" + Colors.RESET);
        List<Course> courses2 = teacher.getAllClasses();
        for (Course course : courses2) {
            System.out.println(course);
        }
        System.out.println();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "5. getting student 6 data\n" + Colors.RESET);
        System.out.println(teacher.getStudentData("6"));
        System.out.println();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "6. adding 3 assignments\n" + Colors.RESET);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 7);
        teacher.addAssignment(new Assignment("Assignment 1", "0", c.getTime()));
        c.add(Calendar.DATE, 1);
        teacher.addAssignment(new Assignment("Assignment 2", "1", c.getTime()));
        c.add(Calendar.DATE, 1);
        teacher.addAssignment(new Assignment("Assignment 3", "1", c.getTime()));
        System.out.println();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "7. submitting students attendance\n" + Colors.RESET);
        List<CourseAttendance> attendances = new ArrayList<>();
        attendances.add(new CourseAttendance("0", "6", new Date(), "attended"));
        attendances.add(new CourseAttendance("1", "5", new Date(), "attended"));
        attendances.add(new CourseAttendance("1", "6", new Date(), "absent"));
        attendances.add(new CourseAttendance("2", "5", new Date(), "attended"));

        teacher.submitStudentsAttendance(attendances);


        System.out.println("\n\n####################" + Colors.RED_BOLD_BRIGHT + " Testing Student " + Colors.RESET + "#######################\n\n");
        Student student = admin1.viewStudentDetails("5");

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "1. viewing enrolled courses for student 5\n" + Colors.RESET);
        for (Course course : student.viewEnrolledCourses()) {
            System.out.println(course);
        }

        System.out.println();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "2. submitting assignment\n" + Colors.RESET);
        AssignmentSubmission assignmentSubmission = new AssignmentSubmission("2", student.getId(), "1", "solution for assignment2");
        student.submitAssignment(assignmentSubmission);
        System.out.println();

        System.out.println(Colors.CYAN_BOLD_BRIGHT + "3. viewing assignment for course 1\n" + Colors.RESET);
        for (Assignment assignment : student.viewAssignments("1")){
            System.out.println(assignment);
        }

        System.out.println();

    }
}
