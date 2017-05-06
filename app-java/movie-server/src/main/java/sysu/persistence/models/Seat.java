package sysu.persistence.models;

/**
 * Created by Shower on 2017/5/6 0006.
 */
public class Seat {
    private long id;
    private int positionX;
    private int positionY;
    private boolean sold = false;
    private long hallId;

    public Seat() {}
    public Seat(int x, int y) {
        this.positionX = x;
        this.positionY = y;
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

    public long getHallId() {
        return hallId;
    }

    public void setHallId(long hallId) {
        this.hallId = hallId;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                ", sold=" + sold +
                ", hallId=" + hallId +
                '}';
    }
}
