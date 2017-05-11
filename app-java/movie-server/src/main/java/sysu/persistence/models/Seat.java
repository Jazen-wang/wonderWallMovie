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
    @ManyToOne
    @JoinColumn(name = "screening_id", insertable = false, updatable = false)
    private Screening screening;


    public Seat() {}
    public Seat(int x, int y, Screening screening) {
        this.positionX = x;
        this.positionY = y;
        this.screening = screening;
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

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }
}
