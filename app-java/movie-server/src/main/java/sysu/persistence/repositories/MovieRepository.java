package sysu.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import sysu.persistence.models.Movie;

/**
 * Created by Shower on 2017/5/10 0010.
 */
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
