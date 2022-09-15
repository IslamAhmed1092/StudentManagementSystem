package system.ui;

import system.Admin;
import system.Student;
import system.User;

public class StudentUI implements UserUI{
    @Override
    public void start(User user) {
        Student student = (Student) user;
        System.out.println("starting student functionality");
    }
}
