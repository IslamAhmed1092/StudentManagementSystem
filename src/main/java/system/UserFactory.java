package system;

import system.User;
import system.database.PublicAPI;

public class UserFactory {
    public User getUser(int userType, String id) {
        switch (userType) {
            case 1:
                return PublicAPI.getAdmin(id);
            case 2:
                return PublicAPI.getTeacher(id);
            case 3:
                return PublicAPI.getStudent(id);
            default:
                return null;
        }

    }
}
