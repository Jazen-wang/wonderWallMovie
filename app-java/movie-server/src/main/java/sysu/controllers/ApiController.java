package sysu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sysu.services.DoubanService;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by Shower on 2017/5/10 0010.
 */
@RestController
public class ApiController {
    @Autowired
    private DoubanService doubanService;

    @GetMapping("/latest")
    public ResponseEntity<?> getLatestMovies() throws IOException {
        Optional<String> result = doubanService.getLatestMovies("广州");
        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<?> getMovieDetail(@PathVariable long id) throws IOException {
        Optional<String> detail = doubanService.getMovieDetail(id);
        return new ResponseEntity<>(detail.get(), HttpStatus.OK);
    }
}