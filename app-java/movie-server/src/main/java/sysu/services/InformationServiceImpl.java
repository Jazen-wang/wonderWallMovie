package sysu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sysu.persistence.models.Cinema;
import sysu.persistence.models.Hall;
import sysu.persistence.models.Screening;
import sysu.persistence.models.Seat;
import sysu.persistence.repositories.ScreeningRepository;
import sysu.persistence.repositories.SeatRepository;

import java.io.IOException;

import java.util.*;

/**
 * Created by sk2014 on 2017/6/3.
 */
@Service
public class InformationServiceImpl implements InformationService{

    @Autowired
    private ScreeningRepository screeningRepository;

    @Autowired
    private SeatRepository seatRepository;

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
    public List<Seat> getSeats(long hall_id, long movie_id) throws IOException {
        List<Seat> seats = seatRepository
            .findByScreening_Hall_IdAndScreening_Movie_Id(hall_id, movie_id);
        return seats;
    }
}
