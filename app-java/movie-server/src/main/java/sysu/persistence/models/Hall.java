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

    @OneToMany
    @JoinColumn(name = "seat_id")
    private List<Seat> seats = new ArrayList<>();

    public Hall() {}

}
