package sysu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Shower on 2017/5/8 0008.
 */
@Service
public class DoubanApi {
    private final String url = "https://api.douban.com";
    private final String latest = "/v2/movie/in_theaters?city=";
    private final String movie = "/v2/movie/subject/";
    private final String search = "/v2/movie/search?q=";

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<String> getLatestMovies(String city) {
        return restTemplate.getForEntity(url + latest + city, String.class);
    }

    public ResponseEntity<String> getMovieDetail(String movieId) {
        return restTemplate.getForEntity(url + movie + movieId, String.class);
    }
}
