package Service.ServiceImpl;

import Model.User;
import Repository.RepositoryImpl.UserRepositoryImpl;
import Service.UserService;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance;

    public static synchronized UserServiceImpl getInstance(){
        if(instance == null){
            instance = new UserServiceImpl();
        }
        return instance;
    }


    UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.getUserByUserName(userName);
    }

    @Override
    public boolean signUp(String toString, String username, String userPassword, String userEmail, String userRole) {
        User user = new User(toString, username, userPassword, userEmail, userRole);
        return userRepository.addUser(user);
    }
}
