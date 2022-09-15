package ui;

import user.Student;
import user.User;

public class StudentUI implements UserUI{
    @Override
    public void start(User user) {
        Student student = (Student) user;
        System.out.println("starting student functionality");
    }
}
