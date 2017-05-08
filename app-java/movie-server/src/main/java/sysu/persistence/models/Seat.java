package sysu.persistence.models;

import javax.persistence.*;

/**
 * Created by Shower on 2017/5/6 0006.
 */
@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    private int positionX;
    private int positionY;
    private boolean sold = false;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "hall_id", insertable = false, updatable = false)
    private Hall hall;


    public Seat() {}
    public Seat(int x, int y, Hall hall) {
        this.positionX = x;
        this.positionY = y;
        this.hall = hall;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
