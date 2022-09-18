package ui;

import database.PublicAPI;
import model.Course;
import user.Admin;
import user.Student;
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
            System.out.println(Color.CYAN_BOLD_BRIGHT + "11. Add Course" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "12. Remove Course" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "13. View All Courses" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "14. View Course Details" + Color.RESET);
            System.out.println(Color.CYAN_BOLD_BRIGHT + "15. Update Course Data" + Color.RESET);
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
                    addTeacher();
                    break;
                case 2:
                    removeTeacher();
                    break;
                case 3:
                    viewAllTeachers();
                    break;
                case 4:
                    viewTeacherDetails();
                    break;
                case 5:
                    updateTeacherData();
                    break;
                case 6:
                    addStudent();
                    break;
                case 7:
                    removeStudent();
                    break;
                case 8:
                    viewAllStudents();
                    break;
                case 9:
                    viewStudentDetails();
                    break;
                case 10:
                    updateStudentData();
                    break;
                case 11:
                    addCourse();
                    break;
                case 12:
                    removeCourse();
                    break;
                case 13:
                    viewAllCourses();
                    break;
                case 14:
                    viewCourseDetails();
                    break;
                case 15:
                    updateCourseData();
                    break;
                case 0:
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
        System.out.println();
        for (Teacher teacher: admin.viewAllTeachers()) {
            System.out.println(teacher);
        }
    }

    private void viewTeacherDetails() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Teacher ID" + Color.RESET);
        String id = scanner.nextLine();

        System.out.println();
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
        if(!in.isEmpty()) teacher.setMobileNumber(in);


        admin.updateTeacherData(teacher);
    }

    private void addStudent() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student Name" + Color.RESET);
        String name = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student Email" + Color.RESET);
        String email = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student Mobile Number" + Color.RESET);
        String mobileNumber = scanner.nextLine();

        int age;
        while (true) {
            System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student Age" + Color.RESET);
            String ageIn = scanner.nextLine();

            try {
                age = Integer.parseInt(ageIn);
                break;
            } catch (Exception e) {
                continue;
            }
        }

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student Address" + Color.RESET);
        String address = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student Gender" + Color.RESET);
        String gender = scanner.nextLine();

        admin.addStudent(name, email, mobileNumber, age, address, gender);
    }

    private void removeStudent() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student ID" + Color.RESET);
        String id = scanner.nextLine();

        admin.removeStudent(id);
    }

    private void viewAllStudents() {
        System.out.println();
        for (Student student: admin.viewAllStudents()) {
            System.out.println(student);
        }
    }

    private void viewStudentDetails() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student ID" + Color.RESET);
        String id = scanner.nextLine();

        System.out.println();
        System.out.println(admin.viewStudentDetails(id));
    }

    private void updateStudentData() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student ID" + Color.RESET);
        String id = scanner.nextLine();

        Student student = admin.viewStudentDetails(id);
        System.out.println(student);

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student Name (blank for no change)" + Color.RESET);
        String in = scanner.nextLine();
        if(!in.isEmpty()) student.setName(in);

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student Email (blank for no change)" + Color.RESET);
        in = scanner.nextLine();
        if(!in.isEmpty()) student.setEmail(in);

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student Mobile Number (blank for no change)" + Color.RESET);
        in = scanner.nextLine();
        if(!in.isEmpty()) student.setMobileNumber(in);


        while (true) {
            System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student Age (blank for no change)" + Color.RESET);
            String ageIn = scanner.nextLine();

            if(ageIn.isEmpty()) break;

            try {
                int age = Integer.parseInt(ageIn);
                student.setAge(age);
                break;
            } catch (Exception e) {
                continue;
            }

        }

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student Address (blank for no change)" + Color.RESET);
        in = scanner.nextLine();
        if(!in.isEmpty()) student.setAddress(in);

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Student Gender (blank for no change)" + Color.RESET);
        in = scanner.nextLine();
        if(!in.isEmpty()) student.setGender(in);


        admin.updateStudentData(student);
    }

    private void addCourse() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Course Name" + Color.RESET);
        String name = scanner.nextLine();

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Teacher ID" + Color.RESET);
        String teacherID = scanner.nextLine();

        admin.addCourse(name, teacherID);
    }

    private void removeCourse() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Course ID" + Color.RESET);
        String id = scanner.nextLine();

        admin.removeCourse(id);
    }

    private void viewAllCourses() {
        System.out.println();
        for (Course course: admin.viewAllCourses()) {
            System.out.println(course);
        }
    }

    private void viewCourseDetails() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Course ID" + Color.RESET);
        String id = scanner.nextLine();

        System.out.println();
        System.out.println(admin.viewCourseDetails(id));
    }

    private void updateCourseData() {
        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Course ID" + Color.RESET);
        String id = scanner.nextLine();

        Course course = admin.viewCourseDetails(id);
        System.out.println(course);

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Course Name (blank for no change)" + Color.RESET);
        String in = scanner.nextLine();
        if(!in.isEmpty()) course.setName(in);

        System.out.println(Color.CYAN_BOLD_BRIGHT + "\nEnter Teacher ID (blank for no change)" + Color.RESET);
        in = scanner.nextLine();
        if(!in.isEmpty()) course.setTeacherID(in);

        admin.updateCourseData(course);
    }
}
