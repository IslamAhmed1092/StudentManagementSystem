package system.ui;

import system.Admin;
import system.Teacher;
import system.User;

public class TeacherUI implements UserUI {
    @Override
    public void start(User user) {
        Teacher teacher = (Teacher) user;
        System.out.println("starting teacher functionality");
    }
}
