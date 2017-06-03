package sysu.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import sysu.persistence.models.User;

import java.util.Optional;

/**
 * Created by Shower on 2017/5/10 0010.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

    Optional<User> findUserById(long id);

    Optional<User> findUserByUsernameAndPassword(String username, String password);
}
