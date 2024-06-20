package Repository;

import Model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository {

    User getUserByUserName(String userName);

    boolean addUser(User user);
}
