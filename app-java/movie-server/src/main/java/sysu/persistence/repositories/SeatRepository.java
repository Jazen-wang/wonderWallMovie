package sysu.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import sysu.persistence.models.Seat;

import java.util.List;

/**
 * Created by Shower on 2017/5/10 0010.
 */
public interface SeatRepository extends CrudRepository<Seat, Long> {
    Seat findById(long id);
    List<Seat> findByScreening_Hall_IdAndScreening_Movie_Id(long hallId, long movieId);
}
