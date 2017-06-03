package sysu.persistence.models;

import javax.persistence.*;

/**
 * Created by Shower on 2017/5/6 0006.
 */
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @Column(name = "id")
    private long id;
    private String title;

    public Movie() {}

    public Movie(String name) {
        this.title = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
