package sysu.persistence.models;

import javax.persistence.*;
import java.time.LocalTime;

/**
 * Created by Shower on 2017/5/6 0006.
 */
@Entity
@Table(name = "screening")
public class Screening {
    private static long gen = 0;

    @Id
    @Column(name = "id")
    private long id = gen++;
    private LocalTime start;
    private LocalTime end;
    @OneToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;
    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Screening() {}

    public Screening(LocalTime start, LocalTime end, Hall hall, Movie movie) {
        this.start = start;
        this.end = end;
        this.hall = hall;
        this.movie = movie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", hall=" + hall +
                ", movie=" + movie +
                '}';
    }
}
