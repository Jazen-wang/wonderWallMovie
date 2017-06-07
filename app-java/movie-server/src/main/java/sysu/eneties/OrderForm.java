package sysu.eneties;

import sysu.persistence.models.Seat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Shower on 2017/6/7 0007.
 */
public class OrderForm {
    private List<Seat> seats;
    private LocalDateTime orderDate;
    private int ticketPrice;

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
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
}
