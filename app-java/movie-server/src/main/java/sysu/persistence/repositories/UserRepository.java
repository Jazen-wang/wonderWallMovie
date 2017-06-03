package sysu.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import sysu.persistence.models.User;

/**
 * Created by Shower on 2017/5/10 0010.
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
