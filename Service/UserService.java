package Service;

import Model.User;

public interface UserService {
    User getUserByUserName(String userName);

    User getUserByUserId(String customerId);

    boolean signUp(String toString, String username, String userEmail, String userPassword, String userRole);

    boolean checkEmailAlreadyExistsOrNot(String userEmail);
}
