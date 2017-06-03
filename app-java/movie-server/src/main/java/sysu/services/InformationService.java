package sysu.services;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by sk2014 on 2017/6/3.
 */
public interface InformationService {
    Optional<String> getCinemasHasMovie(long id) throws IOException;
    Optional<String> getHallByMovieAndCinema(long movie_id, long cinema_id) throws IOException;
    Optional<String> getSeats(long movie_id, long cinema_id, long hall_id) throws IOException;

}
