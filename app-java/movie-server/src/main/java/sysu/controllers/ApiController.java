package sysu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sysu.eneties.Message;
import sysu.persistence.models.Cinema;
import sysu.persistence.models.Hall;
import sysu.services.DoubanServiceImpl;
import sysu.services.InformationServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Shower on 2017/5/10 0010.
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private DoubanServiceImpl doubanService;

    @Autowired
    private InformationServiceImpl informationService;

    @GetMapping("/hotMovies")
    public ResponseEntity<?> getLatestMovies() throws IOException {
        Optional<String> result = doubanService.getLatestMovies("广州");
        return new ResponseEntity<>(result.get(), HttpStatus.OK);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<?> getMovieDetail(@PathVariable long id) throws IOException {
        Optional<String> detail = doubanService.getMovieDetail(id);
        return new ResponseEntity<>(detail.get(), HttpStatus.OK);
    }

    @GetMapping("/movies")
    public ResponseEntity<?> getAllMovies() throws IOException {
        String allMovies = doubanService.getAllMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.OK);
    }

    @GetMapping("/movies/{id}/cinema")
    public ResponseEntity<?> getCinemasHaveMovie(@PathVariable long id) throws IOException {
        Set<Cinema> cinemas = informationService.getCinemasHasMovie(id);
        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }

    @GetMapping("/movies/{movie_id}/cinema/{cinema_id}")
    public ResponseEntity<?> getHallByMovieAndCinema(@PathVariable long movie_id, @PathVariable long cinema_id) throws IOException {
        List<Hall> halls = informationService.getHallByMovieAndCinema(movie_id, cinema_id);
        return new ResponseEntity<>(halls, HttpStatus.OK);
    }

    @GetMapping("/movies/{movie_id}/cinema/{cinema_id}/{hall_id}")
    public ResponseEntity<?> getSeats(@PathVariable long movie_id, @PathVariable long cinema_id, @PathVariable long hall_id) throws IOException {
        return null;
    }

    @GetMapping("/movies/{movie_id}/cinema/{cinema_id}/hall/{seat_id}")
    @RequestMapping(method = RequestMethod.POST)
    public void generateOrder(@PathVariable long movie_id, @PathVariable long cinema_id, @PathVariable long hall_id, @PathVariable long seat_id) {

    }
}