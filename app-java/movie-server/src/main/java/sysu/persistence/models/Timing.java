package sysu.persistence.models;

import java.time.LocalTime;

/**
 * Created by Shower on 2017/5/6 0006.
 */
public class Timing {
    private long id;
    private LocalTime start;
    private LocalTime end;
    private long movieId;
    private long hallId;

    public Timing() {}

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

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public long getHallId() {
        return hallId;
    }

    public void setHallId(long hallId) {
        this.hallId = hallId;
    }
}
