import model.Assignment;
import model.AssignmentSubmission;
import model.Course;
import model.CourseAttendance;
import user.Admin;
import user.Student;
import user.Teacher;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import utils.Color;


public class Test {

    public static void main(String[] args) {
        Admin admin1 = new Admin();


        System.out.println("\n\n####################" + Color.RED_BOLD_BRIGHT + " Testing Admin " + Color.RESET + "#######################\n\n");


        System.out.println(Color.CYAN_BOLD_BRIGHT + "1. adding 3 teacher\n" + Color.RESET);
        admin1.addTeacher("teacher 1", "e1@e.com", "0111");
        admin1.addTeacher("teacher 2", "e2@e.com", "0112");
        admin1.addTeacher("teacher 3", "e3@e.com", "0113");

        System.out.println();


        System.out.println(Color.CYAN_BOLD_BRIGHT + "2. viewing added teachers\n" + Color.RESET);

        List<Teacher> teachers1 = admin1.viewAllTeachers();
        for (Teacher teacher : teachers1) {
            System.out.println(teacher);
        }

        System.out.println();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "3. removing teacher with id 2\n" + Color.RESET);
        admin1.removeTeacher("3");

        System.out.println("list after removing: ");
        List<Teacher> teachers2 = admin1.viewAllTeachers();

        for (Teacher teacher : teachers2) {
            System.out.println(teacher);
        }

        System.out.println();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "4. viewing teacher details for id 2 and 3\n" + Color.RESET);
        System.out.println(admin1.viewTeacherDetails("2"));
        System.out.println(admin1.viewTeacherDetails("3"));

        System.out.println();


        System.out.println(Color.CYAN_BOLD_BRIGHT + "5. updating name of teacher with id 1\n" + Color.RESET);
        Teacher teacher0 = admin1.viewTeacherDetails("1");
        teacher0.setName("updated teacher");
        admin1.updateTeacherData(teacher0);
        System.out.println(admin1.viewTeacherDetails("1"));

        System.out.println();

        Admin admin2 = new Admin("New Admin");

        System.out.println(Color.CYAN_BOLD_BRIGHT + "6. adding 3 students\n" + Color.RESET);
        admin2.addStudent("student 1", "", "", 20, "", "M");
        admin2.addStudent("student 2", "", "", 21, "", "F");
        admin2.addStudent("student 3", "", "", 22, "", "M");

        System.out.println();


        System.out.println(Color.CYAN_BOLD_BRIGHT + "7. viewing added students\n" + Color.RESET);

        List<Student> students1 = admin2.viewAllStudents();
        for (Student student : students1) {
            System.out.println(student);
        }

        System.out.println();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "8. removing student with id 7\n" + Color.RESET);

        admin2.removeStudent("7");

        System.out.println("list after removing: ");
        List<Student> students2 = admin2.viewAllStudents();

        for (Student student : students2) {
            System.out.println(student);
        }

        System.out.println();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "9. viewing student details for id 6 and 7\n" + Color.RESET);

        System.out.println(admin2.viewStudentDetails("6"));
        System.out.println(admin2.viewStudentDetails("7"));

        System.out.println();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "10. updating name of student with id 5\n" + Color.RESET);
        Student student2 = admin2.viewStudentDetails("5");
        student2.setName("updated student");
        admin2.updateStudentData(student2);
        System.out.println(admin2.viewStudentDetails("5"));

        System.out.println();


        System.out.println(Color.CYAN_BOLD_BRIGHT + "11. adding 3 courses\n" + Color.RESET);
        admin2.addCourse("Maths", "1");
        admin2.addCourse("Database", "2");
        admin2.addCourse("Software Engineering", "1");

        System.out.println();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "12. viewing added courses\n" + Color.RESET);

        List<Course> courses1 = admin2.viewAllCourses();
        for (Course course : courses1) {
            System.out.println(course);
        }

        System.out.println();

        System.out.println("\n\n####################" + Color.RED_BOLD_BRIGHT + " Testing Teacher " + Color.RESET + "#######################\n\n");

        System.out.println(Color.CYAN_BOLD_BRIGHT + "1. assigning students to courses\n" + Color.RESET);
        Teacher teacher = admin1.viewTeacherDetails("1");
        teacher.assignStudentToCourse("5", "1");
        teacher.assignStudentToCourse("5", "2");
        teacher.assignStudentToCourse("6", "0");
        teacher.assignStudentToCourse("6", "1");


        System.out.println(Color.CYAN_BOLD_BRIGHT + "2. viewing assigned classes for students\n" + Color.RESET);
        teacher.viewStudentsAssignedClasses();
        System.out.println();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "3. getting student in course 2\n" + Color.RESET);
        for (Student student : teacher.getStudentsInCourse("2")) {
            System.out.println(student);
        }
        System.out.println();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "4. getting all classes\n" + Color.RESET);
        List<Course> courses2 = teacher.getAllClasses();
        for (Course course : courses2) {
            System.out.println(course);
        }
        System.out.println();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "5. getting student 6 data\n" + Color.RESET);
        System.out.println(teacher.getStudentData("6"));
        System.out.println();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "6. adding 3 assignments\n" + Color.RESET);
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 7);
        teacher.addAssignment(new Assignment("Assignment 1", "0", c.getTime()));
        c.add(Calendar.DATE, 1);
        teacher.addAssignment(new Assignment("Assignment 2", "1", c.getTime()));
        c.add(Calendar.DATE, 1);
        teacher.addAssignment(new Assignment("Assignment 3", "1", c.getTime()));
        System.out.println();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "7. submitting students attendance\n" + Color.RESET);
        List<CourseAttendance> attendances = new ArrayList<>();
        attendances.add(new CourseAttendance("0", "6", new Date(), "attended"));
        attendances.add(new CourseAttendance("1", "5", new Date(), "attended"));
        attendances.add(new CourseAttendance("1", "6", new Date(), "absent"));
        attendances.add(new CourseAttendance("2", "5", new Date(), "attended"));

        teacher.submitStudentsAttendance(attendances);


        System.out.println("\n\n####################" + Color.RED_BOLD_BRIGHT + " Testing Student " + Color.RESET + "#######################\n\n");
        Student student = admin1.viewStudentDetails("5");

        System.out.println(Color.CYAN_BOLD_BRIGHT + "1. viewing enrolled courses for student 5\n" + Color.RESET);
        for (Course course : student.viewEnrolledCourses()) {
            System.out.println(course);
        }

        System.out.println();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "2. submitting assignment\n" + Color.RESET);
        AssignmentSubmission assignmentSubmission = new AssignmentSubmission("2", student.getId(), "1", "solution for assignment2");
        student.submitAssignment(assignmentSubmission);
        System.out.println();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "3. viewing assignment for course 1\n" + Color.RESET);
        for (Assignment assignment : student.viewAssignments("1")){
            System.out.println(assignment);
        }

        System.out.println();

    }
}
