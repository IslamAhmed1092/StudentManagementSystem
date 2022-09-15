package ui;

public class UserUIFactory {
    public UserUI getUserUI(int userType) {
        switch (userType) {
            case 1:
                return new AdminUI();
            case 2:
                return new TeacherUI();
            case 3:
                return new StudentUI();
            default:
                return null;
        }

    }
}
