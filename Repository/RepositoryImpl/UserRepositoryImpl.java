package Repository.RepositoryImpl;

import Model.User;
import Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private static UserRepositoryImpl instance;
    public static synchronized UserRepositoryImpl getInstance(){
        if(instance == null){
            instance = new UserRepositoryImpl();
        }
        return instance;
    }

    private List<User> usersList = new ArrayList<>();

    @Override
    public boolean addUser(User user) {
        return usersList.add(user);
    }

    @Override
    public User getUserByUserName(String userName) {
        for(User user : usersList){
            if(user.getUserName().equals(userName)){
                return user;
            }
        }
        return null;
    }
}
