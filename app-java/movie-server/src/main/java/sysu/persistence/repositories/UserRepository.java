package sysu.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import sysu.persistence.models.User;

/**
 * Created by shower on 17-4-15.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);

}
