package sysu.persistence.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shower on 2017/5/6 0006.
 */
@Entity
@Table(name = "user_order")
public class UserOrder {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;
    private int ticketPrice;
    private int ticketCount;
    @OneToMany
    @JoinColumn(name = "seat_id")
    private List<Seat> seats;

    public UserOrder() {}

    public UserOrder(User user, LocalDateTime orderDate,
                     int ticketPrice, int ticketCount,
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

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
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
