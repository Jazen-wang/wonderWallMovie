package sysu.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Shower on 2017/5/8 0008.
 */
@Service
public class DoubanServiceImpl implements DoubanService {
    private final String url = "https://api.douban.com";
    private final String latest = "/v2/movie/in_theaters?city=";
    private final String movie = "/v2/movie/subject/";
    private final String search = "/v2/movie/search?q=";
    private final String allMovie = "/v2/movie/top250";

    private Map<Long, String> movieDetailMap = new HashMap<>();
    private Map<String, String> latestMoviesMap = new HashMap<>();

    private String top250 = null;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public Optional<String> getLatestMovies(String city) throws IOException {
        if (!latestMoviesMap.containsKey(city)) {
            String t = restTemplate.getForEntity(url + latest + city,
                    String.class).getBody();
            t = StringEscapeUtils.unescapeJava(t);
            latestMoviesMap.put(city, t);
        }
        return Optional.ofNullable(latestMoviesMap.getOrDefault(city, null));
    }

    public Optional<String> getMovieDetail(long movieId) throws IOException {
        if (!movieDetailMap.containsKey(movieId)) {
            String t = restTemplate.getForEntity(url + movie + movieId,
                    String.class).getBody();
            t = StringEscapeUtils.unescapeJava(t);
//            System.out.println(t);
            //should check if t is valid
            movieDetailMap.put(movieId, t);
        }
        return Optional.ofNullable(movieDetailMap.getOrDefault(movieId, null));
    }

    public String getAllMovies() throws IOException {
        if (top250 != null) return top250;
        top250 = restTemplate.getForEntity(url + allMovie, String.class).getBody();
        top250 = StringEscapeUtils.unescapeJava(top250);
        return top250;
    }

    public String search(String key) {
        String t = restTemplate.getForEntity(url + search + key,
                String.class).getBody();
        t = StringEscapeUtils.unescapeJava(t);
        return t;
    }

    private boolean isValid(String s) throws IOException {
        JsonNode root = objectMapper.readTree(s);
        return !root.has("code");
    }
}
