package sysu.persistence.models;

import javax.persistence.*;

/**
 * Created by Shower on 2017/4/20 0020.
 */
@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    private int min;
    private int max;
    private double average;
    private double stars;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "min=" + min +
                ", max=" + max +
                ", average=" + average +
                ", stars=" + stars +
                '}';
    }
}
