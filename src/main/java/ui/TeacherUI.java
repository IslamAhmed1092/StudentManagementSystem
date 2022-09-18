package ui;

import model.Assignment;
import model.Course;
import model.CourseAttendance;
import user.Student;
import user.Teacher;
import user.User;
import utils.Color;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TeacherUI implements UserUI {
    private static final Scanner scanner = new Scanner(System.in);
    private Teacher teacher;
    @Override
    public void start(User user) {
        teacher = (Teacher) user;
        System.out.println("starting teacher functionality");

        loop1: while(true) {
            System.out.println(Color.CYAN_BOLD_BRIGHT + "\n1. View Students Assigned Classes" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "2. Get Students in Course" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "3. Get All classes" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "4. Get Student Data" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "5. Add Assignment" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "6. Submit Students Attendance" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "7. Assign Student to Course" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "0. Log out" + Color.RESET);


            String in = scanner.nextLine();

            int command;

            try {
                command = Integer.parseInt(in);
            } catch (Exception e) {
                continue;
            }

            switch (command) {
                case 1:
                    viewStudentsAssignedClasses();
                    break;
                case 2:
                    getStudentsInCourse();
                    break;
                case 3:
                    getAllClasses();
                    break;
                case 4:
                    getStudentData();
                    break;
                case 5:
                    addAssignment();
                    break;
                case 6:
                    submitStudentsAttendance();
                    break;
                case 7:
                    assignStudentToCourse();
                    break;
                case 0:
                    break loop1;
            }

        }
    }

    private void viewStudentsAssignedClasses() {
        System.out.println();
        teacher.viewStudentsAssignedClasses();
    }

    private void getStudentsInCourse() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Course ID" + Color.RESET);
        String id = scanner.nextLine();

        System.out.println();
        for (Student student: teacher.getStudentsInCourse(id)) {
            System.out.println(student);
        }
    }

    private void getAllClasses() {
        System.out.println();
        for (Course course : teacher.getAllClasses()) {
            System.out.println(course);
        }
    }

    private void getStudentData() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student ID" + Color.RESET);
        String id = scanner.nextLine();

        System.out.println();
        System.out.println(teacher.getStudentData(id));
    }

    private void addAssignment() {

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Course ID" + Color.RESET);
        String courseID = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Assignment Description" + Color.RESET);
        String description = scanner.nextLine();

        Date dueDate;

        while (true) {
            System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Due Date in format dd/MM/yyyy" + Color.RESET);
            String dueDateString = scanner.nextLine();

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            try {
                dueDate = dateFormat.parse(dueDateString);
                break;
            } catch (ParseException e) {
                continue;
            }
        }

        Assignment assignment = new Assignment(description, courseID, dueDate);

        teacher.addAssignment(assignment);
    }

    private void submitStudentsAttendance() {
        ArrayList<CourseAttendance> courseAttendances = new ArrayList<>();

        attendancesLoop: while(true) {
            System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Course ID" + Color.RESET);
            String courseID = scanner.nextLine();

            System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student ID" + Color.RESET);
            String studentID = scanner.nextLine();


            Date attendanceDate;

            while (true) {
                System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Attendance Date in format dd/MM/yyyy" + Color.RESET);
                String attendanceDateString = scanner.nextLine();

                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    attendanceDate = dateFormat.parse(attendanceDateString);
                    break;
                } catch (ParseException e) {
                    continue;
                }
            }

            System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Attendance Status" + Color.RESET);
            String status = scanner.nextLine();

            courseAttendances.add(new CourseAttendance(courseID, studentID, attendanceDate, status));

            addLoop: while(true) {
                System.out.println(Color.CYAN_BOLD_BRIGHT + "\nAdd another Attendance? (Y/N)" + Color.RESET);
                String in = scanner.nextLine();

                in = in.toUpperCase();

                switch (in) {
                    case "Y":
                        break addLoop;
                    case "N":
                        break attendancesLoop;
                }
            }

        }

        teacher.submitStudentsAttendance(courseAttendances);
    }

    private void assignStudentToCourse() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student ID" + Color.RESET);
        String studentID = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Course ID" + Color.RESET);
        String courseID = scanner.nextLine();

        teacher.assignStudentToCourse(studentID, courseID);
    }
}
