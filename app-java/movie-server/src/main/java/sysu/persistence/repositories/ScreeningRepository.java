package sysu.persistence.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sysu.persistence.models.Movie;
import sysu.persistence.models.Screening;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shower on 2017/5/10 0010.
 */
public interface ScreeningRepository extends CrudRepository<Screening, Long> {
    List<Screening> findAll();
    List<Screening> findByMovieId(Long id);
}
