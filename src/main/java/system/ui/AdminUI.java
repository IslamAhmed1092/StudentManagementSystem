package system.ui;

import system.Admin;
import system.User;

public class AdminUI implements UserUI {
    @Override
    public void start(User user) {
        Admin admin = (Admin) user;
        System.out.println("starting admin functionality");
    }
}
