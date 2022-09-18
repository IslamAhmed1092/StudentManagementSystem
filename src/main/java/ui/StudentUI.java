package ui;

import exception.NotFoundException;
import model.Assignment;
import model.AssignmentSubmission;
import model.Course;
import user.Admin;
import user.Student;
import user.User;
import utils.Color;

import java.util.Scanner;

public class StudentUI implements UserUI{


    private static final Scanner scanner = new Scanner(System.in);
    private Student student;

    @Override
    public void start(User user) {
        student = (Student) user;
        System.out.println("starting student functionality");

        loop1: while(true) {
            System.out.println(Color.CYAN_BOLD_BRIGHT + "\n1. View Enrolled Courses" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "2. View Assignments" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "3. Submit Assignment" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "0. Log out" + Color.RESET);

            String in = scanner.nextLine();

            int command;

            try {
                command = Integer.parseInt(in);
            } catch (Exception e) {
                continue;
            }

            try {
                switch (command) {
                    case 1:
                        viewEnrolledCourses();
                        break;
                    case 2:
                        viewAssignments();
                        break;
                    case 3:
                        submitAssignment();
                        break;
                    case 0:
                        break loop1;
                }
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private void viewEnrolledCourses() {
        System.out.println();
        for (Course course : student.viewEnrolledCourses()) {
            System.out.println(course);
        }
    }

    private void viewAssignments() throws NotFoundException {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Course ID" + Color.RESET);
        String id = scanner.nextLine();

        for (Assignment assignment : student.viewAssignments(id)) {
            System.out.println(assignment);
        }
    }

    private void submitAssignment() throws NotFoundException {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Course ID" + Color.RESET);
        String courseID = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Assignment ID" + Color.RESET);
        String assignmentID = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Submitted Content" + Color.RESET);
        String assignmentContentSubmitted = scanner.nextLine();

        AssignmentSubmission assignmentSubmission = new AssignmentSubmission(assignmentID, student.getId(), courseID, assignmentContentSubmitted);
        student.submitAssignment(assignmentSubmission);
    }
}
