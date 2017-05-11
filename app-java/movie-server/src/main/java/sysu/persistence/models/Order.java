package sysu.persistence.models;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shower on 2017/5/6 0006.
 */
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private LocalTime orderDate;
    private double ticketPrice;
    private int ticketCount;
    @OneToMany
    @JoinColumn(name = "seat_id")
    private List<Seat> seats = new ArrayList<>();

    public Order() {}

    public Order(User user, LocalTime orderDate,
                 double ticketPrice, int ticketCount,
                 List<Seat> seats) {
        this.user = user;
        this.orderDate = orderDate;
        this.ticketPrice = ticketPrice;
        this.ticketCount = ticketCount;
        this.seats = seats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalTime orderDate) {
        this.orderDate = orderDate;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

}
