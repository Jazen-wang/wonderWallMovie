package sysu.persistence.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shower on 2017/5/6 0006.
 */
@Entity
@Table(name = "hall")
public class Hall {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    private int number;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "cinema_id", insertable = false, updatable = false)
    private Cinema cinema;

    public Hall() {}
    public Hall(int number, Cinema cinema) {
        this.number = number;
        this.cinema = cinema;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}
