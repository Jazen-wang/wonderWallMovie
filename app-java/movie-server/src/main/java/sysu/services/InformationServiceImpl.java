package sysu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sysu.persistence.models.Cinema;
import sysu.persistence.models.Hall;
import sysu.persistence.models.Screening;
import sysu.persistence.repositories.CinemaRepository;
import sysu.persistence.repositories.HallRepository;
import sysu.persistence.repositories.ScreeningRepository;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

/**
 * Created by sk2014 on 2017/6/3.
 */
@Service
public class InformationServiceImpl implements InformationService{

    @Autowired
    private ScreeningRepository screeningRepository;

    @Override
    public Optional<String> getCinemasHasMovie(long id) throws IOException {
        List<Screening> screenings = screeningRepository.findByMovieId(id);
        HashSet<Cinema> cinemas = new HashSet<>();
        for (int i = 0; i < screenings.size(); i++) {
            cinemas.add(screenings.get(i).getHall().getCinema());
        }
        return  Optional.ofNullable(cinemas.toString());
    }

    @Override
    public Optional<String> getHallByMovieAndCinema(long movie_id, long cinema_id) throws IOException {
        List<Screening> screenings = screeningRepository.findByMovieId(movie_id);
        ArrayList<Hall> halls = new ArrayList<>();
        for (int i = 0; i < screenings.size(); i++) {
            if (cinema_id == screenings.get(i).getHall().getCinema().getId()) {
                halls.add(screenings.get(i).getHall());
            }
        }
        return Optional.ofNullable(halls.toString());
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
