package sysu.persistence.models;

import javax.persistence.*;

/**
 * Created by Shower on 2017/5/6 0006.
 */
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    private String name;

    public Movie() {}

    public Movie(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
