package Controller;

import Model.User;
import Service.ServiceImpl.UserServiceImpl;

public class UserController {
    UserServiceImpl userService = UserServiceImpl.getInstance();
    private static UserController instance;
    public static synchronized UserController getInstance(){
        if(instance == null){
            instance = new UserController();
        }
        return instance;
    }
    public User getUserByUserName(String userName){
        return userService.getUserByUserName(userName);
    }

    public User getUserByUserId(String customerId){
        return userService.getUserByUserId(customerId);
    }
    public boolean signUp(String userId, String username, String userPassword, String userEmail, String userRole) {
        return userService.signUp(userId, username, userPassword, userEmail, userRole);
    }

    public boolean checkEmailAlreadyExistsOrNot(String userEmail) {
        return userService.checkEmailAlreadyExistsOrNot(userEmail);
    }
}
