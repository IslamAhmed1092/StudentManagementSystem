package ui;

import user.Admin;
import user.User;

public class AdminUI implements UserUI {
    @Override
    public void start(User user) {
        Admin admin = (Admin) user;
        System.out.println("starting admin functionality");
    }
}
