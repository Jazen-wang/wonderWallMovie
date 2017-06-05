package sysu.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sysu.persistence.models.Cinema;

/**
 * Created by Shower on 2017/5/10 0010.
 */
public interface CinemaRepository extends CrudRepository<Cinema, Long> {
    Cinema findById(long id);
}
