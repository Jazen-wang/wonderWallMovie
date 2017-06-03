package sysu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sysu.persistence.models.User;
import sysu.persistence.repositories.UserRepository;

import java.util.Optional;

/**
 * Created by Shower on 2017/6/3 0003.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return userRepository.findUserByUsername(name);
    }

    @Override
    public Optional<User> getUserByNameAndPassword(String name, String password) {
        return userRepository.findUserByUsernameAndPassword(name, password);
    }

    @Override
    public boolean isUsernamePresent(String name) {
        return userRepository.findUserByUsername(name).isPresent();
    }
}
