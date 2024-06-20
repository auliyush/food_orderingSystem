package Service;

import Model.User;

public interface UserService {
    User getUserByUserName(String userName);

    boolean signUp(String toString, String username, String userEmail, String userPassword, String userRole);
}
