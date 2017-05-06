package sysu.persistence.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shower on 2017/5/6 0006.
 */
@Entity
@Table(name = "cinema")
public class Cinema {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    private String name;
    private String address;
    @OneToMany
    @JoinColumn(name = "hall_id")
    private List<Hall> halls = new ArrayList<>();

    public Cinema() {}

}
