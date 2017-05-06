package sysu.persistence.models;

import java.time.LocalTime;

/**
 * Created by Shower on 2017/5/6 0006.
 */
public class Order {
    private long id;
    private long userId;
    private LocalTime orderDate;
    private long timingId;
    private LocalTime watchingDate;
    private long seatId;
    private double payment;

    public Order() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalTime orderDate) {
        this.orderDate = orderDate;
    }

    public long getTimingId() {
        return timingId;
    }

    public void setTimingId(long timingId) {
        this.timingId = timingId;
    }

    public LocalTime getWatchingDate() {
        return watchingDate;
    }

    public void setWatchingDate(LocalTime watchingDate) {
        this.watchingDate = watchingDate;
    }

    public long getSeatId() {
        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderDate=" + orderDate +
                ", timingId=" + timingId +
                ", watchingDate=" + watchingDate +
                ", seatId=" + seatId +
                ", payment=" + payment +
                '}';
    }
}
