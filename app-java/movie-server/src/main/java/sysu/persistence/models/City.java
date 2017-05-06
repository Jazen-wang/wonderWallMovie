package sysu.persistence.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shower on 2017/5/6 0006.
 */
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    private String name;
    private int code;

    @OneToMany
    @JoinColumn(name = "cinema_id")
    private List<Cinema> cinemas = new ArrayList<>();

    public City() {}

}
