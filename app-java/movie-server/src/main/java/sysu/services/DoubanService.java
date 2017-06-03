package sysu.services;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by Shower on 2017/6/3 0003.
 */
public interface DoubanService {
    Optional<String> getLatestMovies(String city) throws IOException;
    Optional<String> getMovieDetail(long movieId) throws IOException;
    String search(String key);
}
