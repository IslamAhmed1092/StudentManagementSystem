package ui;

import user.Teacher;
import user.User;

public class TeacherUI implements UserUI {
    @Override
    public void start(User user) {
        Teacher teacher = (Teacher) user;
        System.out.println("starting teacher functionality");
    }
}
