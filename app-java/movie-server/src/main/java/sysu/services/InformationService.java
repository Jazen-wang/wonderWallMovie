package sysu.services;

import sysu.persistence.models.Cinema;
import sysu.persistence.models.Hall;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by sk2014 on 2017/6/3.
 */
public interface InformationService {
    Set<Cinema> getCinemasHasMovie(long id) throws IOException;
    List<Hall> getHallByMovieAndCinema(long movie_id, long cinema_id) throws IOException;
    Optional<String> getSeats(long movie_id, long cinema_id, long hall_id) throws IOException;
    Optional<String> generateOrder(long movie_id, long cinema_id, long hall_id, long seat_id) throws IOException;

}
