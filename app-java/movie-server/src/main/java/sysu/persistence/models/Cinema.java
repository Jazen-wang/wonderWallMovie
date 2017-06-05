package sysu.persistence.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

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
    @JsonInclude
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

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city=" + city +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Cinema)obj).getName()) && this.address.equals(((Cinema)obj).getAddress())
                && this.city.getName().equals(((Cinema)obj).getCity().getName());
    }
}
