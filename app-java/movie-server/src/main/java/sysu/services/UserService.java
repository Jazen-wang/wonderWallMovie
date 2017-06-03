package sysu.services;

import sysu.persistence.models.User;

import java.util.Optional;

/**
 * Created by Shower on 2017/6/3 0003.
 */
public interface UserService {
    User addUser(User user);
    Optional<User> getUserById(long id);
    Optional<User> getUserByName(String name);
    Optional<User> getUserByNameAndPassword(String name, String password);
    boolean isUsernamePresent(String name);
}
