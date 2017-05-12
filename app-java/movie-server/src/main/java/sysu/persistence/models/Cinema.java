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
    private static long gen = 0;

    @Id
    @Column(name = "id")
    private long id = gen++;
    private String name;
    private String address;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "city_id")
    private City city;

    public Cinema() {}

    public Cinema(String name, String address, City city) {
        this.name = name;
        this.address = address;
        this.city = city;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
