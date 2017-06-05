package sysu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sysu.persistence.models.Cinema;
import sysu.persistence.models.Hall;
import sysu.persistence.models.Screening;
import sysu.persistence.repositories.ScreeningRepository;

import java.io.IOException;

import java.util.*;

/**
 * Created by sk2014 on 2017/6/3.
 */
@Service
public class InformationServiceImpl implements InformationService{

    @Autowired
    private ScreeningRepository screeningRepository;

    @Override
    public Set<Cinema> getCinemasHasMovie(long id) throws IOException {
        List<Screening> screenings = screeningRepository.findByMovieId(id);
        Set<Cinema> cinemas = new HashSet<>();
        for (Screening screening : screenings) {
            cinemas.add(screening.getHall().getCinema());
        }
        System.out.println(cinemas);
        return cinemas;
    }

    @Override
    public List<Hall> getHallByMovieAndCinema(long movie_id, long cinema_id) throws IOException {
        List<Screening> screenings = screeningRepository.findByMovieId(movie_id);
        List<Hall> halls = new ArrayList<>();
        for (Screening screening : screenings) {
            if (cinema_id == screening.getHall().getCinema().getId()) {
                halls.add(screening.getHall());
            }
        }
        return halls;
    }

    @Override
    public Optional<String> getSeats(long movie_id, long cinema_id, long hall_id) throws IOException {
        return null;
    }

    @Override
    public Optional<String> generateOrder(long movie_id, long cinema_id, long hall_id, long seat_id) throws IOException {
        return null;
    }
}
