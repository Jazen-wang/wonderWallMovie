package sysu.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import sysu.persistence.models.Movie;
import sysu.persistence.models.UserOrder;

/**
 * Created by Shower on 2017/5/10 0010.
 */
public interface OrderRepository extends CrudRepository<UserOrder, Long> {
}
